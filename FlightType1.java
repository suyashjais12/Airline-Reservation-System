/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.airline.model;

/**
 *
 * @author sanjayp
 */
public class FlightType1 extends Flight{
static int economySeatCount;
    static int businessSeatCount;
    static int firstClassSeatCount;
    static int currentEconomySeatNumber;
    static int currentBusinessSeatNumber;
    static int currentFirstClassSeatNumber;
    static int economySeatStartNumber;
    static int businessSeatStartNumber;
    static int firstClassSeatStartNumber;
    static String flightTypeName ;
    public FlightType1(int ecoSeatCount, int busSeatCount, int firstClsSeatCount, String typeName, int ecoSeatStart, int busSeatStart, int firstClsSeatStart){
        economySeatCount = ecoSeatCount;
        businessSeatCount = busSeatCount;
        firstClassSeatCount = firstClsSeatCount;
        flightTypeName = typeName;
        currentEconomySeatNumber = ecoSeatStart;
        currentBusinessSeatNumber = busSeatStart;
        currentFirstClassSeatNumber = firstClsSeatStart;
    }
    @Override
    public String startReservation(String seatCategory) {
        String pnrId = "NA";
        int seatNumber = 0;
        if("Economy".equalsIgnoreCase(seatCategory)){
            if(economySeatCount > 0){
                seatNumber = currentEconomySeatNumber + 1;
                economySeatCount--;
            }
        }else if("Business".equalsIgnoreCase(seatCategory)){
            if(businessSeatCount > 0){
                seatNumber = currentBusinessSeatNumber + 1;
                businessSeatCount--;
            }
        }else {
            if(firstClassSeatCount > 0){
                seatNumber = currentFirstClassSeatNumber + 1;
                firstClassSeatCount--;
            }
        }
        pnrId = flightTypeName +"-"+seatCategory+"-"+seatNumber;
        return pnrId;
    }
    
}
