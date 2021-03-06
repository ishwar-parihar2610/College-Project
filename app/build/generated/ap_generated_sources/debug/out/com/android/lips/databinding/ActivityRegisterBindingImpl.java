package com.android.lips.databinding;
import com.android.lips.R;
import com.android.lips.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRegisterBindingImpl extends ActivityRegisterBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBar, 1);
        sViewsWithIds.put(R.id.loginForm, 2);
        sViewsWithIds.put(R.id.layoutImage, 3);
        sViewsWithIds.put(R.id.profileImage, 4);
        sViewsWithIds.put(R.id.addImageTv, 5);
        sViewsWithIds.put(R.id.nameField, 6);
        sViewsWithIds.put(R.id.emailField, 7);
        sViewsWithIds.put(R.id.departmentField, 8);
        sViewsWithIds.put(R.id.subjectField, 9);
        sViewsWithIds.put(R.id.passwordField, 10);
        sViewsWithIds.put(R.id.confirmPasswordField, 11);
        sViewsWithIds.put(R.id.registerBtn, 12);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRegisterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private ActivityRegisterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[5]
            , (com.google.android.material.appbar.AppBarLayout) bindings[1]
            , (android.widget.EditText) bindings[11]
            , (android.widget.EditText) bindings[8]
            , (android.widget.EditText) bindings[7]
            , (android.widget.FrameLayout) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[2]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[10]
            , (com.makeramen.roundedimageview.RoundedImageView) bindings[4]
            , (com.google.android.material.button.MaterialButton) bindings[12]
            , (android.widget.EditText) bindings[9]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}