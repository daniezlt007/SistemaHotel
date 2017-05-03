/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.DadProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class LogProduto {
    private final Conexao mysql = new Conexao();
    private final Connection cn = mysql.conectar();
    private String eSQL="";
    public Integer totalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "Produto", "Descricao", "Unidade Medida", "Preço Venda"};
        
        String [] registro = new String [5];
        
        totalRegistros=0;
        modelo = new DefaultTableModel(null,titulos);
        
        eSQL = "select * from produto where nome_prod like '%"+ buscar + "%'order by idproduto desc";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(eSQL);
            
            while(rs.next()){
                registro[0]= rs.getString("idproduto");
                registro[1]= rs.getString("nome_prod");
                registro[2]= rs.getString("descricao");
                registro[3]= rs.getString("unidade_medida");
                registro[4]= rs.getString("preco_venda");
                              
                totalRegistros = totalRegistros+1;
                modelo.addRow(registro);
                
                
            }
            return modelo;
            
        }catch (SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }          
    }
    
    public boolean inserir (DadProduto dts){
        eSQL ="insert into produto (nome_prod, descricao, unidade_medida, preco_venda)" +
                "values (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setString(1, dts.getNome_produto());
            pst.setString(2, dts.getDescricao());
            pst.setString(3, dts.getUnidade_medida());
            pst.setDouble(4, dts.getPreco_venda());
           
            
            int n = pst.executeUpdate();
            
            return n !=0;
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar (DadProduto dts){
        eSQL = "update produto set nome_prod=?, descricao=?, unidade_medida=?, preco_venda=?" +
                " where idproduto=? ";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setString(1, dts.getNome_produto());
            pst.setString(2, dts.getDescricao());
            pst.setString(3, dts.getUnidade_medida());
            pst.setDouble(4, dts.getPreco_venda());
            
            pst.setInt(5, dts.getIdproduto());
            
            int n = pst.executeUpdate();
            
            return n !=0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean excluir (DadProduto dts){
        eSQL="delete from produto where idproduto=?";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdproduto());
            
            int n = pst.executeUpdate();
            
            if (n != 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
