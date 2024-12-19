import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
        musica1.setArquivoAudio("./assets/y2meta.net_320kbps-moony-i-dont-know-why-summer-eletrohits-5.wav");

        musica musica2 = new musica();
        musica2.setNome("Summer Eletrohits - Stereo Love");
        musica2.setGenero("Eletronica");
        musica2.setDuração(120);
        musica2.setArquivoAudio(
                "./assets/y2meta.net_320kbps-edward-maya-and-vika-jigulina-stereo-love-official-music-video.wav");

        musica musica3 = new musica();
        musica3.setNome("Summer Eletrohits - If You");
        musica3.setGenero("Eletronica");
        musica3.setDuração(120);
        musica3.setArquivoAudio("./assets/y2meta.net_320kbps-magic-box-if-you-official-video.wav");

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
        player.loadAudio(SummerEletroHits.getAlbuns().get(0).getMusicas().get(0).getArquivoAudio()); // Carregue o áudio
                                                                                                     // ao iniciar

        // Cria os botões Play/Stop e Next e configura suas ações
        JButton playStopButton = new JButton("Play");
        JButton nextButton = new JButton("Next");

        // Lista de músicas e índice atual
        List<musica> musicas = SummerEletroHits.getAlbuns().get(0).getMusicas();
        int[] musicaAtual = { 0 };

        // Inicializa o player com a primeira música
        player.loadAudio(musicas.get(musicaAtual[0]).getArquivoAudio());

        // Configura ação do botão Play/Stop
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

        // Configura ação do botão Next
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.stopAudio(); // Para a música atual
                musicaAtual[0] = (musicaAtual[0] + 1) % musicas.size(); // Avança para a próxima música
                player.loadAudio(musicas.get(musicaAtual[0]).getArquivoAudio()); // Carrega a nova música
                JOptionPane.showMessageDialog(
                        null,
                        "Tocando: " + musicas.get(musicaAtual[0]).getNome(),
                        "PlayMusic",
                        JOptionPane.INFORMATION_MESSAGE);
                playStopButton.setText("Play");
            }
        });

        // Exibe um JOptionPane com os botões Play/Stop/Next
        ImageIcon icon = new ImageIcon("./src/assets/music.png");
        JOptionPane.showOptionDialog(
                null,
                "Escolha uma ação:",
                "PlayMusic",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                icon,
                new Object[] { playStopButton, nextButton },
                playStopButton);

        // Fecha o clip de áudio ao encerrar o programa
        if (player.audioClip != null) {
            player.audioClip.close();
        }

    }

}
