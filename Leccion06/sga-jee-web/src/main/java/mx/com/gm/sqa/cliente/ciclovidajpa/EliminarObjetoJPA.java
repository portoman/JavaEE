package mx.com.gm.sqa.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EliminarObjetoJPA {
      static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        //Inicia la transacción
        
        //Paso 1. Iniciar una transacción
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        
        //Paso 2. Ejecuta SQL de tipo select
        Persona persona1=em.find(Persona.class, 44);

        //Paso 3. Terminar la transacción 1
        tx.commit();
        
        
        //Paso 4. Inicia la transacción 2
        EntityTransaction tx2=em.getTransaction();
        tx2.begin();
        
        //Paso 5. Ejecuta SQL que es un delete
        em.remove(em.merge(persona1));
        
        //Paso 6. Termina transacción 2
        tx2.commit();
        
         //Objeto en estado detached ya eliminado
        log.debug("Objeto eliminado:"+persona1);
        
        //Cerramos entity manager
        em.close();
    }
}
