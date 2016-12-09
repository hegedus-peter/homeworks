package pkg02_javaee_kft;

import java.util.Date;

public class Boss extends Person{

    public Boss(String name, Date birthDate, int salary, int budget, Company workplace) {
        super(name, birthDate, salary, budget, workplace);
    }

    @Override
    public void work() {
        this.workplace.setBudget(this.workplace.getBudget()+20000);
        System.out.println(this.name + "(boss) is working.");
    }
    
    public void fireSomeone(Worker worker){
    System.out.println(this.name + " wants to fire " + worker.name);
    this.workplace.fireWorker(worker);
    };
}
