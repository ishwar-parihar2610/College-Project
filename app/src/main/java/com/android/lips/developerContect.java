package com.android.lips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.android.lips.databinding.ActivityDeveloperContectBinding;

public class developerContect extends AppCompatActivity {
    ActivityDeveloperContectBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_developer_contect);
        binding.getSourceCode.setOnClickListener(v->{
            Uri uri = Uri.parse("https://github.com/ishwar-parihar2610"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
        binding.back.setOnClickListener(v->{
            finish();
        });

    }
}