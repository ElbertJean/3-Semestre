import java.util.ArrayList;
import java.util.List;

public class WhatsApp {
  
  private List<Contatinho> contatos;
  private List<Mensagem> mensagens;

  public WhatsApp() {
    this.contatos = new ArrayList<>();
    this.mensagens = new ArrayList<>();
  }

  public void adicionarContato(Contatinho contato) {
    contatos.add(contato);
  }

  public void verContatos() {
    contatos.forEach(contato -> System.out.println(contato.toString()));
  }

  public void adicionarMensagem(Mensagem mensagem) {
    mensagens.add(mensagem);
  }

  public void verMensagem() {
    mensagens.forEach(mensagem -> System.out.println(mensagem));
  }

}
