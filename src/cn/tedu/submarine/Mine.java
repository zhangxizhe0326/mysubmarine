package cn.tedu.submarine;

import javax.swing.*;

/** 水雷 */
public class Mine extends SeaObject {
    /** 构造方法 */
    public Mine(int x,int y){
        super(11,11,x,y,1); //传递的是x与y的值
    }

    /** 重写move()移动 */
    public void move(){
        y -= speed; //y-(向上)
    }

    /** 重写getImage()获取图片 */
    public ImageIcon getImage(){
        return Images.mine; //返回水雷图片
    }
    public boolean isOutOfBounds(){
        return this.y <= 150-this.height;
    }
}


















