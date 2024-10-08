public class App {

    public static void main(String[] args) {

        WhatsApp whatsapp = new WhatsApp();

        Contatinho contatinho = new Contatinho ("Elbert", "12 991231-1288");
        
        whatsapp.adicionarContato(contatinho);

        whatsapp.verContatos();

        MsgTexto msgTexto = new MsgTexto(contatinho, "12:00", "Ola, tudo bem?", 200);

        whatsapp.adicionarMensagem(msgTexto);

        whatsapp.verMensagem();
    }

}