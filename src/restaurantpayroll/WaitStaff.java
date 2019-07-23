/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 *  Description: A WaitStaff is a sub class of 
 * super class HourlyWorker
 * An WaitStaff has added members: gratuities (tips of each WaitStaff)
 * and uniformAllowance (for the senior people, old people)
 * This class also implements Payroll interface and define the CalculatePay
 * method is declared in Payroll interface
 * Set/Get methods are provided as well as an overridden 
 * generatePayCheck() method that uses the (new Java 8) time stamp 
 * for dates on the pay stubs
 * Note the toString() method also calls the super.toString() 
 * for the common HourlyWorker and RestaurantWorker info
 */

package restaurantpayroll;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * Programmed by: Quang Bui
 * Due Date: Thursday, May 3rd, 2018
 * Description: A WaitStaff is a sub class of 
 * super class HourlyWorker
 * An WaitStaff has added members: gratuities (tips of each WaitStaff)
 * and uniformAllowance (for the senior people, old people)
 * This class also implements Payroll interface and define the CalculatePay
 * method is declared in Payroll interface
 * Set/Get methods are provided as well as an overridden 
 * generatePayCheck() method that uses the (new Java 8) time stamp 
 * for dates on the pay stubs
 * Note the toString() method also calls the super.toString() 
 * for the common HourlyWorker and RestaurantWorker info
 */
public class WaitStaff extends HourlyWorker implements Payroll{
    private double gratuities;
    private double uniformAllowance;
    private static final double MIN_GRATUITY = 2.0d;
    private static final double MAX_GRATUITY = 10.0;
    private static final double ALLOWANCE = 200.0d;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: inGratuities must be in the range [2.0 - 10.0]
     * and inUniformAllowance must be > 200.0
     * The default constructor of RestaurantWorker and HourlyWorker
     * class must be defined
     * Post-condition: input uniformAllowance
     * if uniformAllowance > 200.0
     * otherwise, you input again
     * input gratuities if gratuities
     * in the range [2.0 - 10.0]
     * otherwise, you input again
     */
    public WaitStaff(){
        super();
        System.out.println("Pleasen enter the WaitStaff's infomation: ");
        Scanner cin = new Scanner(System.in);
        boolean flag = false;
        
        while(flag == false){
            try{
                do{
                    System.out.print(" Enter the gratuities [" 
                            + MIN_GRATUITY + " - " + MAX_GRATUITY + "]: ");
                    gratuities = Double.parseDouble(cin.nextLine());
                    if(!(MIN_GRATUITY <= gratuities 
                            && gratuities <= MAX_GRATUITY)){
                        System.err.println("The gratuities must"
                                + " be in the range [" + MIN_GRATUITY +
                                " - " + MAX_GRATUITY + "].");
                    }
                }while(!(MIN_GRATUITY <= gratuities 
                        && gratuities <= MAX_GRATUITY));
                flag = true;
            }catch(NumberFormatException e){
                System.out.println("Input is not a valid double.");
                System.out.println("The exception message "
                        + "is: " + e.getMessage());
            }
        }
        
        flag = false;
        
        while(flag == false){
            try{
                do{
                    System.out.print(" Enter the uniform allowance"
                            + " (> " + ALLOWANCE + "): ");
                    uniformAllowance = Double.parseDouble(cin.nextLine());
                    if(uniformAllowance < ALLOWANCE){
                        System.err.println("The uniform allowance must"
                                + " be greater than or equals to "
                                + ALLOWANCE + ".");
                    }
                }while(uniformAllowance < ALLOWANCE);
                flag = true;
            }catch(NumberFormatException e){
                System.out.println("Input is not a valid double.");
                System.out.println("The exception message "
                        + "is: " + e.getMessage());
            }
        }
    }
    
    /**
     * C O N V E R S A T I O N  C O N S T R U C T O R
     * @param inName
     * @param inPhone
     * @param inShift
     * @param hours
     * @param rate
     * @param inTips 
     * Pre-condition: 
     * The conversion constructor of RestaurantWorker and HourlyWorker
     * class must be defined
     * Post-condition: assign 360.42 to uniformAllowance
     * and assign 10.3 to gratuities
     */
    public WaitStaff(String inName, PhoneNumber inPhone, Shift inShift, 
            double hours, double rate, double inTips){
        super(inName, inPhone, inShift, hours, rate, inTips);
        gratuities = 10.3;
        uniformAllowance = 360.42;
    }
    
