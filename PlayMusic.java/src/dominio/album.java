package dominio;

import java.util.ArrayList;
import java.util.List;

public class album {
    private String nome;
    private int ano;
    private List<musica> musicas = new ArrayList<>();

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public List<musica> getMusicas(){
        return musicas;
    }

    public void addMusica(musica musica){
        musicas.add(musica);
    }

    public void addMusicas(List<musica> musicas) {
        this.musicas.addAll(musicas);
      }

}