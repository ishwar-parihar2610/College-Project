package com.android.lips.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.lips.MainActivity;
import com.android.lips.R;
import com.android.lips.adapter.FacultyAdapter;
import com.android.lips.databinding.FragmentFacultyBinding;
import com.android.lips.utilities.Constant;
import com.android.model.FacultyModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class FacultyFragment extends Fragment {
    FragmentFacultyBinding binding;
    FirebaseFirestore database=FirebaseFirestore.getInstance();
    CollectionReference admin=database.collection(Constant.KEY_COLLECTION_ADMIN);
    ArrayList<FacultyModel> facultyModelArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        facultyModelArrayList=new ArrayList<>();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_faculty, container, false);
    //    readData();
        return binding.getRoot();
    }

    private void readData() {
        binding.progressBar.setVisibility(View.VISIBLE);
        admin.document(Constant.KEY_DOCUMENT_USER).collection("userInfo").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
                    if (task.isSuccessful() && task.getResult() != null) {
                        FacultyModel facultyModel = new FacultyModel();
                        facultyModel.setUserName(queryDocumentSnapshot.getString(Constant.KEY_NAME));
                        facultyModel.setDepartment(queryDocumentSnapshot.getString(Constant.KEY_DEPARTMENT));
                        facultyModel.setProfileImage(queryDocumentSnapshot.getString(Constant.KEY_PROFILE_IMAGE));
                        facultyModel.setSubject(queryDocumentSnapshot.getString(Constant.KEY_SUBJECT));
                        facultyModelArrayList.add(facultyModel);
                    }
                }
            //    Log.d("Activity", "onComplete: profile image"+ facultyModelArrayList.get(0).getProfileImage());
                if(facultyModelArrayList.size()>0){
                    binding.progressBar.setVisibility(View.GONE);
                    binding.recycleView.setVisibility(View.VISIBLE);

                    FacultyAdapter adapter=new FacultyAdapter(facultyModelArrayList,getContext());
                    binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter.notifyDataSetChanged();
                    binding.recycleView.setAdapter(adapter);
                }

            }
        });

//        admin.document(Constant.KEY_DOCUMENT_USER).collection("userInfo").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @SuppressLint("NotifyDataSetChanged")
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//            for(QueryDocumentSnapshot queryDocumentSnapshot:queryDocumentSnapshots){
//                FacultyModel  facultyModel=queryDocumentSnapshot.toObject(FacultyModel.class);
//
//                facultyModelArrayList.add(facultyModel);
//
//            }    Toast.makeText(getContext(),"data is "+ facultyModelArrayList.get(0).toString(), Toast.LENGTH_SHORT).show();
//                FacultyAdapter adapter=new FacultyAdapter(facultyModelArrayList,getContext());
//            adapter.notifyDataSetChanged();
//            binding.recycleView.setAdapter(adapter);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//
//            }
//        });
    }

    @Override
    public void onStart() {
        super.onStart();
        readData();
    }
}