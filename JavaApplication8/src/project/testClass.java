/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Administrator
 */
public class testClass {

    private int year = 2017;
    private int month = 5;
    private int dayOfMonth = 3;

    public static void main(String args[]) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(2017, 3, 5);
        MyPlan2 mp = new MyPlan2();
        cal.setTime(mp.getStartDate());

        // this formatter will have the current locale
        SimpleDateFormat format = new SimpleDateFormat("EEEE");

        System.out.println(format.format(cal.getTime()));
        
//        Calendar cal = Calendar.getInstance();
//        int day = cal.get(Calendar.DAY_OF_WEEK);
//        System.out.print("Today is ");
//        switch (day) {
//            case 1:
//                System.out.print("Sunday");
//                break;
//            case 2:
//                System.out.print("Monday");
//                break;
//            case 3:
//                System.out.print("Tuesday");
//                break;
//            case 4:
//                System.out.print("Wednesday");
//                break;
//            case 5:
//                System.out.print("Thursday");
//                break;
//            case 6:
//                System.out.print("Friday");
//                break;
//            case 7:
//                System.out.print("Saturday");
//        }
//        //System.out.print(".");
//        testClass tc =new testClass();
    }

    public String show() throws ParseException {
        String input_date = "01/08/2012";
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        Date dt1 = format1.parse(input_date);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }
}

//    public int show() {
//        Calendar myCalendar = new GregorianCalendar(year, month, dayOfMonth);
//        int dayOfWeek = myCalendar.get(Calendar.DAY_OF_WEEK);
//        return dayOfWeek;
//    }
//        Date date = null;
//        try {
//            date = new SimpleDateFormat(format).parse(inputDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return new SimpleDateFormat("EEEE", Locale.US).format(date);
