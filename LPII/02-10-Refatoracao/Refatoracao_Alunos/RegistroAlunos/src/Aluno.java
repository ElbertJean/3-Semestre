import java.util.ArrayList;

public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private ArrayList<Double> notas;
    private ArrayList<Double> pesos;

    public Aluno(String matricula, String nome, String curso, ArrayList<Double> notas, ArrayList<Double> pesos) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
        this.notas = notas;
        this.pesos = pesos;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public double calcularMedia() {
        double somaNotas = 0;
        double somaPesos = 0;
        for (int i = 0; i < notas.size(); i++) {
            somaNotas += notas.get(i) * pesos.get(i);
            somaPesos += pesos.get(i);
        }
        return somaNotas / somaPesos;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Nome: " + nome + ", Curso: " + curso + ", Média: " + calcularMedia();
    }
}
