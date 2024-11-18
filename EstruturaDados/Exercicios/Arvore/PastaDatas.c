#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct PastaDatas {
  char valor[11];
  struct PastaDatas *noDireito;
  struct PastaDatas *noEsquerdo;
} PastaDatas;

void adicionar(PastaDatas **raiz, const char *valor) {
  if (*raiz == NULL) {
    PastaDatas *novo = (PastaDatas *)malloc(sizeof(PastaDatas));
    strncpy(novo->valor, valor, 10);
    novo->valor[10] = '\0';
    novo->noDireito = NULL;
    novo->noEsquerdo = NULL;
    *raiz = novo;
  } else {
    if (strcmp(valor, (*raiz)->valor) > 0) {
      adicionar(&(*raiz)->noDireito, valor);
    } else {
      adicionar(&(*raiz)->noEsquerdo, valor);
    }
  }
}

void imprimir(PastaDatas *raiz) {
  if (raiz != NULL) {
    imprimir(raiz->noEsquerdo);
    printf("%s ", raiz->valor);
    imprimir(raiz->noDireito);
  }
}



int main() {

  PastaDatas *raiz = NULL;

  adicionar(&raiz, "2024-11");
  adicionar(&raiz, "2023-06");
  adicionar(&raiz, "2024-01");
  adicionar(&raiz, "2025-01");
  adicionar(&raiz, "2024-12");
  adicionar(&raiz, "2024-10");

  imprimir(raiz);

  return 0;
}