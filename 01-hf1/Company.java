package pkg02_javaee_kft;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Company {

    private String location;
    private String name;
    private int budget;
    private List<Worker> workers;
    private List<Boss> bosses;
    
    public Company(String location, String name, int budget){
        this.location=location;
        this.name=name;
        this.budget=budget;
        this.workers=new ArrayList<Worker>();
        this.bosses=new ArrayList<Boss>();
    }
    
    public void hireBoss(Boss boss){
    bosses.add(boss);
    System.out.println(this.name + " hired " + boss.name + " " + boss.birthDate + ". Salary: " + boss.salary); 
    };
    
    public void hireWorker(Worker worker){
    workers.add(worker);
    System.out.println(this.name + " hired " + worker.name + " " + worker.birthDate + ". Salary: " + worker.salary); 
    };
    
    public void fireBoss(Boss boss){
     for(int i=0; i<bosses.size();i++){
         if(bosses.get(i).equals(boss)){
             bosses.remove(i);
             System.out.println(boss.name + " was fired.");
         }
     }
    };
    
    public void fireWorker(Worker worker){
     for(int i=0; i<workers.size();i++){
         if(workers.get(i).equals(worker)){
             workers.remove(i);
             System.out.println(worker.name + " was fired.");
         }
     }
    };
    
    public void giveSalary(Person person){
    person.setBudget(person.getBudget() + person.getSalary());
    this.budget-=person.getSalary();
    System.out.println(person.name + " was paid. His new budget: " + person.budget + ". Company's new budget: " + this.budget );
    };

    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int budget) {
       this.budget=budget;
    }
    
    public void workAll(){
       for (Worker worker : workers) {
            worker.work();
            this.giveSalary(worker);
        }
        for (Boss boss : bosses) {
            boss.work();
            this.giveSalary(boss);
        }
    }
    
}
