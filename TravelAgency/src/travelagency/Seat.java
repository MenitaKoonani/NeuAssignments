/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

/**
 *
 * @author Menita Koonani
 */
public class Seat {

    private int numWindow;
    private int numAisle;
    private int numMiddle;
    private int columnNum;
    private int totalSeats;
    private static float aislePrice;
    private static float windowPrice;
    private static float middlePrice;

    // constructor
    public Seat() {
        numWindow = 0;
        numAisle = 0;
        numMiddle = 0;
        columnNum = 1;
        totalSeats = numWindow + numAisle + numMiddle;
    }

    public int getNumWindow() {
        return numWindow;
    }

    public void setNumWindow(int numWindow) {
        this.numWindow += numWindow;
    }

    public int getNumAisle() {
        return numAisle;
    }

    public void setNumAisle(int numAisle) {
        this.numAisle += numAisle;
    }

    public int getNumMiddle() {
        return numMiddle;
    }

    public void setNumMiddle(int numMiddle) {
        this.numMiddle += numMiddle;
    }
    
    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats += totalSeats;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public float getAislePrice() {
        return aislePrice;
    }

    public void setAislePrice(float aislePrice) {
        this.aislePrice = aislePrice;
    }

    public float getWindowPrice() {
        return windowPrice;
    }

    public void setWindowPrice(float windowPrice) {
        this.windowPrice = windowPrice;
    }

    public float getMiddlePrice() {
        return middlePrice;
    }

    public void setMiddlePrice(float middlePrice) {
        this.middlePrice = middlePrice;
    }
}
