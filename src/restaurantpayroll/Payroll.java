/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 *  Description: Payroll Interface is used by each subclass to perform 
 * the necessary calculation per sub class 
 */
package restaurantpayroll;

/**
 * @author Quang Bui - CSC - 122 - 01
 */
public interface Payroll {
    // abstract method named CalculatePay() that will be used by each 
    // subclass to perform the necessary calculation per sub class 
    public double CalculatePay();
}
