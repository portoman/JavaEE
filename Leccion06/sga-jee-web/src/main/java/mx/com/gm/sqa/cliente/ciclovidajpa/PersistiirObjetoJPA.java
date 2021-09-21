package mx.com.gm.sqa.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistiirObjetoJPA {
    
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        //Inicia la transacción
        
        //Paso 1. Crea un nuevo objeto
        //Objeto en estado transitivo
        Persona persona1=new Persona("Alfonso", "Porto", "aporto@mail.com", "620771628");
        
        //Paso 2. Inicia transacción
        tx.begin();
        
        //Paso 3. Ejecuta SQL
        em.persist(persona1);
        
        log.debug("Objeto persistido - aun sin commit: "+persona1);
        
        //Paso 4. commit/rollback
         tx.commit();
         
        //Objeto en estado detached
        log.debug("Objeto persistido - estado detached: "+persona1);
        
        //Cerramos entity manager
        em.close();
    }
            
            
            
}
