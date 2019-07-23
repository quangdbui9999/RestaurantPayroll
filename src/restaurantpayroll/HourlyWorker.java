/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 *  Description: An hourly worker is a sub class of 
 * super class RestaurantWorker
 * An hourly worker has added members: houreWorked, hourlyRate, and tips
 * Set/Get methods are provided as well as an overridden 
 * generatePayCheck() method that uses the (new Java 8) time stamp 
 * for dates on the pay stubs
 * Note the toString() method also calls the super.toString() 
 * for the common RestaurantWorker info
 */

package restaurantpayroll;

import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, May 3rd, 2018
 * Description: An hourly worker is a sub class of 
 * super class RestaurantWorker
 * An hourly worker has added members: houreWorked, hourlyRate, and tips
 * Set/Get methods are provided as well as an overridden 
 * generatePayCheck() method that uses the (new Java 8) time stamp 
 * for dates on the pay stubs
 * Note the toString() method also calls the super.toString() 
 * for the common RestaurantWorker info
 */
abstract public class HourlyWorker extends RestaurantWorker{
    protected double hoursWorked;
    protected double tips;
    protected double hourlyRate;
    private static final double MIN_HOUR = 0.0d;
    private static final double MAX_HOUR = 72.0d;
    private static final double MIN_HOURLYRATE = 5.25d;
    private static final double MAX_HOURLYRATE = 40.0d;
    private static final double MIN_TIP = 2.0d;
    private static final double MAX_TIP = 20.0d;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: the default constructor of RestaurantWorker
     * must be defined
     * Post-condition: input hoursWorked (0 - 72 hours), tips (2.0 - 20.0d),
     * and hourlyRate (5.25 - 40.0) for each worker 
     */
    public HourlyWorker(){
        // call the default constructor method of 
        // parent class (RestaurantWorker class)
        super();
        
        Scanner cin = new Scanner(System.in);
        boolean flag = false;
        
        while(flag == false){
            try{
                do{
                    System.out.print(" Enter the number of hour worked "
                            + "[" + MIN_HOUR + " - " + MAX_HOUR + "]: ");
                    hoursWorked = Double.parseDouble(cin.nextLine());
                    if(!(MIN_HOUR <= hoursWorked && hoursWorked <= MAX_HOUR)){
                        System.err.println("The number of hour worked must"
                                + " be in the range [" + MIN_HOUR +
                                " - " + MAX_HOUR + "].");
                    }
                }while(!(MIN_HOUR <= hoursWorked && hoursWorked <= MAX_HOUR));
                flag = true;
            }catch(NumberFormatException e){
                System.out.println("Input is not a valid double.");
                System.out.println("The exception message is: "
                        + "" + e.getMessage());
            }
        }
        
        flag = false;
        
        while(flag == false){
            try{
                do{
                    System.out.print(" Enter the hourly rate "
                            + "[" + MIN_HOURLYRATE + " - " 
                            + MAX_HOURLYRATE + "]: ");
                    hourlyRate = Double.parseDouble(cin.nextLine());
                    if(!(MIN_HOURLYRATE <= hourlyRate 
                            && hourlyRate <= MAX_HOURLYRATE)){
                        System.err.println("The hourly rate must"
                                + " be in the range [" + MIN_HOURLYRATE +
                                " - " + MAX_HOURLYRATE + "].");
                    }
                }while(!(MIN_HOURLYRATE <= hourlyRate 
                        && hourlyRate <= MAX_HOURLYRATE));
                flag = true;
            }catch(NumberFormatException e){
                System.out.println("Input is not a valid double.");
                System.out.println("The exception message is:"
                        + " " + e.getMessage());
            }
        }
        
        flag = false;
        
        while(flag == false){
            try{
                do{
                    System.out.print(" Enter the tips [" 
                            + MIN_TIP + " - " + MAX_TIP + "]: ");
                    tips = Double.parseDouble(cin.nextLine());
                    if(!(MIN_TIP <= tips && tips <= MAX_TIP)){
                        System.err.println("The tips must"
                                + " be in the range [" + MIN_TIP +
                                " - " + MAX_TIP + "].");
                    }
                }while(!(MIN_TIP <= tips && tips <= MAX_TIP));
                flag = true;
            }catch(NumberFormatException e){
                System.out.println("Input is not a valid double.");
                System.out.println("The exception message is: "
                        + "" + e.getMessage());
            }
        }
    }
    
