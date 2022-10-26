package com.elec5619.recipeweb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.service.IUserService;
import com.elec5619.recipeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * User registration
     *
     * @param user user information
     * @return state_code_OK
     * @author Andy
     */
    @RequestMapping("/reg")
    @ResponseBody
    public JsonResult<User> reg(User user, HttpSession session) {
        User result = userService.reg(user);
        if (result != null) {
            session.setAttribute("uid", result.getUid());
            session.setAttribute("username", result.getUsername());
            return new JsonResult<User>(CODE_OK, "success", result);
        }
        return new JsonResult<>(CODE_FAIL);

    }

    /**
     * User login
     *
     * @param username login username
     * @param password login password
     * @param session  HttpSession
     * @return state_code_OK
     * @author Andy
     */
    @RequestMapping("/login")
    @ResponseBody
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User result = userService.login(username, password);
        if (result != null) {
            session.setAttribute("uid", result.getUid());
            session.setAttribute("username", result.getUsername());

            System.out.println(getUidFromSession(session));
            System.out.println(getUsernameFromSession(session));
            return new JsonResult<User>(CODE_OK, "success", result);
        }
        return new JsonResult<User>(CODE_FAIL);
    }

//    @RequestMapping("/uploadAvatar")
//    @ResponseBody
//    public JsonResult<MultipartFile> uploadAvatar(@RequestPart("file") MultipartFile[] file) throws IOException {
//        System.out.println(file.length);
//        MultipartFile resultFile = file[0];
//        resultFile.transferTo(new File("D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\resources\\static\\images\\" + resultFile.getOriginalFilename()));
//        String url = "D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\resources\\static\\images\\" + resultFile.getOriginalFilename();
//        String imageUrl = userService.convert(url);
//        String narrowImageUrl = userService.press(imageUrl);
//        userService.saveImage(narrowImageUrl);
//        return new JsonResult<MultipartFile>(CODE_OK,"success");
//    }

}

