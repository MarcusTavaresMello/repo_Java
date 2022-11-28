/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author marcu
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    public void atualizaTabela(){
        //Buscar lista com agendamentos do banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        //Exiber lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaCliente(){
        //buscar clientes no banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        //exibir clientes no combobox cliente
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServico(){
        
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        helper.preencherServicos(servicos);
        
    }
    
    
    public void atualizaValor(){
        Servico servico = helper.obterServico();
        helper.setarValor(servico.getValor());
    }
    
    
    public void agendar() {
        
        Agendamento agendamento = helper.obterModelo();
        
        new AgendamentoDAO().insert(agendamento);
        
        atualizaTabela();
        
        helper.limparTela();
        
    }
    
}
