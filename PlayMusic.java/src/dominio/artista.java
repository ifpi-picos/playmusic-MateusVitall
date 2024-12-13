package dominio;


import java.util.ArrayList;
import java.util.List;

public class artista {
    private String nome;
    private List<album> albuns = new ArrayList<>();

    public String getNome() {
        return nome;
      }
    
      public void setNome(String nome) {
        this.nome = nome;
      }
    
      public List<album> getAlbuns() {
        return albuns;
      }
    
      public void addAlbum(album album) {
        this.albuns.add(album);
      }
    
      public void addAlbuns(List<album> albuns) {
        this.albuns.addAll(albuns);
      }
}
