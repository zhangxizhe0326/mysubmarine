package cn.tedu.submarine;

import javax.swing.*;

/** 水雷潜艇 */
public class MineSubmarine extends SeaObject implements EnemyLife{
    /** 构造方法 */
    public MineSubmarine(){
        super(63,19);
    }

    /** 重写move()移动 */
    public void move(){
        x += speed; //x+(向右)
    }

    /** 重写getImage()获取图片 */
    public ImageIcon getImage(){
        return Images.minesubm; //返回水雷潜艇图片
    }

    /**
     * 发射水雷
     */
    public Mine shootMine(){
        int x = this.x+this.width;//潜艇的x+潜艇的宽
        int y = this.y - 11;//潜艇的y - 11
        return new Mine(x,y);
    }

    @Override
    public int getLife() {
        return 1;
    }
}

















