package cn.tedu.submarine;

import javax.swing.*;

/** 侦察潜艇 */
public class ObserveSubmarine extends SeaObject implements EnemyScore{
    /** 构造方法 */
    public ObserveSubmarine(){
        super(63,19);
    }

    /** 重写move()移动 */
    public void move(){
        x += speed; //x+(向右)
    }

    /** 重写getImage()获取图片 */
    public ImageIcon getImage(){
        return Images.obsersubm; //返回侦察潜艇图片
    }

    @Override
    public int getScore() {
        return 10;
    }
}



















