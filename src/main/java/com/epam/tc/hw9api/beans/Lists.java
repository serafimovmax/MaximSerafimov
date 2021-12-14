package com.epam.tc.hw9api.beans;

import com.google.gson.annotations.SerializedName;

public class Lists {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("pos")
    private String pos;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
