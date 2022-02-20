package com.android.lips.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lips.R;
import com.android.lips.adapter.StudentListAdapter;
import com.android.lips.databinding.FragmentStudentBinding;
import com.android.lips.utilities.Constant;
import com.android.model.studentModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;


public class StudentFragment extends Fragment {
    FragmentStudentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_student, container, false);
        getUser();
        return binding.getRoot();


    }

    private void getUser(){
        loading(true);
        FirebaseFirestore dataBase= FirebaseFirestore.getInstance();
        dataBase.collection(Constant.KEY_STUDENT_COLLECTION).get().addOnCompleteListener(task -> {
            loading(false);

            if (task.isSuccessful() && task.getResult() !=null){
                ArrayList<studentModel> users=new ArrayList<>();
                for (QueryDocumentSnapshot queryDocumentSnapshot:task.getResult()){

                    studentModel user=new studentModel();
                    user.name=queryDocumentSnapshot.getString(Constant.STUDENT_NAME);
                    user.email=queryDocumentSnapshot.getString(Constant.STUDENT_EMAIL);
                    user.profileImage=queryDocumentSnapshot.getString(Constant.STUDENT_PROFILE_IMAGE);
                    user.fatherName=queryDocumentSnapshot.getString(Constant.STUDENT_FATHER_NAME);
                    user.studentClass=queryDocumentSnapshot.getString(Constant.STUDENT_CLASS);

                    users.add(user);

                }
                if (users.size()>0){
                    StudentListAdapter usersAdapter=new StudentListAdapter(users,getContext());
                    binding.recycleView.setAdapter(usersAdapter);
                    binding.recycleView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void loading(Boolean isLoading){
        if (isLoading){
            binding.progressBar.setVisibility(View.VISIBLE);
        }else{
            binding.progressBar.setVisibility(View.INVISIBLE);
        }
    }
}