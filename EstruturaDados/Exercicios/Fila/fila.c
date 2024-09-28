#include <stdio.h>
#include <stdlib.h>

typedef struct Fila {
    int valor;
    struct Fila *proximo;
} Fila;

void adicionar(Fila **primeiro, Fila **ultimo, int valor) {
    Fila *novo = (Fila *) malloc(sizeof(Fila));
    novo->valor = valor;
    novo->proximo = NULL;
    if (*primeiro == NULL) {
        *primeiro = novo;
        *ultimo = novo;
        return;
    }
    (*ultimo)->proximo = novo;
    *ultimo = novo;
}

void imprimir(Fila **primeiro) {
    Fila *no = *primeiro;
    if (no != NULL) {
        while (no != NULL) {
            printf("%d\n", no->valor);
            no = no->proximo;
        }
    } else {
        printf("A fila está vazia");
    }
    printf("\n");
}

int remover(Fila **primeiro, Fila **ultimo) {
    int retornar;
    Fila *remover = *primeiro;
    if (remover == NULL) {
        *ultimo == NULL;
    }
    *primeiro = remover->proximo;
    retornar = remover->valor;
    free(remover);
    return retornar;
}

int main() {
    Fila *primeiro = NULL;
    Fila *ultimo = NULL;

    adicionar(&primeiro, &ultimo, 1);
    adicionar(&primeiro, &ultimo, 2);
    adicionar(&primeiro, &ultimo, 3);
    // adicionar(&primeiro, &ultimo, 4);
    // adicionar(&primeiro, &ultimo, 5);
    // adicionar(&primeiro, &ultimo, 6);
    // adicionar(&primeiro, &ultimo, 7);
    // imprimir(&primeiro);
    printf("%d\n", remover(&primeiro, &ultimo));
    // printf("%d\n", teste);
    // printf(&primeiro, &ultimo);
    // remover(&primeiro, &ultimo);
    // imprimir(&primeiro);
}