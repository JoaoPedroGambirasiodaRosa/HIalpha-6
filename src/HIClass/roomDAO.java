/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HIClass;

import java.sql.Connection;
import HIClass.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author s.lucas
 */
public class roomDAO {

    Connection con;
    
    public roomDAO() throws SQLException {
        con = connectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(room s) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbroom (room) VALUES (?)");

            stmt.setString(1, s.getRoom());
          
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sala Salva com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(room s) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbroom WHERE pkidroom = ?");
            stmt.setInt(1, s.getPkIdRoom());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(room s) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbroom SET room = ?, local = ?, floor = ? WHERE pkidroom = ?");
            stmt.setString(1, s.getRoom());
            stmt.setString(2, s.getLocall());
            stmt.setString(3, s.getFloor()); 
            stmt.setInt(4, s.getPkIdRoom());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sala Atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS
    public ArrayList<room> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<room> salas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbroom");
            rs = stmt.executeQuery();

            while (rs.next()) {

                room sala = new room();

                sala.setPkIdRoom(rs.getInt("pkidsala"));
                sala.setRoom(rs.getString("room"));
                
                salas.add(sala);
            }

        } catch (SQLException ex) {
            Logger.getLogger(roomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<room>) salas;

    }

//PESQUISA PELO LOGIN
    public List<room> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null; int tipo = 0;
        if(opcao == 1){
            sql = "SELECT * FROM tbroom ORDER BY sala ASC";
        }else if(opcao == 2){
             sql = "SELECT * FROM tbroom ORDER BY sala DESC";
        }else {
           sql = "SELECT * FROM tbroom WHERE sala LIKE ?";
           tipo=1;
        }
        
        
        ArrayList<room> salas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
          
            if (tipo==1 || tipo ==2){
                stmt.setString(1, "%" + desc + "%");                
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                room sala = new room();

                sala.setPkIdRoom(rs.getInt("pkidroom"));
                sala.setRoom(rs.getString("room"));
                salas.add(sala);
            }

        } catch (SQLException ex) {
            Logger.getLogger(roomDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return salas;
    }

    
}
