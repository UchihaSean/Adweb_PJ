package adweb.model;

/**
 * Created by Jly_wave on 7/1/16.
 */
public class Comment {
    private int cid;
    private int vid;
    private int uid;
    private int grade;
    private String detail;
    private String url;
    private int type;
    private String addition;
    public Comment(int vid,int uid,int grade,String detail,String url,int type,String addition){
        this.vid=vid;
        this.grade=grade;
        this.detail=detail;
        this.uid=uid;
        this.url=url;
        this.type=type;
        this.addition=addition;
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
    public void setUid(int uid){
        this.uid=uid;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public void setType(int type){
        this.type=type;
    }
    public void setAddition(String addition){
        this.addition=addition;
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
    public int getUid(){
        return uid;
    }
    public String getUrl(){
        return url;
    }
    public int getType(){
        return type;
    }
    public String getAddition(){
        return addition;
    }
}
