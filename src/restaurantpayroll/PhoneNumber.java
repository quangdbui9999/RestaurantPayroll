/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: 
 *  Description: 
 */

package restaurantpayroll;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Programmed by: Quang Bui
 * Due Date: 
 * Description: 
 * 
 */
public class PhoneNumber {
    /* customerPhoneNumber variable's length must be 10, have the
    area code appropriated with some states, and all character is
    digital number */
    private String customerPhoneNumber;
    // checkPhone include validPhoneNumber, areaCode, 
    // digitNumber, lengthNumber
    private CheckCustomerPhoneNumber checkPhone;
    
    /**
     * D E F A U L T   C O N S T R U C T O R
     * Pre-condition: the customerPhoneNumber, kindPlan, checkPhone,
     * additionalLine, minutesUsed. and dataUsed variable must be 
     * declared and they are placed inside the class MonthlyBill
     * Post-condition: Create the valid for some variables: 
     * customerPhoneNumber, kindPlan, checkPhone,
     * additionalLine, minutesUsed and dataUsed
     */
    public PhoneNumber(){
        customerPhoneNumber = "6091234321";
        checkPhone = CheckCustomerPhoneNumber.validPhoneNumber;
    }
    
    /**
     * Mutator: input()
     * Pre-condition: the checkPhoneNumber() method must be defined to
     * check the condition for customerPhoneNumber variable. The
     * displayTypeOfPlan() method must be defined to input the
     * additionalLine variable
     * This method should import java.util.Scanner;
     * Post: The input() method carries out to input the values for
     * customerPhoneNumber, kindPlan, checkPhone,
     * additionalLine, minutesUsed and dataUsed variables. In this 
     * method: customerPhoneNumber must be checked by the 
     * checkPhoneNumber() method, and the minutesUsed and 
     * dataUsed variables must be > 0.
     */
    public void input(){
        Scanner cin = new Scanner(System.in);
        int choose = 0;
        
        do{
            System.out.print("Enter phone number"
                    + " (the length equal to 10): ");
            customerPhoneNumber = cin.nextLine();
            
            if(this.checkPhoneNumber() != checkPhone.validPhoneNumber){
                this.displayProblemPhoneNumber();
            }
        }while(this.checkPhoneNumber() != checkPhone.validPhoneNumber);
    }
    
    /**
     * Accessor displayInformation()
     * @return result
     * Pre-condition: The kindPlan, additionalLine, minutesUsed, and
     * dataUsed variables must be initialized. The handlePhoneNumber(),
     * displayArea(), calculateMonthlyBills(), calculateRate(),
     * calculateCostLine(), billExceedMinutes(), and billExceedData()
     * methods must be defined.
     * This method should import java.text.DecimalFormat;
     * Post-condition: the displayInformation() show all the information
     * of the bill (do not have the date publish and due date to 
     * pay the bill)
     */
    private String displayInformation(){
        String result = "";
        
        result += " Phone number: " + handlePhoneNumber();
        result += "\tArea: " + displayArea();
        
        return result;
    }
    
    /**
     * Accessor: toString()
     * @return result
     * Pre-condition: The begin(), dueDate(), displayInformation(),
     * and end() methods must be defined.
     * Post-condition: This method just output all information
     * of the bill.
     */
    public String toString(){
        String result = "";
        
        result += displayInformation();
        
        return result;
    }
    
    /**
     * Mutator: displayProblemPhoneNumber()
     * Pre-condition: The methods: checkPhoneNumber() must be defined.
     * Post-condition: this method will base on the checkPhoneNumber()
     * method to output all information about the problem when users
     * input the phone number. If users input phone number is invalid,
     * these problems will output.
     */
    private void displayProblemPhoneNumber(){
        checkPhone = this.checkPhoneNumber();
        switch (checkPhone) {
            case lengthNumber:
                System.err.println("The phone number that you entered is "
                        + "not a phone number because its length is not"
                        + " equal 10.");
                break;
            case digitNumber:
                System.err.println("The phone number that you entered is "
                        + "not a phone number. \nMaybe it contains "
                        + "alphabetic, or symbol characters");
                break;
            case areaCode:
                System.err.println("The phone number that you entered "
                        + "have been not supported. \n We just support"
                        + "  for some state: New York, New Jersey, "
                        + "California, Texas, \nWashington, Pennsylvania,"
                        + "\nOregon, Florida, Delaware, "
                        + "Massachusetts, and Virginia.");
                break;
            default:
                break;
        }
    }
    
