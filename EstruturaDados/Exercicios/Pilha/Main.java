public class Main {
    
    public static void main(String[] args) {

        Playlist playlist = new Playlist();

        playlist.empilhar("Sign of the Cross");
        playlist.empilhar("Lord of the Flies");  
        playlist.empilhar("Fortunes of War");  
        playlist.empilhar("Look for the truth");  
        
        playlist.imprimir();

        System.out.println(playlist.desempilhar());

        System.out.println("\n");
        playlist.imprimir();
    }
}
