package com.thoughtworks;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("3", "张三"),
                new Student("4", "李四"),
                new Student("5", "王五"),
                new Student("6", "赵六"),
                new Student("7", "钱七"));

        MemoryRepository<Student> memoryRepository = new MemoryRepository<>();

        for (Student student : students) {
            memoryRepository.save(student.getId(),student);
        }

        System.out.println(memoryRepository.get("3"));
        System.out.println("==================");

        memoryRepository.delete("4");

        Student stu6 = new Student("5", "冯五");
        memoryRepository.update(stu6.getId(), stu6);

        RepositoryUtil.printList(memoryRepository.list());

    }

}
