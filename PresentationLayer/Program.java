package PresentationLayer;

import java.util.Scanner;

/**
 * Program
 */
public class Program {


    public static void main(String[] args) 
        
        
        ProgramMethods pm = new ProgramMethods();
        boolean contLoop = true;
        while (contLoop) {
            System.out.println("---------------------------------------\n"
                              +"\tWELCOME TO DELICIOUS CATERING\n"
                              +"---------------------------------------\n"
                              +"1. NEW CLIENT\n"
                              +"2. ADD A NEW EVENT\n"
                              +"3. VIEW AN EVENT\n"
                              +"4. EDIT AN EVENT\n"
                              +"0. EXIT\n"
                              +"---------------------------------------");
            Scanner sn = new Scanner(System.in);
            boolean switchloop = true;
            while (switchloop) {
                int menupick = sn.nextInt();
                System.out.println("");
                switch (menupick) {
                    case 1:
                        pm.NewClient();
                        switchloop = false;
                        break;
                    case 2:
                        pm.NewEvent();
                        switchloop = false;
                        break;
                    case 3:
                        System.out.println("View event");
                        switchloop = false;
                        break;
                    case 4:
                        System.out.println("Edit Event");
                        switchloop = false;
                        break;
                    case 0:
                        System.out.println("exit");
                        sn.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("THIS INPUT IS INCORRECT PLEASE ENTER RIGHT INPUT:");
                        break;
                }
            }
            
        }    
    }
}