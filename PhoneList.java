package Data;

import java.io.Serializable;

public class PhoneList implements Serializable {
    private int id;
    private int phoneNum;
    private String group;
    private String name;
    private String gender;
    private String address;
    private int birthday;
    private String email;
    
    public PhoneList(int id, int phoneNum, String group, String name, String gender, String address, int birthday, String email) {
        this.id=id;
        this.phoneNum = phoneNum;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthday= birthday;
        this.email=email;
    }

    public PhoneList(int number, String group, String name, String gender, String address, int birthday, String email) {
    }

    public int getId(){
        return id;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public int getBirthday(){
        return birthday;
    }

    public String getEmail(){
        return email;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(int birthday){
        this.birthday= birthday;
    }

    public void setEmail(String email){
        this.email= email;
    }
}
