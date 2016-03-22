/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.DadHabitacao;
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
public class LogHabitacao {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String eSQL="";
    public Integer totalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Apto", "Andar", "Descricao", "Caracteristicas", "Preço", "Status", "Tipo Habitação"};
        
        String [] registro = new String [8];
        
        totalRegistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        eSQL = "select * from habitacao where andar like '%"+ buscar + "%'order by idhabitacao";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(eSQL);
            
            while(rs.next()){
                registro[0]= rs.getString("idhabitacao");
                registro[1]= rs.getString("apto");
                registro[2]= rs.getString("andar");
                registro[3]= rs.getString("descricao");
                registro[4]= rs.getString("caracteristica");
                registro[5]= rs.getString("preco_diaria");
                registro[6]= rs.getString("status");
                registro[7]= rs.getString("tipo_habitacao");
                
                totalRegistros = totalRegistros+1;
                modelo.addRow(registro);
                
                
            }
            return modelo;
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }          
    }
    
    public DefaultTableModel mostrarView(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Apto", "Andar", "Descricao", "Caracteristicas", "Preço", "Status", "Tipo Habitação"};
        
        String [] registro = new String [8];
        
        totalRegistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        eSQL = "select * from habitacao where andar like '%"+ buscar + "%' and status='Disponível' order by idhabitacao";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(eSQL);
            
            while(rs.next()){
                registro[0]= rs.getString("idhabitacao");
                registro[1]= rs.getString("apto");
                registro[2]= rs.getString("andar");
                registro[3]= rs.getString("descricao");
                registro[4]= rs.getString("caracteristica");
                registro[5]= rs.getString("preco_diaria");
                registro[6]= rs.getString("status");
                registro[7]= rs.getString("tipo_habitacao");
                
                totalRegistros = totalRegistros+1;
                modelo.addRow(registro);
                
                
            }
            return modelo;
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }          
    }
    
    public boolean inserir (DadHabitacao dts){
        eSQL ="insert into habitacao (apto, andar, descricao, caracteristica, preco_diaria, status, tipo_habitacao)" +
                "values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setString(1, dts.getApto());
            pst.setString(2, dts.getAndar());
            pst.setString(3, dts.getDescricao());
            pst.setString(4, dts.getCaracteristica());
            pst.setDouble(5, dts.getPreco_diaria());
            pst.setString(6, dts.getStatus());
            pst.setString(7, dts.getTipo_habitacao());
            
            int n = pst.executeUpdate();
            
            if (n !=0){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar (DadHabitacao dts){
        eSQL = "update habitacao set apto=?, andar=?, descricao=?, caracteristica=?, preco_diaria=?, status=?, tipo_habitacao=?" +
                " where idhabitacao=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setString(1, dts.getApto());
            pst.setString(2, dts.getAndar());
            pst.setString(3, dts.getDescricao());
            pst.setString(4, dts.getCaracteristica());
            pst.setDouble(5, dts.getPreco_diaria());
            pst.setString(6, dts.getStatus());
            pst.setString(7, dts.getTipo_habitacao());
            pst.setInt(8, dts.getIdhabitacao());
            
            int n = pst.executeUpdate();
            
            if (n !=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean desocupar (DadHabitacao dts){
        eSQL = "update habitacao set status='Disponível'" +
                " where idhabitacao=?";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);;
            pst.setInt(1, dts.getIdhabitacao());
            
            int n = pst.executeUpdate();
            
            if (n !=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean ocupar (DadHabitacao dts){
        eSQL = "update habitacao set status='Ocupado'" +
                " where idhabitacao=?";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);;
            pst.setInt(1, dts.getIdhabitacao());
            
            int n = pst.executeUpdate();
            
            if (n !=0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean excluir (DadHabitacao dts){
        eSQL="delete from habitacao where idhabitacao=?";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdhabitacao());
            
            int n = pst.executeUpdate();
            
            if (n != 0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
