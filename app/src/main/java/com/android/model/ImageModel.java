package com.android.model;

import java.io.Serializable;

public class ImageModel implements Serializable {
    String titleImage;
    String Image;
    String date;

    public String getImageTitle() {
        return titleImage;
    }

    public void setImageTitle(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
