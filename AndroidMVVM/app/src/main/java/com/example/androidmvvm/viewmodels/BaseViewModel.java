
package com.example.androidmvvm.viewmodels;

import android.Manifest;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableBoolean;

import com.example.androidmvvm.models.BaseModel;

import com.example.androidmvvm.views.activities.BaseActivity;
import com.example.androidmvvm.views.fragments.BaseFragment;
/**
 * Created by Satish on 09/06/2020.
 * Base model view
 */
public abstract class BaseViewModel<T extends BaseModel> extends BaseObservable {
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);
    private BaseActivity activity;
    private BaseFragment fragment;
    protected T model;
    private static BaseActivity baseActivity;
    private BaseModel customeModel;
    private boolean isDownload;

    public BaseViewModel(BaseActivity activity) {

        model = getModel();
        this.activity = activity;
        baseActivity = activity;
    }

    public BaseViewModel(BaseFragment fragment) {

        model = getModel();
        this.fragment = fragment;
        this.activity = fragment.getBaseActivity();
        baseActivity = activity;
    }

    public void setModel(T model) {
        this.model = model;
    }

    abstract T getModel();

    public BaseActivity getActivity() {
        return activity;
    }

    public abstract boolean validate();

    public BaseFragment getFragment() {
        return fragment;
    }

}

