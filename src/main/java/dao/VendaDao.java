package dao;

import model.Cliente;
import model.Venda;

import javax.persistence.EntityManager;
import java.util.List;

public class VendaDao {
    private EntityManager em ;
    public VendaDao (EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Venda venda) {
        // cria o registro no banco de dados
        this.em.persist(venda);
    }
    public List<Venda> buscarTodos() {
        String jpql = "SELECT v  FROM Venda v";
        return em.createQuery(jpql, Venda.class).getResultList();
    }
    public Venda buscarPorId (int id){
        return  em.find(Venda.class,id);
    }
    public void remover (Venda venda){
        em.merge(venda);//carrega o produto
        this.em.remove(venda);//exclui o registro
    }
    public void alterar (Venda venda){
        em.merge(venda );
    }

}
