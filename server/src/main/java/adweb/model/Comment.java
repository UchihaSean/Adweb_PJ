package adweb.model;

/**
 * Created by Jly_wave on 7/1/16.
 */
public class Comment {
    private int cid;
    private int vid;
    private int grade;
    private String detail;
    private String resourceId;
    public Comment(int cid,int vid,int grade,String detail,String resourceId){
        this.cid=cid;
        this.vid=vid;
        this.grade=grade;
        this.detail=detail;
        this.resourceId=resourceId;
    }
    public Comment(){}
    public void setCid(int cid){
        this.cid=cid;
    }
    public void setVid(int vid){
        this.vid=vid;
    }
    public void setGrade(int grade){
        this.grade=grade;
    }
    public void setDetail(String detail){
        this.detail=detail;
    }
    public void setResourceId(String resourceId){
        this.resourceId=resourceId;
    }
    public int getCid(){
        return cid;
    }
    public int getVid(){
        return vid;
    }
    public int getGrade(){
        return grade;
    }
    public String getDetail(){
        return detail;
    }
    public String getResourceId(){
        return resourceId;
    }
}
