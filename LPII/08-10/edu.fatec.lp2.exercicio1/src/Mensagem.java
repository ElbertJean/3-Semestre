abstract public class Mensagem {
  
  protected Contatinho destinatario;
  protected String horaEnvio;
  protected String conteudo;

  public Mensagem (Contatinho destinatario, String horaEnvio, String conteudo) {
    this.destinatario = destinatario;
    this.horaEnvio = horaEnvio;
    this.conteudo = conteudo;
  }

  protected abstract Mensagem sendMessage(String mensagem);

  @Override
  public String toString() {
    return "Destinatario: " + destinatario.getNome() + ", Hora: " + horaEnvio + ", Mensagem: " + conteudo;
  }

}
