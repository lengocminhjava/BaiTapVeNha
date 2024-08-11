package baitapcolection.bai9;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
//        HashSet: Không đảm bảo thứ tự của các phần tử. Các phần tử có thể xuất hiện trong một thứ tự
//        ngẫu nhiên, không phụ thuộc vào thứ tự mà chúng được thêm vào.
//        LinkedHashSet: Duy trì thứ tự chèn của các phần tử. Điều này có nghĩa là
//        các phần tử sẽ được lưu trữ và trả về theo thứ tự mà chúng được thêm vào tập hợp
//        TreeSet: Duy trì thứ tự của các phần tử theo thứ tự tự nhiên hoặc theo Comparator cung cấp.


        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Cherry");

        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Cherry");

        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Cherry");

        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet: " + treeSet);


    }
}
