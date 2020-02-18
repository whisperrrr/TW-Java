package com.thoughtworks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Student implements Comparable<Student>{
    private final String name;
    private final String num;
    private final String dateStr;
    private Date date;
    private String datePattern = "yyyy.MM.dd";
    private SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

    public Student(String name, String num, String dateStr){
        this.name = name;
        this.num = num;
        this.dateStr = dateStr;
        try {
            this.date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public String getDateStr() {
        return dateStr;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(num, student.num);
    }

    // 计算学龄
    public int getDateInSchool() {
        String[] dateList = dateStr.split("\\.");
        String year = dateList[0];

        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);//获取年份

        int time = yearNow - Integer.parseInt(year);

        return time;
    }
    // 打印学生对象
    @Override
    public String toString() {
        String date = parseDate();

        StringBuilder str = new StringBuilder();
        str.append("我叫").append(name).append(",");
        str.append("我的学号是").append(num).append(",");
        str.append(date).append("入学,");
        str.append("学龄").append(getDateInSchool()).append("年");

        return str.toString();
    }

    public String parseDate() {
        String datePattern = "yyyy年MM月dd日";
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

        return sdf.format(date);
    }
    @Override
    public int compareTo(Student o) {
        return Integer.parseInt(this.num) - Integer.parseInt(o.num);
    }
}
