// Generated by data binding compiler. Do not edit!
package com.android.lips.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.android.lips.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityUploadNoticeBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appBar;

  @NonNull
  public final ConstraintLayout card;

  @NonNull
  public final ImageView noticeImg;

  @NonNull
  public final TextView noticeText;

  @NonNull
  public final EditText noticeTitleField;

  @NonNull
  public final ImageView noticeUploadedImage;

  @NonNull
  public final MaterialButton uploadBtn;

  @NonNull
  public final ConstraintLayout uploadImageLayout;

  @NonNull
  public final MaterialCardView uploadNoticeCard;

  protected ActivityUploadNoticeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appBar, ConstraintLayout card, ImageView noticeImg, TextView noticeText,
      EditText noticeTitleField, ImageView noticeUploadedImage, MaterialButton uploadBtn,
      ConstraintLayout uploadImageLayout, MaterialCardView uploadNoticeCard) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBar = appBar;
    this.card = card;
    this.noticeImg = noticeImg;
    this.noticeText = noticeText;
    this.noticeTitleField = noticeTitleField;
    this.noticeUploadedImage = noticeUploadedImage;
    this.uploadBtn = uploadBtn;
    this.uploadImageLayout = uploadImageLayout;
    this.uploadNoticeCard = uploadNoticeCard;
  }

  @NonNull
  public static ActivityUploadNoticeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_upload_notice, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityUploadNoticeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityUploadNoticeBinding>inflateInternal(inflater, R.layout.activity_upload_notice, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityUploadNoticeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_upload_notice, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityUploadNoticeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityUploadNoticeBinding>inflateInternal(inflater, R.layout.activity_upload_notice, null, false, component);
  }

  public static ActivityUploadNoticeBinding bind(@NonNull View view) {
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
  public static ActivityUploadNoticeBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityUploadNoticeBinding)bind(component, view, R.layout.activity_upload_notice);
  }
}
