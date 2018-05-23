package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/15.
 */

public class MyPlane {
    float x,y;
    int ix,iy,count=0;
    boolean isMyplane = true;
    public ArrayList<MyBullet> myBulletArrayList;
    public ArrayList<Planes> planesArrayList;
    private Canvas canvas;
    private MyBullet myBullet;
    MyPlaneActivity mp;
    private Bitmap plane;
    public void setXY(float x,float y){
        this.x = x;
        this.y = y;
    }
    public MyPlane(final MyPlaneActivity mp, final ArrayList<Planes> planesArrayList){
        this.planesArrayList = planesArrayList;
        this.mp = mp;
        myBulletArrayList = new ArrayList<>();
        plane = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.myplane);
        new Thread(){
            public void run(){
                while(true){
                    MyBullet myBullet = new MyBullet(mp,planesArrayList,myBulletArrayList);
                    myBullet.x = (int)MyPlane.this.x;
                    myBullet.y = (int)MyPlane.this.y-50;
//                    if(count <= myBulletArrayList.size()){
//                        myBulletArrayList.add(count,myBullet);
//                        count++;
//                    }
//                    else{
//                        count =0;
//                    }
                    myBulletArrayList.add(myBullet);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void drawmyplane(Canvas canvas){
        this.canvas = canvas;
        ix = (int)x;
        iy = (int)y;
        Rect plsrc = new Rect(0,0,plane.getWidth(),plane.getHeight());
        Rect pldst = new Rect(ix-50,iy-50,ix+50,iy+50);
        canvas.drawBitmap(plane,plsrc,pldst,null);
        for(int i  = 0;i<myBulletArrayList.size();i++){
            myBullet = myBulletArrayList.get(i);
            myBullet.move();
//            myBullet.HitCheck();
            myBullet.drawmyBullet(canvas);
        }
    }



}
