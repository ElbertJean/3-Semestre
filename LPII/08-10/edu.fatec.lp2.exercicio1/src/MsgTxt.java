public class MsgTxt extends Mensagem{
    
    private int numChar;

    public MsgTxt (Contatinho destinatario, String horaEnvio, String conteudo, int numChar) {
        super(destinatario, horaEnvio, conteudo);
        this.numChar = numChar;
    }

    @Override
    public Mensagem sendMensagem (String mensagem) {
        this.conteudo = mensagem;
        System.out.println("Mensagem escrita: ... " + mensagem);
        return this;
    }

}
