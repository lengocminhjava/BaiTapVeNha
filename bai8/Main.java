package baitapcolection.bai8;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String,List<PageView>> userViews = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int count = 1;
        Map<String, List<PageView>> pageViews = new HashMap<>();
        while (true) {
            System.out.println("Nhập vào userId" + count);
            String userId = sc.nextLine();
            System.out.println("Nhập danh sách preview cho userId " + count);
            while (true) {
                System.out.println("nhập vào pageUrl " + count);
                String pageUrl = sc.nextLine();
                if (!userId.isEmpty() && !pageUrl.isEmpty()) {
                    PageView pageView = new PageView(userId, pageUrl, Instant.now());
                    pageViews.computeIfAbsent(userId, k -> new ArrayList<>()).add(pageView);
                }
                System.out.println("Nhân phím 1 để thoát hoặc enter để tiếp tục");
                String output = sc.nextLine();
                if (output.equals("1")) {
                    count++;
                    break;
                }
            }
            for (String key : pageViews.keySet()) {
               for(PageView pageView:pageViews.get(key)){
                   if(key.equals(userId)){
                       userViews.computeIfAbsent(userId, k -> new ArrayList<>()).add(pageView);
                   }
               }
            }
            System.out.println("Nhân phím 0 để thoát chương trình hoặc enter để tiếp tục nhập vào userId"+count);
            String outWhile = sc.nextLine();
            if (outWhile.equals("0")) {
                break;
            }
        }
        System.out.println(userViews);
        System.out.println("số lượt xem của từng trang web");
        System.out.println(countUrl(userViews));
        System.out.println("Trang web được xem nhiều nhất");
        List<Integer> countUrl = new ArrayList<>() ;
        for(String url:countUrl(userViews).keySet()){
            countUrl.add(countUrl(userViews).get(url));
        }
        for(String url:countUrl(userViews).keySet()){
            if(countUrl(userViews).get(url) == Collections.max(countUrl)){
                System.out.println(url);
            }
        }
        System.out.println("Nhập vào id cần tìm kiếm");
        int id = sc.nextInt();
        System.out.println(getPageViews(userViews,id));
        System.out.print("Nhập ngày start (yyyy-MM-dd): ");
        sc.nextLine();
        String dateString1 = sc.nextLine();
        Instant startDate = convertDate(dateString1);
        System.out.print("Nhập ngày end (yyyy-MM-dd): ");
        String dateString2 = sc.nextLine();
        Instant endDate = convertDate(dateString2);
        System.out.println("danh sách các trang web mà người dùng đã xem trong một khoảng thời gian cho trước");
        System.out.println(getForTime(userViews,startDate,endDate));



    }
    public static Instant convertDate(String date){
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Instant dateInstant = localDate.atStartOfDay(ZoneOffset.UTC).toInstant();
        return dateInstant;
    }
    public static List<PageView> getPageViews(Map<String,List<PageView>> userViews,int userId) {
        return userViews.getOrDefault(String.valueOf(userId), new ArrayList<>());
    }
    public static List<PageView> getForTime(Map<String,List<PageView>> userViews,Instant startDate,Instant endDate) {
        List<PageView> pageViews = new ArrayList<>();
        for(String key:userViews.keySet()){
            for(PageView pageView:userViews.get(key)){
                if(pageView.getTimestamp().isAfter(startDate)&&pageView.getTimestamp().isBefore(endDate)){
                    pageViews.add(pageView);
                }
            }
        }
        return pageViews;
    }
    public static Map<String,Integer> countUrl(Map<String,List<PageView>> userViews) {
        List<String> pageUrls = new ArrayList<>();
        for(String key:userViews.keySet()){
            for(PageView pageView:userViews.get(key)){
                pageUrls.add(pageView.getPageUrl());
            }
        }
       Map<String,Integer> demCout = new HashMap<>();
         for(String key:userViews.keySet()){
            for(PageView pageView:userViews.get(key)){
                int count = 0;
                for(String pageUrl:pageUrls){
                    if(pageView.getPageUrl().equals(pageUrl)){
                        count++;
                    }
                }
                demCout.put(pageView.getPageUrl(),count);
            }
        }
            return demCout;
    }
}
