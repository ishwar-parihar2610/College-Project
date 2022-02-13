package com.android.lips.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.android.lips.R;
import com.android.lips.databinding.AllNoticeItemBinding;
import com.android.model.NoticeModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.viewHolder> {
    ArrayList<NoticeModel> noticeModels;
    Context context;
    LayoutInflater inflater;

    public NoticeAdapter(ArrayList<NoticeModel> noticeModels, Context context) {
        this.noticeModels = noticeModels;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticeAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return new viewHolder(DataBindingUtil.inflate(inflater, R.layout.all_notice_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeAdapter.viewHolder holder, int position) {
        NoticeModel noticeModel = noticeModels.get(position);
        holder.binding.noticeTitle.setText(noticeModel.getNoticeTitle());
        Glide.with(context).load(noticeModel.getNoticeImage()).into(holder.binding.noticeImage);
    }

    @Override
    public int getItemCount() {
        return noticeModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        AllNoticeItemBinding binding;

        public viewHolder(AllNoticeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
