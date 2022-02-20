package com.android.lips.studentFragment.notice;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lips.AllNoticeActivity;
import com.android.lips.R;
import com.android.lips.adapter.NoticeAdapter;
import com.android.lips.databinding.FragmentNoticeBinding;
import com.android.lips.utilities.Constant;
import com.android.model.NoticeModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class NoticeFragment extends Fragment {
    FragmentNoticeBinding binding;
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    CollectionReference admin = database.collection(Constant.KEY_COLLECTION_ADMIN);
    ArrayList<NoticeModel> noticeModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notice, container, false);
        noticeModelArrayList = new ArrayList<>();
        readData();
        return binding.getRoot();
    }

    void readData() {
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
                if (noticeModelArrayList.size() > 0) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.noticeRecycleView.setVisibility(View.VISIBLE);

                    NoticeAdapter adapter = new NoticeAdapter(noticeModelArrayList, getContext());
                    binding.noticeRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter.notifyDataSetChanged();
                    binding.noticeRecycleView.setAdapter(adapter);
                } else {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.noticeRecycleView.setVisibility(View.GONE);
                    binding.noData.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}