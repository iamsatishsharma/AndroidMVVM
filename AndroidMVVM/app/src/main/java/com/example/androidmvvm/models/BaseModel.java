package com.example.androidmvvm.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Satish on 09/06/2020.
 * Base model
 */
public class BaseModel implements Parcelable {

    protected String code;
    private String message;

    public BaseModel() {

    }


    protected BaseModel(Parcel in) {
        code = in.readString();
        message = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

}
