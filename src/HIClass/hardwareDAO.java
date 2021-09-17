/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HIClass;

import HIClass.brand;
import HIClass.hardware;
import HIClass.category;
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
public class hardwareDAO {
Connection con;

    public hardwareDAO() throws SQLException {
        con = connectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(hardware h) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbHardware(nome,modelo,estado,data,"
                    + " preco,caracteristica,fkidcategoria,fkidmarca) VALUES (?,?,?,?,?,?,?,?)");

            stmt.setString(1, h.getName());

            stmt.setString(2, h.getModel());
            stmt.setString(3, h.getStats());
            stmt.setString(4, h.getDatee());
            stmt.setDouble(5, h.getPrice());
            stmt.setString(6, h.getCharacteristics());
            stmt.setInt(7, h.getCategory().getIdPkCat());
            stmt.setInt(8, h.getBrand().getIdPkBrand());

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Hardware Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar:" + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(hardware h) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbhardware WHERE pkidhard = ?");
            stmt.setInt(1, h.getIdHard());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(hardware h) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbhardware SET nome=?,modelo=?, estado=?, data=?, preco=?, caracteristica=?,fkidcategoria=?,fkidmarca=? WHERE pkidhard = ?");
            stmt.setString(1, h.getName());
            stmt.setString(2, h.getModel());
            stmt.setString(3, h.getStats());
            stmt.setString(4, h.getDatee());
            stmt.setDouble(5, h.getPrice());
            stmt.setString(6, h.getCharacteristics());
            stmt.setInt(7, h.getCategory().getIdPkCat());
            stmt.setInt(8, h.getBrand().getIdPkBrand());

            stmt.setInt(9, h.getIdHard());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//MÉTODO PARA RETORNAR AS CATEGORIAS PARA A COMBOBOX
    public ArrayList<category> listaCategoria() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<category> cs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategory order by categoria ASC ");
            rs = stmt.executeQuery();

            while (rs.next()) {

                category c = new category();

                c.setIdPkCat(rs.getInt("pkidcategory"));
                c.setCategory(rs.getString("category"));

                cs.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(hardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<category>) cs;

    }

    //MÉTODO PARA RETORNAR AS MARCA PARA A COMBOBOX
    public ArrayList<brand> listaMarca() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<brand> ms = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbbrand");
            rs = stmt.executeQuery();

            while (rs.next()) {

                brand m = new brand();

                m.setIdPkBrand(rs.getInt("pkidbrand"));
                m.setBrand(rs.getString("brand"));

                ms.add(m);
            }

        } catch (SQLException ex) {
            Logger.getLogger(hardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<brand>) ms;

    }

//EM ORDEM DE CADASTRO TODOS
    public ArrayList<hardware> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<hardware> hs = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT h.pkidhard, h.hardware, h.model, h.stats, h.datee,h.price,"
                    + " h.characteristics, c.category, m.brand FROM tbhardware as h "
                    + "join tbcategory as c on (h.fkidCategory=c.pkidcategory) "
                    + "join tbbrand as m on (h.fkidbrand = m.pkidbrand)");
            rs = stmt.executeQuery();

            while (rs.next()) {

                hardware hard = new hardware();
                category c = new category();
                c.setCategory(rs.getString("category"));
                brand m = new brand();
                m.setBrand(rs.getString("brand"));
                hard.setIdHard(rs.getInt("pkidhard"));
                hard.setName(rs.getString("hardware"));
                hard.setModel(rs.getString("model"));
                hard.setStats(rs.getString("stats"));
                hard.setDatee(rs.getString("datee"));
                hard.setPrice(rs.getDouble("price"));
                hard.setCategory(c);
                hard.setBrand(m);
                hard.setCharacteristics(rs.getString("characteristics"));
                hs.add(hard);
            }

        } catch (SQLException ex) {
            Logger.getLogger(hardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<hardware>) hs;

    }

//PESQUISA PELO LOGIN
    public List<user> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null;
        int tipo = 0;
        if (opcao == 1) {
            sql = "SELECT * FROM tbuser ORDER BY nome ASC";
        } else if (opcao == 2) {
            sql = "SELECT * FROM tbuser ORDER BY nome DESC";
        } else if (opcao == 3) {
            sql = "SELECT * FROM tbuser WHERE nome LIKE ?";
            tipo = 1;
        } else {
            sql = "SELECT * FROM tbuser WHERE email LIKE ?";
            tipo = 2;
        }

        ArrayList<user> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);

            if (tipo == 1 || tipo == 2) {
                stmt.setString(1, "%" + desc + "%");
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                user usuario = new user();

                usuario.setId(rs.getInt("pkiduser"));
                usuario.setName(rs.getString("name"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPhone(rs.getString("phone"));
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(hardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }

    public boolean checkLogin(String email, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM tbuser WHERE email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(hardwareDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }
}
