public class MsgFoto extends Mensagem{
    
    private int tamanho;

    public MsgFoto (Contatinho destinatario, String horaEnvio, String conteudo, int tamanho) {
        super(destinatario, horaEnvio, conteudo);
        this.tamanho = tamanho;
    }

    @Override
    public Mensagem sendMensagem (String mensagem) {
        this.conteudo = mensagem;
        System.out.println(mensagem.toString());
        return this;
    }

}
