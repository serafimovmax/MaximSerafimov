package com.epam.tc.hw9api.beans;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Board{"
            + "id='" + id + '\''
            + ", name='" + name + '\''
            + ", url='" + url + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board board = (Board) o;
        return Objects.equals(id, board.id) && Objects.equals(name, board.name)
            && Objects.equals(url, board.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url);
    }
}
