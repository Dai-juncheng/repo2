package Javaday06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallJPanel extends JPanel implements MouseListener,MouseMotionListener {
    //英雄几
    private int hx;
    private int hy;
    public Image image = new ImageIcon("hero.gif").getImage();

    //星星坐标
    private int xx[];
    private int yy[];
    //星星大小
    private Font[] fs;
    //无线的敌机
    private List<Ball> fose;

    //无限的子弹
    private List<Ball> fires;

    //是否发射子弹
    public boolean isFire= false;


    public  BallJPanel(){
        hx=420;
        hy=900;
        xx=new int[300];
        yy=new int[300];
        fs = new Font[5];
        //给星星找位置

        for (int i=0;i<xx.length;i++){
            xx[i]=new Random().nextInt(800);
            yy[i]=new Random().nextInt(800);
        }
        for (int i = 0; i <fs.length ; i++) {
            fs[i]=new Font("宋体" ,Font.BOLD,12+i*2);
         }
        //无限的敌机
        fose = new ArrayList<>();
        //无线的子弹
        fires = new ArrayList<>();
        //添加监听
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.black);
       g.drawImage(image,hx,hy,50,50,null );

        //画出星星
        for (int i = 0; i <xx.length ; i++) {
            g.setColor(new Color(new Random().nextInt(0xffffff)));
            g.setFont(fs[new Random().nextInt(5)]);
            g.drawString("*",xx[i],yy[i]);
        }
        repaint();
      //画所有敌机
        for (int i = 0; i <fose.size() ; i++) {
            Ball ball =fose.get(i);
            ball.draw(g);
         }
         //画所有子弹
        for (int i = 0; i <fires.size() ; i++) {
            Ball ball =fires.get(i);
            ball.draw(g);
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
         isFire=true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isFire=false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        hx=e.getX()-20;
        hy=e.getY()-20;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        hx=e.getX()-20;
        hy=e.getY()-20;
        repaint();
    }

   //通过线程控制，实现画板的更新
    public void starRun() {
   Thread thread= new Thread(){

       public void run() {
           int count=0;
           while(true) {
               count++;
               if (count >= Integer.MAX_VALUE) {
                   count = 0;
               }
               try {
                   Thread.sleep(40);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               //生产敌机
               if (count % 60 == 0) {
                   Ball ball = new Ball();
                   ball.x = new Random().nextInt(800);
                   ball.y = 30;
                   ball.r = 20;
                   ball.type = Ball.FOE;
                   ball.ori = Ball.DOWN;
                   fose.add(ball);

               }
//                   repaint();
               //让敌机向下运动
               for (int i = 0; i < fose.size(); i++) {
                   Ball ball = fose.get(i);
                   ball.move();
                   if (ball.y >= 800) {
                       fose.remove(i);
                   }
                  // repaint();
               }
               if (isFire && count % 20 == 0) {
                   Ball ball = new Ball();
                   ball.x = hx + 5;
                   ball.y = hy - 20;
                   ball.r = 20;
                   ball.ori = Ball.UP;
                   ball.type = Ball.FIRE;
                   fires.add(ball);
               }
               for (int i = 0; i < fires.size(); i++) {
                   Ball ball = fires.get(i);
                   ball.move();
                   if (ball.y <= 0) {
                       fires.remove(i);
                   }
                  // repaint();
               }
               // 碰撞判断子弹与敌机
               for (int i = 0; i < fires.size(); i++) {
                   for (int j = 0; j < fose.size(); j++) {
                       if (i < fires.size() && j < fose.size() && fires.get(i).isTouch(fose.get(i))) {
                           fires.remove(i);
                           fose.remove(j);

                       }
                   }
               }
               repaint();

           }//while
       }


   };
 thread.start();
    }
}
