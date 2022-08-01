package cn.redu.shoot;
/** 英雄机 */
public class Hero extends cn.redu.shoot.FlyingObject {
    private int life; //命
    private int fire; //火力值
    /** 构造方法 */
    public Hero(){
        super(97,139,140,400);
        life = 3;
        fire = 0;
    }
}

















