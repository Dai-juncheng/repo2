package Javaday03;

import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.swing.*;

public class MyJFrame1 {
    public static void main(String[] args) {
        JFrame jf=new JFrame();
        jf.setSize(512,765);
        jf.setTitle("star");
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        MyJPanel jp1= new MyJPanel();
        jf.add(jp1);

        Thread thread= new Thread(jp1);
        thread.start();

    }
}
