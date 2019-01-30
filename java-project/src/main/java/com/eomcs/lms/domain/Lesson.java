package com.eomcs.lms.domain;
import java.sql.Date;

public class Lesson implements Cloneable {
  private int no;
  private String title;
  private String contents;
  private Date startDate;
  private Date endDate;
  private int totalHours;
  private int dayHours;
  
  @Override
  public Lesson clone() throws CloneNotSupportedException {
    return (Lesson) super.clone();
  }
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getTotalHours() {
    return totalHours;
  }
  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }
  public int getDayHours() {
    return dayHours;
  }
  public void setDayHours(int dayHours) {
    this.dayHours = dayHours;
  }
  
  public static Lesson valueOf(String line) {
    String[] values = line.split(",");
    Lesson temp = new Lesson();
    temp.setNo(Integer.valueOf(values[0]));
    temp.setTitle(values[1]);
    temp.setContents(values[2]);
    temp.setStartDate(Date.valueOf(values[3]));
    temp.setEndDate(Date.valueOf(values[4]));
    temp.setTotalHours(Integer.valueOf(values[5]));
    temp.setDayHours(Integer.valueOf(values[6]));
    return temp;
    
  }
  
  
}
