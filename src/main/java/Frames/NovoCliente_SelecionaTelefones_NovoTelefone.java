/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

//import Classes.Configurar;
import Classes.TelefoneCliente;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.text.ParseException;

/**
 *
 * @author Douglas Horvath (douglashorvath@icloud.com)
 */
public class NovoCliente_SelecionaTelefones_NovoTelefone extends javax.swing.JDialog {
    
    private TelefoneCliente telefone;
    /**
     * Creates new form NovoPaciente_SelecionaTelefones_NovoTelefone
     * @param parent Janela pai
     * @param modal TRUE para modal e FALSE para não modal
     */
    public NovoCliente_SelecionaTelefones_NovoTelefone(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        URL url = this.getClass().getResource("/Imagens/windowThumb.png");
        java.awt.Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }
    
    public void setFixo() throws ParseException
    {
        lbTitulo.setText("Telefone Fixo");
        tfTelefone.setFormatterFactory(null);
        javax.swing.text.MaskFormatter format = new javax.swing.text.MaskFormatter("(##) ####-####");
        format.setPlaceholderCharacter('0');  
        tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(format));
        tfTelefone.setValue(null);
    }
    
    public void setCelular() throws ParseException
    {
        lbTitulo.setText("Telefone Celular");
        tfTelefone.setFormatterFactory(null);
        javax.swing.text.MaskFormatter format = new javax.swing.text.MaskFormatter("(##) #####-####");
        format.setPlaceholderCharacter('0');  
        tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(format));
        tfTelefone.setValue(null);
    }

    public TelefoneCliente getTelefone() {
        return telefone;
    }

    public void setTelefone(TelefoneCliente telefone) {
        this.telefone = telefone;
    }


    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFundo = new javax.swing.JPanel();
        lbTitulo = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JFormattedTextField();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelFundo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitulo.setText("Telefone Fixo");

        try {
            tfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTelefone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTelefoneKeyReleased(evt);
            }
        });

        btSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/saveMicroIcon.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelMicroIcon.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFundoLayout = new javax.swing.GroupLayout(panelFundo);
        panelFundo.setLayout(panelFundoLayout);
        panelFundoLayout.setHorizontalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFundoLayout.createSequentialGroup()
                        .addComponent(lbTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelFundoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelFundoLayout.setVerticalGroup(
            panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(270, 169));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.telefone = null;
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        String tel = tfTelefone.getText().replace(" ", "").replace("-", "").replace("(", "").replace(")", "");
        if(tel.length() >=10)
        {
            this.telefone = new TelefoneCliente();
            this.telefone.setTelefone(tel);
            if(lbTitulo.getText().equals("Telefone Fixo"))
            {
                this.telefone.setTipo("FIXO");
            }
            if(lbTitulo.getText().equals("Telefone Celular"))
            {
                this.telefone.setTipo("MOVEL");
            }
        }
        else
        {
            this.telefone = null;
        }
        this.dispose();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tfTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefoneKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            btSalvar.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            btCancelar.doClick();
        }
    }//GEN-LAST:event_tfTelefoneKeyReleased

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
            java.util.logging.Logger.getLogger(NovoCliente_SelecionaTelefones_NovoTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoCliente_SelecionaTelefones_NovoTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoCliente_SelecionaTelefones_NovoTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoCliente_SelecionaTelefones_NovoTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NovoCliente_SelecionaTelefones_NovoTelefone dialog = new NovoCliente_SelecionaTelefones_NovoTelefone(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelFundo;
    private javax.swing.JFormattedTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}