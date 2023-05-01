package com.example.androidmvvm.models;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Satish on 09/06/2020.
 */
public class CardModel extends BaseModel implements Parcelable {

    private int id;
    private String  login;
    private String  avatar_url;

    protected CardModel(Parcel in) {
        super(in);
        id = in.readInt();
        login = in.readString();
        avatar_url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(id);
        dest.writeString(login);
        dest.writeString(avatar_url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CardModel> CREATOR = new Creator<CardModel>() {
        @Override
        public CardModel createFromParcel(Parcel in) {
            return new CardModel(in);
        }

        @Override
        public CardModel[] newArray(int size) {
            return new CardModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

}


