package com.android.lips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.android.lips.databinding.ActivityStudentMainBinding;
import com.android.lips.utilities.Constant;
import com.android.lips.utilities.PreferenceManager;
import com.bumptech.glide.Glide;

public class StudentMainActivity extends AppCompatActivity {
    ActivityStudentMainBinding binding;
    PreferenceManager preferenceManager;
    NavController navController;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_student_main);
       preferenceManager=new PreferenceManager(this);
        navController= Navigation.findNavController(this,R.id.frame_layout);
        appBarConfiguration=new AppBarConfiguration.Builder(navController.getGraph()).build();
       if(preferenceManager.getString(Constant.STUDENT_PROFILE_IMAGE)!=null){
           Glide.with(this).load(preferenceManager.getString(Constant.STUDENT_PROFILE_IMAGE)).into(binding.profileImage);
       }
       binding.home.setOnClickListener(v->{
           navController.navigate(R.id.navigation_Home);
           binding.adminText.setText("Home");
       });
       binding.gallery.setOnClickListener(v->{
           navController.navigate(R.id.navigation_gallery);
           binding.adminText.setText("Gallery");
       });
       binding.notice.setOnClickListener(v->{
           navController.navigate(R.id.navigation_Notice);
           binding.adminText.setText("Notice");
       });
       binding.faculty.setOnClickListener(v->{
           navController.navigate(R.id.faculty_view);
           binding.adminText.setText("Group");
       });

    }
}