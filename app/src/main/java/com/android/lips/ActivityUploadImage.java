package com.android.lips;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;

import com.android.lips.databinding.ActivityUploadImageBinding;
import com.android.lips.utilities.Constant;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Objects;

public class ActivityUploadImage extends AppCompatActivity {
    ActivityUploadImageBinding binding;
    FirebaseFirestore dataBase;
    Bitmap bitmap;
    int requestValueCode=1;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    ProgressDialog progressDialog;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBase=FirebaseFirestore.getInstance();
        progressDialog=new ProgressDialog(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        storageReference = FirebaseStorage.getInstance("gs://mycollegeapp-a3012.appspot.com/").getReference();
        binding= DataBindingUtil.setContentView(this,R.layout.activity_upload_image);
        binding.uploadImageCard.setOnClickListener(v->{
            openGallery();
        });

        binding.uploadBtn.setOnClickListener(v->{
            if(binding.noticeTitleField.getText().toString().isEmpty()){
                binding.noticeTitleField.setError("Empty");
                binding.noticeTitleField.requestFocus();
            }else{
                uploadImageToDataBase(binding.noticeTitleField.getText().toString());
            }
        });
    }

    private void openGallery() {
        Intent pickImage=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,requestValueCode);
    }

    void uploadToFireStore(String occasionTitle,String imageUrl){
        HashMap<String, String> noticeData = new HashMap();
        noticeData.put(Constant.KEY_OCCASION_TITLE, occasionTitle);
        noticeData.put(Constant.KEY_NOTICE_IMAGE,imageUrl);
        dataBase.collection(Constant.KEY_COLLECTION_ADMIN).document(Constant.KEY_DOCUMENT_GALLERY).collection("images").document().set(noticeData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                progressDialog.dismiss();
                showToast("Successfully Notice Added");
                startActivity(new Intent(ActivityUploadImage.this,MainActivity.class));

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                showToast("Failed : " + e.getMessage());
            }
        });
    }

//    private String encodedImage(Bitmap bitmap) {
//        int previewWidth=150;
//        int previewHeight=bitmap.getHeight()+previewWidth/bitmap.getWidth();
//        Bitmap previewBitmap=Bitmap.createScaledBitmap(bitmap,previewWidth,previewHeight,false);
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        previewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
//        byte[] bytes=byteArrayOutputStream.toByteArray();
//        return Base64.encodeToString(bytes,Base64.DEFAULT);
//    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==requestValueCode && resultCode==RESULT_OK){
            imageUri=data.getData();
            try {
                bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
            } catch (Exception e) {
                binding.uploadImageCard.setVisibility(View.GONE);
                binding.uploadImg.setVisibility(View.VISIBLE);
                e.printStackTrace();

            }
            if(bitmap!=null){
                binding.uploadImg.setImageBitmap(bitmap);
            }else{
                binding.uploadImg.setVisibility(View.GONE);
                binding.uploadImageCard.setVisibility(View.VISIBLE);
            }
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void uploadImageToDataBase(String imageTitle) {
        progressDialog.setTitle("Please Wait....");
        progressDialog.setMessage("Uploading Image To Gallery");
        progressDialog.show();
        StorageReference reference = storageReference.child("gallery/" + imageTitle + "-" + System.currentTimeMillis() + ".image");

        UploadTask urlTask = reference.putFile(imageUri);
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
                        uploadToFireStore(imageTitle, String.valueOf(downloadUrl));
                    }
                }
            }
        });
    }
}