package cn.redu.shoot;
/** 子弹 */
public class Bullet extends FlyingObject {
    private int speed; //移动速度
    /** 构造方法 */
    public Bullet(int x,int y){
        super(8,20,x,y);
        speed = 3;
    }
}















