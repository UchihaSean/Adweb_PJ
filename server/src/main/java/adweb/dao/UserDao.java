package adweb.dao;

import adweb.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by zhouyi on 16-6-30.
 */
@Component
public interface UserDao {
    public int insert(User user);

//    public int updatePortrait(User user);

    public User selectByName(String name);
}
