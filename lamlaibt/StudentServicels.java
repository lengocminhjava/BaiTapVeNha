package baitapcolection.bai1.lamlaibt;

import baitapcolection.bai1.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentServicels implements StudentService{
    private List<NewStudent> students = new ArrayList<>();
    @Override
    public void addStudent(NewStudent student) {
        students.add(student);
    }
    @Override
    public NewStudent findStudentById(int id) {
        boolean isId = false;
        NewStudent studentForId = new NewStudent();
        for (NewStudent student:students){
            if(id == student.getId()){
                isId = true;
                studentForId = student;
            }
        }
        if(!isId){
            System.out.println("Không tồn tại id");
        }
        return studentForId;
    }

    @Override
    public void updateStudent(int id, NewStudent updatedStudent) {
        NewStudent student = findStudentById(id);
        if (student != null && !updatedStudent.getName().isEmpty()
        && (Integer)updatedStudent.getAge()!=null &&(Double)updatedStudent.getGpa()!=null) {
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setGpa(updatedStudent.getGpa());
        }

    }

    @Override
    public void deleteStudent(int id) {
        NewStudent student = findStudentById(id);
        students.remove(student);
        System.out.println("Xóa thành công");
    }

    @Override
    public void sortStudentsByName() {
        students.sort(Comparator.comparing(NewStudent::getName));
    }

    @Override
    public void findStudentsByGpa(double gpa) {
        List<NewStudent> result = new ArrayList<>();
        for (NewStudent student : students) {
            if (student.getGpa() > gpa) {
                result.add(student);
            }
        }
       for(NewStudent student:result){
           System.out.println(student);
       }
    }

    @Override
    public void displayAllStudents() {
        for(NewStudent student:students){
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        int input;
        StudentServicels students = new StudentServicels();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("---------------------------------------------------");
            System.out.println("1. Thêm một sinh viên vào danh sách sinh viên.");
            System.out.println("2. Tìm kiếm sinh viên theo id.");
            System.out.println("3. Cập nhật thông tin sinh viên theo id.");
            System.out.println("4. Xóa sinh viên theo id.");
            System.out.println("5. Sắp xếp danh sách sinh viên theo tên.");
            System.out.println("6. Hiển thị tất cả sinh viên có gpa lớn hơn một giá trị cho trước.");
            System.out.println("7. Hiển thị tất cả sinh viên.");
            System.out.println("0. Thoát");
            System.out.println("---------------------------------------------------");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    students.addStudent(new NewStudent(1, "Minh", 20, 3.5));
                    students.addStudent(new NewStudent(2, "Manh", 21, 3.8));
                    students.addStudent(new NewStudent(3, "Mo", 22, 2.9));
                    break;
                case 2:
                    System.out.println("Nhập id");
                    int id = sc.nextInt();
                    System.out.println(students.findStudentById(id));
                    break;
                case 3:
                    System.out.println("Nhập id");
                    int idUpdate = sc.nextInt();
                    System.out.println("Nhập tên update");
                    sc.nextLine();
                    String name =  sc.nextLine();
                    System.out.println("Nhập age update");
                    int age =  sc.nextInt();
                    System.out.println("Nhập agv update");
                    double agv =  sc.nextDouble();
                    students.updateStudent(idUpdate,new NewStudent(idUpdate,name,age,agv));
                    break;
                case 4:
                    System.out.println("Nhập id xóa");
                    int idDelete = sc.nextInt();
                    students.deleteStudent(idDelete);
                    break;
                case 5:
                    students.sortStudentsByName();
                    break;
                case 6:
                    System.out.println("Nhập điểm trung bình");
                    int gba = sc.nextInt();
                    students.findStudentsByGpa(gba);
                    break;
                case 7:
                    students.displayAllStudents();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Số vừa nhập ko hợp lệ");
                    break;
            }
        } while (input != 0);
    }
}
