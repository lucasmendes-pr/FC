package dao;

import model.Produto;
import model.Sabor;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {
    private EntityManager em ;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Produto produto) {
        // cria o registro no banco de dados
        this.em.persist(produto);
    }
    public List<Produto> buscarTodos(){
        String jpql ="SELECT p  FROM Produto p";
        return em.createQuery(jpql,Produto.class).getResultList();
    }
    public Produto buscarPorId (int id){
        return  em.find(Produto.class,id);
    }
    public void remover (Produto produto){
        em.merge(produto);//carrega o produto
        this.em.remove(produto);//exclui o registro
    }
    public void alterar (Produto produto){
        em.merge(produto);
    }
}
