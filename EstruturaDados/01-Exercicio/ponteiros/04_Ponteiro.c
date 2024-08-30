#include <stdio.h>

int main(void) {
  struct horario {
    int hora;
    int minuto;
    int segundo;
  };
  
  struct horario h, *depois;
  depois = &h;

  // pode se chamar assim ou da maneira abaixo
  depois->hora = 10;
  depois->minuto = 20;
  depois->segundo = 30;

  // *depois->hora = 10;
  // *depois->minuto = 20;
  // *depois->segundo = 30;
  
  printf("%d:%d:%d\n", depois->hora, depois->minuto, depois->segundo);
  
  return 0;  
}