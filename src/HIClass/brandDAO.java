/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HIClass;

import HIClass.brand;
import HIClass.room;
import HIClass.user;
import java.sql.Connection;
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
public class brandDAO {

    Connection con;

    public brandDAO() throws SQLException {
        con = connectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(brand m) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbbrand (brand) VALUES (?)");

            stmt.setString(1, m.getBrand());
          
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Salva com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(brand m) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbbrand WHERE pkidbrand = ?");
            stmt.setInt(1, m.getIdPkBrand());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Excluida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(brand m) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbbrand SET brand = ? WHERE pkidbrand = ?");
            stmt.setString(1, m.getBrand());
            

            stmt.setInt(2, m.getIdPkBrand());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS
    public ArrayList<brand> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<brand> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbbrand");
            rs = stmt.executeQuery();

            while (rs.next()) {

                brand marca = new brand();

                marca.setIdPkBrand(rs.getInt("pkidbrand"));
                marca.setBrand(rs.getString("brand"));
                
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(brandDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<brand>) marcas;

    }

//PESQUISA PELO LOGIN
    public ArrayList<brand> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null; int tipo = 0;
        if(opcao == 1){
            sql = "SELECT * FROM tbbrand ORDER BY marca ASC";
        }else if(opcao == 2){
             sql = "SELECT * FROM tbbrand ORDER BY marca DESC";
        }else {
           sql = "SELECT * FROM tbbrand WHERE marca LIKE ?";
           tipo=1;
        }
        
        
        ArrayList<brand> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
          
            if (tipo==1 || tipo ==2){
                stmt.setString(1, "%" + desc + "%");                
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                brand marca = new brand();

                marca.setIdPkBrand(rs.getInt("pkidbrand"));
                marca.setBrand(rs.getString("brand"));
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(brandDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return marcas;
    }

    
}
