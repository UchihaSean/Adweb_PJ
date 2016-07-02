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

    public String setPortrait(int uid,MultipartFile file);

    public List<View> getActions(int uid,int aid);

    public View getViewInfo(int vid);

    public List<View> getAllView();

    public List<View> searchView(String name);

    public List<HashMap> rankByAction(int category,int aid);

    public HashMap gradeOfView(int vid);

    public List<HashMap> getAllComments(int vid);

    public boolean addAction(int uid,int vid,int aid);

    public List<HashMap> getFlag(int ftype);

    public boolean addFlag(int fid,int vid,double longitude,double latitude,String addition);

    public List<HashMap> getUserAction(int uid,int aid);

    public String setPicture(MultipartFile file);

    public boolean addComment(int uid,int vid,int grade,String detail,String resourceId);

    public List<HashMap> rankOfNeighbour(int aid,double longitude,double latitude);
}
