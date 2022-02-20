package com.android.lips.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android.lips.R;
import com.android.lips.databinding.ItemLayoutBinding;
import com.android.model.FacultyModel;
import com.android.model.studentModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.viewHolder> {
    ArrayList<studentModel> studentModels;
    LayoutInflater inflater;
    Context context;

    public StudentListAdapter(ArrayList<studentModel> studentModels, Context context) {
        this.studentModels = studentModels;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return new StudentListAdapter.viewHolder(DataBindingUtil.inflate(inflater, R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        studentModel student = studentModels.get(position);
        //    Toast.makeText(context, "name is :"+facultyModel.getDepartment(), Toast.LENGTH_SHORT).show();
        holder.binding.userName.setText("Name : " + student.name);
        holder.binding.department.setText("Father name : " + student.fatherName);
        holder.binding.subject.setText("Class : " + student.studentClass);
        Glide.with(context).load(student.getProfileImage()).into(holder.binding.profileImageShape);
    }


    @Override
    public int getItemCount() {
        return studentModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ItemLayoutBinding binding;

        public viewHolder(ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}