    /**
     * Accessor: checkPhoneNumber
     * @return checkPhone (enumerated type: instant variable)
     * Pre-condition: the lookUpAreaCode(), checkDigitPhoneNumber(),
     * and checkPhoneLength() must be defined.
     * Post-condition: This method just get the problems about the 
     * phone number: length, digit, and area code. If one of the three
     * methods: lookUpAreaCode(), checkDigitPhoneNumber(),
     * and checkPhoneLength() is return false, they will be assigned
     * to checkPhone enumerated type with respectively.
     */
    public CheckCustomerPhoneNumber checkPhoneNumber(){
        if(this.lookUpAreaCode() == false){
            checkPhone = CheckCustomerPhoneNumber.areaCode;
        }
        if(this.checkDigitPhoneNumber() == true &&
                this.checkPhoneLength() == true &&
                this.lookUpAreaCode() == true){
            checkPhone = CheckCustomerPhoneNumber.validPhoneNumber;
        }
        if(this.checkPhoneLength() == false){
            checkPhone = CheckCustomerPhoneNumber.lengthNumber;
        }
        if(this.checkDigitPhoneNumber() == false){
            checkPhone = CheckCustomerPhoneNumber.digitNumber;
        }
        return checkPhone;
    }
    
    /**
     * Accessor: checkPhoneLength
     * @return true if length() == 10 
     * and false if length() is not equal 10
     * Pre-condition: customerPhoneNumber variable must be initialize
     * Post-condition: this method will return true if length() == 10 
     * and false if length() is not equal 10
     */
    private boolean checkPhoneLength(){
        return (customerPhoneNumber.length() == 10);
    }
    
    /**
     * Accessor: checkDigitPhoneNumber()
     * @return true if customerPhoneNumber variable is all characters
     * and false if customerPhoneNumber variable is not all characters
     * Pre-condition: the users should 
     * import java.util.regex.Matcher; import java.util.regex.Pattern;
     * Post-condition: this method will
     * return true if customerPhoneNumber variable is all characters
     * and false if customerPhoneNumber variable is not all characters
     */
    private boolean checkDigitPhoneNumber(){
        boolean flag = false;
        Pattern model = Pattern.compile("\\d*");
        Matcher fit = model.matcher(this.customerPhoneNumber);
        if(fit.matches()){
            flag = true; // is phone number
        }else{
            flag = false; // is not phone number
        }
        return flag;
    }
    
    /**
     * Accessor: handlePhoneNumber()
     * @return result
     * Pre-condition: The checkPhoneNumber() method must be defined.
     * The customerPhoneNumber variable must be initialized.
     * Post-condition: this method will separate the String
     * customerPhoneNumber to 3 parts by substring() method is
     * defined in the String class. 
     * Part 1: Area code - customerPhoneNumber.substring(0, 3);
     * Part 2: customerPhoneNumber.substring(3, 6);
     * Part 3: customerPhoneNumber.substring(6, 10);
     * and after that connect 3 parts by the format of
     * a phone number
     */
    private String handlePhoneNumber(){
        String result = "";
        String sec1, sec2, sec3;
        if(this.checkPhoneNumber() != checkPhone.validPhoneNumber){
            result = "";
        }else{
            sec1 = customerPhoneNumber.substring(0, 3);
            sec2 = customerPhoneNumber.substring(3, 6);
            sec3 = customerPhoneNumber.substring(6, 10);
            result += "(" + sec1 + ")-" + sec2 + "-" + sec3;
        }
        
        return result;
    }
    
