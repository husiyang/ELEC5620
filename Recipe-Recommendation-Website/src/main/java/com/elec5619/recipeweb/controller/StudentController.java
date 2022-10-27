package com.elec5619.recipeweb.controller;

import com.elec5619.recipeweb.bean.Contact;
import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.service.IStudentService;
import com.elec5619.recipeweb.service.IUserService;
import com.elec5619.recipeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController extends BaseController{

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/addfriend")
    @ResponseBody
    public JsonResult<Contact> addFriend(String student_id, HttpSession session){
        int userid = getUidFromSession(session);
        Contact result = studentService.addfriend(student_id, userid);
        if(result != null){
            return new JsonResult<Contact>(CODE_OK, "success");
        }
        return new JsonResult<>(CODE_FAIL);
    }

    @RequestMapping("/friendlist")
    @ResponseBody
    public JsonResult<List<List<String>>> loadFriendList(HttpSession session){
        int userid = getUidFromSession(session);
        List<Contact> contacts = studentService.getFriendList(userid);
        List<User> users = userService.getFriendList(contacts);
        List<List<String>> data = new ArrayList<>();
        for(User u : users){
            String url = u.getAvatar();
            File imageFile = new File(url);
            String fileName = imageFile.getName();
            String relativeUrl = "/ThumbImage/" + fileName;
            String username = u.getUsername();
            String studentid = u.getStudentid();
            List<String> userData = new ArrayList<>();
            userData.add(studentid);
            userData.add(relativeUrl);
            userData.add(username);
            data.add(userData);
        }
        return new JsonResult<List<List<String>>>(CODE_OK,"message", data);
    }
}
