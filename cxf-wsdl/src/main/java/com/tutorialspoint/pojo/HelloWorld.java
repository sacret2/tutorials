package com.tutorialspoint.pojo;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String greetings(String text);
}
