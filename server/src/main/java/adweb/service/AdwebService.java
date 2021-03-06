package adweb.service;

import adweb.model.Flag;
import adweb.model.View;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhouyi on 16-6-30.
 */
@Service
public interface AdwebService {

    public int register(String username,String password);

    public int login(String username,String password);

    public String setPortrait(int uid);

    public List<View> getActions(int uid,int aid);

    public View getViewInfo(int vid);

    public List<View> getAllView();

    public List<View> searchView(int uid,String name);

    public List<HashMap> searchHistory(int uid,int aid);

    public List<HashMap> rankByAction(int category,int aid);

    public HashMap gradeOfView(int vid);

    public List<HashMap> getAllComments(int vid);

    public boolean addAction(int uid,int vid,int aid);

    public boolean deleteAction(int uid,int vid,int aid);

    public List<HashMap> getFlag(int ftype,int vid);

    public boolean addFlag(int fid,int vid,double longitude,double latitude,String addition);


    public String setPicture();

    public boolean addComment(int uid,int vid,int grade,String detail,String url,int type,String addition);

    public List<HashMap> rankOfNeighbour(int aid,double longitude,double latitude);

    public List<View> routeSchedule(String name_x,String name_y);

    public String[] viewArea(int vid);

    public HashMap recommand(int uid);
}
