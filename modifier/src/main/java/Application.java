public class Application {

  public static void main(String[] args) {
      Student stu1 = new Student("Cindy", 80);
      Student stu2 = new Student("Mary", 95);

      Teacher teacher1 = new Teacher("Solider", new Student[]{stu2});
      Teacher teacher2 = new Teacher("Bob" , new Student[]{stu1});

      addScore(teacher1, 5);
      addScore(teacher2,5);
      printTeacher(teacher1);
      printTeacher(teacher2);
  }
  //给学生加分
  public static Teacher addScore(Teacher teacher, int score) {
      Student[] studentList = teacher.getStudents();
      for (Student stu: studentList) {
          int scoreTemp = stu.getScore();
          stu.setScore(scoreTemp + score);
      }
      teacher.setStudents(studentList);
      return teacher;
  }
  //打印老师和其名下学生的信息
  public static void printTeacher(Teacher teacher) {
      System.out.println("教师姓名： " + teacher.getName());
      Student[] studentList = teacher.getStudents();
      for (Student stu: studentList) {
          System.out.println("学生姓名： " + stu.getName());
          System.out.println("学生成绩： " + stu.getScore());
      }
      System.out.println("==================");
  }

}
