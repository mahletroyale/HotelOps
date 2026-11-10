

import java.time.LocalDateTime;

public class Employee {

    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private int startHour;
    private int startMinute;
    private boolean punchedIn;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;

        this.startHour = 0;
        this.startMinute = 0;
        this.punchedIn = false;
    }

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

    public void punchIn(int time) {
        startShift(time, 0);
    }

    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();

        int hour = now.getHour();
        int minute = now.getMinute();

        startShift(hour, minute);
    }

    private void startShift(int hour, int minute) {

        if (hour < 0 || hour > 23) {
            System.out.println("Invalid time.");
            return;
        }

        if (punchedIn) {
            System.out.println("Employee is already punched in.");
            return;
        }

        startHour = hour;
        startMinute = minute;
        punchedIn = true;

        System.out.printf("%s punched in at %02d:%02d%n",
                name, hour, minute);
    }

    public void punchOut(int time) {
        endShift(time, 0);
    }

    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();

        int hour = now.getHour();
        int minute = now.getMinute();

        endShift(hour, minute);
    }

    private void endShift(int hour, int minute) {

        if (hour < 0 || hour > 23) {
            System.out.println("Invalid time.");
            return;
        }

        if (!punchedIn) {
            System.out.println("Employee has not punched in.");
            return;
        }

        int startTotalMinutes = startHour * 60 + startMinute;
        int endTotalMinutes = hour * 60 + minute;

        if (endTotalMinutes < startTotalMinutes) {
            endTotalMinutes += 24 * 60;
        }

        double shiftHours =
                (endTotalMinutes - startTotalMinutes) / 60.0;

        hoursWorked += shiftHours;
        punchedIn = false;

        System.out.printf("%s punched out at %02d:%02d%n",
                name, hour, minute);

        System.out.printf("Hours this shift: %.2f%n", shiftHours);
        System.out.printf("Total hours worked: %.2f%n", hoursWorked);
    }

    public void punchTimeCard(int time) {
        if (!punchedIn) {
            punchIn(time);
        } else {
            punchOut(time);
        }
    }
}
