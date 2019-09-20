/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import javax.swing.event.TableModelListener;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

/**
 *
 * @author Thiago
 */
public class SistemaCadastro extends javax.swing.JFrame {

    //Teste Cliente
    Cliente moises = new Cliente("moises","10393639460", "moises@live.com", 12369, 10);
    Cliente oie = new Cliente("Caveira","12345678900","renokinNHÁ@live.com",999,10);
    SistemaClientes sis = new SistemaClientes();
    DefaultTableModel tblDados;
    JFrame telaNovoCli = new NovoCliente();

    /**
     * Creates new form NewJFrame
     */
    public SistemaCadastro() {
        //Teste Cliente 2
        nimbusDesing();
        sis.novoCliente(moises);
        sis.novoCliente(oie);
        initComponents();
        setPreferredSize(new Dimension(1024,768));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        pnCpf = new javax.swing.JPanel();
        lblCpf = new javax.swing.JLabel();
        txfCPf = new javax.swing.JTextField();
        btnCpf = new javax.swing.JButton();
        pnBotoes = new javax.swing.JPanel();
        btnNovoCli = new javax.swing.JButton();
        btnEditCli = new javax.swing.JButton();
        btnExcluiCli = new javax.swing.JButton();
        pnlListaCli = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCli = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Clientes");

        pnlMenu.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        pnCpf.setLayout(new javax.swing.BoxLayout(pnCpf, javax.swing.BoxLayout.LINE_AXIS));

        lblCpf.setLabelFor(txfCPf);
        lblCpf.setText("CPF:");
        pnCpf.add(lblCpf);
        pnCpf.add(txfCPf);

        btnCpf.setText("Procurar");

        //Função do Botão de Procurar Cliente
        btnCpf.addActionListener(actionEvent -> {
            try {
                String cpf = txfCPf.getText();
                if(cpf.isEmpty()){
                    tblCli.setModel(tabelaDados());
                }else {
                    if (!this.validarCpf(cpf)) {
                        throw new Exception("CPF Inválido!");
                    } else {
                        Cliente cli = this.sis.procurarCliente(cpf);
                        if (cli == null) {
                            throw new Exception("Não existe ninguem com esse CPF!");
                        } else {
                            tblDados.setNumRows(0);
                            tblDados.addRow(cli.arrayCliente());
                            tblCli.setModel(tblDados);
                        }
                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,e.getMessage(),"Erro!", JOptionPane.ERROR_MESSAGE);
            }
        });

        pnCpf.add(btnCpf);

        pnBotoes.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btnNovoCli.setText("Novo Cliente");
        btnNovoCli.addActionListener(actionEvent -> {
            if(telaNovoCli.isVisible()){
                JOptionPane.showMessageDialog(this,"Finalize o cadastro anterior!","Erro!", JOptionPane.ERROR_MESSAGE);
            }else{
                telaNovoCli.setVisible(true);
            }
        });

        pnBotoes.add(btnNovoCli);

        btnEditCli.setText("Editar Cliente");
        pnBotoes.add(btnEditCli);

        btnExcluiCli.setText("Excluir Cliente");

        //Função do Botão de Remover Cliente
        btnExcluiCli.addActionListener(actionEvent -> {
            if(tblCli.getSelectedRow() == -1){
                JOptionPane.showMessageDialog(this,"Cliente não selecionado!","Erro!", JOptionPane.ERROR_MESSAGE);
            }else{
                int excluir = JOptionPane.showConfirmDialog(this, "Você tem certeza que quer excluir esse cliente?","Excluir Cliente", JOptionPane.YES_NO_OPTION);
                if(excluir == 0){
                    sis.remove(tblCli.getSelectedRow());
                    JOptionPane.showMessageDialog(this, "Cliente Excluido Com Sucesso!");
                    tblCli.setModel(tabelaDados());
                }

            }
        });

        pnBotoes.add(btnExcluiCli);

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
                pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addComponent(pnCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlMenuLayout.setVerticalGroup(
                pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pnBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pnCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pnlListaCli.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        pnlListaCli.setLayout(new javax.swing.BoxLayout(pnlListaCli, javax.swing.BoxLayout.LINE_AXIS));

        tblCli.setModel(tabelaDados());

        jScrollPane1.setViewportView(tblCli);
        if (tblCli.getColumnModel().getColumnCount() > 0) {
            tblCli.getColumnModel().getColumn(0).setResizable(false);
            tblCli.getColumnModel().getColumn(1).setResizable(false);
            tblCli.getColumnModel().getColumn(2).setResizable(false);
            tblCli.getColumnModel().getColumn(3).setResizable(false);
            tblCli.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlListaCli.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pnlListaCli, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                                        .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlListaCli, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    //Validação do CPF
    private boolean validarCpf(String cpf){
        if(!cpf.matches("[0-9]{11}")){
            return false;
        }else {
            return true;
        }
    }

    //Gera a Tabela de Dados Padrão
    private DefaultTableModel tabelaDados(){
        this.tblDados = new DefaultTableModel(
                sis.tabelarLista(), //Teste na tabela.
                new String [] {
                        "Nome", "CPF", "E-mail", "Telefone", "Saldo"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        return tblDados;
    }

    //Desing do Nimbus no Swing
    public static void nimbusDesing(){
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
            java.util.logging.Logger.getLogger(SistemaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify
    private javax.swing.JButton btnCpf;
    private javax.swing.JButton btnEditCli;
    private javax.swing.JButton btnExcluiCli;
    private javax.swing.JButton btnNovoCli;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnCpf;
    private javax.swing.JPanel pnlListaCli;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JTable tblCli;
    private javax.swing.JTextField txfCPf;
    // End of variables declaration                   
}
