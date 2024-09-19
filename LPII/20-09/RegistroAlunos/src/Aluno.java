public class Aluno {
  private String matricula;
  private String nome;
  private String curso;
  private double[] notas;
  private double[] pesos;

  public Aluno(String matricula, String nome, String curso, double[] notas, double[] pesos) {
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

  public double[] getNotas() {
    return notas;
  }

  public void setNotas(double[] notas) {
    this.notas = notas;
  }

  public double calcularMedia() {
    double somaNotas = 0;
    double somaPesos = 0;
    for (int i = 0; i < notas.length; i++) {
      somaNotas += notas[i] * pesos[i];
      somaPesos += pesos[i];
    }
    return somaNotas / somaPesos;
  }

  @Override
  public String toString() {
    return "Matrícula: " + matricula + ", Nome: " + nome + ", Curso: " + curso + ", Média: " + calcularMedia();
  }
}
