package com.dung2_backend.Utils;

import org.springframework.http.ResponseEntity;

public class Utils {
    public static String responseError(Exception e){
        while (e.getCause()!=null){
            e= (Exception) e.getCause();
        }
        return e.getMessage();
    }
}
