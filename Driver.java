import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Driver extends JFrame implements Runnable, KeyListener//Other implementables
{
    Container con = getContentPane();
    Thread t = new Thread(this);
    // All variables and objects declared here.
    int x = 406, y = 420, xLoc=-200, yLoc=0, xVel=0, yVel=0, asdf=1, Wx=730;
    int xLoc2 = -200, yLoc2 = 0, xLoc3 = -200, yLoc3 = 0, xVel2 = 0, yVel2 = 0, xVel3 = 0, yVel3 = 0;
    int ctf = 0, ctf2 = 0, ctf3 = 0, ctb = 0, ctb2 = 0, ctb3 = 0, ctl = 0, ctl2 = 0, ctl3 = 0, ctr = 0, ctr2 = 0, ctr3 = 0;
    int bx = -1230, by = 230; 
    int ex = 0, ey = 1000, eyL = 0, endy = -1000;
    int Cx, Cy, hh, ox = 0, oxx = 0;
    boolean endd = false;
    boolean bg = true;
    boolean l = false;
    boolean r = false;
    boolean f = true;
    boolean b = false;
    boolean BR = false;
    boolean BRX = false;
    boolean BRM = false;
    boolean endx = false;
    boolean BM = true;
    boolean CR = false;
    boolean CRO = false;
    boolean bc = false;
    boolean breh = true;
    Random ran;
    int ar1[], ar2[];
    int tX, tY, tVel = 0, hct = 0, tdx, tdy, tt = 0, pct = 0;
    int tX2, tY2, tX3, tY3, tX4, tY4, hX1, hY1, hX2, hY2, hX3, hY3, hY1Vel, hY2Vel, hY3Vel, BX;
    int tx1[], ty1[], tx2[], ty2[], tx3[], ty3[], tx4[], ty4[];
    int hx1[], hy1[], hx2[], hy2[], hx3[], hy3[];
    int etx[], ety[];
    Polygon t1, t2, t3, t4, h1, h2, h3, tree;
    Rectangle isaac, tt1, tt2, tt3, tt4, BB, pr1, pr2, pr3, td, lw, rw, tw, bw, c;
    Clip background, boss, ihurt, ihurtt, ihurtth, ihurtf, ihurto, thurt, thurtt, thurtth, thurtf, thurto, ending, bossdead, itemget, end;
    public Driver()
    {
        con.setLayout(new FlowLayout());
        addKeyListener(this);
        try{
            URL url = this.getClass().getClassLoader().getResource("background.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            background = AudioSystem.getClip();
            background.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("boss.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            boss = AudioSystem.getClip();
            boss.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("ihurt.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            ihurt = AudioSystem.getClip();
            ihurt.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("ihurto.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            ihurto = AudioSystem.getClip();
            ihurto.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("ihurtt.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            ihurtt = AudioSystem.getClip();
            ihurtt.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("ihurtth.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            ihurtth = AudioSystem.getClip();
            ihurtth.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("ihurtf.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            ihurtf = AudioSystem.getClip();
            ihurtf.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("thurt.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            thurt = AudioSystem.getClip();
            thurt.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("thurto.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            thurto = AudioSystem.getClip();
            thurto.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("thurtt.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            thurtt = AudioSystem.getClip();
            thurtt.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("thurtth.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            thurtth = AudioSystem.getClip();
            thurtth.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("thurtf.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            thurtf = AudioSystem.getClip();
            thurtf.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("ending.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            ending = AudioSystem.getClip();
            ending.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("bossdead.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            bossdead = AudioSystem.getClip();
            bossdead.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("itemget.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            itemget = AudioSystem.getClip();
            itemget.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try{
            URL url = this.getClass().getClassLoader().getResource("end.wav");
            AudioInputStream audioln = AudioSystem.getAudioInputStream(url);
            end = AudioSystem.getClip();
            end.open(audioln);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        ar1 = new int[5000];
        ar2 = new int[5000];
        ran = new Random();
        tX = 100;
        tY = 100;
        tX2 = 600;
        tY2 = 600;
        tX3 = 100;
        tY3 = 600;
        tX4 = 600;
        tY4 = 100;
        BX = 600;
        BB = new Rectangle(bx,by,400,340);
        hX1 = 50;
        hY1 = 20;
        hY1Vel = 1000;
        hX2 = 150;
        hY2 = 20;
        hY2Vel = 1000;
        hX3 = 250;
        hY3 = 20;
        hY3Vel = 1000;
        tdx = -350;
        tdy = -350;
        Cx = -1300;
        Cy = -1300;
        etx = new int[] {ex+530,ex+585,ex+620,ex+590, ex+790, ex+770, ex+740, ex+570, ex+530};
        ety = new int[] {ey+1105,ey+1185,ey+1300,ey+1500, ey+1500, ey+1090, ey+1230, ey+1150, ey+1105};
        tree = new Polygon(etx,ety,9);
        ey+=eyL;
        eyL=-5;
        td = new Rectangle(tdx,tdy,100,100);
        isaac = new Rectangle(x-6,y-20,40,80);
        tt1 = new Rectangle(tX,tY,50,60);
        tt2 = new Rectangle(tX2,tY2,50,60);
        tt3 = new Rectangle(tX3,tY3,50,60);
        tt4 = new Rectangle(tX4,tY4,50,60);
        pr1 = new Rectangle(xLoc,yLoc,20,20);
        pr2 = new Rectangle(xLoc2,yLoc2,20,20);
        pr3 = new Rectangle(xLoc3,yLoc3,20,20);
        lw = new Rectangle(0,0,70,800);
        rw = new Rectangle(730,0,70,600);
        tw = new Rectangle(0,0,800,70);
        bw = new Rectangle(0,730,800,70);
        c = new Rectangle(Cx,Cy,60,40);
        int tLoc = 100;
        tLoc+=tVel;
        tx1 = new int[] {tX+25,tX+30,tX+50,tX+45,tX+50,tX+45,tX+37,tX+32,tX+33,tX+20,tX+20,tX+15,tX+11,tX+2,tX,tX+5,tX+10,tX+25};
        ty1 = new int[] {tY+7,tY,tY+5,tY+20,tY+30,tY+40,tY+45,tY+48,tY+60,tY+60,tY+50,tY+50,tY+43,tY+33,tY+20,tY+10,tY+5,tY+7};
        t1 = new Polygon(tx1, ty1, 18);
        tx2 = new int[] {625,630,650,645,650,645,637,632,633,620,620,615,611,602,600,605,610,625};
        ty2 = new int[] {607,600,605,620,630,640,645,648,660,660,650,650,643,633,620,610,605,607};
        t2 = new Polygon(tx2, ty2, 18);
        tx3 = new int[] {125,130,150,145,150,145,137,132,133,120,120,115,111,102,100,105,110,125};
        ty3 = new int[] {607,600,605,620,630,640,645,648,660,660,650,650,643,633,620,610,605,607};
        t3 = new Polygon(tx3, ty3, 18);
        tx4 = new int[] {625,630,650,645,650,645,637,632,633,620,620,615,611,602,600,605,610,625};
        ty4 = new int[] {107,100,105,120,130,140,145,148,160,160,150,150,143,133,120,110,105,107};
        t4 = new Polygon(tx4, ty4, 18);
        hx1 = new int[] {90,100,105,90,75,80,90};
        hy1 = new int[] {55,45,50,70,50,45,55};
        h1 = new Polygon(hx1,hy1,7);
        hx2 = new int[] {135,145,150,135,120,125,135};
        hy2 = new int[] {55,45,50,70,50,45,55};
        h2 = new Polygon(hx2,hy2,7);
        hx3 = new int[] {180,190,195,180,165,170,180};
        hy3 = new int[] {55,45,50,70,50,45,55};
        h3 = new Polygon(hx3,hy3,7);
        hh = 1;

        while (asdf < 5000)
        {
            ar1[asdf] = ran.nextInt(730);
            ar2[asdf] = ran.nextInt(730);
            asdf++;
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        t.start();
    }

    public void run()
    {
        try{
            if (BM)
                background.loop(3);
            while(true)
            {
                t.sleep(67);//Smaller number == faster, larger == slower
                /*
                All motion and collision detection coded here
                 */
                xLoc+=xVel;
                yLoc+=yVel;
                xLoc2+=xVel2;
                yLoc2+=yVel2;
                xLoc3+=xVel3;
                yLoc3+=yVel3;
                ox+=oxx;
                tx1 = new int[] {tX+25,tX+30,tX+50,tX+45,tX+50,tX+45,tX+37,tX+32,tX+33,tX+20,tX+20,tX+15,tX+11,tX+2,tX,tX+5,tX+10,tX+25};
                ty1 = new int[] {tY+7,tY,tY+5,tY+20,tY+30,tY+40,tY+45,tY+48,tY+60,tY+60,tY+50,tY+50,tY+43,tY+33,tY+20,tY+10,tY+5,tY+7};//                 tx2 = new int[] {tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50};
                //                 tx3 = new int[] {tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50};
                //                 tx4 = new int[] {tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50, tVel-50, tVel+50};
                t1 = new Polygon(tx1, ty1, 18);
                //                 t2 = new Polygon(tx2, ty2, 18);
                isaac = new Rectangle(x-6,y-20,40,80);
                pr1 = new Rectangle(xLoc,yLoc,20,20);
                pr2 = new Rectangle(xLoc2,yLoc2,20,20);
                pr3 = new Rectangle(xLoc3,yLoc3,20,20);
                if (isaac.intersects(tt1)||(isaac.intersects(tt2)||(isaac.intersects(tt3)||(isaac.intersects(tt4)||(isaac.intersects(BB))))))
                {
                    if (isaac.intersects(tt1))
                    {
                        y+=30;
                        x+=30;
                    }
                    if (isaac.intersects(tt2))
                    {
                        y-=30;
                        x-=30;
                    }
                    if (isaac.intersects(tt3))
                    {
                        x+=30;
                        y-=30;
                    }
                    if (isaac.intersects(tt4))
                    {
                        x-=30;
                        y+=30;
                    }
                    if (isaac.intersects(BB))
                    {
                        x-=30;
                        y+=30;
                    }
                    if (hct==3)
                    {
                        System.exit(0);
                        ihurt.loop(0);
                        ihurtf.loop(0);
                    }
                    if (hct==2)
                    {
                        hY1+=hY1Vel;
                        hy1 = new int[] {hY1,hY1+50,hY1-50,hY1+1,hY1-1,hY1+1,hY1-1};
                        h1 = new Polygon(hx1,hy1,7);
                        hct++;
                        ihurt.loop(0);
                        ihurto.loop(0);
                    }
                    if (hct==1)
                    {
                        hY2+=hY2Vel;
                        hy2 = new int[] {hY2,hY2+50,hY2-50,hY2+1,hY2-1,hY2+1,hY2-1};
                        h2 = new Polygon(hx2,hy2,7);
                        hct++;
                        ihurt.loop(0);
                        ihurtt.loop(0);
                    }
                    if (hct==0)
                    {
                        hY3+=hY3Vel;
                        hy3 = new int[] {hY3,hY3+50,hY3-50,hY3+1,hY3-1,hY3+1,hY3-1};
                        h3 = new Polygon(hx3,hy3,7);
                        hct++;
                        ihurt.loop(0);
                        ihurtth.loop(0);
                    }
                }
                if (isaac.intersects(td))
                {
                    endx = true;
                }
                if (endx)
                {
                    ey+=eyL;
                    etx = new int[] {ex+500,ex+585,ex+700,ex+698, ex+748, ex+740, ex+765, ex+710, ex+620, ex+500};
                    ety = new int[] {ey+1115,ey+1166,ey+1270,ey+1500, ey+1500, ey+1260, ey+1090, ey+1230, ey+1150, ey+1115};
                    tree = new Polygon(etx,ety,9);
                }
                if (ey<=-800)
                {
                    endd = true;
                }
                if (endd)
                {
                    eyL=0;
                    endy = 650;
                }
                if (pr1.intersects(tt1) || pr2.intersects(tt1) || pr3.intersects(tt1))
                {
                    tX=-5000;
                    tx1 = new int[] {tX+125,tX+130,tX+150,tX+145,tX+150,tX+145,tX+137,tX+132,tX+133,tX+120,tX+120,tX+115,tX+111,tX+102,tX+100,tX+105,tX+110,tX+125};
                    t1 = new Polygon(tx1, ty1, 18);
                    tt1 = new Rectangle(tX,tY,50,60);
                    tt++;
                    thurt.loop(0);
                    thurto.loop(0);
                }
                if (pr1.intersects(tt2) || pr2.intersects(tt2) || pr3.intersects(tt2))
                {
                    tX2=-5000;
                    tx2 = new int[] {tX2+125,tX2+130,tX2+150,tX2+145,tX2+150,tX2+145,tX2+137,tX2+132,tX2+133,tX2+120,tX2+120,tX2+115,tX2+111,tX2+102,tX2+100,tX2+105,tX2+110,tX2+125};
                    t2 = new Polygon(tx2, ty2, 18);
                    tt2 = new Rectangle(tX2,tY2,50,60);
                    tt++;
                    thurt.loop(0);
                    thurtt.loop(0);
                }
                if (pr1.intersects(tt3) || pr2.intersects(tt3) || pr3.intersects(tt3))
                {
                    tX3=-5000;
                    tx3 = new int[] {tX3+125,tX3+130,tX3+150,tX3+145,tX3+150,tX3+145,tX3+137,tX3+132,tX3+133,tX3+120,tX3+120,tX3+115,tX3+111,tX3+102,tX3+100,tX3+105,tX3+110,tX3+125};
                    t3 = new Polygon(tx3, ty3, 18);
                    tt3 = new Rectangle(tX3,tY3,50,60);
                    tt++;
                    thurt.loop(0);
                    thurtth.loop(0);
                }
                if (pr1.intersects(tt4) || pr2.intersects(tt4) || pr3.intersects(tt4))
                {
                    tX4=-5000;
                    tx4 = new int[] {tX4+125,tX4+130,tX4+150,tX4+145,tX4+150,tX4+145,tX4+137,tX4+132,tX4+133,tX4+120,tX4+120,tX4+115,tX4+111,tX4+102,tX4+100,tX4+105,tX4+110,tX4+125};
                    t4 = new Polygon(tx4, ty4, 18);
                    tt4 = new Rectangle(tX4,tY4,50,60);
                    tt++;
                    thurt.loop(0);
                    thurtf.loop(0);
                }
                if (isaac.intersects(c))
                {
                    CRO = true;
                    breh = false;
                }
                repaint();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void paint(Graphics gr)
    {
        Image i=createImage(getSize().width, getSize().height);
        Graphics2D g = (Graphics2D)i.getGraphics();
        //draw stuff here
        g.setColor(new Color(83,57,44));
        g.fillRect(0,0,1000,1000);
        g.setColor(Color.BLACK);
        g.fillRect(20,10,2,800);
        g.fillRect(40,10,2,800);
        g.fillRect(60,10,2,800);
        g.fillRect(90,0,2,800);
        g.fillRect(120,0,2,800);
        g.fillRect(150,0,2,800);
        g.fillRect(180,0,2,800);
        g.fillRect(210,0,2,800);
        g.fillRect(240,0,2,800);
        g.fillRect(270,0,2,800);
        g.fillRect(300,0,2,800);
        g.fillRect(330,0,2,800);
        g.fillRect(360,0,2,800);
        g.fillRect(390,0,2,800);
        g.fillRect(420,0,2,800);
        g.fillRect(450,0,2,800);
        g.fillRect(480,0,2,800);
        g.fillRect(510,0,2,800);
        g.fillRect(540,0,2,800);
        g.fillRect(570,0,2,800);
        g.fillRect(600,0,2,800);
        g.fillRect(630,0,2,800);
        g.fillRect(660,0,2,800);
        g.fillRect(690,0,2,800);
        g.fillRect(720,0,2,800);
        g.fillRect(740,0,2,800);
        g.fillRect(760,0,2,800);
        g.fillRect(780,0,2,800);

        g.fillRect(0,40,800,2);
        g.fillRect(0,55,800,2);
        g.fillRect(0,70,800,2);
        g.fillRect(0,100,800,2);
        g.fillRect(0,130,800,2);
        g.fillRect(0,160,800,2);
        g.fillRect(0,190,800,2);
        g.fillRect(0,220,800,2);
        g.fillRect(0,250,800,2);
        g.fillRect(0,280,800,2);
        g.fillRect(0,310,800,2);
        g.fillRect(0,340,800,2);
        g.fillRect(0,370,800,2);
        g.fillRect(0,400,800,2);
        g.fillRect(0,430,800,2);
        g.fillRect(0,460,800,2);
        g.fillRect(0,490,800,2);
        g.fillRect(0,520,800,2);
        g.fillRect(0,550,800,2);
        g.fillRect(0,580,800,2);
        g.fillRect(0,610,800,2);
        g.fillRect(0,640,800,2);
        g.fillRect(0,670,800,2);
        g.fillRect(0,700,800,2);
        g.fillRect(0,740,800,2);
        g.fillRect(0,755,800,2);
        g.fillRect(0,770,800,2);
        g.fillRect(0,785,800,2);

        g.setColor(new Color(78,45,38));
        g.fillRect(80,80,650,650);
        g.setColor(new Color(83,57,44));
        g.fillRect(Wx,600,70,130);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,80);
        asdf=0;
        while (asdf<2000)
        {
            g.setColor(Color.RED);
            g.fillOval(ar1[asdf], ar2[asdf],3, 2);
            if (ar1[asdf]<80)
                ar1[asdf]=82;
            if (ar1[asdf]>730)
                ar1[asdf]=728;
            if (ar2[asdf]<80)
                ar2[asdf]=82;
            if (ar2[asdf]>730)
                ar2[asdf]=728;
            asdf++;
        }
        if (tt==4)
        {
            g.setColor(Color.BLACK);
            g.fillRect(Wx,600,70,130);
        }

        if (!CR)
        {
            Cx = -1300;
            Cy = -1300;
            c = new Rectangle(Cx,Cy,60,40);
        }

        //CHEST ROOM
        if (CR)
        {
            Cx = 300;
            Cy = 300;
            g.setColor(new Color(83,57,44));
            g.fillRect(0,0,1000,1000);
            g.setColor(Color.BLACK);
            g.fillRect(20,10,2,800);
            g.fillRect(40,10,2,800);
            g.fillRect(60,10,2,800);
            g.fillRect(90,0,2,800);
            g.fillRect(120,0,2,800);
            g.fillRect(150,0,2,800);
            g.fillRect(180,0,2,800);
            g.fillRect(210,0,2,800);
            g.fillRect(240,0,2,800);
            g.fillRect(270,0,2,800);
            g.fillRect(300,0,2,800);
            g.fillRect(330,0,2,800);
            g.fillRect(360,0,2,800);
            g.fillRect(390,0,2,800);
            g.fillRect(420,0,2,800);
            g.fillRect(450,0,2,800);
            g.fillRect(480,0,2,800);
            g.fillRect(510,0,2,800);
            g.fillRect(540,0,2,800);
            g.fillRect(570,0,2,800);
            g.fillRect(600,0,2,800);
            g.fillRect(630,0,2,800);
            g.fillRect(660,0,2,800);
            g.fillRect(690,0,2,800);
            g.fillRect(720,0,2,800);
            g.fillRect(740,0,2,800);
            g.fillRect(760,0,2,800);
            g.fillRect(780,0,2,800);

            g.fillRect(0,40,800,2);
            g.fillRect(0,55,800,2);
            g.fillRect(0,70,800,2);
            g.fillRect(0,100,800,2);
            g.fillRect(0,130,800,2);
            g.fillRect(0,160,800,2);
            g.fillRect(0,190,800,2);
            g.fillRect(0,220,800,2);
            g.fillRect(0,250,800,2);
            g.fillRect(0,280,800,2);
            g.fillRect(0,310,800,2);
            g.fillRect(0,340,800,2);
            g.fillRect(0,370,800,2);
            g.fillRect(0,400,800,2);
            g.fillRect(0,430,800,2);
            g.fillRect(0,460,800,2);
            g.fillRect(0,490,800,2);
            g.fillRect(0,520,800,2);
            g.fillRect(0,550,800,2);
            g.fillRect(0,580,800,2);
            g.fillRect(0,610,800,2);
            g.fillRect(0,640,800,2);
            g.fillRect(0,670,800,2);
            g.fillRect(0,700,800,2);
            g.fillRect(0,740,800,2);
            g.fillRect(0,755,800,2);
            g.fillRect(0,770,800,2);
            g.fillRect(0,785,800,2);
            g.setColor(new Color(78,45,38));
            g.fillRect(80,80,650,650);

            g.setColor(Color.BLACK);
            g.fillRect(Cx-300,Cy+270,80,160);
            g.fillRect(Cx+430,Cy+270,80,160);

            g.setColor(Color.RED);
            g.fillRect(Cx+40,Cy+40,100,100);
            g.setColor(new Color(98,65,58)); //CHEST
            g.fillRect(Cx+60,Cy+75,60,40);
            g.fillArc(Cx+60,365,60,20,0,180);
            g.setColor(Color.BLACK);
            g.fillRect(Cx+60,Cy+80,60,1);
            g.fillRect(Cx+60,Cy+85,60,1);
            g.fillRect(Cx+60,Cy+90,60,1);
            g.fillRect(Cx+60,Cy+95,60,1);
            g.fillRect(Cx+60,Cy+100,60,1);
            g.fillRect(Cx+60,Cy+105,60,1);
            g.fillRect(Cx+60,Cy+110,60,1);
            g.setColor(Color.ORANGE);
            g.fillRect(Cx+60,Cy+76,60,2);
            g.fillRect(Cx+75,Cy+76,2,40);
            g.fillRect(Cx+100,Cy+76,2,40);
            g.fillOval(Cx+80,Cy+80,15,15);
            g.setColor(Color.BLACK);
            g.fillRect(Cx+86,Cy+83,4,10);
            g.fillOval(Cx+83,Cy+82,9,8);
            c = new Rectangle(Cx+60,Cy+60,60,40);
            if (CRO)
            {
                g.setColor(Color.BLACK);
                g.fillRect(Cx+60,Cy+55,60,40);
                g.setColor(new Color(98,65,58)); //CHEST
                g.fillRect(Cx+60,Cy+75,60,40);
                g.setColor(Color.BLACK);
                g.fillRect(Cx+60,Cy+80,60,1);
                g.fillRect(Cx+60,Cy+85,60,1);
                g.fillRect(Cx+60,Cy+90,60,1);
                g.fillRect(Cx+60,Cy+95,60,1);
                g.fillRect(Cx+60,Cy+100,60,1);
                g.fillRect(Cx+60,Cy+105,60,1);
                g.fillRect(Cx+60,Cy+110,60,1);
                g.setColor(Color.ORANGE);
                g.fillRect(Cx+60,Cy+76,60,2);
                g.fillRect(Cx+75,Cy+76,2,40);
                g.fillRect(Cx+100,Cy+76,2,40);
                g.fillOval(Cx+80,Cy+80,15,15);
                g.setColor(Color.BLACK);
                g.fillRect(Cx+86,Cy+83,4,10);
                g.fillOval(Cx+83,Cy+82,9,8);
                oxx = 5;
                g.fillOval(ox,-50,3,3);
            }
        }

        //BOSS ROOM
        if (BR)
        {
            if (hh == 1)
            {
                BM = false;
                background.stop();
                hh++;
            }
            BM = false;
            BRM = true;
            tdx = 350;
            tdy = 350;
            td = new Rectangle(tdx,tdy,100,100);
            g.setColor(new Color(83,57,44));
            g.fillRect(0,0,1000,1000);
            g.setColor(Color.BLACK);
            g.fillRect(20,10,2,800);
            g.fillRect(40,10,2,800);
            g.fillRect(60,10,2,800);
            g.fillRect(90,0,2,800);
            g.fillRect(120,0,2,800);
            g.fillRect(150,0,2,800);
            g.fillRect(180,0,2,800);
            g.fillRect(210,0,2,800);
            g.fillRect(240,0,2,800);
            g.fillRect(270,0,2,800);
            g.fillRect(300,0,2,800);
            g.fillRect(330,0,2,800);
            g.fillRect(360,0,2,800);
            g.fillRect(390,0,2,800);
            g.fillRect(420,0,2,800);
            g.fillRect(450,0,2,800);
            g.fillRect(480,0,2,800);
            g.fillRect(510,0,2,800);
            g.fillRect(540,0,2,800);
            g.fillRect(570,0,2,800);
            g.fillRect(600,0,2,800);
            g.fillRect(630,0,2,800);
            g.fillRect(660,0,2,800);
            g.fillRect(690,0,2,800);
            g.fillRect(720,0,2,800);
            g.fillRect(740,0,2,800);
            g.fillRect(760,0,2,800);
            g.fillRect(780,0,2,800);

            g.fillRect(0,40,800,2);
            g.fillRect(0,55,800,2);
            g.fillRect(0,70,800,2);
            g.fillRect(0,100,800,2);
            g.fillRect(0,130,800,2);
            g.fillRect(0,160,800,2);
            g.fillRect(0,190,800,2);
            g.fillRect(0,220,800,2);
            g.fillRect(0,250,800,2);
            g.fillRect(0,280,800,2);
            g.fillRect(0,310,800,2);
            g.fillRect(0,340,800,2);
            g.fillRect(0,370,800,2);
            g.fillRect(0,400,800,2);
            g.fillRect(0,430,800,2);
            g.fillRect(0,460,800,2);
            g.fillRect(0,490,800,2);
            g.fillRect(0,520,800,2);
            g.fillRect(0,550,800,2);
            g.fillRect(0,580,800,2);
            g.fillRect(0,610,800,2);
            g.fillRect(0,640,800,2);
            g.fillRect(0,670,800,2);
            g.fillRect(0,700,800,2);
            g.fillRect(0,740,800,2);
            g.fillRect(0,755,800,2);
            g.fillRect(0,770,800,2);
            g.fillRect(0,785,800,2);

            g.setColor(new Color(78,45,38));
            g.fillRect(80,80,650,650);
            g.setColor(Color.DARK_GRAY);
            BB = new Rectangle(bx,by,400,340);
            g.fill(BB);

            g.setColor(new Color(142,80,4)); //TRAPDOOR
            g.fillRect(350,350,100,100);
            g.setColor(Color.BLACK);
            g.fillRect(350,360,100,2);
            g.fillRect(350,370,100,2);
            g.fillRect(350,380,100,2);
            g.fillRect(350,390,100,2);
            g.fillRect(350,400,100,2);
            g.fillRect(350,410,100,2);
            g.fillRect(350,420,100,2);
            g.fillRect(350,430,100,2);
            g.fillRect(350,440,100,2);
            g.setColor(new Color(168,167,164));
            g.fillOval(355,355,3,3);
            g.fillOval(355,365,3,3);
            g.fillOval(355,375,3,3);
            g.fillOval(355,385,3,3);
            g.fillOval(355,395,3,3);
            g.fillOval(355,405,3,3);
            g.fillOval(355,415,3,3);
            g.fillOval(355,425,3,3);
            g.fillOval(355,435,3,3);
            g.fillOval(355,445,3,3);
            g.fillOval(442,355,3,3);
            g.fillOval(442,365,3,3);
            g.fillOval(442,375,3,3);
            g.fillOval(442,385,3,3);
            g.fillOval(442,395,3,3);
            g.fillOval(442,405,3,3);
            g.fillOval(442,415,3,3);
            g.fillOval(442,425,3,3);
            g.fillOval(442,435,3,3);
            g.fillOval(442,445,3,3);
            g.setColor(new Color(226,160,4));
            g.fillRect(375,350,5,100);
            g.fillRect(420,350,5,100);
            g.setColor(Color.BLACK);
            g.draw(td);

            g.setColor(new Color(164,144,146));
            g.fillOval(bx,by,400,340);
            g.setColor(Color.BLACK);
            g.fillRect(bx+60,by+90,50,10);
            g.fillRect(bx+280,by+90,50,10);
            g.setColor(new Color(211,152,150));
            g.fillOval(bx+70,by+200,260,100);
            g.setColor(Color.BLACK);
            g.drawOval(bx+70,by+200,260,100);
            g.setColor(Color.WHITE);
            g.fillRect(bx+155,by+200,45,40);
            g.fillRect(bx+200,by+200,45,40);
            g.setColor(Color.BLACK);
            g.drawOval(bx,by,400,340);
            g.drawRect(bx+155,by+200,45,40);
            g.drawRect(bx+200,by+200,45,40);
            g.drawString("Z Z Z", bx+55, by);

            g.setColor(Color.RED);
            g.fillRect(100,95,BX,15);
            if (pr1.intersects(BB))
            {
                BB = new Rectangle(bx,by,400,340);
                BX-=60;
                yLoc+=2000;
            }
            if (pr2.intersects(BB))
            {
                BB = new Rectangle(bx,by,400,340);
                BX-=60;
                yLoc2+=2000;
            }
            if (pr3.intersects(BB))
            {
                BB = new Rectangle(bx,by,400,340);
                BX-=60;
                yLoc3+=2000;
            }
            if (BX<=0)
            {
                BRX = true;
                BRM = false;
            }
            if (BRX)
            {
                bx=2000;
                bossdead.loop(0);
                BRM = false;
            }
            else
                bx = 230;
            if (BRM)
            {
                boss.loop(0);
            }
            if (!BRM)
            {
                boss.setFramePosition(0);
            }
            g.setColor(Color.BLACK);
            g.draw(BB);
        }
        //HEARTS
        g.setColor(Color.RED);
        g.fill(h1);
        g.fill(h2);
        g.fill(h3);

        if (pr1.intersects(tw) || (pr1.intersects(bw) || (pr1.intersects(lw) || (pr1.intersects(rw)))))
            yLoc+=2000;
        if (pr2.intersects(tw) || (pr2.intersects(bw) || (pr2.intersects(lw) || (pr2.intersects(rw)))))
            yLoc2+=2000;
        if (pr3.intersects(tw) || pr3.intersects(bw) || pr3.intersects(lw) || pr3.intersects(rw))
            yLoc3+=2000;

        //ENEMIES
        if (tX<=x)
        {
            tX+=1;
            tx1 = new int[] {tX+25,tX+30,tX+50,tX+45,tX+50,tX+45,tX+37,tX+32,tX+33,tX+20,tX+20,tX+15,tX+11,tX+2,tX,tX+5,tX+10,tX+25};
            t1 = new Polygon(tx1, ty1, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t1);
            tt1 = new Rectangle(tX,tY,50,60);
        }
        if (tX>=x)
        {
            tX-=1; 
            tx1 = new int[] {tX+25,tX+30,tX+50,tX+45,tX+50,tX+45,tX+37,tX+32,tX+33,tX+20,tX+20,tX+15,tX+11,tX+2,tX,tX+5,tX+10,tX+25};
            t1 = new Polygon(tx1, ty1, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t1);
            tt1 = new Rectangle(tX,tY,50,60);
        }
        if (tY<=y)
        {
            tY+=1;
            ty1 = new int[] {tY+7,tY,tY+5,tY+20,tY+30,tY+40,tY+45,tY+48,tY+60,tY+60,tY+50,tY+50,tY+43,tY+33,tY+20,tY+10,tY+5,tY+7};
            t1 = new Polygon(tx1, ty1, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t1);
            tt1 = new Rectangle(tX,tY,50,60);
        }
        if (tY>=y)
        {
            tY-=1;
            ty1 = new int[] {tY+7,tY,tY+5,tY+20,tY+30,tY+40,tY+45,tY+48,tY+60,tY+60,tY+50,tY+50,tY+43,tY+33,tY+20,tY+10,tY+5,tY+7};
            t1 = new Polygon(tx1, ty1, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t1);
            tt1 = new Rectangle(tX,tY,50,60);
        }

        if (tX2<=x)
        {
            tX2+=1;
            tx2 = new int[] {tX2+25,tX2+30,tX2+50,tX2+45,tX2+50,tX2+45,tX2+37,tX2+32,tX2+33,tX2+20,tX2+20,tX2+15,tX2+11,tX2+2,tX2,tX2+5,tX2+10,tX2+25};
            t2 = new Polygon(tx2, ty2, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t2);
            tt2 = new Rectangle(tX2,tY2,50,60);
        }
        if (tX2>=x)
        {
            tX2-=1;
            tx2 = new int[] {tX2+25,tX2+30,tX2+50,tX2+45,tX2+50,tX2+45,tX2+37,tX2+32,tX2+33,tX2+20,tX2+20,tX2+15,tX2+11,tX2+2,tX2,tX2+5,tX2+10,tX2+25};
            t2 = new Polygon(tx2, ty2, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t2);
            tt2 = new Rectangle(tX2,tY2,50,60);
        }
        if (tY2<=y)
        {
            tY2+=1;
            ty2 = new int[] {tY2+7,tY2,tY2+5,tY2+20,tY2+30,tY2+40,tY2+45,tY2+48,tY2+60,tY2+60,tY2+50,tY2+50,tY2+43,tY2+33,tY2+20,tY2+10,tY2+5,tY2+7};
            t2 = new Polygon(tx2, ty2, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t2);
            tt2 = new Rectangle(tX2,tY2,50,60);
        }
        if (tY2>=y)
        {
            tY2-=1;
            ty2 = new int[] {tY2+7,tY2,tY2+5,tY2+20,tY2+30,tY2+40,tY2+45,tY2+48,tY2+60,tY2+60,tY2+50,tY2+50,tY2+43,tY2+33,tY2+20,tY2+10,tY2+5,tY2+7};
            t2 = new Polygon(tx2, ty2, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t2);
            tt2 = new Rectangle(tX2,tY2,50,60);
        }
        // 
        if (tX3<=x)
        {
            tX3+=1;
            tx3 = new int[] {tX3+25,tX3+30,tX3+50,tX3+45,tX3+50,tX3+45,tX3+37,tX3+32,tX3+33,tX3+20,tX3+20,tX3+15,tX3+11,tX3+2,tX3,tX3+5,tX3+10,tX3+25};
            t3 = new Polygon(tx3, ty3, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t3);
            tt3 = new Rectangle(tX3,tY3,50,60);
        }
        if (tX3>=x)
        {
            tX3-=1; 
            tx3 = new int[] {tX3+25,tX3+30,tX3+50,tX3+45,tX3+50,tX3+45,tX3+37,tX3+32,tX3+33,tX3+20,tX3+20,tX3+15,tX3+11,tX3+2,tX3,tX3+5,tX3+10,tX3+25};
            t3 = new Polygon(tx3, ty3, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t3);
            tt3 = new Rectangle(tX3,tY3,50,60);
        }
        if (tY3<=y)
        {
            tY3+=1;
            ty3 = new int[] {tY3+7,tY3,tY3+5,tY3+20,tY3+30,tY3+40,tY3+45,tY3+48,tY3+60,tY3+60,tY3+50,tY3+50,tY3+43,tY3+33,tY3+20,tY3+10,tY3+5,tY3+7};
            t3 = new Polygon(tx3, ty3, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t3);
            tt3 = new Rectangle(tX3,tY3,50,60);
        }
        if (tY3>=y)
        {
            tY3-=1;
            ty3 = new int[] {tY3+7,tY3,tY3+5,tY3+20,tY3+30,tY3+40,tY3+45,tY3+48,tY3+60,tY3+60,tY3+50,tY3+50,tY3+43,tY3+33,tY3+20,tY3+10,tY3+5,tY3+7};
            t3 = new Polygon(tx3, ty3, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t3);
            tt3 = new Rectangle(tX3,tY3,50,60);
        }

        if (tX4<=x)
        {
            tX4+=1;
            tx4 = new int[] {tX4+25,tX4+30,tX4+50,tX4+45,tX4+50,tX4+45,tX4+37,tX4+32,tX4+33,tX4+20,tX4+20,tX4+15,tX4+11,tX4+2,tX4,tX4+5,tX4+10,tX4+25};
            t4 = new Polygon(tx4, ty4, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t4);
            tt4 = new Rectangle(tX4,tY4,50,60);
        }
        if (tX4>x)
        {
            tX4-=1; 
            tx4 = new int[] {tX4+25,tX4+30,tX4+50,tX4+45,tX4+50,tX4+45,tX4+37,tX4+32,tX4+33,tX4+20,tX4+20,tX4+15,tX4+11,tX4+2,tX4,tX4+5,tX4+10,tX4+25};
            t4 = new Polygon(tx4, ty4, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t4);
            tt4 = new Rectangle(tX4,tY4,50,60);
        }
        if (tY4<=y)
        {
            tY4+=1;
            ty4 = new int[] {tY4+7,tY4,tY4+5,tY4+20,tY4+30,tY4+40,tY4+45,tY4+48,tY4+60,tY4+60,tY4+50,tY4+50,tY4+43,tY4+33,tY4+20,tY4+10,tY4+5,tY4+7};
            t4 = new Polygon(tx4, ty4, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t4);
            tt4 = new Rectangle(tX4,tY4,50,60);
        }
        if (tY4>=y)
        {
            tY4-=1;
            ty4 = new int[] {tY4+7,tY4,tY4+5,tY4+20,tY4+30,tY4+40,tY4+45,tY4+48,tY4+60,tY4+60,tY4+50,tY4+50,tY4+43,tY4+33,tY4+20,tY4+10,tY4+5,tY4+7};
            t4 = new Polygon(tx4, ty4, 18);
            g.setColor(new Color(194,164,165));
            g.fill(t4);
            tt4 = new Rectangle(tX4,tY4,50,60);
        }

        //1
        g.setColor(new Color(194,164,165));
        g.fill(t1);
        g.setColor(Color.BLACK);
        g.drawLine(tX+32,tY+48,tX+20,tY+50);
        g.drawLine(tX+26,tY+49,tX+27,tY+60);
        g.fillOval(tX+10,tY+17,10,8); //EYES
        g.fillOval(tX+35,tY+24,9,7);
        g.fillOval(tX+33,tY+8,3,3); //SPOTS
        g.fillOval(tX+6,tY+30,3,3);
        g.fillOval(tX+38,tY+38,3,3);
        g.fillArc(tX+20,tY+30,13,15,-10,180);
        g.setColor(Color.WHITE);
        g.fillOval(tX+12,tY+18,4,3);
        g.fillOval(tX+37,tY+25,3,3);
        g.setColor(new Color(158,207,255));
        g.fillRect(tX+11,tY+25,8,3);
        g.fillRect(tX+36,tY+31,7,4);
        //2
        g.setColor(new Color(194,164,165));
        g.fill(t2);
        g.setColor(Color.BLACK);
        g.drawLine(tX2+32,tY2+48,tX2+20,tY2+50);
        g.drawLine(tX2+26,tY2+49,tX2+27,tY2+60);
        g.fillOval(tX2+10,tY2+17,10,8); //EYES
        g.fillOval(tX2+35,tY2+24,9,7);
        g.fillOval(tX2+33,tY2+8,3,3); //SPOTS
        g.fillOval(tX2+6,tY2+30,3,3);
        g.fillOval(tX2+38,tY2+38,3,3);
        g.fillArc(tX2+20,tY2+30,13,15,-10,180);
        g.setColor(Color.WHITE);
        g.fillOval(tX2+12,tY2+18,4,3);
        g.fillOval(tX2+37,tY2+25,3,3);
        g.setColor(new Color(158,207,255));
        g.fillRect(tX2+11,tY2+25,8,3);
        g.fillRect(tX2+36,tY2+31,7,4);
        //3
        g.setColor(new Color(194,164,165));
        g.fill(t3);
        g.setColor(Color.BLACK);
        g.drawLine(tX3+32,tY3+48,tX3+20,tY3+50);
        g.drawLine(tX3+26,tY3+49,tX3+27,tY3+60);
        g.fillOval(tX3+10,tY3+17,10,8); //EYES
        g.fillOval(tX3+35,tY3+24,9,7);
        g.fillOval(tX3+33,tY3+8,3,3); //SPOTS
        g.fillOval(tX3+6,tY3+30,3,3);
        g.fillOval(tX3+38,tY3+38,3,3);
        g.fillArc(tX3+20,tY3+30,13,15,-10,180);
        g.setColor(Color.WHITE);
        g.fillOval(tX3+12,tY3+18,4,3);
        g.fillOval(tX3+37,tY3+25,3,3);
        g.setColor(new Color(158,207,255));
        g.fillRect(tX3+11,tY3+25,8,3);
        g.fillRect(tX3+36,tY3+31,7,4);
        //4
        g.setColor(new Color(194,164,165));
        g.fill(t4);
        g.setColor(Color.BLACK);
        g.drawLine(tX4+32,tY4+48,tX4+20,tY4+50);
        g.drawLine(tX4+26,tY4+49,tX4+27,tY4+60);
        g.fillOval(tX4+10,tY4+17,10,8); //EYES
        g.fillOval(tX4+35,tY4+24,9,7);
        g.fillOval(tX4+33,tY4+8,3,3); //SPOTS
        g.fillOval(tX4+6,tY4+30,3,3);
        g.fillOval(tX4+38,tY4+38,3,3);
        g.fillArc(tX4+20,tY4+30,13,15,-10,180);
        g.setColor(Color.WHITE);
        g.fillOval(tX4+12,tY4+18,4,3);
        g.fillOval(tX4+37,tY4+25,3,3);
        g.setColor(new Color(158,207,255));
        g.fillRect(tX4+11,tY4+25,8,3);
        g.fillRect(tX4+36,tY4+31,7,4);

        if (f && breh)
        {
            g.setColor(new Color(236,166,239)); //SPRITE FACING FORWARD
            g.fillOval(x-6,y+15,10,20); //ARMS
            g.fillOval(x+24,y+15,10,20); //ARMS
            g.setColor(Color.BLACK);
            g.drawOval(x,y+10,12,50); //LEGS
            g.drawOval(x+16,y+10,12,50); //LEGS
            g.drawOval(x-6,y+15,10,20); //ARMS
            g.drawOval(x+24,y+15,10,20); //ARMS
            g.drawOval(x,y,28,50); //BODY
            g.setColor(new Color(236,166,239));
            g.fillOval(x-6,y-20,40,40); //BODY
            g.fillOval(x,y,28,50); //HEAD
            g.fillOval(x,y+10,12,50); //LEGS
            g.fillOval(x+16,y+10,12,50); //LEGS
            g.setColor(new Color(158,207,255));//                 X = 406, Y = 420
            g.fillRect(x,y,10,14); //TEARS
            g.fillRect(x+18,y,10,14); //TEARS // 400-430, 420-480
            g.setColor(Color.BLACK);
            g.drawOval(x-6,y-20,40,40); //HEAD
            g.fillOval(x-1,y-10,12,12); //EYES
            g.fillOval(x+17,y-10,12,12); //EYES
            g.fillArc(x+7,y+2,13,15,0,180); //MOUTH
            g.setColor(Color.WHITE);
            g.fillRect(x+9,y+7,10,2); //MOUTH
            g.fillOval(x-1,y-8,4,4); //EYE SPARKLE
            g.fillOval(x+19,y-8,4,4); //EYE SPARKLE
        }

        if (b && breh)
        {
            g.setColor(new Color(236,166,239)); //SPRITE FACING BACKWARDS
            g.fillOval(x-6,y+15,10,20); //ARMS
            g.fillOval(x+24,y+15,10,20); //ARMS
            g.setColor(Color.BLACK);
            g.drawOval(x,y+10,12,50); //LEGS
            g.drawOval(x+16,y+10,12,50); //LEGS
            g.drawOval(x-6,y+15,10,20); //ARMS
            g.drawOval(x+24,y+15,10,20); //ARMS
            g.drawOval(x,y,28,50); //BODY
            g.setColor(new Color(236,166,239));
            g.fillOval(x-6,y-20,40,40); //BODY
            g.fillOval(x,y,28,50); //HEAD
            g.fillOval(x,y+10,12,50); //LEGS
            g.fillOval(x+16,y+10,12,50); //LEGS
            g.setColor(Color.BLACK);
            g.drawOval(x-6,y-20,40,40); //HEAD
            g.setColor(new Color(234,137,238));
        }

        if (r && breh)
        {
            g.setColor(new Color(236,166,239)); //SPRITE FACING RIGHT
            g.fillOval(x-6,y+15,10,20); //ARMS
            g.fillOval(x+24,y+15,10,20); //ARMS
            g.setColor(Color.BLACK);
            g.drawOval(x,y+10,12,50); //LEGS
            g.drawOval(x+16,y+10,12,50); //LEGS
            g.drawOval(x-6,y+15,10,20); //ARMS
            g.drawOval(x+24,y+15,10,20); //ARMS
            g.drawOval(x,y,28,50); //BODY
            g.setColor(new Color(236,166,239));
            g.fillOval(x-6,y-20,40,40); //BODY
            g.fillOval(x,y,28,50); //HEAD
            g.fillOval(x,y+10,12,50); //LEGS
            g.fillOval(x+16,y+10,12,50); //LEGS
            g.setColor(Color.BLACK);
            g.drawOval(x-6,y-20,40,40); //HEAD
            g.setColor(new Color(158,207,255));//                 X = 406, Y = 420
            g.fillRect(x+17,y,5,14); //TEARS
            g.setColor(Color.BLACK);
            g.drawOval(x-6,y-20,40,40); //HEAD
            g.fillOval(x+12,y-10,12,12); //EYES
            g.fillArc(x+24,y+2,16,18,90,90); //MOUTH
            g.setColor(Color.WHITE);
            g.fillRect(x+26,y+8,6,2); //MOUTH
            g.fillOval(x+18,y-8,4,4); //EYE SPARKLE
        }
        if (l && breh)
        {
            g.setColor(new Color(236,166,239)); //SPRITE FACING LEFT
            g.fillOval(x-6,y+15,10,20); //ARMS
            g.fillOval(x+24,y+15,10,20); //ARMS
            g.setColor(Color.BLACK);
            g.drawOval(x,y+10,12,50); //LEGS
            g.drawOval(x+16,y+10,12,50); //LEGS
            g.drawOval(x-6,y+15,10,20); //ARMS
            g.drawOval(x+24,y+15,10,20); //ARMS
            g.drawOval(x,y,28,50); //BODY
            g.setColor(new Color(236,166,239));
            g.fillOval(x-6,y-20,40,40); //BODY
            g.fillOval(x,y,28,50); //HEAD
            g.fillOval(x,y+10,12,50); //LEGS
            g.fillOval(x+16,y+10,12,50); //LEGS
            g.setColor(Color.BLACK);
            g.drawOval(x-6,y-20,40,40); //HEAD
            g.setColor(new Color(158,207,255));//                 X = 406, Y = 420
            g.fillRect(x+10,y,5,14); //TEARS
            g.setColor(Color.BLACK);
            g.drawOval(x-6,y-20,40,40); //HEAD
            g.fillOval(x+6,y-10,12,12); //EYES
            g.fillArc(x-7,y+2,16,18,0,90); //MOUTH
            g.setColor(Color.WHITE);
            g.fillRect(x+2,y+8,6,2); //MOUTH
            g.fillOval(x+8,y-8,4,4); //EYE SPARKLE
            g.setColor(new Color(234,137,238));
        }

        if (oxx==5)
        {
            if (ox<300)
            {
                if (f || (b) || (l) || (r) && (!breh))
                {
                    itemget.loop(0);
                    g.setColor(Color.WHITE);
                    g.drawString("You got an item!", x-25,y+75);
                    g.setColor(new Color(212,175,55)); //ITEM
                    g.fillOval(x+7,y-40,15,15);
                    g.setColor(Color.BLACK);
                    g.drawOval(x+9,y-38,11,11);
                    g.drawOval(x+11,y-36,7,7);
                    g.drawOval(x+13,y-34,3,3);

                    g.setColor(new Color(236,166,239)); //SPRITE FACING FORWARD
                    g.fillOval(x-6,y+15,10,20); //ARMS
                    g.fillOval(x+24,y+15,10,20); //ARMS
                    g.setColor(Color.BLACK);
                    g.drawOval(x,y+10,12,50); //LEGS
                    g.drawOval(x+16,y+10,12,50); //LEGS
                    g.drawOval(x-6,y+15,10,20); //ARMS
                    g.drawOval(x+24,y+15,10,20); //ARMS
                    g.drawOval(x,y,28,50); //BODY
                    g.setColor(new Color(236,166,239));
                    g.fillOval(x-6,y-20,40,40); //BODY
                    g.fillOval(x,y,28,50); //HEAD
                    g.fillOval(x,y+10,12,50); //LEGS
                    g.fillOval(x+16,y+10,12,50); //LEGS
                    g.setColor(new Color(158,207,255));//                 X = 406, Y = 420
                    g.fillRect(x,y,10,14); //TEARS
                    g.fillRect(x+18,y,10,14); //TEARS // 400-430, 420-480
                    g.setColor(Color.BLACK);
                    g.drawOval(x-6,y-20,40,40); //HEAD
                    g.fillOval(x-1,y-10,12,12); //EYES
                    g.fillOval(x+17,y-10,12,12); //EYES
                    g.fillArc(x+7,y,13,14,180,180); //MOUTH
                    g.setColor(Color.WHITE);
                    g.fillRect(x+9,y+7,10,2); //MOUTH
                    g.fillOval(x-1,y-8,4,4); //EYE SPARKLE
                    g.fillOval(x+19,y-8,4,4); //EYE SPARKLE
                }
                breh = true;
            }
        }

        g.setColor(new Color(158,207,255));
        g.fillOval(xLoc,yLoc,20,20); //PROJECTILES
        g.fillOval(xLoc2,yLoc2,20,20);
        g.fillOval(xLoc3,yLoc3,20,20);
        if (x>830)
        {
            x = 90;
            CR = true;
        }
        if (x>800 && (CR))
        {
            x = 90;
            BR = true;
            BRM = true;
        }

        if (endx)
        {
            end.loop(0);
            g.setColor(Color.BLACK);
            g.fillRect(ex,ey,800,1000);
            g.setColor(new Color(75,70,96));
            g.fillRect(ex,ey+800,800,800);
            g.setColor(new Color(79,71,95));
            g.fillRect(ex,ey+900,800,800);
            g.setColor(new Color(90,72,90));
            g.fillRect(ex,ey+950,800,800);
            g.setColor(new Color(108,73,84));
            g.fillRect(ex,ey+1000,800,800);
            g.setColor(new Color(120,76,82));
            g.fillRect(ex,ey+1050,800,800);
            g.setColor(new Color(136,76,78));
            g.fillRect(ex,ey+1100,800,800);
            g.setColor(new Color(157,78,72));
            g.fillRect(ex,ey+1100,800,800);
            g.setColor(new Color(159,79,66));
            g.fillRect(ex,ey+1120,800,800);
            g.setColor(new Color(183,82,60));
            g.fillRect(ex,ey+1150,800,800);
            g.setColor(new Color(172,79,59));
            g.fillRect(ex,ey+1200,800,800);
            g.setColor(new Color(186,75,48)); //
            g.fillRect(ex,ey+1250,800,800);
            g.setColor(new Color(192,57,23)); //219,93,17
            g.fillRect(ex,ey+1300,800,800);
            g.setColor(new Color(132,38,6));
            g.fillRect(ex,ey+1350,800,800);
            g.setColor(new Color(119,36,5));
            g.fillRect(ex,ey+1400,800,800);
            g.setColor(new Color(95,26,1));
            g.fillRect(ex,ey+1450,800,800);
            g.fill(tree);
            g.setColor(new Color(7,92,16)); //LAND/TREE
            g.fillOval(ex+500,ey+1420,400,500);
            g.setColor(Color.WHITE);
            g.fillRect(ex+100,ey+939,2,2);
            g.fillRect(ex+427,ey+1045,2,2);
            g.fillRect(ex+78,ey+960,2,2);
            g.fillRect(ex+463,ey+952,2,2);
            g.fillRect(ex+665,ey+1008,2,2);
            g.fillRect(ex+54,ey+1008,2,2);
            g.fillRect(ex+626,ey+1003,2,2);
            g.fillRect(ex+142,ey+1099,2,2);
            g.fillRect(ex+350,ey+815,2,2);
            g.fillRect(ex+340,ey+1031,2,2);
            g.fillRect(ex+512,ey+879,2,2);
            g.fillOval(ex+700,ey+850,50,50);

            g.setColor(new Color(17,49,176)); //LAKE
            g.fillOval(ex,ey+1460,800,100);
            g.setColor(Color.WHITE);
            g.drawOval(ex,ey+1470,800,100);
            g.drawOval(ex,ey+1480,800,100);
            g.drawOval(ex,ey+1490,800,100);
            g.setColor(new Color(70,40,5)); //bottom
            g.fillRect(ex,ey+1500,1000,800);
            g.setColor(new Color(142,80,4));
            g.fillRect(ex+350,ey+1570,100,100);
            g.setColor(new Color(226,160,4));
            g.fillRect(ex+375,ey+1570,5,100);
            g.fillRect(ex+420,ey+1570,5,100);
            g.setColor(Color.WHITE);
            g.drawString("THE END", ex+700,ey+1580);

            g.setColor(new Color(115,5,44)); //SPRITE FACING BACKWARDS
            g.fillOval(500,endy+25,10,30); //ARMS
            g.fillOval(530,endy+25,10,30); //ARMS
            g.setColor(Color.BLACK);
            g.drawOval(500,endy+25,10,30); //ARMS
            g.drawOval(530,endy+25,10,30); //ARMS
            g.setColor(new Color(115,5,44));         //x=406, endy=620
            g.fillOval(500,endy-10,40,40); //BODY
            g.fillOval(506,endy+20,12,50); //LEGS
            g.fillOval(522,endy+20,12,50); //LEGS
            g.setColor(Color.BLACK);
            g.drawOval(500,endy-10,40,40); //HEAD
            g.setColor(new Color(115,5,44));
            g.setColor(Color.BLACK);
            g.drawOval(506,endy+30,12,50); //LEGS
            g.drawOval(522,endy+30,12,50); //LEGS
            g.setColor(new Color(115,5,44));
            g.fillOval(506,endy+20,28,50); //HEAD
            g.fillOval(506,endy+30,12,50); //LEGS
            g.fillOval(522,endy+30,12,50); //LEGS
        }

        if (isaac.intersects(lw))
        {
            x = 80;
            xVel = 10;
        }
        if (isaac.intersects(rw))
        {
            x = 695;
            xVel = -10;
        }
        if (isaac.intersects(tw))
        {
            y = 80;
            yVel = 10;
        }
        if (isaac.intersects(bw))
        {
            y = 660;
            yVel = -10;
        }
        g.dispose();
        gr.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args)
    {
        Driver frame = new Driver();
        JOptionPane.showMessageDialog(null, "You are Isaac, a six year-old boy who was discarded by his mother and tossed down a basement where monsters lurk. You must defeat them with your tears then face the slumbering boss through the door that appears. After that, you can be free! (ARROW KEYS to move, SPACEBAR to shoot)");
        frame.setSize(800, 800);//determines size of screen: Phillips' max is 800, 800
        frame.setVisible(true);
    }

    public void update(Graphics g)
    {
        paint(g);
    } 

    public void keyReleased(KeyEvent k)
    {
        if (k.getKeyCode() == 32)
        {
            if (f)
            {
                if (pct==0)
                {
                    xLoc=x;
                    yLoc=y;
                    if (ctf==0)
                    {
                        yVel+=10;
                        xVel=0;
                        ctf++;
                    }
                    if (ctf==1)
                    {
                        yVel=10;
                        xVel=0;
                        ctf=0;
                    }
                    pct++;
                }
                else if (pct==1)
                {
                    xLoc2=x;
                    yLoc2=y;
                    if (ctf2==0)
                    { 
                        yVel2+=10;
                        xVel2=0;
                        ctf2++;
                    }
                    if (ctf2==1)
                    {
                        yVel2=10;
                        xVel2=0;
                        ctf2=0;
                    }
                    pct++;
                }
                else
                {
                    xLoc3=x;
                    yLoc3=y;
                    if (ctf3==0)
                    {
                        yVel3+=10;
                        xVel3=0;
                        ctf3++;
                    }
                    if (ctf3==1)
                    {
                        yVel3=10;
                        xVel3=0;
                        ctf=0;
                    }
                    pct=0;
                }
            }
            if (b)
            {
                if (pct==0)
                {
                    xLoc=x;
                    yLoc=y;
                    if (ctb==0)
                    {
                        yVel-=10;
                        xVel=0;
                        ctb++;
                    }
                    if (ctb==1)
                    {
                        yVel=-10;
                        xVel=0;
                        ctb=0;
                    }
                    pct++;
                }
                else if (pct==1)
                {
                    xLoc2=x;
                    yLoc2=y;
                    if (ctb2==0)
                    { 
                        yVel2-=10;
                        xVel2=0;
                        ctb2++;
                    }
                    if (ctb2==1)
                    {
                        yVel2=-10;
                        xVel3=0;
                        ctb2=0;
                    }
                    pct++;
                }
                else
                {
                    xLoc3=x;
                    yLoc3=y;
                    if (ctb3==0)
                    {
                        yVel3-=10;
                        xVel3=0;
                        ctb3++;
                    }
                    if (ctb3==1)
                    {
                        yVel3=-10;
                        xVel3=0;
                        ctb=0;
                    }
                    pct=0;
                }
            }
            if (l)
            {
                if (pct==0)
                {
                    xLoc=x;
                    yLoc=y;
                    if (ctb==0)
                    {
                        xVel-=10;
                        yVel=0;
                        ctb++;
                    }
                    if (ctb==1)
                    {
                        xVel=-10;
                        yVel=0;
                        ctb=0;
                    }
                    pct++;
                }
                else if (pct==1)
                {
                    xLoc2=x;
                    yLoc2=y;
                    if (ctb2==0)
                    { 
                        xVel2-=10;
                        yVel2=0;
                        ctb2++;
                    }
                    if (ctb2==1)
                    {
                        xVel2=-10;
                        yVel2=0;
                        ctb2=0;
                    }
                    pct++;
                }
                else
                {
                    xLoc3=x;
                    yLoc3=y;
                    if (ctb3==0)
                    {
                        xVel3-=10;
                        yVel3=0;
                        ctb3++;
                    }
                    if (ctb3==1)
                    {
                        xVel3=-10;
                        yVel3=0;
                        ctb=0;
                    }
                    pct=0;
                }
            }
            if (r)
            {
                if (pct==0)
                {
                    xLoc=x;
                    yLoc=y;
                    if (ctb==0)
                    {
                        xVel+=10;
                        yVel=0;
                        ctb++;
                    }
                    if (ctb==1)
                    {
                        xVel=10;
                        yVel=0;
                        ctb=0;
                    }
                    pct++;
                }
                else if (pct==1)
                {
                    xLoc2=x;
                    yLoc2=y;
                    if (ctb2==0)
                    { 
                        xVel2+=10;
                        yVel2=0;
                        ctb2++;
                    }
                    if (ctb2==1)
                    {
                        xVel2=10;
                        yVel2=0;
                        ctb2=0;
                    }
                    pct++;
                }
                else
                {
                    xLoc3=x;
                    yLoc3=y;
                    if (ctb3==0)
                    {
                        xVel3+=10;
                        yVel3=0;
                        ctb3++;
                    }
                    if (ctb3==1)
                    {
                        xVel3=10;
                        yVel3=0;
                        ctb=0;
                    }
                    pct=0;
                }
            }
        }
    }

    public void keyPressed(KeyEvent k)
    {
        if (k.getKeyCode() == 37)
        {
            x = x - 10;
            l = true;
            r = false;
            b = false;
            f = false;
        }
        if (k.getKeyCode() == 39)
        {
            x = x + 10;
            r = true;
            l = false;
            f = false;
            b = false;
        }

        if (k.getKeyCode() == 38)
        {
            y = y - 10;
            b = true;
            f = false;
            l = false;
            r = false;
        }
        if (k.getKeyCode() == 40)
        {
            y = y + 10;
            f = true;
            b = false;
            l = false;
            r = false;
        }
    }

    public void keyTyped(KeyEvent k)
    {}
}