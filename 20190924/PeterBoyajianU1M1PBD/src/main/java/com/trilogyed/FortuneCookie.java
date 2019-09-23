package com.trilogyed;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        Random random=new Random();
        int num= random.nextInt(6)+1;
        String[] fortunes={"You will soon find true love.",
                "Great prosperity is in your future.",
                "Your loyalty will soon pay off.",
                "Disregard previous fortune.",
                "A terrible tragedy awaits you.",
                "Your next meal will be delicious."};
        System.out.println("Fortune cookie says: "+fortunes[num-1]);
        System.out.print("     ");
        for (int i = 0; i < 5; i++) {
            System.out.print((random.nextInt(54)+1)+" - ");
        }
        System.out.println((random.nextInt(54)+1));
    }


}
