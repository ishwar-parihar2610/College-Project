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
        sViewsWithIds.put(R.id.adminText, 2);
        sViewsWithIds.put(R.id.dashBoardText, 3);
        sViewsWithIds.put(R.id.scrollView, 4);
        sViewsWithIds.put(R.id.uploadNoticeCard, 5);
        sViewsWithIds.put(R.id.noticeImg, 6);
        sViewsWithIds.put(R.id.noticeText, 7);
        sViewsWithIds.put(R.id.uploadImageCard, 8);
        sViewsWithIds.put(R.id.uploadImg, 9);
        sViewsWithIds.put(R.id.uploadText, 10);
        sViewsWithIds.put(R.id.uploadE_BookCard, 11);
        sViewsWithIds.put(R.id.uploadEBook, 12);
        sViewsWithIds.put(R.id.uploadEBookText, 13);
        sViewsWithIds.put(R.id.uploadFacilityCard, 14);
        sViewsWithIds.put(R.id.uploadFacilityImg, 15);
        sViewsWithIds.put(R.id.uploadFacilityText, 16);
        sViewsWithIds.put(R.id.deleteCard, 17);
        sViewsWithIds.put(R.id.deleteNotice, 18);
        sViewsWithIds.put(R.id.deleteText, 19);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (com.google.android.material.appbar.AppBarLayout) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (com.google.android.material.card.MaterialCardView) bindings[17]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.TextView) bindings[19]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[7]
            , (android.widget.ScrollView) bindings[4]
            , (android.widget.ImageView) bindings[12]
            , (com.google.android.material.card.MaterialCardView) bindings[11]
            , (android.widget.TextView) bindings[13]
            , (com.google.android.material.card.MaterialCardView) bindings[14]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.TextView) bindings[16]
            , (com.google.android.material.card.MaterialCardView) bindings[8]
            , (android.widget.ImageView) bindings[9]
            , (com.google.android.material.card.MaterialCardView) bindings[5]
            , (android.widget.TextView) bindings[10]
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