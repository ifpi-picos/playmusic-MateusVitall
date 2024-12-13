package dominio;

import java.util.ArrayList;
import java.util.List;

public class playlist {
    private String nomePlaylist;
    private List<musica> musicas= new ArrayList<>();
    
    public String getNomePlaylist() {
        return nomePlaylist;
    }
    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }
    public List<musica> getMusicas() {
        return musicas;
    }
    public void setMusicas(List<musica> musicas) {
        this.musicas = musicas;
    }

    

}