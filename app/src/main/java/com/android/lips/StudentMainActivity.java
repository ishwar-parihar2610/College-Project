package com.android.lips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.lips.databinding.ActivityDeveloperContectBinding;
import com.android.lips.databinding.ActivityStudentMainBinding;
import com.android.lips.databinding.AllPdfListItemBinding;
import com.android.lips.utilities.Constant;
import com.android.lips.utilities.PreferenceManager;
import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.makeramen.roundedimageview.RoundedImageView;

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
        View view=binding.navigationView.getHeaderView(0);
        TextView userName=view.findViewById(R.id.userName);
        TextView email=view.findViewById(R.id.email);
        userName.setText(preferenceManager.getString(Constant.STUDENT_NAME));
        email.setText(preferenceManager.getString(Constant.STUDENT_EMAIL));
        RoundedImageView roundedImageView=view.findViewById(R.id.profileImage);
        Glide.with(this).load(preferenceManager.getString(Constant.STUDENT_PROFILE_IMAGE)).into(roundedImageView);
       binding.profileImage.setOnClickListener(v->{
           binding.drawerLayout.openDrawer(GravityCompat.START);
       });
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
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    navController.navigate(R.id.navigation_Home);
                   binding.drawerLayout.close();
                }else if(item.getItemId()==R.id.logOut){
                    preferenceManager.Clear();

                    startActivity(new Intent(StudentMainActivity.this,SplashActivity.class));
                    finishAffinity();
                }else if(item.getItemId()==R.id.developerContact){
                    startActivity(new Intent(StudentMainActivity.this, developerContect.class));
                }else if(item.getItemId()==R.id.E_Book){
                    startActivity(new Intent(StudentMainActivity.this, ActivityEbook.class));
                }else if(item.getItemId()==R.id.code){

                        Uri uri = Uri.parse("https://github.com/ishwar-parihar2610"); // missing 'http://' will cause crashed
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);

                }else if(item.getItemId()==R.id.contect_us){
//                    Uri uri = Uri.parse("https://luckyinstitute.org/contact.php"); // missing 'http://' will cause crashed
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
                    navController.navigate(R.id.contact_us_fragment);
                    binding.drawerLayout.close();
                }else if(item.getItemId()==R.id.Website){
                    Uri uri = Uri.parse("https://digimobaile.blogspot.com/"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                return true;
            }
        });
    }
}