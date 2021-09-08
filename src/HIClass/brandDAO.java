/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HIClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author s.lucas
 */
public class brandDAO {

        Connection con;
    
 public void create(brand u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbbrand (idBrand, brand) VALUE (?,?)");
            stmt.setString(1, u.getBrand());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Esta Marca "+u.getBrand()
                    +" foi salva com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt);
        }
    }   
    
}
