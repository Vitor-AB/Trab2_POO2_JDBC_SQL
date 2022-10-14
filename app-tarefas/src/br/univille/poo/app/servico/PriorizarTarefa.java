package br.univille.poo.app.servico;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.persistencia.TarefaDAO;

public class PriorizarTarefa {

    private TarefaDAO dao;

    public void priorizarTarefa(Tarefa tarefa, int prioridade) throws Exception{
        if(tarefa.getId() < 1){
            throw  new Exception("A tarefa não possui um identificador válido.");
        }
        tarefa.setPrioridade(prioridade);
        dao.atualizar(tarefa, prioridade);
    }


}
