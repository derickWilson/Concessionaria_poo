package trabalho.trabalhopoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.time.LocalDate;
/*
+ getParametros:String[][] (feito)
+ getVeiculos:String[][] (feito)
+ getLocacoes:String[][] (feito)
+ getClientes:String[][] (feito)
+ setParametros:void (feito)
+ setVeiculos:void (feito)
+ setLocacoes:void (feito)
+ setClientes:void (feito)
- lerArquivo: String[][](parcialmente feito)(temos que decidir a estrutura de diretorios)
- escreverNoArquivo: void (parcialmente feito)(temos que decidir a estrutura de diretorios)
*/
public class Arquivos {  
    
    public static String[][] getParametros(){
        String[][] parametros;
        
        parametros = lerArquivo("parametros.txt", 6);
        
        if(parametros == null){
            System.err.println("ERRO: desconhecido!");
        }
        return parametros;
    }
    
    public static String[][] getVeiculos(){     
        String[][] veiculos;
     
        veiculos = lerArquivo("veiculos.txt", 7);
        
        if(veiculos == null){
            System.err.println("Nenhum veiculo encontrado!");
        }
        return veiculos;       
     }
    
    public static String[][] getLocacoes(){
        String[][] locacoes;
     
        locacoes = lerArquivo("locacoes.txt", 7);
        
        if(locacoes == null){
            System.err.println("Nenhuma locacao encontrada!");
        }
        return locacoes;   
    }
    
    public static String[][] getClientes(){
        String[][] clientes;
     
        clientes = lerArquivo("clientes.txt", 5);
        
        if(clientes == null){
            System.err.println("Nenhum cliente encontrado!");
        }
        return clientes;
    }
    
    //AQUI NOS SETS EU POSSO MUDAR OS PARAMETROS DE ENTRADA PARA OS OBJETOS. O append precisa ficar
    public static void setParametros(String NomeDoGrupo, float ValorDiaria, float ValorTanque, float ValorLimpezaExt, float ValorLimpezaInt, float DiariaSeguro, boolean append){
        String parametro = String.format("<%s><TAB><%f><TAB><%f><TAB><%f><TAB><%f><TAB><%f><EndOfLine>",
                NomeDoGrupo,
                ValorDiaria,
                ValorTanque,
                ValorLimpezaExt,
                ValorLimpezaInt,
                DiariaSeguro);
        escreverNoArquivo(parametro, "parametros.txt", append);
    }
    
    public static void setVeiculos(String Placa, String Marca, String Modelo, String Cor, String AnoFabricacao, String NomeDoGrupo, String Status, boolean append){
        String veiculo = String.format("<%s><TAB><%s><TAB><%s><TAB><%s><TAB><%s><TAB><%s><TAB><%s><EndOfLine>",
                Placa, 
                Marca, 
                Modelo,
                Cor,
                AnoFabricacao,
                NomeDoGrupo,
                Status);
        escreverNoArquivo(veiculo, "veiculos.txt", append);
    }
    
    public static void setLocacoes(long Identificador,String CPFCliente, String Placa, LocalDate DataRetirada, LocalDate DataDevolucao, float ValorLocacao, String Status, boolean append){
        String locacao = String.format("<%d><TAB><%s><TAB><%s><TAB><%s><TAB><%s><TAB><%f><TAB><%s><EndOfLine>",
                Identificador,
                CPFCliente,
                Placa,
                DataRetirada,
                DataDevolucao,
                ValorLocacao,
                Status);
        escreverNoArquivo(locacao, "locacoes.txt", append);
    }
    
    public static void setClientes(String CPF, String NomeCliente, LocalDate DataNascimento, String Email, String NumeroCelular, boolean append){
        String cliente = String.format("<%s><TAB><%s><TAB><%s><TAB><%s><TAB><%s><EndOfLine>",
                CPF,
                NomeCliente,
                DataNascimento,
                Email,
                NumeroCelular);
        escreverNoArquivo(cliente, "clientes.txt", append);
    }
    
    //metodos auxiliares  
    private static String[][] lerArquivo(String nomeArquivo, int qntColunas){
        String[][] matriz = null;
        String aux = "";       
        BufferedReader reader = null;
        File file;
        int qntLinhas, linha, coluna, i, j;
        try{
            file = new File("src\\main\\java\\trabalho\\trabalhopoo\\"+nomeArquivo);
            if(!file.exists()){
                System.err.println("\nArquivo '"+nomeArquivo+"' nao foi encontrado!\nCriando arquivo...\n");
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            //ler arquivo
            qntLinhas = 0;
            while(reader.ready()){
                aux += reader.readLine();
                ++qntLinhas;
            }           
            //checar se arquivo está vazio 
            if(aux.equals("")){
                if(nomeArquivo.equals("parametros.txt")){             
                    //setar default
                    setParametros("basico", 0 , 0, 0, 0, 0, false);
                    setParametros("padrao", 0 , 0, 0, 0, 0, true);
                    setParametros("premium", 0 , 0, 0, 0, 0, true);        
                    //ler de novo
                    while(reader.ready()){aux += reader.readLine();}
                    qntLinhas = 3;                                     
                }else{
                    return null;
                }
            }
            //transformar em matriz
            matriz = new String[qntLinhas][qntColunas];           
            i = 0;
            linha = 0;
            coluna = 0;
            while(i < aux.length()){
                if(aux.charAt(i) == '<'){
                    j = i+1;
                    while(aux.charAt(j) != '>'){
                        ++j;
                    }                   
                    switch (aux.substring(i, j+1)) {
                        case "<TAB>":
                            ++coluna;
                            break;
                        case "<EndOfLine>":
                            ++linha;
                            coluna = 0;                           
                            break;                       
                        default:                          
                            matriz[linha][coluna] = aux.substring(i+1, j);                                               
                            break;
                    }                   
                    i = j+1;
                }else{
                    ++i;
                }
            }          
        }catch(FileNotFoundException fnfe){
            System.err.println("ERRO: " + fnfe);        
        }catch(IOException ioe){
            System.err.println("ERRO: " + ioe);
        }finally{
            try{
                if(reader != null){
                    reader.close();                   
                }
            }catch(IOException ioe){
                System.err.println("ERRO: " + ioe);
            }
        }      
        return matriz;
    }
    
    private static void escreverNoArquivo(String entrada, String nomeArquivo, boolean append){
        File file;
        BufferedWriter writer = null;    
        try{
            file = new File("src\\main\\java\\trabalho\\trabalhopoo\\"+nomeArquivo);
            if(!file.exists()){
                System.err.println("\nArquivo '"+nomeArquivo+"' não foi encontrado!\nCriando arquivo...");
                file.createNewFile();           
            }
            //o append = true deve ser usado apenas na primeira insercao do FileWriter para o arquivo ser sobrescrito
            writer =  new BufferedWriter(new FileWriter(file.getAbsolutePath(), append));           
            writer.write(entrada);
            writer.newLine();                    
        }catch(IOException ioe){
            System.err.println("ERRO: " + ioe);
        }finally{
            try{
                if(writer != null){
                    writer.close();
                }
            }catch(IOException ioe){
                System.err.println("ERRO: " + ioe);
            }
        }  
    }
}