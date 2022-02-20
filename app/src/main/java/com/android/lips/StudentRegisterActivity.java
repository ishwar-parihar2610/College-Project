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
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.android.lips.databinding.ActivityStudentRegisterBinding;
import com.android.lips.utilities.Constant;
import com.android.lips.utilities.PreferenceManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class StudentRegisterActivity extends AppCompatActivity {
    ActivityStudentRegisterBinding binding;
    int requestCodeValue = 1;
    Bitmap bitmap;
    Uri imageUrl;
    FirebaseDatabase firebaseDatabase;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    FirebaseFirestore fireStore;
    PreferenceManager preferenceManager;
    String imgUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_register);
        firebaseDatabase = FirebaseDatabase.getInstance();
        fireStore = FirebaseFirestore.getInstance();
        preferenceManager = new PreferenceManager(StudentRegisterActivity.this);
        storageReference = FirebaseStorage.getInstance("gs://mycollegeapp-a3012.appspot.com/").getReference();
        binding.layoutImage.setOnClickListener(v -> {
            Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickImage, requestCodeValue);
        });
        binding.registerBtn.setOnClickListener(v -> {
            if (isValidSignUpDetails()) {
                uploadImage();

            }
        });

    }

    private void signUp() {

        HashMap<String, Object> user = new HashMap<>();
        user.put(Constant.STUDENT_NAME, binding.nameField.getText().toString());
        user.put(Constant.STUDENT_EMAIL, binding.emailField.getText().toString());
        user.put(Constant.STUDENT_PASSWORD, binding.passwordField.getText().toString());
        user.put(Constant.STUDENT_FATHER_NAME, binding.fatherName.getText().toString());
        user.put(Constant.STUDENT_CLASS, binding.classField.getText().toString());
        user.put(Constant.STUDENT_PROFILE_IMAGE, imgUrl);

        fireStore.collection(Constant.KEY_STUDENT_COLLECTION).add(user).addOnSuccessListener(DocumentReference -> {
            loading(false);
            preferenceManager.putBoolean(Constant.KEY_IS_SIGNED_IN, true);
            preferenceManager.putString(Constant.STUDENT_ID, DocumentReference.getId());
            preferenceManager.putString(Constant.STUDENT_NAME, binding.nameField.getText().toString());
            preferenceManager.putString(Constant.STUDENT_PROFILE_IMAGE, imgUrl);
            Intent intent = new Intent(getApplicationContext(), StudentMainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }).addOnFailureListener(exception -> {
            loading(false);
            showToast(exception.getMessage());
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
        } else if (binding.passwordField.getText().toString().length() < 6) {
            showToast("Password Must be Greater than 6");
        } else if (binding.classField.getText().toString().isEmpty()) {
            showToast("Enter Your Class ");
        } else if (binding.fatherName.getText().toString().isEmpty()) {
            showToast("Enter Father name ");
        } else {
            return true;
        }
        return true;

    }

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

    private void uploadImage() {
        loading(true);
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
                        imgUrl = String.valueOf(downloadUrl);
                        checkAccount();
                    }
                }
            }
        });

    }

    private void loading(Boolean isLoading) {
        if (isLoading) {
            binding.registerBtn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.registerBtn.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.INVISIBLE);
        }
    }

    void checkAccount() {

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constant.KEY_STUDENT_COLLECTION)
                .whereEqualTo(Constant.STUDENT_EMAIL, binding.emailField.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0) {
                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
                        showToast("Already Have A Account");

                    } else {
                        signUp();
                    }
                });
    }
}