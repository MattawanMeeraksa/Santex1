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

/**
 *
 * @author Administrator
 */
public class Plan {

    private String planName;
    private int dayPerWeek;
    private String description;
    private int totaldays;

    public Plan() {
    }

  
    public String start(int dayPerWeek, int planId) throws ClassNotFoundException, SQLException {
        this.dayPerWeek = dayPerWeek;
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
                    nameDay = "Monday Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Thursday";
                }
                break;
            case 3:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday Wednesday Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Thursday Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Friday Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Saturday Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Sunday Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Monday Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Tuesday Thursday";
                }
                break;
            case 4:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday Tuesday Thursday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Wednesday Friday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Thursday Saturday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Friday Sunday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Saturday Monday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Sunday Tuesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Monday Wednesday Friday";
                }
                break;
            case 5:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday Tuesday Wednesday Friday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Wednesday Thursday Saturday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Thursday Friday Sunday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Friday Saturday Monday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Saturday Sunday Tuesday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Sunday Monday Wednesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Monday Tuesday Thursday Friday";
                }
                break;
            case 6:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday Tuesday Wednesday Thursday Friday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Wednesday Thursday Friday Saturday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Thursday Friday Saturday Sunday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Friday Saturday Sunday Monday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Saturday Sunday Monday Tuesday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Sunday Monday Tuesday Wednesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Monday Tuesday Wednesday Thursday Friday";
                }
                break;
            case 7:
                nameDay =  "Monday Tuesday Wednesday Thursday Friday Saturday Sunday";
                break;
            default:
                nameDay = "The day that you input are more than 7 days or less than 1 day";

        }
        
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set nameDay = ?,dayperweek = ? where planID = ?");
        pstm.setString(1, nameDay);
        pstm.setInt(2, dayPerWeek);
        pstm.setInt(3, planId);
        int rs = pstm.executeUpdate();
        System.out.println(rs);
        return "";
    }

    public ResultSet show() throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from PLAN");
        ResultSet rs = pstm.executeQuery();
        return rs;
    }

    public String create(String planName, String description, int totalDays) throws ClassNotFoundException, SQLException {

        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("insert into PLAN (planName,descriptionPlan,totaldays,dayperweek"
                + ",nameDay) values (?,?,?,?,?)");
        pstm.setString(1, planName);
        pstm.setString(2, description);
        pstm.setInt(3, totalDays);
        pstm.setInt(4, 0);
        pstm.setString(5, "null");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
        return "";
    }

    public void editPlanName(int PlanId, String newPlanName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set planName='"
                + newPlanName + "'where planID ='" + PlanId + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void editDescription(int PlanId, String newDescription) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set descriptionPlan='"
                + newDescription + "' where planID ='" + PlanId + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void editDayPerWeek(int PlanId, int newDayPerWeek) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String nameDay = sdf.format(date);
        switch (newDayPerWeek) {
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
                    nameDay = "Monday Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Thursday";
                }
                break;
            case 3:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday Wednesday Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Thursday Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Friday Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Saturday Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Sunday Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Monday Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Tuesday Thursday";
                }
                break;
            case 4:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday Tuesday Thursday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Wednesday Friday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Thursday Saturday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Friday Sunday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Saturday Monday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Sunday Tuesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Monday Wednesday Friday";
                }
                break;
            case 5:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = " = Monday Tuesday Wednesday Friday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Wednesday Thursday Saturday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = " Wednesday Thursday Friday Sunday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Friday Saturday Monday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Saturday Sunday Tuesday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Sunday Monday Wednesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Monday Tuesday Thursday Friday";
                }
                break;
            case 6:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = "Monday Tuesday Wednesday Thursday Friday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = "Tuesday Wednesday Thursday Friday Saturday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = "Wednesday Thursday Friday Saturday Sunday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = "Thursday Friday Saturday Sunday Monday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = "Friday Saturday Sunday Monday Tuesday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = "Saturday Sunday Monday Tuesday Wednesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = "Sunday Monday Tuesday Wednesday Thursday Friday";
                }
                break;
            case 7:
                nameDay = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday";
                break;
            default:
                nameDay = "The day that you input are more than 7 days or less than 1 day";
        }
        PreparedStatement pstm = conn.prepareStatement("update PLAN set dayperweek ='" + newDayPerWeek + 
                "'where planID ='" + PlanId + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);

    }

    public void editTotalDay(int PlanId, int newDay) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set totaldays='" 
                + newDay + "'where planID ='" + PlanId + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void delete(String planName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("delete from PLAN where planName=?");
        pstm.setString(1, planName);
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getDayPerWeek() {
        return dayPerWeek;
    }

    public void setDayPerWeek(int dayPerWeek) {
        this.dayPerWeek = dayPerWeek;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotaldays() {
        return totaldays;
    }

    public void setTotaldays(int totaldays) {
        this.totaldays = totaldays;
    }
}
