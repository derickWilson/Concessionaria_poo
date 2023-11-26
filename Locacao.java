package moduloGerencia;

import java.time.LocalDate;

/*
<Identificador><TAB><CPFCliente><TAB><Placa><TAB><DataRetirada><TAB>
<DataDevolução><TAB><ValorLocacao><TAB><Status><EndOfLine>
Onde:
 Identificador: número único do tipo long positivo gerado de forma aleatória e usado para
identificar uma reserva/locação;

 CPFCliente: representa o identificador do cliente que realizou a reserva/locação;

 Placa: representa o identificador do veículo reservado/locado, segundo padrão do
Mercosul;

 DataRetirada: representa a data programada para a retirada do veículo na locadora ou a data
na qual o veículo foi efetivamente retirado, no formato YYYY-MM-DD;

 DataDevolução: representa a data programada para a devolução do veículo na locadora ou
a data na qual o veículo foi efetivamente devolvido, no formato YYYY-MM-DD;

 ValorLocacao: representa o valor a ser pago para a locação do veículo, incluindo diárias,
seguros, etc, ou o valor efetivamente pago pela locação do veículo;

 Status: representa o status da reserva/locação (e.g., ativa, cancelada, no-show, efetivada,
concluida). Quando um cliente realiza uma reserva, esta reserva inicialmente encontra-se
ativa. Uma reserva ativa pode ser cancelada ou efetivada (retirada/locação do veículo). Caso
o cliente não compareça para retirar o veículo, a reserva é cancelada por no-show. Quanto
o veículo locado é devolvido, a reserva/locação está concluída.
 */
public class Locacao {
    private long Identificador;
    private String CPFCliente;
    private String Placa;
    private LocalDate DataRetirada;
    private LocalDate DataDevolucao;
    private float ValorLocacao;
    private String Status;
    
    public Locacao(long Identificador, String CPFCliente, String Placa, LocalDate DataRetirada, LocalDate DataDevolucao, float ValorLocacao, String Status){
        this.Identificador = Identificador;
        this.CPFCliente = CPFCliente;
        this.Placa = Placa;
        this.DataRetirada = DataRetirada;
        this.DataDevolucao = DataDevolucao;
        this.ValorLocacao = ValorLocacao;
        this.Status = Status;
    }
    
    //metodos get
    public long getIdentificador(){
        return Identificador;
    }
    public String getCPFCliente(){
        return CPFCliente;
    }
    public String getPlaca(){
        return Placa;
    }
    public LocalDate getDataRetirada(){
        return DataRetirada;
    }
    public LocalDate getDataDevolucao(){
        return DataDevolucao;
    }
    public float getValorLocacao(){
        return ValorLocacao;
    }
    public String getStatus(){
        return Status;
    }
    
    //metodos set
    public void setIdentificador(long Identificador){
        this.Identificador = Identificador;
    }
    public void setCPFCliente(String CPFCliente){
        this.CPFCliente = CPFCliente;
    }
    public void setPlaca(String Placa){
        this.Placa = Placa;
    }
    public void setDataRetirada(LocalDate DataRetirada){
        this.DataRetirada = DataRetirada;
    }
    public void setDataDevolucao(LocalDate DataDevolucao){
        this.DataDevolucao = DataDevolucao;
    }
    public void setValorLocacao(float ValorLocacao){
        this.ValorLocacao = ValorLocacao;
    }
    public void setStatus(String Status){
        this.Status = Status;
    }
}
