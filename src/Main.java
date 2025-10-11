import modelo.Encomendas;
import modelo.Funcionarios;
import java.util.Scanner;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Olá, Bem vindo :");

        int trabalho = 0;

        while (trabalho != 3){
            System.out.println("Deseja trabalhar com 1 - Encomendas ou 2 - Funcionarios :");
            trabalho = sc.nextInt();
            sc.nextLine();
            int opcao = 0;
            switch (trabalho){

                case 1 :
                    while (opcao != 5){

                        System.out.println("Deseja qual das funcões : 1 - Consultar, 2 - Cadastrar, 3 - Alterar, 4 - Excluir, 5 - Sair.(SOMENTE NUMEROS)");
                        opcao = sc.nextInt();
                        sc.nextLine();

                        switch (opcao){
                            case 1 :
                                System.out.println("Você escolheu consultar : ");
                                System.out.println("Digite nome do cliente : ");
                                String nome = sc.nextLine();
                                Exibe ex = new Exibe();
                                ex.exibeEncomenda(nome);
                                break;

                            case 2 :
                                System.out.println("Codigo : ");
                                String codigo = sc.nextLine();
                                System.out.println("Nome Cliente :");
                                String nome_cliente = sc.nextLine();
                                System.out.println("Telefone :");
                                String telefone = sc.nextLine();
                                System.out.println("Email :");
                                String email = sc.nextLine();
                                System.out.println("Documento (RG ou CPF) :");
                                String documento = sc.nextLine();
                                System.out.println("Descrição :");
                                String descricao = sc.nextLine();
                                System.out.println("Transportadora :");
                                String transportadora = sc.nextLine();
                                String status = "Aguardando retirada";
                                System.out.println("Obs:");
                                String observacao = sc.nextLine();

                                Encomendas e  = new Encomendas(codigo, nome_cliente, telefone, email, documento, descricao, transportadora, status, observacao);

                                Criar c = new Criar();
                                c.salvarEncomenda(e);
                                break;
                            case 3 :
                                System.out.println("Qual Numero de identificação (ID) : ");
                                int id = sc.nextInt();
                                Alterar alt = new Alterar();
                                alt.alterarEncomenda(id);
                                break;
                            case 4 :
                                System.out.println("Qual Numero de identificação (ID) :");
                                id = sc.nextInt();

                                Delete del = new Delete();
                                del.deleteEncomenda(id);
                                break;

                            case 5 :
                                System.out.println("você escolheu sair");
                                break;

                        }
                    }
                    break;
                case 2 :
                    while(opcao != 5){
                    System.out.println("Deseja qual das funcões : 1 - Consultar, 2 - Cadastrar, 3 - Alterar, 4 - Excluir, 5 - Sair.(SOMENTE NUMEROS)");
                    opcao = sc.nextInt();
                    sc.nextLine();

                    switch (opcao){
                        case 1 :
                            System.out.println("Você escolheu consultar : ");
                            System.out.println("Digite nome do funcionario: ");
                            String nome = sc.nextLine();
                            Exibe exb = new Exibe();
                            exb.exibeFuncionario(nome);
                            break;

                        case 2 :
                            System.out.println("Você escolheu cadastrar : ");
                            System.out.println("Nome : ");
                            nome = sc.nextLine();
                            System.out.println("Email :");
                            String email = sc.nextLine();
                            System.out.println("Documento RG ou CPF");
                            String documento = sc.nextLine();
                            System.out.println("Senha : ");
                            String senha = sc.nextLine();
                            System.out.println("Idade : ");
                            int idade = sc.nextInt();
                            Funcionarios f  = new Funcionarios(nome, email, documento, senha, idade);

                            Criar c = new Criar();
                            c.salvarFuncionario(f);
                            break;

                        case 3 :
                            System.out.println("Você escolheu alterar : ");
                            System.out.println("Informe o ID do funcionario: ");
                            int idFunc = sc.nextInt();
                            Alterar alt = new Alterar();
                            alt.alterarFuncionario(idFunc);
                            break;

                        case 4:
                            System.out.println("Você escolheu excluir :");
                            System.out.println("Informe o ID do funcionario: ");
                            int idDel = sc.nextInt();
                            sc.nextLine();
                            Delete del = new Delete();
                            del.deleteFuncionario(idDel);
                            break;

                        case 5:
                            System.out.println("Saido do menu funcionario...");
                            break;

                        default:
                            System.out.println("Opção invalida. Tente novamente.");
                    }
                }
                break;

            }
        }


        }
    }