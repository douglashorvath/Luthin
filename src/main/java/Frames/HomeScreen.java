/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 *
 * @author Douglas Horvath
 */

public class HomeScreen extends javax.swing.JFrame {


    public HomeScreen() {
        
        initComponents();
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtp = new javax.swing.JDesktopPane();
        lbUsuario = new javax.swing.JLabel();
        lbVersao = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuAcesso = new javax.swing.JMenu();
        submenuSair = new javax.swing.JMenuItem();
        submenuEntrar = new javax.swing.JMenuItem();
        submenuAdministrador = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        submenuNovoCliente = new javax.swing.JMenuItem();
        submenuBuscarCliente = new javax.swing.JMenuItem();
        menuServiços = new javax.swing.JMenu();
        submenuNovoOrcamento = new javax.swing.JMenuItem();
        submenuOrcamentosAbertos = new javax.swing.JMenuItem();
        submenuNovaOrdemServico = new javax.swing.JMenuItem();
        submenuOrdensServicoAbertas = new javax.swing.JMenuItem();
        submenuRelatorioDiarioOrcamentos = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        submenuAgendaGeral = new javax.swing.JMenuItem();
        submenuMarcadores = new javax.swing.JMenuItem();
        menuAdministração = new javax.swing.JMenu();
        submenuContabilidade = new javax.swing.JMenu();
        submenuDespesas = new javax.swing.JMenuItem();
        submenuNovaDespesa = new javax.swing.JMenuItem();
        submenuReceitas = new javax.swing.JMenuItem();
        submenuNovaReceita = new javax.swing.JMenuItem();
        submenuRelatórios = new javax.swing.JMenuItem();
        submenuProdutos = new javax.swing.JMenu();
        submenuNovoProduto = new javax.swing.JMenuItem();
        submenuBuscarProduto = new javax.swing.JMenuItem();
        submenuEstoque = new javax.swing.JMenuItem();
        submenuAvaliacao = new javax.swing.JMenu();
        submenuRelatorioAvaliacoes = new javax.swing.JMenuItem();
        menuConfiguracoes = new javax.swing.JMenu();
        submenuConfiguracoesGerais = new javax.swing.JMenuItem();
        submenuDadosConsultorio = new javax.swing.JMenuItem();
        submenuConfiguracoesGerais1 = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        submenuEnviarRelatorioErros = new javax.swing.JMenuItem();
        menuDEV = new javax.swing.JMenu();
        submenuConsole = new javax.swing.JMenuItem();
        submenuMakeDB = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbUsuario.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbVersao.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        lbVersao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        dtp.setLayer(lbUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dtp.setLayer(lbVersao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dtpLayout = new javax.swing.GroupLayout(dtp);
        dtp.setLayout(dtpLayout);
        dtpLayout.setHorizontalGroup(
            dtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtpLayout.createSequentialGroup()
                .addGap(0, 382, Short.MAX_VALUE)
                .addGroup(dtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVersao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        dtpLayout.setVerticalGroup(
            dtpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtpLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 614, Short.MAX_VALUE)
                .addComponent(lbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuBar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        menuBar.setPreferredSize(new java.awt.Dimension(172, 40));
        menuBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                menuBarKeyReleased(evt);
            }
        });

        menuAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userLogin.png"))); // NOI18N
        menuAcesso.setText("Acesso");
        menuAcesso.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        submenuSair.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuSair.setText("Sair");
        submenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSairActionPerformed(evt);
            }
        });
        menuAcesso.add(submenuSair);

        submenuEntrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuEntrar.setText("Entrar");
        submenuEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuEntrarActionPerformed(evt);
            }
        });
        menuAcesso.add(submenuEntrar);

        submenuAdministrador.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuAdministrador.setText("Administrador");
        submenuAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdministradorActionPerformed(evt);
            }
        });
        menuAcesso.add(submenuAdministrador);

        menuBar.add(menuAcesso);

        menuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        menuCliente.setText("Orçamentos");
        menuCliente.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        submenuNovoCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuNovoCliente.setText("Novo Cliente");
        submenuNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuNovoClienteActionPerformed(evt);
            }
        });
        menuCliente.add(submenuNovoCliente);

        submenuBuscarCliente.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuBuscarCliente.setText("Buscar Clientes");
        submenuBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuBuscarClienteActionPerformed(evt);
            }
        });
        menuCliente.add(submenuBuscarCliente);

        menuBar.add(menuCliente);

        menuServiços.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        menuServiços.setText("Serviços");
        menuServiços.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        submenuNovoOrcamento.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuNovoOrcamento.setText("Novo Orçamento");
        submenuNovoOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuNovoOrcamentoActionPerformed(evt);
            }
        });
        menuServiços.add(submenuNovoOrcamento);

        submenuOrcamentosAbertos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuOrcamentosAbertos.setText("Orçamentos Abertos");
        submenuOrcamentosAbertos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuOrcamentosAbertosActionPerformed(evt);
            }
        });
        menuServiços.add(submenuOrcamentosAbertos);

        submenuNovaOrdemServico.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuNovaOrdemServico.setText("Nova Ordem de Serviço");
        submenuNovaOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuNovaOrdemServicoActionPerformed(evt);
            }
        });
        menuServiços.add(submenuNovaOrdemServico);

        submenuOrdensServicoAbertas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuOrdensServicoAbertas.setText("Ordens de Serviço Abertas");
        submenuOrdensServicoAbertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuOrdensServicoAbertasActionPerformed(evt);
            }
        });
        menuServiços.add(submenuOrdensServicoAbertas);

        submenuRelatorioDiarioOrcamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuRelatorioDiarioOrcamentos.setText("Relatório Diário");
        submenuRelatorioDiarioOrcamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuRelatorioDiarioOrcamentosActionPerformed(evt);
            }
        });
        menuServiços.add(submenuRelatorioDiarioOrcamentos);

        menuBar.add(menuServiços);

        menuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendarBig.png"))); // NOI18N
        menuConsultas.setText("Agenda");
        menuConsultas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        submenuAgendaGeral.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuAgendaGeral.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuAgendaGeral.setText("Agenda Geral");
        submenuAgendaGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAgendaGeralActionPerformed(evt);
            }
        });
        menuConsultas.add(submenuAgendaGeral);

        submenuMarcadores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuMarcadores.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuMarcadores.setText("Marcadores");
        submenuMarcadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuMarcadoresActionPerformed(evt);
            }
        });
        menuConsultas.add(submenuMarcadores);

        menuBar.add(menuConsultas);

        menuAdministração.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/despesa.png"))); // NOI18N
        menuAdministração.setText("Administração");
        menuAdministração.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        submenuContabilidade.setText("Contabilidade");
        submenuContabilidade.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        submenuDespesas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuDespesas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuDespesas.setText("Ver Despesas");
        submenuDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuDespesasActionPerformed(evt);
            }
        });
        submenuContabilidade.add(submenuDespesas);

        submenuNovaDespesa.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuNovaDespesa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuNovaDespesa.setText("Nova Despesa");
        submenuNovaDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuNovaDespesaActionPerformed(evt);
            }
        });
        submenuContabilidade.add(submenuNovaDespesa);

        submenuReceitas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuReceitas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuReceitas.setText("Ver Receitas");
        submenuReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReceitasActionPerformed(evt);
            }
        });
        submenuContabilidade.add(submenuReceitas);

        submenuNovaReceita.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuNovaReceita.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuNovaReceita.setText("Nova Receita");
        submenuNovaReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuNovaReceitaActionPerformed(evt);
            }
        });
        submenuContabilidade.add(submenuNovaReceita);

        submenuRelatórios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuRelatórios.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuRelatórios.setText("Relatórios de Contabilidade");
        submenuRelatórios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuRelatóriosActionPerformed(evt);
            }
        });
        submenuContabilidade.add(submenuRelatórios);

        menuAdministração.add(submenuContabilidade);

        submenuProdutos.setText("Produtos");
        submenuProdutos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        submenuNovoProduto.setText("Novo Produto");
        submenuProdutos.add(submenuNovoProduto);

        submenuBuscarProduto.setText("Buscar Produto");
        submenuProdutos.add(submenuBuscarProduto);

        submenuEstoque.setText("Estoque");
        submenuProdutos.add(submenuEstoque);

        menuAdministração.add(submenuProdutos);

        submenuAvaliacao.setText("Avaliação");
        submenuAvaliacao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        submenuRelatorioAvaliacoes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuRelatorioAvaliacoes.setText("Relatório de Avaliações");
        submenuRelatorioAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuRelatorioAvaliacoesActionPerformed(evt);
            }
        });
        submenuAvaliacao.add(submenuRelatorioAvaliacoes);

        menuAdministração.add(submenuAvaliacao);

        menuBar.add(menuAdministração);

        menuConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/config.png"))); // NOI18N
        menuConfiguracoes.setText("Configurações");
        menuConfiguracoes.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        submenuConfiguracoesGerais.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuConfiguracoesGerais.setText("Configurações Gerais");
        submenuConfiguracoesGerais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuConfiguracoesGeraisActionPerformed(evt);
            }
        });
        menuConfiguracoes.add(submenuConfiguracoesGerais);

        submenuDadosConsultorio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuDadosConsultorio.setText("Dados do Consultório");
        submenuDadosConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuDadosConsultorioActionPerformed(evt);
            }
        });
        menuConfiguracoes.add(submenuDadosConsultorio);

        submenuConfiguracoesGerais1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        submenuConfiguracoesGerais1.setText("Procurar Atualizações");
        submenuConfiguracoesGerais1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuConfiguracoesGerais1ActionPerformed(evt);
            }
        });
        menuConfiguracoes.add(submenuConfiguracoesGerais1);

        menuBar.add(menuConfiguracoes);

        menuAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/question.png"))); // NOI18N
        menuAjuda.setText("Ajuda");
        menuAjuda.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        submenuEnviarRelatorioErros.setText("Reportar Erro");
        submenuEnviarRelatorioErros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuEnviarRelatorioErrosActionPerformed(evt);
            }
        });
        menuAjuda.add(submenuEnviarRelatorioErros);

        menuBar.add(menuAjuda);

        menuDEV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dev.png"))); // NOI18N
        menuDEV.setText("DEV");
        menuDEV.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        submenuConsole.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        submenuConsole.setText("Console");
        submenuConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuConsoleActionPerformed(evt);
            }
        });
        menuDEV.add(submenuConsole);

        submenuMakeDB.setText("MakeDB");
        submenuMakeDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuMakeDBActionPerformed(evt);
            }
        });
        menuDEV.add(submenuMakeDB);

        menuBar.add(menuDEV);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtp)
        );

        setSize(new java.awt.Dimension(1283, 740));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void submenuMakeDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuMakeDBActionPerformed

    }//GEN-LAST:event_submenuMakeDBActionPerformed

    private void submenuConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuConsoleActionPerformed

    }//GEN-LAST:event_submenuConsoleActionPerformed

    private void submenuEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuEntrarActionPerformed

    }//GEN-LAST:event_submenuEntrarActionPerformed

    private void submenuAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdministradorActionPerformed

    }//GEN-LAST:event_submenuAdministradorActionPerformed

    private void submenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSairActionPerformed

    }//GEN-LAST:event_submenuSairActionPerformed

    private void submenuConfiguracoesGeraisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuConfiguracoesGeraisActionPerformed

    }//GEN-LAST:event_submenuConfiguracoesGeraisActionPerformed

    private void submenuMarcadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuMarcadoresActionPerformed

    }//GEN-LAST:event_submenuMarcadoresActionPerformed

    private void submenuAgendaGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAgendaGeralActionPerformed

    }//GEN-LAST:event_submenuAgendaGeralActionPerformed

    private void submenuDadosConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuDadosConsultorioActionPerformed

    }//GEN-LAST:event_submenuDadosConsultorioActionPerformed

    private void menuBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuBarKeyReleased
        
    }//GEN-LAST:event_menuBarKeyReleased

    private void submenuConfiguracoesGerais1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuConfiguracoesGerais1ActionPerformed

    }//GEN-LAST:event_submenuConfiguracoesGerais1ActionPerformed

    private void submenuEnviarRelatorioErrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuEnviarRelatorioErrosActionPerformed

    }//GEN-LAST:event_submenuEnviarRelatorioErrosActionPerformed

    private void submenuNovaDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuNovaDespesaActionPerformed

    }//GEN-LAST:event_submenuNovaDespesaActionPerformed

    private void submenuNovaReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuNovaReceitaActionPerformed

    }//GEN-LAST:event_submenuNovaReceitaActionPerformed

    private void submenuDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuDespesasActionPerformed

    }//GEN-LAST:event_submenuDespesasActionPerformed

    private void submenuReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReceitasActionPerformed

    }//GEN-LAST:event_submenuReceitasActionPerformed

    private void submenuRelatóriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuRelatóriosActionPerformed

    }//GEN-LAST:event_submenuRelatóriosActionPerformed

    private void submenuRelatorioAvaliacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuRelatorioAvaliacoesActionPerformed

    }//GEN-LAST:event_submenuRelatorioAvaliacoesActionPerformed

    private void submenuRelatorioDiarioOrcamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuRelatorioDiarioOrcamentosActionPerformed

    }//GEN-LAST:event_submenuRelatorioDiarioOrcamentosActionPerformed

    private void submenuOrcamentosAbertosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuOrcamentosAbertosActionPerformed

    }//GEN-LAST:event_submenuOrcamentosAbertosActionPerformed

    private void submenuNovoOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuNovoOrcamentoActionPerformed

    }//GEN-LAST:event_submenuNovoOrcamentoActionPerformed

    private void submenuNovaOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuNovaOrdemServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submenuNovaOrdemServicoActionPerformed

    private void submenuOrdensServicoAbertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuOrdensServicoAbertasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submenuOrdensServicoAbertasActionPerformed

    private void submenuNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuNovoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submenuNovoClienteActionPerformed

    private void submenuBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuBuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submenuBuscarClienteActionPerformed



    public JDesktopPane getDtp() {
        return dtp;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dtp;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbVersao;
    private javax.swing.JMenu menuAcesso;
    private javax.swing.JMenu menuAdministração;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuConfiguracoes;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenu menuDEV;
    private javax.swing.JMenu menuServiços;
    private javax.swing.JMenuItem submenuAdministrador;
    private javax.swing.JMenuItem submenuAgendaGeral;
    private javax.swing.JMenu submenuAvaliacao;
    private javax.swing.JMenuItem submenuBuscarCliente;
    private javax.swing.JMenuItem submenuBuscarProduto;
    private javax.swing.JMenuItem submenuConfiguracoesGerais;
    private javax.swing.JMenuItem submenuConfiguracoesGerais1;
    private javax.swing.JMenuItem submenuConsole;
    private javax.swing.JMenu submenuContabilidade;
    private javax.swing.JMenuItem submenuDadosConsultorio;
    private javax.swing.JMenuItem submenuDespesas;
    private javax.swing.JMenuItem submenuEntrar;
    private javax.swing.JMenuItem submenuEnviarRelatorioErros;
    private javax.swing.JMenuItem submenuEstoque;
    private javax.swing.JMenuItem submenuMakeDB;
    private javax.swing.JMenuItem submenuMarcadores;
    private javax.swing.JMenuItem submenuNovaDespesa;
    private javax.swing.JMenuItem submenuNovaOrdemServico;
    private javax.swing.JMenuItem submenuNovaReceita;
    private javax.swing.JMenuItem submenuNovoCliente;
    private javax.swing.JMenuItem submenuNovoOrcamento;
    private javax.swing.JMenuItem submenuNovoProduto;
    private javax.swing.JMenuItem submenuOrcamentosAbertos;
    private javax.swing.JMenuItem submenuOrdensServicoAbertas;
    private javax.swing.JMenu submenuProdutos;
    private javax.swing.JMenuItem submenuReceitas;
    private javax.swing.JMenuItem submenuRelatorioAvaliacoes;
    private javax.swing.JMenuItem submenuRelatorioDiarioOrcamentos;
    private javax.swing.JMenuItem submenuRelatórios;
    private javax.swing.JMenuItem submenuSair;
    // End of variables declaration//GEN-END:variables
}
