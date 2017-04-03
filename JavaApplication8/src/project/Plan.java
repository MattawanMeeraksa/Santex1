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
import java.util.ArrayList;
import java.util.List;
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
    private int totaldays;

    public Plan() {
    }

    public String start(int dayPerWeek) throws ClassNotFoundException, SQLException {
        this.dayPerWeek = dayPerWeek;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String nameDay = sdf.format(date);

        switch (dayPerWeek) {
            case 1:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 1 + " = Monday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 1 + " = Tuesday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 1 + " = Wednesday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 1 + " = Thursday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 1 + " = Friday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 1 + " = Saturday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 1 + " = Sunday";
                }
                break;
            case 2:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 2 + " = Monday Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 2 + " = Tuesday Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 2 + " = Wednesday Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 2 + " = Thursday Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 2 + " = Friday Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 2 + " = Saturday Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 2 + " = Sunday Thursday";
                }
                break;
            case 3:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 3 + " = Monday Wednesday Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 3 + " = Tuesday Thursday Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 3 + " = Wednesday Friday Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 3 + " = Thursday Saturday Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 3 + " = Friday Sunday Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 3 + " = Saturday Monday Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 3 + " = Sunday Tuesday Thursday";
                }
                break;
            case 4:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 4 + " = Monday Tuesday Thursday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 4 + " = Tuesday Wednesday Friday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 4 + " = Wednesday Thursday Saturday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 4 + " = Thursday Friday Sunday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 4 + " = Friday Saturday Monday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 4 + " = Saturday Sunday Tuesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 4 + " = Sunday Monday Wednesday Friday";
                }
                break;
            case 5:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 5 + " = Monday Tuesday Wednesday Friday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 5 + " = Tuesday Wednesday Thursday Saturday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 5 + " = Wednesday Thursday Friday Sunday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 5 + " = Thursday Friday Saturday Monday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 5 + " = Friday Saturday Sunday Tuesday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 5 + " = Saturday Sunday Monday Wednesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 5 + " = Sunday Monday Tuesday Thursday Friday";
                }
                break;
            case 6:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 6 + " = Monday Tuesday Wednesday Thursday Friday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 6 + " = Tuesday Wednesday Thursday Friday Saturday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 6 + " = Wednesday Thursday Friday Saturday Sunday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 6 + " = Thursday Friday Saturday Sunday Monday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 6 + " = Friday Saturday Sunday Monday Tuesday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 6 + " = Saturday Sunday Monday Tuesday Wednesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 6 + " = Sunday Monday Tuesday Wednesday Thursday Friday";
                }
                break;
            case 7:
                nameDay = 7 + " = Monday Tuesday Wednesday Thursday Friday Saturday Sunday";
                break;
            default:
                nameDay = "The day that you input are more than 7 days or less than 1 day";

        }

        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("insert into PLAN (dayperweek,nameDay) values (?,?)");
        pstm.setInt(1, dayPerWeek);
        pstm.setString(2, nameDay);

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
        pstm.setString(5, null);
        pstm.setString(5, "null");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
        return "";
    }

    public void editAll(String oldPlanName, String newPlanName, String newDescription, int totalDays) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set planName='" + newPlanName
                + "' where planName ='" + oldPlanName + "'");
        pstm = conn.prepareStatement("update PLAN set planName='"
                + newPlanName + "' where planName ='" + oldPlanName + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void editPlanName(String oldPlanName, String newPlanName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set planName='"
                + newPlanName + "'where planName ='" + oldPlanName + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void editDescription(String oldDescription, String newDescription) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set descriptionPlan='"
                + newDescription + "' where descriptionPlan ='" + oldDescription + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void editDayPerWeek(int oldDayPerWeek, int newDayPerWeek) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String nameDay = sdf.format(date);
        switch (newDayPerWeek) {
            case 1:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 1 + " = Monday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 1 + " = Tuesday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 1 + " = Wednesday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 1 + " = Thursday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 1 + " = Friday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 1 + " = Saturday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 1 + " = Sunday";
                }
                break;
            case 2:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 2 + " = Monday Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 2 + " = Tuesday Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 2 + " = Wednesday Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 2 + " = Thursday Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 2 + " = Friday Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 2 + " = Saturday Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 2 + " = Sunday Thursday";
                }
                break;
            case 3:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 3 + " = Monday Wednesday Friday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 3 + " = Tuesday Thursday Saturday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 3 + " = Wednesday Friday Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 3 + " = Thursday Saturday Monday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 3 + " = Friday Sunday Tuesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 3 + " = Saturday Monday Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 3 + " = Sunday Tuesday Thursday";
                }
                break;
            case 4:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 4 + " = Monday Tuesday Thursday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 4 + " = Tuesday Wednesday Friday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 4 + " = Wednesday Thursday Saturday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 4 + " = Thursday Friday Sunday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 4 + " = Friday Saturday Monday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 4 + " = Saturday Sunday Tuesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 4 + " = Sunday Monday Wednesday Friday";
                }
                break;
            case 5:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 5 + " = Monday Tuesday Wednesday Friday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 5 + " = Tuesday Wednesday Thursday Saturday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 5 + " = Wednesday Thursday Friday Sunday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 5 + " = Thursday Friday Saturday Monday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 5 + " = Friday Saturday Sunday Tuesday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 5 + " = Saturday Sunday Monday Wednesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 5 + " = Sunday Monday Tuesday Thursday Friday";
                }
                break;
            case 6:
                if (sdf.format(date).equals("วันจันทร์") || sdf.format(date).equals("Monday")) {
                    nameDay = 6 + " = Monday Tuesday Wednesday Thursday Friday Saturday";
                } else if (sdf.format(date).equals("วันอังคาร") || sdf.format(date).equals("Tuesday")) {
                    nameDay = 6 + " = Tuesday Wednesday Thursday Friday Saturday Sunday";
                } else if (sdf.format(date).equals("วันพุธ") || sdf.format(date).equals("Wednesday")) {
                    nameDay = 6 + " = Wednesday Thursday Friday Saturday Sunday Monday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี") || sdf.format(date).equals("Thursday")) {
                    nameDay = 6 + " = Thursday Friday Saturday Sunday Monday Tuesday";
                } else if (sdf.format(date).equals("วันศุกร์") || sdf.format(date).equals("Friday")) {
                    nameDay = 6 + " = Friday Saturday Sunday Monday Tuesday Wednesday";
                } else if (sdf.format(date).equals("วันเสาร์") || sdf.format(date).equals("Saturday")) {
                    nameDay = 6 + " = Saturday Sunday Monday Tuesday Wednesday Thursday";
                } else if (sdf.format(date).equals("วันอาทิตย์") || sdf.format(date).equals("Sunday")) {
                    nameDay = 6 + " = Sunday Monday Tuesday Wednesday Thursday Friday";
                }
                break;
            case 7:
                nameDay = 7 + " = Monday Tuesday Wednesday Thursday Friday Saturday Sunday";
                break;
            default:
                nameDay = "The day that you input are more than 7 days or less than 1 day";
        }
        PreparedStatement pstm = conn.prepareStatement("update PLAN set dayperweek ='" + newDayPerWeek + 
                "'where dayperweek ='" + oldDayPerWeek + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);

    }

    public void editTotalDay(int oldDay, int newDay) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set totaldays='" 
                + newDay + "'where totaldays ='" + oldDay + "'");
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
