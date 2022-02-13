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

import com.android.lips.R;
import com.android.lips.adapter.ImageAdapter;
import com.android.lips.adapter.NoticeAdapter;
import com.android.lips.databinding.ActivityAllImageBinding;
import com.android.lips.databinding.AllNoticeItemBinding;
import com.android.lips.utilities.Constant;
import com.android.model.ImageModel;
import com.android.model.NoticeModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AllImageActivity extends AppCompatActivity {
    ActivityAllImageBinding binding;
    FirebaseFirestore database=FirebaseFirestore.getInstance();
    CollectionReference admin=database.collection(Constant.KEY_COLLECTION_ADMIN);
    ArrayList<ImageModel> imageModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageModelArrayList=new ArrayList<>();

       binding= DataBindingUtil.setContentView(this, R.layout.activity_all_image);
        readData();
       binding.addBtn.setOnClickListener(v->{
           startActivity(new Intent(AllImageActivity.this,ActivityUploadImage.class));
       });
    }

    void readData(){
       binding.progressBar.setVisibility(View.VISIBLE);
        admin.document(Constant.KEY_DOCUMENT_GALLERY).collection("images").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
                    if (task.isSuccessful() && task.getResult() != null) {
                        ImageModel imageModel = new ImageModel();
                        imageModel.setImageTitle(queryDocumentSnapshot.getString("occasion"));
                        imageModel.setImage(queryDocumentSnapshot.getString(Constant.KEY_IMAGE));

                        imageModelArrayList.add(imageModel);
                    }
                }
                Log.d("Activity", "onComplete: profile image"+ imageModelArrayList.get(0).getImage());
                //    Log.d("Activity", "onComplete: profile image"+ facultyModelArrayList.get(0).getProfileImage());
                if(imageModelArrayList.size()>0){
                    binding.progressBar.setVisibility(View.GONE);
                    binding.imageRecycleView.setVisibility(View.VISIBLE);

                    ImageAdapter adapter=new ImageAdapter(imageModelArrayList,getApplicationContext());
                    binding.imageRecycleView.setLayoutManager(new LinearLayoutManager(AllImageActivity.this));
                    adapter.notifyDataSetChanged();
                    binding.imageRecycleView.setAdapter(adapter);
                }

            }
        });
    }

}