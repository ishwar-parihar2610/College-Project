// Generated by data binding compiler. Do not edit!
package com.android.lips.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.android.lips.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;
import com.makeramen.roundedimageview.RoundedImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityMainBinding extends ViewDataBinding {
  @NonNull
  public final TextView adminText;

  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final TextView dashBoardText;

  @NonNull
  public final MaterialCardView deleteCard;

  @NonNull
  public final ImageView deleteNotice;

  @NonNull
  public final TextView deleteText;

  @NonNull
  public final MaterialCardView developerContact;

  @NonNull
  public final TextView developerText;

  @NonNull
  public final MaterialCardView logoutCard;

  @NonNull
  public final ImageView logoutImg;

  @NonNull
  public final TextView logoutText;

  @NonNull
  public final ImageView noticeImg;

  @NonNull
  public final TextView noticeText;

  @NonNull
  public final RoundedImageView profileImage;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final ImageView uploadEBook;

  @NonNull
  public final MaterialCardView uploadEBookCard;

  @NonNull
  public final TextView uploadEBookText;

  @NonNull
  public final MaterialCardView uploadFacilityCard;

  @NonNull
  public final ImageView uploadFacilityImg;

  @NonNull
  public final TextView uploadFacilityText;

  @NonNull
  public final MaterialCardView uploadImageCard;

  @NonNull
  public final ImageView uploadImg;

  @NonNull
  public final MaterialCardView uploadNoticeCard;

  @NonNull
  public final TextView uploadText;

  protected ActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView adminText, AppBarLayout appBar, TextView dashBoardText, MaterialCardView deleteCard,
      ImageView deleteNotice, TextView deleteText, MaterialCardView developerContact,
      TextView developerText, MaterialCardView logoutCard, ImageView logoutImg, TextView logoutText,
      ImageView noticeImg, TextView noticeText, RoundedImageView profileImage,
      ScrollView scrollView, ImageView uploadEBook, MaterialCardView uploadEBookCard,
      TextView uploadEBookText, MaterialCardView uploadFacilityCard, ImageView uploadFacilityImg,
      TextView uploadFacilityText, MaterialCardView uploadImageCard, ImageView uploadImg,
      MaterialCardView uploadNoticeCard, TextView uploadText) {
    super(_bindingComponent, _root, _localFieldCount);
    this.adminText = adminText;
    this.appBar = appBar;
    this.dashBoardText = dashBoardText;
    this.deleteCard = deleteCard;
    this.deleteNotice = deleteNotice;
    this.deleteText = deleteText;
    this.developerContact = developerContact;
    this.developerText = developerText;
    this.logoutCard = logoutCard;
    this.logoutImg = logoutImg;
    this.logoutText = logoutText;
    this.noticeImg = noticeImg;
    this.noticeText = noticeText;
    this.profileImage = profileImage;
    this.scrollView = scrollView;
    this.uploadEBook = uploadEBook;
    this.uploadEBookCard = uploadEBookCard;
    this.uploadEBookText = uploadEBookText;
    this.uploadFacilityCard = uploadFacilityCard;
    this.uploadFacilityImg = uploadFacilityImg;
    this.uploadFacilityText = uploadFacilityText;
    this.uploadImageCard = uploadImageCard;
    this.uploadImg = uploadImg;
    this.uploadNoticeCard = uploadNoticeCard;
    this.uploadText = uploadText;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMainBinding>inflateInternal(inflater, R.layout.activity_main, null, false, component);
  }

  public static ActivityMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMainBinding)bind(component, view, R.layout.activity_main);
  }
}
