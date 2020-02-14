public class Teacher {
    private final String name;
    private Student[] students;

    public Teacher(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void addScore(int score) {
        Student[] studentList = getStudents();
        for (Student stu: studentList) {
            int scoreTemp = stu.getScore();
            stu.setScore(scoreTemp + score);
        }
    }

    public void printTeacher() {
        System.out.println("教师姓名： " + getName());
        Student[] studentList = getStudents();
        for (Student stu: studentList) {
            System.out.println("学生姓名： " + stu.getName());
            System.out.println("学生成绩： " + stu.getScore());
        }
        System.out.println("==================");
    }
}
