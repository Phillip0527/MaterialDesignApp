package com.example.phillip.materialdesignapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Phillip on 2017/11/23.
 */

public class Tool implements Parcelable{
    private static final int DETAILS_COUNT = 3;

    private final String name;
    private final String price;
    private final String [] details;
    private final String description;



    public Tool(String name, String price, String[] details, String description) {
        this.name = name;
        this.price = price;
        this.details = new String[DETAILS_COUNT];
        if(details != null){
            for (int i=0;i<details.length;i++){
                this.details[i] = details[i];
            }
        }
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String[] getDetails() {
        return details;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.price);
        dest.writeStringArray(this.details);
        dest.writeString(this.description);
    }

    protected Tool(Parcel in) {
        this.name = in.readString();
        this.price = in.readString();
        this.details = in.createStringArray();
        this.description = in.readString();
    }

    public static final Creator<Tool> CREATOR = new Creator<Tool>() {
        @Override
        public Tool createFromParcel(Parcel source) {
            return new Tool(source);
        }

        @Override
        public Tool[] newArray(int size) {
            return new Tool[size];
        }
    };
}
