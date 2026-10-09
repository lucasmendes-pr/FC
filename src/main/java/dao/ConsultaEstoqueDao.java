package dao;

import model.ConsultaEstoque;
import model.Estoque;

import javax.persistence.EntityManager;
import java.util.List;

public class ConsultaEstoqueDao {
    public EntityManager em;

    public ConsultaEstoqueDao(EntityManager em) {
        this.em = em;
    }
    public List<ConsultaEstoque>buscarTodos(){
        String jpql ="SELECT c FROM ConsultaEstoque c";
        return em.createQuery(jpql, ConsultaEstoque.class).getResultList();
    }
}
