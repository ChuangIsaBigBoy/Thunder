package com.example.administrator.thunder;

import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/10.
 */

public class PlaneFactoryThread extends Thread {
    private ArrayList<Planes> planesArrayList;
    private MyPlaneActivity mp;
    private ImageView iv;
    private Planes plane;
    public PlaneFactoryThread(MyPlaneActivity mp,ImageView iv,ArrayList<Planes> planesArrayList){
        this.mp = mp;
        this.iv = iv;
        this.planesArrayList = planesArrayList;
    }
    public void run(){
        while(true){
            plane = new Planes(mp,iv,planesArrayList);
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
