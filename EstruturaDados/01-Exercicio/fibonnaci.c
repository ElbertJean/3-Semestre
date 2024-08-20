#include <stdio.h>

int fibbonaci(int n) {
    if (n == 0 || n ==1) {
        return n;
    } else {
        return fibbonaci(n-1) * n + fibbonaci(n-2);
    }
}

int main() {
    printf("%d\n", fibbonaci(6));
    return 0;
}