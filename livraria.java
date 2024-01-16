import java.util.*;

public class livraria {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
			produto prod= new produto();//estancia a classe
			funcionario func = new funcionario();//estancia a classe
			compras requi = new compras();//estancia a classe
			vendas vend = new vendas();//estancia a classe
			cliente cli = new cliente();//estancia a classe
			fornecedor forn = new fornecedor();//estancia a classe
			int submenu;//variavel dos submenus
			
			
			Scanner sc = new Scanner(System.in);
			String resp;//variavel da resposta no final do programa
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			System.out.println("------------Digite o Login e Senha para acessar o Sistema------------");
			boolean l;
			do{//login e senha
				System.out.print("Usuario: " );
				String usuario1 = sc.next();
				
				System.out.print("Senha: ");
				String senha1 = sc.next();
			l = func.login(usuario1, senha1);//metodo que verifica se login e senha est�o corretos
			}while(l == false);//verifica se o usuario e senha esta correta, continua no la�o at� que seja true.
			
			
			do{//la�o do programa, finaliza nas linhas finais perguntando se o usuario deseja fazer outra opera��o 
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("Bem vindo! " + func.nome);//mensagem de boas vindas ao funcionario;
			
			System.out.println(" \n 1-FUNCIONARIOS, 2-PRODUTOS, 3-REQUISI��O, 4-VENDAS, 5-CLIENTE, 6-FORNECEDOR, 7-ADMINISTRATIVO, 8-SAIR");//itens do menu principal
			System.out.println(" \n OP��O: ");//mensagem de op��o
			int menuprincipal = sc.nextInt();//variavel que indica qual item do menu o usuario ser� redirecionado 
			if(menuprincipal <=0 || menuprincipal >=8)//filtro de informa��es invalidas
				System.out.println("digite um numero valido");//mensagem caso a op��o digitada for fora dos parametros
			
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			switch (menuprincipal){ //recebe o numero equivalente ao menu
			
			case 1: 
				//no modulo funcionario a op��o 1 representa o cadastro de novos funcionario, , nele � possivel
				//inserir nome, cpf, enredere�o, telefone, cargo, usuario e senha
					System.out.println("-------------FUNCIONARIOS--------------");
					System.out.println("1-CADASTRO DE FUNCIONARIOS, 2-SAIR");
					System.out.print("OP��O: ");
					submenu = sc.nextInt();
					
					switch (submenu){
					case 1:
				func.codfuncionario = ++func.codfuncionario;
				
				System.out.print("Nome: ");
				func.nome = sc.next();
				
				System.out.print("CPF: ");
				func.cpf = sc.nextLong();
				
				System.out.print("Endere�o: ");
				func.endereco = sc.next();
				
				System.out.print("Telefone: ");
				func.telefone = sc.nextInt();
				
				do{//� obrigat�rio que o funcionario tenha uma fun��o
				System.out.print("Cargo: 1-Vendedor, 2-Gerente,  ");
				func.cargo = sc.nextInt();
				}while(func.cargo <=0 ||func.cargo>2);//caso a op��o seja diferente ir� rodar at� a op��o ser v�lida
				
				System.out.print("Usuario: ");
				func.usuario = sc.next();
				
				System.out.print("Senha: ");
				String senha = sc.next();
				func.registrasenha(senha);
						
				break;
				case 2:break;//sai do modulo funcionario
				default: System.out.println("DIGITE UMA OP��O V�LIDA");	
					}
				break;//sai do la�o principal e pergunta se quer fazer alguma outra opera��o
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////// 
				
			case 2:
				//no modulo de produtos � possivel fazer o cadastro dos produtos, nele � possivel
				//inserir o nome, categoria, forncedor 
				System.out.println("-------------PRODUTOS--------------");
				System.out.println("1-CADASTRO DE PRODUTOS, 2-SAIR");
				int submenu2;
				
				System.out.print("OP��O: ");
				submenu2 = sc.nextInt();
						
						switch(submenu2){
						
						case 1:
						prod.codproduto = ++prod.codproduto;
						System.out.println("C�digo: " + prod.codproduto);
						
						System.out.print("Nome: ");
						prod.nome = sc.next();
						
						System.out.println("CATEGORIA: 1-Livros, 2-Papelaria,	3-Filmes,	4-M�sica,	5-Games");
						System.out.print("OP��O: ");
						prod.categoria = sc.nextInt();
						
						System.out.print("Fornecedor: ");
						prod.fornecedor = sc.next();
						
						
						case 2:break;//sai do modulo produtos
						default: System.out.println("DIGITE UMA OP��O V�LIDA");
						}
						break;//sai para o la�o principal
						
						//------------------------------------------------------------:
						//------------------------------------------------------------
						
					
						
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			case 3: 
			
			//na requisi��o de produtos � possivel solicitar produtos apenas se o
			//produto estiver cadastrado no sistema, caso o produto n�o esteja o sistema
			//sai para la�o principal, caso esteja cadastrado � possivel solicitar o produto, 
			//verificar a quantidade em estoque ap�s a compra, colocar o valor de compra, ver o total da compra,
			//caso tenha algum dado incompativel(exceto o codigo do produto), ser� solicitado que fa�a o cadastro do
			//recurso faltante, caso contrario a solicita��o � feita normalmente
				
			System.out.println("-------------REQUISI��O DE PRODUTOS--------------");
			System.out.println("1-SOLICITA��O, 2-SAIR");
			
			System.out.println("OP��O: ");
			
			int submenu3 = sc.nextInt();
			
			switch(submenu3){
			case 1:
			
			requi.numerodopedido = ++requi.numerodopedido;
			
			System.out.print("C�digo do produto: ");
			requi.codproduto = sc.nextInt();
			
			boolean b = prod.validacodigo(requi.codproduto);//verifica se o c�digo do produto � v�lido
			if(b==false){									//se n�o for v�lido sera exibida uma mensagem
				System.out.print("c�digo invalido");		//de erro e o numero do pedido sera zerado,
				requi.numerodopedido = 0;					//e o sistema voltara para o la�o principal
				break;
			}
			
			System.out.print("nome do fornecedor: ");
			requi.fornecedor = sc.next();	
			
			if(forn.verificafornecedor(requi.fornecedor)==false)//verifica se o forncedor existe
			{
				System.out.println("fornecedor n�o cadastrado, cadastrar novo fornecedor? S/N:  ");
				String resposta = sc.next();//se n�o existir o usuario podera cadastrar um novo fornecedor
											//ou sera cadastrado como fornecedor n�o cadastrado
						if(resposta.equals("s")||resposta.equals("S")){
						
						forn.codfornecedor = ++forn.codfornecedor;
							
						System.out.print("Nome do fornecedor");
						forn.nome = sc.next();
						requi.fornecedor = forn.nome;
						
						System.out.print("CNPJ DO FORNECEDOR: ");
						forn.cnpj =sc.nextLong();
						
						System.out.print("ENDERE�O DO FORNECEDOR: ");
						forn.endereco = sc.next();
						
						System.out.print("TELEFONE DO FORNECEDOR: ");
						forn.telefone = sc.nextInt();
						}
						else
						requi.fornecedor = "fornecedor_n�o_cadastrado";
			}
			
			
			System.out.print("Quantidade comprada: ");
			requi.qtdcomprada = sc.nextInt();
			prod.aumentaestoque(requi.qtdcomprada);//aumenta a quantidade em estoque
			
			System.out.print("valor por unidade: ");
			requi.valorunitario = sc.nextFloat();
			prod.valornacompra = requi.valorunitario;//atribui o valor de compra no produto
			
			requi.valortotalcompra = requi.qtdcomprada*requi.valorunitario;
			System.out.println("valor total da requisi��o: R$ "+ requi.valortotalcompra);//mostra o valor total da compra
			
			System.out.print("valor de venda: ");
			prod.valornavenda = sc.nextFloat();//atribui o valor de venda do produto
		 
			System.out.println("seu estoque � de: " + prod.qtddisponivel);//mostra o estoque disponivel
			
			case 2: break;//sai do modulo requisi��o
			
			default: System.out.println("DIGITE UMA OP��O V�LIDA");
			}
				break;//sai para o la�o principal
			
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////	
					
			case 4: 
				// Em vendas � verificado se o cliente � registrado ou n�o, caso n�o seja cadastrado,
				//ser� solicitado um cadastramento deste cliente, e tbm � verificado se o endere�o de entrega
				//confere com o endere�o do cliente, caso n�o bata, � solocitado um cadastro de endere�o,
				//tbm � verificado se o codigo do produto � valido, caso n�o seja o pedido ser� cancelado
				//al�m disso � verificado a quantidade em estoque e a quantidade solicitada para venda,
				//caso seja incompativel ser� emitido um alerta de que o estoque n�o � suficiente,
				//o calculo dos itens comprados s�o feitos automaticamente
			System.out.println("-------------VENDAS--------------");
			System.out.println("1-VENDAS, 2-SAIR");
			int submenu4;
			System.out.print("OP��O: ");
			submenu4 = sc.nextInt();
			
			switch(submenu4){
			case 1:
					
				vend.numerodopedido = ++vend.numerodopedido;//gera numero do pedido
				
				System.out.println("Nome do Cliente: ");
				vend.nomedocliente = sc.next();
				boolean b = cli.confirmacliente(vend.nomedocliente);//metodo que confirma se o clinte existe
				
				if(b==false){//cadastro de um novo cliente caso n�o exista
					System.out.println("Cadastrar Cliente? S/N:  ");
					String resposta = sc.next();
					if(resposta.equals("s")||resposta.equals("S"))
					{
					cli.codcliente = ++cli.codcliente;
					
					System.out.print("Nome: ");
					cli.nome = sc.next();
					vend.nomedocliente = cli.nome;
					System.out.print("CPF: ");
					cli.cpf =sc.nextInt();
					
					System.out.print("Endere�o: ");
					cli.endereco = sc.next();
					
					System.out.print("Telefone: ");
					cli.telefone = sc.nextInt();
					}
				
					}
				System.out.println("Endere�o de Entrega: ");
				vend.endereco = sc.next();
				b=cli.confirmaendereco(vend.endereco);//confirma o endere�o de entrega
				
				if(b==false){//cadastro de endere�o caso n�o seja igual ao endere�o do cliente
					System.out.println("Deseja cadastrar endere�o? S/N: ");
					String resposta = sc.next();
					if(resposta.equals("s")||resposta.equals("S"))
					{
						System.out.print("Endere�o: ");
						cli.endereco = sc.next();
						vend.endereco = cli.endereco;
					}
					}
					else
					{
					vend.endereco = "ENDERECO_N�O_CADASTRADO";
					System.out.println("endere�o n�o cadastrado");
					}
					
					System.out.println("C�digo do produto");
					vend.codproduto = sc.nextInt();
					b = prod.validacodigo(vend.codproduto);//verifica se o codigo do produto � v�lido
					
					if(b==false){
						System.out.println("c�digo invalido");
						requi.numerodopedido = 0;//zera o codigo da venda
						break;//sai de vendas
					}
					
					
					System.out.println("quantidade vendida");
					vend.qtdvenda = sc.nextInt();
					b = prod.confirmaqtd(vend.qtdvenda);//verifica se o estoque � suficiente
					if(b==false){
						System.out.println("quantidade insuficiente \r\n insira uma quantidade menor ou igual ou menor a " + prod.qtddisponivel  );
						System.out.print("quantidade: ");
						vend.qtdvenda = sc.nextInt();
					}
					
					vend.valorunitario = prod.valornavenda;
					System.out.println("valor unitario: " + prod.valornavenda);//valor unitario
						
					vend.valortotalvenda += prod.valornavenda*vend.qtdvenda;
					System.out.println("total da venda: " +vend.valortotalvenda);//total da venda
					
				
					
					prod.abaixaestoque(vend.qtdvenda);//abaixa o estoque
					
					System.out.println("data da venda: " + vend.datavenda());//data da venda
					
				
					
			
			
			case 2:break;//sai de vendas
				}
			break;//sai para o laco principal
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			case 5:
				
				//cadastro de cliente, nele � possivel inserir dados como
				//nome, cpf, endere�o e telefone de um novo cliente
				System.out.println("-------------CLIENTE--------------");
				System.out.println("1-CADASTRO DE CLIENTE, 2-SAIR");
				int submenu5;
				
				System.out.println("OP��O: ");
				 submenu5 = sc.nextInt();
				switch(submenu5){
				case 1:
				cli.codcliente = ++cli.codcliente;
				
				System.out.print("Nome: ");
				cli.nome = sc.next();
				
				System.out.print("CPF: ");
				cli.cpf =sc.nextInt();
				
				System.out.print("Endere�o: ");
				cli.endereco = sc.next();
				
				System.out.print("Telefone: ");
				cli.telefone = sc.nextInt();
				break;
				
				case 2: break;	//sai de cliente
				}	
				
				break;	//sai para o la�o principal
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			case 6:
				//cadastro de forncedor, nele � possivel inserir dados como
				//nome, cnpj, endere�o e telefone de um novo forncedor
				System.out.println("-------------FORNECEDOR--------------");
				System.out.println("1-CADASTRO DO FORNECEDOR, 2-SAIR");
				int submenu6;
				System.out.print("OP��O: ");
					submenu6 = sc.nextInt();
					
					switch(submenu6){
					case 1:
						
						forn.codfornecedor = ++forn.codfornecedor;
						
						System.out.print("NOME: ");
						forn.nome = sc.next();
						
						
						System.out.print("CNPJ: ");
						forn.cnpj =sc.nextLong();
						
						System.out.print("Endere�o: ");
						forn.endereco = sc.next();
						
						System.out.print("Telefone: ");
						forn.telefone = sc.nextInt();
						break;
						
					case 2:break;
					}
				break;	
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			case 7: System.out.println("ADMINISTRA��O");
			//Em administra��o, � possovel visualizar e alterar todos os dados relativos aos modulos anteriores, 
			//mas apenas o GERENTE tem a permiss�o de acessar esta area para eventuais consultas e altera��es de dados
			
			
				System.out.print("Login: ");
				String login = sc.next();
			
				System.out.print("Senha: ");
				String senha = sc.next();
				l = func.loginadm(login,senha);//metodo que verifica se a senha esta correta
				if(l==false){
				break;}
			do{	
			System.out.println("1-RELATORIOS, 2-MODIFICA��ES, 3-SAIR");
			System.out.println("OP��O: ");
			int submenu7 = sc.nextInt();
			
			switch(submenu7){
			
			//visualiza todos os dados cadastrados
			case 1:
			System.out.println("1-RELAT�RIOS");
			System.out.println("Produtos");
			System.out.println("c�digo do produto: "+prod.codproduto);
			System.out.println("nome do produto: "+prod.nome);
			System.out.println("categoria do produto: "+prod.categoria);
			System.out.println("fornecedor do produto: "+prod.fornecedor);
			System.out.println("quantidade em estoque: "+prod.qtddisponivel);
			System.out.println("valor na hora da compra: "+prod.valornacompra);
			System.out.println("valor na hora da venda: "+prod.valornavenda);
			System.out.println("");
			System.out.println("Fornecedor");
			System.out.println("c�digo do fornecedor: "+forn.codfornecedor);
			System.out.println("nome do forncedor: "+forn.nome);
			System.out.println("cnpj do fornecedor: "+forn.cnpj);
			System.out.println("endere�o do fornecedor: "+forn.endereco);
			System.out.println("telefone do fornecedor: "+forn.telefone);
			System.out.println("");
			System.out.println("Requisi��o");
			System.out.println("numero do pedido: "+requi.numerodopedido);
			System.out.println("fornecedor: "+requi.fornecedor);
			System.out.println("codigo do produto: "+requi.codproduto);
			System.out.println("quantidade comprada: "+requi.qtdcomprada);
			System.out.println("valor por unidade: "+requi.valorunitario);
			System.out.println("valor total da compra: "+requi.valortotalcompra);
			System.out.println("");
			System.out.println("Vendas");
			System.out.println("numero do pedido: "+vend.numerodopedido);
			System.out.println("nome do cliente: "+vend.nomedocliente);
			System.out.println("codigo do produto: "+vend.codproduto);
			System.out.println("quantidade na venda: "+vend.qtdvenda);
			System.out.println("valor por unidade: "+vend.valorunitario);
			System.out.println("valor total da venda: "+vend.valortotalvenda);
			System.out.println("endere�o de entrega: "+vend.endereco);
			System.out.println("data da venda: "+vend.datavenda);
			System.out.println("");
			System.out.println("Cliente");
			System.out.println("codigo do cliente: "+cli.codcliente);
			System.out.println("nome do cliente: "+cli.nome);
			System.out.println("cpf do cliente: "+cli.cpf);
			System.out.println("endere�o do cliente: "+cli.endereco);
			System.out.println("telefone do cliente: "+cli.telefone);
			System.out.println("");
			System.out.println("Funcionario");
			System.out.println("codigo do funcionario: "+func.codfuncionario);
			System.out.println("cargo do funcionario, 1-vendedor, 2-gerente: "+func.cargo);
			System.out.println("nome do funcionario: "+func.nome);
			System.out.println("cpf do funcionario: "+func.cpf);
			System.out.println("endere�o do funcionario: "+func.endereco);
			System.out.println("telefone do funcionario: "+func.telefone);
			System.out.println("usuario do funcionario: "+func.usuario);
			System.out.println("");
			break;
			
			//modifica dados cadastrados de FUNCIONARIO, PRODUTOS, CLIENTE  e FORNECEDOR
			case 2:
				System.out.println("2-MODIFICA��ES");
				System.out.println("1-FUNCIONARIOS, 2-PRODUTOS, 3-CLIENTE, 4-FORNECEDOR, 5 - SAIR");
				System.out.println("OP��O: ");
				int opcao = sc.nextInt();
				
				switch(opcao){
				case 1: 
					System.out.println("FUNCIONARIO");
					System.out.println("1-c�digo do funcionario, 2-nome do funcionario, 3- cpf, 4-endere�o ,5-telefone, 6-usuario, 7-break");
					System.out.print("OP��O: ");
					opcao = sc.nextInt();
					switch(opcao){
					
					case 1: System.out.println("codigo do funcionario: "+func.codfuncionario+": ");
					func.codfuncionario = sc.nextInt();break;
					case 2: System.out.println("nome do funcionario: "+func.nome+": ");
					func.nome = sc.next();break;
					case 3: System.out.println("cpf do produto: "+func.cpf+": ");
					func.cpf = sc.nextInt();break;
					case 4: System.out.println("endere�o do funcionario: "+func.endereco+": ");
					func.endereco= sc.next();break;
					case 5: System.out.println("telefone do funcionario: "+func.telefone+": ");
					func.telefone = sc.nextInt();break;
					case 6: System.out.println("usuario do funcionario: "+func.usuario+": ");
					func.usuario = sc.next();break;
					case 7: break;
					default: System.out.println("digite uma op��o valida");
					}
					break;
				
				
				case 2: 
				System.out.println("PRODUTOS");
				System.out.println("1-c�digo do produto, 2-nome do produto, 3- categoria do produto ,4- fornecedor do produto ,5-estoque, 6-valor de compra, 7-valor de venda, 8-sair");
				System.out.print("OP��O: ");
				opcao = sc.nextInt();
					switch(opcao){
					case 1:System.out.println("c�digo do produto"+prod.codproduto+": ");
					prod.codproduto = sc.nextInt();break;
					case 2:System.out.println("nome do produto: "+prod.nome+": ");
					prod.nome = sc.next();break;
					case 3:System.out.println("categoria do produto: "+prod.categoria+": ");
					prod.categoria = sc.nextInt();break;
					case 4:System.out.println("fornecedor do produto: "+prod.fornecedor+": ");
					prod.fornecedor = sc.next();break;
					case 5:System.out.println("quantidade em estoque: "+prod.qtddisponivel+": ");
					prod.qtddisponivel = sc.nextInt();break;
					case 6:System.out.println("valor na hora da compra: "+prod.valornacompra+": ");
					prod.valornacompra = sc.nextFloat();break;
					case 7:System.out.println("valor na hora da venda: "+prod.valornavenda+": ");
					prod.valornavenda = sc.nextFloat();	break;
					case 8: break;
					default: System.out.println("digite uma op��o valida");}
					break;
				
				case 3:System.out.println("FUNCIONARIO");
				System.out.println("1-c�digo do cliente, 2-nome do cliente, 3- cpf, 4-endere�o  ,5-telefone, 6-sair");
				System.out.print("OP��O: ");
				opcao = sc.nextInt();
					switch(opcao){
					case 1: System.out.print("codigo do cliente: "+cli.codcliente+": ");
					cli.codcliente = sc.nextInt();break;
					case 2: System.out.print("nome do cliente: "+cli.nome+": ");
					cli.nome = sc.next();break;
					case 3: System.out.print("cpf do cliente: "+cli.cpf+": ");
					cli.cpf = sc.nextInt();break;
					case 4: System.out.print("endere�o do cliente: "+cli.endereco+": ");
					cli.endereco = sc.next();break;
					case 5: System.out.print("telefone do cliente: "+cli.telefone+": ");
					cli.telefone = sc.nextInt();break;
					case 6: break;
						}
				break;
					
				
				
				case 4:
					System.out.println("FORNECEDOR");
					System.out.println("1-c�digo do fornecedor, 2-nome do fornecedor, 3- cnpj, 4-endere�o  ,5-telefone, 6-sair");
					System.out.print("OP��O: ");
					opcao = sc.nextInt();
						switch(opcao){
						case 1: System.out.print("c�digo do fornecedor: "+forn.codfornecedor+": ");
						forn.codfornecedor = sc.nextInt();break;
						case 2: System.out.print("nome do forncedor: "+forn.nome+": ");
						forn.nome = sc.next();break;
						case 3: System.out.print("cnpj do fornecedor: "+forn.cnpj+": ");
						forn.cnpj = sc.nextLong();break;
						case 4: System.out.print("endere�o do fornecedor: "+forn.endereco+": ");
						forn.endereco = sc.next();break;
						case 5: System.out.print("telefone do fornecedor: "+forn.telefone+": ");
						forn.telefone = sc.nextInt();break;
						case 6: break;
						default: System.out.println("digite uma op��o valida");
						}
					break;
				}
			case 3: break; //sai para o la�o que pergunta se deseja continuar na area administrativa 
			default: System.out.println("digite uma op��o v�lida");
			}
			System.out.print("DESEJA CONTINUAR NA AREA ADMINISTRATIVA?  S/N: ");	
			  resp = sc.next();
		}while(resp.equals("s")||resp.equals("S"));//condi��o para que continue na area administrativa
			
				
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////	
			case 8:break;//menu sair
				default: System.out.println("DIGITE UMA OP��O V�LIDA!");//default para digitar uma op��o valida
			}
				
				System.out.print("Deseja fazer outra opera��o? S/N: ");//op��o para fazer uma outra opera��o no sistema
				resp=sc.next();//recebe a resposta
			}while(resp.equals("s")||resp.equals("S"));//verifica a resposta, se for "S", ent�o o programa repetira, mantendo os dados armazenados
				
			System.out.print("\t \t FIM DO PROGRAMA");//mensagem de fim do programa, caso a resposta seja "N"		
	
	}
}
