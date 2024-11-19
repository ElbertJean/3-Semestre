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
    Arvore *temp;
    if ((*no)->noEsquerdo == NULL && (*no)->noDireito == NULL) {
        free(*no);
        *no = NULL;
    } else if ((*no)->noDireito == NULL) {
        temp = (*no)->noEsquerdo;
        free(*no);
        *no = temp;
    } else if ((*no)->noEsquerdo == NULL) {
        temp = (*no)->noDireito;
        free(*no);
        *no = temp;
    } else {
        temp = encontrarMaior((*no)->noEsquerdo);
        int maiorValor = temp->valor;

        remover(buscar(&(*no)->noEsquerdo, maiorValor));

        (*no)->valor = maiorValor;
        
    }
    return valorRemovido;
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

    printf("Valor removido: %d\n", remover(buscar(&raiz, 10)));

    printf("Árvore após remover:\n");
    imprimir(raiz);

    return 0;
}


// aux = busca_pai(10)

// remove (aux->valor);