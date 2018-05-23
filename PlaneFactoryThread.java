package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/10.
 */

public class PlaneFactoryThread extends Thread {
    private ArrayList<Planes> planesArrayList;
    private ArrayList<Bitmap> bitmapArrayList = new ArrayList<Bitmap>();
    private MyPlaneActivity mp;
    private ImageView iv;
    private Planes plane;
    private Bitmap planebmp1,planebmp2,planebmp3,planebmp4,planebmp5;
    public PlaneFactoryThread(MyPlaneActivity mp,ImageView iv,ArrayList<Planes> planesArrayList){
        this.mp = mp;
        this.iv = iv;
        this.planesArrayList = planesArrayList;
        planebmp1 = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane1);
        bitmapArrayList.add(planebmp1);
        planebmp2 = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane2);
        bitmapArrayList.add(planebmp2);
        planebmp3 = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane3);
        bitmapArrayList.add(planebmp3);
        planebmp4 = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane4);
        bitmapArrayList.add(planebmp4);
        planebmp5 = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane5);
        bitmapArrayList.add(planebmp5);

    }
    public void run(){
        while(true){
            plane = new Planes(mp,iv,planesArrayList,bitmapArrayList);
            Log.i("PlaneFactory","plane = "+plane+"    planeArrayList.size="+planesArrayList.size());
            planesArrayList.add(plane);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
