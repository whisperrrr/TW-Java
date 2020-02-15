import model.Student;
import model.Teacher;

public class Application {

    public static void main(String[] args) {
        Student stu = new Student("李莉",20,"女");
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getGender());
        stu.study();
        stu.sleep();

        Student stu1 = new Student("李莉",20,"女");
        Student stu2 = new Student("王其",21,"男");
        Student[] stuArray = {stu1, stu2};
        Teacher teacher = new Teacher("张龙",stuArray);
        //给张龙老师添加一名学生
        Student stu3 = new Student("赵毅",22,"男");
        teacher.addStudent(stu3);
        //查看张老师管理的学生
        teacher.listStudent();
    }
}
