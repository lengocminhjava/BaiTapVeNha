package baitapcolection.bai6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1,"Minh",27);
        Student student2 = new Student(2,"Đức",27);
        ExamResult examResult1 = new ExamResult("Math",10);
        ExamResult examResult2 = new ExamResult("Science",10);
        ExamResult examResult3 = new ExamResult("English",10);
        ExamResult examResult4 = new ExamResult("program",9);
        Map<Student, List<ExamResult>> studentList = new HashMap<>();
        studentList.computeIfAbsent(student1,k -> new ArrayList<>()).add(examResult1);
        studentList.computeIfAbsent(student1,k -> new ArrayList<>()).add(examResult2);
        studentList.computeIfAbsent(student2,k -> new ArrayList<>()).add(examResult3);
        studentList.computeIfAbsent(student2,k -> new ArrayList<>()).add(examResult4);
        for(Map.Entry<Student,List<ExamResult>> entry:studentList.entrySet()){
            Student student = entry.getKey();
            List<ExamResult> results = entry.getValue();
            System.out.println(student);
            for(ExamResult result:results){
                System.out.println(result);
            }
            System.out.println();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id tìm kiếm");
        int id = sc.nextInt();
        System.out.println("Hiển thị danh sách điểm theo id");
        searchForId(studentList,id);
        System.out.println();
        List<Student> students = new ArrayList<>();
        for(Map.Entry<Student,List<ExamResult>> entry:studentList.entrySet()){
            students.add(entry.getKey());
        }
        Map<Student,Double> diemTb = new HashMap<>();
        for(Student student:students){
            double dtb = 0.0;
           for(ExamResult result:studentList.get(student)){
               dtb+=(result.getScore());
           }
            diemTb.put(student,dtb/(studentList.get(student).size()));
        }
        List<Double> maxDtb = new ArrayList<>();
        for(Map.Entry<Student,Double> entry:diemTb.entrySet()){
             Student student = entry.getKey();
             Double dtb = entry.getValue();
              maxDtb.add(dtb);
            System.out.println(student+" dtb: "+dtb);
        }
        System.out.println();
        System.out.println("Sinh viên có điểm trung bình lớn nhất");
        for(Map.Entry<Student,List<ExamResult>> entry:studentList.entrySet()){
            Student student = entry.getKey();
            List<ExamResult> results = entry.getValue();
           double dtb = dtb(studentList,student);
            if(Collections.max(maxDtb) == dtb){
                System.out.println(student);
                for(ExamResult result:results){
                    System.out.println(result);
                }
            }
        }


    }
    public static void searchForId(Map<Student,List<ExamResult>> students , int id){
               boolean isId = false;
               for(Map.Entry<Student,List<ExamResult>> entry:students.entrySet()){
                   Student student = entry.getKey();
                   if(student.getId() == id){
                       isId = true;
                       List<ExamResult> results = entry.getValue();
                       for(ExamResult result:results){
                           System.out.println(result);
                       }
                   }

               }
               if(!isId){
                   System.out.println("Không tồn tại id");
               }
    }
    public static double dtb(Map<Student,List<ExamResult>> studentList,Student student){
        List<ExamResult> results = studentList.get(student);
        double dtb = 0;
        for(ExamResult result:results){
            dtb+=result.getScore();
        }
        return dtb/results.size();
    }
}
