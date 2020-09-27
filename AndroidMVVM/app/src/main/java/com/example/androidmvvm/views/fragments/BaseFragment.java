
package com.example.androidmvvm.views.fragments;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.androidmvvm.viewmodels.BaseViewModel;
import com.example.androidmvvm.views.activities.BaseActivity;

/**
 * Created by Satish on 09/06/2020.
 */
public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private BaseActivity mActivity;
    private View mRootView;
    private T mViewDataBinding;
    private V mViewModel;
    private BaseFragment fragment;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            fragment = this;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        setHasOptionsMenu(false);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
            disableAutoFill();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();

        return mRootView;
    }

    @Override
    public void onDetach() {
        mActivity = null;

        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();

    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }


    private void performDependencyInjection() {
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void disableAutoFill() {
        if (getActivity() != null)
            getActivity().getWindow().getDecorView().setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS);
    }


}
