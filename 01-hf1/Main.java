package pkg02_javaee_kft;

import java.util.Date;

public class Main {

  static public void test(){
      Company testCompany = new Company("1075 Budapest, Karoly krt. 3/A","XYZ Kft",100000);
      
        Worker worker0 = new Worker( "John Smith",new Date(90,10,21),20000,0,testCompany);
        Worker worker1 = new Worker( "Jane Jones",new Date(88,1,13),10000,10000,testCompany);
        Worker worker2 = new Worker( "Gregory Williams",new Date(98,12,30),5000,84500,testCompany);
        Worker worker3 = new Worker( "Susan Taylor",new Date(99,8,03),1000,67843,testCompany);
        Worker worker4 = new Worker( "Harry Brown",new Date(92,11,07),15000,100000,testCompany);
        Boss boss0 = new Boss( "Peter Wilson",new Date(70,10,25),50000, 150000, testCompany);
        
        testCompany.hireWorker(worker0);
        testCompany.hireWorker(worker1); 
        testCompany.hireWorker(worker2);
        testCompany.hireWorker(worker3);
        testCompany.hireWorker(worker4);
        testCompany.hireBoss(boss0);
        
        testCompany.workAll();
        
        testCompany.fireWorker(worker1);
        boss0.fireSomeone(worker3);
        testCompany.fireBoss(boss0);
  }
    public static void main(String[] args) { 
        test(); 
    }
    
}
