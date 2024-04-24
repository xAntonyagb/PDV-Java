package com.mycompany.app.pdv.util;

public class FieldFormatterUtil {
    
    public static String ajustaNumberInput(String input) {
        if(input != null) {
            input = input.replaceAll("[^.\\d]+", "");
        }
        
        return input == null ? "0" : (input.isEmpty() ? "0" : input);
    }
    
}
