package com.example.demo;

public class ApplePredicateWeight implements functionInterface{
    public boolean test(Apple apple) {
        return apple.getWeight()<2;
    }

    @Override
    public boolean test(Object o) {
        return false;
    }
}
