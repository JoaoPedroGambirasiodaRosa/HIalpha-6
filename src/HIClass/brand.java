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
public class brand {
    
  private int idPkBrand; 
  private String brand; 

    public int getIdPkBrand() {
        return idPkBrand;
    }

    public void setIdPkBrand(int idPkBrand) {
        this.idPkBrand = idPkBrand;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "brand{" + "idPkBrand=" + idPkBrand + ", brand=" + brand + '}';
    }

}
