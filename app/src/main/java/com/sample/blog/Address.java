package com.sample.blog;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Address implements Parcelable {
    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.street);
        dest.writeString(this.suite);
        dest.writeString(this.city);
        dest.writeString(this.zipcode);
    }

    public Address() {
    }

    protected Address(Parcel in) {
        this.street = in.readString();
        this.suite = in.readString();
        this.city = in.readString();
        this.zipcode = in.readString();
    }

    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel source) {
            return new Address(source);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };
}
