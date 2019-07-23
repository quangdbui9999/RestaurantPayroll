/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 *  Description: ManagerEmployee class is declared some kind of employees:
 * Manager, WaitStaff, and KitchenStaff. This class uses only one variable
 * is an array. staffs is an array of all employees in the restaurant:
 * Manager, WaitStaff, and KitchenStaff. This class will use the feature
 * polymorphism to call each employee (polymorphism help the staffs array
 * distinguish each kind of employee)
 */

package restaurantpayroll;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 *
 * Programmed by: Quang Bui
 * Due Date: Thursday, May 3rd, 2018
 * Description: ManagerEmployee class is declared some kind of employees:
 * Manager, WaitStaff, and KitchenStaff. This class uses only one variable
 * is an array. staffs is an array of all employees in the restaurant:
 * Manager, WaitStaff, and KitchenStaff. This class will use the feature
 * polymorphism to call each employee (polymorphism help the staffs array
 * distinguish each kind of employee)
 */
public class ManagerEmployee {
    private RestaurantWorker[] staffs;
    //public static final int SIZE = 9;
    public static final int SIZE = 6;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: all the constructor method Manager, WaitStaff, 
     * and KitchenStaff classed must be defined
     * Post-condition: create the new employee (Manager, WaitStaff, 
     * and KitchenStaff) depend on each constructor of each class
     */
    public ManagerEmployee(){
        try{
            staffs = new RestaurantWorker[SIZE];
            PhoneNumber number1 = new PhoneNumber();
            number1.setCustomerPhoneNumber("3051112222");
            PhoneNumber number2 = new PhoneNumber();
            number2.setCustomerPhoneNumber("7603334444");
            PhoneNumber number3 = new PhoneNumber();
            number3.setCustomerPhoneNumber("7325556666");
            PhoneNumber number4 = new PhoneNumber();
            number4.setCustomerPhoneNumber("3157777888");
            PhoneNumber number5 = new PhoneNumber();
            number5.setCustomerPhoneNumber("3609900112");
            PhoneNumber number6 = new PhoneNumber();
            number6.setCustomerPhoneNumber("9363421532");

            staffs[0] = new Manager("Sakura", number1, 
                    Shift.dinner, 12, 0.64, 1053.67);
            staffs[1] = new WaitStaff("Tomoyo", number2, Shift.breakfast,
                    60, 12.3, 18);
            staffs[2] = new KitchenStaff("Li Shaoran", number3, 
                    Shift.lunch, 50, 11.6, 20);
            staffs[3] = new WaitStaff("Li Meilin", number3, Shift.lunch, 
                    32, 8.6, 12.4, 14.3, 201.35);
            staffs[4] = new KitchenStaff("Toya", number5, Shift.swing, 
                    64, 20.5, 20.0, 2.5);
            staffs[5] = new KitchenStaff("Yuki", number6, Shift.dinner, 
                    34, 10.5, 10.0, 2.2);
            //staffs[6] = new Manager();
            //staffs[7] = new KitchenStaff();
            //staffs[8] = new WaitStaff();
        }catch(NullPointerException e){
            System.err.println("The exception message: " + e.getMessage());
        }
    }
    
    /**
     * Mutator: displayInformation()
     * Pre-condition: all the toString() and generatePayCheck() method 
     * of Manager, WaitStaff, and KitchenStaff classed must be defined
     * Post-condition: output all the information and salary of each
     * employee (Manager, WaitStaff, and KitchenStaff) base on 
     * the polymorphism feature
     */
    public void displayInformation(){
        int count = 0;
        for(RestaurantWorker who:staffs){
            count++;
            System.out.println("The employee: " + count + ".");
            
            try{
                System.out.println(who); // polymorphism
                who.generatePayCheck(); // polymorphism
            }catch(NullPointerException e){
                System.err.println("Error Nullpointer exception in "
                        + "displayInformation method.");
                System.err.println("The message exception: "
                        + "" + e.getMessage());
            }
            System.out.println("------------------------------------"
                    + "-------");
        }
    }
    
    /**
     * Mutator: writePaystubs()
     * @param fileName
     * @throws IOException 
     * Pre-condition: all the toString() and generatePayCheck() method 
     * of Manager, WaitStaff, and KitchenStaff classed must be defined
     * Post-condition: output all the information and salary of each
     * employee (Manager, WaitStaff, and KitchenStaff) base on 
     * the polymorphism feature to file named fileName
     */
    public void writePaystubs(String fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName, false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter outFile = new PrintWriter(bw);
        DecimalFormat fmt = new DecimalFormat("0.00");
        
        for(RestaurantWorker who:staffs){
            try{
                outFile.print(who); // polymorphism
                outFile.print("Salary: " 
                        + fmt.format(who.netPay) + "\n");  // polymorphism
                outFile.print("------------------------------"
                        + "-------------\n");
            }catch(NullPointerException e){
                System.err.println("Error Nullpointer exception in "
                        + "writePaystubs method.");
                System.err.println("The message exception: "
                        + "" + e.getMessage());
            }
        }
        
        outFile.close();
    }
}
