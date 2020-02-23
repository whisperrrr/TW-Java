package com.thoughtworks;

public class App {

    public static void main(String[] args) {
        Student stu1 = new Student("3", "张三");
        Student stu2 = new Student("4", "李四");
        Student stu3 = new Student("5", "王五");
        Student stu4 = new Student("6", "赵六");
        Student stu5 = new Student("7", "钱七");

        MemoryRepository memoryRepository = new MemoryRepository();

        memoryRepository.save(stu1.getId(), stu1);
        memoryRepository.save(stu2.getId(), stu2);
        memoryRepository.save(stu3.getId(), stu3);
        memoryRepository.save(stu4.getId(), stu4);
        memoryRepository.save(stu5.getId(), stu5);

        System.out.println(memoryRepository.get("3"));
        System.out.println("==================");

        memoryRepository.delete("4");

        Student stu6 = new Student("5", "冯五");
        memoryRepository.update(stu6.getId(), stu6);

        RepositoryUtil.printList(memoryRepository.list());

    }

}
