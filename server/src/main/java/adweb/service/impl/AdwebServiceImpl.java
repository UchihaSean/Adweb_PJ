package adweb.service.impl;

import adweb.Config;
import adweb.dao.Dao;
import adweb.model.User;
import adweb.model.View;
import adweb.service.AdwebService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * Created by zhouyi on 16-6-30.
 */
@Service
public class AdwebServiceImpl implements AdwebService {
    @Resource
    private Dao dao;

    @Override
    public int register(String username, String password) {
        if(dao.selectByName(username)!=null)
            return -1;//用户已存在
        User user=new User(username,password);
        int success= dao.insert(user);
        return success==1?user.getUid():-1;//成功或其他错误
    }

    @Override
    public int login(String username, String password) {
        User user= dao.selectByName(username);
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
            User user= dao.selectByUid(uid);
            user.setPortrait(filename);
            dao.updatePortrait(user);
        }catch (Exception e){
            return "-1";
        }
        return filename;
    }

    @Override
    public List<View> getActions(int uid, int aid) {
        return dao.selectByUidAndAid(uid,aid);
    }
}
