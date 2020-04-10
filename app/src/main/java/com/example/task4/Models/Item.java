
package com.example.task4.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("from_name")
    @Expose
    private String fromName;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("to_name")
    @Expose
    private String toName;
    @SerializedName("type")
    @Expose
    private String type;

    protected Item(Parcel in) {
        name = in.readString();
        subtype = in.readString();
        fromName = in.readString();
        id = in.readString();
        toName = in.readString();
        type = in.readString();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(subtype);
        dest.writeString(fromName);
        dest.writeString(id);
        dest.writeString(toName);
        dest.writeString(type);
    }
}
