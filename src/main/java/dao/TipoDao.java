package dao;

import model.Sabor;
import model.Tipo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class TipoDao {
    private EntityManager em ;

    public TipoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Tipo tipo) {
        // cria o registro no banco de dados
        this.em.persist(tipo);
    }

    public List<Tipo> buscarTodos() {
        String jpql = "SELECT t  FROM Tipo t";
        return em.createQuery(jpql, Tipo.class).getResultList();
    }
    public Tipo buscarPorId (int id){
        return  em.find(Tipo.class,id);
    }
    public void remover (Tipo tipo){
        em.merge(tipo);//carrega o produto
        this.em.remove(tipo);//exclui o registro
    }
    public void alterar (Tipo tipo){
        em.merge(tipo);
    }
}
