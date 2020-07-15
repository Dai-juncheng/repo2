package dazuoye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends  JFrame{
    private JButton jb,jc;
    private Dialog ta;
    private Label lab;
    private JButton okBut;


    MyJFrame(){
        init();

        this.setTitle("黑与白");
        this.setSize(480,710);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        MyJPanel jp=new MyJPanel();
        this.add(jp);
    }


    private void init() {

        this.setLayout(null);
        jb=new JButton("<html><span color=black>NO</span><html>");
        jb.setFont(new Font("微软雅黑",Font.BOLD,150));
        jb.setFocusPainted(false);
        add(jb);
        jc=new JButton("<html><span color=white >YES</span><html>");
        jc.setFont(new Font("微软雅黑",Font.BOLD,150));
        jc.setFocusPainted(false);
        add(jc);

        jb.setBackground(Color.white);
        jb.setBounds(0,0,480,330);
         //白块提示
        jb.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                       JOptionPane.showMessageDialog(null,"请别踩白块");

                    }
                }
        );

        jc.setBackground(Color.black);
        jc.setBounds(0,330,480,355);
        //黑块监听
        jc.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Music();
                        Music.audio.loop();

                            MmyJFrame my= new MmyJFrame();
                            Main.mj.dispose();
                    }
                }
                );
    }
}
