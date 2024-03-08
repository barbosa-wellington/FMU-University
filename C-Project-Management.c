#include <stdio.h> 
#include <conio.h> 
#include <stdlib.h> 
int main() { 
 int lanc,opcao,n1,d,sal_func,a,sam,ff,aa; 
 float total,lanc_vlr,c,inss,irrf,vt,imp,nfimp,nf,y,z; 
  
 char opcao_escolha,nome_func; 
 d = 0; 
 c = 0; 
 a = 0; 
  
 printf ("Por favor escolha uma das opcoes a abaixo\n"); 
 printf ("F para financeiro\n"); 
 printf ("R para recursos humanos\n"); 
 printf ("D para desenvolvimento organizacional\n"); 
 printf ("T tecnologia da informacao\n"); 
 printf ("C para contas a pagar\n"); 
 scanf ("%c", &opcao_escolha); 
 switch (opcao_escolha) 
 { 
   case 'F' :  
   printf ("Digite a quantidade de lancamentos efetuados"); 
   scanf ("%d", &lanc); 
   while (d < lanc){ 
    printf ("Digite o valor em reais:   "); 
    scanf ("%f", &lanc_vlr); 
    c = c + lanc_vlr; 
    d = d + 1; 
   } 
  printf ("O Valor total dos lancamentos e: %f \n",c); 
  printf ("Escolha uma opera� para fazer com os lancamentos"); 
  printf ("\n 1. SOMAR \n"); 
  printf ("\n 2. SUBTRAIR \n"); 
  printf ("\n 3. DIVIDIR \n"); 
  printf ("\n 4. MULTIPLICAR \n"); 
  printf ("\n 5. SAIR \n"); 
  scanf ("%d", &opcao); 
   if (opcao == 1) { 
    printf ("Digite o valor que sera somado aos lancamentos \n"); 
    scanf ("%d", &n1); 
    total = c + n1; 
    printf ("O Valor final do lancamento e\n"); 
    printf ("%f \n",total); 
   } 
   else if (opcao == 2) { 
    printf ("Digite o valor que ira subtrair os lancamentos \n"); 
    scanf ("%d", &n1); 
    total = c - n1; 
    printf ("O Valor final do lancamento e\n"); 
    printf ("%f \n",total); 
   } 
   else if (opcao == 3) { 
    printf ("Digite o valor que ira dividir aos lancamentos \n"); 
    scanf ("%d", &n1); 
    total = c / n1; 
    printf ("O Valor final do lancamento e\n"); 
    printf ("%f \n",total); 
   } 
   else if (opcao == 4) { 
    printf ("Digite o valor que sera multiplicado aos lancamentos \n"); 
    scanf ("%d", &n1); 
    total = c * n1; 
    printf ("O Valor final do lancamento e"); 
    printf ("%f \n",total); 
   } 
   else { 
    printf ("Obrigado"); 
   } 
  break; 
   case 'R' : 
    printf ("Digite o salario do funcionario: "); 
    scanf ("%d" ,&sal_func); 
   if (sal_func < 1318) { 
    inss = sal_func * 0.06; 
     }  
   else if (sal_func < 2196) { 
    inss = sal_func * 0.09; 
    } 
   else { 
    inss = sal_func * 0.11; 
     }  
    
   if (sal_func < 1904) { 
    printf ("Insento de IRRF\n"); 
    }  
   else if (sal_func < 2827) { 
    irrf = sal_func * 0.075; 
    } 
   else if (sal_func < 3752) { 
    irrf = sal_func * 0.15; 
    } 
   else if (sal_func < 4665) { 
    irrf = sal_func * 0.225; 
   }  
   else  
   { 
    irrf = sal_func * 0.275; 
   } 
   vt = sal_func * 0.06;  
   sal_func = sal_func - vt - irrf - inss; 
   printf ("\n O Salario do funcionario e %d \n",sal_func); 
   
   break; 
    
    
    case 'C' :  
   printf ("Digite a quantidade de lancamentos efetuados \n"); 
   scanf ("%d", &lanc); 
    
   printf ("Digite o percentual de imposto sobre as notas \n"); 
   scanf ("%d",imp); 
    
   while (lanc > d){ 
    printf ("Digite o valor em reais: \n" ); 
    scanf ("%f", & lanc_vlr); 
    a = a + lanc_vlr; 
    d = d + 1; 
      nfimp = lanc_vlr*(lanc_vlr*imp)/100; 
   } 
   break; 
    
    
           
     sam = 0;        
      
          case 'T' : 
           printf ("Digite 1 para chamados e 2 para calculo de investimento por profissional contratado \n"); 
           scanf ("%d",& sam); 
            
           if (sam == 1){ 
           printf ("Digite a quantidade de chamados abertos \n"); 
           scanf ("%d", & aa); 
            
            printf("Digite a quantidade de funcionarios \n"); 
            scanf ("%d", &ff); 
           y = ff / aa; 
           printf("O calculo de chamados e de: %f \n ", y); 
           
           }else{ 
            printf ("Digite o valor em reais que sera investido: \n"); 
            scanf ("%d", & aa); 
            printf ("Digite o numero de funcioanrios: \n"); 
            scanf ("%d", & ff); 
             
           y = aa / ff; 
     printf ("O valor investido por funcioanrio e de: %f \n", y);  
             
     } 
     break; 
      
     sam = 0; 
      
     case 'D': 
       
      printf ("Digite 1 para admissoes e desligamentos e 2 para TurnOnver (calculo dos funcionarios desligados) \n"); 
      scanf ("%d",& sam); 
       
      if (sam == 1){ 
       printf("Digite o total de pessoas contratadas: \n"); 
       scanf ("%d", &aa); 
       printf("Digite o total de pessoas desligadas: \n"); 
       scanf ("%d", &ff); 
       printf("Digite o total de funcioanrios da empresa: \n"); 
       scanf ("%d", & vt); 
        
       y = (aa + ff) /2; 
       z = ((y /vt) *100); 
        
       printf ("O Calculo de admissoes e desligamentos e: %d \n ", z); 
                     
      }else{ 
       printf ("Digite o total de funcionarios desligados: \n"); 
       scanf ("%d", & aa); 
       printf ("Digite o total de funcionarios da empresa: \n"); 
       scanf ("%d", & ff); 
       y = (ff / aa); 
       y = y*100; 
        printf ("O calculo de Turnonver e: %f", y); 

} 
 system ("pause"); 
  
} 
} 