package moduloGerencia;
public class Veiculo{
    private String Placa;
    private String Marca;
    private String Modelo;
    private String Cor;
    private String AnoFabricacao;
    private String NomeGrupo;
    private String Status;
    
    public Veiculo(String placa, String marca, String modelo, String cor, String anoFabricacao, String nomeGrupo, String status){
        this.Placa = placa;
        this.Marca = marca;
        this.Modelo = modelo;
        this.Cor = cor;
        this.AnoFabricacao = anoFabricacao;
        this.NomeGrupo = nomeGrupo;
        this.Status = status;
    }

    public String getPlaca(){
        return Placa;
    }

    public void setPlaca(String placa){
        this.Placa = placa;        
    }

    public String getMarca(){
        return Marca;
    }

    public void setMarca(String marca){
        this.Marca = marca;
    }

    public String getModelo(){
        return Modelo;
    }

    public void setModelo(String modelo){
        this.Modelo = modelo;
    }

    public String getCor(){
        return Cor;
    }

    public void setCor(String cor){
        this.Cor = cor;
    }

    public String getAnoFabricacao(){
        return AnoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao){
        this.AnoFabricacao = anoFabricacao;
    }

    public String getNomeGrupo(){
        return NomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo){
        this.NomeGrupo = nomeGrupo;
    }
    
    public String getStatus(){
        return Status;
    }
    
    public void setStatus(String status){
        this.Status = status;
    }

    private boolean checkPlaca(String placa){
        String padrao = "[A-Z]{3}\\d[A-Z]{2}";
    }
}
