/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarmill.Repository;

/**
 *
 * @author ashrh
 */
public class Conversions {
    public Double convertAmountYardToMeter(Double yard){
        yard *= 0.9144;
        return Math.round(yard * 100.0) / 100.0;
    }
    
    public Double convertAmountMeterToYard(Double meter){
        meter *= 1.09361;
        return Math.round(meter * 100.0) / 100.0;
    }
    
    public Double convertRateYardToMeter(Double yard){
        yard /= 0.9144;
        return Math.round(yard * 100.0) / 100.0;
    }
    
    public Double convertRateMeterToYard(Double meter){
        meter /= 1.09361;
        return Math.round(meter * 100.0) / 100.0;
    }
}
