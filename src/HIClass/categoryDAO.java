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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author s.lucas
 */
public class categoryDAO {
    
 Connection con;
        
 public categoryDAO() throws SQLException {
        con = connectionFactory.getConnection();
    }
 
 public void create(category c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbcategory (category) VALUES (?)");

            stmt.setString(1, c.getCategory());
          
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Categoria Salva com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(category c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbcategory WHERE pkidcategory = ?");
            stmt.setInt(1, c.getIdPkCat());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Categoria Excluida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(category c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbcategory SET category = ? WHERE pkidcategory = ?");
            stmt.setString(1, c.getCategory());
            

            stmt.setInt(2, c.getIdPkCat());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Categoria Atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS
    public ArrayList<category> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<category> categorias = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategory");
            rs = stmt.executeQuery();

            while (rs.next()) {

                category categoria = new category();

                categoria.setIdPkCat(rs.getInt("pkidcategory"));
                categoria.setCategory(rs.getString("category"));
                
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(categoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<category>) categorias;

    }

//PESQUISA PELO LOGIN
    public ArrayList<category> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null; int tipo = 0;
        if(opcao == 1){
            sql = "SELECT * FROM tbcategory ORDER BY categoria ASC";
        }else if(opcao == 2){
             sql = "SELECT * FROM tbcategory ORDER BY categoria DESC";
        }else {
           sql = "SELECT * FROM tbcategory WHERE categoria LIKE ?";
           tipo=1;
        }
        
        
        ArrayList<category> categorias = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
          
            if (tipo==1 || tipo ==2){
                stmt.setString(1, "%" + desc + "%");                
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                category categoria = new category();

                categoria.setIdPkCat(rs.getInt("pkidcategory"));
                categoria.setCategory(rs.getString("category"));
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(categoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return categorias;
    }

    
}
