package adweb.model;

/**
 * Created by Jly_wave on 6/30/16.
 */
public class Flag {
    private int fid;
    private int vid;
    private double longitude;
    private double latitude;
    private String addition;
    public Flag(int fid,int vid,double longitude,double latitude,String addition){
        this.fid=fid;
        this.vid=vid;
        this.longitude=longitude;
        this.latitude=latitude;
        this.addition=addition;
    }
    public void setFid(int fid){
        this.fid=fid;
    }
    public void setVid(int vid){
        this.vid=vid;
    }
    public void setLongitude(double longitude){
        this.longitude=longitude;
    }
    public void setLatitude(double latitude){
        this.latitude=latitude;
    }
    public void setAddition(String addition){
        this.addition=addition;
    }
    public int getFid(){
        return fid;
    }
    public int getVid(){
        return vid;
    }
    public double getLongitude(){
        return longitude;
    }
    public double getLatitude(){
        return latitude;
    }
    public String getAddition(){
        return addition;
    }
}
