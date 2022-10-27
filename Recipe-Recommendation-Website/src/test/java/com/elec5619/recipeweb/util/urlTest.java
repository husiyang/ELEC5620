package com.elec5619.recipeweb.util;

public class urlTest {
    public static void main(String[] args) {
        String url = "D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\resources\\static\\images\\";
        System.out.println(url);
        url = url.replaceAll("\\\\\\\\","\\\\");
        System.out.println(url);
    }
}
