package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    // gerencia a conexão com o banco de dados "cadastro"
    private static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("estoquesorveteria");
    public static EntityManager getEntityManager () {
        return  FACTORY.createEntityManager();
    }
}
