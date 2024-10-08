import java.util.ArrayList;

public class Turma {
  private ArrayList<Aluno> alunos;
  private int maxAlunos;

  public Turma(int maxAlunos) {
    this.alunos = new ArrayList<>();
    this.maxAlunos = maxAlunos;
  }

  public boolean incluirAluno(Aluno aluno) {
    if (alunos.size() >= maxAlunos) {
      System.out.println("Turma cheia, não é possível adicionar mais alunos.");
      return false;
    }
    if (buscarPorMatricula(aluno.getMatricula()) != null) {
      System.out.println("Aluno com a matrícula " + aluno.getMatricula() + " já existe.");
      return false;
    }
    alunos.add(aluno);
    System.out.println("Aluno incluído com sucesso.");
    return true;
  }

  public void alterarAluno(String matricula, String novoNome, String novoCurso, ArrayList<Double> novasNotas) {
    Aluno aluno = buscarPorMatricula(matricula);
    if (aluno != null) {
      aluno.setNome(novoNome);
      aluno.setCurso(novoCurso);
      aluno.setNotas(novasNotas);
      System.out.println("Dados do aluno atualizados.");
    } else {
      System.out.println("Aluno não encontrado.");
    }
  }

  public Aluno buscarPorNome(String nome) {
    for (Aluno aluno : alunos) {
      if (aluno.getNome().equalsIgnoreCase(nome)) {
        return aluno;
      }
    }
    System.out.println("Aluno com o nome " + nome + " não encontrado.");
    return null;
  }

  public Aluno buscarPorMatricula(String matricula) {
    for (Aluno aluno : alunos) {
      if (aluno.getMatricula().equals(matricula)) {
        return aluno;
      }
    }
    return null;
  }

  public void excluirAluno(String matricula) {
    Aluno aluno = buscarPorMatricula(matricula);
    if (aluno != null) {
      alunos.remove(aluno);
      System.out.println("Aluno removido com sucesso.");
    } else {
      System.out.println("Aluno com a matrícula " + matricula + " não encontrado.");
    }
  }

  public void imprimirAlunos() {
    if (alunos.isEmpty()) {
      System.out.println("Nenhum aluno registrado.");
    } else {
      for (Aluno aluno : alunos) {
        System.out.println(aluno.toString());
      }
    }
  }

  public boolean validarMatricula(String matricula) {
    return buscarPorMatricula(matricula) != null;
  }
}
