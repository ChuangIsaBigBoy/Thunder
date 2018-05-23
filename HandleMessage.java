package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;


/**
 * Created by Administrator on 2018/4/7.
 */
public class HandleMessage extends Handler {
    private ImageView iv;

    public HandleMessage(ImageView iv) {
        this.iv = iv;
    }
    public void handleMessage(Message msg) {
        Bitmap bmp = (Bitmap)msg.obj;
        iv.setImageBitmap(bmp);
    }
}
