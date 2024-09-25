#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Fila {
  char valor[50];
  struct Fila *prox;
} Fila;

void adicionar(Fila **primeiro, Fila **ultimo, char valor[50]) {
  Fila *novo = (Fila *) malloc(sizeof(Fila));
  
  strcpy(novo->valor, valor);
  novo->prox = NULL;

  if (*primeiro == NULL) {
    *primeiro = novo;
    *ultimo = novo;
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

void imprimir(Fila *primeiro) {
  Fila *aux = primeiro;
  if (aux != NULL) {
    while (aux != NULL) {
      printf("%s\n", aux->valor);
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

  adicionar(&primeiro, &ultimo, "Sign of the Cross");
  adicionar(&primeiro, &ultimo, "Look for the Truth");
  adicionar(&primeiro, &ultimo, "Man of the Edge");
  adicionar(&primeiro, &ultimo, "Fortunes of War");
  adicionar(&primeiro, &ultimo, "Look for the truth");

  printf("Fila atual:\n");
  imprimir(primeiro);

  remover(&primeiro, &ultimo);
  remover(&primeiro, &ultimo);
  
  printf("Fila após remoção:\n");
  imprimir(primeiro);

  return 0;
}
