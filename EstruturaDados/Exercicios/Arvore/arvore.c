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
        if (valor > (*raiz)->valor) {
            adicionar(&(*raiz)->noDireito, valor);
        } else {
            adicionar(&(*raiz)->noEsquerdo, valor);
        }
    }
}

void imprimir(Arvore *raiz) {
    if (raiz != NULL) {
        imprimir(raiz->noEsquerdo);
        printf("%d\n", raiz->valor);
        imprimir(raiz->noDireito);
    }
}

Arvore *encontrarMaior(Arvore *raiz) {
    while (raiz->noDireito != NULL) {
        raiz = raiz->noDireito;
    }
    return raiz;
}

int remover(Arvore **raiz, int valor) {
    if (*raiz == NULL) {
        printf("Valor %d não encontrado na árvore.\n", valor);
        return -1;
    }

    if (valor < (*raiz)->valor) {
        remover(&(*raiz)->noEsquerdo, valor);
    } else if (valor > (*raiz)->valor) {
        remover(&(*raiz)->noDireito, valor);
    } else {
        int valorRemovido = (*raiz)->valor; 
        Arvore *temp;
        if ((*raiz)->noEsquerdo == NULL && (*raiz)->noDireito == NULL) {
            free(*raiz);
            *raiz = NULL;
        } else if ((*raiz)->noDireito == NULL) {
            temp = (*raiz)->noEsquerdo;
            free(*raiz);
            *raiz = temp;
        } else if ((*raiz)->noEsquerdo == NULL) {
            temp = (*raiz)->noDireito;
            free(*raiz);
            *raiz = temp;
        } else {
            temp = encontrarMaior((*raiz)->noEsquerdo);
            (*raiz)->valor = temp->valor;
            remover(&(*raiz)->noEsquerdo, temp->valor);
        }
        return valorRemovido;
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

    printf("Árvore inicial:\n");
    imprimir(raiz);
    printf("\n");

    printf("Valor removido: %d\n", remover(&raiz, 10));
    remover(&raiz, 100);
    remover(&raiz, 15);
    remover(&raiz, 5);

    printf("Árvore após remoções:\n");
    imprimir(raiz);

    return 0;
}
