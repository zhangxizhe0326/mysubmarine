package cn.redu.shoot;

import java.util.Random;

/** 小蜜蜂 */
public class Bee extends FlyingObject {
    private int xSpeed; //x坐标移动速度
    private int ySpeed; //y坐标移动速度
    private int awardType; //奖励类型
    /** 构造方法 */
    public Bee(){
        super(60,51);
        xSpeed = 1;
        ySpeed = 2;
        Random rand = new Random(); //随机数对象
        awardType = rand.nextInt(2); //0到1之内的随机数
    }
}












