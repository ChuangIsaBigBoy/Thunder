package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2018/4/9.
 */

public class Planes {
    //飞机类
    //属性：位置，速度，生命值，飞机种类等
    //方法：运动，发射子弹，画出飞机的方法等
    public int x,y,vy,r=50,num;
    private int hp;
    private int kind;
    private ImageView iv;
    private Canvas canvas;
    private Bitmap bitmap,planebmp;
    private Paint paint;
    private Random random;
    private MyPlaneActivity mp;
    boolean isOverBound = false;
    boolean isMyplane = false;
    private ArrayList<Bullet> bulletArrayList;
    private Bullet bullet;
    private ArrayList<Planes> planesArrayList;

    public Planes(MyPlaneActivity mp,ImageView iv,ArrayList<Planes> planesArrayList){
        this.mp = mp;
        this.iv = iv;
        this.planesArrayList = planesArrayList;
        bulletArrayList = new ArrayList<>();
        random = new Random();
        y = 0;
        x = 20 * random.nextInt(40);
        vy = 2;
        kind = random.nextInt(5);
        switch(kind){
            case 0:
                planebmp = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane1);
                break;
            case 1:
                planebmp = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane2);
                break;
            case 2:
                planebmp = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane3);
                break;
            case 3:
                planebmp = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane4);
                break;
            case 4:
                planebmp = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.plane5);
                break;
        }
        BulletsFactoryThread bft1 = new BulletsFactoryThread(mp,canvas,bulletArrayList);
        bft1.setPlane(this);
        bft1.setTime(1500);
        bft1.start();
    }

    public void fly(){
        y = y+vy;
        if(y>=iv.getHeight()){
            isOverBound = true;
            planesArrayList.remove(this);
//            num++;
//            bulletArrayList = null;
        }
    }

    public void drawplane(Canvas canvas,Bitmap bitmap){
        this.canvas = canvas;
        this.bitmap = bitmap;
        Rect planesrc = new Rect(0,0,planebmp.getWidth(),planebmp.getHeight());
        Rect planedst = new Rect(x-r,y-r,x+r,y+r);
        canvas.drawBitmap(planebmp,planesrc,planedst,paint);
        for (int i = 0;i<bulletArrayList.size();i++){
            bullet = bulletArrayList.get(i);
            bullet.move();
            bullet.drawbullet(canvas);
            if(y-50>=iv.getHeight()){
                num++;
                bulletArrayList = null;
                break;
            }
        }
    }
}
