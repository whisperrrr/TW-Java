public class Application {

  public static void main(String[] args) {
      Student stu1 = new Student("Cindy", 80);
      Student stu2 = new Student("Mary", 95);

      Teacher teacher1 = new Teacher("Solider", new Student[]{stu2});
      Teacher teacher2 = new Teacher("Bob" , new Student[]{stu1});

      teacher1.addScore(5);
      teacher2.addScore(5);

      teacher1.printTeacher();
      teacher2.printTeacher();
  }
}
