package cn.redu.shoot;

import java.util.Random;

/** 飞行物 */
public class FlyingObject {
    protected int width;  //宽
    protected int height; //高
    protected int x;      //x坐标
    protected int y;      //y坐标
    /** 专门给小敌机、大敌机、小蜜蜂提供的 */
    //因为三种敌人的width/height是不同的，所以数据不能写死，需传参写活
    //因为三种敌人的x/y是相同的，所以数据可以写死，不需要传参
    public FlyingObject(int width,int height){
        this.width = width;
        this.height = height;
        Random rand = new Random(); //随机数对象
        x = rand.nextInt(World.WIDTH-width+1); //0到(窗口宽-敌人宽)之内的随机数
        y = -height; //负的敌人的高
    }

    /** 专门给英雄机、天空、子弹提供的 */
    /** 因为英雄机/天空/子弹的width/height/x/y都是不同的，所以数据都不写死，需传参写活 */
    public FlyingObject(int width,int height,int x,int y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
}


















