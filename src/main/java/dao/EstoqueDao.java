package dao;

import model.Estoque;
import model.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class EstoqueDao {
    private EntityManager em ;

    public EstoqueDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Estoque estoque) {
        // cria o registro no banco de dados
        this.em.persist(estoque);
    }
    public List<Estoque> buscarTodos(){
        String jpql ="SELECT e FROM Estoque e";
        return em.createQuery(jpql,Estoque.class).getResultList();
    }
    public Estoque buscarPorId (int id){
        return  em.find(Estoque.class,id);
    }
    public void remover (Estoque estoque){
        em.merge(estoque);//carrega o produto
        this.em.remove(estoque);//exclui o registro
    }
    public void alterar (Estoque estoque){
        em.merge(estoque);
    }
}
