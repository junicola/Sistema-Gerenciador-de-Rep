/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.MainController;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.User;

/**
 *
 * @author JuliaNicolaGualeve
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        loadTableUser();
        loadTableBill();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblBill = new javax.swing.JLabel();
        lblAct = new javax.swing.JLabel();
        lblExit = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        painelCard = new javax.swing.JPanel();
        jPanelUser = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        btnRemoveUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        jPanelBill = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBill = new javax.swing.JTable();
        btnAddBill = new javax.swing.JButton();
        btnRemoveBill = new javax.swing.JButton();
        btnEditBill = new javax.swing.JButton();
        jPanelAct = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbAct = new javax.swing.JTable();
        btnAddAct = new javax.swing.JButton();
        btnRemoveAct = new javax.swing.JButton();
        btnEditAct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(560, 360));
        setSize(new java.awt.Dimension(560, 360));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUser.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblUser.setForeground(new java.awt.Color(204, 204, 204));
        lblUser.setText("Usuários");
        lblUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserMouseClicked(evt);
            }
        });
        jPanel5.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 12, -1, -1));

        lblBill.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblBill.setForeground(new java.awt.Color(204, 204, 204));
        lblBill.setText("Contas");
        lblBill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBillMouseClicked(evt);
            }
        });
        jPanel5.add(lblBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 12, -1, -1));

        lblAct.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblAct.setForeground(new java.awt.Color(204, 204, 204));
        lblAct.setText("Atividades");
        lblAct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActMouseClicked(evt);
            }
        });
        jPanel5.add(lblAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 12, -1, -1));

        lblExit.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        lblExit.setForeground(new java.awt.Color(204, 204, 204));
        lblExit.setText("Sair");
        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
        });
        jPanel5.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 14, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 6, 24, 29));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 7, 33, 28));

        painelCard.setBackground(new java.awt.Color(204, 204, 204));
        painelCard.setLayout(new java.awt.CardLayout());

        jPanelUser.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Usuários");

        tbUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Email", "Nome", "RG", "Telefone"
            }
        ));
        tbUser.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbUser);

        btnAddUser.setBackground(new java.awt.Color(153, 153, 153));
        btnAddUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAddUser.setForeground(new java.awt.Color(51, 51, 51));
        btnAddUser.setText("Adicionar");
        btnAddUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        btnRemoveUser.setBackground(new java.awt.Color(153, 153, 153));
        btnRemoveUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRemoveUser.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoveUser.setText("Excluir");
        btnRemoveUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveUserActionPerformed(evt);
            }
        });

        btnEditUser.setBackground(new java.awt.Color(153, 153, 153));
        btnEditUser.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEditUser.setForeground(new java.awt.Color(51, 51, 51));
        btnEditUser.setText("Alterar");
        btnEditUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUserLayout = new javax.swing.GroupLayout(jPanelUser);
        jPanelUser.setLayout(jPanelUserLayout);
        jPanelUserLayout.setHorizontalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUserLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUserLayout.createSequentialGroup()
                        .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveUser, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        jPanelUserLayout.setVerticalGroup(
            jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUserLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanelUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUser)
                    .addComponent(btnRemoveUser)
                    .addComponent(btnEditUser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        painelCard.add(jPanelUser, "userCard");

        jPanelBill.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Contas");

        tbBill.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Valor", "Vencimento", "Responsável", "Status"
            }
        ));
        jScrollPane2.setViewportView(tbBill);

        btnAddBill.setBackground(new java.awt.Color(153, 153, 153));
        btnAddBill.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAddBill.setForeground(new java.awt.Color(51, 51, 51));
        btnAddBill.setText("Adicionar");
        btnAddBill.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBillActionPerformed(evt);
            }
        });

        btnRemoveBill.setBackground(new java.awt.Color(153, 153, 153));
        btnRemoveBill.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRemoveBill.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoveBill.setText("Excluir");
        btnRemoveBill.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRemoveBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveBillActionPerformed(evt);
            }
        });

        btnEditBill.setBackground(new java.awt.Color(153, 153, 153));
        btnEditBill.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEditBill.setForeground(new java.awt.Color(51, 51, 51));
        btnEditBill.setText("Alterar");
        btnEditBill.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBillLayout = new javax.swing.GroupLayout(jPanelBill);
        jPanelBill.setLayout(jPanelBillLayout);
        jPanelBillLayout.setHorizontalGroup(
            jPanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBillLayout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBillLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBillLayout.createSequentialGroup()
                        .addComponent(btnAddBill, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnRemoveBill, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditBill, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        jPanelBillLayout.setVerticalGroup(
            jPanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBillLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanelBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBill)
                    .addComponent(btnRemoveBill)
                    .addComponent(btnEditBill))
                .addGap(39, 39, 39))
        );

        painelCard.add(jPanelBill, "billCard");

        jPanelAct.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Atividades");

        tbAct.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tbAct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Inicio", "Fim", "Responsável", "Status"
            }
        ));
        jScrollPane3.setViewportView(tbAct);

        btnAddAct.setBackground(new java.awt.Color(153, 153, 153));
        btnAddAct.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnAddAct.setForeground(new java.awt.Color(51, 51, 51));
        btnAddAct.setText("Adicionar");
        btnAddAct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRemoveAct.setBackground(new java.awt.Color(153, 153, 153));
        btnRemoveAct.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRemoveAct.setForeground(new java.awt.Color(51, 51, 51));
        btnRemoveAct.setText("Excluir");
        btnRemoveAct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnEditAct.setBackground(new java.awt.Color(153, 153, 153));
        btnEditAct.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnEditAct.setForeground(new java.awt.Color(51, 51, 51));
        btnEditAct.setText("Alterar");
        btnEditAct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanelActLayout = new javax.swing.GroupLayout(jPanelAct);
        jPanelAct.setLayout(jPanelActLayout);
        jPanelActLayout.setHorizontalGroup(
            jPanelActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel7)
                .addContainerGap(245, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelActLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelActLayout.createSequentialGroup()
                        .addComponent(btnAddAct, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveAct, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditAct, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanelActLayout.setVerticalGroup(
            jPanelActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelActLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanelActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAct)
                    .addComponent(btnRemoveAct)
                    .addComponent(btnEditAct))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        painelCard.add(jPanelAct, "actCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(painelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 45, Short.MAX_VALUE)
                    .addComponent(painelCard, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserMouseClicked
        CardLayout c1 = (CardLayout) (painelCard.getLayout());
        c1.show(painelCard, "userCard");

    }//GEN-LAST:event_lblUserMouseClicked

    private void lblBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBillMouseClicked
        CardLayout c1 = (CardLayout) (painelCard.getLayout());
        c1.show(painelCard, "billCard");
    }//GEN-LAST:event_lblBillMouseClicked

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblActMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActMouseClicked
        CardLayout c1 = (CardLayout) (painelCard.getLayout());
        c1.show(painelCard, "actCard");
    }//GEN-LAST:event_lblActMouseClicked
    //User Panel
    public void loadTableUser() {
        DefaultTableModel dtb = (DefaultTableModel) tbUser.getModel();
        dtb.setNumRows(0);
        MainController main = new MainController();
        ArrayList<User> dados = main.getDataUsers();

        for (User u : dados) {
            dtb.addRow(new Object[]{u.getEmail(), u.getName(), u.getRg(), u.getPhone()});
        }
    }

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        AddUser add = new AddUser(this);
        add.setVisible(true);
        loadTableUser();
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveUserActionPerformed
        MainController main = new MainController();
        int row = tbUser.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para remover", "Erro ao remover Usuario", JOptionPane.ERROR_MESSAGE);
        } else {
            main.removeUser(tbUser.getValueAt(row, 0).toString());
            JOptionPane.showMessageDialog(null, "Usuario removido com sucesso", "Remover Usuario", JOptionPane.INFORMATION_MESSAGE);
            loadTableUser();
        }
    }//GEN-LAST:event_btnRemoveUserActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        MainController main = new MainController();
        int row = tbUser.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar", "Erro ao editar Usuario", JOptionPane.ERROR_MESSAGE);
        } else {
            main.editUser(tbUser.getValueAt(row, 0).toString(), this);
        }
    }//GEN-LAST:event_btnEditUserActionPerformed

    //Bill panel
    public void loadTableBill() {
        DefaultTableModel dtb = (DefaultTableModel) tbBill.getModel();
        dtb.setNumRows(0);
        MainController main = new MainController();
        ArrayList<Bill> dados = main.getDataBills();

        for (Bill b : dados) {
            dtb.addRow(new Object[]{b.getName(), b.getValue(), b.getExpDate(), b.getUserName(), b.getStatus()});
        }
    }

    private void btnAddBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBillActionPerformed
        AddBill add = new AddBill(this);
        add.setVisible(true);
        loadTableBill();
    }//GEN-LAST:event_btnAddBillActionPerformed

    private void btnRemoveBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveBillActionPerformed
        MainController main = new MainController();
        int row = tbBill.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para remover", "Erro ao remover Usuario", JOptionPane.ERROR_MESSAGE);
        } else {
            main.removeBill(tbBill.getValueAt(row, 0).toString());
            JOptionPane.showMessageDialog(null, "Conta removida com sucesso", "Remover Conta", JOptionPane.INFORMATION_MESSAGE);
            loadTableBill();
        }
    }//GEN-LAST:event_btnRemoveBillActionPerformed

    private void btnEditBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBillActionPerformed
        MainController main = new MainController();
        int row = tbBill.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para editar", "Erro ao editar Usuario", JOptionPane.ERROR_MESSAGE);
        } else {
            main.editBill(tbBill.getValueAt(row, 0).toString(), this);
        }
    }//GEN-LAST:event_btnEditBillActionPerformed

    
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAct;
    private javax.swing.JButton btnAddBill;
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnEditAct;
    private javax.swing.JButton btnEditBill;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnRemoveAct;
    private javax.swing.JButton btnRemoveBill;
    private javax.swing.JButton btnRemoveUser;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelAct;
    private javax.swing.JPanel jPanelBill;
    private javax.swing.JPanel jPanelUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAct;
    private javax.swing.JLabel lblBill;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel painelCard;
    private javax.swing.JTable tbAct;
    private javax.swing.JTable tbBill;
    private javax.swing.JTable tbUser;
    // End of variables declaration//GEN-END:variables
}
