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
public class category {

private int idPkCat;
private String category;

    public int getIdPkCat() {
        return idPkCat;
    }

    public void setIdPkCat(int idPkCat) {
        this.idPkCat = idPkCat;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        
    }
    @Override
    public String toString() {
        return  this.getCategory();
    }
}
   