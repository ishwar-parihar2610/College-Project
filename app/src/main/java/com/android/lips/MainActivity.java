package com.android.lips;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.lips.databinding.ActivityMainBinding;
import com.android.lips.utilities.Constant;
import com.android.lips.utilities.PreferenceManager;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PreferenceManager preferenceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        preferenceManager=new PreferenceManager(this);

        if(preferenceManager.getString(Constant.KEY_PROFILE_IMAGE)!=null){
            Log.d("Value", "Image is : "+preferenceManager.getString(Constant.KEY_PROFILE_IMAGE));
            Glide.with(this).load(preferenceManager.getString(Constant.KEY_PROFILE_IMAGE)).into(binding.profileImage);
        }
        binding.uploadNoticeCard.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,AllNoticeActivity.class));
        });
        binding.uploadImageCard.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,AllImageActivity.class));
        });

        binding.logoutCard.setOnClickListener(v->{

            preferenceManager.Clear();
            startActivity(new Intent(MainActivity.this,SplashActivity.class));
        });
        binding.uploadEBookCard.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,ActivityEbook.class));
        });
        binding.uploadFacilityCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActivityGroup.class));
            }
        });
        binding.developerContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,developerContect.class));
            }
        });
    }


}