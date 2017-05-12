package com.censhare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class BranchProtectorApplication {

    private static final Logger log = Logger.getLogger(BranchProtectorApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(BranchProtectorApplication.class, args);
    }
}
