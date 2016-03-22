/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import model.DadHabitacao;
import model.DadPagamento;
import model.DadReserva;
import control.LogConsumo;
import control.LogHabitacao;
import control.LogPagamento;
import control.LogReserva;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class JfrmPagamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form JfrmPagamento
     */
    public JfrmPagamento() {
        initComponents();
        mostrar(idReserva);
        inabilitar();
        txtIdReserva.setText(idReserva);
        txtCliente.setText(cliente);
        txtHabitacao.setText(habitacao);
        txtIdHabitacao.setText(idHabitacao);
        txtTotalReservas.setText(Double.toString(totalReserva));
        
        LogConsumo func = new LogConsumo();
        func.mostrar(idReserva);
        
        txtTotalPagar.setText(Double.toString(totalReserva + func.totalConsumo));
    }
    
    private String acao = "salvar";
    public static String idReserva;
    public static String cliente;
    public static String idHabitacao;
    public static String habitacao;
    public static Double totalReserva;

    void ocultar_colunas() {
        TabelaListaPagto.getColumnModel().getColumn(0).setMaxWidth(0);
        TabelaListaPagto.getColumnModel().getColumn(0).setMinWidth(0);
        TabelaListaPagto.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        TabelaListaPagto.getColumnModel().getColumn(1).setMaxWidth(0);
        TabelaListaPagto.getColumnModel().getColumn(1).setMinWidth(0);
        TabelaListaPagto.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void ocultar_colunas_consumo() {
        TabelaListaConsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        TabelaListaConsumo.getColumnModel().getColumn(0).setMinWidth(0);
        TabelaListaConsumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        TabelaListaConsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        TabelaListaConsumo.getColumnModel().getColumn(1).setMinWidth(0);
        TabelaListaConsumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        TabelaListaConsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        TabelaListaConsumo.getColumnModel().getColumn(2).setMinWidth(0);
        TabelaListaConsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    void inabilitar() {
        txtIdpagamento.setVisible(false);
        
        txtIdReserva.setVisible(false);
        txtCliente.setEnabled(false);
        txtNumComprovante.setEnabled(false);
        JcomboTipoComprovante.setEnabled(false);
        txtIgv.setEnabled(false);
        txtTotalReservas.setEnabled(false);
        dcFechaEmissao.setEnabled(false);
        dcFechaPagto.setEnabled(false);
        
        txtIdHabitacao.setVisible(false);
        txtHabitacao.setEnabled(false);
        
        jButton_Salvar.setEnabled(false);
        jButton_cancelar.setEnabled(false);
        jButton_Excluir.setEnabled(false);
        txtIdpagamento.setText("");
        txtNumComprovante.setText("");
        txtIgv.setText("");
        txtTotalPagar.setText("");
    }

    void habilitar() {
        txtIdpagamento.setVisible(false);
        
        txtIdReserva.setVisible(true);
        txtCliente.setEnabled(true);
        txtNumComprovante.setEnabled(true);
        JcomboTipoComprovante.setEnabled(true);
        txtIgv.setEnabled(true);
        txtTotalReservas.setEnabled(true);
        dcFechaEmissao.setEnabled(true);
        dcFechaPagto.setEnabled(true);
        
        txtIdHabitacao.setVisible(true);
        txtHabitacao.setEnabled(true);
        
        jButton_Salvar.setEnabled(true);
        jButton_cancelar.setEnabled(true);
        jButton_Excluir.setEnabled(true);
        txtIdpagamento.setText("");
        txtNumComprovante.setText("");
        txtIgv.setText("");
        //txtTotalPagar.setText("");
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            LogPagamento func = new LogPagamento();
            modelo = func.mostrar(buscar);
            TabelaListaPagto.setModel(modelo);
            ocultar_colunas();
            LabelTotalRegistros.setText("Total Pagamentos = " + Integer.toString(func.totalRegistros));
            
            //Mostrar dados de consumos.
            LogConsumo func2 = new LogConsumo();
            modelo = func2.mostrar(buscar);
            TabelaListaConsumo.setModel(modelo);
            ocultar_colunas_consumo();
            LabelTotalRegistrosConsumo.setText("Total Consumos = " + func2.totalRegistros);
            LabelTotalConsumo.setText("Total Consumido R$"+func2.totalConsumo);
            

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtIdpagamento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdReserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNumComprovante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JcomboTipoComprovante = new javax.swing.JComboBox();
        jButton_Novo = new javax.swing.JButton();
        jButton_Salvar = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        txtTotalReservas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdHabitacao = new javax.swing.JTextField();
        txtHabitacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dcFechaEmissao = new com.toedter.calendar.JDateChooser();
        dcFechaPagto = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaListaPagto = new javax.swing.JTable();
        jButton_Excluir = new javax.swing.JButton();
        jButton_Sair = new javax.swing.JButton();
        LabelTotalRegistros = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelaListaConsumo = new javax.swing.JTable();
        LabelTotalRegistrosConsumo = new javax.swing.JLabel();
        LabelTotalConsumo = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pagamentos"));

        jLabel2.setText("Reserva.:");

        txtIdReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdReservaActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Reservas.:");

        jLabel6.setText("Num. Comprovante.:");

        txtNumComprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumComprovanteActionPerformed(evt);
            }
        });

        jLabel7.setText("Tipo de Comprovante.:");

        JcomboTipoComprovante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NFS-e", "Boleto", "Fatura", "Ticket", "Outro" }));
        JcomboTipoComprovante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcomboTipoComprovanteActionPerformed(evt);
            }
        });

        jButton_Novo.setBackground(new java.awt.Color(51, 51, 51));
        jButton_Novo.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/novo.png"))); // NOI18N
        jButton_Novo.setText("Novo");
        jButton_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NovoActionPerformed(evt);
            }
        });

        jButton_Salvar.setBackground(new java.awt.Color(51, 51, 51));
        jButton_Salvar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/salvar.png"))); // NOI18N
        jButton_Salvar.setText("Salvar");
        jButton_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalvarActionPerformed(evt);
            }
        });

        jButton_cancelar.setBackground(new java.awt.Color(51, 51, 51));
        jButton_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/cancelar.png"))); // NOI18N
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });

        txtTotalReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalReservasActionPerformed(evt);
            }
        });

        jLabel3.setText("Apartamento.:");

        txtIdHabitacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdHabitacaoActionPerformed(evt);
            }
        });

        jLabel8.setText("IGV Comprovante.:");

        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });

        jLabel10.setText("Total a Pagar.:");

        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha Emissão.:");

        jLabel11.setText("Fecha Pagamento.:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(157, Short.MAX_VALUE)
                        .addComponent(txtIdpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_cancelar)))
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dcFechaEmissao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dcFechaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtIdHabitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHabitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtIgv, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNumComprovante, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JcomboTipoComprovante, javax.swing.GroupLayout.Alignment.LEADING, 0, 164, Short.MAX_VALUE))
                                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTotalReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtIdpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdHabitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHabitacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JcomboTipoComprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumComprovante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcFechaEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(dcFechaPagto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Novo)
                    .addComponent(jButton_Salvar)
                    .addComponent(jButton_cancelar)))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Pagamentos");

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listagem de Pagamentos"));

        TabelaListaPagto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelaListaPagto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaListaPagtoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabelaListaPagto);

        jButton_Excluir.setBackground(new java.awt.Color(51, 51, 51));
        jButton_Excluir.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/excluir.png"))); // NOI18N
        jButton_Excluir.setText("Excluir");
        jButton_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExcluirActionPerformed(evt);
            }
        });

        jButton_Sair.setBackground(new java.awt.Color(51, 51, 51));
        jButton_Sair.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Arquivos/sair.png"))); // NOI18N
        jButton_Sair.setText("Sair");
        jButton_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SairActionPerformed(evt);
            }
        });

        LabelTotalRegistros.setText("Registros ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jButton_Excluir)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Sair)
                        .addGap(0, 129, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LabelTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Excluir)
                    .addComponent(jButton_Sair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelTotalRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Listagem de Consumos"));

        TabelaListaConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelaListaConsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaListaConsumoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TabelaListaConsumo);

        LabelTotalRegistrosConsumo.setText("Registros ");

        LabelTotalConsumo.setText("jLabel13");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LabelTotalConsumo)
                        .addGap(18, 18, 18)
                        .addComponent(LabelTotalRegistrosConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTotalRegistrosConsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelTotalConsumo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdReservaActionPerformed
        // TODO add your handling code here:
        txtIdReserva.transferFocus();
    }//GEN-LAST:event_txtIdReservaActionPerformed

    private void txtNumComprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumComprovanteActionPerformed
        // TODO add your handling code here:
        txtNumComprovante.transferFocus();
    }//GEN-LAST:event_txtNumComprovanteActionPerformed

    private void JcomboTipoComprovanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcomboTipoComprovanteActionPerformed
        // TODO add your handling code here:
        JcomboTipoComprovante.transferFocus();
    }//GEN-LAST:event_JcomboTipoComprovanteActionPerformed

    private void jButton_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NovoActionPerformed
        // TODO add your handling code here:
        habilitar();
        jButton_Salvar.setText("Salvar");
        acao = "salvar";
    }//GEN-LAST:event_jButton_NovoActionPerformed

    private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalvarActionPerformed
        // TODO add your handling code here:
        if (txtIgv.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Favor preencher o campo IGV do Comprovante!");
            txtIgv.requestFocus();
            return;
        }

        if (txtTotalPagar.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Favor preencher o Total do COmprovante!");
            txtTotalPagar.requestFocus();
            return;
        }

        if (txtNumComprovante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Favor preencher o campo Número de Comprovante!");
            txtNumComprovante.requestFocus();
            return;
        }

        DadPagamento dts = new DadPagamento();
        LogPagamento func = new LogPagamento();

        dts.setIdreserva(Integer.parseInt(txtIdReserva.getText()));

        int selecionado = JcomboTipoComprovante.getSelectedIndex();
        dts.setTipocomprovante((String) JcomboTipoComprovante.getItemAt(selecionado));
        
        dts.setNumcomprovante(txtNumComprovante.getText());
        dts.setIgv(Double.parseDouble(txtIgv.getText()));
        dts.setTotalpagamento(Double.parseDouble(txtTotalPagar.getText()));
        
        Calendar cal;
        int d,m,a;
        
        cal = dcFechaPagto.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setFecha_pagamento(new Date(a, m, d));
        
        cal = dcFechaEmissao.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setFecha_emissao(new Date(a, m, d));
        
        
        if (acao.equals("salvar")) {
            if (func.inserir(dts)) {
                JOptionPane.showMessageDialog(rootPane, "Recebido o valor de R$"+txtTotalPagar.getText()+
                        " do Sr."+ txtCliente.getText() + ". Pagamento recebido com Sucesso!");
                mostrar(idReserva);
                inabilitar();
            //Desocupar
            LogHabitacao func2 = new LogHabitacao();
            DadHabitacao dts2 = new DadHabitacao();
            
            dts2.setIdhabitacao(Integer.parseInt(txtIdHabitacao.getText()));
            func2.desocupar(dts2);
            
            //Cancelar ou Pagar a Reserva
            
            LogReserva func3 = new LogReserva();
            DadReserva dts3 = new DadReserva();
            
            dts3.setIdhabitacao(Integer.parseInt(txtIdHabitacao.getText()));
            func3.pagar(dts3);
            
            }
        } else if (acao.equals("editar")) {
            dts.setIdpagamento(Integer.parseInt(txtIdpagamento.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "O Pagamento do sr."+txtCliente.getText()+
                        " foi editado com sucesso!");
                mostrar(idReserva);
                inabilitar();
            }
        }
    }//GEN-LAST:event_jButton_SalvarActionPerformed

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        // TODO add your handling code here
        //this.dispose();
        this.inabilitar();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void TabelaListaPagtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaListaPagtoMouseClicked
        // TODO add your handling code here:
        jButton_Salvar.setText("Editar");
        habilitar();
        jButton_Excluir.setEnabled(true);
        acao = "editar";

        int fila = TabelaListaPagto.rowAtPoint(evt.getPoint());

        txtIdpagamento.setText(TabelaListaPagto.getValueAt(fila, 0).toString());
        //txtIdReserva.setText(TabelaListaPagto.getValueAt(fila, 1).toString());

        JcomboTipoComprovante.setSelectedItem(TabelaListaPagto.getValueAt(fila, 2).toString());
        txtNumComprovante.setText(TabelaListaPagto.getValueAt(fila, 3).toString());
        txtIgv.setText(TabelaListaPagto.getValueAt(fila, 4).toString());
        txtTotalPagar.setText(TabelaListaPagto.getValueAt(fila, 5).toString());
        
        dcFechaEmissao.setDate(Date.valueOf(TabelaListaPagto.getValueAt(fila, 6).toString()));
        dcFechaPagto.setDate(Date.valueOf(TabelaListaPagto.getValueAt(fila, 7).toString()));
        
    }//GEN-LAST:event_TabelaListaPagtoMouseClicked

    private void jButton_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExcluirActionPerformed
        // TODO add your handling code here:
        if (!txtIdpagamento.getText().equals("")) {
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja excluir o Registro de Pagamento?", "Confirmar", 2);

            if (confirmacao == 0) {
                LogPagamento func = new LogPagamento();
                DadPagamento dts = new DadPagamento();

                dts.setIdpagamento(Integer.parseInt(txtIdpagamento.getText()));
                func.excluir(dts);
                mostrar(idReserva);
                inabilitar();
            }
        }
    }//GEN-LAST:event_jButton_ExcluirActionPerformed

    private void jButton_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton_SairActionPerformed

    private void txtTotalReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalReservasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalReservasActionPerformed

    private void txtIdHabitacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdHabitacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdHabitacaoActionPerformed

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvActionPerformed

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagarActionPerformed

    private void TabelaListaConsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaListaConsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelaListaConsumoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JfrmPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrmPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrmPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrmPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrmPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JcomboTipoComprovante;
    private javax.swing.JLabel LabelTotalConsumo;
    private javax.swing.JLabel LabelTotalRegistros;
    private javax.swing.JLabel LabelTotalRegistrosConsumo;
    private javax.swing.JTable TabelaListaConsumo;
    private javax.swing.JTable TabelaListaPagto;
    private com.toedter.calendar.JDateChooser dcFechaEmissao;
    private com.toedter.calendar.JDateChooser dcFechaPagto;
    private javax.swing.JButton jButton_Excluir;
    private javax.swing.JButton jButton_Novo;
    private javax.swing.JButton jButton_Sair;
    private javax.swing.JButton jButton_Salvar;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtHabitacao;
    private javax.swing.JTextField txtIdHabitacao;
    private javax.swing.JTextField txtIdReserva;
    private javax.swing.JTextField txtIdpagamento;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNumComprovante;
    private javax.swing.JTextField txtTotalPagar;
    private javax.swing.JTextField txtTotalReservas;
    // End of variables declaration//GEN-END:variables
}
