package modelo;

import java.util.ArrayList;
import java.util.List;

public class Funcionarios {
    public int id;
    public String nome;
    public String email;
    public String documento;
    public String senha;
    public int idade;
    public List<Integer> encomendas;

    public Funcionarios(String nome, String email, String documento, String senha, int idade){
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.senha = senha;
        this.idade = idade;
        this.encomendas = new ArrayList<>();
    }


    public Funcionarios(int id, String nome, String email, String documento, String senha, int idade, List<Integer> encomendas){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.senha = senha;
        this.idade = idade;
        this.encomendas = encomendas != null ? encomendas : new ArrayList<>();
    }

    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public String getDocumento(){
        return documento;
    }
    public String getSenha(){
        return senha;
    }
    public int getIdade(){
        return idade;
    }

    public List<Integer> getEncomendas() {return encomendas;}
    public void setEncomendas(List<Integer> encomendas) {this.encomendas = encomendas;}

    public void adicionarEncomenda(Integer idEncomenda){
        if (!this.encomendas.contains(idEncomenda)){
            this.encomendas.add(idEncomenda);
        }
    }
}