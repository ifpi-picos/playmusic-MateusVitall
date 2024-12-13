package dominio;

public class musica {
   private String nome;
   private String genero;
   private String arquivoAudio;
   private int duracao;

  //Retorna o valor atribuido a 'nome'
  public String getNome(){
    return nome;
 }
  //Atribui um valor a 'nome'
   public void setNome(String nome){
    this.nome = nome;
 }
  //Retorna o valor atribuido a 'genero'
   public String getGenero(){
    return genero;
 }
  //Atribui um valor a 'genero'
   public void setGenero(String genero){
    this.genero = genero;
 }
  //Retorna o valor atribuido a 'arquivoAudio'
   public String getArquivoAudio(){
    return arquivoAudio;
 }
  //Atribui um valor a 'arquivoAudio'
   public void setArquivoAudio(String arquivoAudio){
    this.arquivoAudio = arquivoAudio;
 }
  //Retorna o valor atribuido a 'duracao'
   public int getDuracao(){
    return duracao;
 }
  //Atribui um valor a 'duracao'
   public void setDuração(int duracao){
    this.duracao = duracao;
 }
 
 
}
