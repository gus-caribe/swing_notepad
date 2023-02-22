/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiPrincipal;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class BlocoDeNotasGUI extends javax.swing.JFrame implements classes.BlocoDeNotas {

    /**
     * Creates new form BlocoDeNotasGUI
     */
    public BlocoDeNotasGUI() {
        initComponents();
        arquivo = new classes.Arquivo();
        atualizaEstadoDoArquivo();
        this.botaoSalvar.setEnabled(false);
    }
    
    @Override
    public void criarNovo() {
        int retornoDialog;
        JFileChooser selecionar = new JFileChooser();
        
        //se o arquivo atual estiver alterado
        if (this.arquivo.isAlterado()) {
            //chamar a dialog salvar "deseja salvar alterações?"
            Object[] opcoes = {"Sim", "Não"};
            
            retornoDialog = JOptionPane.showOptionDialog(this, "Deseja salvar alterações?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            //se o usuário confirmar e o file do arquivo for nulo
            if(retornoDialog == 0 && this.arquivo.getArquivo() == null) {
                //chama a dialog de salvar como
                int opcao = selecionar.showOpenDialog(this);
                //caso retorne positivo
                if (opcao == JFileChooser.APPROVE_OPTION) {
                    //mandar o arquivo salvar
                    this.arquivo.salvar(selecionar.getSelectedFile(), this.conteudo.getText());
                    //manda o arquivo abrir
                    reseta();
                }
            }
            else if (retornoDialog ==0) {//se o usuário confirmar e o file do arquivo não for nulo
                //mandar o arquivo salvar
                this.arquivo.salvar(this.conteudo.getText());
                //manda o arquivo abrir 
                reseta();
            }
            else {//se o usuario recusar
                //manda o arquivo abrir 
                reseta();
            }
        }
        else {//se o arquivo atual não estiver alterado
            //manda o arquivo abrir
            reseta();
        }
    }
    
    @Override
    public void salvar() {
        JFileChooser salvarComo = new JFileChooser();
        //se o file do arquivo for nulo
        if (this.arquivo.getArquivo() == null) {
            //abrir dialog de salvar como
            int opcao = salvarComo.showSaveDialog(this);
            
            //caso retorne positivo
            if (opcao == JFileChooser.APPROVE_OPTION) {
                //aí salva
                this.arquivo.salvar(salvarComo.getSelectedFile(), this.conteudo.getText());
            }
        }
        else {//se o file do arquivo não for nulo
            //aí salva
            this.arquivo.salvar(this.conteudo.getText());
        }
        
        atualizaEstadoDoArquivo();
    }
    
    @Override
    public void abrir() {
        int retornoDialog;
        JFileChooser selecionar = new JFileChooser();
        
        //se o arquivo atual estiver alterado
        if (this.arquivo.isAlterado()) {
            //chamar a dialog salvar "deseja salvar alterações?"
            Object[] opcoes = {"Sim", "Não"};
            
            retornoDialog = JOptionPane.showOptionDialog(this, "Deseja salvar alterações?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            //se o usuário confirmar e o file do arquivo for nulo
            if(retornoDialog == 0 && this.arquivo.getArquivo() == null) {
                //chama a dialog de salvar como
                int opcao = selecionar.showOpenDialog(this);
                //caso retorne positivo
                if (opcao == JFileChooser.APPROVE_OPTION) {
                    //mandar o arquivo salvar
                    this.arquivo.salvar(selecionar.getSelectedFile(), this.conteudo.getText());
                    //manda o arquivo abrir
                    this.conteudo.setText(this.arquivo.abrir(selecionar.getSelectedFile()));
                }
            }
            else if (retornoDialog ==0) {//se o usuário confirmar e o file do arquivo não for nulo
                //mandar o arquivo salvar
                this.arquivo.salvar(this.conteudo.getText());
                
                //manda o arquivo abrir 
                int opcao = selecionar.showOpenDialog(this);
                
                if (opcao == JFileChooser.APPROVE_OPTION) {
                    //manda o arquivo abrir
                    this.conteudo.setText(this.arquivo.abrir(selecionar.getSelectedFile()));
                }
            }
            else {//se o usuario recusar
                //manda o arquivo abrir 
                int opcao = selecionar.showOpenDialog(this);
                
                if (opcao == JFileChooser.APPROVE_OPTION) {
                    //manda o arquivo abrir
                    this.conteudo.setText(this.arquivo.abrir(selecionar.getSelectedFile()));
                }
            }
        }
        else {//se o arquivo atual não estiver alterado
            //manda o arquivo abrir
            int opcao = selecionar.showOpenDialog(this);
                
                if (opcao == JFileChooser.APPROVE_OPTION) {
                    //manda o arquivo abrir
                    this.conteudo.setText(this.arquivo.abrir(selecionar.getSelectedFile()));
                }
        }
        
        atualizaEstadoDoArquivo();
        atualizaInformacoes();
    }
    
    public void atualizaEstadoDoArquivo() {
        setTitle(tituloJanela + " - " + this.arquivo.getTitulo() + (this.arquivo.isAlterado() ? "*" : ""));
        this.botaoSalvar.setEnabled(this.arquivo.isAlterado());
    }
    
    public void atualizaInformacoes() {
        campoLinhas.setText(String.valueOf(this.conteudo.getLineCount()));
        campoCaracteres.setText(String.valueOf(this.conteudo.getText().length()+1));
        campoPalavras.setText(String.valueOf(this.conteudo.getText().split("\\s").length));
    }
    
    public void reseta() {
        this.conteudo.setText("");
        this.arquivo = null;
        this.arquivo = new classes.Arquivo();
        atualizaEstadoDoArquivo();
        atualizaInformacoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraDeFerramentas = new javax.swing.JToolBar();
        botaoNovo = new javax.swing.JButton();
        botaoAbrir = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoQuebraDeLinha = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        conteudo = new javax.swing.JTextArea();
        labelCaracteres = new javax.swing.JLabel();
        labelPalavras = new javax.swing.JLabel();
        labelLinhas = new javax.swing.JLabel();
        campoCaracteres = new javax.swing.JTextField();
        campoPalavras = new javax.swing.JTextField();
        campoLinhas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        barraDeFerramentas.setRollover(true);

        botaoNovo.setText("Novo");
        botaoNovo.setFocusable(false);
        botaoNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(botaoNovo);

        botaoAbrir.setText("Abrir");
        botaoAbrir.setFocusable(false);
        botaoAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAbrirActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(botaoAbrir);

        botaoSalvar.setText("Salvar");
        botaoSalvar.setFocusable(false);
        botaoSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(botaoSalvar);

        botaoQuebraDeLinha.setText("Quebra de Linha");
        botaoQuebraDeLinha.setFocusable(false);
        botaoQuebraDeLinha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoQuebraDeLinha.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoQuebraDeLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoQuebraDeLinhaActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(botaoQuebraDeLinha);

        conteudo.setColumns(20);
        conteudo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        conteudo.setRows(5);
        conteudo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                conteudoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(conteudo);

        labelCaracteres.setText("Caracteres:");

        labelPalavras.setText("Palavras:");

        labelLinhas.setText("Linhas:");

        campoCaracteres.setEditable(false);

        campoPalavras.setEditable(false);

        campoLinhas.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraDeFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelCaracteres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPalavras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPalavras, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLinhas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraDeFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLinhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLinhas)
                    .addComponent(campoPalavras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPalavras)
                    .addComponent(campoCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCaracteres))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoQuebraDeLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoQuebraDeLinhaActionPerformed
        // TODO add your handling code here:
        
        this.conteudo.setLineWrap(!this.conteudo.getLineWrap());
    }//GEN-LAST:event_botaoQuebraDeLinhaActionPerformed

    private void conteudoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_conteudoKeyTyped
        // TODO add your handling code here:
        
        atualizaInformacoes();
        
        if (!this.arquivo.isAlterado()) {
            this.arquivo.setAlterado(true);
            atualizaEstadoDoArquivo();
            this.botaoSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_conteudoKeyTyped

    private void botaoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAbrirActionPerformed
        // TODO add your handling code here:
        
        abrir();
    }//GEN-LAST:event_botaoAbrirActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        // TODO add your handling code here:
        
        salvar();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        // TODO add your handling code here:
        
        criarNovo();
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        int retornoDialog;
        JFileChooser selecionar = new JFileChooser();
        
        //se o arquivo atual estiver alterado
        if (this.arquivo.isAlterado()) {
            //chamar a dialog salvar "deseja salvar alterações?"
            Object[] opcoes = {"Sim", "Não"};
            
            retornoDialog = JOptionPane.showOptionDialog(this, "Deseja salvar alterações?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            //se o usuário confirmar e o file do arquivo for nulo
            if(retornoDialog == 0 && this.arquivo.getArquivo() == null) {
                //chama a dialog de salvar como
                int opcao = selecionar.showSaveDialog(this);
                //caso retorne positivo
                if (opcao == JFileChooser.APPROVE_OPTION) {
                    //mandar o arquivo salvar
                    this.arquivo.salvar(selecionar.getSelectedFile(), this.conteudo.getText());
                }
            }
            else if (retornoDialog ==0) {//se o usuário confirmar e o file do arquivo não for nulo
                //mandar o arquivo salvar
                this.arquivo.salvar(this.conteudo.getText());
            }
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(BlocoDeNotasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlocoDeNotasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlocoDeNotasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlocoDeNotasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BlocoDeNotasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraDeFerramentas;
    private javax.swing.JButton botaoAbrir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoQuebraDeLinha;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoCaracteres;
    private javax.swing.JTextField campoLinhas;
    private javax.swing.JTextField campoPalavras;
    private javax.swing.JTextArea conteudo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCaracteres;
    private javax.swing.JLabel labelLinhas;
    private javax.swing.JLabel labelPalavras;
    // End of variables declaration//GEN-END:variables

    private classes.Arquivo arquivo;
    private final String tituloJanela = "Java Notepad";
}
