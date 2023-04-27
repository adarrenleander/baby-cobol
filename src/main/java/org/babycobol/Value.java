package org.babycobol;

public class Value {
    private String value;
    private String picture;

    public Value() {}

    public Value(String value, String picture) {
        this.value = value;
        this.picture = picture;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
