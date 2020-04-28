/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.airline.processor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.airline.model.BusinessCategory;
import org.airline.model.EconomyCategory;
import org.airline.model.FirstClassCategory;
import org.airline.model.Flight;
import org.airline.model.FlightType1;
import org.airline.model.FlightType2;
import org.airline.model.FlightType3;
import org.airline.model.Passenger;

/**
 *
 * @author sanjayp
 */
public class ReservationProcessor {

    static Set pnrSet = new HashSet();
    static Map pnrSeatCategoryMap = new HashMap();
    static Flight flightType1 = new FlightType1(180, 0, 0, "Type1", 1, 0, 0);
    static Flight flightType2 = new FlightType2(180, 0, 0, "Type2", 1, 0, 0);
    static Flight flightType3 = new FlightType3(180, 0, 0, "Type3", 1, 0, 0);

    public static void main(String[] args) throws Exception {
        ReservationProcessor reservationProcessor = new ReservationProcessor();
        int choice;
        Scanner s = new Scanner(System.in);
        System.out.println("\t\t...............    Welcome to Indian Airlines   .............\n\n");
        System.out.println("Enter your choice and then press Enter to continue.");
        System.out.println("1. Book a flight\n" + "2. Cancel a flight\n");
        choice = s.nextInt();

        if (choice == 1) {
            String seatCategory = null;
            System.out.println("Enter the choice of flight:\n1. Economy\n2. Business\n3. First class");
            int c = s.nextInt();
            if (c == 1) {
                seatCategory = "Economy";
            } else if (c == 2) {
                seatCategory = "Business";
            } else {
                seatCategory = "First class";
            }
System.out.println("Enter the passenger details:\n");
            String name = s.next();
            Passenger pasnger = new Passenger(name);
//            System.out.println("How many passengers ?\n");
//            int passengerCount = s.nextInt();

//            Passenger passenger[] = new Passenger[passengerCount];
//            System.out.println("Enter the passenger details:\n");
//            for (int i = 0; i < passengerCount; i++) {
//                String name = s.next();
//                Passenger pasnger = new Passenger(name);
//                passenger[i] = pasnger;
//            }
            String pnrNumber= "NA";
            if ("Economy".equalsIgnoreCase(seatCategory)) {
                pnrNumber=flightType3.startReservation(seatCategory);
                if(pnrNumber.equalsIgnoreCase("NA")){
                    pnrNumber=flightType2.startReservation(seatCategory);
                    if(pnrNumber.equalsIgnoreCase("NA")){
                        pnrNumber=flightType1.startReservation(seatCategory);
                    }
                }
            } else if ("Business".equalsIgnoreCase(seatCategory)) {
                pnrNumber=flightType3.startReservation(seatCategory);
                if(pnrNumber.equalsIgnoreCase("NA")){
                    pnrNumber=flightType2.startReservation(seatCategory);
                    
                }
            } else {
                pnrNumber=flightType3.startReservation(seatCategory);
            }
            if(pnrNumber.equalsIgnoreCase("NA")){
                System.out.println("Sorry no seat availability ");
            }else{
                pnrSet.add(pnrNumber);
                pnrSeatCategoryMap.put(pnrNumber, seatCategory);
                System.out.println("Congratulation your booking is confirmed !! Your PNR number is ::"+pnrNumber);
                System.out.println("Enter your baggage in kg ::");
                int baggageinKg = s.nextInt();
                
            }
        } else {
            System.out.println("Please your PNR number :");
            String pnr = s.next();
            boolean isCancelled = reservationProcessor.cancel(pnr);
            if (isCancelled) {
                System.out.println("Congratulations your ticket is successfully cancelled");
            } else {
                System.out.println("Sorry pnr number is not correct");

            }
        }

    }

    private boolean cancel(String pnr) {
        boolean isCancelled = false;
        if (pnrSet.contains(pnr)) {
            pnrSet.remove(pnr);
            pnrSeatCategoryMap.remove(pnr);
            isCancelled = true;
        }
        return isCancelled;
    }

    private int getBaggageLimit(String pnr) {
        int baggageLimit = 0;
        String seatCategory = (String) pnrSeatCategoryMap.get(pnr);
            if ("Economy".equalsIgnoreCase(seatCategory)) {
                EconomyCategory Category = new EconomyCategory();
                baggageLimit = Category.maxFreeAllowedBaggage;
            } else if ("Business".equalsIgnoreCase(seatCategory)) {
                BusinessCategory Category = new BusinessCategory();
                baggageLimit = Category.maxFreeAllowedBaggage;
            } else {
                FirstClassCategory Category = new FirstClassCategory();
                baggageLimit = Category.maxFreeAllowedBaggage;
            }
        return baggageLimit;
    }

    private int buyExcessBagagge(int k) {
        int baggageLimit = 0;
        return baggageLimit;
    }
    
    private int makePayment(int R) {
        int baggageLimit = 0;
        return baggageLimit;
    }
}
