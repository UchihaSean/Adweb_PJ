package adweb.service;

import adweb.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhouyi on 16-6-30.
 */
@Service
public interface UserService {

    public int register(String username,String password);

    public int login(String username,String password);

    public String setPortrait(int uid,MultipartFile file);
}
