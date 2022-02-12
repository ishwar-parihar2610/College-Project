package com.android.lips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.android.lips.adapter.FragmentAdapter;
import com.android.lips.databinding.ActivityGroupBinding;
import com.google.android.material.tabs.TabLayout;

public class ActivityGroup extends AppCompatActivity {
    ActivityGroupBinding binding;
    FragmentAdapter fragmentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_group);
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentAdapter=new FragmentAdapter(fragmentManager,getLifecycle());
        binding.viewPager.setAdapter(fragmentAdapter);

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Faculty"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Student"));
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
    }
    }
