package com.android.lips.studentFragment.home;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lips.R;
import com.android.lips.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding= DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
       try {
           binding.webView.loadUrl("https://luckyinstitute.org/");
       } catch (Exception e) {
           e.printStackTrace();
       }


       return binding.getRoot();
    }
}