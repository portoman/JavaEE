package mx.com.gm.sqa.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncontrarObjetoJPA {
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        //Inicia la transacción
        
        //Paso 1. Iniciar una transacción
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        
        //Paso 2. Ejecuta SQL de tipo select
        Persona persona1=em.find(Persona.class, 45);
        
        //Paso 3. Termina la transacción
        tx.commit();
        
        //Objeto en estado de detached
        log.debug("Objeto recuperado: "+persona1);
        
        //Cerramos entity manager
        em.close();
    }
}
