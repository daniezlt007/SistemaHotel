/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.DadCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class LogCliente {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String eSQL = "";
    private String eSQL2 = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "CPF", "RG", "Endereço", "Fone Res. Com.", "Fone Celular", "Email", "Código"};

        String[] registro = new String[9];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        eSQL = "select p.idpessoa, p.nome, p.cpf, p.rg, p.endereco, p.fone_res_com, "
                + "p.fone_cel, p.email, c.codigo_cliente from pessoa p inner join cliente c on "
                + "(p.idpessoa = c.idpessoa) where cpf like '%" + buscar + "%'order by p.idpessoa desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(eSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpessoa");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("cpf");
                registro[3] = rs.getString("rg");
                registro[4] = rs.getString("endereco");
                registro[5] = rs.getString("fone_res_com");
                registro[6] = rs.getString("fone_cel");
                registro[7] = rs.getString("email");
                registro[8] = rs.getString("codigo_cliente");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean inserir(DadCliente dts) {
        eSQL = "insert into pessoa (nome, cpf, rg, endereco, fone_res_com, fone_cel, email)"
                + " values (?,?,?,?,?,?,?)";
        eSQL2 = "insert into cliente (idpessoa, codigo_cliente)"
                + " values ((select idpessoa from pessoa order by idpessoa desc limit 1),?)";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            PreparedStatement pst2 = cn.prepareStatement(eSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getCpf());
            pst.setString(3, dts.getRg());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getFone_res_com());
            pst.setString(6, dts.getFone_cel());
            pst.setString(7, dts.getEmail());

            pst2.setString(1, dts.getCodigo_cliente());

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "\nErro");
            return false;
        }
    }

    public boolean editar(DadCliente dts) {
        eSQL = "update pessoa set nome=?, cpf=?, rg=?, endereco=?, fone_res_com=?, fone_cel=?, email=? where idpessoa=? ";
        
        eSQL2 = "update cliente set codigo_cliente=? where idpessoa=?";
        
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            PreparedStatement pst2 = cn.prepareStatement(eSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getCpf());
            pst.setString(3, dts.getRg());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getFone_res_com());
            pst.setString(6, dts.getFone_cel());
            pst.setString(7, dts.getEmail());
            pst.setInt(8, dts.getIdpessoa());

            pst2.setString(1, dts.getCodigo_cliente());
            pst2.setInt(2, dts.getIdpessoa());
            
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean excluir(DadCliente dts) {
        eSQL = "delete from cliente where idpessoa=?";
        eSQL2 = "delete from pessoa where idpessoa=?";
        
       try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            PreparedStatement pst2 = cn.prepareStatement(eSQL2);

            pst.setInt(1, dts.getIdpessoa());

            pst2.setInt(1, dts.getIdpessoa());
            
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
