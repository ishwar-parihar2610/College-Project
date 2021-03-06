// Generated by data binding compiler. Do not edit!
package com.android.lips.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.android.lips.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentStudentBinding extends ViewDataBinding {
  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RecyclerView recycleView;

  protected FragmentStudentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ProgressBar progressBar, RecyclerView recycleView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.progressBar = progressBar;
    this.recycleView = recycleView;
  }

  @NonNull
  public static FragmentStudentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_student, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentStudentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentStudentBinding>inflateInternal(inflater, R.layout.fragment_student, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentStudentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_student, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentStudentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentStudentBinding>inflateInternal(inflater, R.layout.fragment_student, null, false, component);
  }

  public static FragmentStudentBinding bind(@NonNull View view) {
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
  public static FragmentStudentBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentStudentBinding)bind(component, view, R.layout.fragment_student);
  }
}
