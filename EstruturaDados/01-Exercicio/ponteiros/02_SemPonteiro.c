#include <stdio.h>

int main() {

  int x = 10;
  int y = x;
  
  x = 20;

  printf("%i %i\n", x, y);
  return 0;
}