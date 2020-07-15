package dazuoye;

import javax.swing.*;

public class MmyJFrame extends JFrame {

    MmyJFrame(){
        init();
        this.setTitle("别踩白块");
        this.setSize(480,710);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
    }

    private void init() {


        MyJPanel jp=new MyJPanel();

        this.add(jp);



        Thread th=new Thread(jp);
        th.start();



        this.addMouseListener(jp);
        this.requestFocus();
    }


}
