package dazuoye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.io.File;
import java.net.URI;


public class MyJPanel extends JPanel implements  Runnable, MouseListener {
//static  MyJFrame jf;
    private int x;
    private int y;
    int score;
    boolean gameover;
    int speed=25;
    private List<Black> blacks;

    public MyJPanel(){

       blacks = new ArrayList<>();
       // int dx;
       // int dy;
    }

    @Override
    public void paint(Graphics g) {

        this.setBackground(Color.white);
        super.paint(g);
        // Music();

        for (int i = 0; i <blacks.size(); i++) {
            Black black=blacks.get(i);
            //调用画方法,画出黑块
            black.draw(g);
        }
        //画分数
        g.setColor(Color.BLUE);
        g.setFont(new Font("楷体",Font.BOLD,30));
        g.drawString("分数"+score,200,30);
        //画线
        g.setColor(Color.GRAY);
        g.drawLine(120,0,120,720);
        g.drawLine(240,0,240,720);
        g.drawLine(360,0,360,720);


        if(gameover){
            g.setColor(Color.RED);
            g.setFont(new Font("楷体",Font.BOLD,30));
            g.drawString("抱歉游戏结束!",130,285);
            g.setColor(Color.BLUE);
            g.setFont(new Font("楷体",Font.BOLD,30));
            g.drawString(" 你的分数为: "+score,120,320);


        }
        repaint();
    }

    @Override
    public void run(){
        int count=0;
        while(true) {
            count++;
            if (!gameover) {
                gameover=false;
                //创建黑块
                if (count % 56 == 0) {
                    Black black = new Black();
                    black.x = new Random().nextInt(4) * 120;
                    black.y = -170;
                    blacks.add(black);
                }
                //黑块下移
                for (int i = 0; i < blacks.size(); i++) {
                    Black black = blacks.get(i);
                    black.Move();
                    if (black.y > 600) {
                        gameover=true;
                        blacks.clear();

                    }
                    repaint();
                }
                   repaint();
                try {
                    Thread.sleep((long) speed);            //sleep初始为40（正常速度）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
public void end(){

}

    @Override
    public void mouseClicked(MouseEvent e) {
        int dx=e.getX();
        int dy=e.getY();
        Onclick(dx,dy);
        if(gameover){
            gameover=false;
            score=0;
            blacks.clear();
            repaint();
        }

            //重新来过


    }
   //判断是否点击
    private void Onclick(int dx,int dy) {
        for (int i = 0; i <blacks.size(); i++) {
            Black black=blacks.get(i);
            x=black.x;
            y=black.y;
            //在区域内点击则显示,并加分
            if(dx>x&&dx<x+120&&dy>y&&dy<y+170){
                      blacks.remove(i);
                      score++;
                     speed=speed-1;
            }
            //不能使得速度太快,到达一定值返回接近原来的速度
            if(speed<=6){
                speed=22;
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e)
    {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {

    }



}
