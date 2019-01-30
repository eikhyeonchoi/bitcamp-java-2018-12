package com.eomcs.lms.domain;
import java.sql.Date;

public class Member implements Cloneable {
  private int no;
  private String name;
  private String email;
  private String password;
  private String photo;
  private String tel;
  private Date registeredDate;
  
  @Override
  public Member clone() throws CloneNotSupportedException {
    return (Member) super.clone();
  }
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  
  public static Member valueOf(String line) {
    String[] values = line.split(",");
    Member temp = new Member();
    temp.setNo(Integer.valueOf(values[0]));
    temp.setName(values[1]);
    temp.setEmail(values[2]);
    temp.setPassword(values[3]);
    temp.setPhoto(values[4]);
    temp.setTel(values[5]);
    temp.setRegisteredDate(Date.valueOf(values[6]));
    return temp;
    
  }
  
  
}
