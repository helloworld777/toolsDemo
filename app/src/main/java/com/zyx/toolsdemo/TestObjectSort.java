package com.zyx.toolsdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Java对象排序的3种实现方式
 * @author zhangwenzhang
 *
 */
public class TestObjectSort {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**方法1
         * 使用Collections.sort(List, Comparator)实现，必须实现Comparator的一个比较器并复写compare()方法
         */
        Person1[] ps = new Person1[]{new Person1("p0",0),
                                     new Person1("p1",3),
                                     new Person1("p2",5),
                                     new Person1("p3",4),
                                     new Person1("p4",8),
                                     new Person1("p5",6),
                                     new Person1("p6",7),
                                     new Person1("p7",1),
                                     new Person1("p8",2),
                                     new Person1("p9",9)};
        List<Person1> pl = new ArrayList<Person1>();
        for(int i = 0; i < 10; i++){
            System.out.print(ps[i].getAge());
            pl.add(ps[i]);
        }
        System.out.println("\n使用Collections.sort(List, Comparator)类来比较：");
        long l1 = System.currentTimeMillis();
        Collections.sort(pl, new MyComparator());
        System.out.println("time: " + (System.currentTimeMillis() - l1));
        for(Iterator it = pl.iterator(); it.hasNext();){
            Person1 p = (Person1) it.next();
            System.out.print(p.getAge());
        }
        /**方法2
         * 使用Arrays.sort(Object[])实现,对象必须实现Comparable接口并复写compareTo()方法
         */
        Person2[] ps2 = new Person2[]{new Person2("p0",0),
                                     new Person2("p1",3),
                                     new Person2("p2",5),
                                     new Person2("p3",4),
                                     new Person2("p4",8),
                                     new Person2("p5",6),
                                     new Person2("p6",7),
                                     new Person2("p7",1),
                                     new Person2("p8",2),
                                     new Person2("p9",9)};
        System.out.println("\n使用Arrays.sort(Object[])类来比较：");
        long l2 = System.currentTimeMillis();
        Arrays.sort(ps2);
        System.out.println("time: " + (System.currentTimeMillis() - l2));
        for(int i = 0; i < 10; i++){
            System.out.print(ps2[i].getAge());
        }
        /**方法3
         * 使用Collections.sort(List)实现，对象必须实现Comparable接口并复写compareTo()方法
         */
        Person2[] ps3 = new Person2[]{new Person2("p0",0),
                                     new Person2("p1",3),
                                     new Person2("p2",5),
                                     new Person2("p3",4),
                                     new Person2("p4",8),
                                     new Person2("p5",6),
                                     new Person2("p6",7),
                                     new Person2("p7",1),
                                     new Person2("p8",2),
                                     new Person2("p9",9)};
        List<Person2> pl3 = new ArrayList<Person2>();
        for(int i = 0; i < 10; i++){
            pl3.add(ps3[i]);
        }
        System.out.println("\n使用Collections.sort(List)类来比较：");
        Collections.sort(pl3);
        for(Iterator it = pl3.iterator(); it.hasNext();){
            Person2 p = (Person2) it.next();
            System.out.print(p.getAge());
        }
    }
}
/**
 * 方法1需要
 * @author zhangwenzhang
 *
 */
class MyComparator implements Comparator {
    public int compare(Object o1, Object o2){
        Person1 p1 = (Person1)o1;
        Person1 p2 = (Person1)o2;
        if(p1.getAge() < p2.getAge()){
            return -1;
        }else if(p1.getAge() == p2.getAge()){
            return 0;
        }else{
            return 1;
        }
    }
}
/**
 * 方法1需要
 * @author zhangwenzhang
 *
 */
class Person1{
    private String name;
    private int age;
    public Person1(){}
    public Person1(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
/**
 * 方法2,3需要
 * @author zhangwenzhang
 *
 */
class Person2 implements Comparable{
    private String name;
    private int age;
    public Person2(){}
    public Person2(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int compareTo(Object o){
        Person2 p = (Person2)o;
        if(this.age < p.age){
            return -1;
        }else if(this.age == p.age){
            return 0;
        }else{
            return 1;
        }
    }
}