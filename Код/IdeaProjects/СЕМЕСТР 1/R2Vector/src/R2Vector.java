/*
    реализовать метод для вычисления скалярного произведения двух векторов
    и метод для вычисления векторного произведения двух векторов.
    в двух вариантах - как методы класса и как методы экземпляра класса.
*/

import java.util.Scanner;

public class R2Vector {
    // объект – это экземпляр класса
    // переменные экземпляров класса
    private double x, y, z;


    // конструктор (1) – это специальный метод для создания нового объекта данного класса
    public R2Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // конструктор (2)
    public R2Vector() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the coordinate x: ");
        this.x = in.nextDouble();
        System.out.println("Enter the coordinate y: ");
        this.y = in.nextDouble();
        System.out.println("Enter the coordinate z: ");
        this.z = in.nextDouble();
    }

    // метод класса
    public static boolean Equals(R2Vector v1, R2Vector v2) {
        return v1.x == v2.x && v1.y == v2.y && v1.z == v2.z;
    }

    public static double Distance(R2Vector v1, R2Vector v2) {
        return Math.sqrt(Math.pow(v1.x + v2.x, 2) + Math.pow(v1.y + v2.y, 2) + Math.pow(v1.z + v2.z, 2));
    }

    public static double Scalar(R2Vector v1, R2Vector v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }

    public static R2Vector Vector(R2Vector v1, R2Vector v2) {
        return new R2Vector(v1.y * v2.z - v2.y * v1.z, v2.x * v1.z - v1.x * v2.z, v1.x * v2.y - v2.x * v1.y);
    }

    // метод объекта – это метод экземпляра класса
    // метод экземпляра класса
    public boolean Equals(R2Vector v) { return this.x == v.x && this.y == v.y && this.z == v.z; }

    public void Scale(double k) {
        this.x *= k;
        this.y *= k;
        this.z *= k;
    }

    public void print() {
        System.out.printf("x = %4s, y = %4s, z = %4s\n", this.x, this.y, this.z);
    }

    public R2Vector Sum(R2Vector v) {
        return new R2Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public double Distance(R2Vector v) {
        return Math.sqrt(Math.pow(x + v.x, 2) + Math.pow(y + v.y, 2) + Math.pow(z + v.z, 2));
    }

    public double Scalar(R2Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }

    public R2Vector Vector(R2Vector v) {
        return new R2Vector(this.y * v.z - v.y * this.z, v.x * this.z - this.x * v.z, this.x * v.y - v.x * this.y);
    }
}
