package controlgames.controlgamesbd.dao;

import java.util.List;
import java.util.ArrayList;

public class BancoTemporario {
    private static List<Desenvolvedores> desenvolvedores = new ArrayList<>(); 
    private static List<Jogos> jogos = new ArrayList<>();
    private static List<Usuarios> usuarios = new ArrayList<>();

    static {
        desenvolvedores.add(new Desenvolvedores("Rockstar Games", "rockstar@gmail.com", "1234rock", 2,0,0));
        jogos.add(new Jogos("Grand Theft Auto 5", "Grand Theft Auto V para PC oferece aos jogadores a opção de explorar o gigantesco e premiado mundo de Los Santos e Blaine County em resoluções de até 4K e além, assim como a chance de experimentar o jogo rodando a 60 FPS (quadros por segundo).", "Mundo Aberto", "14/04/2015", "Rockstar Games", 18, 74.95, "Ativo", 0,0,1));
        jogos.add(new Jogos("Red Dead Redemption 2", "Red Dead Redemption 2, a épica aventura de mundo aberto da Rockstar Games aclamada pela crítica e o jogo mais bem avaliado desta geração de consoles, agora chega aprimorado para PC com conteúdos inéditos no Modo História, melhorias visuais e muito mais.", "Velho Oeste", "05/12/2019", "Rockstar Games", 18, 299.90, "Ativo", 0,0,2));
    }

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
