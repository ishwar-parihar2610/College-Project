package com.android.lips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.lips.databinding.ActivityUploadPdfBinding;
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

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

public class UploadPdfActivity extends AppCompatActivity {
    ActivityUploadPdfBinding binding;
    int requestCodeValue = 1;
    Bitmap bitmap;
    ProgressDialog progressDialog;
    Uri pdfData;
    String pdfName;
    String title;
    FirebaseFirestore firebaseFirestore;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    File selectedFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        storageReference = FirebaseStorage.getInstance("gs://mycollegeapp-a3012.appspot.com/").getReference();
        progressDialog = new ProgressDialog(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_upload_pdf);
        binding.uploadEBookCard.setOnClickListener(v -> {
            openGallery();
        });
        binding.uploadBtn.setOnClickListener(v -> {
            if (binding.pdfTitle.getText().toString().isEmpty()) {
                binding.pdfTitle.setError("Empty");
                binding.pdfTitle.requestFocus();
            } else if (pdfData == null) {
                showToast("Please Upload Pdf");
            } else {
                title=binding.pdfTitle.getText().toString();
                uploadPdf();
            }
        });
    }

    private void uploadPdf() {
        progressDialog.setTitle("Please Wait....");
        progressDialog.setMessage("Uploading Pdf");
        progressDialog.show();
        StorageReference reference = storageReference.child("pdf/" + pdfName + "-" + System.currentTimeMillis() + ".pdf");

        UploadTask urlTask = reference.putFile(pdfData);
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
                if(task.isSuccessful()){

                    Uri downloadUrl=task.getResult();
                    if(downloadUrl!=null){
                        uploadData(String.valueOf(downloadUrl));
                    }
                }
            }
        });


//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        Task<Uri> uriTask=taskSnapshot.getStorage().getDownloadUrl();
//                        do{
//
//                            Uri uri=uriTask.getResult();
//                            uploadData(String.valueOf(uri));
//                        }
//                        while (!uriTask.isComplete());
//
//
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                showToast("Something went Wrong");
//                progressDialog.dismiss();
//            }
//        });

    }

    private void uploadData(String pdfUri) {

      //  String uniqueKey = databaseReference.child("pdf").push().getKey();
        HashMap data = new HashMap();
        data.put(Constant.KEY_BOOK_TITLE, title);
        data.put("pdfUrl", pdfUri);
        firebaseFirestore.collection(Constant.KEY_COLLECTION_ADMIN)
                .document(Constant.KEY_E_BOOK_DOCUMENT)
                .collection(Constant.KEY_BOOK_PDF_COLLECTION)
                .document()
                .set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                binding.pdfTitle.setText("");
                binding.pdfText.setText("");
                showToast("upload Successfully");
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("failed" + e.getLocalizedMessage());
                binding.pdfTitle.setText("");
                binding.pdfText.setText("");
                progressDialog.dismiss();
            }
        });


//        databaseReference.child("pdf").child(uniqueKey).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    progressDialog.dismiss();
//                    showToast("Pdf Uploaded Successfully");
//                    binding.pdfTitle.setText("");
//
//                }
//
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                progressDialog.dismiss();
//                showToast("Failed To upload Pdf");
//            }
//        });
//    }Pdf
    }

    private void openGallery() {
        Intent pickPdf = new Intent();
        pickPdf.setType("application/pdf");
        pickPdf.setAction(Intent.ACTION_GET_CONTENT);


        startActivityForResult(Intent.createChooser(pickPdf, "Select Pdf File"), requestCodeValue);
    }

    @SuppressLint("Range")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCodeValue && resultCode == RESULT_OK) {
            pdfData = data.getData();
            if (pdfData.toString().startsWith("content://")) {
                Cursor cursor = null;
                try {


                    cursor = UploadPdfActivity.this.getContentResolver().query(pdfData, null, null, null, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        pdfName = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (pdfData.toString().startsWith("file://")) {

                pdfName = new File(pdfData.toString()).getName();
                selectedFile = new File(String.valueOf(pdfData));
            }
            binding.pdfText.setText(pdfName);
            showToast(" " + pdfData);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}