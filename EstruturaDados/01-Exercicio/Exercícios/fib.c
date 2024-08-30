#include <stdio.h>

int Fib(int n) {
    if (n == 0 || n ==1) {
        return n;
    } else {
        return Fib(n-1) * n + Fib(n-2);
    }
}

int main() {
    printf("%d\n", Fib(6));
    return 0;
}