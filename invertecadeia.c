#include <stdio.h>
#include <string.h> /* funcao strlen */

void inverte (char s[]) {
  int c,i,j;
  for (i=0, j=strlen(s) - 1; i<j;i++,j--) {
    c = s[i];
    s[i] = s[j];
    s[j] = c;
    fprintf(stderr, "debug interacao i=%d, j=%d, c=%d, s[i=%d]=s[j=%d]=%d, s[j=%d]=c=%d\n", i, j, c-'0', i, j, s[i]-'0', j, c-'0');

  }
}

void main(int argc, char *argv[]) {
 if (argc <= 1)
  printf ("Uso: invertecadeia CADEIA_A_INVERTER\n");
 else {
   inverte(argv[1]);
   printf("%s\n", argv[1]);
  }
}
