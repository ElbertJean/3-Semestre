#include <stdio.h>
#include <stdlib.h>

typedef struct Arvore {
    int valor;
    struct Arvore *noDireito;
    struct Arvore *noEsquerdo;
} Arvore;

void adicionar(Arvore **raiz, int valor) {
    if (*raiz == NULL) {
        Arvore *novo = (Arvore *)malloc(sizeof(Arvore));
        novo->valor = valor;
        novo->noDireito = NULL;
        novo->noEsquerdo = NULL;
        *raiz = novo;
    } else {
        if (valor > (*raiz)->valor) {                // Como estou chamando o ponteiro com ** no params, preciso chamar o ponteiro com *
            adicionar(&(*raiz)->noDireito, valor);   // endereçamento do ponteiro direito
        } else {
            adicionar(&(*raiz)->noEsquerdo, valor);  // endereçamento do ponteiro esquerdo
        }
    }
}

void imprimir(Arvore *raiz) {
    if (raiz != NULL) {
        imprimir(raiz->noEsquerdo);
        printf("%d ", raiz->valor);
        imprimir(raiz->noDireito);
    }
}

int main() {

    Arvore *raiz = NULL;

    adicionar(&raiz, 10);
    adicionar(&raiz, 7);
    adicionar(&raiz, 20);
    adicionar(&raiz, 2);
    adicionar(&raiz, 15);
    adicionar(&raiz, 5);

    imprimir(raiz);

    return 0;
}