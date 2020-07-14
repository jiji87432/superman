package com.decorator;

// 毛胚房，这是我们装修工程的基础
public class BlankRoom implements Room {

    @Override
    public String showRoom() {
        return "毛胚房";
    }
}