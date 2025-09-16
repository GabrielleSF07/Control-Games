package controlgames.controlgamesbd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControlGamesDAO {
    
    private ControlGamesConnector conexao;
    private Statement stm;
    private Connection conn;
    private ResultSet rs;
    
    public void insereUsuario(Usuarios u){
      try{
          stm.execute("INSERT INTO Clientes (nome, email, senha, idade) VALUES('" + u.getNome() + "','" + u.getEmail() + "' , '" + u.getSenha() + "' , '" + u.getIdade() + "');");
      }  catch (Exception e){
          Logger.getLogger(ControlGamesDAO.class.getName()).log(Level.SEVERE, null, e);
          JOptionPane.showMessageDialog(null, e.getMessage());
      }
    }
    
    private static List<Desenvolvedores> desenvolvedores = new ArrayList<>(); 
    private static List<Jogos> jogos = new ArrayList<>();
    private static List<Usuarios> usuarios = new ArrayList<>();

    public static List<Jogos> getJogos() {
        return jogos;
    }
    
    public static List<Usuarios> getUsuarios(){
        return usuarios;
    }

    public static Desenvolvedores login(String nome, String email, String senha) {
        for (Desenvolvedores d : desenvolvedores) {
            if (d.getNome().equals(nome) && d.getEmail().equals(email) && d.getSenha().equals(senha)) {
                return d;
            }
        }
        return null;
    }
}
