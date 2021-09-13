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
import HIClass.category;
/**
 *
 * @author s.lucas
 */
public class categoryDAO {
    
 Connection con;
        
public void create(category u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbcategory (Category, VALUE (?)");
            stmt.setString(1, u.getCategory());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "A categoria "+u.getCategory()
                    +" foi salva com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<category> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<category> categorias = new ArrayList<category>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategory");
            rs = stmt.executeQuery();
            while(rs.next()){
                user usuario = new user();
                categorias.setId(rs.getInt("idCategory"));
                categorias.setCategory(rs.getString("Category"));
                categorias.add(categorias);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<category>) categorias;
    }
    
    public ArrayList<category> readPesq(String category){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<category> categorias = new ArrayList<category>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategory WHERE nome LIKE ?");
            stmt.setString(1, "%"+category+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                user usuario = new user();
                categorias.setId(rs.getInt("idCategory"));
                categorias.setCategory(rs.getString("Category"));                
                categorias.add(categorias);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<category>) categorias;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(user u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbcategory SET Category = ?,");
            stmt.setString(1, u.getId());            
            stmt.setInt   (2, u.getCategory());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, " O usuario "+u.getName()
                    +" foi modificado com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt);
        }
    }
    //excluir do banco de dados   --- D
    public void delete(user u){
            PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM tbcategory WHERE id = ?");
           
            stmt.setInt   (1, u.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que"
                    + " deseja excluir o Usuario(a)"+u.getName(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, " o usuario(a) "+u.getName()
                    +" foi excluído(a)com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do Usuario(a) "+u.getCategory()
                    +" Cancelado(a)com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt);
        }
    }  
    
}
