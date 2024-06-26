package com.mycompany.app.pdv.views;

import com.mycompany.app.pdv.entities.Cliente;
import com.mycompany.app.pdv.entities.ItemVenda;
import com.mycompany.app.pdv.entities.Venda;
import com.mycompany.app.pdv.exceptions.ValidationException;
import com.mycompany.app.pdv.reports.ReportUtils;
import com.mycompany.app.pdv.tablemodels.ItemVendaTableModel;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;


public class JframeVenda extends javax.swing.JFrame {

    
    private List<ItemVenda> listaItemVenda = new ArrayList<>();
    private Cliente cliente;
    private Cliente vendedor;
    private Venda venda;
    private boolean cpfNaNota = false;
    private double vlTotal;

    public JframeVenda() {   
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Menu PDV");
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableItens = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelSubtotal = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btFinalizar = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jFieldCpfCnpj = new javax.swing.JTextField();
        jFieldCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btSelecionarCliente = new javax.swing.JButton();
        jCheckBoxCpfNota = new javax.swing.JCheckBox();
        btAddProdutos = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jFieldVendedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btSelecionarVendedor = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.BorderLayout(0, 10));

        tableItens.setBackground(new java.awt.Color(204, 204, 204));
        tableItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Valor Unit.", "Qtd.", "Desconto (%)", "Valor total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItens.setGridColor(new java.awt.Color(51, 51, 51));
        tableItens.setMinimumSize(new java.awt.Dimension(200, 200));
        tableItens.setRequestFocusEnabled(false);
        tableItens.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tableItens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableItens);
        if (tableItens.getColumnModel().getColumnCount() > 0) {
            tableItens.getColumnModel().getColumn(0).setResizable(false);
            tableItens.getColumnModel().getColumn(1).setResizable(false);
            tableItens.getColumnModel().getColumn(2).setResizable(false);
            tableItens.getColumnModel().getColumn(3).setResizable(false);
            tableItens.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel10.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.setAlignmentX(0.0F);
        jPanel8.setAlignmentY(0.0F);
        jPanel8.setPreferredSize(new java.awt.Dimension(602, 50));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("SUBTOTAL");

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("R$");

        jLabelSubtotal.setBackground(new java.awt.Color(204, 204, 204));
        jLabelSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSubtotal.setText("0,00");
        jLabelSubtotal.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 841, Short.MAX_VALUE)
                .addComponent(jLabelSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
            .addComponent(jLabelSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jPanel7.setForeground(new java.awt.Color(60, 63, 65));
        jPanel7.setToolTipText("");

        btNovo.setBackground(new java.awt.Color(0, 102, 51));
        btNovo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Novo.png"))); // NOI18N
        btNovo.setText("Novo (F9)");
        btNovo.setActionCommand("Novo");
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btNovo.setIconTextGap(5);
        btNovo.setPreferredSize(new java.awt.Dimension(265, 75));
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel9.add(btNovo);

        btFinalizar.setBackground(new java.awt.Color(0, 90, 153));
        btFinalizar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Checked.png"))); // NOI18N
        btFinalizar.setText("Finalizar (F8)");
        btFinalizar.setActionCommand("Finalizar");
        btFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btFinalizar.setIconTextGap(5);
        btFinalizar.setPreferredSize(new java.awt.Dimension(265, 75));
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });
        jPanel9.add(btFinalizar);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(350, 116));

        jLabel2.setText("CPF/CNPJ");

        jFieldCpfCnpj.setEditable(false);
        jFieldCpfCnpj.setEnabled(false);

        jFieldCliente.setEditable(false);
        jFieldCliente.setMinimumSize(new java.awt.Dimension(64, 15));
        jFieldCliente.setPreferredSize(new java.awt.Dimension(64, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Cliente");
        jLabel1.setPreferredSize(new java.awt.Dimension(42, 15));

        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jFieldCpfCnpj, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jFieldCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFieldCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFieldCpfCnpj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFieldCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel13.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 340, 180));

        btSelecionarCliente.setBackground(new java.awt.Color(0, 70, 70));
        btSelecionarCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSelecionarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Clientes.png"))); // NOI18N
        btSelecionarCliente.setText("Selecionar Cliente");
        btSelecionarCliente.setToolTipText("");
        btSelecionarCliente.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btSelecionarCliente.setIconTextGap(5);
        btSelecionarCliente.setMargin(new java.awt.Insets(20, 14, 20, 14));
        btSelecionarCliente.setPreferredSize(new java.awt.Dimension(166, 35));
        btSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarClienteActionPerformed(evt);
            }
        });
        jPanel13.add(btSelecionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 35, 190, -1));
        btSelecionarCliente.getAccessibleContext().setAccessibleName("Selecionar cliente");

        jCheckBoxCpfNota.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jCheckBoxCpfNota.setText("CPF na nota");
        jCheckBoxCpfNota.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCheckBoxCpfNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCpfNotaActionPerformed(evt);
            }
        });
        jPanel13.add(jCheckBoxCpfNota, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        btAddProdutos.setBackground(new java.awt.Color(0, 70, 70));
        btAddProdutos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btAddProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/adicionar-sacola-de-compras (1).png"))); // NOI18N
        btAddProdutos.setText("Adicionar Produtos");
        btAddProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btAddProdutos.setIconTextGap(15);
        btAddProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddProdutosActionPerformed(evt);
            }
        });

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane3.setPreferredSize(new java.awt.Dimension(350, 116));

        jFieldVendedor.setEditable(false);
        jFieldVendedor.setMinimumSize(new java.awt.Dimension(64, 15));
        jFieldVendedor.setPreferredSize(new java.awt.Dimension(64, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Vendedor");
        jLabel4.setPreferredSize(new java.awt.Dimension(42, 15));

        jLayeredPane3.setLayer(jFieldVendedor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFieldVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFieldVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel14.add(jLayeredPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 340, 80));

        btSelecionarVendedor.setBackground(new java.awt.Color(0, 70, 70));
        btSelecionarVendedor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSelecionarVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Clientes.png"))); // NOI18N
        btSelecionarVendedor.setText("Selecionar Vendedor");
        btSelecionarVendedor.setToolTipText("");
        btSelecionarVendedor.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btSelecionarVendedor.setIconTextGap(5);
        btSelecionarVendedor.setMargin(new java.awt.Insets(20, 14, 20, 14));
        btSelecionarVendedor.setPreferredSize(new java.awt.Dimension(166, 35));
        btSelecionarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarVendedorActionPerformed(evt);
            }
        });
        jPanel14.add(btSelecionarVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 35, 190, -1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btAddProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(btAddProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.add(jPanel7, java.awt.BorderLayout.LINE_END);

        jPanel1.add(jPanel10, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxCpfNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCpfNotaActionPerformed
        boolean isChecked = jCheckBoxCpfNota.isSelected();
        
        jFieldCpfCnpj.setEnabled(isChecked);
        this.cpfNaNota = isChecked;
    }//GEN-LAST:event_jCheckBoxCpfNotaActionPerformed

    private void btSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarClienteActionPerformed
        JFrameConsultaCliente frameClientes = new JFrameConsultaCliente(this, "C");
        frameClientes.setResizable(false);
        frameClientes.setLocationRelativeTo(null);
        frameClientes.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removerFocoPricipal(frameClientes);
        frameClientes.setVisible(true);
    }//GEN-LAST:event_btSelecionarClienteActionPerformed

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        try {
            if(listaItemVenda.size() == 0){
                throw new ValidationException("Por favor selecione algum produto");
            }
            if(cliente == null){
                throw new ValidationException("Por favor selecione algum cliente");
            }
            if(vendedor == null){
                throw new ValidationException("Por favor selecione algum vendedor");
            }
            
            int qtdItens = 0;
            for(ItemVenda item : this.listaItemVenda) {
                qtdItens += item.getQuantidade();
            }
            
            this.venda = new Venda();
            
            this.venda.setCliente(cliente);
            this.venda.setVendedor(vendedor);
            this.venda.setItemVenda(listaItemVenda);
            this.venda.setQuantidadeItens(qtdItens);
            this.venda.setCpfNota(this.cpfNaNota ? this.jFieldCpfCnpj.getText() : "Não");
            this.venda.setValorTotal(vlTotal);
            
            
            JFrameFinalizarVenda frame = new JFrameFinalizarVenda(this.venda, this);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            removerFocoPricipal(frame);
            frame.setVisible(true);
        } 
        catch(ValidationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Venda incompleta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        limparVenda();
    }//GEN-LAST:event_btNovoActionPerformed
    
    public void limparVenda() {
        this.cliente = null;
        this.vendedor = null;
        setCliente(this.cliente);
        setVendedor(this.vendedor);
        
        this.venda = null;
        this.listaItemVenda = new ArrayList<>();
        
        ItemVendaTableModel model = new ItemVendaTableModel(this.listaItemVenda);
        tableItens.setModel(model);
        
        exibirValorTotal();
    }
    
    private void btAddProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddProdutosActionPerformed
        JFrameConsultaProduto frame = new JFrameConsultaProduto(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removerFocoPricipal(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_btAddProdutosActionPerformed

    private void btSelecionarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarVendedorActionPerformed
        JFrameConsultaCliente frameClientes = new JFrameConsultaCliente(this, "V");
        frameClientes.setResizable(false);
        frameClientes.setLocationRelativeTo(null);
        frameClientes.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        removerFocoPricipal(frameClientes);
        frameClientes.setVisible(true);
    }//GEN-LAST:event_btSelecionarVendedorActionPerformed

    private void removerFocoPricipal(JFrame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                setEnabled(false); //desabilitar janela de venda
            }

            @Override
            public void windowClosed(WindowEvent e) {
                setEnabled(true); //habilitar janela de venda
                requestFocus(); //aplicar foco novamente
            }
        });
    }
    
    public void addNovoItemToTable(ItemVenda item) {
        this.listaItemVenda.add(item);
        
        ItemVendaTableModel model = new ItemVendaTableModel(this.listaItemVenda);
        tableItens.setModel(model);
        
        exibirValorTotal();
    }
    
    private void exibirValorTotal() {
        double total = 0;
        for(ItemVenda item : listaItemVenda) {
            total += item.getValorTotal();
        }
        this.vlTotal = total;
        
        jLabelSubtotal.setText(Double.toString(total));
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        jFieldCliente.setText(cliente == null ? "" : cliente.getNome());
        jFieldCpfCnpj.setText(cliente == null ? "" : cliente.getCpf());
    }
    
    public void setVendedor(Cliente vendedor) {
        this.vendedor = vendedor;
        jFieldVendedor.setText(vendedor == null ? "" : vendedor.getNome());
    }
    
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JframeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeVenda().setVisible(true);
                new JframeVenda().setBackground(Color.DARK_GRAY);           
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddProdutos;
    private javax.swing.JButton btFinalizar;
    public javax.swing.JButton btNovo;
    private javax.swing.JButton btSelecionarCliente;
    private javax.swing.JButton btSelecionarVendedor;
    private javax.swing.JCheckBox jCheckBoxCpfNota;
    private javax.swing.JTextField jFieldCliente;
    private javax.swing.JTextField jFieldCpfCnpj;
    private javax.swing.JTextField jFieldVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelSubtotal;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableItens;
    // End of variables declaration//GEN-END:variables
}
