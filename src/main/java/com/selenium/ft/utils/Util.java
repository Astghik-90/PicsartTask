package com.selenium.ft.utils;

public class Util {

    public static void sleep(int timeout) {
        try{
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
