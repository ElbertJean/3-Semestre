import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número máximo de alunos da turma: ");
        int maxAlunos = sc.nextInt();
        Turma turma = new Turma(maxAlunos);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n****** FATEC SJC ******");
            System.out.println("1. Incluir Aluno");
            System.out.println("2. Alterar Aluno");
            System.out.println("3. Consultar por Nome");
            System.out.println("4. Consultar por Matrícula");
            System.out.println("5. Excluir Aluno");
            System.out.println("6. Imprimir Lista de Alunos");
            System.out.println("0. Sair");
            System.out.println("***********************\n");
            System.out.print("Escolha uma opção: \n");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (turma.validarMatricula(leMatricula(sc))) {
                        System.out.println("Aluno já registrado neste número de matricula!");
                    } else {
                        System.out.print("Cadastrar aluno:\n");
                        System.out.print("Digite a matrícula: ");
                        String matricula = sc.nextLine();

                        System.out.print("Digite o nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Digite o curso: ");
                        String curso = sc.nextLine();

                        double[] notas = lerNotasEPesos(sc);
                        double[] pesos = lerPesos(sc);

                        Aluno aluno = new Aluno(matricula, nome, curso, notas, pesos);
                        turma.incluirAluno(aluno);
                    }
                    break;

                case 2:
                    System.out.print("Digite a matrícula do aluno a ser alterado: ");
                    String matriculaAlterar = sc.nextLine();
                    if (turma.validarMatricula(matriculaAlterar)) {
                        System.out.print("Digite o novo nome: ");
                        String novoNome = sc.nextLine();
                        System.out.print("Digite o novo curso: ");
                        String novoCurso = sc.nextLine();
                        double[] novasNotas = lerNotasEPesos(sc);
                        turma.alterarAluno(matriculaAlterar, novoNome, novoCurso, novasNotas);
                    } else {
                        System.out.println("Matrícula não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do aluno: ");
                    String nomeConsulta = sc.nextLine();
                    Aluno alunoPorNome = turma.buscarPorNome(nomeConsulta);
                    if (alunoPorNome != null) {
                        System.out.println(alunoPorNome);
                    }
                    break;

                case 4:
                    System.out.print("Digite a matrícula do aluno: ");
                    String matriculaConsulta = sc.nextLine();
                    Aluno alunoPorMatricula = turma.buscarPorMatricula(matriculaConsulta);
                    if (alunoPorMatricula != null) {
                        System.out.println(alunoPorMatricula);
                    } else {
                        System.out.println("Matrícula não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Digite a matricula do aluno a ser excluído: ");
                    String matriculaExcluir = sc.nextLine();
                    turma.excluirAluno(matriculaExcluir);
                    break;

                case 6:
                    turma.imprimirAlunos();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        sc.close();
    }

    public static double[] lerNotasEPesos(Scanner sc) {
        double[] notas = new double[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite a nota da prova " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();
        }
        sc.nextLine();
        return notas;
    }

    public static double[] lerPesos(Scanner sc) {
        double[] pesos = new double[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o peso da prova " + (i + 1) + ": ");
            pesos[i] = sc.nextDouble();
        }
        sc.nextLine();
        return pesos;
    }

    public static String leMatricula(Scanner sc) {
        System.out.print("Verificar o número da matricula: ");
        return sc.nextLine();
    }
}
