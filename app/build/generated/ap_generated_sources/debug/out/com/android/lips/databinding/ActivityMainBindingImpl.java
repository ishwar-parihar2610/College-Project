package com.android.lips.databinding;
import com.android.lips.R;
import com.android.lips.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBar, 1);
        sViewsWithIds.put(R.id.profileImage, 2);
        sViewsWithIds.put(R.id.adminText, 3);
        sViewsWithIds.put(R.id.dashBoardText, 4);
        sViewsWithIds.put(R.id.scrollView, 5);
        sViewsWithIds.put(R.id.uploadNoticeCard, 6);
        sViewsWithIds.put(R.id.noticeImg, 7);
        sViewsWithIds.put(R.id.noticeText, 8);
        sViewsWithIds.put(R.id.uploadImageCard, 9);
        sViewsWithIds.put(R.id.uploadImg, 10);
        sViewsWithIds.put(R.id.uploadText, 11);
        sViewsWithIds.put(R.id.uploadE_BookCard, 12);
        sViewsWithIds.put(R.id.uploadEBook, 13);
        sViewsWithIds.put(R.id.uploadEBookText, 14);
        sViewsWithIds.put(R.id.uploadFacilityCard, 15);
        sViewsWithIds.put(R.id.uploadFacilityImg, 16);
        sViewsWithIds.put(R.id.uploadFacilityText, 17);
        sViewsWithIds.put(R.id.deleteCard, 18);
        sViewsWithIds.put(R.id.deleteNotice, 19);
        sViewsWithIds.put(R.id.deleteText, 20);
        sViewsWithIds.put(R.id.logoutCard, 21);
        sViewsWithIds.put(R.id.logoutImg, 22);
        sViewsWithIds.put(R.id.logoutText, 23);
        sViewsWithIds.put(R.id.developerContact, 24);
        sViewsWithIds.put(R.id.developerText, 25);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[3]
            , (com.google.android.material.appbar.AppBarLayout) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (com.google.android.material.card.MaterialCardView) bindings[18]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.TextView) bindings[20]
            , (com.google.android.material.card.MaterialCardView) bindings[24]
            , (android.widget.TextView) bindings[25]
            , (com.google.android.material.card.MaterialCardView) bindings[21]
            , (android.widget.ImageView) bindings[22]
            , (android.widget.TextView) bindings[23]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (com.makeramen.roundedimageview.RoundedImageView) bindings[2]
            , (android.widget.ScrollView) bindings[5]
            , (android.widget.ImageView) bindings[13]
            , (com.google.android.material.card.MaterialCardView) bindings[12]
            , (android.widget.TextView) bindings[14]
            , (com.google.android.material.card.MaterialCardView) bindings[15]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (com.google.android.material.card.MaterialCardView) bindings[9]
            , (android.widget.ImageView) bindings[10]
            , (com.google.android.material.card.MaterialCardView) bindings[6]
            , (android.widget.TextView) bindings[11]
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