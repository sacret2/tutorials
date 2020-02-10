package com.tutorialspoint.helloworld;


import com.tutorialspoint.pojo.HelloWorld;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public String greetings(String text) {
        return "Hi " + text;
    }
}
