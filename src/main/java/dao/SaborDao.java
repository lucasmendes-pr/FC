package dao;

import model.Sabor;

import javax.persistence.EntityManager;
import java.util.List;

public class SaborDao {
    private EntityManager em ;

    public SaborDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Sabor sabor) {
        // cria o registro no banco de dados
        this.em.persist(sabor);
    }
    public List<Sabor> buscarTodos(){
        String jpql ="SELECT s  FROM Sabor s";
        return em.createQuery(jpql,Sabor.class).getResultList();
    }
    public Sabor buscarPorId (int id){
        return  em.find(Sabor.class,id);
    }
    public void remover (Sabor sabor){
        em.merge(sabor);//carrega o produto
        this.em.remove(sabor);//exclui o registro
    }
    public void alterar (Sabor sabor){
        em.merge(sabor);
    }

}
