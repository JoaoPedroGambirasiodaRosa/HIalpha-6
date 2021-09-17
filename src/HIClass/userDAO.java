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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class userDAO {

    Connection con;

    public userDAO() throws SQLException {
        con = connectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(user u) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbuser (name, email, pass_word, phone) VALUES (?,?,?,?)");

            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPhone());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPassword());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(user u) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbuser WHERE pkidusuario = ?");
            stmt.setInt(1, u.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(user u) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbuser SET name = ?, phone = ?, email = ?, pass_word = ? WHERE pkidusuario = ?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getPhone());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, u.getPassword());
            stmt.setInt(5, u.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS
    public ArrayList<user> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<user> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbuser");
            rs = stmt.executeQuery();

            while (rs.next()) {

                user usuario = new user();

                usuario.setId(rs.getInt("pkidusuario"));
                usuario.setName(rs.getString("name"));
                usuario.setPhone(rs.getString("phone"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("pass_word"));

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<user>) usuarios;

    }

//PESQUISA PELO LOGIN
    public List<user> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null; int tipo = 0;
        if(opcao == 1){
            sql = "SELECT * FROM tbuser ORDER BY nome ASC";
        }else if(opcao == 2){
             sql = "SELECT * FROM tbuser ORDER BY nome DESC";
        }else if(opcao == 3){
           sql = "SELECT * FROM tbuser WHERE nome LIKE ?";
           tipo=1;
        }else{
              sql = "SELECT * FROM tbuser WHERE email LIKE ?";
              tipo = 2;
        }
        
        
        ArrayList<user> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
          
            if (tipo==1 || tipo ==2){
                stmt.setString(1, "%" + desc + "%");                
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                user usuario = new user();

                usuario.setId(rs.getInt("pkidusuario"));
                usuario.setName(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPhone(rs.getString("fone"));
                usuario.setPassword(rs.getString("Pass_Word"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }

    public boolean checkLogin(String email, String pass_word) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM tbuser WHERE email = ? and pass_word = ?");
            stmt.setString(1, email);
            stmt.setString(2, pass_word);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }
}
