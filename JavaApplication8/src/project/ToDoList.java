package project;

import java.sql.Timestamp;
import java.util.Date;

public class ToDoList {
    private int id;
    private String name;
    //private boolean ck;
    private int status;
    private String days;
    private int statusId;
    private Date dateDone;

//    public ToDoList(String name,int status,String days,int statusId,int listID,Timestamp date) {
//        this.name = name;
//        //this.ck = ck;
//        this.status = status;
//        this.days = days;
//        this.statusId = statusId;
//        id=listID;
//        if(date!=null){
//            this.dateDone = date;
//        }
//    }

        public ToDoList(int listID,String name,String days) {
            id=listID;
        this.name = name;
        //this.ck = ck;
        this.days = days;

    }
    
    public Date getDateDone() {
        return dateDone;
    }

    public void setDateDone(Date dateDone) {
        this.dateDone = dateDone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    
    
    public String getName() {
        return name;
    }

//    public boolean isCk() {
//        return ck;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setCk(boolean ck) {
//        this.ck = ck;
//    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
    
    
    
}
