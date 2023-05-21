package HW_09_16052023;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Start {
    private static List<Integer> list = new ArrayList<>(10_000_000);
    private static int tempStatic;


    public static void main(String[] args) {

        fill10MArrayList(list);
        workResultTimesForeachandStatic(list);
        workResultTimesForeach(list);
        workResultTimesClassicForIncr(list);
        workResultTimesClassicForIncrExample2(list);
        workResultTimesClassicForDecr(list);
        workResultTimesIterator(list);
        workResultTimesListIterator(list);
    }

    public static void fill10MArrayList(List<Integer> list) {

        for (int i = 0; i < 10_000_000; i++) {
            int temp=i;
            list.add(temp);
        }
        System.out.println();
    }
    // перебираем список с помощью foreach loop + static
    public static void workResultTimesForeachandStatic(List<Integer> list) {
        long start = System.currentTimeMillis();        // замер времени
        for (Integer i : list) {
            tempStatic = i;
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("замер времени \"foreach loop and staticINT\" ============== : " + result + " msec.");
    }

    // перебираем список с помощью foreach loop
    public static void workResultTimesForeach(List<Integer> list) {
        long start = System.currentTimeMillis();        // замер времени
        for (Integer i : list) {
            int temp = i;
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("замер времени \"foreach loop\" ============== : " + result + " msec.");
    }

    // classic for и вызываем list.size() для каждой итерации:
    public static void workResultTimesClassicForIncr(List<Integer> list) {
        long start = System.currentTimeMillis();        // замер времени
        for (int i = 0; i < list.size(); i++) {
             int temp = i;
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("замер времени \"classic for incr. example 1\" : " + result + " msec.");
    }

    // classic for, но list.size() определяем в переменную

    public static void workResultTimesClassicForIncrExample2 (List<Integer> list) {
        long start = System.currentTimeMillis();        // замер времени
        int size = list.size();
        for (int i = 0; i < size; i++) {
             int temp = i;
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("замер времени \"classic for incr. example 2\" : " + result + " msec.");
    }


    //  classic for, list.size() определяем в переменную, перебираем с конца (i--)

    public static void workResultTimesClassicForDecr(List<Integer> list) {
        long start = System.currentTimeMillis();        // замер времени

        int size = list.size();
        for (int i = size; i >= 0; i--) {
            int temp = i;
        }

        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("замер времени \"classic for decr. example 3\" : " + result + " msec.");
    }

    // используя Iterator
    public static void workResultTimesIterator (List<Integer> list) {
        long start = System.currentTimeMillis();        // замер времени

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int temp = iterator.next();
        }

        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("замер времени \"Iterator\" ================== : " + result + " msec.");
    }

    // используя ListIterator
    public static void workResultTimesListIterator (List<Integer> list) {
        long start = System.currentTimeMillis();        // замер времени

        ListIterator<Integer> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()){
           int  temp = iterator.previous();
        }

        long end = System.currentTimeMillis();
        long result = end - start;
        System.out.println("замер времени \"ListIterator\" ============== : " + result + " msec.");
    }
}
