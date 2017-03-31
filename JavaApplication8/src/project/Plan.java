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

    private static void getDataFromDB(ResultSet rs, Plan p) throws SQLException {
        p.setPlanName(rs.getString("planName"));
        p.setDescription(rs.getString("descriptionPlan"));
        p.setDayPerWeek(rs.getInt("dayperweek"));
        p.setTotaldays(rs.getInt("totaldays"));
    }

    /* public static List<Plan> show() {
        List<Plan> listPlans = null;
        try {
            Connection conn = MySQLConnect.getMySQLConnection();
            PreparedStatement pstm = conn.prepareStatement("select * from PLAN");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                if(listPlans == null){
                    listPlans = new ArrayList<Plan>();
                }
                Plan p = new Plan();
                getDataFromDB(rs, p);
                listPlans.add(p);
            }
        }catch(ClassNotFoundException e){
            System.err.print(e);
        }catch(SQLException e){
            System.err.print(e);
        }
        return listPlans;
    }*/
    public ResultSet show() throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from PLAN");
        ResultSet rs = pstm.executeQuery();
        /*    while (rs.next()) {
            System.out.print("Plan name : ");
            System.out.println(rs.getString("planName"));
            System.out.print("Description : ");
            System.out.println(rs.getString("descriptionPlan"));
            System.out.print("Total days : ");
            System.out.println(rs.getString("totaldays"));
            System.out.print("Days per week : ");
            System.out.println(rs.getString("dayperweek"));
        }*/
        return rs;
    }

    public String create(String planName, String description, int totalDays, int dayPerWeek) throws ClassNotFoundException, SQLException {
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
        PreparedStatement pstm = conn.prepareStatement("insert into PLAN (planName,descriptionPlan,totaldays,dayperweek) values (?,?,?,?)");
        pstm.setString(1, planName);
        pstm.setString(2, description);
        pstm.setInt(3, totalDays);
        pstm.setInt(4, dayPerWeek);
        int rs = pstm.executeUpdate();
        System.out.println(rs);
        return "--------------Plan name : " + planName + "--------------"
                + "\nDescription : " + description
                + "\nThe total day in your plan : " + totaldays + " days"
                + "\nThe day that you have to exercise : " + nameDay;

    }

    public void editPlanName(String oldPlanName, String newPlanName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set planName='" + newPlanName + "'where planName ='" + oldPlanName + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void editDescription(String oldDescription, String newDescription) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set descriptionPlan='" + newDescription + "'where descriptionPlan ='" + oldDescription + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void editDayPerWeek(int oldDayPerWeek, int newDayPerWeek) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String nameDay = sdf.format(date);
        this.show();
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
        PreparedStatement pstm = conn.prepareStatement("update PLAN set dayperweek ='" + newDayPerWeek + "'where dayperweek ='" + oldDayPerWeek + "'");

        int rs = pstm.executeUpdate();
        System.out.println(rs);

    }

    public void editTotalDay(int oldDay, int newDay) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update PLAN set totaldays='" + newDay + "'where totaldays ='" + oldDay + "'");
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
