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
public class Passenger {
    private String name;
    private String seatNumber;
    private String pnrNumber;
    private String cabinClass;
    
    public Passenger(String name){
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the seatNumber
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * @param seatNumber the seatNumber to set
     */
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * @return the pnrNumber
     */
    public String getPnrNumber() {
        return pnrNumber;
    }

    /**
     * @param pnrNumber the pnrNumber to set
     */
    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    /**
     * @return the cabinClass
     */
    public String getCabinClass() {
        return cabinClass;
    }

    /**
     * @param cabinClass the cabinClass to set
     */
    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }
}
