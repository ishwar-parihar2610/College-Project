package com.android.lips.studentFragment.gallery;

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

import com.android.lips.AllImageActivity;
import com.android.lips.R;
import com.android.lips.adapter.ImageAdapter;
import com.android.lips.databinding.FragmentGalleryBinding;
import com.android.lips.utilities.Constant;
import com.android.model.ImageModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class GalleryFragment extends Fragment {
    FragmentGalleryBinding binding;
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    CollectionReference admin = database.collection(Constant.KEY_COLLECTION_ADMIN);
    ArrayList<ImageModel> imageModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false);
        imageModelArrayList = new ArrayList<>();
        readData();
        return binding.getRoot();
    }

    void readData() {
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
                        imageModel.setDate(queryDocumentSnapshot.getString(Constant.KEY_DATE));
                        imageModelArrayList.add(imageModel);
                    }
                }
                Log.d("Activity", "onComplete: profile image" + imageModelArrayList.get(0).getImage());
                //    Log.d("Activity", "onComplete: profile image"+ facultyModelArrayList.get(0).getProfileImage());
                if (imageModelArrayList.size() > 0) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.imageRecycleView.setVisibility(View.VISIBLE);

                    ImageAdapter adapter = new ImageAdapter(imageModelArrayList, getContext());
                    binding.imageRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter.notifyDataSetChanged();
                    binding.imageRecycleView.setAdapter(adapter);
                }

            }
        });
    }
}