#include <stdio.h>

int fibbonaci(int n) {
    if (n <= 2) {
        return 1;
    } else {
        return fibbonaci(n-1) + fibbonaci(n-2);
    }
}

int main() {
    printf("%d\n", fibbonaci(5));
    return 0;
}