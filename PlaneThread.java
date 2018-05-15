package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/7.
 */
public class PlaneThread extends Thread{
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;
    private  MyPlane myPlane;
    private HandleMessage hm;
    private ImageView iv;
    private ImageViewListener ivl;
    private float x,y;
    private  MyPlaneActivity mp;
    private ArrayList<Planes> planesArrayList;
    private Rect bgsrc;
    private Rect bgdst;
    private HitCheckThread hct;


    public PlaneThread(MyPlaneActivity mp,Canvas canvas, Bitmap bitmap,Paint paint, HandleMessage hm, ImageView iv, ArrayList<Planes> planesArrayList,ImageViewListener ivl,MyPlane myPlane){
        this.mp = mp;
        this.canvas = canvas;
        this.bitmap = bitmap;
        this.paint = paint;
        this.hm = hm;
        this.iv = iv;
        this.myPlane = myPlane;
        this.planesArrayList = planesArrayList;
        this.ivl = ivl;
        this.myPlane = myPlane;

    }


    public void run(){

        while(true){
            bitmap = Bitmap.createBitmap(iv.getWidth(),iv.getHeight(), Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            paint = new Paint();
            bgsrc = new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
            bgdst = new Rect(0,0,iv.getWidth(),iv.getHeight());

            for(int i = 0;i<planesArrayList.size();i++){
                Planes plane = planesArrayList.get(i);
                plane.fly();
                plane.drawplane(canvas,bitmap);
            }
            myPlane.drawmyplane(canvas);

            canvas.drawBitmap(bitmap,bgsrc,bgdst,paint);
            Message msg = new Message();
            msg.obj =bitmap;
            hm.sendMessage(msg);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
