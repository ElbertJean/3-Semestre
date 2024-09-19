#include <stdio.h>
#include <stdlib.h>

typedef struct Paciente {
    int id;
    struct Paciente *proximo;
} Paciente;

void enfileiraPaciente(int id, Paciente **comeco, Paciente **fim) {
    Paciente *novo = malloc(sizeof(Paciente));
    if (novo == NULL) {
        printf("Erro de alocação do nó.\n");
    } else {
        novo->id = id;
        novo->proximo = NULL;
        if (*comeco == NULL) {
            *comeco = novo;
        } else {
            (*fim)->proximo = novo;
        }
        *fim = novo;
    }
}

int desenfileiraPaciente(Paciente **comeco, Paciente **fim) {
    Paciente *auxiliar = *comeco;
    int lixo;
    if (auxiliar != NULL) {
        *comeco = auxiliar->proximo;
        lixo = auxiliar->id;
        auxiliar->proximo = NULL;
        free(auxiliar);
        if (*comeco == NULL) {
            *fim = NULL;
        }
        return lixo;
    } else {
        printf("Fila vazia\n");
        return -1;
    }
}

void imprimeFilaPacientes(Paciente **comeco) {
    Paciente *paciente = *comeco;
    if (paciente != NULL) {
        while (paciente != NULL) {
            printf("ID: %d", paciente->id);
            paciente = paciente->proximo;
        }
    } else {
        printf("Fila vazia\n");
    }
}

int main() {
    Paciente *comeco = NULL;
    Paciente *fim = NULL;
    int opcao, id;

    do {
        printf("Escolha uma opção:\n");
        printf("1. Adicionar paciente na fila\n");
        printf("2. Atender próximo paciente\n");
        printf("3. Imprimir fila de pacientes\n");
        printf("4. Sair\n");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                printf("Digite o ID do paciente: ");
                scanf("%d", &id);
                enfileiraPaciente(id, &comeco, &fim);
                printf("Paciente adicionado na fila.\n");
                break;
            case 2: {
                int pacienteId = desenfileiraPaciente(&comeco, &fim);
                if (pacienteId != -1) {
                    printf("Paciente com ID %d atendido.\n", pacienteId);
                }
                else{
                    printf("Sem paciente para atender.\n");
                }
                break;
            }
            case 3:
                imprimeFilaPacientes(&comeco);
                break;
            case 4:
                printf("Saindo...\n");
                break;
            default:
                printf("Opção inválida. Tente novamente.\n");
                break;
        }

        printf("\n");
    } while (opcao != 4);

    return 0;
}