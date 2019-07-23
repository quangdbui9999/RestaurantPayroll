/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, May 3rd, 2018
 * Description: The CheckCustomerPhoneNumber enumerated type include
 * 3 attribute: 
 * - validPhoneNumber (the phone number is valid), 
 * - digitNumber: check all characters in the phone
 * instance variable are digits
 * - lengthNumber: The length of phone instance variable 
 * must equal to 10
 */

package restaurantpayroll;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, May 3rd, 2018
 * Description: The CheckCustomerPhoneNumber enumerated type include
 * 3 attribute: 
 * - validPhoneNumber (the phone number is valid), 
 * - digitNumber: check all characters in the phone
 * instance variable are digits
 * - lengthNumber: The length of phone instance variable 
 * must equal to 10
 */
public enum CheckCustomerPhoneNumber {
    validPhoneNumber, digitNumber, lengthNumber, areaCode;
}
