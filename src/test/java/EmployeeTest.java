



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void calculateHoursWorked() {

        // arrange
        Employee employee = new Employee(101, "Sarah", "Front Desk", 20.00, 0);
        double expected = 8.0;

        // act
        employee.punchIn(9);
        employee.punchOut(17);

        // assert
        assertEquals(expected, employee.getHoursWorked());
    }

    @Test
    void calculateMultipleShifts() {

        // arrange
        Employee employee = new Employee(101, "Sarah", "Front Desk", 20.00, 0);

        double expected = 7.0;

        // act
        employee.punchIn(9);
        employee.punchOut(12);

        employee.punchIn(13);
        employee.punchOut(17);

        // assert
        assertEquals(expected, employee.getHoursWorked());
    }

    @Test
    void calculateOvernightShift() {

        // arrange
        Employee employee = new Employee(101, "Sarah", "Front Desk", 20.00, 0);
        double expected = 8.0;

        // act
        employee.punchIn(22);
        employee.punchOut(6);

        // assert
        assertEquals(expected, employee.getHoursWorked());
    }

    @Test
    void punchOutWithoutPunchingIn() {

        // arrange
        Employee employee = new Employee(101, "Sarah", "Front Desk", 20.00, 0);
        double expected = 0.0;

        // act
        employee.punchOut(17);

        // assert
        assertEquals(expected, employee.getHoursWorked());
    }

    @Test
    void punchInTwice() {

        // arrange
        Employee employee = new Employee(101, "Sarah", "Front Desk", 20.00, 0);
        double expected = 8.0;

        // act
        employee.punchIn(9);
        employee.punchIn(10);
        employee.punchOut(17);

        // assert
        assertEquals(expected, employee.getHoursWorked());
    }

    @Test
    void calculateOvertimeHours() {

        // arrange
        Employee employee = new Employee(101, "Sarah", "Front Desk", 20.00, 40);
        double expected = 5.0;

        // act
        employee.punchIn(9);
        employee.punchOut(14);

        // assert
        assertEquals(expected, employee.getOvertimeHours());
    }
}
