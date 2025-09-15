/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package controlgames.controlgamesbd.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Gabrielle
 */
public class ControlGamesConnector {

    public static void main(String[] args) {
         EntityManagerFactory fabricaEntidade = Persistence.createEntityManagerFactory("control_games");
            EntityManager manager = fabricaEntidade.createEntityManager();                        
                      
    }
}
