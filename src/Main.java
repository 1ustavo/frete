import modelo.Encomendas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

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

    Criar_encomenda c = new Criar_encomenda();
    c.salvarEncomenda(e);
        }
    }