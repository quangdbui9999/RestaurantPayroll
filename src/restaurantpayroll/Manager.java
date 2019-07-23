/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 *  Description: class Manager is a subclass of RestaurantWorker
 * Manger has added variable members: paidTimeOff, bonus (as a %...
 * e.g. 0.02), and salary (fixed salary each week)
 * The overridden generatePayCheck() issues the Manager's pay stub 
 * (note the use of the Java 8 revised time (and date) API.  
 * The toString() uses the super toString() and the setters/getters are
 * coded for the variables as appropriate
 * This class also implements Payroll interface and define the CalculatePay
 * method is declared in Payroll interface
 */

package restaurantpayroll;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, May 3rd, 2018
 * Description: class Manager is a subclass of RestaurantWorker
 * Manger has added variable members: paidTimeOff, bonus (as a %...
 * e.g. 0.02), and salary (fixed salary each week)
 * The overridden generatePayCheck() issues the Manager's pay stub 
 * (note the use of the Java 8 revised time (and date) API.  
 * The toString() uses the super toString() and the setters/getters are
 * coded for the variables as appropriate
 * This class also implements Payroll interface and define the CalculatePay
 * method is declared in Payroll interface
 */
public class Manager extends RestaurantWorker implements Payroll{
    private int paidTimeOff;
    private double bonus;
    private double salary;
    private static final int MIN_DAY_OFF = 0;
    private static final int DEFAULT_DAY_OFF = 10;
    private static final int MAX_DAY_OFF = 20;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: the default constructor of RestaurantWorker
     * must be defined
     * Post-condition: input paidTimeOff (0 - 20 days), bonus (>0) 
     * and salary (>0) for each worker 
     */
    public Manager ()
    {
        // call the default constructor method of 
        // parent class (RestaurantWorker class) 8563975090
        super();
        System.out.println("Pleasen enter the Manager's infomation: ");
        Scanner cin = new Scanner(System.in);
        boolean flag = false;
        
        while(flag == false){
            try{
                do{
                    System.out.print(" Enter the number of vacation "
                            + "day [" + MIN_DAY_OFF + " -"
                                    + " " + MAX_DAY_OFF + "]: ");
                    paidTimeOff = Integer.parseInt(cin.nextLine());
                    if(!(MIN_DAY_OFF <= paidTimeOff 
                            && paidTimeOff <= MAX_DAY_OFF)){
                        System.err.println("The number of vacation "
                                + "day must"
                                + " be in the range [" + MIN_DAY_OFF +
                                " - " + MAX_DAY_OFF + "].");
                    }
                }while(!(MIN_DAY_OFF <= paidTimeOff 
                        && paidTimeOff <= MAX_DAY_OFF));
                flag = true;
            }catch(NumberFormatException e){
                System.out.println("Input is not a valid integer.");
                System.out.println("The exception "
                        + "message is: " + e.getMessage());
            }
        }
        
        flag = false;
        
        while(flag == false){
            try{
                do{
                    System.out.print(" Enter the bonus (> 0): ");
                    bonus = Double.parseDouble(cin.nextLine());
                    if(bonus <= 0.0){
                        System.err.println("The bonus "
                                + "must be greater than 0.");
                    }
                }while(bonus <= 0.0);
                flag = true;
            }catch(NumberFormatException e){
                System.out.println("Input is not a valid double.");
                System.out.println("The exception "
                        + "message is: " + e.getMessage());
            }
        }
        
        flag = false;
        
        while(flag == false){
            try{
                do{
                    System.out.print(" Enter the salary (> 0): ");
                    salary = Double.parseDouble(cin.nextLine());
                    if(salary <= 0.0){
                        System.err.println("The salary must "
                                + "be greater than 0.");
                    }
                }while(salary <= 0.0);
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
     * @param name
     * @param phoneNum
     * @param inShift
     * @param vacationDays
     * @param bonusPercent
     * @param grossPay 
     * Pre-condition: vacationDays must be in the range [0 - 20]
     * bonusPercent and grossPay must be > 0
     * The conversion constructor of RestaurantWorker class 
     * must be defined
     * Post-condition: initialize the variable: vacationDays (0 - 20), 
     * bonusPercent (>0) and grossPay (>0) for each worker
     * depend on the parameters are passed, respectively
     */
    public Manager (String name, PhoneNumber phoneNum, Shift inShift, 
           int vacationDays, double bonusPercent, double grossPay)
    {
        super (name, phoneNum, inShift);
        if (vacationDays >= MIN_DAY_OFF && vacationDays <= MAX_DAY_OFF)
            paidTimeOff = vacationDays;
        else paidTimeOff = DEFAULT_DAY_OFF;
        
        if(0.0 < bonusPercent){
            bonus = bonusPercent;
        }else{
            bonus = 0.0;
        }
        if(0.0 < grossPay){
            salary = grossPay;
        }else{
            salary = 500.0;
        }
    }
    
    /**
     * Accessor: CalculatePay()
     * @return netPay
     * Pre-condition: implements the Payroll interface
     * Post-condition: calculate the netPay of Manager
     * if netPay < 0 (netPay = 0); otherwise, netPay is the salary of 
     * Manager
     */
    public double CalculatePay(){
        netPay = ((1 + bonus) * salary) - HealthInsuranceCOST;
        if(netPay < 0.0){
            netPay = 0.0d;
        }
        return netPay;
    }
  
    /**
     * Mutator: generatePayCheck
     * Pre-condition: CalculatePay() method must be defined
     * Post-condition: output the information of Manager class and
     * the netPay (salary) of that Manager
     */
    protected void generatePayCheck()
    {
        DecimalFormat fmt = new DecimalFormat("0.00");
        LocalDate currentDate = LocalDate.now();
        System.out.println(" ================================"
                + "=================");
        System.out.println ( "\t  Blue Moon Cafe Earnings Statement\n\t"
                           + "  Pay period ending:   "
                + ""+ currentDate +" \n");
        System.out.println ( "\tMANAGEMENT: Salaried Employee");
        System.out.println("\tName: " + getName() + 
                "\t\tShift: " + getShift());
        System.out.println("\n\tAmount electronically deposited: "
                + "$" + fmt.format(CalculatePay()));
        System.out.println(" ================================"
                + "=================");
    }
    
    /**
     * Mutator: setPaidTimeOff()
     * @param vacationDays 
     * Pre-condition: vacationDays must be in the range [0 - 20]
     * Post-condition: assign vacationDays to paidTimeOff if vacationDays
     * in the range [0 - 20]; otherwise, paidTimeOff = DEFAULT_DAY_OFF;
     */
    public void setPaidTimeOff (int vacationDays)
    {
        if (vacationDays >= MIN_DAY_OFF && vacationDays <= MAX_DAY_OFF)
            paidTimeOff = vacationDays;
        else paidTimeOff = DEFAULT_DAY_OFF;
    }

    /**
     * Accessor: getPaidTimeOff()
     * @return paidTimeOff
     * Pre-condition: none
     * Post-condition: get the value of paidTimeOff
     */
    public int getPaidTimeOff()
    {
        return paidTimeOff;
    }
    
    /**
     * Accessor: getBonus()
     * @return bonus
     * Pre-condition: none
     * Post-condition: get the value of bonus
     */
    public double getBonus()
    {
        return bonus;
    }
    
    /**
     * Mutator: setBonus()
     * @param inBonus 
     * Pre-condition: inBonus > 0;
     * Post-condition: assign inBonus to bonus if inBonus > 0;
     * otherwise, bonus = inBonus
     */
    protected void setBonus(double inBonus)
    {
        if(0.0 < inBonus){
            bonus = inBonus;
        }else{
            bonus = 0.0;
        }
    }
    
    /**
     * Accessor: getSalary()
     * @return salary
     * Pre-condition: none
     * Post-condition: get the value of salary
     */
    public double getSalary(){
        return salary;
    }
    
    /**
     * Mutator: setSalary()
     * @param grossPay 
     * Pre-condition: grossPay > 0;
     * Post-condition: assign grossPay to salary if inBonus > 0;
     * otherwise, salary = grossPay
     */
    public void setSalary(double grossPay){
        if(0.0 < grossPay){
            salary = grossPay;
        }else{
            salary = 500.0;
        }
    }

    /**
     * Accessor: toString()
     * @return out
     * Pre-condition: the toString method() of RestaurantWorker class
     * must be defined
     * Post-condition: output all the information of Manager class
     */
    public String toString()
    {
        String output = "";
        output += super.toString();
        output += " Management Staff \n";
        output += " Paid Time Off Remaining: " + paidTimeOff + " days\n";
        output += " The bonus: " + bonus + ". ";
        output += "\t Salary: " + salary + ".\n";
        return output;
    }
}