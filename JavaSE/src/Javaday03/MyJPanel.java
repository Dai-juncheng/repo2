package Javaday03;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyJPanel extends JPanel implements Runnable {

    private int xx[]=new int[300];
    private int yy[]=new int[300];


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.black);
        //雪花数量
        //xx,yy为随机数，控制雪花的随机出现
        for(int i=0;i<300;i++){
            g.setColor( new Color((int)(Math.random()*0xffffff)));
            g.setFont( new Font("黑体",Font.BOLD,new Random().nextInt(10)+20));
            g.drawString("*",xx[i],yy[i]);
        }
    }

    @Override

    //没0.4s雪花下移一次
    public void run() {
    while (true){
       ;
           //不能dengyu
        for(int i=0;i<yy.length;i++){
         yy[i]++;

         if(yy[i]>765){
             yy[i]=0;
         }

        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         repaint();
    }


    }


}
