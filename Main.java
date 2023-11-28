import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;


    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public abstract double calCulateSallary(); // abstract method


    @Override
    public String toString() {   // override tostring method

        return "name= " + name + "  id= " + id + "  Sallary= "+calCulateSallary();

    }
}

class FullTimeEmployee extends Employee{

    private double monthlySallary;


    public FullTimeEmployee(String name, int id, double monthlySallary){
        super(name, id);
        this.monthlySallary=monthlySallary;
    }
    @Override
    public double calCulateSallary() {
        return monthlySallary;
    }
}


class PartTimeEmployee extends Employee{
    private double monthlysallary;
    private int hoursWork;
    private double houryrate;

    public PartTimeEmployee(String name,int id,int hoursWork,double houryrate){
        super(name, id);
        this.hoursWork=hoursWork;
        this.houryrate=houryrate;
    }


    @Override
    public double calCulateSallary() {

        return houryrate*hoursWork;
    }
}



class PayrollSystem {

    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList=new ArrayList<>();

    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeetoremove=null;

        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeetoremove=employee;
                break;
            }
        }

        if(employeetoremove !=null){
            employeeList.remove(employeetoremove);
        }
    }

    public void displayEmployee(){

        for(Employee employee:employeeList){
            System.out.println(employee+ "  ");
        }
    }
}




public class Main {

    public static void main(String[] args) {
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("Shubham",1,45000);
        PartTimeEmployee emp2=new PartTimeEmployee("Saurabh",2,136,70);
        FullTimeEmployee emp3=new FullTimeEmployee("Vishal",3,16000);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);

        System.out.println("Initial Employee Details  ");
        payrollSystem.displayEmployee();

        System.out.println("Removing Employees ");
        payrollSystem.removeEmployee(2);

        System.out.println("Remaining Employee Details : ");
        payrollSystem.displayEmployee();

        payrollSystem.addEmployee(emp3);

        payrollSystem.displayEmployee();




    }
}