package demo;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    //声明右侧蛇头和身体图片,该images路径在当前工程目录下
    ImageIcon right = new ImageIcon("images/right.png");
    ImageIcon body = new ImageIcon("images/body.png");

    //第8步,声明上,下,左侧的蛇头图片
    ImageIcon top = new ImageIcon("images/top.png");
    ImageIcon bottom = new ImageIcon("images/bottom.png");
    ImageIcon left = new ImageIcon("images/left.png");


    //第7步申明一个初始值,表示蛇的长度为3
    int len = 3;
    //第7步声明两个数组分别存放x和y坐标的位置
    int[] snakeX = new int[768];//最大值宽度格子(24)*高度格子(32)
    int[] snakeY = new int[768];//最大值宽度格子(24)*高度格子(32)

    //第8步声明一个枚举类型的变量,标识蛇头的方向
    Direction direction = Direction.right;



    //无参构造,快捷键alt+insert
    public MyPanel() {
        //设定蛇的头部和身体的初始位置
        //初始化蛇头,0表示蛇头
        snakeX[0] = 100;
        snakeY[0] = 100;

        //初始化身体
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;

    }

    //重写当前父类画组件方法,快捷键ctrl+o
    //参数g可以看作画笔
    @Override
    protected void paintComponent(Graphics g) {
        //调用父类的方法,做一些基本工作
        super.paintComponent(g);
        //设置背景颜色
        this.setBackground(Color.BLUE);

        //第5步在画布上添加游戏区域,因为要填满整个画布,所以x,y的值为零
        g.fillRect(0,0,600,800);

        //第6步,添加右侧蛇头,this表示当前对象,g为画笔,x,y为蛇头位置坐标
        //第7步,修改参数
        //right.paintIcon(this,g,snakeX[0],snakeY[0]);

        //第8步,根据枚举变量方向的值,进行一个判断,显示哪个方向的蛇头
        switch (direction){
            case top:
                //快捷键:ctrl+shift+下键
                top.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case bottom:
                bottom.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case left:
                left.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case right:
                right.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
        }


        //第6步,添加两个身体
        //body.paintIcon(this,g,75,100);
        //body.paintIcon(this,g,50,100);

        //第7步,修改参数
        for (int i = 1; i < len; i++) {
            body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //第9步,开始提示信息,并设置字体颜色信息和字体
        g.setColor(Color.white);
        g.setFont(new Font("微软雅黑",Font.BOLD,30));
        g.drawString("请按空格键表示游戏开始!",120,600);


    }
}
