package cn.redu.shoot;
/** 天空 */
public class Sky extends cn.redu.shoot.FlyingObject {
    private int speed; //移动速度
    private int y1;    //第2张天空图的y坐标
    /** 构造方法 */
    public Sky() {
        super(400, 700, 0, 0);
        speed = 1;
        y1 = -World.HEIGHT;
    }
}
















