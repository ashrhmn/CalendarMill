/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarmill.Entity;

/**
 *
 * @author ashrh
 */
public class DataItem {
    private String date;
    private String name;
    private Double rate;
    private Double amount;
    private Double payable;
    private Double taka;

    public DataItem() {
    }

    public DataItem(String date, String name, Double rate, Double amount, Double payable) {
        this.date = date;
        this.name = name;
        this.rate = rate;
        this.amount = amount;
        this.payable = payable;
    }

    public Double getPayable() {
        return payable;
    }

    public void setPayable(Double payable) {
        this.payable = payable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTaka() {
        return taka;
    }

    public void setTaka(Double taka) {
        this.taka = taka;
    }
}
