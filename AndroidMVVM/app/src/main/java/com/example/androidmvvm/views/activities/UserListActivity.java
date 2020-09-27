package com.example.androidmvvm.views.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.androidmvvm.BR;
import com.example.androidmvvm.R;
import com.example.androidmvvm.databinding.ActivityUserListBinding;
import com.example.androidmvvm.viewmodels.UserListViewModel;

/**
 * Created by Satish on 09/06/2020.
 */
public class UserListActivity extends BaseActivity<ActivityUserListBinding, UserListViewModel> {

    private UserListViewModel userListViewModel;
    public static boolean ISOFFLINE = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        userListViewModel = new UserListViewModel(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_list;
    }

    @Override
    public UserListViewModel getViewModel() {
        return userListViewModel;
    }

}