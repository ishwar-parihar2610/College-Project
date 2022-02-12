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
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.android.lips.databinding.ActivityRegisterBinding;
import com.android.lips.utilities.Constant;
import com.android.lips.utilities.PreferenceManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    FirebaseFirestore database;
    FirebaseAuth _auth;
    int requestCodeValue = 1;
    boolean isRegister = false;
    Bitmap bitmap;
    String encodeImage;
    ProgressDialog progressDialog;
    StorageReference storageReference;
    Uri imageUrl;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseFirestore.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        storageReference = FirebaseStorage.getInstance("gs://mycollegeapp-a3012.appspot.com/").getReference();
        _auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        binding.layoutImage.setOnClickListener(v -> {
            Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickImage, requestCodeValue);
        });
        binding.registerBtn.setOnClickListener(v -> {
            if (isValidSignUpDetails()) {
                createAccount(binding.emailField.getText().toString(), binding.passwordField.getText().toString(), binding.nameField.getText().toString());

            }

        });
    }

    private void createAccount(String email, String password, String name) {
        _auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    PreferenceManager preferenceManager = new PreferenceManager(RegisterActivity.this);
                    preferenceManager.putString(Constant.KEY_EMAIL, Objects.requireNonNull(_auth.getCurrentUser()).getEmail());
                    preferenceManager.putString(Constant.KEY_USER_ID, _auth.getUid());

                    FirebaseUser user = _auth.getCurrentUser();
                    uploadImage(email, password, name,binding.departmentField.getText().toString(),binding.subjectField.getText().toString());


                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("failed  " + e.getMessage());
            }
        });
    }

    private void storeToFirestore(String email, String password, String name, String imgUrl,String subject,String department) {

        progressDialog.setTitle("Please Wait....");
        progressDialog.setMessage("Registration");
        progressDialog.show();

        HashMap<String, String> registerValue = new HashMap<>();
        registerValue.put(Constant.KEY_EMAIL, email);
        registerValue.put(Constant.KEY_PASSWORD, password);
        registerValue.put(Constant.KEY_NAME, "Name :"+ name);
        registerValue.put(Constant.KEY_PROFILE_IMAGE, imgUrl);
        registerValue.put(Constant.KEY_DEPARTMENT,"Department :"+ department);
        registerValue.put(Constant.KEY_SUBJECT, "Subject :"+ subject);


        database.collection(Constant.KEY_COLLECTION_ADMIN).document(Constant.KEY_DOCUMENT_USER).collection("userInfo").document(binding.nameField.getText().toString()).set(registerValue).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                // showToast("Register Success full");
                progressDialog.dismiss();
                showToast("Register Success full");
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                finishAffinity();
                //finishAffinity();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                showToast("Register Failed " + e.getMessage());
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private Boolean isValidSignUpDetails() {
        if (binding.nameField.getText().toString().trim().isEmpty()) {
            showToast("Enter Name");
            return false;
        } else if (binding.emailField.getText().toString().trim().isEmpty()) {
            showToast("Enter Email");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailField.getText().toString()).matches()) {
            showToast("Enter Valid Email");
            return false;
        } else if (binding.passwordField.getText().toString().trim().isEmpty()) {
            showToast("Enter Password");
            return false;
        } else if (binding.confirmPasswordField.getText().toString().trim().isEmpty()) {
            showToast("Confirm Your Password");
        } else if (!binding.passwordField.getText().toString().equals(binding.confirmPasswordField.getText().toString())) {
            showToast("Password & Confirm Password must be same");
            return false;
        } else if(binding.passwordField.getText().toString().length()<6){
            showToast("Password Must be Greater than 6");
        } else if(binding.departmentField.getText().toString().isEmpty()){
            showToast("Enter Department ");
        }
        else if(binding.subjectField.getText().toString().isEmpty()){
            showToast("Enter Subject ");
        }else {
            return true;
        }
        return true;

    }

    private void uploadImage(String email, String password, String name,String department,String subject) {

        StorageReference reference = storageReference.child("userImage/" + imageUrl + "-" + System.currentTimeMillis() + ".pdf");

        UploadTask urlTask = reference.putFile(imageUrl);
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
                        storeToFirestore(email, password, name, String.valueOf(downloadUrl),subject,department);
                    }
                }
            }
        });


//    private String encodedImage(Bitmap bitmap){
//        int previewWidth=150;
//        int previewHeight=bitmap.getHeight()+previewWidth/bitmap.getWidth();
//        Bitmap previewBitmap=Bitmap.createScaledBitmap(bitmap,previewWidth,previewHeight,false);
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        previewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
//        byte[] bytes=byteArrayOutputStream.toByteArray();
//        return Base64.encodeToString(bytes,Base64.DEFAULT);
//
//    }
    }

//    private void uploadImage(String uploadImg) {
//        HashMap<String, String> registerValue = new HashMap<>();
//        registerValue.put(Constant.KEY_PROFILE_IMAGE, uploadImg);
//        database.collection(Constant.KEY_COLLECTION_ADMIN).document(Constant.KEY_DOCUMENT_USER).collection("userInfo").document(binding.nameField.getText().toString()).set(registerValue).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void unused) {
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                progressDialog.dismiss();
//                showToast("Register Failed " + e.getMessage());
//            }
//        });
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == requestCodeValue && resultCode == RESULT_OK) {
            assert data != null;
            imageUrl = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUrl);


            } catch (IOException e) {


                e.printStackTrace();
            }
            if (bitmap != null) {
//                encodeImage=encodedImage(bitmap);
                binding.addImageTv.setVisibility(View.GONE);
                binding.profileImage.setImageBitmap(bitmap);
            } else {
                showToast("Error");
            }


        }
    }


}
