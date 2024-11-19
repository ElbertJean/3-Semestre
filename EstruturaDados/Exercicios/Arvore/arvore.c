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

Arvore **buscar(Arvore **raiz, int valor) {
    if (*raiz == NULL) return NULL;

    if (valor == (*raiz)->valor) {
        return raiz;
    } else if (valor < (*raiz)->valor) {
        return buscar(&(*raiz)->noEsquerdo, valor);
    } else {
        return buscar(&(*raiz)->noDireito, valor);
    }
}

int remover(Arvore **no) {
    if (*no == NULL) return -1;

    int valorRemovido = (*no)->valor;

    if ((*no)->noEsquerdo == NULL && (*no)->noDireito == NULL) {
        free(*no);
        *no = NULL;
    } else if ((*no)->noDireito == NULL) {
        Arvore *temp = (*no)->noEsquerdo;
        free(*no);
        *no = temp;
    } else if ((*no)->noEsquerdo == NULL) {
        Arvore *temp = (*no)->noDireito;
        free(*no);
        *no = temp;
    } else {
        Arvore **maior = &(*no)->noEsquerdo;
        Arvore **paiMaior = NULL;

        while ((*maior)->noDireito != NULL) {
            paiMaior = maior;
            maior = &(*maior)->noDireito;
        }

        Arvore *temp = *maior;

        if (paiMaior != NULL) {
            (*paiMaior)->noDireito = temp->noEsquerdo;
        } else {
            (*no)->noEsquerdo = temp->noEsquerdo;
        }

        temp->noEsquerdo = (*no)->noEsquerdo;
        temp->noDireito = (*no)->noDireito;

        free(*no);
        *no = temp;
    }

    return valorRemovido;
}


int main() {
    Arvore *raiz = NULL;

    adicionar(&raiz, 30);
    adicionar(&raiz, 15);
    adicionar(&raiz, 20);
    adicionar(&raiz, 25);
    adicionar(&raiz, 22);
    adicionar(&raiz, 54);
    adicionar(&raiz, 37);
    adicionar(&raiz, 45);
    adicionar(&raiz, 57);

    printf("Árvore inicial:\n");
    imprimir(raiz);
    printf("\n");

    printf("Valor removido: %d\n", remover(buscar(&raiz, 30)));

    printf("Árvore após remover:\n");
    imprimir(raiz);

    return 0;
}
