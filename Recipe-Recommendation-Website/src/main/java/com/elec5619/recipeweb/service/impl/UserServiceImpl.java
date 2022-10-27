package com.elec5619.recipeweb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elec5619.recipeweb.bean.User;
import com.elec5619.recipeweb.mapper.UserMapper;
import com.elec5619.recipeweb.service.IUserService;
import com.elec5619.recipeweb.util.Avatar;
import com.elec5619.recipeweb.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;


/** userService Implementation */
//@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User reg(User user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            return null;
        }

        User result = userMapper.findByUsername(user.getUsername());

        if (result != null){
            return null;
        }

        if(user.getStudentid().length() != 0) {
            user.setRole(0);
        } else {
            user.setRole(1);
        }

        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            return null;
        }

        return userMapper.findByUsername(user.getUsername());
    }

    @Override
    public User login(String username, String password) {

        if (username == null || password == null) {
            return null;
        }

        User result = userMapper.findByUsername(username);

        if (result == null) {
            return null;
        }

        if (!password.equals(result.getPassword())) {
            return null;
        }

        return result;
    }

    @Override
    public String convert(String url) throws InterruptedException{
        Avatar avatar = new Avatar();
        return avatar.getFile(url);
    }

    @Override
    public String press(String url) throws IOException {
        File file = new File(url);
        String fileName = file.getName();
        String output = "D:\\code\\ELEC5620\\Recipe-Recommendation-Website\\src\\main\\webapp\\WEB-INF\\jsp\\ThumbImage\\" + fileName;
        ImageUtil.imgThumb(url,output,150,150);
        return output;
    }

    @Override
    public void saveImage(String url, int uid) {
        User user = new User();
        user.setUid(uid);
        user.setAvatar(url);
        userMapper.updateById(user);
    }
}
