package cisco;

import java.util.Calendar;
import java.util.Date;

public class ImmutableClassTest {

    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.DATE, 25);
        c1.set(Calendar.MONTH, 5);
        c1.set(Calendar.YEAR, 1992);
        Date dob = c1.getTime();
        Employee emp1 = new Employee("Avanish", 29, dob);
        System.out.println("Print 1:"+ emp1);
        Date emp1DOB = emp1.getDob();
        emp1DOB.setYear(2000);
        System.out.println("Print 2:"+ emp1);
    }
}
