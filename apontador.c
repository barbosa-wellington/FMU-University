#include <stdio.h>
void main(void) {
  int x = 1, y = 2, z[5] = {-1, 0, 1, 2, 3}; /* Declaracao e inicializacao de 2 inteiros e um vetor de 10 inteiros */
  int *ip; /* ip eh um apontador para um inteiro (integer pointer) */

  fprintf(stderr, "debug x = %d, y = %d. Apontando ip para x...\n", x, y);
  ip = &x; /* ip agora aponta para o inteiro x. Como x = 1, então *ip = 1 (o valor de ip eh 1) */
  fprintf(stderr, "debug Apontado.  Agora ip = &x = %d. Y recebera o valor de ip...\n", *ip);

  y = *ip; /* y recebe o valor contido em ip */
  fprintf(stderr, "debug Atribuido. Agora y = *ip = %d\n", y);

  *ip = 0; /* Atribui o valor zero ao conteudo de ip. Como ip aponta para x, teremos x = 0 */
  fprintf(stderr, "debug Atribuido 0 ao conteudo de ip. Agora *ip = %d e x = %d\n", *ip, x);

  ip = &z[0]; /* ip agora aponta para o vetor z na posicao zero */
  fprintf(stderr, "debug Agora ip aponta para z[0]. Temos ip = %d e z[0] = %d\n", *ip, z[0]);
}
