#include <stdio.h>
#include <stdlib.h>

typedef struct Fila {
  int valor;
  struct Fila *prox;
} Fila;

void adicionar (Fila **primeiro, Fila **ultimo, int valor) {
  Fila *novo = (Fila *) malloc(sizeof(Fila));
  novo->valor = valor;
  novo->prox = NULL;
  if (*primeiro == NULL) {
    *primeiro = novo;
    *ultimo = novo;
    return;
  }
  (*ultimo)->prox = novo;
  *ultimo = novo;
}

void remover(Fila **primeiro, Fila **ultimo) {
  Fila *aux = *primeiro;
  if (aux != NULL) {
    *primeiro = aux->prox;
    free(aux);
    if (*primeiro == NULL) {
      *ultimo = NULL;
    }
  } else {
    printf("Fila vazia\n");
  }
}

void imprimir (Fila *primeiro) {
  Fila *aux = primeiro;
  if (aux != NULL) {
    while (aux != NULL) {
      printf("%d\n", aux->valor);
      aux = aux->prox;
    }
  } else {
    printf("Fila vazia\n");
  }
  printf("\n");
}

int main() {
  Fila *primeiro = NULL;
  Fila *ultimo = NULL;

  // adicionar(&primeiro, &ultimo, 1);
  // adicionar(&primeiro, &ultimo, 2);
  // adicionar(&primeiro, &ultimo, 3);

  imprimir(primeiro);
  // remover(&primeiro, &ultimo);
  // imprimir(primeiro);
  return 0;
}