package com.android.lips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.android.lips.databinding.ActivityUploadImageBinding;

public class ActivityUploadImage extends AppCompatActivity {
    ActivityUploadImageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_upload_image);
    }
}