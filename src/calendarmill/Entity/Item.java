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
public class Item {
    private String name;
    private Double ratey;
    private Double ratem;

    public Item() {
    }

    public Item(String name, Double ratey, Double ratem) {
        this.name = name;
        this.ratey = ratey;
        this.ratem = ratem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRatey() {
        return ratey;
    }

    public void setRatey(Double ratey) {
        double roundedDouble = Math.round(ratey * 100.0) / 100.0;
        this.ratey = roundedDouble;
    }

    public Double getRatem() {
        return ratem;
    }

    public void setRatem(Double ratem) {
        double roundedDouble = Math.round(ratem * 100.0) / 100.0;
        this.ratem = roundedDouble;
    }
    
    
    
}
