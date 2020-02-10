package com.tutorialspoint.pojo;


public class HelloWorldImpl implements HelloWorld {
    @Override
    public String greetings(String text) {
        return "Hi " + text;
    }
}
