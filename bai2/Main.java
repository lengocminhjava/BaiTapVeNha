package baitapcolection.bai2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Book> listBooks = new ArrayList<>();
        listBooks.add(new Book(1,"Sống ở đáy sông","Lê Lựu",1996));
        listBooks.add(new Book(2,"Chiếc thuyền ngooài xa","Nguyễn Minh Châu",1975));
        listBooks.add(new Book(4,"Sống ở đáy sông","Lê Lựu",1994));
        listBooks.add(new Book(3,"Vợ Nhặt","Kim Lân",1962));
       for(Book book:listBooks){
           System.out.println(book);
       }
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập isbn");
        int isbn = sc.nextInt();
        if(isIsbn(listBooks,isbn)){
            System.out.println(searchIsbn(listBooks,isbn));
        }
        else {
            System.out.println("isbn không hợp lệ");
        }
        System.out.println("Nhập isbn cần update");
        int isbnUpdate = sc.nextInt();
        if(isIsbn(listBooks,isbnUpdate)){
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Nhập title cần update");
            String title = sc1.nextLine();
            System.out.println("Nhập author cần update");
            String author = sc1.nextLine();
            System.out.println("Nhập yearPublished cần update");
            int yearPublished = sc.nextInt();
            System.out.println("sau khi update"+updateBooks(listBooks,isbnUpdate,title,author,yearPublished));
        }
        else {
            System.out.println("isbn không hợp lệ");
        }
        System.out.println("Nhập isbn cần xóa");
        int removeIsbn = sc.nextInt();
        if(isIsbn(listBooks,removeIsbn)){
            System.out.println("Mảng sau khi xóa"+removeBook(listBooks,removeIsbn));
        }
        else {
            System.out.println("isbn không hợp lệ");
        }
        System.out.println("Nhập tác giả");
        sc.nextLine();
        String author = sc.nextLine();
        boolean isAuthor = false;
        for(Book book:listBooks){
         String[] tacGia = book.getAuthor().toLowerCase().split(" ");
               for(String tg:tacGia){
                  if(tg.contains(author)){
                      System.out.println("search theo author"+book);
                      isAuthor=true;
                  }
               }
        }
        if(!isAuthor){
            System.out.println("Không tồn tại tên tác giả");
        }
        System.out.println("Sắp xếp theo yearPublished");
      sortByYear(listBooks);
    }
    public static boolean isIsbn(List<Book> Books,int isbn){
        boolean isTrue = false;
        for(Book book:Books){
            if(isbn == book.getIsbn()){
                isTrue = true;
            }
        }
        return isTrue;
    }
    public static List<Book> searchIsbn(List<Book> Books,int isbn){
        List<Book> listBooks = new ArrayList<>();
        for(Book book:Books){
            if(isbn == book.getIsbn()){
                listBooks.add(book);
            }
        }
        return listBooks;
    }
    public static List<Book> updateBooks(List<Book> Books,int isbn,String title,String author,int yearPublished){
        for(Book book:Books){
            if(isbn == book.getIsbn()){
                book.setTitle(title);
                book.setAuthor(author);
                book.setYearPublished(yearPublished);
            }
        }
        return Books;
    }
    public static List<Book> removeBook(List<Book> Books,int isbn){
        List<Book> listBooks = searchIsbn(Books,isbn);
         Books.removeAll(listBooks);
         return Books;
    }
    public static void sortByYear(List<Book> Books){
//      Books.sort(Comparator.comparingInt(Book::getYearPublished));
        List<Integer> years = new ArrayList<>();
        for (Book book : Books) {
            years.add(book.getYearPublished());
        }
        Collections.sort(years);
        Map<Integer,Integer> listYear = new HashMap<>();
        for (Book book : Books) {
            listYear.put(book.getYearPublished(),book.getIsbn());
        }
        for(Integer year:years){
            System.out.println(searchIsbn(Books,listYear.get(year)));
        }
    }
}

