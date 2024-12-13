import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import dominio.musica;
import dominio.album;
import dominio.artista;


public class App {
    public static void main(String[] args) throws Exception {

        musica musica1 = new musica();
        musica1.setNome("Summer Eletrohits - Don't know why");
        musica1.setGenero("Eletronica");
        musica1.setDuração(120);
        musica1.setArquivoAudio("./assets/y2meta.net_320kbps-moony-i-dont-know-why-summer-eletrohits-5.mp3");

        musica musica2 = new musica();
        musica2.setNome("Summer Eletrohits - Stereo Love");
        musica2.setGenero("Eletronica");
        musica2.setDuração(120);
        musica2.setArquivoAudio("./assets/y2meta.net_320kbps-edward-maya-and-vika-jigulina-stereo-love-official-music-video.mp3");

        musica musica3 = new musica();
        musica3.setNome("Summer Eletrohits - If You");
        musica3.setGenero("Eletronica");
        musica3.setDuração(120);
        musica3.setArquivoAudio("./assets/y2meta.net_320kbps-magic-box-if-you-official-video.mp3");

        album album1 = new album();
        album1.setNome("Primeiro album");
        album1.setAno(2000);
        album1.addMusica(musica1);
        album1.addMusica(musica2);
        album1.addMusica(musica3);
        
        artista SummerEletroHits = new artista();
        SummerEletroHits.setNome("Summer Eletrohits");
        SummerEletroHits.addAlbum(album1);

        System.out.println("Abrindo PlayMusic");

        AudioPlayer player = new AudioPlayer();
        player.loadAudio(SummerEletroHits.getAlbuns().get(0).getMusicas().get(0).getArquivoAudio()); // Carregue o áudio ao iniciar

        // Cria o botão Play/Stop e configura sua ação
        JButton playStopButton = new JButton("Play");
        playStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!player.isPlaying) {
                    player.playAudio();
                    playStopButton.setText("Stop");
                } else {
                    player.stopAudio();
                    playStopButton.setText("Play");
                }
            }
        });
        
        ImageIcon icon = new ImageIcon("./assets/music.png");
        // Exibe um JOptionPane com o botão Play/Stop
        JOptionPane.showOptionDialog(
                null,
                SummerEletroHits.getAlbuns().get(0).getMusicas().get(0).getNome(),
                "PlayMusic",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon,
                new Object[] { playStopButton }, playStopButton);

        // Fecha o clip de áudio ao encerrar o programa
        if (player.audioClip != null) {
            player.audioClip.close();
        }

    }
}
