abstract public class Mensagem {
    
    protected Contatinho destinatario;
    protected String horaEnvio;
    protected String conteudo;

    public Mensagem (Contatinho destinatario, String horaEnvio, String conteudo) {
        this.destinatario = destinatario;
        this.horaEnvio = horaEnvio;
        this.conteudo = conteudo;
    }

    public abstract Mensagem sendMensagem(String mensagem);

    @Override
    public String toString() {
        return "Destinatario: " + destinatario + ", Hora de Envio: " + horaEnvio + ", Conteudo: " + conteudo;
    }

}
