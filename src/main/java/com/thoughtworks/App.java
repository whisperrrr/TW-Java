package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

  public static void main(String[] args) {
    Student stu1 = new Student("张三", "001", "2019.02.11");
    Student stu2 = new Student("李四", "002", "2019.02.10");
    Student stu3 = new Student("王五", "001", "2019.02.09");

    Student[] stuList = new Student[]{stu1, stu2, stu3};
    Teacher teacher = new Teacher("张龙", new ArrayList<>(Arrays.asList(stuList)));

    System.out.println(teacher);
    teacher.printRepeatStu();
  }
}
