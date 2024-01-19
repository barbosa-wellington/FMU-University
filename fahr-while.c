#include <stdio.h>

void main(void) {
  #define INICIO 0
  #define FIM  300
  float fahr = INICIO, celsius;
  int incr = 20;

  printf ("Fahrenheit\tCelsius\n");
  while (fahr <= FIM) {
    celsius = (5.0/9.0) * (fahr - 32.0);
    printf ("  %3.0f\t\t%6.1f\n", fahr, celsius);
    fahr = fahr + incr;
  }
}
