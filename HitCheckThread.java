package com.example.administrator.thunder;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/2.
 */

public class HitCheckThread extends Thread{
    private MyPlane myPlane;
    private Planes plane;
    private MyBullet bullet0;
    private ArrayList<Planes> planesArrayList;
    public HitCheckThread(MyPlane myPlane,ArrayList<Planes> planesArrayList){
        this.myPlane = myPlane;
        this.planesArrayList = planesArrayList;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0;i<planesArrayList.size();i++){
                plane = planesArrayList.get(i);
                for (int j = 0;j<myPlane.myBulletArrayList.size();j++){
                    bullet0 = myPlane.myBulletArrayList.get(j);
                    if((plane.x+plane.r>=bullet0.x-bullet0.w && plane.y+plane.r>=bullet0.y-bullet0.h)
                            ||(plane.x-plane.r<=bullet0.x+bullet0.w && plane.y+plane.r>=bullet0.y-bullet0.h)
                            ||(plane.x+plane.r>=bullet0.x-bullet0.w && plane.y-plane.r<=bullet0.y+bullet0.h)
                            ||(plane.x-plane.r<=bullet0.x+bullet0.w && plane.y-plane.r<=bullet0.y+bullet0.h)){
                        myPlane.myBulletArrayList.remove(bullet0);
                        planesArrayList.remove(plane);
                        break;
                    }
                }
            }

        }
    }

}
