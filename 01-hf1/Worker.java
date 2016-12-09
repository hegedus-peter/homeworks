package pkg02_javaee_kft;

import java.util.Date;

public class Worker extends Person{

    public Worker(String name, Date birthDate, int salary, int budget, Company workplace) {
        super(name, birthDate, salary, budget, workplace);
    }

    @Override
    public void work() {
          this.workplace.setBudget(this.workplace.getBudget()+10000);
          System.out.println(this.name + "(worker) is working.");
    }
    
}
