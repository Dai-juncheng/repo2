package Javaday06;

import javax.swing.*;
import java.awt.*;

public class Ball {
     int x,y;
     int r;
     int type; //飞行的类型
     //运动方向
     int ori;
    //图片，获取取地址
    //子到图片
    public Image img_fire=new ImageIcon("fire.gif").getImage();
    //敌机图片
    public Image img_foe=new ImageIcon("foe.gif").getImage();
    //子弹
    public static final int FIRE =0;
    //敌机
    public static final int FOE =1;
    //向上
    public static final int UP=0;
    //向下
    public static final int DOWN =1;

    public void draw(Graphics g) {
       switch(type){
           case FIRE:
           g.drawImage(img_fire,x,y,r*2,r*2,null);break;
           case FOE:
               g.drawImage(img_foe,x,y,r*2,r*2,null);break;
       }

    }
    //移动上啊下
    public void move(){
       switch(ori){
           case UP:
               y--;break;
           case DOWN:
               y++;break;
    }
    }
   /*相遇方法
   判断 半径对比
   */
   public boolean isTouch(Ball ball){
       int x1=x+r;
       int y1=y+r;

       int x2=ball.x+ball.r;
       int y2=ball.y+ball.r;

       double s = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
       double sr= r+ball.r;
       if(s<=sr){
           return true;
       }
       return  false;
   }

}
