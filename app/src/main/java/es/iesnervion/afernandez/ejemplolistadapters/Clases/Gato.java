package es.iesnervion.afernandez.ejemplolistadapters.Clases;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Gato {
    private int imageId;
    private String text;

    public Gato(int id, String txt)
    {
        imageId=id;
        text=txt;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

//    public String getText() {
//        return text;
//    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
