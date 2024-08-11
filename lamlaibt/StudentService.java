package baitapcolection.bai1.lamlaibt;

import java.util.List;

public interface StudentService {
    void addStudent(NewStudent student);
    NewStudent findStudentById(int id);
    void updateStudent(int id, NewStudent updatedStudent);
    void deleteStudent(int id);
    void sortStudentsByName();
    void findStudentsByGpa(double gpa);
    void displayAllStudents();
}
