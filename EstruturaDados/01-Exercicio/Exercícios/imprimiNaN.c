#include <stdio.h>

int imprimirNaN(int n) {
    printf("%d\n", n);
    if (n > 1) {
        printf("%d\n", n);
        imprimirNaN(n - 1);
    }
}

int main() {
    imprimirNaN(5);
    return 0;
}