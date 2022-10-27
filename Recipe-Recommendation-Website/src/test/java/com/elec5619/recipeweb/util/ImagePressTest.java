package com.elec5619.recipeweb.util;

import java.io.File;
import java.io.IOException;

public class ImagePressTest {
    public static void main(String[] args) throws IOException {
        String input = "D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\resources\\static\\AnnexImage\\667833bb3dba9fe21ca9c28e43ef29b.jpg";
        File file = new File(input);
        String fileName = file.getName();
        String output = "D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\resources\\static\\ThumbImage\\" + fileName;
//        ImageUtil.imgThumb(input,output,150,150);
        System.out.println(output);
    }
}
