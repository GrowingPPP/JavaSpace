package com.example.demo;

public class ApplePredicateColor implements functionInterface {
    public boolean test(Apple apple) {
        return apple.getColor().equals(
                "red"
        );
    }

    @Override
    public boolean test(Object o) {
        return false;
    }
}
