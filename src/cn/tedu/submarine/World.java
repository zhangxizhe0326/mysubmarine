package cn.tedu.submarine;
import javax.swing.JFrame;
import javax.swing.JPanel; //1.
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/** 整个窗口世界 */
public class World extends JPanel { //2.
    public static final int WIDTH = 641;  //窗口的宽
    public static final int HEIGHT = 479; //窗口的高
    //如下这一堆对象就是窗口中你所看到的对象了
    private Battleship ship = new Battleship(); //战舰对象
    private SeaObject[] submarines = {}; //潜艇数组
    private Mine[] mines = {}; //水雷数组
    private Bomb[] bombs = {}; //炸弹数组
    private int score;

    /**
     * 随机生成潜艇
     */
    public SeaObject nextSubmarine() {
        Random random = new Random();
        int type = random.nextInt(20);
        if (type < 10) {
            return new ObserveSubmarine();//侦察潜艇
        } else if (type < 15) {
            return new TorpedoSubmarine();//鱼雷潜艇
        } else {
            return new MineSubmarine();//水雷潜艇
        }
    }
    /**
     * 潜艇入场
     */
    private int subEnterIndex = 0;
    private void submarineEnterAction() {
        subEnterIndex++;
        if (subEnterIndex % 40 == 0) {//每过400毫秒走一次
            SeaObject obj = nextSubmarine();
            submarines = Arrays.copyOf(submarines, submarines.length + 1);
            submarines[submarines.length - 1] = obj;
        }
    }
    //水雷入场
    private int MineEnterIndex = 0;
    private void MineEnterAction() {
        MineEnterIndex++;
        if (MineEnterIndex % 100 == 0) {
            for (int i = 0; i < submarines.length; i++) {
                if (submarines[i] instanceof MineSubmarine){
                    MineSubmarine ms =(MineSubmarine) submarines[i];
                    Mine obj = ms.shootMine();
                    mines = Arrays.copyOf(mines,mines.length+1);
                    mines[mines.length-1]=obj;
                }
            }
        }
    }
    //海洋对象移动
    private void moveAction() {
        for (int i = 0; i < submarines.length; i++) {
            submarines[i].move();
        }
        for (int i = 0; i < mines.length; i++) {
            mines[i].move();
        }
        for (int i = 0; i < bombs.length; i++) {
            bombs[i].move();
        }

    }
    //删除越界对象
    private void outOfBoundsAction() {
        for (int i = 0; i < submarines.length; i++) {
            if (submarines[i].isOutOfBounds()){
                submarines[i] =submarines[submarines.length-1];
                submarines = Arrays.copyOf(submarines,submarines.length-1);
            }
        }
        for (int i = 0; i < mines.length; i++){
            if (mines[i].isOutOfBounds()){
                mines[i] = mines[mines.length-1];
                mines = Arrays.copyOf(mines,mines.length-1);
            }
        }
        for (int i = 0; i < bombs.length; i++){
            if (bombs[i].isOutOfBounds()){
                bombs[i] = bombs[bombs.length-1];
                bombs = Arrays.copyOf(bombs,bombs.length-1);
            }
        }
    }
    //炸弹与潜艇的碰撞
    private void bombBangAction() {
        for (int i = 0; i < bombs.length; i++) {
            Bomb b = bombs[i];
            for (int j = 0; j < submarines.length; j++) {
                SeaObject s = submarines[j];
                if (b.isLive() && s.isLive() && s.isHit(b)){
                    s.goDead();
                    b.goDead();
                    //得分得命
                    if (s instanceof EnemyScore){
                        EnemyScore es = (EnemyScore) s;
                        score += es.getScore();
                    }
                    if (s instanceof EnemyLife){
                        EnemyLife el = (EnemyLife) s;
                        int num = el.getLife();
                        ship.addLife(num);
                    }
                }
            }
        }
    }
    //程序启动的运行
    public void action() {
        KeyAdapter k = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Bomb obj = ship.shootBomb();
                    bombs = Arrays.copyOf(bombs, bombs.length + 1);
                    bombs[bombs.length - 1] = obj;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    ship.moveLeft();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    ship.moveRight();
                }
            }
        };//键盘监听
        this.addKeyListener(k);//添加侦听
        Timer timer = new Timer();
        int interval = 10;//每10毫秒自动调用一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                submarineEnterAction();//潜艇入场
                MineEnterAction();//水雷入场
                moveAction();//移动
                bombBangAction();//炸弹与潜艇的碰撞
                outOfBoundsAction();//删除越界海洋对象

                repaint();
            }
        }, interval, interval);
    }



    /** 重写paint()画  g:系统自带的画笔 */
    public void paint(Graphics g){
        Images.sea.paintIcon(null,g,0,0); //画海洋图---不要求掌握
        ship.paintImage(g); //画战舰
        for(int i=0;i<submarines.length;i++){ //遍历所有潜艇
            submarines[i].paintImage(g); //画潜艇
        }
        for(int i=0;i<mines.length;i++){ //遍历所有水雷
            mines[i].paintImage(g); //画水雷
        }
        for(int i=0;i<bombs.length;i++){ //遍历所有炸弹
            bombs[i].paintImage(g); //画炸弹
        }
        g.drawString("SCORE"+score,200,50);
        g.drawString("LIFE"+ship.getLife(),400,50);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame(); //3.
        World world = new World(); //会创建窗口中的那一堆对象
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH+16, HEIGHT+39);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); //系统自动调用paint()方法
        world.action();
    }
}




















