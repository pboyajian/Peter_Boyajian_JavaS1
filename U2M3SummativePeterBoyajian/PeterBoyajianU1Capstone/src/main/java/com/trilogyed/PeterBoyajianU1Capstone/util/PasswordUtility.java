package com.trilogyed.PeterBoyajianU1Capstone.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class PasswordUtility {
    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();
        List<String> pwds = new ArrayList<>();
        pwds.add("pwd1");
        pwds.add("pwd2");
        pwds.add("pwd3");
        pwds.add("password");
        pwds.forEach(password-> System.out.println(password+"   :   "+enc.encode(password)));
    }
}
