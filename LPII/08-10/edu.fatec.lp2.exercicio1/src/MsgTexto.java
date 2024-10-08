public class MsgTexto extends Mensagem {
  
  private int numChar;

  public MsgTexto (Contatinho destinatario, String horaEnvio, String conteudo, int numChar){
    super(destinatario, horaEnvio, conteudo);
    this.numChar = numChar;
  }

  @Override
  public Mensagem sendMessage(String mensagem) {
    this.conteudo = mensagem;
    System.out.println("Enviando mensagem de texto: " + mensagem);
    return this;
  }

}
