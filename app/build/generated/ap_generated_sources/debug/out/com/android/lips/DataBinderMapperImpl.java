package com.android.lips;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.android.lips.databinding.ActivityMainBindingImpl;
import com.android.lips.databinding.ActivityRegisterBindingImpl;
import com.android.lips.databinding.ActivitySplashBindingImpl;
import com.android.lips.databinding.ActivityUploadImageBindingImpl;
import com.android.lips.databinding.ActivityUploadNoticeBindingImpl;
import com.android.lips.databinding.ActivityUploadPdfBindingImpl;
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
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_ACTIVITYREGISTER = 2;

  private static final int LAYOUT_ACTIVITYSPLASH = 3;

  private static final int LAYOUT_ACTIVITYUPLOADIMAGE = 4;

  private static final int LAYOUT_ACTIVITYUPLOADNOTICE = 5;

  private static final int LAYOUT_ACTIVITYUPLOADPDF = 6;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(6);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_register, LAYOUT_ACTIVITYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_image, LAYOUT_ACTIVITYUPLOADIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_notice, LAYOUT_ACTIVITYUPLOADNOTICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_pdf, LAYOUT_ACTIVITYUPLOADPDF);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(6);

    static {
      sKeys.put("layout/activity_main_0", com.android.lips.R.layout.activity_main);
      sKeys.put("layout/activity_register_0", com.android.lips.R.layout.activity_register);
      sKeys.put("layout/activity_splash_0", com.android.lips.R.layout.activity_splash);
      sKeys.put("layout/activity_upload_image_0", com.android.lips.R.layout.activity_upload_image);
      sKeys.put("layout/activity_upload_notice_0", com.android.lips.R.layout.activity_upload_notice);
      sKeys.put("layout/activity_upload_pdf_0", com.android.lips.R.layout.activity_upload_pdf);
    }
  }
}