    //-----------------------------------------------------------------
    //  Sets up this nurse with the information specified.
    //-----------------------------------------------------------------
    /**
     * C O N V E R S A T I O N  C O N S T R U C T O R
     * @param inName
     * @param inPhone
     * @param inShift
     * @param hours
     * @param rate
     * @param inTips 
     * Pre-condition: hours must be in the range [0 - 72.0]
     * rate must be in the range [5.25 - 40.0]
     * inTips must be in the range [2.0 - 20.0]
     * The conversion constructor of RestaurantWorker class
     * Post-condition: initialize the variable: hoursWorked (0 - 72 hours), 
     * tips (2.0 - 20.0d), and hourlyRate (5.25 - 40.0) for each worker
     * depend on the parameters are passed, respectively
     */
    public HourlyWorker(String inName, PhoneNumber inPhone, Shift inShift, 
            double hours, double rate, double inTips)   {
        super(inName, inPhone, inShift);
        
        if(MIN_HOUR <= hours && hours <= MAX_HOUR){
            hoursWorked = hours;
        }else{
            hoursWorked = 0;
        }
        
        if(MIN_HOURLYRATE <= rate && rate <= MAX_HOURLYRATE){
            hourlyRate = rate;
        }else{
            hourlyRate = MIN_HOURLYRATE;
        }
        
        if(MIN_TIP <= inTips && inTips <= MAX_TIP){
            tips = inTips;
        }else{
            tips = MIN_TIP;
        }
    }
    
    /**
     * Mutator: setHourlyRate()
     * @param hrate 
     * Pre-condition: hrate must be in the range [5.25 - 40.0]
     * Post-condition: assign hrate to hourlyRate if hrate in the range 
     * [5.25 - 40.0]; otherwise, hourlyRate = MIN_HOURLYRATE;
     */
    public void setHourlyRate (double hrate)
    {
        if(MIN_HOURLYRATE <= hrate && hrate <= MAX_HOURLYRATE){
            hourlyRate = hrate;
        }else{
            hourlyRate = MIN_HOURLYRATE;
        }
    }
    
    /**
     * Accessor: getHourlyRate()
     * @return hourlyRate
     * Pre-condition: none
     * Post-condition: get the value of hourlyRate
     */
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    
    /**
     * Mutator: setHoursWorked()
     * @param hrs 
     * Pre-condition: hrs must be in the range [0 - 72.0]
     * Post-condition: assign hrs to hoursWorked if hrs in the range 
     * [0 - 72.0]; otherwise, hoursWorked = MIN_HOUR;
     */
    public void setHoursWorked (double hrs)
    {
        if(MIN_HOUR <= hrs && hrs <= MAX_HOUR){
            hoursWorked = hrs;
        }else{
            hoursWorked = MIN_HOUR;
        }
    }

    /**
     * Accessor: getHoursWorked()
     * @return hoursWorked
     * Pre-condition: none
     * Post-condition: get the value of hoursWorked
     */
    public double getHoursWorked()
    {
        return hoursWorked;
    }
    
    /**
     * Accessor: getTips()
     * @return tips
     * Pre-condition: none
     * Post-condition: get the value of tips
     */
    public double getTips(){
        return tips;
    }
    
    /**
     * Mutator: setTips()
     * @param inTips 
     * Pre-condition: inTips must be in the range [2.0 - 20.0]
     * Post-condition: assign inTips to tips if inTips in the range 
     * [2.0 - 20.0]; otherwise, tips = MIN_TIP;
     */
    public void setTips(double inTips){
        if(MIN_TIP <= inTips && inTips <= MAX_TIP){
            tips = inTips;
        }else{
            tips = MIN_TIP;
        }
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
     * Pre-condition: the toString method() of RestaurantWorker class
     * must be defined
     * Post-condition: output all the information of HourlyWorker class
     */
    public String toString()
    {
        String output = "";
        output += super.toString() + ".\n He (she) has worked:  " 
                + hoursWorked + " this week\n";
        output += " Hour rate: " + hourlyRate + "\t\t";
        output += " Tips: " + tips + ". \n";
        return output;
    }
}