    /**
     * C O N V E R S A T I O N  C O N S T R U C T O R
     * @param inName
     * @param inPhone
     * @param inShift
     * @param hours
     * @param rate
     * @param inTips
     * @param inGratuities
     * @param inUniformAllowance 
     * Pre-condition: inGratuities must be in the range [2.0 - 10.0]
     * and inUniformAllowance must be > 200.0
     * The conversion constructor of RestaurantWorker and HourlyWorker
     * class must be defined
     * Post-condition: assign inUniformAllowance to uniformAllowance
     * if inUniformAllowance > 200.0
     * otherwise, uniformAllowance = ALLOWANCE;
     * assign inGratuities to gratuities if inGratuities
     * in the range [2.0 - 10.0]
     * otherwise, gratuities = MIN_GRATUITY;
     */
    public WaitStaff(String inName, PhoneNumber inPhone, Shift inShift, 
            double hours, double rate, double inTips, 
            double inGratuities, double inUniformAllowance){
        super(inName, inPhone, inShift, hours, rate, inTips);
        
        if(MIN_GRATUITY <= inGratuities && inGratuities <= MAX_GRATUITY){
            gratuities = inGratuities;
        }else{
            gratuities = MIN_GRATUITY;
        }
        
        if(inUniformAllowance < ALLOWANCE){
            uniformAllowance = ALLOWANCE;
        }else{
            uniformAllowance = inUniformAllowance;
        }
    }
    
    /**
     * Accessor: getGratuities()
     * @return gratuities
     * Pre-condition: none
     * Post-condition: get the value of gratuities
     */
    public double getGratuities() {
        return gratuities;
    }

    /**
     * Mutator: setGratuities()
     * @param inGratuities 
     * Pre-condition: inGratuities must be in the range [2.0 - 10.0]
     * Post-condition: assign inGratuities to gratuities if inGratuities
     * in the range [2.0 - 10.0]
     * otherwise, gratuities = MIN_GRATUITY;
     */
    public void setGratuities(double inGratuities) {
        if(MIN_GRATUITY <= inGratuities && inGratuities <= MAX_GRATUITY){
            gratuities = inGratuities;
        }else{
            gratuities = MIN_GRATUITY;
        }
    }

    /**
     * Accessor: getUniformAllowance()
     * @return uniformAllowance
     * Pre-condition: none
     * Post-condition: get the value of uniformAllowance
     */
    public double getUniformAllowance() {
        return uniformAllowance;
    }

    /**
     * Mutator: setUniformAllowance()
     * @param inUniformAllowance 
     * Pre-condition: inUniformAllowance must be > 200.0
     * Post-condition: assign inUniformAllowance to uniformAllowance
     * if inUniformAllowance > 200.0
     * otherwise, uniformAllowance = ALLOWANCE;
     */
    public void setUniformAllowance(double inUniformAllowance) {
        if(inUniformAllowance < ALLOWANCE){
            uniformAllowance = ALLOWANCE;
        }else{
            uniformAllowance = inUniformAllowance;
        }
    }
    
    /**
     * Mutator: generatePayCheck
     * Pre-condition: CalculatePay() method must be defined
     * Post-condition: output the information of WaitStaff class and
     * the netPay (salary) of that WaitStaff
     */
    protected void generatePayCheck(){
        DecimalFormat fmt = new DecimalFormat("0.00");
        CalculatePay();
        LocalDate currentDate = LocalDate.now();
        System.out.println(" ================================"
                + "=================");
        System.out.println ( "\t  Blue Moon Cafe Earnings Statement\n\t"
                           + "  Pay period ending:   "
                + currentDate +" \n");
        System.out.println ( "\tWAITER (WAITRESS): Salaried Employee");
        System.out.println("\tName: " + getName() + "\t\tShift: "
                + getShift());
        System.out.println("\n\tAmount electronically deposited: $"
                + fmt.format(CalculatePay()));
        System.out.println(" =============================="
                + "===================");
    }
    
    /**
     * Accessor: toString()
     * @return out
     * Pre-condition: the toString method() of RestaurantWorker 
     * and HourlyWorker class must be defined
     * Post-condition: output all the information of WaitStaff class
     */
    public String toString(){
        String output = "";
        output += super.toString();
        output += " Waiter (Waitress) Staff:\n ";
        output += "\t The gratuities is: " + gratuities + ". \n";
        output += "\t The uniform allowance is: " 
                + uniformAllowance + ". \n";
        return output;
    }
    
    /**
     * Accessor: CalculatePay()
     * @return netPay
     * Pre-condition: implements the Payroll interface
     * Post-condition: calculate the netPay of WaitStaff
     * if netPay < 0 (netPay = 0); otherwise, netPay is the salary of 
     * WaitStaff
     */
    public double CalculatePay(){
        netPay = (hoursWorked * hourlyRate) + tips 
                + gratuities - HealthInsuranceCOST;
        if(netPay < 0.0){
            netPay = 0.0;
        }
        return netPay;
    }
}
