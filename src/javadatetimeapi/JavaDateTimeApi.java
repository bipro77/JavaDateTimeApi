/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatetimeapi;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 *
 * @author User
 */
public class JavaDateTimeApi {

    public static void main(String args[]) {
        System.out.println("https://www.tutorialspoint.com/java8/java8_datetime_api.htm");
        JavaDateTimeApi java8tester = new JavaDateTimeApi();
        java8tester.testLocalDateTime();

        System.out.println("https://www.mkyong.com/java8/java-8-how-to-format-localdatetime/");
        java8tester.testMkyoug();

        System.out.println("https://www.youtube.com/watch?v=nvluJ9yf4ho");
        for (String id : ZoneId.getAvailableZoneIds()) {
//            System.out.println(id);
        }
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("GMT"));
        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.ofOffset("GMT", ZoneOffset.ofHours(+6)));
        System.out.println("Bangladesh Time: " + localDateTime2);

        Instant instant = Instant.now();
        ZoneId systemZone = ZoneId.systemDefault(); // my timezone
        ZoneOffset currentOffsetForMyZone = systemZone.getRules().getOffset(instant);
        System.out.println(currentOffsetForMyZone); // gives my offset

        LocalDateTime d = LocalDateTime.of(2000, 3, 10, 0, 0);
        System.out.println(d.toLocalDate());

    }

    public void testMkyoug() {
        String now = "2016-11-09 10:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);
        System.out.println("Before : " + now);
        System.out.println("After : " + formatDateTime);
        System.out.println("After : " + formatDateTime.format(formatter));
    }

    public void testLocalDateTime() {
        // Get the current date and time
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println("Current DateTime: " + currentTime);
        System.out.println("Current DateTime: " + currentTime.format(formatter));

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);
        System.out.println("date1: " + date1.format(DateTimeFormatter.ISO_DATE));

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("Month: " + month + "day: " + day + "seconds: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        //12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        //22 hour 15 minutes
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        //parse a string
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
    }
}
