package org.example;


public class Main {
    public static void main(String[] args) {
        Interf i1 = new Demo();
        i1.m1();
        //Instead of using Demo class to implement functional intrerface, We can use lambda expressions
        //to implement functional interface
        Interf i2 = ()-> System.out.println("Hello world By Lambda expressions");
        i2.m1();
        //We can remove the Demo class
        //Functional interface is used to provide reference to our lambda expressions
        //Lambda expression is always associated with functional interface
        //We cannot use lambda expression without functional interface

        // Note : Lambda expression does not generate .class file. It is just a method
    }
}