package com.epam.tc.hw9api.beans;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "Lists{"
            + "id='" + id + '\''
            + ", name='" + name + '\''
            + ", pos='" + pos + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lists lists = (Lists) o;
        return Objects.equals(id, lists.id) && Objects.equals(name, lists.name)
            && Objects.equals(pos, lists.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pos);
    }
}
