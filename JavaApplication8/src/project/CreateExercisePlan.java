/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class CreateExercisePlan {

    private String planName;
    private int dayPerWeek;
    private String type;
    private String level;
    String day[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public void create(String planName, int dayPerWeek, String type, String level) {
        this.planName = planName;
        this.dayPerWeek = dayPerWeek;
        this.type = type;
        this.level = level;
        //day : 1 = Sunday ....

        switch (dayPerWeek) {
            case 1:
                System.out.println("Your exercise day is : " + day[0]);
                break;
            case 2:
                System.out.println("Your exercise day are : " + day[2] + ", " + day[6]);
                break;
            case 3:
                System.out.println("Your exercise day are : " + day[1] + ", " + day[3] + ", " + day[5]);
                break;
            case 4:
                System.out.println("Your exercise day are : " + day[1] + ", " + day[2] + ", " + day[4] + ", " + day[5]);
                break;
            case 5:
                System.out.println("Your exercise day are : " + day[0] + ", " + day[1] + ", " + day[2] + ", "
                        + day[4] + ", " + day[5]);
                break;
            case 6:
                System.out.println("Your exercise day are : " + day[0] + ", " + day[1] + ", " + day[2] + ", "
                        + day[4] + ", " + day[5] + ", " + day[6]);
                break;
            case 7:
                System.out.print("Your exercise day are : " + day[0]);
                for (int i = 1; i < day.length; i++) {
                    System.out.print(", " + day[i]);
                }

                break;
        }
    }

    public String showDay(int day) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String nameDay = sdf.format(date);
        if (sdf.format(date).equals("วันจันทร์")) {
            nameDay = "Monday";
        } else if (sdf.format(date).equals("วันอังคาร")) {
            nameDay = "Tuesday";
        } else if (sdf.format(date).equals("วันพุธ")) {
            nameDay = "Wednesday";
        } else if (sdf.format(date).equals("วันพฤหัสบดี")) {
            nameDay = "Thursday";
        } else if (sdf.format(date).equals("วันศุกร์")) {
            nameDay = "Friday";
        } else if (sdf.format(date).equals("วันเสาร์")) {
            nameDay = "Saturday";
        } else if (sdf.format(date).equals("วันอาทิตย์")) {
            nameDay = "Sunday";
        }

        switch (day) {
            case 2:
                if (sdf.format(date).equals("วันจันทร์")) {
                    nameDay = "Monday, Friday";
                } else if (sdf.format(date).equals("วันอังคาร")) {
                    nameDay = "Tuesday, Saturday";
                } else if (sdf.format(date).equals("วันพุธ")) {
                    nameDay = "Wednesday, Sunday";
                } else if (sdf.format(date).equals("วันพฤหัสบดี")) {
                    nameDay = "Thursday, Monday";
                } else if (sdf.format(date).equals("วันศุกร์")) {
                    nameDay = "Friday, Tuesday" ;
                } else if (sdf.format(date).equals("วันเสาร์")) {
                    nameDay = "Saturday, Wednesday";
                } else if (sdf.format(date).equals("วันอาทิตย์")) {
                    nameDay = "Sunday, Thursday";
                }
        }

        return nameDay;
    }

    public void edit() {

    }

    public void delete() {

    }
}
