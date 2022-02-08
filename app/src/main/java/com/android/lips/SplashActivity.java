package com.android.lips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.lips.databinding.ActivitySplashBinding;
import com.android.lips.utilities.Constant;
import com.android.lips.utilities.PreferenceManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;
    FirebaseAuth auth;


    @Override
    protected void onStart() {
        PreferenceManager preferenceManager=new PreferenceManager(this);
        if(preferenceManager.getString(Constant.KEY_USER_ID)!=null){
            Log.d("user id  is ", "onStart: "+preferenceManager.getString(Constant.KEY_USER_ID));
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                binding.luckyLogo.startAnimation(slideUp);
                newActivity(binding.loginForm);
            }
        }, 0);

        binding.loginBtn.setOnClickListener(v -> {
            if (isValidSignInDetails()) {
                signIn(binding.emailField.getText().toString(), binding.passwordField.getText().toString());
            }

        });

        binding.registerBtn.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, RegisterActivity.class));


        });
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        },3000);
    }

    private void signIn(String email, String password) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                showToast("Login Success Full");
                PreferenceManager preferenceManager = new PreferenceManager(SplashActivity.this);
                preferenceManager.putString(Constant.KEY_EMAIL, Objects.requireNonNull(Objects.requireNonNull(authResult.getUser()).getEmail()));
                preferenceManager.putString(Constant.KEY_USER_ID, authResult.getUser().getUid());
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finishAffinity();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast("Login Failed " + e.getMessage());
            }
        });
    }

    void newActivity(ConstraintLayout layout) {


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                layout.setVisibility(View.VISIBLE);
            }
        }, 3000);

//            @Override
//            public void run() {
//
//
//            }
//        },5000);

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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