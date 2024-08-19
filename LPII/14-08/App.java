public class App {

    private int a = 1;

    public void setA(int value) {
        this.a = value;
    }

    public static void main(String[] args) {

        App app = new App();

        app.setA(10);

        System.out.println(app.a);
    }
}
