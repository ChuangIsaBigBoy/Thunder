package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;

public class MyPlaneActivity extends AppCompatActivity {

    private Bitmap bgbmp;
    private ArrayList<Planes> planesArrayList = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_plane);
        ImageView iv = (ImageView)this.findViewById(R.id.imageview);
        ImageViewListener ivl = new ImageViewListener(this,iv,planesArrayList);
        iv.setOnTouchListener(ivl);
    }
}
