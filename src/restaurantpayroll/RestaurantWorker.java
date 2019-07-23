/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 *  Description: The RestaurantWorker class include the variable: name, 
 * phone number, netPay, and shift. This class will be carry out 
 * to input and output name, phoneNumber, netPay, and shift's workers.
 * RestaurantWorker class included the generatePayCheck() method 
 * is declared with abstract (no definition), the definition of 
 * generatePayCheck() method will be defined by its child class.
 */

package restaurantpayroll;

import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, May 3rd, 2018
 * Description: The RestaurantWorker class include the variable: name, 
 * phone number, netPay, and shift. This class will be carry out 
 * to input and output name, phoneNumber, netPay, and shift's workers.
 * RestaurantWorker class included the generatePayCheck() method 
 * is declared with abstract (no definition), the definition of 
 * generatePayCheck() method will be defined by its child class.
 */
abstract public class RestaurantWorker {
    protected String name;   // Worker's name provphoneed
    protected PhoneNumber phone;  // Worker's phoneNumber provphoneed
    protected double netPay; // Worker's netPay...must be calculated
    private Shift shift;     // Worker's shift
    protected final static double HealthInsuranceCOST = 68.50;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: the getShiftAsInput() method must be defined
     * Post-condition: input name, phone, netPay, and Shift of each
     * worker
     */
    public RestaurantWorker(){
        Scanner input = new Scanner(System.in);
        phone = new PhoneNumber();
        System.out.print(" \n\nPlease enter the employee's name > ");
        name = input.nextLine();
        
        try{
            phone.input();
        }catch(NullPointerException e){
            System.err.println("Error. You do not create a new object "
                    + "for PhoneNumber. Please create an object for"
                    + " PhoneNumber.");
            System.err.println("The exception message "
                    + "is: " + e.getMessage());
        }
        getShiftAsInput();
        
        netPay = 0.0d;
    }
    
    /**
     * C O N V E R S A T I O N  C O N S T R U C T O R
     * @param inName
     * @param inPhone
     * @param inShift 
     * Pre-condition: inPhone must be valid phone number
     * Post-condition: initialize the variable: name, phone (must be valid
     * phone number), netPay, and Shift depend on the parameters are passed
     */
    public RestaurantWorker (String inName, PhoneNumber inPhone, 
            Shift inShift){
        name = inName;
        if(inPhone.checkPhoneNumber() == 
                CheckCustomerPhoneNumber.validPhoneNumber){
            phone = inPhone;
        }
        netPay = 0.0d;
        shift = inShift;
    }
    
    /**
     * Mutator: getShiftAsInput()
     * Pre-condition: none
     * Post-condition: input the shift (Breakfast, Lunch, Dinner, and
     * Swing)
     */
    private void getShiftAsInput()
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("**************************"
                + "********************");
        System.out.print(" Please enter " + getName()
                + "'s Shift by Number:\n"
                         + "1.  Breakfast\n"
                         + "2.  Lunch\n"
                         + "3.  Dinner\n"
                         + "4.  Swing \n========> ");
        String inShift = cin.nextLine();
        System.out.println("*********************"
                + "*************************");
        switch(inShift){
            case "1": shift = Shift.breakfast; break;
            case "2": shift = Shift.lunch; break;
            case "3": shift = Shift.dinner; break;
            case "4": shift = Shift.swing; break;
            default: getShiftAsInput(); break;
        }
    }
    
    /**
     * Mutator: setName()
     * @param empName
     * Pre-condition: none
     * Post-condition: assign empName to name
     */
    protected void setName (String empName)
    {
        name = empName;
    }

    /**
     * Mutator: setPhone()
     * @param empNumber 
     * Pre-condition: empNumber must be valid phone number
     * Post-condition: assign empNumber to phone if empNumber is valid
     * phone number
     */
    public void setPhone (PhoneNumber empNumber)
    {
        if(empNumber.checkPhoneNumber() == 
                CheckCustomerPhoneNumber.validPhoneNumber){
            phone = empNumber;
        }
    }
    
    /**
     * Mutator: setShift()
     * @param inShift 
     * Pre-condition: none
     * Post-condition: assign inShift to shift
     */
    public void setShift (Shift inShift)
    {
        shift = inShift;
    }
    
    /**
     * Accessor: getName()
     * @return name
     * Pre-condition: none
     * Post-condition: get the value of name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Accessor: getPhone()
     * @return phone
     * Pre-condition: none
     * Post-condition: get the value of phone
     */
    public PhoneNumber getPhone()
    {
        return phone;
    }
    
    /**
     * Accessor: getPay()
     * @return netPay
     * Pre-condition: none
     * Post-condition: get the value of netPay
     */
    public double getPay()
    {
        return netPay;
    }
    
    /**
     * Accessor: getShift()
     * @return shift
     * Pre-condition: none
     * Post-condition: get the value of shift
     */
    public Shift getShift()
    {
        return shift;
    }
    
    /**
     * Mutator: generatePayCheck()
     * Pre-condition: must be the abstract method, no definition
     * Post-condition: the method will be defined by its child class
     */
    abstract protected void generatePayCheck();
    
    /**
     * Accessor: toString()
     * @return out
     * Pre-condition: none
     * Post-condition: output all the information of RestaurantWorker class
     */
    public String toString()
    {
        String out = "\tBlue Moon Cafe Employee Information\n";
        //out += " Name "+ name + "\t" + phone + "\tShift: " + shift +"\n";
        out += " Name: " + name + " \t\tShift: " + shift + "\n";
        out += phone;
        return out;
    }
}
