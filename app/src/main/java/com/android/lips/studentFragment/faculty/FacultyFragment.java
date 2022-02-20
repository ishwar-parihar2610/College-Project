package com.android.lips.studentFragment.faculty;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.lips.R;
import com.android.lips.adapter.FragmentAdapter;
import com.android.lips.databinding.FragmentFaculty2Binding;
import com.google.android.material.tabs.TabLayout;


public class FacultyFragment extends Fragment {

    FragmentFaculty2Binding binding;
    FragmentAdapter fragmentAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_faculty2, container, false);
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragmentManager, getLifecycle());
        binding.viewPager.setAdapter(fragmentAdapter);
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Student"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Faculty"));
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });


        return binding.getRoot();
    }
}