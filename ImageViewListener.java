package com.example.administrator.thunder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/7.
 */
public class ImageViewListener implements View.OnTouchListener {
    private float firstX,firstY,nextX,nextY,tempX,tempY;
    private int action;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;
    private ImageView iv;
    private HandleMessage hm;
    private PlaneThread pt;
    MyPlaneActivity mp;
    ArrayList<Planes> planesArrayList;
    MyPlane myPlane;
    private int touch=0;
    private boolean flag = true,pflag = true;
    private PlaneFactoryThread pft;

    public ImageViewListener(MyPlaneActivity mp,ImageView iv,ArrayList<Planes> planesArrayList){
        this.mp = mp;
        this.iv = iv;
        this.planesArrayList = planesArrayList;
        hm = new HandleMessage(iv);
    }


    public boolean onTouch(View v, MotionEvent event) {
        action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                if(pft == null){
                    pft = new PlaneFactoryThread(mp,iv,planesArrayList);
                    pft.start();
                }
                if(pt == null){
                    myPlane = new MyPlane(mp,planesArrayList) ;
                    myPlane.x = event.getX();
                    myPlane.y = event.getY();
                    pt = new PlaneThread(mp,canvas,bitmap,paint,hm,iv,planesArrayList,this,myPlane);
                    pt.start();
                }
                if(touch ==1){
                    firstX = event.getX();
                    firstY = event.getY();
                }else{
                    nextX = event.getX();
                    nextY = event.getY();
                }
                break;

            case MotionEvent.ACTION_UP:
                touch++;
                break;

            case MotionEvent.ACTION_MOVE:
                if(touch == 1){
                    myPlane.setXY(firstX,firstY);
                }
                else {
                    tempX = event.getX() - nextX;
                    tempY = event.getY() - nextY;
                    nextX = event.getX();
                    nextY = event.getY();
                    if(myPlane.x + tempX<=50){
                        myPlane.setXY(50, myPlane.y + tempY);
                    }
                    else if(myPlane.x + tempX>=iv.getWidth()-50){
                        myPlane.setXY(iv.getWidth()-50, myPlane.y + tempY);
                    }
                    else if(myPlane.y + tempY<=50){
                        myPlane.setXY(myPlane.x + tempX, 50);
                    }
                    else if(myPlane.y + tempY>=iv.getHeight()-50){
                        myPlane.setXY(myPlane.x + tempX, iv.getHeight()-50);
                    }
                    else myPlane.setXY(myPlane.x + tempX, myPlane.y + tempY);
                }
                break;
        }
        //注意这里必须要return true否则将只会出现一次监听，即仅会触发DOWN操作
        return true;
    }

}
