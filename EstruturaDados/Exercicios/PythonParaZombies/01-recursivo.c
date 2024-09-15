#include <stdio.h>

int fatorial(int n) {
  if (n <=1) return 1;
  return n * fatorial(n-1);
}

int pot(int base, int expoente) {
  if (expoente == 0) return 1;
  return base * pot(base, expoente-1);
}

int main () {
  int respostaFatorial = fatorial(4);
  printf("%i\n", respostaFatorial);

  int respostaPot = pot(4, 3);
  printf("%i\n", respostaPot);

  return 0;
}