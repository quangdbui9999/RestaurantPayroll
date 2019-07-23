/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 *  Description: A KitchenStaff is a sub class of 
 * super class HourlyWorker
 * An KitchenStaff has added members overTimeRate (for person who work over
 * 40 hours)
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
 * Description: A KitchenStaff is a sub class of 
 * super class HourlyWorker
 * An KitchenStaff has added members overTimeRate (for person who work over
 * 40 hours)
 * This class also implements Payroll interface and define the CalculatePay
 * method is declared in Payroll interface
 * Set/Get methods are provided as well as an overridden 
 * generatePayCheck() method that uses the (new Java 8) time stamp 
 * for dates on the pay stubs
 * Note the toString() method also calls the super.toString() 
 * for the common HourlyWorker and RestaurantWorker info
 */
public class KitchenStaff extends HourlyWorker implements Payroll{
    private double overTimeRate;
    private static final double MAX_HOURS_WORKED = 40.0d;
    private static final double MAX_OVERTIME = 3.0d;
    private static final double MIN_OVERTIME = 1.0d;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: the default constructor of RestaurantWorker
     * and HourlyWorker class must be defined
     * Post-condition: overTimeRate only input when hourWorked >= 40 and
     * overTimeRate must be in the range [1.0 - 3.0]
     */
    public KitchenStaff(){
        super();
        System.out.println("Pleasen enter the KitchenStaff's "
                + "infomation: ");
        Scanner cin = new Scanner(System.in);
        boolean flag = false;
        
        if(hoursWorked <= MAX_HOURS_WORKED){
            System.err.println("You worked is: "
                    + hoursWorked + " hours.");
            System.err.println("You don't have the number of "
                    + "over-time hour.");
        }else if(hoursWorked > MAX_HOURS_WORKED){
            while(flag == false){
                try{
                    do{
                        System.out.println("You worked is: " 
                                + hoursWorked + " hours.");
                        System.out.print(" Enter the over-time rate "
                                + "(" + MIN_OVERTIME + " "
                                        + "- " + MAX_OVERTIME + "): ");
                        overTimeRate = Double.parseDouble(cin.nextLine());
                        if(overTimeRate < MIN_OVERTIME 
                                || overTimeRate > MAX_OVERTIME){
                            System.err.println("The number of over-time"
                                    + " rate must be in the range "
                                    + "[" + MIN_OVERTIME + " - "
                                            + "" + MAX_OVERTIME + "].");
                        }
                    }while(overTimeRate < MIN_OVERTIME 
                            || overTimeRate > MAX_OVERTIME);
                    flag = true;
                }catch(NumberFormatException e){
                    System.out.println("Input is not a valid double.");
                    System.out.println("The exception message is:"
                            + " " + e.getMessage());
                }
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
     * Pre-condition: overTimeRate must be in the range [1.0 - 3.0] and
     * hoursWorked >= 40
     * The conversion constructor of RestaurantWorker and HourlyWorker
     * class must be defined
     * Post-condition: initialize the variable: overTimeRate if 
     * overTimeRate have hoursWorked >= 40; otherwise, overTimeRate = 1.5d;
     */
    public KitchenStaff(String inName, PhoneNumber inPhone, Shift inShift, 
            double hours, double rate, double inTips){
        super(inName, inPhone, inShift, hours, rate, inTips);
        if(hoursWorked <= MAX_HOURS_WORKED){
            overTimeRate = MIN_OVERTIME;
        }else if(hoursWorked > MAX_HOURS_WORKED){
            overTimeRate = MIN_OVERTIME;
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
     * @param inTime 
     * Pre-condition: inTime must be in the range [1.0 - 3.0] and
     * hoursWorked >= 40
     * The conversion constructor of RestaurantWorker and HourlyWorker
     * class must be defined
     * Post-condition: initialize the variable: overTimeRate if 
     * inTime in the range [1.0 - 3.0] and hoursWorked >= 40;
     * otherwise, overTimeRate = MIN_OVERTIME;
     */
    public KitchenStaff(String inName, PhoneNumber inPhone, Shift inShift, 
            double hours, double rate, double inTips, double inTime){
        super(inName, inPhone, inShift, hours, rate, inTips);
        
        if(hoursWorked <= MAX_HOURS_WORKED){
            overTimeRate = MIN_OVERTIME;
        }else if(hoursWorked > MAX_HOURS_WORKED){
            if(MIN_OVERTIME <= inTime && inTime <= MAX_OVERTIME){
                overTimeRate = inTime;
            }
        }
    }

    /**
     * Accessor: getOverTimeRate()
     * @return overTimeRate
     * Pre-condition: none
     * Post-condition: get the value of overTimeRate
     */
    public double getOverTimeRate() {
        return overTimeRate;
    }

    /**
     * Mutator: setOverTimeRate()
     * @param inTime 
     * Pre-condition: inTime must be in the range [1.0 - 3.0] and
     * hoursWorked >= 40
     * Post-condition: initialize the variable: overTimeRate if 
     * inTime in the range [1.0 - 3.0] and hoursWorked >= 40;
     * otherwise, overTimeRate = MIN_OVERTIME;
     */
    public void setOverTimeRate(double inTime) {
        if(hoursWorked <= MAX_HOURS_WORKED){
            overTimeRate = MIN_OVERTIME;
        }else if(hoursWorked > MAX_HOURS_WORKED){
            if(MIN_OVERTIME <= inTime && inTime <= MAX_OVERTIME){
                overTimeRate = inTime;
            }
        }
    }
    
    /**
     * Mutator: generatePayCheck
     * Pre-condition: CalculatePay() method must be defined
     * Post-condition: output the information of KitchenStaff class and
     * the netPay (salary) of that KitchenStaff
     */
    protected void generatePayCheck(){
        DecimalFormat fmt = new DecimalFormat("0.00");
        CalculatePay();
        LocalDate currentDate = LocalDate.now();
        System.out.println(" ===================================="
                + "=============");
        System.out.println ( "\t  Blue Moon Cafe Earnings Statement\n\t"
                           + "  Pay period ending:   "
                + currentDate +" \n");
        System.out.println ( "\tKITCHEN: Salaried Employee");
        System.out.println("\tName: " + getName() + "\t\tShift: " 
                + getShift());
        System.out.println("\n\tAmount electronically deposited: $" 
                + fmt.format(CalculatePay()));
        System.out.println(" ================================="
                + "================");
    }
    
    /**
     * Accessor: toString()
     * @return out
     * Pre-condition: the toString method() of RestaurantWorker 
     * and HourlyWorker class must be defined
     * Post-condition: output all the information of KitchenStaff class
     */
    public String toString(){
        String output = "";
        output += super.toString();
        output += " Kitchen Staff:";
        output += "\t His or her over-time rate is: " 
                + overTimeRate + ". \n";
        return output;
    }
    
    /**
     * Accessor: CalculatePay()
     * @return netPay
     * Pre-condition: implements the Payroll interface
     * Post-condition: calculate the netPay of KitchenStaff
     * if netPay < 0 (netPay = 0); otherwise, netPay is the salary of 
     * KitchenStaff
     */
    public double CalculatePay(){
        double wageOverTime = 0, wageTime = 0;
        
        if(hoursWorked <= MAX_HOURS_WORKED){
            wageTime = (hoursWorked * hourlyRate);
        }else if(hoursWorked > MAX_HOURS_WORKED){
            wageTime = (MAX_HOURS_WORKED * hourlyRate);
            wageOverTime = (((hoursWorked - MAX_HOURS_WORKED)
                    * overTimeRate * hourlyRate));
        }
        
        netPay = ((wageTime + wageOverTime) + tips - HealthInsuranceCOST);
        
        if(netPay < 0.0){
            netPay = 0.0d;
        }
        return netPay;
    }
}
