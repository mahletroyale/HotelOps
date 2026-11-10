
public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private int startTime;
    private boolean punchedIn;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;

        this.startTime = 0;
        this.punchedIn = false;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getRegularHours() {

        if (hoursWorked <= 40) {
            return hoursWorked;
        }

        return 40;
    }

    public double getOvertimeHours() {

        if (hoursWorked > 40) {
            return hoursWorked - 40;
        }
        return 0;
    }

    public double getTotalPay() {

        double regularPay = getRegularHours() * payRate;
        double overtimePay = getOvertimeHours() * payRate * 1.5;
        return regularPay + overtimePay;
    }

    // Employee punches in
    public void punchIn(int time) {

        if (time < 0 || time > 23) {
            System.out.println("Invalid time.");
            return;
        }

        if (!punchedIn) {
            startTime = time;
            punchedIn = true;

            System.out.println(name + " punched in at " + time + ":00");
        } else {
            System.out.println("Employee is already punched in.");
        }
    }

    public void punchOut(int time) {

        if (time < 0 || time > 23) {
            System.out.println("Invalid time.");
            return;
        }

        if (punchedIn) {

            int shiftHours = time - startTime;
            if (shiftHours < 0) {
                shiftHours = shiftHours + 24;
            }

            hoursWorked = hoursWorked + shiftHours;
            punchedIn = false;
            System.out.println(name + " punched out at " + time + ":00");
            System.out.println("Hours worked this shift: " + shiftHours);
            System.out.println("Total hours: " + hoursWorked);

        } else {
            System.out.println("Employee has not punched in.");
        }
    }

    public void punchTimeCard(int time) {

        if (!punchedIn) {
            punchIn(time);
        } else {
            punchOut(time);
        }
    }
}
