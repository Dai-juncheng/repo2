package dazuoye;

import javax.swing.*;
import java.awt.*;

public class Black extends JPanel {
    int x;
    int y;
    //int time=800;

    //定义化黑块的方法，
 public void draw(Graphics g) {
     //g.setColor( new Color((int)(Math.random()*0xffffff)));  //多彩
  g.setColor(Color.BLACK);
  g.fillRect(x,y,120,170);

    }
   //黑块向下移动属性
    public void Move(){
     y=y+3;


 }
}
