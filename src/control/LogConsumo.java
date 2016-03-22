
package control;

import model.DadConsumo;
import model.DadProduto;
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
public class LogConsumo {
    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String eSQL="";
    public Integer totalRegistros;
    public Double totalConsumo;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "IdReserva", "IdProduto","Produto", "Quantidade", "Preço Venda", "Status"};
        
        String [] registro = new String [7];
        
        totalRegistros = 0;
        totalConsumo = 0.0;
                
        modelo = new DefaultTableModel(null,titulos);
        
        eSQL = "select c.idconsumo,c.idreserva,c.idproduto,p.nome_prod,c.quantidade, c.preco_venda, c.estado"+
                " from consumo c inner join produto p on (c.idproduto=p.idproduto) where c.idreserva ="+buscar+
                " order by c.idconsumo desc";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(eSQL);
            
            while(rs.next()){
                registro[0]= rs.getString("idconsumo");
                registro[1]= rs.getString("idreserva");
                registro[2]= rs.getString("idproduto");
                registro[3]= rs.getString("nome_prod");
                registro[4]= rs.getString("quantidade");
                registro[5]= rs.getString("preco_venda");
                registro[6]= rs.getString("estado");
                              
                totalRegistros = totalRegistros+1;
                totalConsumo=totalConsumo + (rs.getDouble("quantidade") * rs.getDouble("preco_venda"));
                modelo.addRow(registro);
                
                
            }
            return modelo;
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }          
    }
    
    public boolean inserir (DadConsumo dts){
        eSQL ="insert into consumo (idreserva, idproduto, quantidade, preco_venda, estado)" +
                "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setInt(2, dts.getIdproduto());
            pst.setDouble(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco_venda());
            pst.setString(5, dts.getEstado());
           
            
            int n = pst.executeUpdate();
            
            if (n !=0){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e + "erro");
            return false;
        }
    }
    
    public boolean editar (DadConsumo dts){
        eSQL = "update consumo set idreserva=?, idproduto=?, quantidade=?, preco_venda=?, estado=?" +
                " where idconsumo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdreserva());
            pst.setInt(2, dts.getIdproduto());
            pst.setDouble(3, dts.getQuantidade());
            pst.setDouble(4, dts.getPreco_venda());
            pst.setString(5, dts.getEstado());
            
            pst.setInt(6, dts.getIdconsumo());
            
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
    
    public boolean excluir (DadConsumo dts){
        eSQL="delete from consumo where idconsumo=?";
        try {
            PreparedStatement pst = cn.prepareStatement(eSQL);
            pst.setInt(1, dts.getIdconsumo());
            
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
