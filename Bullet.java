package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/10.
 */

public class Bullet {
    public  int x,y,vy,w=10,h=16;
    private Canvas canvas;
    private Bitmap bitmap;
    private Paint paint;
    private Bitmap bullet1;
    private MyPlaneActivity mp;
    private ArrayList<Bullet> bulletArrayList;
    boolean isMybullet;
    public Bullet(MyPlaneActivity mp,ArrayList<Bullet> bulletArrayList){
        this.mp = mp;
        this.bulletArrayList = bulletArrayList;
        bullet1 = BitmapFactory.decodeResource(mp.getResources(),R.mipmap.bullet1);
    }


    public void drawbullet(Canvas canvas) {
        this.canvas = canvas;
        Rect bltsrc1 = new Rect(0, 0, bullet1.getWidth(), bullet1.getHeight());
        Rect bltdst1 = new Rect(x - w, y - h, x + w, y + h);
        canvas.drawBitmap(bullet1, bltsrc1, bltdst1, paint);
    }

    public void move(){
            vy = 5;
            y += vy;
            if(this.y >= 1800){
                bulletArrayList.remove(this);
            }
    }
}
