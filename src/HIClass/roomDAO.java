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
public class roomDAO {
    
            Connection con;
    
 public void create(room u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbroom (idRoom, locall, floor) VALUE (?,?,?,?)");
            stmt.setString(1, u.getRoom());
            stmt.setString(1, u.getLocal());
            stmt.setString(1, u.getFloor());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "A "+u.getRoom()
                    +" foi salva com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt);
        }
    }  
    
}
