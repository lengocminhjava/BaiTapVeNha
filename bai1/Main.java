package baitapcolection.bai1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student sv1 = new Student(1,"Minh",20,10);
        Student sv2 = new Student(2,"Tuấn",20,10);
        Student sv3 = new Student(3,"Trường",20,10);
        List<Student> students = new ArrayList<>();
        students.add(sv1);
        students.add(sv2);
        students.add(sv3);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào id");
        int id = sc.nextInt();
        boolean isId = isId(students,id);
        if(!isId){
            listStudentForId(students,id);
        }
      else{
            System.out.println("id không hợp lệ");
        }
        System.out.println("Nhập vào id cần update");
        int idUpdate = sc.nextInt();
           boolean isUpdateId = isId(students, idUpdate);
        if(!isUpdateId){
            System.out.println("Nhập vào tên update");
            Scanner sc1 = new Scanner(System.in);
            String ten = sc1.nextLine();
            System.out.println("Nhập vào age update");
            int age = sc.nextInt();
            System.out.println("Nhập vào gpa");
            double gpa = sc.nextDouble();
            listStudentUpdateForId(students,idUpdate,ten,age,gpa);
        }
        else{
            System.out.println("id không hợp lệ");
        }
        System.out.println("Nhập id cần xóa");
        int removeId  = sc.nextInt();
        boolean isRemoveId = isId(students, removeId);
        if(!isRemoveId){
          List<Student> listApterRemoveStudent =   removeStudentForId(students,removeId);
          for (Student student:listApterRemoveStudent){
              System.out.println("Sau khi xóa"+student);
          }
        }else{
            System.out.println("id không hợp lệ");
        }
        System.out.println("-------------------");
      sortName(students);
      int gta = 1;
        System.out.println("danh sách có giá trị > gta là");
      for(Student student:students){
          if(student.getGpa()>gta){
              System.out.println(student);
          }
      }

    }
    public static boolean isId(List<Student> students , int id){
        boolean isId = true;
        for(Student student:students){
            if(student.getId() == id){
                isId = false;
            }
        }
        return isId;
    }
    public static void listStudentForId(List<Student> students,int id){
            for (Student student:students){
                      if(id == student.getId()){
                          System.out.println(student);
                      }
            }
    }
    public static void listStudentUpdateForId(List<Student> students,int id,String name,int age,double gpa){
        for (Student student:students){
            if(id == student.getId()){
                student.setName(name);
                student.setAge(age);
                student.setGpa(gpa);
                System.out.println("sau khi update"+id+" "+student);
            }
        }
    }
    public static List<Student> removeStudentForId(List<Student> students,int id){
        int index = 0;
        for (Student student:students){
            if(id == student.getId()){
                index = students.indexOf(student);
            }
        }
        students.remove(index);
        return students;
    }
    public static void sortName(List<Student> students){
        List<String> names = new ArrayList<>();
        for (Student student:students){
            names.add(student.getName());
        }
         Collections.sort(names);
        Map<String, Integer> nameToIdMap = new HashMap<>();
        for (Student student : students) {
            nameToIdMap.put(student.getName(), student.getId());
        }
        List<Integer> listIds = new ArrayList<>();
        for (String name : names) {
            listIds.add(nameToIdMap.get(name));
        }
        for (int id : listIds) {
            listStudentForId(students,id);
        }
    }
}
