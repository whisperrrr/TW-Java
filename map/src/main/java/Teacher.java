
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Teacher {
    private String name;
    private Map<Integer, HashSet<Student>> studentMap = new HashMap<>();
    // 构造函数
    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, Student[] students) {
        this.name = name;
        for (Student stu:students) {
            addStudent(stu);
        }
    }
    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, HashSet<Student>> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Integer, HashSet<Student>> studentMap) {
        this.studentMap = studentMap;
    }
    // 添加学生
    public void addStudent(Student stu) {
        int age = stu.getAge();

//        if (studentMap.containsKey(age)) {
//            HashSet<Student> students = studentMap.get(age);
//            students.add(stu);
//        } else {
//            HashSet<Student> student = new HashSet<>();
//            student.add(stu);
//            studentMap.put(age, student);
//        }

        studentMap.computeIfAbsent(age, k -> new HashSet<>()).add(stu);

    }

    // 获得老师的信息
    @Override
    public String toString() {
        return "I am a Teacher, \n" +
                "My name is " + name + '\n' +
                "I teach " + getStuInfo() +
                '.';
    }

    //获得学生的信息
    public String getStuInfo() {
        StringBuilder students = new StringBuilder();
        Set<Integer> keySet = studentMap.keySet();

        for (Integer key:keySet) {
            students.append(studentMap.get(key));
        }

        return String.valueOf(students);
    }
}
