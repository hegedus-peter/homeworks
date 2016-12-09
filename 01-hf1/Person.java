package pkg02_javaee_kft;

import java.util.Date;

public abstract class Person{
    
    protected String name;
    protected Date birthDate;
    protected int salary;
    protected int budget;
    protected Company workplace;
    
    public Person(String name, Date birthDate, int salary, int budget, Company workplace){
        this.name=name;
        this.birthDate=birthDate;
        this.salary=salary;
        this.budget=budget;
        this.workplace = workplace;
    }
    
    public abstract void work();

    public int getSalary(){
        return this.salary;
    };
    
    public int getBudget() {
        return this.budget;
    }
    
   public void setBudget(int budget) {
        this.budget=budget;
    }
}
