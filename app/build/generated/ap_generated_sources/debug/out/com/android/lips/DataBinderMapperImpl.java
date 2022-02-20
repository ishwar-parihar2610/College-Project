package com.android.lips;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.android.lips.databinding.ActivityAdminRegisterBindingImpl;
import com.android.lips.databinding.ActivityAllImageBindingImpl;
import com.android.lips.databinding.ActivityAllNoticeBindingImpl;
import com.android.lips.databinding.ActivityDeveloperContectBindingImpl;
import com.android.lips.databinding.ActivityEbookBindingImpl;
import com.android.lips.databinding.ActivityGroupBindingImpl;
import com.android.lips.databinding.ActivityMainBindingImpl;
import com.android.lips.databinding.ActivityPdfViewBindingImpl;
import com.android.lips.databinding.ActivityRegisterBindingImpl;
import com.android.lips.databinding.ActivitySplashBindingImpl;
import com.android.lips.databinding.ActivityStudentLoginBindingImpl;
import com.android.lips.databinding.ActivityStudentMainBindingImpl;
import com.android.lips.databinding.ActivityStudentRegisterBindingImpl;
import com.android.lips.databinding.ActivityUploadImageBindingImpl;
import com.android.lips.databinding.ActivityUploadNoticeBindingImpl;
import com.android.lips.databinding.ActivityUploadPdfBindingImpl;
import com.android.lips.databinding.AllNoticeItemBindingImpl;
import com.android.lips.databinding.AllPdfListItemBindingImpl;
import com.android.lips.databinding.FragmentContactUsBindingImpl;
import com.android.lips.databinding.FragmentFaculty2BindingImpl;
import com.android.lips.databinding.FragmentFacultyBindingImpl;
import com.android.lips.databinding.FragmentGalleryBindingImpl;
import com.android.lips.databinding.FragmentHomeBindingImpl;
import com.android.lips.databinding.FragmentNoticeBindingImpl;
import com.android.lips.databinding.FragmentStudentBindingImpl;
import com.android.lips.databinding.ItemLayoutBindingImpl;
import com.android.lips.databinding.LayoutNavigationHeaderBindingImpl;
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
  private static final int LAYOUT_ACTIVITYADMINREGISTER = 1;

  private static final int LAYOUT_ACTIVITYALLIMAGE = 2;

  private static final int LAYOUT_ACTIVITYALLNOTICE = 3;

  private static final int LAYOUT_ACTIVITYDEVELOPERCONTECT = 4;

  private static final int LAYOUT_ACTIVITYEBOOK = 5;

  private static final int LAYOUT_ACTIVITYGROUP = 6;

  private static final int LAYOUT_ACTIVITYMAIN = 7;

  private static final int LAYOUT_ACTIVITYPDFVIEW = 8;

  private static final int LAYOUT_ACTIVITYREGISTER = 9;

  private static final int LAYOUT_ACTIVITYSPLASH = 10;

  private static final int LAYOUT_ACTIVITYSTUDENTLOGIN = 11;

  private static final int LAYOUT_ACTIVITYSTUDENTMAIN = 12;

  private static final int LAYOUT_ACTIVITYSTUDENTREGISTER = 13;

  private static final int LAYOUT_ACTIVITYUPLOADIMAGE = 14;

  private static final int LAYOUT_ACTIVITYUPLOADNOTICE = 15;

  private static final int LAYOUT_ACTIVITYUPLOADPDF = 16;

  private static final int LAYOUT_ALLNOTICEITEM = 17;

  private static final int LAYOUT_ALLPDFLISTITEM = 18;

  private static final int LAYOUT_FRAGMENTCONTACTUS = 19;

  private static final int LAYOUT_FRAGMENTFACULTY = 20;

  private static final int LAYOUT_FRAGMENTFACULTY2 = 21;

  private static final int LAYOUT_FRAGMENTGALLERY = 22;

  private static final int LAYOUT_FRAGMENTHOME = 23;

  private static final int LAYOUT_FRAGMENTNOTICE = 24;

  private static final int LAYOUT_FRAGMENTSTUDENT = 25;

  private static final int LAYOUT_ITEMLAYOUT = 26;

  private static final int LAYOUT_LAYOUTNAVIGATIONHEADER = 27;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(27);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_admin_register, LAYOUT_ACTIVITYADMINREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_all_image, LAYOUT_ACTIVITYALLIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_all_notice, LAYOUT_ACTIVITYALLNOTICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_developer_contect, LAYOUT_ACTIVITYDEVELOPERCONTECT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_ebook, LAYOUT_ACTIVITYEBOOK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_group, LAYOUT_ACTIVITYGROUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_pdf_view, LAYOUT_ACTIVITYPDFVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_register, LAYOUT_ACTIVITYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_student_login, LAYOUT_ACTIVITYSTUDENTLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_student_main, LAYOUT_ACTIVITYSTUDENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_student_register, LAYOUT_ACTIVITYSTUDENTREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_image, LAYOUT_ACTIVITYUPLOADIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_notice, LAYOUT_ACTIVITYUPLOADNOTICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.activity_upload_pdf, LAYOUT_ACTIVITYUPLOADPDF);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.all_notice_item, LAYOUT_ALLNOTICEITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.all_pdf_list_item, LAYOUT_ALLPDFLISTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_contact_us, LAYOUT_FRAGMENTCONTACTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_faculty, LAYOUT_FRAGMENTFACULTY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_faculty2, LAYOUT_FRAGMENTFACULTY2);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_gallery, LAYOUT_FRAGMENTGALLERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_notice, LAYOUT_FRAGMENTNOTICE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.fragment_student, LAYOUT_FRAGMENTSTUDENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.item_layout, LAYOUT_ITEMLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.android.lips.R.layout.layout_navigation_header, LAYOUT_LAYOUTNAVIGATIONHEADER);
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
        case  LAYOUT_ACTIVITYADMINREGISTER: {
          if ("layout/activity_admin_register_0".equals(tag)) {
            return new ActivityAdminRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_admin_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYALLIMAGE: {
          if ("layout/activity_all_image_0".equals(tag)) {
            return new ActivityAllImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_all_image is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYALLNOTICE: {
          if ("layout/activity_all_notice_0".equals(tag)) {
            return new ActivityAllNoticeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_all_notice is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYDEVELOPERCONTECT: {
          if ("layout/activity_developer_contect_0".equals(tag)) {
            return new ActivityDeveloperContectBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_developer_contect is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEBOOK: {
          if ("layout/activity_ebook_0".equals(tag)) {
            return new ActivityEbookBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_ebook is invalid. Received: " + tag);
        }
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
        case  LAYOUT_ACTIVITYPDFVIEW: {
          if ("layout/activity_pdf_view_0".equals(tag)) {
            return new ActivityPdfViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_pdf_view is invalid. Received: " + tag);
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
        case  LAYOUT_ACTIVITYSTUDENTLOGIN: {
          if ("layout/activity_student_login_0".equals(tag)) {
            return new ActivityStudentLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_student_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTUDENTMAIN: {
          if ("layout/activity_student_main_0".equals(tag)) {
            return new ActivityStudentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_student_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYSTUDENTREGISTER: {
          if ("layout/activity_student_register_0".equals(tag)) {
            return new ActivityStudentRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_student_register is invalid. Received: " + tag);
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
        case  LAYOUT_ALLNOTICEITEM: {
          if ("layout/all_notice_item_0".equals(tag)) {
            return new AllNoticeItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for all_notice_item is invalid. Received: " + tag);
        }
        case  LAYOUT_ALLPDFLISTITEM: {
          if ("layout/all_pdf_list_item_0".equals(tag)) {
            return new AllPdfListItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for all_pdf_list_item is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCONTACTUS: {
          if ("layout/fragment_contact_us_0".equals(tag)) {
            return new FragmentContactUsBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_contact_us is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFACULTY: {
          if ("layout/fragment_faculty_0".equals(tag)) {
            return new FragmentFacultyBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_faculty is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFACULTY2: {
          if ("layout/fragment_faculty2_0".equals(tag)) {
            return new FragmentFaculty2BindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_faculty2 is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTGALLERY: {
          if ("layout/fragment_gallery_0".equals(tag)) {
            return new FragmentGalleryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_gallery is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTNOTICE: {
          if ("layout/fragment_notice_0".equals(tag)) {
            return new FragmentNoticeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_notice is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSTUDENT: {
          if ("layout/fragment_student_0".equals(tag)) {
            return new FragmentStudentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_student is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLAYOUT: {
          if ("layout/item_layout_0".equals(tag)) {
            return new ItemLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_layout is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTNAVIGATIONHEADER: {
          if ("layout/layout_navigation_header_0".equals(tag)) {
            return new LayoutNavigationHeaderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_navigation_header is invalid. Received: " + tag);
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
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(27);

    static {
      sKeys.put("layout/activity_admin_register_0", com.android.lips.R.layout.activity_admin_register);
      sKeys.put("layout/activity_all_image_0", com.android.lips.R.layout.activity_all_image);
      sKeys.put("layout/activity_all_notice_0", com.android.lips.R.layout.activity_all_notice);
      sKeys.put("layout/activity_developer_contect_0", com.android.lips.R.layout.activity_developer_contect);
      sKeys.put("layout/activity_ebook_0", com.android.lips.R.layout.activity_ebook);
      sKeys.put("layout/activity_group_0", com.android.lips.R.layout.activity_group);
      sKeys.put("layout/activity_main_0", com.android.lips.R.layout.activity_main);
      sKeys.put("layout/activity_pdf_view_0", com.android.lips.R.layout.activity_pdf_view);
      sKeys.put("layout/activity_register_0", com.android.lips.R.layout.activity_register);
      sKeys.put("layout/activity_splash_0", com.android.lips.R.layout.activity_splash);
      sKeys.put("layout/activity_student_login_0", com.android.lips.R.layout.activity_student_login);
      sKeys.put("layout/activity_student_main_0", com.android.lips.R.layout.activity_student_main);
      sKeys.put("layout/activity_student_register_0", com.android.lips.R.layout.activity_student_register);
      sKeys.put("layout/activity_upload_image_0", com.android.lips.R.layout.activity_upload_image);
      sKeys.put("layout/activity_upload_notice_0", com.android.lips.R.layout.activity_upload_notice);
      sKeys.put("layout/activity_upload_pdf_0", com.android.lips.R.layout.activity_upload_pdf);
      sKeys.put("layout/all_notice_item_0", com.android.lips.R.layout.all_notice_item);
      sKeys.put("layout/all_pdf_list_item_0", com.android.lips.R.layout.all_pdf_list_item);
      sKeys.put("layout/fragment_contact_us_0", com.android.lips.R.layout.fragment_contact_us);
      sKeys.put("layout/fragment_faculty_0", com.android.lips.R.layout.fragment_faculty);
      sKeys.put("layout/fragment_faculty2_0", com.android.lips.R.layout.fragment_faculty2);
      sKeys.put("layout/fragment_gallery_0", com.android.lips.R.layout.fragment_gallery);
      sKeys.put("layout/fragment_home_0", com.android.lips.R.layout.fragment_home);
      sKeys.put("layout/fragment_notice_0", com.android.lips.R.layout.fragment_notice);
      sKeys.put("layout/fragment_student_0", com.android.lips.R.layout.fragment_student);
      sKeys.put("layout/item_layout_0", com.android.lips.R.layout.item_layout);
      sKeys.put("layout/layout_navigation_header_0", com.android.lips.R.layout.layout_navigation_header);
    }
  }
}
