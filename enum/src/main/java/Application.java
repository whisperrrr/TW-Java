public class Application {

  public static void main(String[] args) {
    Student stu1 = new Student("Linda", Gender.FEMALE);
    Student stu2 = new Student("Bob", Gender.MALE);
    Student stu3 = new Student("Solider", Gender.MALE);
    Student stu4 = new Student("Cindy", Gender.FEMALE);

    Student[] stuList = {stu1, stu2, stu3, stu4};

    filterByGender(stuList, Gender.FEMALE);
  }

  public static void filterByGender(Student[] stuList, Gender gender) {
    for (Student stu:stuList) {
      if(stu.getGender() == gender) {
        System.out.println(stu.getName());
      }
    }
  }
}
