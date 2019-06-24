package com.AAAAAA.pestcontrolproject.util;

import java.util.UUID;

public class GetUUID {

    public static String getUUID(){


        return  UUID.randomUUID().toString().replace("-","");
    }
}
