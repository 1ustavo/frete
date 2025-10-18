package modelo;

public class Funcionarios {
    public int id;
    public String nome;
    public String email;
    public String documento;
    public String senha;
    public int idade;

    public Integer recebeid;

    public Funcionarios(String nome, String email, String documento, String senha, int idade){
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.senha = senha;
        this.idade = idade;
        this.recebeid = null;
    }


    public Funcionarios(int id, String nome, String email, String documento, String senha, int idade, Integer recebeid){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.senha = senha;
        this.idade = idade;
        this.recebeid = recebeid;
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

    public Integer getRecebeid() {
        return recebeid;
    }
    public void setRecebeid(Integer recebeid) {
        this.recebeid = recebeid;
    }
}