package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectorDB {
    private static final EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("Poulet_Diallo");
    
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    // Optionnel : fermer à la fin de l'app
    public static void shutdown() {
        emf.close();
    }
}
