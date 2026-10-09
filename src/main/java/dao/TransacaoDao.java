package dao;

import model.Cliente;
import model.Transacao;

import javax.persistence.EntityManager;
import java.util.List;

public class TransacaoDao {
    private EntityManager em ;
    public TransacaoDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Transacao transacao) {
        // cria o registro no banco de dados
        this.em.persist(transacao);
    }
    public List<Transacao> buscarTodos() {
        String jpql = "SELECT r  FROM Transacao r";
        return em.createQuery(jpql, Transacao.class).getResultList();
    }
    public Transacao buscarPorId (int id){
        return  em.find(Transacao.class,id);
    }
    public void remover (Transacao transacao){
        em.merge(transacao);//carrega o produto
        this.em.remove(transacao);//exclui o registro
    }
    public void alterar (Transacao transacao){
        em.merge(transacao);
    }

}
