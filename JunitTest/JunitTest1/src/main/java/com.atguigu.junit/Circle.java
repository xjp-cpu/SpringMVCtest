package com.atguigu.junit;

public class Circle {
    private double radius;
    //private final double PI = 3.14;
    public Circle(){
        radius = 1.0;
    }
    public Circle(double newRadius){
        radius = newRadius;
    }
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double Radius) {
        this.radius = Radius;
    }
}


