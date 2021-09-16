package mx.com.gm.sqa.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {
     static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        //Inicia la transacción
        
        //Paso 1. Iniciar una transacción
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        
        //Paso 2. Ejecuta SQL de tipo select
        //El id proporcionado debe ecistir en la base de datos
        Persona persona1=em.find(Persona.class, 44);
        
        //Paso 3. Termina la transacción 1
        tx.commit();
        
        //Objeto en estado detache
        log.debug("Objeto recuperado: "+persona1);
        
        //Paso 4. setValue(nuevoValor)
        persona1.setApellido("Calatraba");
        
        //Paso 5. Inicia transacción 2
        EntityTransaction tx2=em.getTransaction();
        tx2.begin();
        
        //Paso 6. Modificamos el objeto
        em.merge(persona1);
        
        //Paso 7. Termina transacción 2
        tx2.commit();
        
        //Objeto en estado detached ya modificado
        log.debug("Objeto recuperado:"+persona1);
        
        //Cerramos entity manager
        em.close();
    }
}

