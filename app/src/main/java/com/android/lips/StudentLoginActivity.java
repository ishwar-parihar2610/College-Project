package com.android.lips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.android.lips.databinding.ActivityStudentLoginBinding;
import com.android.lips.databinding.ActivityStudentMainBinding;
import com.android.lips.utilities.Constant;
import com.android.lips.utilities.PreferenceManager;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class StudentLoginActivity extends AppCompatActivity {
    ActivityStudentLoginBinding binding;
    PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_student_login);
        preferenceManager = new PreferenceManager(getApplicationContext());
       binding.loginBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(StudentLoginActivity.this,StudentMainActivity.class));
           }
       });
       binding.registerBtn.setOnClickListener(v->{
           startActivity(new Intent(StudentLoginActivity.this,StudentRegisterActivity.class));
       });
       binding.loginBtn.setOnClickListener(v->{
          if(isValidSignInDetails()){
              signIn();
          }
       });
    }

    private void signIn() {
        loading(true);

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constant.KEY_STUDENT_COLLECTION)
                .whereEqualTo(Constant.STUDENT_EMAIL, binding.emailField.getText().toString())
                .whereEqualTo(Constant.STUDENT_PASSWORD, binding.passwordField.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult()!=null && task.getResult().getDocuments().size()>0){
                        DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                        preferenceManager.putBoolean(Constant.KEY_IS_SIGNED_IN,true);
                        preferenceManager.putString(Constant.STUDENT_ID,documentSnapshot.getId());
                        preferenceManager.putString(Constant.STUDENT_NAME,documentSnapshot.getString(Constant.STUDENT_NAME));
                        preferenceManager.putString(Constant.STUDENT_EMAIL,documentSnapshot.getString(Constant.STUDENT_EMAIL));
                        preferenceManager.putString(Constant.STUDENT_PROFILE_IMAGE,documentSnapshot.getString(Constant.STUDENT_PROFILE_IMAGE));
                        Intent intent=new Intent(getApplicationContext(),StudentMainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else{
                        loading(false);
                        showToast("Unable To Sign In");
                    }
                });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void loading(Boolean isLoading) {
        if (isLoading) {
            binding.loginBtn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.loginBtn.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private Boolean isValidSignInDetails() {
        if (binding.emailField.getText().toString().trim().isEmpty()) {
            showToast("Enter Email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.emailField.getText().toString()).matches()) {
            showToast("Enter valid Email");
            return false;
        } else if (binding.passwordField.getText().toString().trim().isEmpty()) {
            showToast("Enter Password");
            return false;
        } else {
            return true;
        }
    }
}