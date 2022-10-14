package br.univille.poo.app.persistencia;

import br.univille.poo.app.persistencia.TarefaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeletarTabela {

    private final static String DELETAR_TABELA_TAREFA = "DROP TABLE tarefa;";

    public DeletarTabela(){}

    public static void deletarTabela(){
        try(Connection c = FabricaDeConexoes.obterInstancia().obterConexao();
            PreparedStatement p = c.prepareStatement(DELETAR_TABELA_TAREFA)) {
            p.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
