public class Application {

  public static void main(String[] args) {
    Student stu1 = new Student("Linda", 18);
    Student stu2 = new Student("Cindy", 19);
    Student stu3 = new Student("Mary", 19);


    Teacher teacher = new Teacher("Bob", new Student[]{stu1, stu2, stu3});
    System.out.println(teacher.getStuInfo());

    Student stu4 = new Student("Ben", 19);
    Student stu5 = new Student("Solider", 19);

    teacher.addStudent(stu4);
    teacher.addStudent(stu5);
    System.out.println(teacher.getStuInfo());

  }

}
