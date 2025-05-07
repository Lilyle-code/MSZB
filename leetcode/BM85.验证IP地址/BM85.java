package com.nowcoder;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public String solve (String IP){
        if(IP.equals("")) return "Neither";
        if(IP.contains(".")){
            return isIPv4(IP) ? "IPv4" : "Neither";
        }else if(IP.contains(":")){
            return isIPv6(IP) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    public boolean isIPv4(String IP){
        String[] parts = IP.split("\\.", -1);
        if(parts.length != 4) return false;
        for(String part : parts){
            if(part.isEmpty() || part.length() > 3) return false;
            if(part.length() > 1 && part.charAt(0) == '0') return false;
            for(char c : part.toCharArray()){
                if(!Character.isDigit(c)) return false;
            }
            int num = Integer.parseInt(part);
            if(num < 0 || num > 255) return false;
        }
        return true;
    }

    public boolean isIPv6(String IP){
        String[] parts = IP.split(":", -1);
        if(parts.length != 8) return false;
        for(String part : parts){
            if(part.isEmpty() || part.length() > 4) return false;
            for(char c : part.toCharArray()){
                if(!isHexNumber(c)) return false;
            }
        }
        return true;
    }

    public boolean isHexNumber(char c){
        return Character.isDigit(c) || (c >= 'a' && c <='f') || (c >= 'A' && c <='F');
    }
}
