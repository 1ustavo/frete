package modelo;

public class Funcionarios {
    public int id;
    public String nome;
    public String email;
    public String documento;
    public String senha;
    public int idade;

    public Funcionarios(String nome, String email, String documento, String senha, int idade){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.senha = senha;
        this.idade = idade;

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
}




