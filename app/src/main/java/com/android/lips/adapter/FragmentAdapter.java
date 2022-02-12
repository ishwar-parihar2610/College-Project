package com.android.lips.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.android.lips.fragment.FacultyFragment;
import com.android.lips.fragment.StudentFragment;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new FacultyFragment();
        }
        return new StudentFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
