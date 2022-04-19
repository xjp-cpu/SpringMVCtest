package org.example;

import com.atguigu.junit.Circle;

public class TestCircle {
        public static void main(String[] args) {
            Circle cir1 = new Circle();
            System.out.println("测试默认构造，圆的半径为1.0=："+
                    cir1.getRadius());
            Circle cir2 = new Circle(3.0);
            System.out.println("测试半径为3构造圆，圆的半径3.0=："+
                    cir1.getArea());

            cir1.setRadius(4.0);
            System.out.println("测试setRadius方法，圆的半径为："+
                    cir1.getRadius());
            System.out.println("测试半径为1构造圆，圆的周长为："+
                    cir1.getPerimeter());
            System.out.println("测试半径为1构造圆，圆的面积为："+
                    cir1.getArea());
        }
    }



