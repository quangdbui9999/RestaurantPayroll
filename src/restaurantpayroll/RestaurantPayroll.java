/*
 *  CSC-122 SP 2018 PROJECT: Lab # 8 Restaurant Employee Payroll
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 *  Description: RestaurantPayroll class is the main class to run the
 * restaurantpayroll application by calling the ManagerEmployee class
 * (the combination of all classes) the run it.
 */

package restaurantpayroll;

import java.io.IOException;
import java.time.LocalDate;


/**
 * DRIVE FILE
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class RestaurantPayroll {
        
    public static void main(String[] args) throws IOException {
        // RestaurantWorker is abstract class, cannot be instantiated
        // RestaurantWorker newHire = new RestaurantWorker();
        
        ManagerEmployee boss = new ManagerEmployee();
        boss.displayInformation();
        boss.writePaystubs("paystub.dat");
        
        LocalDate a = LocalDate.now();
        System.out.println(a);
    }
}
