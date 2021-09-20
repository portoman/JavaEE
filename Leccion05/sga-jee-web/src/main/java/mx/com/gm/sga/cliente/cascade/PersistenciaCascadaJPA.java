/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.cascade;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author portb
 */
public class PersistenciaCascadaJPA {
    static Logger log=LogManager.getRootLogger();
    
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        
        //Paso 1. Crear nuevo objeto
        //Objeto en estado transitivo
        Persona persona1=new Persona("Paco", "Buyo", "pbuyo@mail.com", "687989898");
        
        //Crear objeto usuario(tiene dependencia con el objeto persona)
        Usuario usuario1=new Usuario("pbuyo","123",persona1);
        
        //Paso 3. Persistimos objeto usuario unicamente
        em.persist(usuario1);
        
        //Paso 4. Commit
        tx.commit();
        
        //Objetos en estado detached
        log.debug("Objeto persistido persona: "+persona1);
        log.debug("Objeto persistido usuario: "+usuario1);
        
        em.close();
}
}
