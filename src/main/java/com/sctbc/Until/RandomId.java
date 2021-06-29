package com.sctbc.Until;

import java.util.Random;

public class RandomId {
    public static String RuandomID(){
        Random random = new Random();
        int rand=random.nextInt(99999999);
        return String.valueOf(System.currentTimeMillis()-rand);
    }
}
