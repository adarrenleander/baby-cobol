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

    public Boolean isNumerical() {
        for (int i = 0; i < this.picture.length(); i++) {
            if (this.picture.charAt(i) != '9' && this.picture.charAt(i) != 'Z') {
                return false;
            }
        }
        return true;
    }
}
