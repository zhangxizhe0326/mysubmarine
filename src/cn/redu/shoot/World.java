package cn.redu.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** 整个游戏窗口 */
public class World extends JPanel {
    public static final int WIDTH = 400;  //窗口的宽
    public static final int HEIGHT = 700; //窗口的高

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH+16,HEIGHT+39);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
















