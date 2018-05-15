package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/2.
 */

public class MyBullet {
    public  int x,y,vy,w=10,h=16;
    private MyPlaneActivity mp;
    private Bitmap myBullet;
    private Canvas canvas;
    private Planes plane;
    private ArrayList<Planes> planesArrayList;
    private ArrayList<MyBullet>myBulletArrayList;
    public MyBullet(MyPlaneActivity mp,ArrayList<Planes> planesArrayList,ArrayList<MyBullet>myBulletArrayList) {
        this.planesArrayList = planesArrayList;
        this.myBulletArrayList = myBulletArrayList;
        this.mp = mp;
        myBullet = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.bullet0);
    }

    public void drawmyBullet(Canvas canvas){
        this.canvas = canvas;
        Rect bltsrc0 = new Rect(0,0,myBullet.getWidth(),myBullet.getHeight());
        Rect bltdst0 = new Rect(x-w,y-h,x+w,y+h);
        canvas.drawBitmap(myBullet,bltsrc0,bltdst0,null);
    }

    public void move(){
        vy = 10;
        y -= vy;
        if(y<=0){
            myBulletArrayList.remove(this);
        }
    }

    public void HitCheck(){
        for(int i = 0;i<planesArrayList.size();i++){
            plane = planesArrayList.get(i);
            if((plane.x+plane.r>=this.x-this.w && plane.y+plane.r>=this.y-this.h)
                    ||(plane.x-plane.r<=this.x+this.w && plane.y+plane.r>=this.y-this.h)
                    ||(plane.x+plane.r>=this.x-this.w && plane.y-plane.r<=this.y+this.h)
                    ||(plane.x-plane.r<=this.x+this.w && plane.y-plane.r<=this.y+this.h)) {
                myBulletArrayList.remove(this);
                planesArrayList.remove(i);
//                break;
            }
        }
    }

}
