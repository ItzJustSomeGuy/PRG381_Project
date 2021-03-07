package PresentationLayer;

import java.lang.reflect.Method;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import BusinessLogicLayer.Bookings;
import BusinessLogicLayer.Client;
import BusinessLogicLayer.Food;

public class ProgramMethods {
    

    public void NewClient() {
        List<Client> cList = new ArrayList<>();
        boolean contLoop = true;
        String name;
        String surname;
        int pnumber;
        String email;
        String address;

        while (contLoop) {
            System.out.println("---------------------------------------\n"
                              +"               NEW CLIENT\n"
                              +"---------------------------------------\n"
                              +"PLEASE ENTER YOUR NAME:");
            Scanner sn = new Scanner(System.in);
            name = sn.nextLine();
            System.out.println("");
            System.out.println("ENTER YOUR SURNAME:");
            surname = sn.nextLine();
            System.out.println("");
            System.out.println("ENTER YOUR PHONE NUMBER:");
            pnumber = sn.nextInt();
            System.out.println("");
            System.out.println("ENTER YOUR EMAIL ADDRESS: (example@email.com)");
            email = sn.nextLine();
            System.out.println("");
            // System.out.println("ENTER HOME ADDRESS (street, suburb, city, postal code)" );
            // address = sn.nextLine();
            System.out.println("");
            System.out.println("---------------------------------------\n"
                              +"              CLIENT INFO\n"
                              +"---------------------------------------\n"
                              +"\n"
                              +"NAME:\t"+name+"\n"
                              +"SURNAME:\t"+surname+"\n"
                              +"PHONE NUMBER:\t"+pnumber+"\n"
                              +"EMAIL ADDRESS:\t"+email+"\n"
                              //+"HOME ADDRESS:\t"+address+"\n"
                              //+"\n"
                              +"---------------------------------------\n"
                              +"IS THIS INFORMATION CORRECT?\n"
                              +"1. YES\n"
                              +"2. NO");
            boolean switchloop = true;           
            while (switchloop) {
                int yn = sn.nextInt();
                switch (yn) {
                    case 1:
                        cList.add(new Client(String.valueOf(pnumber),name,surname,pnumber,email));
                        switchloop = false;
                        contLoop = false;
                        break;
                    case 2:
                        switchloop = false;
                        break;
                    default:
                        System.out.println("THIS INPUT IS INCORRECT PLEASE ENTER RIGHT INPUT:");
                        break;
                }               
            }
            
        }
    }

