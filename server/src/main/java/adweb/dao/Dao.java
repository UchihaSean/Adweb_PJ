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

    public List<View> getAllView();

    public List<View> searchView(String name);

    public List<HashMap> rankByCollect(int category);

    public List<HashMap> rankByTrack(int category);

    public List<HashMap> rankByWish(int category);

    public List<HashMap> rankByGrade(int category);

    public List<HashMap> gradeOfView(int vid);

    public List<HashMap> getAllComments(int vid);

    public void addAction(HashMap hashMap);

    public void deleteAction(HashMap hashMap);

    public List<HashMap> getFlagTypeZero();

    public List<HashMap> getFlagTypeOne();

    public List<HashMap> getFlagTypeTwo();

    public void addFlag(Flag flag);

    public void addComment(Comment comment);

    public List<HashMap> rankOfNeighbourByCollect();

    public List<HashMap> rankOfNeighbourByTrack();

    public List<HashMap> rankOfNeighbourByWish();

    public List<HashMap> rankOfNeighbourByGrade();

}
