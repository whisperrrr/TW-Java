package com.thoughtworks;

import java.util.ArrayList;
import java.util.Collections;

public class Teacher {
    private final String name;
    private final ArrayList<Student> stuList;

    public Teacher(String name, ArrayList<Student> stuList) {
        this.name = name;
        this.stuList = stuList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStuList() {
        return stuList;
    }
    //获取重复学生名单
    public ArrayList<Student> getRepeatStuList() {
        Collections.sort(stuList);
        ArrayList<Student> stuRepeat = new ArrayList<>(0);
        int stuListLen = stuList.size();

        stuList.add(0,null);
        stuList.add(null);

        for (int i = 1; i < stuListLen + 1; i++) {
            if (stuList.get(i).isSamePerson(stuList.get(i - 1))
              ||stuList.get(i).isSamePerson(stuList.get(i + 1))) {
                stuRepeat.add(stuList.get(i));
            }
        }
        return stuRepeat;
    }
    //打印重复学生名单
    public void printRepeatStu() {
        System.out.println("重复的学生名单如下:");
        ArrayList<Student> repeatStu = getRepeatStuList();
        for (Student stu:repeatStu) {
            System.out.println(stu);
        }
    }
    @Override
    public String toString() {
        return String.format("我叫%s,我是一名教师", name);
    }
}
