package adweb.service;

import adweb.model.View;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by zhouyi on 16-6-30.
 */
@Service
public interface AdwebService {

    public int register(String username,String password);

    public int login(String username,String password);

    public String setPortrait(int uid,MultipartFile file);

    public List<View> getActions(int uid,int aid);
}
