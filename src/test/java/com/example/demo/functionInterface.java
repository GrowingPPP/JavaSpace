package com.example.demo;

public interface functionInterface<T> {
    default void func1(){
        System.out.println("excute func1");
    }
    boolean test(T t);
}
