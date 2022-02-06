package com.android.lips;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.android.lips.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.uploadNoticeCard.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,ActivityUploadNotice.class));
        });
        binding.uploadImageCard.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,ActivityUploadImage.class));
        });
    }


}