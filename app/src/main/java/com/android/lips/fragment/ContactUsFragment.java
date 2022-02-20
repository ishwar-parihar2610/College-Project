package com.android.lips.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lips.R;
import com.android.lips.databinding.FragmentContactUsBinding;


public class ContactUsFragment extends Fragment {
    FragmentContactUsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_contact_us, container, false);
        try {
            binding.webView.loadUrl("https://luckyinstitute.org/contact.php");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return binding.getRoot();
    }
}