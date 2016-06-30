package adweb.model;

/**
 * Created by zhouyi on 16-6-30.
 */
public class User {
    private int uid;
    private String name;
    private String password;
    private String portrait;

    public User(String name,String password){
        this.name=name;
        this.password=password;
    }

    public User(){

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
