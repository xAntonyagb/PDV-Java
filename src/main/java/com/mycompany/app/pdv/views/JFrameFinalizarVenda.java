package com.mycompany.app.pdv.views;

import com.mycompany.app.pdv.entities.ItemVenda;
import com.mycompany.app.pdv.entities.Venda;
import com.mycompany.app.pdv.exceptions.ValidationException;
import com.mycompany.app.pdv.reports.ReportUtils;
import com.mycompany.app.pdv.services.VendaService;
import com.mycompany.app.pdv.util.FieldFormatterUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Antony
 */
public class JFrameFinalizarVenda extends javax.swing.JFrame {
    
    private Venda venda;
    private JframeVenda frameVenda;

    public JFrameFinalizarVenda(Venda venda, JframeVenda frameVenda) {
        this.venda = venda;
        this.frameVenda = frameVenda;
        initComponents();
        
        jFieldSubTotal.setText(Double.toString(venda.getValorTotal()));
        jFieldVlTotal.setText(Double.toString(venda.getValorTotal()));
        jFieldDescontoFinal.setText("0");
        atualizarCampos();
        
        
        
        jFieldDescontoFinal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                atualizarCampos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) { }

            @Override
            public void changedUpdate(DocumentEvent e) {
                atualizarCampos();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btFinalizarVenda = new javax.swing.JButton();
        btCancelarVenda = new javax.swing.JButton();
        jComboBoxMetodoPgmt = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFieldVlTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFieldSubTotal = new javax.swing.JTextField();
        jFieldDescontoTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFieldDescontoFinal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btFinalizarVenda.setBackground(new java.awt.Color(0, 102, 0));
        btFinalizarVenda.setText("Finalizar");
        btFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarVendaActionPerformed(evt);
            }
        });

        btCancelarVenda.setBackground(new java.awt.Color(153, 0, 0));
        btCancelarVenda.setText("Cancelar");
        btCancelarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarVendaActionPerformed(evt);
            }
        });

        jComboBoxMetodoPgmt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito", "Dinheiro" }));

        jLabel1.setText("Método de pagamento:");

        jLabel2.setText("Valor Total: R$");

        jFieldVlTotal.setEnabled(false);

        jLabel3.setText("Descontos: R$");

        jLabel4.setText("SubTotal:");

        jLabel5.setText("-------------------------------------");

        jFieldSubTotal.setEnabled(false);

        jFieldDescontoTotal.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Finalizar Venda");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setText("Desconto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(133, 133, 133)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFieldVlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jFieldDescontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMetodoPgmt, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFieldDescontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxMetodoPgmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFieldDescontoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFieldDescontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(jFieldVlTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFinalizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarVendaActionPerformed
        String descontoText = FieldFormatterUtil.ajustaNumberInput(jFieldDescontoFinal.getText());
        try{
            double descontoFinal = Double.parseDouble(descontoText);
            if (descontoFinal > 100) {
                throw new ValidationException("O máximo de desconto possível é 100%");
            }
            
            
            this.venda.setValorTotal(Double.parseDouble(jFieldVlTotal.getText()));
            this.venda.setValorDesconto(Double.parseDouble(jFieldDescontoTotal.getText()));
            Object selectedItem = jComboBoxMetodoPgmt.getSelectedItem();
            this.venda.setMetodoPagamento(selectedItem != null ? selectedItem.toString() : null);
            
            for(ItemVenda item : this.venda.getItemVenda()) {
                item.setVenda(this.venda);
            }
            
            VendaService vendaService = new VendaService();
            Venda retorno = vendaService.insert(this.venda);
            
            JOptionPane.showMessageDialog(null, "Venda feita com sucesso: "+ retorno.getId(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.frameVenda.limparVenda();
            
            try {
                ReportUtils.relatorioVenda(retorno);
            } catch (JRException ex) {
                Logger.getLogger(JframeVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dispose();
        }
        catch(ValidationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Input inválido", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception ex) {
            System.out.println("Erro ao inserir venda");
        }
    }//GEN-LAST:event_btFinalizarVendaActionPerformed

    private void btCancelarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarVendaActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarVendaActionPerformed

    private void atualizarCampos() {
    String descontoText = FieldFormatterUtil.ajustaNumberInput(jFieldDescontoFinal.getText());
    String subtotalText = FieldFormatterUtil.ajustaNumberInput(jFieldSubTotal.getText());

    try {
        double vlTotalVenda = this.venda.getValorTotal();
        double descontoFinal = Double.parseDouble(descontoText);
        double subtotal = Double.parseDouble(subtotalText);
        
        subtotal = Math.round(vlTotalVenda - (vlTotalVenda * (descontoFinal / 100)));
        descontoFinal = Math.round(100 - ((subtotal * 100) / vlTotalVenda));
        
        if (descontoFinal > 100) {
            throw new ValidationException("O máximo de desconto possível é 100%");
        }
        
        double vlDescontoTotal = vlTotalVenda - subtotal;
        
        double vlDescontoProdutos = 0;
        for(ItemVenda item : this.venda.getItemVenda()) {
            vlDescontoProdutos += ((item.getDescontoProduto() / 100) * item.getValorUnitario()) * item.getQuantidade();
        }
        
        vlDescontoTotal += vlDescontoProdutos;
        
        jFieldDescontoTotal.setText(Double.toString(vlDescontoTotal));
        jFieldVlTotal.setText(Double.toString(subtotal));
    } 
    catch (NumberFormatException ex) {
        System.out.println("Erro ao transformar números");
    }
    catch (ValidationException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Input inválido", JOptionPane.ERROR_MESSAGE);
    }
}

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelarVenda;
    private javax.swing.JButton btFinalizarVenda;
    private javax.swing.JComboBox<String> jComboBoxMetodoPgmt;
    private javax.swing.JTextField jFieldDescontoFinal;
    private javax.swing.JTextField jFieldDescontoTotal;
    private javax.swing.JTextField jFieldSubTotal;
    private javax.swing.JTextField jFieldVlTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
