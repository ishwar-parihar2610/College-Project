package com.android.lips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.lips.adapter.FacultyAdapter;
import com.android.lips.adapter.NoticeAdapter;
import com.android.lips.databinding.ActivityAllNoticeBinding;
import com.android.lips.utilities.Constant;
import com.android.model.FacultyModel;
import com.android.model.NoticeModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class AllNoticeActivity extends AppCompatActivity {
    ActivityAllNoticeBinding binding;
    FirebaseFirestore database=FirebaseFirestore.getInstance();
    CollectionReference admin=database.collection(Constant.KEY_COLLECTION_ADMIN);
    ArrayList<NoticeModel> noticeModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_all_notice);
        noticeModelArrayList=new ArrayList<>();
        readData();
        binding.addBtn.setOnClickListener(v->{
            startActivity(new Intent(AllNoticeActivity.this,ActivityUploadNotice.class));
        });
    }

  void readData(){
      binding.progressBar.setVisibility(View.VISIBLE);
      admin.document(Constant.KEY_DOCUMENT_NOTICEBOARD).collection("Notice").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
          @SuppressLint("NotifyDataSetChanged")
          @Override
          public void onComplete(@NonNull Task<QuerySnapshot> task) {
              for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
                  if (task.isSuccessful() && task.getResult() != null) {
                      NoticeModel noticeModel = new NoticeModel();
                      noticeModel.setNoticeTitle(queryDocumentSnapshot.getString(Constant.KEY_NOTICE_TITLE));
                      noticeModel.setNoticeImage(queryDocumentSnapshot.getString(Constant.KEY_NOTICE_IMAGE));
                      noticeModelArrayList.add(noticeModel);
                  }
              }
              //    Log.d("Activity", "onComplete: profile image"+ facultyModelArrayList.get(0).getProfileImage());
              if(noticeModelArrayList.size()>0){
                  binding.progressBar.setVisibility(View.GONE);
                  binding.noticeRecycleView.setVisibility(View.VISIBLE);

                  NoticeAdapter adapter=new NoticeAdapter(noticeModelArrayList,getApplicationContext());
                  binding.noticeRecycleView.setLayoutManager(new LinearLayoutManager(AllNoticeActivity.this));
                  adapter.notifyDataSetChanged();
                  binding.noticeRecycleView.setAdapter(adapter);
              }

          }
      });
    }
}