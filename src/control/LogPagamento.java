/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.DadPagamento;
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
public class LogPagamento {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String eSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Idreserva", "Comprovante", "Número", "Imposto", "Total", "Fecha Emissão", "Fecha Pagamento"};

        String[] registro = new String[8];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        eSQL = "select * from pagamento where idreserva=" + buscar + " order by idpagamento desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(eSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpagamento");
                registro[1] = rs.getString("idreserva");
                registro[2] = rs.getString("tipo_comprovante");
                registro[3] = rs.getString("num_comprovante");
                registro[4] = rs.getString("igv_pagamento");
                registro[5] = rs.getString("total_pagto");
                registro[6] = rs.getString("fecha_emissao");
                registro[7] = rs.getString("fecha_pagto");

                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean inserir(DadPagamento dts) {
        eSQL = "insert into pagamento (idreserva, tipo_comprovante, num_comprovante, igv_pagamento, total_pagto,"
                + "fecha_emissao, fecha_pagto) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipocomprovante());
            pst.setString(3, dts.getNumcomprovante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotalpagamento());
            pst.setDate(6, dts.getFecha_emissao());
            pst.setDate(7, dts.getFecha_pagamento());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(DadPagamento dts) {
        eSQL = "update pagamento set idreserva=?, tipo_comprovante=?, num_comprovante=?, igv_pagamento=?"
                + " total_pagto=?, fecha_emissao=?, fecha_pagto=?  where idpagamento=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setString(2, dts.getTipocomprovante());
            pst.setString(3, dts.getNumcomprovante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotalpagamento());
            pst.setDate(6, dts.getFecha_emissao());
            pst.setDate(7, dts.getFecha_pagamento());

            pst.setInt(8, dts.getIdpagamento());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean excluir(DadPagamento dts) {
        eSQL = "delete from pagamento where idpagamento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdpagamento());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
