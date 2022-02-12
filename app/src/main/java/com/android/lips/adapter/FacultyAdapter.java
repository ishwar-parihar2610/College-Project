package com.android.lips.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android.lips.R;
import com.android.lips.databinding.ItemLayoutBinding;
import com.android.model.FacultyModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.viewHolder> {
    ArrayList<FacultyModel> facultyModels;
    LayoutInflater inflater;
    Context context;

    public FacultyAdapter(ArrayList<FacultyModel> facultyModels, Context context) {
        this.facultyModels = facultyModels;
        this.context = context;
    }

    @NonNull
    @Override
    public FacultyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return new viewHolder(DataBindingUtil.inflate(inflater, R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyAdapter.viewHolder holder, int position) {
        FacultyModel facultyModel = facultyModels.get(position);
   //    Toast.makeText(context, "name is :"+facultyModel.getDepartment(), Toast.LENGTH_SHORT).show();
        holder.binding.userName.setText(facultyModel.getUserName());
        holder.binding.department.setText(facultyModel.getDepartment());
        holder.binding.subject.setText(facultyModel.getSubject());
        Glide.with(context).load(facultyModel.getProfileImage()).into(holder.binding.profileImageShape);
    }

    @Override
    public int getItemCount() {
        return facultyModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ItemLayoutBinding binding;

        public viewHolder(ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
