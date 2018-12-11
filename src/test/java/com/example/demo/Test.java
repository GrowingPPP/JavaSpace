package com.example.demo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

    @org.junit.Test
    public void test1(){
        File[]  hidden = new File(".").listFiles(File::canExecute);
        // hidden = null;
        Optional.ofNullable(hidden).ifPresent(files -> System.out.println(files.length));
    }
    @org.junit.Test
    public void test2(){
        Apple apple1 = new Apple(1,"red");
        Apple apple2 = new Apple(2,"green");
        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        List<Apple> res = inventory.stream().filter(apple -> apple.getWeight()<2).collect(Collectors.toList());
        Optional.ofNullable(res).ifPresent(apples -> System.out.println(apple1.toString()));
    }

    @org.junit.Test
    public void test3(){
        Apple apple1 = new Apple(1,"red");
        Apple apple2 = new Apple(2,"green");
        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple1);
        inventory.add(apple2);
        // List<Apple> apples = filterApples(inventory,new ApplePredicateColor());
        List<Apple> apples = filter(inventory,apple -> "red".equals(apple.getColor()));

        // inventory.sort((Apple a1, Apple a2)
        //         -> a1.getWeight().compareTo(a2.getWeight())
        // )
        // 根据重量排序
        inventory.sort(Comparator.comparing(a->a.getWeight()));
        //进阶
        //reversed表示逆序(比较器复合)；thenComparing表示若重量相等，就比较颜色
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        Optional.ofNullable(apples).ifPresent(s -> System.out.println(s.toString()));

    }
    public static List<Apple> filterApples(List<Apple> inventory,
                                           functionInterface p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, functionInterface<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
    //JDK1.8 : Predicate<T>
    public static <T> List<T> filtesr(List<T> list, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)){
                result.add(e);
            }
        }
        return result;
    }
    private class entity{
        String name ;
        String age ;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getAge() { return age; }
        public void setAge(String age) { this.age = age; }
    }


    @org.junit.Test
    public void test4(){
        // Apple apple = new Apple(10,"YEllow");
        // System.out.print(()->"ss");
        Runnable r1 = ()->{ System.out.println("sss"); };
        r1.run();
    }

    public static String processFile() throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            return reader.readLine();
        }
    }

    public static String processFile(BufferReaderProcessor p) throws IOException{
        try (BufferedReader e = new BufferedReader(new FileReader("C:\\project\\demo\\src\\test\\java\\com\\example\\demo\\data.txt"))){
            return p.process(e);
        }
    }

    @org.junit.Test
    public void test6(){
        try {
            String oneLine = processFile((BufferedReader br)->br.readLine());
            String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println("oneLine : "+oneLine);
            System.out.println("twoLine : "+twoLine);
//oneLine : aaaaaaaaaaaaaaaa
// twoLine : aaaaaaaaaaaaaaaasssssssssssssss
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T, R> List<R> map(List<T> list,
                                     Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(f.apply(s));
        }
        return result;
    }

    @org.junit.Test
    public void test7(){
        List<Integer> list = map(
                Arrays.asList("apple","banana","watermalen"),
                (String::length)
        )    ;
    }

    @org.junit.Test
    public void test5(){
        try (
                Connection conn = null;
                Statement stmt = null;
                ResultSet resultSet = null;
                ){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 谓词复合
     */
    @org.junit.Test
    public void test8(){

        Predicate<Apple> redApple = (Apple a)->"red".equals(a.getColor());
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> redAndWeightApple = redApple.and(apple -> apple.getWeight()>150);
        Predicate<Apple> redWeightAppleOrGreenApple = redAndWeightApple.or(apple -> "green".equals(apple.getColor()));
    }

    public


}