    public void NewEvent() {
        List<Bookings> booklist = new ArrayList<>();
        List<Client> clientlist = new ArrayList<>();
        List<Food> foodlist = new ArrayList<>();
        
        int pnumber = 0;
        String eventname = "";
        String eventtype = "";
        String venuename = "";
        String venueaddress = "";
        String theme = "";
        String decordetails = "";
        LocalDate eventdate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalTime eventtime = LocalTime.now();
        DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");
        int pamount = 0;        
        int venuepnumber = 0;
        int decorchoice;
        Scanner sn = new Scanner(System.in);
        boolean decorations = false;        
        boolean contloop = true;
        while (contloop) {
            double totalprice = 0;
            System.out.println("---------------------------------------\n"
                              +"\t\tNEW EVENT\n"
                              +"---------------------------------------");
            boolean eventloop = true;
            while (eventloop) {
                boolean idloop = true;
                while (idloop) {
                    System.out.println("PLEASE ENTER YOUR PHONE NUMBER:");
                    pnumber =  sn.nextInt();
                    sn.nextLine();
                    for (Client client : clientlist) {
                        if (client.getPhoneNumber() == pnumber) {
                            idloop = false;
                        }
                        else {
                            System.out.println("Wrong number");
                            System.out.println("Do you want to exit?\n"
                                              +"1. YES\n"
                                              +"2. NO");
                            int yn = sn.nextInt();
                            sn.nextLine();
                            switch (yn) {
                                case 1:
                                    return;
                                case 2:
                                    break;
                                default:
                                    System.out.println("PLEASE ENTER THE RIGHT INPUT");
                                    break;
                            }

                        }
                    }
                }
                              
                System.out.println("");
                System.out.println("ENTER THE EVENTS NAME:");
                eventname = sn.nextLine();
                System.out.println("");
                boolean dateloop = true;
                while (dateloop) {
                    System.out.println("ENTER THE DATE OF THIS EVENT: (d/mm/yyyy)");
                String date = sn.nextLine();
                eventdate =LocalDate.parse(date,formatter);
                for (Bookings booking : booklist) {
                    if (booking.getEventDay().equals(eventdate)) {
                        System.out.println("THIS DATE IS ALREADY TAKEN");
                        boolean ynloop = true;
                        while (ynloop) {
                            System.out.println("DO YOU WANT TO EXIT?\n"
                                          +"1.YES\n"
                                          +"2.NO");
                            int yn = sn.nextInt();
                            sn.nextLine();  
                            switch (yn) {
                                case 1:                                    
                                    return;
                                case 2:                                    
                                    break;
                                default:
                                    System.out.println("PLEASE ENTER THE RIGHT INPUT");
                                    break;
                            } 
                        }
                        
                    }
                }
                System.out.println("");
                }
                System.out.println("ENTER THE TIME OF THIS EVENT: (hh:mm)");
                eventtime = LocalTime.parse(sn.nextLine(),timeformatter);
                System.out.println("");
                System.out.println("ENTER THE AMOUNT OF PEOPLE:");
                pamount = sn.nextInt();
                sn.nextLine();
                System.out.println("");
                System.out.println("WHAT TYPE OF EVENT IS THIS?:");
                eventtype = sn.nextLine();
                System.out.println("");
                System.out.println("WHAT IS THE VENUE'S NAME?:");
                venuename = sn.nextLine();
                System.out.println("");
                System.out.println("ENTER THE VENUE'S ADDRESS:");
                venueaddress = sn.nextLine();
                System.out.println("");
                System.out.println("ENTER THE VENUE'S PHONE NUMBER");
                venuepnumber = sn.nextInt();
                sn.nextLine();
                System.out.println("");
                boolean decorloop = true;
                while (decorloop) {
                    System.out.println("DO YOU WANT DECORATIONS?: (COST: R2000)\n"
                                      +"1. YES\n"
                                      +"2. NO\n");
                    decorchoice = sn.nextInt();
                    sn.nextLine();
                    System.out.println("");
                    switch (decorchoice) {
                        case 1:
                            decorations = true;
                            totalprice += 2000;
                            System.out.println("WHAT THEME DO YOU WANT?:");
                            theme = sn.nextLine();
                            System.out.println("");
                            System.out.println("PLEASE ENTER DETAILS OF WHAT YOU WANT TO DECORATE:");
                            decordetails = sn.nextLine();
                            System.out.println("");
                            decorloop = false;
                            break;
                        case 2:
                            decorations = false;
                            decorloop = false;
                            theme = "NONE";
                            decordetails = "NONE";
                            break;
                        default:
                            System.out.println("PLEASE ENTER THE RIGHT INPUT");
                            System.out.println("");
                            break;
                    }
                }
                System.out.println("-------------------------------\n"
                                  +"EVENT NAME:\t"+eventname+"\n"
                                  +"EVENT DATE AND TIME:\t"+eventdate+" "+eventtime+"\n"
                                  +"AMOUNT PEOPLE:\t"+pamount+"\n"
                                  +"EVENT TYPE:\t"+eventtype+"\n"
                                  +"VENUE NAME:\t"+venuename+"\n"
                                  +"VENUE ADDRESS:\t"+venueaddress+"\n"
                                  +"VENUE PHONENUMBER:\t"+venuepnumber+"\n"
                                  +"WANT DECORATIONS?:\t"+decorations+"\n"
                                  +"DECORATION THEME:\t"+theme+"\n"
                                  +"DECOR DETAILS:\t"+decordetails+"\n"
                                  +"-------------------------------"
                );
                boolean ynloop = true;
                while (ynloop) {
                    System.out.println("IS THIS INFORMATION CORRECT?\n"
                                  +"1. YES\n"
                                  +"2. NO");
                    int yn = sn.nextInt();
                    sn.nextLine();
                    switch (yn) {
                        case 1:
                            ynloop = false;
                            eventloop = false;
                            break;
                        case 2:
                            ynloop = false;
                        default:
                            System.out.println("PLEASE ENTER THE RIGHT INPUT");
                            break;
                    }
                }
                
                  
            }
            
            String menutitle;
            String mealchoice = "";
            int menuitem;
            int persons = 0;
            int allergiesorRequests;
            String allergiesDetails;
            String allergysummary = "";
            double mealPrice = 0;
            int menunum = 0;
            String adultmeal = "";
            int adultpersons = 0;
            double adultprice = 0;
            String kidsmeal = "";
            int kidspersons = 0;
            double kidsprice = 0;
            String drinkchoice = "";
            int drinkpersons = 0;
            double drinkprice = 0;
            String dessertmeal = "";
            int dessertpersons = 0;
            double dessertprice = 0;
            
            System.out.println("---------------------------------------\n"
                              +"\t\tFOOD\n"
                              +"---------------------------------------");
            boolean menuloop = true;
            while (menuloop) {
                menutitle = foodlist.get(menunum).getMealType();
                System.out.println(menutitle.toUpperCase());
                boolean choiceloop = true;
                while (choiceloop) {
                    System.out.println("-----------------------------------");
                    for (Food food : foodlist) {
                        if (food.getMealType() == menutitle) {
                            int i = 1;
                            System.out.println(i+". "+food.getMealChoice()+"\tR"+food.getMealPrice());
                            i++;
                        }                    
                    }
                    System.out.println("0. NONE\n"
                                  +"-----------------------------------");
                    menuitem = sn.nextInt();
                    sn.nextLine();
                    for (Food food : foodlist) {
                        if (food.getMealType() == menutitle) {
                            menuitem--;
                            mealchoice = food.getMealChoice();
                            choiceloop = false;
                        }                    
                    }
                    System.out.println("");
                }
                
                System.out.println("HOW MANY PERSONS?");
                persons = sn.nextInt();
                sn.nextLine();
                System.out.println("");
                // boolean allergyloop = true;
                // while (allergyloop) {
                //     System.out.println("ANY ALLERGENS OR OTHER REQUESTS?:\n"
                //                       +"1. YES\n"
                //                       +"2. NO");
                //     allergiesorRequests = sn.nextInt();
                //     System.out.println("");
                //     switch (allergiesorRequests) {
                //         case 1:
                //             System.out.println("PLEASE ENTER THE ALLERGY OR REQUEST");
                //             allergiesDetails = sn.nextLine();
                //             allergysummary = "ALLERGIES OR REQUESTS: "+allergiesDetails;
                //             System.out.println("");
                //             allergyloop = false;
                //             break;
                //         case 2:
                //             allergyloop = false;
                //             allergysummary = "ALLERGIES OR REQUESTS: NONE";
                //             System.out.println("");
                //             break;
                //         default:
                //             System.out.println("PLEASE ENTER THE RIGHT INPUT");
                //             break;
                //     }
                for (Food food : foodlist) {
                    if (mealchoice == food.getMealChoice()) {
                        mealPrice = food.getMealPrice()*persons;
                    }
                }
                
                System.out.println("--------------------------------------\n"
                                  +"YOU CHOSE THE "+mealchoice+" FOR "+persons+" PERSON/S\n"
                                  +"MEAL PRICE: R"+mealPrice+"\n"
                                  +"--------------------------------------"); 
                System.out.println("IS THIS INFORMATION CORRECT?:\n"
                                  +"1. YES\n"
                                  +"2.NO"); 
                int yn = sn.nextInt();
                sn.nextLine();
                boolean ynloop = true;
                while (ynloop) {
                    switch (yn) {
                        case 1:
                            if (menunum == 3) {
                                menuloop = false;
                                ynloop = false;
                                switch (menunum) {
                                    case 0:
                                        adultmeal = mealchoice;
                                        adultpersons = persons;
                                        adultprice = mealPrice;
                                        if (adultpersons >= 40) {
                                            totalprice += adultprice/2;
                                        } else {
                                            totalprice += adultprice;
                                        }
                                        break;
                                    case 1:
                                    kidsmeal = mealchoice;
                                    kidspersons = persons;
                                    kidsprice = mealPrice;
                                    totalprice += kidsprice;
                                        break;
                                    case 2:
                                    drinkchoice = mealchoice;
                                    drinkpersons = persons;
                                    drinkprice = mealPrice;
                                    totalprice += drinkprice;
                                        break;
                                    case 3:
                                    dessertmeal = mealchoice;
                                    dessertpersons = persons;
                                    dessertprice = mealPrice;
                                    totalprice += dessertprice;
                                    ynloop = false;
                                    menuloop = false;
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                menunum++;
                                ynloop = false;
                            }
                            break;
                        case 2:
    
                            break;
                        default:
                            System.out.println("PLEASE ENTER THE RIGHT INPUT");
                            break;
                    }
                }
                
            }
            System.out.println("-------------------------------\n"
                              +"EVENT NAME:\t"+eventname+"\n"
                              +"EVENT DATE AND TIME:\t"+eventdate+" "+eventtime+"\n"
                              +"AMOUNT PEOPLE:\t"+pamount+"\n"
                              +"EVENT TYPE:\t"+eventtype+"\n"
                              +"VENUE NAME:\t"+venuename+"\n"
                              +"VENUE ADDRESS:\t"+venueaddress+"\n"
                              +"VENUE PHONENUMBER:\t"+venuepnumber+"\n"
                              +"WANT DECORATIONS?:\t"+decorations+"\n"
                              +"DECORATION THEME:\t"+theme+"\n"
                              +"DECOR DETAILS:\t"+decordetails+"\n"
                              +"FOOD"
                              +"ADULT MEAL:\t"+adultmeal+" FOR "+adultpersons+" PERSONS"
                              +"KIDS MEAL:\t"+kidsmeal+" FOR "+kidspersons+" PERSONS"
                              +"DRINKS:\t"+drinkchoice+" FOR "+drinkpersons+" PERSONS"
                              +"DESSERTS:\t"+dessertmeal+" FOR "+dessertpersons+" PERSONS"
                              +"TOTAL PRICE:\tR"+totalprice
                              +"-------------------------------"
                );
                boolean ynloop = true;
                while (ynloop) {
                    System.out.println("IS THIS INFORMATION CORRECT?\n"
                                  +"1. YES\n"
                                  +"2. NO");
                    int yn = sn.nextInt();
                    sn.nextLine();
                    switch (yn) {
                        case 1:
                            ynloop = false;
                            eventloop = false;
                            
                            break;
                        case 2:
                        boolean exitloop = true;
                        while (exitloop) {
                            System.out.println("DO YOU WANT TO EXIT?\n"
                                          +"1.YES\n"
                                          +"2.NO");
                            int yesno = sn.nextInt();
                            sn.nextLine();  
                            switch (yesno) {
                                case 1:                                    
                                    return;
                                case 2:   
                                    exitloop = false;                                 
                                    break;
                                default:
                                    System.out.println("PLEASE ENTER THE RIGHT INPUT");
                                    break;
                            } 
                        }
                            ynloop = false;
                        default:
                            System.out.println("PLEASE ENTER THE RIGHT INPUT");
                            break;
                    }
                }
        }
    }
    public void EditEvent() {
        System.out.println("");
    }
}