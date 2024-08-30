#include <stdio.h>

int main() {

  int x = 10;
  
  int *ponteiro;
  ponteiro = &x;
  *ponteiro = 20;
  x = 15;
  printf("Endereço do ponteiro = %d\n", ponteiro);
  printf("Valor do ponteiro = %d\n", *ponteiro);

  printf("Valor do X = %d\n", x);
  printf("Endereço do X = %d\n", &x);
  return 0;
}