public class Employee extends User{
    String password;
    double salary;
    final static double salaryMin = 5000;

    public void display() {
        System.out.println("Employee: " + getName() +
                "\n\tid: " + getId() +
                "\n\tsalary: " + salary);
    }

    public void setPassword(String password) {
        boolean valid = password.matches("[^\s]") && Validator.lengthInRange(password, 8, 20);

        if(valid)
            this.password = password;
    }

    public boolean setSalary(double salary){
        if(salary < salaryMin){
            System.out.println("Operation failed. Salary cannot go below $" + salaryMin);
            return false;
        }
        this.salary = salary;
        return true;
    }

    @Override
    void setManager() {
        System.out.println("this does nothing");
    }

    public String toString(){
        String result = super.toString();
        return result +
                salary + '\n' +
                password + '\n';
    }
}
