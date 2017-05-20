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

        public ToDoList(int listID,String name,String days) {
            id=listID;
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

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
