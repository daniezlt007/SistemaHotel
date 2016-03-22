/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.DadReserva;
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
public class LogReserva {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String eSQL="";
    public Integer totalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "IdHabitacao", "Apto", "IdCliente", "Cliente", "IdTrabalhador", "Trabalhador", "Tipo Reserva", "Fecha Reserva", "Fecha Entrada", "Fecha Saída", "Valor", "Estado"};
        
        String [] registro = new String [13];
        
        totalRegistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        eSQL = "select r.idreserva, r.idhabitacao,h.apto,r.idcliente,"+
                "(select nome from pessoa where idpessoa=r.idcliente) as clienten,"+
                //"(select cpf from pessoa where idpessoa=r.idcliente) as clientec,"+
                " r.idtrabalhador,(select nome from pessoa where idpessoa=r.idtrabalhador) as trabalhadorn,"+
                //"(select cpf from pessoa where idpessoa=r.idtrabalhador) as trabalhadorc,"+
                " r.tipo_reserva, r.fecha_reserva, r.entrada_reserva,r.saida_reserva,"+
                " r.custo_apto, r.estado from reserva r inner join habitacao h on (r.idhabitacao=h.idhabitacao) where r.fecha_reserva like '%"+ buscar + "%'order by r.idreserva desc";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(eSQL);
            
            while(rs.next()){
                registro[0]= rs.getString("idreserva");
                registro[1]= rs.getString("idhabitacao");
                registro[2]= rs.getString("apto");
                registro[3]= rs.getString("idcliente");
                registro[4]= rs.getString("clienten");//+ " - " + rs.getString("clientec");
                registro[5]= rs.getString("idtrabalhador");
                registro[6]= rs.getString("trabalhadorn");//+ " - " + rs.getString("trabalhadorc");
                registro[7]= rs.getString("tipo_reserva");
                registro[8]= rs.getString("fecha_reserva");
                registro[9]= rs.getString("entrada_reserva");
                registro[10]= rs.getString("saida_reserva");
                registro[11]= rs.getString("custo_apto");
                registro[12]= rs.getString("estado");
                
                
                totalRegistros = totalRegistros+1;
                modelo.addRow(registro);
                
                
            }
            return modelo;
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }          
    }
    
    public boolean inserir (DadReserva dts){
        eSQL ="insert into reserva (idhabitacao, idcliente, idtrabalhador, "+
              "tipo_reserva, fecha_reserva, entrada_reserva, saida_reserva, custo_apto, estado)" +
              "values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdhabitacao());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdtrabalhador());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, dts.getFecha_reserva());
            pst.setDate(6, dts.getEntrada_reserva());
            pst.setDate(7, dts.getSaida_reserva());
            pst.setDouble(8, dts.getCusto_apto());
            pst.setString(9, dts.getEstado());
            
            
           
            
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
    
    public boolean editar (DadReserva dts){
        eSQL = "update reserva set idhabitacao=?, idcliente=?, idtrabalhador=?,tipo_reserva=?,fecha_reserva=?,"+
                "entrada_reserva=?, saida_reserva=?,custo_apto=?,estado=? where idreserva=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdhabitacao());
            pst.setInt(2, dts.getIdcliente());
            pst.setInt(3, dts.getIdtrabalhador());
            pst.setString(4, dts.getTipo_reserva());
            pst.setDate(5, dts.getFecha_reserva());
            pst.setDate(6, dts.getEntrada_reserva());
            pst.setDate(7, dts.getSaida_reserva());
            pst.setDouble(8, dts.getCusto_apto());
            pst.setString(9, dts.getEstado());
            
            pst.setInt(10,dts.getIdreserva());
            
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
    
    public boolean pagar (DadReserva dts){
        eSQL = "update reserva set estado='Pago' where idreserva=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1,dts.getIdreserva());
            
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
    public boolean excluir (DadReserva dts){
        eSQL="delete from reserva where idreserva=?";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdreserva());
            
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
