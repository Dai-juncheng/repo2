package Javaday06;

import javax.swing.*;
import java.awt.*;

public class BallJFrame extends JFrame {




     public void showJF(){
         this.setSize(800,800);
         this.setTitle("one");

         this.setDefaultCloseOperation(3);
         this.setVisible(true);

 }

    public static void main(String[] args) {
        BallJFrame jf = new BallJFrame();
                jf.showJF();
                BallJPanel jp=new BallJPanel();
                jf.add(jp);
                jf.addMouseMotionListener(jp);
                jf.addMouseListener(jp);
                jf.requestFocus();
                jp.starRun();
    }
}
