package cn.redu.shoot;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
/** 图片类 */
public class Images {
    public static BufferedImage start;    //启动图
    public static BufferedImage pause;    //暂停图
    public static BufferedImage gameover; //游戏结束图
    public static BufferedImage sky;      //天空图
    public static BufferedImage bullet;   //子弹图
    public static BufferedImage[] heros;  //英雄机图片数组
    public static BufferedImage[] airs;   //小敌机图片数组
    public static BufferedImage[] bairs;  //大敌机图片数组
    public static BufferedImage[] bees;   //小蜜蜂图片数组
    static{ //初始化静态图片
        start = readImage("start.png"); //将start.png读取到start图片中
        pause = readImage("pause.png");
        gameover = readImage("gameover.png");
        sky = readImage("background.png");
        bullet = readImage("bullet.png");
        heros = new BufferedImage[2]; //2张图片
        heros[0] = readImage("hero0.png");
        heros[1] = readImage("hero1.png");
    }

    /** 读取图片  fileName:图片名称 */ //--------不要求掌握
    public static BufferedImage readImage(String fileName){
        try{
            //读取与FlyingObject类在同包中的图片
            BufferedImage img = ImageIO.read(cn.redu.shoot.FlyingObject.class.getResource(fileName)); //读取与FlyingObject同包中的图片
            return img;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}


























