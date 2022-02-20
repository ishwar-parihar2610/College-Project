package com.android.lips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.lips.adapter.ImageAdapter;
import com.android.lips.adapter.PdfAdapter;
import com.android.lips.databinding.ActivityEbookBinding;
import com.android.lips.utilities.Constant;
import com.android.lips.utilities.PreferenceManager;
import com.android.model.EBookModel;
import com.android.model.ImageModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ActivityEbook extends AppCompatActivity {
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    CollectionReference admin = database.collection(Constant.KEY_COLLECTION_ADMIN);
    ActivityEbookBinding binding;
    ArrayList<EBookModel> eBookModelArrayList;
    PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ebook);
        preferenceManager=new PreferenceManager(this);
        eBookModelArrayList = new ArrayList<>();
        binding.addPdfBtn.setOnClickListener(v -> {
            startActivity(new Intent(ActivityEbook.this, UploadPdfActivity.class));
        });
        binding.back.setOnClickListener(v->{
            finish();
        });
        if(preferenceManager.getString(Constant.KEY_EMAIL)!=null){
            binding.addPdfBtn.setVisibility(View.VISIBLE);
        }else{
            binding.addPdfBtn.setVisibility(View.GONE);
        }
        readData();

    }

    void readData() {
        Log.d("calling", "function calling");
        binding.progressBar.setVisibility(View.VISIBLE);
        admin.document(Constant.KEY_E_BOOK_DOCUMENT).collection("book_pdf").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
                    if (task.isSuccessful() && task.getResult() != null) {
                        EBookModel eBookModel = new EBookModel();
                        eBookModel.seteBookTitle(queryDocumentSnapshot.getString("bookTitle"));
                        eBookModel.seteBookPdf(queryDocumentSnapshot.getString("pdfUrl"));

                        eBookModelArrayList.add(eBookModel);
                    }
                }
                 Log.d("Activity", "onComplete: profile image"+ eBookModelArrayList.get(0).geteBookPdf());
                //    Log.d("Activity", "onComplete: profile image"+ facultyModelArrayList.get(0).getProfileImage());
                if (eBookModelArrayList.size() > 0) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.pdfRecycleView.setVisibility(View.VISIBLE);

                    PdfAdapter adapter = new PdfAdapter(eBookModelArrayList, ActivityEbook.this);
                    binding.pdfRecycleView.setLayoutManager(new LinearLayoutManager(ActivityEbook.this));
                    adapter.notifyDataSetChanged();
                    binding.pdfRecycleView.setAdapter(adapter);
                }

            }
        });
    }
}
