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
public class userDAO {
    
  Connection con;
    
    public userDAO() throws SQLException{
        con = connectionFactory.getConnection();
    }
    
    public boolean  checkLogin(String user, String pass_word){
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbuser"
                    + " where name = ? AND pass_word = ?");
            stmt.setString(1, user);
            stmt.setString(2, pass_word);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;
            }
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
        }
        return check;
    }
    // SALVA O USUARIO NO BANCO DE DADOS   ---- C
    public void create(user u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbuser (name,"
                    + "email,pass_word,phone) VALUE (?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getPhone());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Este usuário "+u.getName()
                    +" foi salvo com Sucesso!!");
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt);
        }
    }
     //listagem de usuarios na tabela do formulario   ---   R
    
    public ArrayList<user> read(){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<user> usuarios = new ArrayList<user>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbuser");
            rs = stmt.executeQuery();
            while(rs.next()){
                user usuario = new user();
                usuario.setId(rs.getInt("id"));
                usuario.setName(rs.getString("name"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("pass_word"));
                usuario.setPhone(rs.getString("phone"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<user>) usuarios;
    }
    
    public ArrayList<user> readPesq(String nome){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<user> usuarios = new ArrayList<user>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                user usuario = new user();
                usuario.setId(rs.getInt("id"));
                usuario.setName(rs.getString("name"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("pass_word"));
                usuario.setPhone(rs.getString("phone"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return (ArrayList<user>) usuarios;
    }
    
    //ALTERAR O USUARIO NO BANCO DE DADOS   -- U 
    public void update(user u){
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbuser SET name = ?,"
                    + "email = ?, pass_word = ? ,phone = ? WHERE id = ?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getPassword());
            stmt.setString(4, u.getPhone());
            stmt.setInt   (5, u.getId());
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
            stmt = con.prepareStatement("DELETE FROM tbuser WHERE id = ?");
           
            stmt.setInt   (1, u.getId());
            
            if (JOptionPane.showConfirmDialog(null,"Exclusão", "Tem certeza que"
                    + " deseja excluir o Usuario(a)"+u.getName(),
                    JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, " o usuario(a) "+u.getName()
                    +" foi excluído(a)com Sucesso!!");
                stmt.executeUpdate();
            }else{
                JOptionPane.showMessageDialog(null, "A exclusão do Usuario(a) "+u.getName()
                    +" Cancelado(a)com Sucesso!!");
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro:"+e.getMessage());
        } finally{
            connectionFactory.closeConnection(con, stmt);
        }
    }  
    
}
