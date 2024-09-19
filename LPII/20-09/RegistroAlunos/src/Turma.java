public class Turma {
  private Aluno[] alunos;
  private int totalAlunos;

  public Turma(int maxAlunos) {
    alunos = new Aluno[maxAlunos];
    totalAlunos = 0;
  }

  public boolean incluirAluno(Aluno aluno) {
    if (totalAlunos >= alunos.length) {
      System.out.println("Turma cheia, não é possível adicionar mais alunos.");
      return false;
    } else {
      System.out.println("Aluno incluído com sucesso.");
    }
    if (buscarPorMatricula(aluno.getMatricula()) != null) {
      System.out.println("Aluno com a matrícula " + aluno.getMatricula() + " já existe.");
      return false;
    }
    alunos[totalAlunos] = aluno;
    totalAlunos++;
    return true;
  }

  public void alterarAluno(String matricula, String novoNome, String novoCurso, double[] novasNotas) {
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
    for (int i = 0; i < totalAlunos; i++) {
      if (alunos[i].getNome().equalsIgnoreCase(nome)) {
        return alunos[i];
      }
    }
    System.out.println("Aluno com o nome " + nome + " não encontrado.");
    return null;
  }

  public Aluno buscarPorMatricula(String matricula) {
    for (int i = 0; i < totalAlunos; i++) {
      if (alunos[i].getMatricula().equals(matricula)) {
        return alunos[i];
      }
    }
    return null;
  }

  public void excluirAluno(String matricula) {
    for (int i = 0; i < totalAlunos; i++) {
      if (alunos[i].getMatricula().equalsIgnoreCase(matricula)) {
        for (int j = i; j < totalAlunos - 1; j++) {
          alunos[j] = alunos[j + 1];
        }
        alunos[totalAlunos - 1] = null;
        totalAlunos--;
        System.out.println("Aluno removido com sucesso.");
        return;
      }
    }
    System.out.println("Aluno com a matricula " + matricula + " não encontrado.");
  }

  public void imprimirAlunos() {
    if (totalAlunos == 0) {
      System.out.println("Nenhum aluno registrado.");
    } else {
      for (int i = 0; i < totalAlunos; i++) {
        System.out.println(alunos[i].toString());
      }
    }
  }

  public boolean validarMatricula(String matricula) {
    return buscarPorMatricula(matricula) != null;
  }
}
