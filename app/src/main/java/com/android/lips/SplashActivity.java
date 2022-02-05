package com.android.lips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.lips.databinding.ActivitySplashBinding;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;

public class SplashActivity extends AppCompatActivity {
    ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_splash);
        Handler handle=new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation slideUp= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
                binding.luckyLogo.startAnimation(slideUp);
                newActivity(binding.loginForm);
            }
        }, 0);

        binding.loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        });

        binding.registerBtn.setOnClickListener(v->{
            startActivity(new Intent(SplashActivity.this,RegisterActivity.class));
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

void newActivity(ConstraintLayout layout){
      Handler handler=new Handler();
      handler.postDelayed(new Runnable() {
          @Override
          public void run() {
              layout.setVisibility(View.VISIBLE);
          }
      },3000);

//            @Override
//            public void run() {
//
//
//            }
//        },5000);

    }
}