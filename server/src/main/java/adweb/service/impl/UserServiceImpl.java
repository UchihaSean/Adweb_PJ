package adweb.service.impl;

import adweb.Config;
import adweb.dao.UserDao;
import adweb.model.User;
import adweb.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Random;

/**
 * Created by zhouyi on 16-6-30.
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    public int register(String username, String password) {
        if(userDao.selectByName(username)!=null)
            return -1;//用户已存在
        User user=new User(username,password);
        int success=userDao.insert(user);
        return success==1?user.getUid():-1;//成功或其他错误
    }

    @Override
    public int login(String username, String password) {
        User user=userDao.selectByName(username);
        if(user==null)
            return -1;//用户不存在
        boolean success=user.getPassword().equals(password);
        return success?user.getUid():-2;//成功或者密码错误
    }

    @Override
    public String setPortrait(int uid,MultipartFile file) {
        String filename= RandomStringUtils.randomAlphabetic(10);
        File toSave=new File(Config.RESOURCE_FOLDER+filename);
        try {
            if(toSave.exists())
                toSave.delete();
            toSave.createNewFile();
            file.transferTo(toSave);
            User user=userDao.selectByUid(uid);
            user.setPortrait(filename);
            userDao.updatePortrait(user);
        }catch (Exception e){
            return "-1";
        }
        return filename;
    }
}
