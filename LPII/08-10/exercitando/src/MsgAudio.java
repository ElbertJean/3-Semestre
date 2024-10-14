public class MsgAudio extends Mensagem {
    
    private int duracao;

    public MsgAudio (Contatinho destinatario, String horaEnvio, String conteudo, int duracao) {
        super(destinatario, horaEnvio, conteudo);
        this.duracao = duracao;
    }

    @Override
    public Mensagem sendMensagem (String mensagem) {
        this.conteudo = mensagem;
        System.out.println(mensagem.toString());
        return this;
    }
}
