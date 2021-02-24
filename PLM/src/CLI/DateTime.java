package CLI;

import java.io.Serializable;

public class DateTime implements Serializable {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    public DateTime() {
    }

    public DateTime(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public DateTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        //oldest league club was created in 1862
        if (year < 1860) {
            System.out.println("Invalid Year.");
            throw new IllegalArgumentException();
        } else {
            this.year = year;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month > 12 || month < 0) {
            System.out.println("Invalid month.");
            throw new IllegalArgumentException();
        } else {
            this.month = month;
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day > 31 || day < 0) {
            System.out.println("Invalid date.");
            throw new IllegalArgumentException();
        } else {
            this.day = day;
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour > 24 || hour < 0) {
            System.out.println("Invalid hour");
            throw new IllegalArgumentException();
        } else {
            this.hour = hour;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {

        if (minute > 60 || minute < 0) {
            System.out.println("Invalid minute.");
            throw new IllegalArgumentException();
        } else {
            this.minute = minute;
        }
    }


    @Override
    public String toString() {
        return "[ " +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                " ] ";
    }

}
