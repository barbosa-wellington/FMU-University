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
			l = func.login(usuario1, senha1);//metodo que verifica se login e senha estão corretos
			}while(l == false);//verifica se o usuario e senha esta correta, continua no laço até que seja true.
			
			
			do{//laço do programa, finaliza nas linhas finais perguntando se o usuario deseja fazer outra operação 
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("Bem vindo! " + func.nome);//mensagem de boas vindas ao funcionario;
			
			System.out.println(" \n 1-FUNCIONARIOS, 2-PRODUTOS, 3-REQUISIÇÃO, 4-VENDAS, 5-CLIENTE, 6-FORNECEDOR, 7-ADMINISTRATIVO, 8-SAIR");//itens do menu principal
			System.out.println(" \n OPÇÃO: ");//mensagem de opção
			int menuprincipal = sc.nextInt();//variavel que indica qual item do menu o usuario será redirecionado 
			if(menuprincipal <=0 || menuprincipal >=8)//filtro de informações invalidas
				System.out.println("digite um numero valido");//mensagem caso a opção digitada for fora dos parametros
			
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			switch (menuprincipal){ //recebe o numero equivalente ao menu
			
			case 1: 
				//no modulo funcionario a opção 1 representa o cadastro de novos funcionario, , nele é possivel
				//inserir nome, cpf, enredereço, telefone, cargo, usuario e senha
					System.out.println("-------------FUNCIONARIOS--------------");
					System.out.println("1-CADASTRO DE FUNCIONARIOS, 2-SAIR");
					System.out.print("OPÇÃO: ");
					submenu = sc.nextInt();
					
					switch (submenu){
					case 1:
				func.codfuncionario = ++func.codfuncionario;
				
				System.out.print("Nome: ");
				func.nome = sc.next();
				
				System.out.print("CPF: ");
				func.cpf = sc.nextLong();
				
				System.out.print("Endereço: ");
				func.endereco = sc.next();
				
				System.out.print("Telefone: ");
				func.telefone = sc.nextInt();
				
				do{//é obrigatório que o funcionario tenha uma função
				System.out.print("Cargo: 1-Vendedor, 2-Gerente,  ");
				func.cargo = sc.nextInt();
				}while(func.cargo <=0 ||func.cargo>2);//caso a opção seja diferente irá rodar até a opção ser válida
				
				System.out.print("Usuario: ");
				func.usuario = sc.next();
				
				System.out.print("Senha: ");
				String senha = sc.next();
				func.registrasenha(senha);
						
				break;
				case 2:break;//sai do modulo funcionario
				default: System.out.println("DIGITE UMA OPÇÃO VÁLIDA");	
					}
				break;//sai do laço principal e pergunta se quer fazer alguma outra operação
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////// 
				
			case 2:
				//no modulo de produtos é possivel fazer o cadastro dos produtos, nele é possivel
				//inserir o nome, categoria, forncedor 
				System.out.println("-------------PRODUTOS--------------");
				System.out.println("1-CADASTRO DE PRODUTOS, 2-SAIR");
				int submenu2;
				
				System.out.print("OPÇÃO: ");
				submenu2 = sc.nextInt();
						
						switch(submenu2){
						
						case 1:
						prod.codproduto = ++prod.codproduto;
						System.out.println("Código: " + prod.codproduto);
						
						System.out.print("Nome: ");
						prod.nome = sc.next();
						
						System.out.println("CATEGORIA: 1-Livros, 2-Papelaria,	3-Filmes,	4-Música,	5-Games");
						System.out.print("OPÇÃO: ");
						prod.categoria = sc.nextInt();
						
						System.out.print("Fornecedor: ");
						prod.fornecedor = sc.next();
						
						
						case 2:break;//sai do modulo produtos
						default: System.out.println("DIGITE UMA OPÇÃO VÁLIDA");
						}
						break;//sai para o laço principal
						
						//------------------------------------------------------------:
						//------------------------------------------------------------
						
					
						
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			case 3: 
			
			//na requisição de produtos é possivel solicitar produtos apenas se o
			//produto estiver cadastrado no sistema, caso o produto não esteja o sistema
			//sai para laço principal, caso esteja cadastrado é possivel solicitar o produto, 
			//verificar a quantidade em estoque após a compra, colocar o valor de compra, ver o total da compra,
			//caso tenha algum dado incompativel(exceto o codigo do produto), será solicitado que faça o cadastro do
			//recurso faltante, caso contrario a solicitação é feita normalmente
				
			System.out.println("-------------REQUISIÇÃO DE PRODUTOS--------------");
			System.out.println("1-SOLICITAÇÃO, 2-SAIR");
			
			System.out.println("OPÇÃO: ");
			
			int submenu3 = sc.nextInt();
			
			switch(submenu3){
			case 1:
			
			requi.numerodopedido = ++requi.numerodopedido;
			
			System.out.print("Código do produto: ");
			requi.codproduto = sc.nextInt();
			
			boolean b = prod.validacodigo(requi.codproduto);//verifica se o código do produto é válido
			if(b==false){									//se não for válido sera exibida uma mensagem
				System.out.print("código invalido");		//de erro e o numero do pedido sera zerado,
				requi.numerodopedido = 0;					//e o sistema voltara para o laço principal
				break;
			}
			
			System.out.print("nome do fornecedor: ");
			requi.fornecedor = sc.next();	
			
			if(forn.verificafornecedor(requi.fornecedor)==false)//verifica se o forncedor existe
			{
				System.out.println("fornecedor não cadastrado, cadastrar novo fornecedor? S/N:  ");
				String resposta = sc.next();//se não existir o usuario podera cadastrar um novo fornecedor
											//ou sera cadastrado como fornecedor não cadastrado
						if(resposta.equals("s")||resposta.equals("S")){
						
						forn.codfornecedor = ++forn.codfornecedor;
							
						System.out.print("Nome do fornecedor");
						forn.nome = sc.next();
						requi.fornecedor = forn.nome;
						
						System.out.print("CNPJ DO FORNECEDOR: ");
						forn.cnpj =sc.nextLong();
						
						System.out.print("ENDEREÇO DO FORNECEDOR: ");
						forn.endereco = sc.next();
						
						System.out.print("TELEFONE DO FORNECEDOR: ");
						forn.telefone = sc.nextInt();
						}
						else
						requi.fornecedor = "fornecedor_não_cadastrado";
			}
			
			
			System.out.print("Quantidade comprada: ");
			requi.qtdcomprada = sc.nextInt();
			prod.aumentaestoque(requi.qtdcomprada);//aumenta a quantidade em estoque
			
			System.out.print("valor por unidade: ");
			requi.valorunitario = sc.nextFloat();
			prod.valornacompra = requi.valorunitario;//atribui o valor de compra no produto
			
			requi.valortotalcompra = requi.qtdcomprada*requi.valorunitario;
			System.out.println("valor total da requisição: R$ "+ requi.valortotalcompra);//mostra o valor total da compra
			
			System.out.print("valor de venda: ");
			prod.valornavenda = sc.nextFloat();//atribui o valor de venda do produto
		 
			System.out.println("seu estoque é de: " + prod.qtddisponivel);//mostra o estoque disponivel
			
			case 2: break;//sai do modulo requisição
			
			default: System.out.println("DIGITE UMA OPÇÃO VÁLIDA");
			}
				break;//sai para o laço principal
			
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////	
					
			case 4: 
				// Em vendas é verificado se o cliente é registrado ou não, caso não seja cadastrado,
				//será solicitado um cadastramento deste cliente, e tbm é verificado se o endereço de entrega
				//confere com o endereço do cliente, caso não bata, é solocitado um cadastro de endereço,
				//tbm é verificado se o codigo do produto é valido, caso não seja o pedido será cancelado
				//além disso é verificado a quantidade em estoque e a quantidade solicitada para venda,
				//caso seja incompativel será emitido um alerta de que o estoque não é suficiente,
				//o calculo dos itens comprados são feitos automaticamente
			System.out.println("-------------VENDAS--------------");
			System.out.println("1-VENDAS, 2-SAIR");
			int submenu4;
			System.out.print("OPÇÃO: ");
			submenu4 = sc.nextInt();
			
			switch(submenu4){
			case 1:
					
				vend.numerodopedido = ++vend.numerodopedido;//gera numero do pedido
				
				System.out.println("Nome do Cliente: ");
				vend.nomedocliente = sc.next();
				boolean b = cli.confirmacliente(vend.nomedocliente);//metodo que confirma se o clinte existe
				
				if(b==false){//cadastro de um novo cliente caso não exista
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
					
					System.out.print("Endereço: ");
					cli.endereco = sc.next();
					
					System.out.print("Telefone: ");
					cli.telefone = sc.nextInt();
					}
				
					}
				System.out.println("Endereço de Entrega: ");
				vend.endereco = sc.next();
				b=cli.confirmaendereco(vend.endereco);//confirma o endereço de entrega
				
				if(b==false){//cadastro de endereço caso não seja igual ao endereço do cliente
					System.out.println("Deseja cadastrar endereço? S/N: ");
					String resposta = sc.next();
					if(resposta.equals("s")||resposta.equals("S"))
					{
						System.out.print("Endereço: ");
						cli.endereco = sc.next();
						vend.endereco = cli.endereco;
					}
					}
					else
					{
					vend.endereco = "ENDERECO_NÃO_CADASTRADO";
					System.out.println("endereço não cadastrado");
					}
					
					System.out.println("Código do produto");
					vend.codproduto = sc.nextInt();
					b = prod.validacodigo(vend.codproduto);//verifica se o codigo do produto é válido
					
					if(b==false){
						System.out.println("código invalido");
						requi.numerodopedido = 0;//zera o codigo da venda
						break;//sai de vendas
					}
					
					
					System.out.println("quantidade vendida");
					vend.qtdvenda = sc.nextInt();
					b = prod.confirmaqtd(vend.qtdvenda);//verifica se o estoque é suficiente
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
				
				//cadastro de cliente, nele é possivel inserir dados como
				//nome, cpf, endereço e telefone de um novo cliente
				System.out.println("-------------CLIENTE--------------");
				System.out.println("1-CADASTRO DE CLIENTE, 2-SAIR");
				int submenu5;
				
				System.out.println("OPÇÃO: ");
				 submenu5 = sc.nextInt();
				switch(submenu5){
				case 1:
				cli.codcliente = ++cli.codcliente;
				
				System.out.print("Nome: ");
				cli.nome = sc.next();
				
				System.out.print("CPF: ");
				cli.cpf =sc.nextInt();
				
				System.out.print("Endereço: ");
				cli.endereco = sc.next();
				
				System.out.print("Telefone: ");
				cli.telefone = sc.nextInt();
				break;
				
				case 2: break;	//sai de cliente
				}	
				
				break;	//sai para o laço principal
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
			case 6:
				//cadastro de forncedor, nele é possivel inserir dados como
				//nome, cnpj, endereço e telefone de um novo forncedor
				System.out.println("-------------FORNECEDOR--------------");
				System.out.println("1-CADASTRO DO FORNECEDOR, 2-SAIR");
				int submenu6;
				System.out.print("OPÇÃO: ");
					submenu6 = sc.nextInt();
					
					switch(submenu6){
					case 1:
						
						forn.codfornecedor = ++forn.codfornecedor;
						
						System.out.print("NOME: ");
						forn.nome = sc.next();
						
						
						System.out.print("CNPJ: ");
						forn.cnpj =sc.nextLong();
						
						System.out.print("Endereço: ");
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
			
			case 7: System.out.println("ADMINISTRAÇÃO");
			//Em administração, é possovel visualizar e alterar todos os dados relativos aos modulos anteriores, 
			//mas apenas o GERENTE tem a permissão de acessar esta area para eventuais consultas e alterações de dados
			
			
				System.out.print("Login: ");
				String login = sc.next();
			
				System.out.print("Senha: ");
				String senha = sc.next();
				l = func.loginadm(login,senha);//metodo que verifica se a senha esta correta
				if(l==false){
				break;}
			do{	
			System.out.println("1-RELATORIOS, 2-MODIFICAÇÕES, 3-SAIR");
			System.out.println("OPÇÃO: ");
			int submenu7 = sc.nextInt();
			
			switch(submenu7){
			
			//visualiza todos os dados cadastrados
			case 1:
			System.out.println("1-RELATÓRIOS");
			System.out.println("Produtos");
			System.out.println("código do produto: "+prod.codproduto);
			System.out.println("nome do produto: "+prod.nome);
			System.out.println("categoria do produto: "+prod.categoria);
			System.out.println("fornecedor do produto: "+prod.fornecedor);
			System.out.println("quantidade em estoque: "+prod.qtddisponivel);
			System.out.println("valor na hora da compra: "+prod.valornacompra);
			System.out.println("valor na hora da venda: "+prod.valornavenda);
			System.out.println("");
			System.out.println("Fornecedor");
			System.out.println("código do fornecedor: "+forn.codfornecedor);
			System.out.println("nome do forncedor: "+forn.nome);
			System.out.println("cnpj do fornecedor: "+forn.cnpj);
			System.out.println("endereço do fornecedor: "+forn.endereco);
			System.out.println("telefone do fornecedor: "+forn.telefone);
			System.out.println("");
			System.out.println("Requisição");
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
			System.out.println("endereço de entrega: "+vend.endereco);
			System.out.println("data da venda: "+vend.datavenda);
			System.out.println("");
			System.out.println("Cliente");
			System.out.println("codigo do cliente: "+cli.codcliente);
			System.out.println("nome do cliente: "+cli.nome);
			System.out.println("cpf do cliente: "+cli.cpf);
			System.out.println("endereço do cliente: "+cli.endereco);
			System.out.println("telefone do cliente: "+cli.telefone);
			System.out.println("");
			System.out.println("Funcionario");
			System.out.println("codigo do funcionario: "+func.codfuncionario);
			System.out.println("cargo do funcionario, 1-vendedor, 2-gerente: "+func.cargo);
			System.out.println("nome do funcionario: "+func.nome);
			System.out.println("cpf do funcionario: "+func.cpf);
			System.out.println("endereço do funcionario: "+func.endereco);
			System.out.println("telefone do funcionario: "+func.telefone);
			System.out.println("usuario do funcionario: "+func.usuario);
			System.out.println("");
			break;
			
			//modifica dados cadastrados de FUNCIONARIO, PRODUTOS, CLIENTE  e FORNECEDOR
			case 2:
				System.out.println("2-MODIFICAÇÕES");
				System.out.println("1-FUNCIONARIOS, 2-PRODUTOS, 3-CLIENTE, 4-FORNECEDOR, 5 - SAIR");
				System.out.println("OPÇÃO: ");
				int opcao = sc.nextInt();
				
				switch(opcao){
				case 1: 
					System.out.println("FUNCIONARIO");
					System.out.println("1-código do funcionario, 2-nome do funcionario, 3- cpf, 4-endereço ,5-telefone, 6-usuario, 7-break");
					System.out.print("OPÇÃO: ");
					opcao = sc.nextInt();
					switch(opcao){
					
					case 1: System.out.println("codigo do funcionario: "+func.codfuncionario+": ");
					func.codfuncionario = sc.nextInt();break;
					case 2: System.out.println("nome do funcionario: "+func.nome+": ");
					func.nome = sc.next();break;
					case 3: System.out.println("cpf do produto: "+func.cpf+": ");
					func.cpf = sc.nextInt();break;
					case 4: System.out.println("endereço do funcionario: "+func.endereco+": ");
					func.endereco= sc.next();break;
					case 5: System.out.println("telefone do funcionario: "+func.telefone+": ");
					func.telefone = sc.nextInt();break;
					case 6: System.out.println("usuario do funcionario: "+func.usuario+": ");
					func.usuario = sc.next();break;
					case 7: break;
					default: System.out.println("digite uma opção valida");
					}
					break;
				
				
				case 2: 
				System.out.println("PRODUTOS");
				System.out.println("1-código do produto, 2-nome do produto, 3- categoria do produto ,4- fornecedor do produto ,5-estoque, 6-valor de compra, 7-valor de venda, 8-sair");
				System.out.print("OPÇÃO: ");
				opcao = sc.nextInt();
					switch(opcao){
					case 1:System.out.println("código do produto"+prod.codproduto+": ");
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
					default: System.out.println("digite uma opção valida");}
					break;
				
				case 3:System.out.println("FUNCIONARIO");
				System.out.println("1-código do cliente, 2-nome do cliente, 3- cpf, 4-endereço  ,5-telefone, 6-sair");
				System.out.print("OPÇÃO: ");
				opcao = sc.nextInt();
					switch(opcao){
					case 1: System.out.print("codigo do cliente: "+cli.codcliente+": ");
					cli.codcliente = sc.nextInt();break;
					case 2: System.out.print("nome do cliente: "+cli.nome+": ");
					cli.nome = sc.next();break;
					case 3: System.out.print("cpf do cliente: "+cli.cpf+": ");
					cli.cpf = sc.nextInt();break;
					case 4: System.out.print("endereço do cliente: "+cli.endereco+": ");
					cli.endereco = sc.next();break;
					case 5: System.out.print("telefone do cliente: "+cli.telefone+": ");
					cli.telefone = sc.nextInt();break;
					case 6: break;
						}
				break;
					
				
				
				case 4:
					System.out.println("FORNECEDOR");
					System.out.println("1-código do fornecedor, 2-nome do fornecedor, 3- cnpj, 4-endereço  ,5-telefone, 6-sair");
					System.out.print("OPÇÃO: ");
					opcao = sc.nextInt();
						switch(opcao){
						case 1: System.out.print("código do fornecedor: "+forn.codfornecedor+": ");
						forn.codfornecedor = sc.nextInt();break;
						case 2: System.out.print("nome do forncedor: "+forn.nome+": ");
						forn.nome = sc.next();break;
						case 3: System.out.print("cnpj do fornecedor: "+forn.cnpj+": ");
						forn.cnpj = sc.nextLong();break;
						case 4: System.out.print("endereço do fornecedor: "+forn.endereco+": ");
						forn.endereco = sc.next();break;
						case 5: System.out.print("telefone do fornecedor: "+forn.telefone+": ");
						forn.telefone = sc.nextInt();break;
						case 6: break;
						default: System.out.println("digite uma opção valida");
						}
					break;
				}
			case 3: break; //sai para o laço que pergunta se deseja continuar na area administrativa 
			default: System.out.println("digite uma opção válida");
			}
			System.out.print("DESEJA CONTINUAR NA AREA ADMINISTRATIVA?  S/N: ");	
			  resp = sc.next();
		}while(resp.equals("s")||resp.equals("S"));//condição para que continue na area administrativa
			
				
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////	
			case 8:break;//menu sair
				default: System.out.println("DIGITE UMA OPÇÃO VÁLIDA!");//default para digitar uma opção valida
			}
				
				System.out.print("Deseja fazer outra operação? S/N: ");//opção para fazer uma outra operação no sistema
				resp=sc.next();//recebe a resposta
			}while(resp.equals("s")||resp.equals("S"));//verifica a resposta, se for "S", então o programa repetira, mantendo os dados armazenados
				
			System.out.print("\t \t FIM DO PROGRAMA");//mensagem de fim do programa, caso a resposta seja "N"		
	
	}
}
