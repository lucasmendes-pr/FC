package dao;

import model.Cliente;
import model.Tipo;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    private EntityManager em ;
    public ClienteDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar(Cliente cliente) {
        // cria o registro no banco de dados
        this.em.persist(cliente);
    }
    public List<Cliente> buscarTodos() {
        String jpql = "SELECT c  FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }
    public Cliente buscarPorId (int id){
        return  em.find(Cliente.class,id);
    }
    public void remover (Cliente cliente){
        em.merge(cliente);//carrega o produto
        this.em.remove(cliente);//exclui o registro
    }
    public void alterar (Cliente cliente){
        em.merge(cliente);
    }

}
