package adweb.service.impl;

import adweb.Config;
import adweb.dao.Dao;
import adweb.model.Comment;
import adweb.model.Flag;
import adweb.model.User;
import adweb.model.View;
import adweb.service.AdwebService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

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
    public String setPortrait(int uid) {
//        String filename= RandomStringUtils.randomAlphabetic(10);
//        File toSave=new File(Config.RESOURCE_FOLDER+filename);
        String url="";
//            if(toSave.exists())
//                toSave.delete();
//            toSave.createNewFile();
          url="http://img4q.duitang.com/uploads/item/201502/09/20150209203903_ZRyKL.jpeg";
          User user= dao.selectByUid(uid);
            user.setPortrait(url);
            dao.updatePortrait(user);
        return url;
    }

    @Override
    public List<View> getActions(int uid, int aid) {
        HashMap hashMap=new HashMap();
        hashMap.put("uid",uid);
        hashMap.put("aid",aid);
        return dao.selectByUidAndAid(hashMap);
    }
    @Override
    public View getViewInfo(int vid){
        return dao.getViewInfo(vid);
    }
    @Override
    public List<View> getAllView(){
        return dao.getAllView();
    }
    @Override
    public List<View> searchView(int uid,String name){
        HashMap hashMap=new HashMap();
        hashMap.put("uid",uid);
        List<View> listView=new LinkedList<View>();
        listView=dao.searchView(name);
        hashMap.put("vid",listView.get(0).getVid());
        hashMap.put("name",name);
        dao.addSearchView(hashMap);
        return listView;
    }

    public List<HashMap> searchHistory(int uid,int aid){
        if (aid==0)
            return dao.rankOfSearchByCollect(uid);
        else if (aid==1)
            return dao.rankOfSearchByTrack(uid);
        else if (aid==2)
            return dao.rankOfSearchByWish(uid);
        else if (aid==3)
            return dao.rankOfSearchByGrade(uid);
        return null;
    }

    @Override
    public List<HashMap> rankByAction(int category,int aid){
        if (aid==0)
            return dao.rankByCollect(category);
        else if (aid==1)
            return dao.rankByTrack(category);
        else if (aid==2)
            return dao.rankByWish(category);
        else if (aid==3)
            return dao.rankByGrade(category);
        return null;
    }

    @Override
    public HashMap gradeOfView(int vid){
        List<HashMap> star=dao.gradeOfView(vid);
        HashMap star_all=new HashMap();
        Long one_star=(long)0,two_star=(long)0,three_star=(long)0,four_star=(long)0,five_star=(long)0;
        for (int i=0;i<star.size();i++){
            if ((Integer)star.get(i).get("grade")==1){
                one_star=(Long)star.get(i).get("grade_number");
            }
            if ((Integer)star.get(i).get("grade")==2){
                two_star=(Long)star.get(i).get("grade_number");
            }
            if ((Integer)star.get(i).get("grade")==3){
                three_star=(Long)star.get(i).get("grade_number");
            }
            if ((Integer)star.get(i).get("grade")==4){
                four_star=(Long)star.get(i).get("grade_number");
            }
            if ((Integer)star.get(i).get("grade")==5){
                five_star=(Long)star.get(i).get("grade_number");
            }
        }
        double avg_star= (one_star*1+two_star*2+three_star*3+four_star*4+five_star*5+0.0)/(one_star+two_star+three_star+four_star+five_star);
        star_all.put("one_star",one_star);
        star_all.put("two_star",two_star);
        star_all.put("three_star",three_star);
        star_all.put("four_star",four_star);
        star_all.put("five_star",five_star);
        star_all.put("avg_star",avg_star);
//
        return star_all;
    }

    @Override
    public List<HashMap> getAllComments(int vid){
        return dao.getAllComments(vid);
    }

    @Override
    public boolean addAction(int uid,int vid,int aid){
        if (aid==0 || aid==1 || aid==2) {
            HashMap hashMap=new HashMap();
            hashMap.put("uid",uid);
            hashMap.put("vid",vid);
            hashMap.put("aid",aid);
            dao.addAction(hashMap);
            return true;
        }
        return false;
//        return dao.addAction(uid,vid,aid);
    }

    public boolean deleteAction(int uid,int vid,int aid){
        if (aid==0 || aid==1 || aid==2) {
            HashMap hashMap=new HashMap();
            hashMap.put("uid",uid);
            hashMap.put("vid",vid);
            hashMap.put("aid",aid);
            dao.deleteAction(hashMap);
            return true;
        }
        return false;
    }

    @Override
    public List<HashMap> getFlag(int ftype,int vid){
        if (ftype==0){
            return dao.getFlagTypeZero(vid);
        } else if (ftype==1){
            return dao.getFlagTypeOne(vid);

        } else if (ftype==2){
            return dao.getFlagTypeTwo(vid);
        }
        return null;
    }

    @Override
    public boolean addFlag(int fid,int vid,double longitude,double latitude,String addition){
        Flag flag=new Flag(fid,vid,longitude,latitude,addition);
        dao.addFlag(flag);
        return true;
    }

    @Override
    public String setPicture() {
//        String filename= RandomStringUtils.randomAlphabetic(10);
//        File toSave=new File(Config.RESOURCE_FOLDER+filename);
       String filename="http://s11.sinaimg.cn/orignal/48d703704e150311a52ea";
        return filename;
    }

    public boolean addComment(int uid,int vid,int grade,String detail,String url,int type,String addition){
        if (grade==0) return false;
        Comment comment=new Comment(vid,uid,grade,detail,url,type,addition);
        dao.addComment(comment);
        return true;
    }

    public List<HashMap> rankOfNeighbour(int aid,double longitude,double latitude){
        List<HashMap> hashMaps=new LinkedList<HashMap>(),ansMaps=new LinkedList<HashMap>();
        double distance=1;
        if (aid==0)
            hashMaps= dao.rankOfNeighbourByCollect();
        else if (aid==1)
            hashMaps=dao.rankOfNeighbourByTrack();
        else if (aid==2)
            hashMaps=dao.rankOfNeighbourByWish();
        else if (aid==3)
            hashMaps= dao.rankOfNeighbourByGrade();
        else return null;
        System.out.println(hashMaps.size());
        for (int i=0;i<hashMaps.size();i++){
            double nowLong=(Float)hashMaps.get(i).get("longitude");
            double nowLat=(Float)hashMaps.get(i).get("latitude");
            System.out.println(nowLong+" "+nowLat);
            System.out.println(hashMaps.get(i));
            if ((nowLong-longitude)*(nowLong-longitude)+(nowLat-latitude)*(nowLat-latitude)<distance){
                ansMaps.add(hashMaps.get(i));
            }
        }
        return ansMaps;
    }

    public List<View> routeSchedule(String name_x,String name_y){
        List<View> list_view_x=dao.searchView(name_x);
        List<View> list_view_y=dao.searchView(name_y);
        double longitude_x=list_view_x.get(0).getLongitude();
        double latitude_x=list_view_x.get(0).getLatitude();
        double longitude_y=list_view_y.get(0).getLongitude();
        double latitude_y=list_view_y.get(0).getLatitude();
        int x=list_view_x.get(0).getVid();
        int y=list_view_y.get(0).getVid();
        if (longitude_x>longitude_y){
            double longitude=longitude_x;
            longitude_x=longitude_y;
            longitude_y=longitude;
        }
        if (latitude_x>latitude_y){
            double latitude=latitude_x;
            latitude_x=latitude_y;
            latitude_y=latitude;
        }
        List<View> listView=new LinkedList<View>(),ansView=new LinkedList<View>();
        listView=dao.getAllView();
        ansView.add(list_view_x.get(0));
        ansView.add(list_view_y.get(0));
        for (int i=0;i<listView.size();i++){
            if (listView.get(i).getVid()==x) continue;
            if (listView.get(i).getVid()==y) continue;
            double nowLong=(Float)listView.get(i).getLongitude();
            double nowLat=(Float)listView.get(i).getLatitude();

            if ((nowLat>latitude_x-0.1)&&(nowLat<latitude_y+0.1)&&(nowLong>longitude_x-0.1)&&(nowLong<longitude_y+0.1)){
                ansView.add(listView.get(i));
            }
        }
        return ansView;
    }

    public String[] viewArea(int vid){
        HashMap area=dao.viewArea(vid);
        String aa=(String) area.get("scope");
        String[] areas=aa.split(",");
//        for (int i=0;i<areas.length;i++)
//            System.out.println(areas[i]);
        return areas;
    }

    public HashMap recommand(int uid){
        List<HashMap> hashMaps=new LinkedList<HashMap>();
        hashMaps=dao.rankByCollect(0);
        return hashMaps.get(0);
    }

}
