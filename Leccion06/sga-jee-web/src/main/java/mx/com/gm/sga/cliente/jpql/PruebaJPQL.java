package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PruebaJPQL {
    
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args) {
        String jpql=null;
        Query q=null;
        List<Persona>personas=null;
        Persona persona=null;
        Iterator iter=null;
        Object[] tupla=null;
        List<String>nombres=null;
        List<Usuario>usuarios=null;
        
        
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        //1. Consulta de todos los objetos de tipo Persona
        log.debug("\n1. Consulta de todas las Personas");
        jpql="select p from Persona p";
        personas=em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
    }
    
    private static void mostrarPersonas(List<Persona> personas){
        for(Persona p: personas){
            log.debug(p);
        }
    }
}
