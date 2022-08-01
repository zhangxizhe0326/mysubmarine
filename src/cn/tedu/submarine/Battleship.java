package cn.tedu.submarine;

import javax.swing.ImageIcon;

/** 战舰 */
public class Battleship extends SeaObject {
    private int life;   //命数
    /** 构造方法 */
    public Battleship(){
        super(66,26,270,124,20);
        life = 5;
    }

    /** 重写move()移动 */
    public void move(){
        //暂时搁置
    }

    /** 重写getImage()获取图片 */
    public ImageIcon getImage(){
        return Images.battleship; //返回战舰图片
    }
    //炸弹入场
    public Bomb shootBomb(){
        return new Bomb(this.x,this.y);
    }
    //向左移
    public void moveLeft(){
         x -= speed;//向左移
    }
    //向右移
    public void moveRight(){
        x += speed;//向右移
    }

    public void addLife(int num){
        life += num;
    }
    public int getLife(){
        return life;
    }
}

















