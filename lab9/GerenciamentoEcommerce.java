import java.util.Scanner;
public class GerenciamentoEcommerce {
    public static void main(String[] args) {
        ListaProdutos<Produto> listaProdutos = new ListaProdutos<Produto>();
        FilaPedidos<Pedido> filaPedidos = new FilaPedidos<Pedido>();
        HistoricoPedidos<Pedido> historicoPedidos = new HistoricoPedidos<Pedido>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0, codigoPedido = 1;
        while(opcao != 7){

            System.out.println("\nDigite uma opção:");
            System.out.println("1 - Cadastrar Produto.");
            System.out.println("2 - Registrar Pedido.");
            System.out.println("3- Processar o próximo pedido.");
            System.out.println("4- Exibir produtos cadastrados.");
            System.out.println("5- Exibir pedidos pendentes.");
            System.out.println("6- Exibir historico de pedidos concluidos.");
            System.out.println("7- Sair.");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // cadastrar produto
                    System.out.println("Digite o codigo do produto:");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a descrição do produto:");
                    String descricaoProduto = scanner.nextLine();

                    System.out.println("Preço padrão: R$10.00, Estoque padrão: 5");

                    System.out.println("Deseja adicionar ao produto os valores padrão de preço e quantidade em estoque? (s/n)");
                    String resposta = scanner.nextLine().toLowerCase();
                    if(resposta.equals("n")){
                        double preco;
                        try{
                            System.out.println("Digite o preço do produto:");
                            preco = scanner.nextDouble();
                            scanner.nextLine();
                            if(preco <= 0){
                                throw new IllegalArgumentException("Preço não pode ser negativo ou igual a 0.");
                            }
                        }
                        catch(IllegalArgumentException e){
                            System.out.println(e.getMessage());
                            break;
                        }
                        
                        
                        int estoque;
                        try{
                            System.out.println("Digite a quantidade em estoque:");
                            estoque = scanner.nextInt();
                            scanner.nextLine();

                            if(estoque <= 0){
                                throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa");
                            }

                        }
                        catch(IllegalArgumentException e){
                            System.out.println(e.getMessage());
                            break;
                        }
                        listaProdutos.adicionarProduto(new Produto(codigo, descricaoProduto, preco, estoque));
                    }
                    else{
                        listaProdutos.adicionarProduto(new Produto(codigo, descricaoProduto));
                    }
                    break;
                
                    case 2:
                    // registrar pedido
                    if(listaProdutos.exibirProtudo() == false){
                        System.out.println("Nenhum produto cadastrado, cadastre um produto antes de registrar um pedido.");
                        break;
                    }
                    int cod;
                    Pedido pedido = null;
                    Produto item = null;
                    String r;
                    
                    System.out.println("Digite o código do Produto:");
                    cod = scanner.nextInt();
                    scanner.nextLine();

                    item = listaProdutos.buscarProduto(cod);
                    if(item == null){
                        break;
                    }
                    else if(item.getEstoque() == 0){
                        System.out.println("Produto sem estoque.");
                        break;
                    }
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.nextLine();
                    pedido = new Pedido(codigoPedido, nomeCliente);
                    codigoPedido++;

                    do{
                        System.out.println("Digite a quantidade do produto:");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        if(quantidade > item.getEstoque()){
                            System.out.println("Quantidade em estoque insuficiente.");
                            break;
                        }
                        else if(quantidade <= 0){
                            System.out.println("Quantidade inválida.");
                            break;
                        }
                        pedido.adicionarProduto(item, quantidade);
                        item.reduzirEstoque(quantidade);
                        filaPedidos.adicionarPedido(pedido);
                        System.out.println("Deseja adicionar mais um produto ao pedido? 's' para sim, qualquer outra tecla para não.");
                        r = scanner.nextLine().toLowerCase();
                        
                        if(r.equals("s")){
                            System.out.println("Digite o código do Produto:");
                            cod = scanner.nextInt();
                            scanner.nextLine();
                            item = listaProdutos.buscarProduto(cod);
                            if(item == null){
                                System.out.println("Entrou;;;");
                                break;
                            }
                            else if(item.getEstoque() == 0){
                                System.out.println("Produto sem estoque.");
                                break;

                            }
                        }

                    }while (r.equals("s"));
                
                    
                    break;

                case 3:
                    
                    if(filaPedidos.exibirFila() == false){
                        break;
                    }
                    historicoPedidos.adicionarPedido(filaPedidos.removerPedido());
                    break;
                case 4:
                    if(listaProdutos.exibirProtudo() != true){
                        System.out.println("Nenhum produto cadastrado");
                    }
                    break;
                case 5:
                    // exibir pedidos pendentes
                    filaPedidos.exibirFila();
                    break;
                case 6:
                    // exibir historico de pedidos concluidos
                    historicoPedidos.exibirHistorico();

                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
            


        }
        
        scanner.close();
        
    }
    
}
