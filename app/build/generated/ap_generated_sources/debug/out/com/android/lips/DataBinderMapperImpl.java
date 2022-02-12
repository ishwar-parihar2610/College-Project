package com.android.lips;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.android.lips.databinding.ActivityGroupBindingImpl;
import com.android.lips.databinding.ActivityMainBindingImpl;
import com.android.lips.databinding.ActivityRegisterBindingImpl;
import com.android.lips.databinding.ActivitySplashBindingImpl;
import com.android.lips.databinding.ActivityUploadImageBindingImpl;
import com.android.lips.databinding.ActivityUploadNoticeBindingImpl;
import com.android.lips.databinding.ActivityUploadPdfBindingImpl;
import com.android.lips.databinding.FragmentFacultyBindingImpl;
import com.android.lips.databinding.FragmentStudentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYGROUP = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_ACTIVITYREGISTER = 3;

  private static final int LAYOUT_ACTIVITYSPLASH = 4;

  private static final int LAYOUT_ACTIVITYUPLOADIMAGE = 5;

  private static final int LAYOUT_ACTIVITYUPLOADNOTICE = 6;

  private static final int LAYOUT_ACTIVITYUPLOADPDF = 7;

  private static final int LAYOUT_FRAGMENTFACULTY = 8;

  private static final int LAYOUT_FRAGMENTSTUDENT = 9;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(9);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_group, LAYOUT_ACTIVITYGROUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_register, LAYOUT_ACTIVITYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_image, LAYOUT_ACTIVITYUPLOADIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_notice, LAYOUT_ACTIVITYUPLOADNOTICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_pdf, LAYOUT_ACTIVITYUPLOADPDF);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_faculty, LAYOUT_FRAGMENTFACULTY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_student, LAYOUT_FRAGMENTSTUDENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYGROUP: {
          if ("layout/activity_group_0".equals(tag)) {
            return new ActivityGroupBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_group is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREGISTER: {
          if ("layout/activity_register_0".equals(tag)) {
            return new ActivityRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSPLASH: {
          if ("layout/activity_splash_0".equals(tag)) {
            return new ActivitySplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUPLOADIMAGE: {
          if ("layout/activity_upload_image_0".equals(tag)) {
            return new ActivityUploadImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_upload_image is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUPLOADNOTICE: {
          if ("layout/activity_upload_notice_0".equals(tag)) {
            return new ActivityUploadNoticeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_upload_notice is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYUPLOADPDF: {
          if ("layout/activity_upload_pdf_0".equals(tag)) {
            return new ActivityUploadPdfBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_upload_pdf is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFACULTY: {
          if ("layout/fragment_faculty_0".equals(tag)) {
            return new FragmentFacultyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_faculty is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSTUDENT: {
          if ("layout/fragment_student_0".equals(tag)) {
            return new FragmentStudentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_student is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(9);

    static {
      sKeys.put("layout/activity_group_0", com.android.lips.R.layout.activity_group);
      sKeys.put("layout/activity_main_0", com.android.lips.R.layout.activity_main);
      sKeys.put("layout/activity_register_0", com.android.lips.R.layout.activity_register);
      sKeys.put("layout/activity_splash_0", com.android.lips.R.layout.activity_splash);
      sKeys.put("layout/activity_upload_image_0", com.android.lips.R.layout.activity_upload_image);
      sKeys.put("layout/activity_upload_notice_0", com.android.lips.R.layout.activity_upload_notice);
      sKeys.put("layout/activity_upload_pdf_0", com.android.lips.R.layout.activity_upload_pdf);
      sKeys.put("layout/fragment_faculty_0", com.android.lips.R.layout.fragment_faculty);
      sKeys.put("layout/fragment_student_0", com.android.lips.R.layout.fragment_student);
    }
  }
}
