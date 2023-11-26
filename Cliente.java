package moduloGerencia;

import java.time.LocalDate;
/*
CPF: representa o número do CPF do cliente;
NomeCliente: nome completo registrado pelo cliente;
DataNascimento: data de nascimento do cliente, no formato YYYY-MM-DD;
Email: endereço de e-mail fornecido pelo cliente;
NumeroCelular: número de celular/telefone contato fornecido pelo cliente.
 */
public class Cliente {
    private String CPF;
    private String NomeCliente;
    private LocalDate DataNascimento;
    private String Email;
    private String NumeroCelular;
    
    public Cliente(String CPF, String NomeCliente, LocalDate DataNascimento, String Email, String NumeroCelular){
        this.CPF = CPF;
        this.NomeCliente = NomeCliente;
        this.DataNascimento = DataNascimento;
        this.Email = Email;
        this.NumeroCelular = NumeroCelular;
    }
    
    //metodos get
    public String getCPF(){
        return CPF;
    }
    public String getNomeCliente(){
        return NomeCliente;
    }
    public LocalDate getDataNascimento(){
        return DataNascimento;
    }
    public String getEmail(){
        return Email;
    }
    public String getNumeroCelular(){
        return NumeroCelular;
    }
    
    //metodos set
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    public void setNomeCliente(String NomeCliente){
        this.NomeCliente = NomeCliente;
    }
    public void setDataNascimento(LocalDate DataNascimento){
        this.DataNascimento = DataNascimento;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public void setNumeroCelular(String NumeroCelular){
        this.NumeroCelular = NumeroCelular;
    }
}
