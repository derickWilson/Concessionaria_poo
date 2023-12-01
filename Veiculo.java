package moduloGerencia;

import java.util.regex.Pattern;
import java.util.List;

public class Veiculo {
    private String Placa;
    private String Marca;
    private String Modelo;
    private String Cor;
    private String AnoFabricacao;
    private String NomeGrupo;
    private String Status;

    public Veiculo(String placa, String marca, String modelo, String cor, String anoFabricacao, String nomeGrupo,
            String status) {
        this.setPlaca(placa);
        this.Marca = marca;
        this.Modelo = modelo;
        this.Cor = cor;
        this.setAnoFabricacao(anoFabricacao);
        this.setNomeGrupo(nomeGrupo);
        this.Status = status;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        // checar se a placa é valida
        if (checarPlaca(placa)) {
            this.Placa = placa.toUpperCase();
        } else {
            System.out.err("Formato de placa inválido");
            System.out.err("LLLNNLNN");
        }
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        this.Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        this.Modelo = modelo;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        this.Cor = cor;
    }

    public String getAnoFabricacao() {
        return AnoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        // checar se o ano esta válido
        if (checarAno(anoFabricacao)) {
            this.AnoFabricacao = anoFabricacao;
        } else {
            System.err.println("formato de ano inválido");
            System.err.println("deve seguir o formato");
            System.err.println("ANO/MES/DIA");
        }
    }

    public String getNomeGrupo() {
        return NomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        if (checarNomeGrupo(nomeGrupo)) {
            this.NomeGrupo = nomeGrupo;
        } else {
            System.err.println("grupo inválido");
            System.err.println("grupos válidos:");
            System.err.println("PREMIUM, PADRAO, BASICO");
        }
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    // Verificadores
    // checar se a placa segue o formato correto
    private boolean checarPlaca(String placa) {
        String pattern = "[A-Z]{3}\\d[A-Z]\\d{2}";
        boolean resp = Pattern(pattern, placa.toUpperCase());
        return (resp);
    }

    // checar se o ano segue o formato ano/mes/dia
    private boolean checarAno(String anoFabricacao) {
        String pattern1 = "\\d{4}\\-\\d{2}\\-\\d{2}";
        boolean resp = Pattern(pattern, anoFabricacao);
        return (resp);
    }

    private boolean checarNomeGrupo(String nomeGrupo) {
        // Premium Padrao Basico
        List grupos = List("PREMIUM", "PADRAO", "BASICO");
        return (grupos.contains(nomeGrupo.toUpperCase()));
    }

    // checar se o estatus é válido
    private boolean checarStatus(String status) {
        List listaStatus = List("DISPONIVEL", "RESERVADO", "LOCADO", "INDISPONIVEL");
        return (grupos.contains(status.toUpperCase()));
    }
}
