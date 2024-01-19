#include <stdio.h>

void main(void) {
  #define INICIO 0
  #define FIM  300
  float fahr, celsius;
  int incr = 20;

  for (fahr = INICIO; fahr <= FIM; fahr = fahr + incr) {
    celsius = (5.0/9.0) * (fahr - 32.0);
    printf ("  %3.0f\t\t%6.1f\n", fahr, celsius);
    /* fahr = fahr + incr; */
  }
}
