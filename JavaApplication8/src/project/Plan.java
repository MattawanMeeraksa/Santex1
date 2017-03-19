/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Plan {

    private String planName;
    private int dayPerWeek;
    private String description;
    private int day;

    public String show() throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from test");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.print("Plan name : ");
            System.out.println(rs.getString("username"));
            System.out.print("Description : ");
            System.out.println(rs.getString("password"));
        }
        return "";
    }

    public String create(String planName, String description) throws ClassNotFoundException, SQLException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String nameDay = sdf.format(date);

        switch (dayPerWeek) {
            case 1:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday";
                }
                break;
            case 2:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Thursday";
                }
                break;
            case 3:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Wednesday, Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Thursday, Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Friday, Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Saturday, Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Sunday, Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Monday, Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Tuesday, Thursday";
                }
                break;
            case 4:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Tuesday, Thursday, Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Wednesday, Friday, Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Thursday, Saturday, Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Friday, Sunday, Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Saturday, Monday, Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Sunday, Tuesday, Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Monday, Wednesday, Friday";
                }
                break;
            case 5:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Tuesday, Wednesday, Friday, Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Wednesday, Thursday, Saturday, Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Thursday, Friday, Sunday, Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Friday, Saturday, Monday, Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Saturday, Sunday, Tuesday, Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Sunday, Monday, Wednesday, Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Monday, Tuesday, Thursday, Friday";
                }
                break;
            case 6:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Tuesday, Wednesday, Thursday, Friday, Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Thursday, Friday, Saturday, Sunday, Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Friday, Saturday, Sunday, Monday, Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Saturday, Sunday, Monday, Tuesday, Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Monday, Tuesday, Wednesday, Thursday, Friday";
                }
                break;
            case 7:
                nameDay = "Monday, Tuesday, Wednesday ,Thursday, Friday, Saturday, Sunday";
                break;
            default:
                nameDay = "The day that you input are more than 7 days or less than 1 day";

        }

        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("insert into test(username,password) values (?,?)");
        pstm.setString(1, planName);
        pstm.setString(2, description);
        int rs = pstm.executeUpdate();
        System.out.println(rs);

        return "--------------Plan name : " + planName + "--------------"
                + "\nThe total day in your plan : " + day + " days"
                + "\nThe day that you have to exercise : " + nameDay;
    }

    //plan name ห้ามเปลี่ยน!!!
    public void editPlanName(String oldPlanName,String newPlanName) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update test set username='" + newPlanName + "'where username ='" + oldPlanName + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editDescription(String oldDescription,String newDescription) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update test set username='" + newDescription + "'where username ='" + oldDescription+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editDayPerWeek(int oldDayPerWeek,int newDayPerWeek) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update test set username='" + newDayPerWeek + "'where username ='" + oldDayPerWeek+ "'");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String nameDay = sdf.format(date);
        switch (dayPerWeek) {
            case 1:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday";
                }
                break;
            case 2:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Thursday";
                }
                break;
            case 3:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Wednesday, Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Thursday, Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Friday, Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Saturday, Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Sunday, Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Monday, Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Tuesday, Thursday";
                }
                break;
            case 4:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Tuesday, Thursday, Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Wednesday, Friday, Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Thursday, Saturday, Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Friday, Sunday, Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Saturday, Monday, Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Sunday, Tuesday, Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Monday, Wednesday, Friday";
                }
                break;
            case 5:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Tuesday, Wednesday, Friday, Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Wednesday, Thursday, Saturday, Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Thursday, Friday, Sunday, Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Friday, Saturday, Monday, Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Saturday, Sunday, Tuesday, Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Sunday, Monday, Wednesday, Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Monday, Tuesday, Thursday, Friday";
                }
                break;
            case 6:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday, Tuesday, Wednesday, Thursday, Friday, Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday, Thursday, Friday, Saturday, Sunday, Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday, Friday, Saturday, Sunday, Monday, Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday, Saturday, Sunday, Monday, Tuesday, Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday, Sunday, Monday, Tuesday, Wednesday, Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday, Monday, Tuesday, Wednesday, Thursday, Friday";
                }
                break;
            case 7:
                nameDay = "Monday, Tuesday, Wednesday ,Thursday, Friday, Saturday, Sunday";
                break;
            default:
                nameDay = "The day that you input are more than 7 days or less than 1 day";

        }
        
        
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editDay(int oldDay,int newDay) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update test set username='" + newDay + "'where username ='" + oldDay + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void delete(String planName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("delete from test where username=?");
        pstm.setString(1, planName);
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
}
