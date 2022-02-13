package com.android.lips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.lips.databinding.ActivityPdfViewBinding;
import com.squareup.okhttp.HttpUrl;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfViewActivity extends AppCompatActivity {
    ActivityPdfViewBinding binding;
    String url;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pdf_view);
        Log.d("webvwiew tag", "onCreate: " + getIntent().getStringExtra("pdfUrl"));
        if (getIntent().getStringExtra("pdfUrl") != null) {
            url = getIntent().getStringExtra("pdfUrl");
            new pdfViewer().execute(url);

        }
        


    }


    private class pdfViewer extends AsyncTask<String,Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
          InputStream inputStream=null;
          try {
            URL url =new URL(strings[0]);
              HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();
              if(urlConnection.getResponseCode()==200){
                  inputStream=new BufferedInputStream(urlConnection.getInputStream());
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
          return  inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            binding.pdfViewer.fromStream(inputStream).load();
        }
    }
}
