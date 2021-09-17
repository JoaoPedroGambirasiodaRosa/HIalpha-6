/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HIClass;

/**
 *
 * @author s.lucas
 */
public class hardware {
    
    private int idHard;
    private String name;
    private String model;
    private String stats;
    private String datee;
    private double price;
    private category category;
    private brand brand;
    private String characteristics;   

    public int getIdHard() {
        return idHard;
    }

    public void setIdHard(int idHard) {
        this.idHard = idHard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public brand getBrand() {
        return brand;
    }

    public void setBrand(brand brand) {
        this.brand = brand;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "hardware{" + "idHard=" + idHard + ", name=" + name + ", model=" + model + ", stats=" + stats + ", datee=" + datee + ", price=" + price + ", category=" + category + ", brand=" + brand + ", characteristics=" + characteristics + '}';
    }
}
