
package controlgames.controlgamesbd.dao;

import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DesenvolvedoresDAO {
   private ControlGamesConnector conexao;
    private Statement stm;
    private Connection conn;
    private ResultSet rs;
    EntityManager em = ControlGamesConnector.getEntityManager();
    
    public void insereDesenvolvedor(Desenvolvedores d){
      try{
          em.getTransaction().begin();
          em.persist(d);
          em.getTransaction().commit();
      }  catch (Exception e){
          Logger.getLogger(DesenvolvedoresDAO.class.getName()).log(Level.SEVERE, null, e);
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }
    
    public Desenvolvedores buscarDesenvolvedores (String email){
    try {
        return em.createQuery(
            "SELECT d FROM Desenvolvedores d WHERE d.email = :email", Desenvolvedores.class)
            .setParameter("email", email)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
    }
    
    public Desenvolvedores loginDesenvolvedores (String email, String senha){
    try {
        return em.createQuery(
            "SELECT d FROM Desenvolvedores d WHERE d.email = :email AND d.senha = :senha", Desenvolvedores.class)
            .setParameter("email", email)
            .setParameter("senha", senha)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
        } 
}
