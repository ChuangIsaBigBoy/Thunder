package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/10.
 */

public class BulletsFactoryThread extends Thread{
    //属性：位置，速度
    //方法：画出子弹
    private int x,y,vx,vy;
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;
    private Planes plane;
    private MyPlane myPlane;
    private int time;
    private ArrayList<Bullet> bulletArrayList;
    MyPlaneActivity mp;

    public BulletsFactoryThread(MyPlaneActivity mp,Canvas canvas,ArrayList<Bullet> bulletArrayList){
        this.mp = mp;
        this.canvas = canvas;
        this.bulletArrayList = bulletArrayList;
    }

    public void run(){
        while (true) {
            Bullet bullet1 = new Bullet(mp,bulletArrayList);
            bullet1.x = plane.x;
            bullet1.y = plane.y+50;
            bullet1.isMybullet = false;
//            for(int i =0;i<bulletArrayList.size();i++){
//                if(bulletArrayList.get(i)==null){
//                    bulletArrayList.add(i,bullet1);
//                }
//                else{
//                    bulletArrayList.add(bullet1);
//                }
//            }
            bulletArrayList.add(bullet1);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setPlane(Planes plane){
        this.plane = plane;
    }
    public void setTime(int time){
        this.time = time;
    }
}
