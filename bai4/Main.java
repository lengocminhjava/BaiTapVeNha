package baitapcolection.bai4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Minh","01",200000));
        employees.add(new Employee(2,"Tuấn","02",300000));
        employees.add(new Employee(3,"Đức","03",100000));
        System.out.println("Nhập id muốn tìm kiếm");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        System.out.println("Danh sách tìm kiếm theo id");
        if(isId(employees,id)){
            searchForId(employees,id);
        }
        else {
            System.out.println("không tồn tại id");
        }
        System.out.println("Cập nhật thông tin");
        System.out.println("Nhập id cần update");
        int idUpdate = sc.nextInt();
        if(isId(employees,idUpdate)){
            System.out.println("Nhập tên update");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.println("Nhập lớp update");
            String department = sc.nextLine();
            System.out.println("Nhập lương update");
            String salaryInput = sc.nextLine();
            Double salary = null;
            if(!salaryInput.isEmpty()){
                salary = Double.parseDouble(salaryInput);
            }
            System.out.println("mảng sau khi update là");
            updateForId(employees,idUpdate,name,department,salary);
        }
        else {
            System.out.println("không tồn tại id");
        }
        System.out.println("Xóa nhân viên theo");
        System.out.println("Nhập id cần xóa");
        int idRemove = sc.nextInt();
        System.out.println("mảng sau khi xóa");
        if(isId(employees,idRemove)){
            removeId(employees,idRemove);
        }
        else {
            System.out.println("id không tồn tại");
        }
        System.out.println("Nhập phòng ban");
        sc.nextLine();
        String pb = sc.nextLine();
        boolean isPb = false;
        for(Employee employee:employees){
           if(!pb.isEmpty()&&employee.getDepartment().equals(pb)){
               System.out.println(employee);
               isPb=true;
           }
        }
        if(!isPb){
            System.out.println("pb không tồn tại");
        }
        System.out.println("Sắp xếp theo mức lương giản dần");
       employees.sort(Comparator.comparingDouble(Employee::getSalary));
       employees = employees.reversed();
       for(Employee employee:employees){
           System.out.println(employee);
       }
    }
    public static boolean isId (List<Employee> employees,int id){
        boolean isTrue = false;
        for(Employee employee:employees){
            if(id == employee.getEmployeeId()){
                isTrue=true;
            }
        }
        return isTrue;
    }
    public static void searchForId (List<Employee> employees,int id){
    for(Employee employee:employees){
    if(id==employee.getEmployeeId()){
        System.out.println(employee);
    }
}
    }
    public static void updateForId (List<Employee> employees, int id, String name, String department, Double salary){
        for(Employee employee:employees){
            if(id == employee.getEmployeeId()){
                if(salary != null){
                    employee.setSalary(salary);
                }
                 if(!department.isEmpty()){
                         employee.setDepartment(department);
                    }
                     if(!name.isEmpty()){
                     employee.setName(name);
                    }
            }
        }
        for (Employee employee:employees){
            System.out.println(employee);
        }
    }
    public static void removeId(List<Employee> employees,int id){
               List<Employee> employeeList = new ArrayList<>();
               for(Employee employee:employees){
                   if(id == employee.getEmployeeId()){
                       employeeList.add(employee);
                   }
               }
               employees.removeAll(employeeList);
               for (Employee employee:employees){
                   System.out.println(employee);
               }
    }
}
