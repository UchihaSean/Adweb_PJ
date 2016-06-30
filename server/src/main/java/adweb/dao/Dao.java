package adweb.dao;

import adweb.model.Comment;
import adweb.model.Flag;
import adweb.model.User;
import adweb.model.View;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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

    public List<View> selectByUidAndAid(HashMap hashMap);

    public View getViewInfo(int vid);

    public List<View> getCategoryOfView(int category);

    public List<View> searchView(String name);

    public List<HashMap> rankByCollect();

    public List<HashMap> rankByTrack();

    public List<HashMap> rankByWish();

    public List<HashMap> rankByGrade();

    public List<HashMap> gradeOfView(int vid);

    public List<HashMap> getAllComments(int vid);

    public void addAction(HashMap hashMap);

    public List<HashMap> getFlagTypeZero();

    public List<HashMap> getFlagTypeOne();

    public List<HashMap> getFlagTypeTwo();

    public void addFlag(Flag flag);

    public List<HashMap> getUserCollect(int uid);

    public List<HashMap> getUserWish(int uid);

    public List<HashMap> getUserTrack(int uid);

    public void addComment(Comment comment);
}
