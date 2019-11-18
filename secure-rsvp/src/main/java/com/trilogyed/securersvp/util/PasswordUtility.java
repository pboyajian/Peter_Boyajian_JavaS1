package com.trilogyed.securersvp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class PasswordUtility {
    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();
        String password = "password";
        String encodedPassword = enc.encode(password);
        System.out.println(encodedPassword);
//        List<String> pwds = new ArrayList<>();
//        for (int i = 0; i <1000 ; i++) {
//            String pwd=enc.encode(password);
//            pwds.add(pwd.substring(7,pwd.length()));
//        }
//        int numDigits=0;
//        int numLetters=0;
//        int len=pwds.get(1).length();
//        for (String pwd : pwds) {
//            numDigits=0;
//            numLetters=0;
//            for (int i = 0; i < len; i++) {
//                if(Character.isDigit(pwd.charAt(i))){
//                    numDigits++;
//                }else if(Character.isLetter(pwd.charAt(i))){
//                    numLetters++;
//                }
//            }
//            System.out.println("\""+pwd+"|"+numDigits+"|"+numLetters+"|"+(len-numDigits-numLetters)+"\",");
//        }
//    }
    }

}
