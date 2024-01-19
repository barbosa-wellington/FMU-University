#include <stdio.h>
#include <string.h>

/* impdec: imprime numero n em decimal em stdout */
void impdec (int n) {
  static int j=1;
  if (n < 0) { /* Se numero negativo, imprime o sinal e torna o numero em positivo */
    printf ("-");
    n = -n;
  }
  
  fprintf(stderr, "debug impdec(%5d) iniciada...\n", n);
  if (n / 10 != 0) /* "Enquanto (nao eh loop) n > 0, chama impdec recursivamente */
    impdec (n / 10);
  fprintf(stderr, "debug impdec execucao #%d finalizou e gravou %d em stdout\n", j++, n % 10);
  printf("%d", n % 10);
}

void main(int argc, char *argv[]) {
  /*int num=(int)argv[0];*/
  
  printf ("-%s-\n", argv[1]);

  /* scanf("Numero: ", &num); */
  impdec(atoi(argv[1]));
}
