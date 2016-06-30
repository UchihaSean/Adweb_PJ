package adweb.model;

/**
 * Created by zhouyi on 16-6-30.
 */
public class View {

    public static final int CATEGORY_PARK=0;//近代公园
    public static final int CATEGORY_INDUSTRY=1;//工业遗址

    private int vid;
    private int category;
    private String name;
    private float longitude;
    private float latitude;
    private String detail;
    private String picture;


    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
