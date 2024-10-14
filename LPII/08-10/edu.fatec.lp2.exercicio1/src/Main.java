public class Main {

    public static void main(String[] args) {

        Contatinho contatinho1 = new Contatinho ("Elbert", "12 99123-1288");
        Contatinho contatinho2 = new Contatinho ("Lailson", "12 98297-5192");

        MsgTxt msgTxt1 = new MsgTxt(contatinho1, "19:57", "I love do love ma little boy", 1);
        MsgAudio msgAudio1 = new MsgAudio(contatinho2, "20:02", "00:32 - Audio", 32);
        MsgFoto msgFoto1 = new MsgFoto(contatinho2, "20:06", "Foto de Lailson pescando um tucunaré", 100);
        msgTxt1.sendMensagem("outra mensagem");
        
        WhatsApp whatsapp = new WhatsApp();

        whatsapp.adicionarContato(contatinho1);
        whatsapp.adicionarContato(contatinho2);
        whatsapp.verContatos();

        whatsapp.adicionarMensagem(msgTxt1);
        whatsapp.adicionarMensagem(msgAudio1);
        whatsapp.adicionarMensagem(msgFoto1);
        whatsapp.verMensagens();

    }

}