package com.raymundo.dbd_guidebook.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class Item implements Parcelable {

    private final UUID id;
    private String title;
    private int iconResId;

    public Item(String title, int iconResId) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.iconResId = iconResId;
    }

    protected Item(Parcel in) {
        id = (UUID) in.readSerializable();
        title = in.readString();
        iconResId = in.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(id);
        dest.writeString(title);
        dest.writeInt(iconResId);
    }
}
