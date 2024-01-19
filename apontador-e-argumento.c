/* apontador-e-argumento.c: exemplo de uso de apontadores como argumento de funções */
#include <stdio.h>
/* X e Y mantem seus valores, pois a funcao troca trabalha com copia das variáveis a e b chamadas por main */
void trocaerrada(int x, int y) {
  int temp;
  temp = x;
  x = y;
  y = temp;
}

/* X e Y trocam de valor, pois a funcao troca trabalha com o endereço (apontador) das variáveis a e b chamadas por main. Notar o uso de *px, *py para referenciar o VALOR de a e b - sem isto teriamos erro de compilacao e logica incorreta (troca de endereço de px e py ao inves do valor referenciado) */
void trocacorreta(int *px, int *py) {
  int temp;
  temp = *px;
  *px = *py;
  *py = temp;
}

void main(void) {
  int a = 1, b = 2;
  
  fprintf(stdout, "Inicio: a=%d e b=%d\n", a, b);
  trocaerrada(a,b);
  fprintf(stderr, "debug Apos trocaerrada(a=%d, b=%d) retorna a=%d e b=%d - valores NAO foram trocados\n", a, b, a, b);
  trocacorreta(&a,&b);
  fprintf(stderr, "debug Apos trocacorreta(a=%d, b=%d) retorna a=%d e b=%d - valores FORAM trocados\n", a, b, a, b);
  fprintf(stdout, "Termino: a=%d e b=%d\n", a, b);
}
