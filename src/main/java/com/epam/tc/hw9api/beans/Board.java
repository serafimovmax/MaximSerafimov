package com.epam.tc.hw9api.beans;

import com.google.gson.annotations.SerializedName;

public class Board {

    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("url")
    public String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
