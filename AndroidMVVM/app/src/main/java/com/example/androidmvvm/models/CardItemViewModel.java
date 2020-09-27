package com.example.androidmvvm.models;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class CardItemViewModel extends BaseObservable {

    private CardModel model;
    private Context context;

    public CardItemViewModel(Context context) {
        this.context = context;
    }

    public void setModel(CardModel model) {
        this.model = model;
    }

    public CardModel getModel() {
        return model;
    }

    @Bindable
    public String getName() {
        return getModel().getLogin();
    }

    public String getUserImage() {
        return getModel().getAvatar_url();
    }

    @BindingAdapter({"bind:imgUrl"})
    public static void setProfilePicture(ImageView imageView, String imgUrl) {
        Glide.with(imageView.getContext()).load(imgUrl).into(imageView);
    }

}
