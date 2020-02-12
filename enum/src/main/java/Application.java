public class Application {

  public static void main(String[] args) {
    Student stu1 = new Student("Linda", "Female");
    Student stu2 = new Student("Bob", "Male");
    Student stu3 = new Student("Solider", "Male");
    Student stu4 = new Student("Cindy", "Female");

    Student[] stuList = {stu1, stu2, stu3, stu4};
    Gender gender = Gender.FEMALE;

    filterByGender(stuList, gender);
  }

  public static void filterByGender(Student[] stuList, Gender gender) {
    for (Student stu:stuList) {
      if(stu.getGender().equals(gender.getGender())) {
        System.out.println(stu.getName());
      }
    }
  }
}
