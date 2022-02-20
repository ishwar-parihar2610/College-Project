package com.android.lips;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.android.lips.databinding.ActivityUploadNoticeBinding;
import com.android.lips.utilities.Constant;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class ActivityUploadNotice extends AppCompatActivity {
    ActivityUploadNoticeBinding binding;
    private int requestCodeValue = 1;
    private Bitmap bitmap;
    private FirebaseFirestore dataBase;
    ProgressDialog progressDialog;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    String noticeName;
    Uri imageData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBase = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        storageReference = FirebaseStorage.getInstance("gs://mycollegeapp-a3012.appspot.com/").getReference();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_upload_notice);
        binding.uploadNoticeCard.setOnClickListener(v -> {
            openGallery();
        });

        binding.back.setOnClickListener(v->{
            finish();
        });

        binding.uploadBtn.setOnClickListener(v -> {
            if (binding.noticeTitleField.getText().toString().isEmpty()) {
                binding.noticeTitleField.setError("Empty");
                binding.noticeTitleField.requestFocus();
            } else {
                uploadNoticeImage(binding.noticeTitleField.getText().toString());


            }
        });
    }

    private void openGallery() {
        binding.noticeUploadedImage.setVisibility(View.VISIBLE);
        binding.uploadNoticeCard.setVisibility(View.GONE);
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(pickImage, requestCodeValue);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCodeValue && resultCode == RESULT_OK) {
            assert data != null;
            imageData = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageData);

            } catch (IOException e) {
                binding.noticeUploadedImage.setVisibility(View.GONE);
                binding.uploadNoticeCard.setVisibility(View.VISIBLE);
                e.printStackTrace();
            }
            if (bitmap != null) {
                binding.noticeUploadedImage.setImageBitmap(bitmap);
            } else {
                binding.noticeUploadedImage.setVisibility(View.GONE);
                binding.uploadNoticeCard.setVisibility(View.VISIBLE);
            }


        }
    }

    void storeDataToFireStore(String noticeTitle, String noticeUrl) {

        HashMap<String, String> noticeData = new HashMap();
        noticeData.put(Constant.KEY_NOTICE_TITLE, noticeTitle);
        noticeData.put(Constant.KEY_NOTICE_IMAGE, noticeUrl);
        dataBase.collection(Constant.KEY_COLLECTION_ADMIN).document(Constant.KEY_DOCUMENT_NOTICEBOARD).collection("Notice").document().set(noticeData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                showToast("Successfully Notice Added");
                startActivity(new Intent(ActivityUploadNotice.this, MainActivity.class));
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("Failed : " + e.getMessage());
                progressDialog.dismiss();
            }
        });
    }


//    void storeNoticeImage() {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
//        byte[] finalImg = byteArrayOutputStream.toByteArray();
//        HashMap noticeImageData = new HashMap();
//
//        noticeImageData.put(Constant.KEY_NOTICE_IMAGE, finalImg);
//        dataBase.collection(Constant.KEY_COLLECTION_ADMIN).document(Constant.KEY_DOCUMENT_NOTICEBOARD).collection("Notice").document().set(noticeImageData).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//                showToast("Successfully Notice Added");
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                showToast("Failed : " + e.getMessage());
//            }
//        });
//
//    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private String encodedImage(Bitmap bitmap) {
        int previewWidth = 150;
        int previewHeight = bitmap.getHeight() + previewWidth / bitmap.getWidth();
        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap, previewWidth, previewHeight, false);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);

    }

    private void uploadNoticeImage(String noticeTitle) {
        progressDialog.setTitle("Please Wait....");
        progressDialog.setMessage("Uploading Notice");
        progressDialog.show();
        StorageReference reference = storageReference.child("notice/" + noticeTitle + "-" + System.currentTimeMillis() + ".image");

        UploadTask urlTask = reference.putFile(imageData);
        Task<Uri> task = urlTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    progressDialog.dismiss();
                    throw Objects.requireNonNull(task.getException());
                }
                return reference.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {

                    Uri downloadUrl = task.getResult();
                    if (downloadUrl != null) {
                        storeDataToFireStore(noticeTitle, String.valueOf(downloadUrl));
                    }
                }
            }
        });
    }
}