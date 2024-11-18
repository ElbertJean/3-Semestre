#include <stdio.h>
#include <stdlib.h>

typedef struct Fila {
  int valor;
  struct Fila *proximo
} Fila;

void adicionarNaFila(Fila **primeiro, Fila **ultimo, int valor) {
  Fila *novoValor = (Fila*)malloc(sizeof(Fila));
  novoValor->valor = valor;
  novoValor->proximo = NULL;
  if (*primeiro == NULL ) {
    *primeiro = novoValor;
    *ultimo = novoValor;
    return;
  }
  (*ultimo)->proximo = novoValor;
  *ultimo = novoValor;
}

void retirarDaFila(Fila **primeiro, Fila **ultimo) {
  if (*primeiro == NULL) {
    *ultimo = NULL;
  }
  Fila *retirar = *primeiro;
  *primeiro = retirar->proximo;
  free(retirar); 
}

void imprimir(Fila **primeiro) {
  Fila *no = *primeiro;
  if (no != NULL) {
    while(no != NULL) {
      printf("%d\n", no->valor);
      no = no->proximo;
    }
  } else {
    printf("Lista vazia");
  }
  printf("\n");
  free(no);
}

int main() {
  Fila *primeiro = NULL;
  Fila *ultimo= NULL;

  adicionarNaFila(&primeiro, &ultimo, 5);
  adicionarNaFila(&primeiro, &ultimo, 7);
  adicionarNaFila(&primeiro, &ultimo, 10);
  adicionarNaFila(&primeiro, &ultimo, 22);
  imprimir(&primeiro);
  retirarDaFila(&primeiro, &ultimo);
  retirarDaFila(&primeiro, &ultimo);
  retirarDaFila(&primeiro, &ultimo);
  retirarDaFila(&primeiro, &ultimo);
  imprimir(&primeiro);
}