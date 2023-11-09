package Homework4;

import Classwork.SLListSimple;

public class ElectingLeader {

    public int electLeader(int n, int m){
        SLListSimple<Integer> list = new SLListSimple<Integer>();
        for(int i = 0; i < n; i++){
            list.addLast(i);
        }
        int count = 0;
        while(list.size() > 1){
            if(count == m){
                list.removeFirst();
                count = 1;
            }
            else{
                list.addLast(list.removeFirst());
                count++;
            }
        }
        return list.removeFirst();
    }

    public static void main(String[] args) {
        ElectingLeader ex = new ElectingLeader();
        System.out.println(ex.electLeader(9, 5)); //This should print 8
        System.out.println(ex.electLeader(7, 3)); //This should print 4
        System.out.println(ex.electLeader(12, 7)); //This should print 0
    }
}
