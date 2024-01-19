#include <stdio.h>

void main(void) {
  float fahr;

  printf ("Fahrenheit\tCelsius\n");
  for (fahr = 0; fahr <= 300; fahr += 20)
    printf ("  %3.0f\t\t%6.1f\n", fahr, (5.0/9.0) * (fahr - 32.0));
}
