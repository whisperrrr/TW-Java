package model;

import java.util.Arrays;
import java.util.Objects;

public class Teacher {
    public String name;
    public Student[] stuList;
    /**构造函数，便于初始化*/
    public Teacher(String name, Student[] stuList) {
        this.name = name;
        this.stuList = stuList;
    }
    /**添加学生*/
    public Student[] addStudent(Student newStudent) {
        int stuListLen = stuList.length;
        Student[] stuListNew = new Student[stuListLen + 1];
        //新建一个对象数组，并将新学生添加进来
        for (int i = 0; i < stuListLen; i++) {
            stuListNew[i] = stuList[i];
        }
        stuListNew[stuListLen] = newStudent;
        stuList = stuListNew;

        System.out.println("add a new student");
        return stuList;
    }
    /**展示学生名单*/
    public void listStudent() {
        for (Student stu:stuList) {
            System.out.println(stu.getName());
        }
    }
}
