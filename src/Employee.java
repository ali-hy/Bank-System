public class Employee extends User{
    String name;
    int id;
    String password;
    double salary;

    public void display() {
        System.out.println("Employee: " + name +
                "\n\tid=" + id +
                "\n\tsalary=" + salary);
    }

    public void setPassword(String password) {
        boolean valid = password.matches("[^\s]") && Validator.lengthInRange(password, 8, 20);

        if(valid)
            this.password = password;
    }

    public void setSalary(double salary){
        boolean valid = salary >= 5000;

        if(valid)
            this.salary = salary;
    }
}
