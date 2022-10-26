package com.elec5619.recipeweb.util;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Avatar {

    public void withCookie(String downloadFilepath, String imagepath) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\AvatarDemo\\Chromedriver\\chromedriver.exe");
        //String downloadFilepath = "f:\\";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://ailab.wondershare.com/app/general/editor/upload?id=181&&code=ct&&fileType=image");
        Cookie c1 = new Cookie("_gcl_au", "1.1.1390598355.1666704208");
        Cookie c2 = new Cookie("_gid", "GA1.2.655010827.1666704208");
        Cookie c3 = new Cookie("_fbp", "=fb.1.1666704209028.46511258");
        Cookie c4 = new Cookie("IR_gbd", "wondershare.com");
        Cookie c5 = new Cookie("lcid", "LC1662349041.1523341");
        Cookie c6 = new Cookie("uts_id", "uts1662349040.79");
        Cookie c7 = new Cookie("sensorsdata2015jssdkcross", "%7B%22distinct_id%22%3A%221840f80d15eb8e-0bd1ff4c33f8fa-26021f51-1327104-1840f80d15f819%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22%24device_id%22%3A%221840f80d15eb8e-0bd1ff4c33f8fa-26021f51-1327104-1840f80d15f819%22%7D");
        Cookie c8 = new Cookie("sajssdk_2015_cross_new_user","1");
        Cookie c9 = new Cookie("sign_identity", "80459e60-45ce-4f74-9128-5c8a089fa8f3");
        Cookie c10 = new Cookie("user_identity", "%7B%22avatar%22%3A%22https%3A%2F%2Flh3.googleusercontent.com%2Fa%2FALm5wu3hSd3y1i4w2Cc4S0jdxvhm0G-OR7HO8X17fGNL%3Ds96-c%22%2C%22email%22%3A%22qing%2A%40gmail.com%22%2C%22first_name%22%3A%22%22%2C%22id%22%3A%22439489416%22%2C%22last_name%22%3A%22%22%2C%22mobile%22%3A%22%22%2C%22nickname%22%3A%22Qing+Kong%22%2C%22t%22%3A%221666707418%22%2C%22vc%22%3A%22d8ee2f181b177e6d2bc586f2701bc734%22%7D");
        Cookie c11 = new Cookie("cus_wid", "439489416");
        Cookie c12 = new Cookie("_dc_gtm_UA-4839360-64", "1");
        Cookie c13 = new Cookie("_ga_24WTSJBD5B", "GS1.1.1666778075.5.0.1666778075.60.0.0");
        Cookie c14 = new Cookie("_ga", "GA1.2.1454601141.1666704208");
        Cookie c15 = new Cookie("_gat_UA-4839360-2", "1");
        Cookie c16 = new Cookie("IR_15586", "1666778076057%7C0%7C1666778076057%7C%7C");
        Cookie c17 = new Cookie("_uetsid", "36a8e780546811edb2a2415579643e5d");
        Cookie c18 = new Cookie("_uetvid", "0baca5602ccc11edb9f8cf1644fbf115");
        Cookie c19 = new Cookie("LCUTS_UID_900133", "900133");
        Cookie c20 = new Cookie("avmws", "1.100840609263156ef185f96818771945.136973993.1666778076.1666778076.1.884818525");
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);
        driver.manage().addCookie(c3);
        driver.manage().addCookie(c4);
        driver.manage().addCookie(c5);
        driver.manage().addCookie(c6);
        driver.manage().addCookie(c7);
        driver.manage().addCookie(c8);
        driver.manage().addCookie(c10);
        driver.manage().addCookie(c11);
        driver.manage().addCookie(c12);
        driver.manage().addCookie(c13);
        driver.manage().addCookie(c14);
        driver.manage().addCookie(c15);
        driver.manage().addCookie(c16);
        driver.manage().addCookie(c17);
        driver.manage().addCookie(c18);
        driver.manage().addCookie(c20);
        driver.get("https://ailab.wondershare.com/app/general/editor/upload?id=181&&code=ct&&fileType=image");
        Thread.sleep(11000);


        driver.findElement(By.cssSelector("#content > article > main > div.os-padding > div > div > div > div > button.upload-btn.bg-edit-control-arguments-wrapper-setting-button.hover\\:bg-edit-control-arguments-wrapper-setting-button-hover.active\\:bg-edit-control-arguments-wrapper-setting-button-press.disable\\:bg-edit-control-arguments-wrapper-setting-button-disable.relative.w-4\\/5.laptop\\:w-2\\/5.py-2.rounded-lg.mt-16.laptop\\:mt-\\[33px\\] > input")).sendKeys(imagepath);
        Thread.sleep(10000);

        driver.findElement(By.cssSelector("#content > article > main > div.os-padding > div > div > div > div.flex.laptop\\:flex.laptop\\:flex-wrap.w-full.laptop\\:editor-args-card.laptop\\:h-full.laptop\\:mr-\\[24px\\].h-1\\/3 > div.flex.flex-col.flex-grow.w-full.w-1\\/2.laptop\\:w-full.h-full.bg-edit-progress-wrapper.laptop\\:rounded-lg.overflow-hidden.laptop\\:h-1\\/2 > div.flex.justify-between.h-12.rounded-b-lg.text-cate-tips-size > button.w-2\\/5.download-btn-image.flex.justify-center.items-center.laptop\\:hidden.bg-edit-control-arguments-wrapper-setting-button.hover\\:bg-edit-control-arguments-wrapper-setting-button-hover.active\\:bg-edit-control-arguments-wrapper-setting-button-press.disable\\:bg-edit-control-arguments-wrapper-setting-button-disable.text-white.disabled\\:cursor-not-allowed")).click();
//        int i = 0;
//        boolean judge = false;
//        while(i < 20){
//            try {
//                judge = driver.findElement(By.cssSelector("#content > article > main > div.os-padding > div > div > div > div.flex.laptop\\:flex.flex-col.w-full.flex-grow.laptop\\:w-\\[590px\\].laptop\\:h-full.flex.h-2\\/3 > div.relative.w-full.h-4\\/5.flex-grow.flex.justify-center.items-center.bg-edit-progress-wrapper.laptop\\:mb-\\[16px\\].rounded-t-lg.laptop\\:rounded-lg > div > div > button")).isEnabled();
//            }catch (Exception e){}
//            if (judge == true){
//                break;
//            }
//            Thread.sleep(10000);
//        }
        Thread.sleep(10000);
        driver.quit();
    }

    public String getFile() throws InterruptedException{
        withCookie("D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\resources\\static\\AnnexImage\\", "D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\resources\\static\\images\\667833bb3dba9fe21ca9c28e43ef29b.jpg");
        String path = "D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\resources\\static\\AnnexImage\\";
        try (Stream<Path> paths = Files.walk(Paths.get(path))){
            List<Path> fileNames = paths
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            return fileNames.get(0).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
