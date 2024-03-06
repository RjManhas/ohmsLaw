/*
 * Title: Ohms Law Calulator
 * Author: Rj Manhas
 * Date: 3/4/24
 */


package com.ohmslaw;
import com.github.tomaslanger.chalk.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App 
{
    /*
    * The main entry point for the program
    * @param	args: (String Array)
    * @return	(void)
    */
    public static void main( String[] args )
    {
        startText();
        mainMenu();
    }


    /*
    * After each calulation, ask for key before continuing
    * @return	(void)
    */
    public static void doneCalulation(){
        System.out.println(Chalk.on("Press any key to continue:").blue().bold().underline());
        try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
    * The Ohms Law menu
    * @return	(void)
    */
    public static void ohmsLawMenu(){

        Scanner input = new Scanner(System.in);

        System.out.println(Chalk.on("---- Ohms Law -----").blue().bold());
        System.out.println(Chalk.on("1. Current & Resistance --> Voltage").blue().bold());
        System.out.println(Chalk.on("2. Voltage & Resistance --> Current").blue().bold());
        System.out.println(Chalk.on("3. Voltage & Current --> Resistance").blue().bold());
        System.out.println(Chalk.on("4. Go back to main menu").blue().bold());
        System.out.println(Chalk.on("---------------------").magenta());
        System.out.print(Chalk.on("Enter Number -> ").bold().magenta());
        try {
            Integer choice = input.nextInt();
            switch (choice) {
            case 1: 

                try {
                    System.out.println(Chalk.on("Please provide current: ").blue().bold());
                    Float current = input.nextFloat();
                    System.out.println(Chalk.on("Please provide resistance: ").blue().bold());
                    Float resistance = input.nextFloat();
                    displayResult(voltage(current, resistance), "voltage");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                ohmsLawMenu();
                break;

            case 2: 

                try {
                    System.out.println(Chalk.on("Please provide voltage: ").blue().bold());
                    Float voltage = input.nextFloat();
                    System.out.println(Chalk.on("Please provide resistance: ").blue().bold());
                    Float resistance = input.nextFloat();
                    displayResult(current(voltage, resistance), "current");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                ohmsLawMenu();
                break;  

            case 3: 

                try {
                    System.out.println(Chalk.on("Please provide voltage: ").blue().bold());
                    Float voltage = input.nextFloat();
                    System.out.println(Chalk.on("Please provide current: ").blue().bold());
                    Float current = input.nextFloat();
                    displayResult(resistance(voltage, current), "resistance");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                ohmsLawMenu();
                break;  
            
            case 4:
                mainMenu();    

            default:
            
                System.out.println(Chalk.on("---------------------").red());
                System.out.println(Chalk.on("Please pick an option you see above ^^^^^^^^^").red().bold().underline());
                System.out.println(Chalk.on("Press any key to continue:").red().bold().underline());
                System.out.println(Chalk.on("---------------------").red());
            
                ohmsLawMenu();
                break;
            }

        } catch (InputMismatchException e) {
            invalidInput();
            ohmsLawMenu();
        }
    }

/*
    * The battery law menu
    * @return	(void)
    */
    public static void batteryLawMenu(){

        Scanner input = new Scanner(System.in);

        System.out.println(Chalk.on("---- A batterys Law -----").blue().bold());
        // a batterys include A, AA, AAA, AAAA
        System.out.println(Chalk.on("1. Voltage --> A Batterys").blue().bold());
        System.out.println(Chalk.on("2. A Batterys --> Voltage").blue().bold());
        // Reason why only a batterys  to and from voltage is because all A batterys have the same amount of voltage
        System.out.println(Chalk.on("3. AA Batterys --> mAh").blue().bold());
        System.out.println(Chalk.on("4. AAA Batterys --> mAh").blue().bold());
        System.out.println(Chalk.on("5. AAAA Batterys --> mAh").blue().bold());
        System.out.println(Chalk.on("6. mAh --> Total amount of AA Batterys").blue().bold());
        System.out.println(Chalk.on("7. mAh --> Total amount of AAA Batterys").blue().bold());
        System.out.println(Chalk.on("8. mAh --> Total amount of AAAA Batterys").blue().bold());
        System.out.println(Chalk.on("9. Go back to main menu").blue().bold());
        // Each A battery is a different size, so different amount of engery they can store
        System.out.println(Chalk.on("---------------------").magenta());
        System.out.print(Chalk.on("Enter Number -> ").bold().magenta());
        try {
            Integer choice = input.nextInt();
            switch (choice) {

            case 1:
                try {
                    System.out.println(Chalk.on("Please provide how much voltage you have: ").blue().bold());
                    Float amount = input.nextFloat();
                    displayResult(batteryVoltage(1, amount, 1.5f), "Batterys");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                batteryLawMenu();
                break; 
            case 2:
                try {
                    System.out.println(Chalk.on("Please provide how many batterys you have: ").blue().bold());
                    Float amount = input.nextFloat();
                    displayResult(batteryVoltage(2, amount, 1.5f), "mAh");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                batteryLawMenu();
                break; 

            case 3:
                try {
                    System.out.println(Chalk.on("Please provide how many AA batterys you have: ").blue().bold());
                    Float amount = input.nextFloat();
                    displayResult(batteryStorage(1, 2700, amount), "mAh");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                batteryLawMenu();
                break; 
                
            case 4:
                try {
                    System.out.println(Chalk.on("Please provide how many AAA batterys you have: ").blue().bold());
                    Float amount = input.nextFloat();
                    displayResult(batteryStorage(1, 1200, amount), "mAh");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                batteryLawMenu();
                break; 

            case 5:
                try {
                    System.out.println(Chalk.on("Please provide how many AAAA batterys you have: ").blue().bold());
                    Float amount = input.nextFloat();
                    displayResult(batteryStorage(1, 625, amount), "mAh");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                batteryLawMenu();
                break; 
            case 6:
                try {
                    System.out.println(Chalk.on("Please provide how mAh you have: ").blue().bold());
                    Float amount = input.nextFloat();
                    displayResult(batteryStorage(2, 2700, amount), "AA Batterys");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                batteryLawMenu();
                break; 
            case 7:
                try {
                    System.out.println(Chalk.on("Please provide how mAh you have: ").blue().bold());
                    Float amount = input.nextFloat();
                    displayResult(batteryStorage(1, 1200, amount), "AAA Batterys");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                batteryLawMenu();
                break; 
            case 8:
                try {
                    System.out.println(Chalk.on("Please provide how mAh you have: ").blue().bold());
                    Float amount = input.nextFloat();
                    displayResult(batteryStorage(2, 625, amount), "AAAA Batterys");
                    
                } catch (InputMismatchException e) {
                    invalidInput();
                }
                doneCalulation();
                batteryLawMenu();
                break; 
            case 9:
                mainMenu();    

            default:
            
                System.out.println(Chalk.on("---------------------").red());
                System.out.println(Chalk.on("Please pick an option you see above ^^^^^^^^^").red().bold().underline());
                System.out.println(Chalk.on("Press any key to continue:").red().bold().underline());
                System.out.println(Chalk.on("---------------------").red());
            
                batteryLawMenu();
                break;
            }

        } catch (InputMismatchException e) {
            invalidInput();
            batteryLawMenu();
        }
    }



    /*
    * The system main menu
    * @return	(void)
    */
    public static void mainMenu(){

        Scanner input = new Scanner(System.in);

        System.out.println(Chalk.on("---------------------").magenta());
        System.out.println(Chalk.on("Main Menu [|\\/|]").blue().bold());
        System.out.println(Chalk.on("1. Ohms Law menu").bold().blue());
        System.out.println(Chalk.on("2. A Battery Law menu").bold().blue());
        System.out.println(Chalk.on("3. End program").bold().blue());
        System.out.println(Chalk.on("---------------------").magenta());
        System.out.print(Chalk.on("Enter Number -> ").bold().magenta());
        try {
            Integer choice = input.nextInt();
            switch (choice) {
            case 1:
                ohmsLawMenu();
                break;
            case 2:
                batteryLawMenu();
                break;
            case 3:
                System.exit(0);  

            default:
            
                System.out.println(Chalk.on("---------------------").red());
                System.out.println(Chalk.on("Please pick an option you see above ^^^^^^^^^").red().bold().underline());
                System.out.println(Chalk.on("Press any key to continue:").red().bold().underline());
                System.out.println(Chalk.on("---------------------").red());
                System.out.println(Chalk.on("Press any key to continue:").blue().bold().underline());
                try {
                    System.in.read();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                mainMenu();
                break;
            }

        } catch (InputMismatchException e) {
            invalidInput();
            mainMenu();
        }
    }


    /*
    * The systems start text splash screen
    * @return	(void)
    */
    public static void startText(){
        System.out.println(Chalk.on("---------------------").magenta());
        System.out.println(Chalk.on("Welcome to the Ohms Law Calculator.. [/]").blue().bold());
        System.out.println(Chalk.on("Made by Rj Manhas").magenta());
        System.out.println(Chalk.on("---------------------").magenta());
        System.out.println(Chalk.on("Press any key to continue:").blue().bold().underline());
        try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /*
    * Throw an error message when every the user enters an input with the worng type
    * @return	(void)
    */
    public static void invalidInput(){
        System.out.println(Chalk.on("---------------------").red());
        System.out.println(Chalk.on("This menu can only accept numbers, please try again.").red().bold().underline());
        System.out.println(Chalk.on("Press any key to continue:").red().bold().underline());
        System.out.println(Chalk.on("---------------------").red());

        try {
            System.in.read();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    /*
    * Displays the result of the calulation
    * @param	result (Float)
    * @param    unit (String)
    * @return	(void)
    */
    public static void displayResult(Float result, String unit){
        System.out.println(Chalk.on("---------------------").red());
        System.out.println(Chalk.on("Result: " + result + ' ' + unit).green().bold().underline());
        System.out.println(Chalk.on("---------------------").red());
    }


    /*
    * Calculate voltage from current and resistance and returns it
    * @param	current: (Float)
    * @param	resistance: (Float)
    * @return	(Float)
    */
    public static Float voltage(Float current, Float resistance){
       
        Float result = current*resistance;
        return result;
    }

    /*
    * Calculate current from voltage and resistance and returns it
    * @param	voltage: (Float)
    * @param	resistance: (Float)
    * @return	(Float)
    */
    public static Float current(Float voltage, Float resistance){
       
        Float result = voltage/resistance;
        return result;
    }


    /*
    * Calculate resistance from voltage and resistance and returns it
    * @param	voltage: (Float)
    * @param	resistance: (Float)
    * @return	(Float)
    */
    public static Float resistance(Float voltage, Float current){
       
        Float result = voltage/current;
        return result;
    }

    /*
    * Calculate voltage for battery and how many
    * @param	type: (Integer)
    * @param	voltage: (Float)
    * @param	amount: (Float)
    * @return	(Float)
    */
    public static Float batteryVoltage(Integer type, Float voltage, Float amount){

        if (type == 1){
            return voltage/amount;
        } else {
            return amount*voltage ;
        }
    }
    /*
    * Calculate how much mAh you have from how many batterys you got or how much batterys for that type you can have with the amount of mAh you have
    * @param	type: (Integer)
    * @param	mAh: (Interger)
    * @param	amount: (Float)
    * @return	(Float)
    */
    public static Float batteryStorage(Integer type, Integer mAh, Float amount){

        if (type == 1){
            return amount*mAh;
        } else {
            return amount/mAh ;
        }
    }

}
