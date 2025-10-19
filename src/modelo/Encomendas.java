package modelo;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Encomendas {
    public int id;
    public String codigo;
    public String nome_cliente;
    public String telefone;
    public String email;
    public String documento;
    public String descricao;
    public String transportadora;
    public String status;
    public String observacoes;

    public Encomendas(String codigo, String nome_cliente, String telefone, String email, String documento, String descricao, String transportadora, String status, String observacoes){
        this.codigo = codigo;
        this.nome_cliente = nome_cliente;
        this.telefone = telefone;
        this.email = email;
        this.documento = documento;
        this.descricao = descricao;
        this.transportadora = transportadora;
        this.status = status;
        this.observacoes = observacoes;
    }

    public Encomendas(int id, String codigo, String nome_cliente, String telefone, String email, String documento, String descricao, String transportadora, String status, String observacoes){
        this.id = id;
        this.codigo = codigo;
        this.nome_cliente = nome_cliente;
        this.telefone = telefone;
        this.email = email;
        this.documento = documento;
        this.descricao = descricao;
        this.transportadora = transportadora;
        this.status = status;
        this.observacoes = observacoes;
    }

    public int getId(){ return id; }
    public String getCodigo(){ return codigo; }
    public String getNome_cliente(){ return nome_cliente; }
    public String getDocumento(){ return documento; }
    public String getDescricao(){ return descricao; }
    public String getTelefone(){ return telefone; }
    public String getEmail(){ return email; }
    public String getTransportadora(){ return transportadora; }
    public String getStatus(){ return status; }
    public String getObs(){ return observacoes; }
}
