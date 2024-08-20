#include <stdio.h>

int imprimir1aN(int n) {
    if (n == 1) {
        printf("1");
    } else {
        imprimir1aN(n - 1);
        printf("T");
    }
}

int main() {
    imprimir1aN(5);
    return 0;
}