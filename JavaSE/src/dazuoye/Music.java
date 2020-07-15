package dazuoye;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class Music {
    static File f1;
    static  URI uri;
    static  URL url;
    static AudioClip audio;

    public    Music(){

        f1=new File("Mine.wav");
        uri=f1.toURI();
        try {
            url=uri.toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        audio= Applet.newAudioClip(url);
        //循环播放


    }

}



