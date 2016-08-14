package com.vishnus1224.teamworkapidemo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Config for the logged in user.
 * Wraps the token and the site url.
 * Created by Vishnu on 8/14/2016.
 */
public class UserConfig implements Parcelable {

    private final String apiToken;

    private final String url;

    public UserConfig(String apiToken, String url) {
        this.apiToken = apiToken;
        this.url = url;
    }

    protected UserConfig(Parcel in) {
        apiToken = in.readString();
        url = in.readString();
    }

    public static final Creator<UserConfig> CREATOR = new Creator<UserConfig>() {
        @Override
        public UserConfig createFromParcel(Parcel in) {
            return new UserConfig(in);
        }

        @Override
        public UserConfig[] newArray(int size) {
            return new UserConfig[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public String getApiToken() {
        return apiToken;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(apiToken);
        parcel.writeString(url);
    }
}
