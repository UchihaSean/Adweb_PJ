package adweb.dao;

import adweb.model.User;
import adweb.model.View;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhouyi on 16-6-30.
 */
@Component
public interface Dao {
    public int insert(User user);

    public int updatePortrait(User user);

    public User selectByName(String name);

    public User selectByUid(int uid);

    public List<View> selectByUidAndAid(int uid,int aid);
}
