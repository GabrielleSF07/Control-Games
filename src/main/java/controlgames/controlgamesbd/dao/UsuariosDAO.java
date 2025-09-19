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
    
    public void insereUsuario(Usuarios u){
      try{
          EntityManager em = ControlGamesConnector.getEntityManager();
          em.getTransaction().begin();
          em.persist(u);
          em.getTransaction().commit();
      }  catch (Exception e){
          Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, e);
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }
}
    
   