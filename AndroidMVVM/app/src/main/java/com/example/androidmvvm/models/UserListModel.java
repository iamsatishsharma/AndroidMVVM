package com.example.androidmvvm.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Satish on 09/06/2020.
 */
public class UserListModel extends BaseModel implements Parcelable {

    private List<CardModel> cardModellist;

    public UserListModel() {

    }

    protected UserListModel(Parcel in) {
        super(in);
        cardModellist = in.createTypedArrayList(CardModel.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(cardModellist);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserListModel> CREATOR = new Creator<UserListModel>() {
        @Override
        public UserListModel createFromParcel(Parcel in) {
            return new UserListModel(in);
        }

        @Override
        public UserListModel[] newArray(int size) {
            return new UserListModel[size];
        }
    };

    public List<CardModel> getCardModellist() {
        return cardModellist;
    }

    public void setCardModellist(List<CardModel> cardModellist) {
        this.cardModellist = cardModellist;
    }
}
