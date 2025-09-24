package controlgames.controlgamesbd.dao;

import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JogosDAO {
    private ControlGamesConnector conexao;
    private Statement stm;
    private Connection conn;
    private ResultSet rs;
    EntityManager em = ControlGamesConnector.getEntityManager();
    
public List<Jogos> listarJogos(Desenvolvedores d) {
    try {
        return em.createQuery("SELECT j FROM Jogos j WHERE j.desenvolvedora = :dev", Jogos.class)
                 .setParameter("dev", d)
                 .getResultList();
    } finally {
        em.close();
    }
}
}
