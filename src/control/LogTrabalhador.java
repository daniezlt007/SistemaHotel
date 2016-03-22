/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.DadTrabalhador;
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
public class LogTrabalhador {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String eSQL = "";
    private String eSQL2 = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "CPF", "RG", "Endereço", "Fone Res. Com.", "Fone Celular", "Email", "Salário", "Acesso", "Login", "Senha", "Estado"};

        String[] registro = new String[13];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        eSQL = "select p.idpessoa, p.nome, p.cpf, p.rg, p.endereco, p.fone_res_com, "
                + "p.fone_cel, p.email, t.salario, t.acesso, t.login, t.senha, t.estado from pessoa p inner join trabalhador t on "
                + "(p.idpessoa = t.idpessoa) where p.cpf like '%" + buscar + "%'order by p.idpessoa desc";

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
                registro[8] = rs.getString("salario");
                registro[9] = rs.getString("acesso");
                registro[10] = rs.getString("login");
                registro[11] = rs.getString("senha");
                registro[12] = rs.getString("estado");
                

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean inserir(DadTrabalhador dts) {
        eSQL = "insert into pessoa (nome, cpf, rg, endereco, fone_res_com, fone_cel, email)"
                + " values (?,?,?,?,?,?,?)";
        eSQL2 = "insert into trabalhador (idpessoa, salario, acesso, login, senha, estado)"
                + " values ((select idpessoa from pessoa order by idpessoa desc limit 1),?,?,?,?,?)";
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

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getSenha());
            pst2.setString(5, dts.getEstado());

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

    public boolean editar(DadTrabalhador dts) {
        eSQL = "update pessoa set nome=?, cpf=?, rg=?, endereco=?, fone_res_com=?, fone_cel=?, email=? where idpessoa=? ";
        
        eSQL2 = "update trabalhador set salario=?, acesso=?, login=?, senha=?, estado=? where idpessoa=?";
        
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

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getSenha());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdpessoa());
            
            
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

    public boolean excluir(DadTrabalhador dts) {
        eSQL = "delete from trabalhador where idpessoa=?";
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
    
    public DefaultTableModel Logar (String login, String senha) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "CPF", "RG", "Acesso", "Login", "Senha", "Estado"};

        String[] registro = new String[8];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        eSQL = "select p.idpessoa, p.nome, p.cpf, p.rg, "
                + "t.acesso, t.login, t.senha, t.estado from pessoa p inner join trabalhador t on "
                + "(p.idpessoa = t.idpessoa) where t.login='" + login + "' and t.senha='"+senha+"' and t.estado='ATIVADO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(eSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpessoa");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("cpf");
                registro[3] = rs.getString("rg");
                registro[4] = rs.getString("acesso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("senha");
                registro[7] = rs.getString("estado");
                

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
}
