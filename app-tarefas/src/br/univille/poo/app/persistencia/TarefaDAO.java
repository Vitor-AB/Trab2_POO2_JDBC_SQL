package br.univille.poo.app.persistencia;

import br.univille.poo.app.entidade.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO extends BaseDAO{

    public void inserir(Tarefa tarefa) {
        String sql = "insert into tarefa(descricao, concluido) values(? ,?)";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,tarefa.getDescricao());
            p.setBoolean(2,tarefa.isConcluido());
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }

    public void atualizar(Tarefa tarefa) {

    }

    public List<Tarefa> obterTodos() {
        List<Tarefa> lista = new ArrayList<>();
        String sql = "select id, descricao, concluido, prioridade from tarefa";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){

            ResultSet resultSet = p.executeQuery();
            while(resultSet.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setConcluido(resultSet.getBoolean("concluido"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setPrioridade(resultSet.getInt("prioridade"));
                lista.add(tarefa);
            }
        }catch (SQLException e){
            System.out.println("Erro ao obter todas as tarefas ");
            e.printStackTrace();
        }
        return lista;
    }

}
