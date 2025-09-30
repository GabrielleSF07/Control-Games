package controlgames.controlgamesbd.dao;

import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.hibernate.query.results.internal.Builders.entity;

public class UsuariosDAO {
    private ControlGamesConnector conexao;
    private Statement stm;
    private Connection conn;
    private ResultSet rs;
    EntityManager em = ControlGamesConnector.getEntityManager();
    
    public void insereUsuario(Usuarios u){
      try{
          em.getTransaction().begin();
          em.persist(u);
          em.getTransaction().commit();
      }  catch (Exception e){
          Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, e);
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }
    
    public Usuarios buscarUsuario (String email){
    try {
        return em.createQuery(
            "SELECT u FROM Usuarios u WHERE u.email = :email", Usuarios.class)
            .setParameter("email", email)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
    }
    
    public Usuarios loginUsuario (String email, String senha){
    try {
        return em.createQuery(
            "SELECT u FROM Usuarios u WHERE u.email = :email AND u.senha = :senha", Usuarios.class)
            .setParameter("email", email)
            .setParameter("senha", senha)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }
        }
    
   public Object[] listarDados(String email) {
    try {
        String jpql = "SELECT u.nome, u.email, COUNT(c) " +
                      "FROM Usuarios u LEFT JOIN u.compras c " +
                      "WHERE u.email = :email " +
                      "GROUP BY u.id, u.nome, u.email";
        
        return em.createQuery(jpql, Object[].class)
                 .setParameter("email", email)
                 .getSingleResult();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}
   