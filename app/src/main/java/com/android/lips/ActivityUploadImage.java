package com.android.lips;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public class ActivityUploadImage extends AppCompatActivity {
    ActivityUploadImageBinding binding;
    FirebaseFirestore dataBase;
    Bitmap bitmap;
    int requestValueCode=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBase=FirebaseFirestore.getInstance();
        binding= DataBindingUtil.setContentView(this,R.layout.activity_upload_image);
        binding.uploadImageCard.setOnClickListener(v->{
            openGallery();
        });

        binding.uploadBtn.setOnClickListener(v->{
            if(binding.noticeTitleField.getText().toString().isEmpty()){
                binding.noticeTitleField.setError("Empty");
                binding.noticeTitleField.requestFocus();
            }else{
                uploadImageToFireStore(binding.noticeTitleField.getText().toString());
            }
        });
    }

    private void openGallery() {
        Intent pickImage=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,requestValueCode);
    }

    void uploadImageToFireStore(String occasionTitle){
        HashMap<String, String> noticeData = new HashMap();
        noticeData.put(Constant.KEY_OCCASION_TITLE, occasionTitle);
        noticeData.put(Constant.KEY_NOTICE_IMAGE,encodedImage(bitmap));
        dataBase.collection(Constant.KEY_COLLECTION_ADMIN).document(Constant.KEY_DOCUMENT_GALLERY).collection("images").document().set(noticeData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                showToast("Successfully Notice Added");
                startActivity(new Intent(ActivityUploadImage.this,MainActivity.class));

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("Failed : " + e.getMessage());
            }
        });
    }

    private String encodedImage(Bitmap bitmap) {
        int previewWidth=150;
        int previewHeight=bitmap.getHeight()+previewWidth/bitmap.getWidth();
        Bitmap previewBitmap=Bitmap.createScaledBitmap(bitmap,previewWidth,previewHeight,false);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
        byte[] bytes=byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes,Base64.DEFAULT);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==requestValueCode && resultCode==RESULT_OK){
            Uri uri=data.getData();
            try {
                bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
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
}