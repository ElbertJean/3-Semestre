#include <stdio.h>

int main() {

  int x = 10;
  double y = 20.5;
  char z = 'a';
  
  int *pX = &x;
  double *pY = &y;
  char *pZ = &z;
  
  printf("Endereco de x = %i - Valor de x = %i\n", pX, *pX);
  printf("Endereco de y = %d - Valor de y = %f\n", pY, *pY);
  printf("Endereco de z = %i - Valor de z = %c\n", pZ, *pZ);

  return 0;
}