    /**
     * Accessor: getCustomerPhoneNumber()
     * @return customerPhoneNumber
     * Pre-condition: none
     * Post-condition:
     * @return a copy of the MonthlyBill's customerPhoneNumber
     */
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber; 
    }
    
    /**
     * Mutator: 
     * @param inCustomerPhoneNumber 
     * Pre-condition: The checkPhoneNumber() method must be defined.
     * Post-condition: change the value of customerPhoneNumber if
     * checkPhoneNumber() method is returned true. Otherwise, the
     * value of customerPhoneNumber is not change
     */
    public void setCustomerPhoneNumber(String inCustomerPhoneNumber) {
        if(this.checkPhoneNumber() == checkPhone.validPhoneNumber)
            customerPhoneNumber = inCustomerPhoneNumber;
    }
    
    /**
     * Accessor: displayArea()
     * @return result
     * Pre-condition: The arrayPhoneNumber() method must be defined.
     * Post-condition: This method will scan the arrayPhoneNumber from 0
     * to (arrayPhoneNumber.length - 1) to find the element (3 first
     * digit of customerPhoneNumber variable). If threeDitgit 
     * variable is matched
     * with 3 first digit of customerPhoneNumber variable, it will be
     * assigned (element = i) with i is a position and scan from 0
     * to (length - 1). After that, the element will be compared with
     * each element in arrayPhoneNumber and get the name of State.
     */
    private String displayArea(){
        String[] arrayPhoneNumber = createArrayPhone();
        String result = "";
        int element = 0; // element to scan in arrayPhoneNumber
        String threeDitgit;
        try{
            threeDitgit = customerPhoneNumber.substring(0, 3);
            for(int i = 0; i < arrayPhoneNumber.length; i++){
                if(threeDitgit.equals(arrayPhoneNumber[i])){
                    element = i;
                }
            }
        }catch(StringIndexOutOfBoundsException e){
            System.err.println("This exception message is: " + e.getMessage());
        }
        
        
        if(element >= 0 && element <= 10){
            result += "New York";
        }else if(element >= 11 && element <= 16){
            result += "New Jersey";
        }else if(element >= 17 && element <= 42){
            result += "California";
        }else if(element >= 43 && element <= 62){
            result += "Texas";
        }else if(element >= 63 && element <= 67){
            result += "Washington";
        }else if(element >= 68 && element <= 74){
            result += "Pennsylvania";
        }else if(element >= 75 && element <= 76){
            result += "Oregon";
        }else if(element >= 77 && element <= 91){
            result += "Florida";
        }else if(element == 92){
            result += "Delaware";
        }else if(element >= 93 && element <= 97){
            result += "Massachusetts";
        }else if(element >= 98 
                && element <= arrayPhoneNumber.length - 1){
            result += "Virginia";
        }
        
        return result;
    }
    
    /**
     * Accessor: createArrayPhone()
     * @return an arrayPhoneNumber[] 
     * Pre-condition: user uses the initializer list to create an array
     * Post-condition: this method will return an arrayPhoneNumber[]
     * with each element in this array is the area of each state: 
     * New York, New Jersey, California, Texas, Washington, Pennsylvania,
     * Oregon, Florida, Delaware, Massachusetts, and Virginia
     */
    private String[] createArrayPhone(){
        String[] arrayPhoneNumber = {"212", "315", "516", "518", "585", 
            "607", "631", "716", "718", "845", "914", "201", "609", 
            "732", "856", "908", "973", "209", "213", "310", "323",
            "408", "415", "510", "530", "559", "562", "619", "626",
            "650", "661", "707", "714", "760", "805", "818", "831",
            "858", "909", "916", "925", "949", "951", "210", "214", 
            "254", "281", "325", "361", "409", "432", "512", "713",
            "806", "817", "830", "903", "915", "936", "940", "956",
            "972" ,"979", "206", "253", "360", "425", "509", "215",
            "412", "570", "610", "717", "724", "814", "503", "541",
            "239", "305", "321", "352", "386", "407", "561", "727",
            "772", "813", "850", "863", "904", "941", "954", "302",
            "413", "508", "617", "781", "978", "276", "434", "540",
            "703", "757", "804"};
        return arrayPhoneNumber;
    }
    
    /**
     * Accessor: lookUpAreaCode()
     * @return flag
     * Pre-condition: The arrayPhoneNumber() method must be defined.
     * Post-condition: this method will return false if 3 first digits
     * of the customerPhoneNumber (in array) variable is not match 
     * with the the customerPhoneNumber variable. Otherwise, this method
     * will return true if 3 first digits
     * of the customerPhoneNumber (in array) variable is matched 
     * with the the customerPhoneNumber variable.
     */
    private boolean lookUpAreaCode(){
        String[] arrayPhoneNumber = createArrayPhone();
        boolean flag = false;
        
        if(this.checkPhoneLength() == false){
            flag = false;
        }else{
            for(String threeFirstDigit : arrayPhoneNumber)
            {
                if(threeFirstDigit.equals(
                        customerPhoneNumber.substring(0, 3)))
                {
                    flag = true;
                }
            }
        }
        
        return flag;
    }

    /**
     * Accessor: getCheckPhone()
     * @return checkPhone
     * Pre-condition: none
     * Post-condition: 
     * return a copy of the MonthlyBill's checkPhone
     */
    public CheckCustomerPhoneNumber getCheckPhone() {
        return checkPhone;
    }

    /**
     * Mutator: setCheckPhone(CheckCustomerPhoneNumber inCheckPhone)
     * @param inCheckPhone 
     * Pre-condition: inCheckPhone must be type of CheckCustomerPhoneNumber
     * Post-condition: assigned inCheckPhone to checkPhone
     */
    public void setCheckPhone(CheckCustomerPhoneNumber inCheckPhone) {
        checkPhone = inCheckPhone;
    }
}
