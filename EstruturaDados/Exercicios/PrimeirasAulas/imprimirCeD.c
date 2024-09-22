#include <stdio.h>

int imprimiCrescente(int n) {
    if (n == 1) {
        printf("1");
    } else {
        imprimiDecrecente(n - 1);
        printf("T");
    }
}

int imprimiDecrecente(int n) {
    if (n == 1) {
        printf("1");
    } else {
        printf("T");
        imprimiDecrecente(n - 1);
    }
}

int main() {
    imprimiDecrecente(5);
    return 0;

    int b = 6;
    int *p = &b;

    printf("%d", *p);
}