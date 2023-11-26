package moduloGerencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Arquivos {  
    //metodos get chamam o metodo lerArquivo que le o arquivo indicado em cada metodo
    public static String[][] getParametros(){
        String[][] parametros;
        
        //le a String[][] direto do arquivo
        parametros = lerArquivo("parametros.txt", 6);
        
        //checa se o arquivo esta vazio
        if(parametros == null){
            System.err.println("ERRO: desconhecido!");
        }
        return parametros;
    }
    
    public static ArrayList<Veiculo> getVeiculos(){     
        String[][] matriz;
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        //le a String[][] direto do arquivo
        matriz = lerArquivo("veiculos.txt", 7);
        
        //checa se o arquivo esta vazio
        if(matriz == null){
            System.err.println("Nenhum veiculo encontrado!");
            return null;
        }
        //transformar a String[][] em ArrayList<Veiculo>
        try{
            for(int i = 0;i < matriz.length;++i){
                //Veiculo(String placa, String marca, String modelo, String cor, String anoFabricacao, String nomeGrupo, String status)
                veiculos.add(new Veiculo(matriz[i][0], matriz[i][1], matriz[i][2], matriz[i][3], matriz[i][4], matriz[i][5], matriz[i][6]));                      
            }
        }catch(Exception erro){
            System.err.println("ERRO: "+erro);
        }
        return veiculos;       
     }
    
    public static ArrayList<Locacao> getLocacoes(){
        String[][] matriz;
        ArrayList <Locacao> locacoes = new ArrayList<>();
        
        //le a String[][] direto do arquivo
        matriz = lerArquivo("locacoes.txt", 7);
        
        //checa se o arquivo esta vazio
        if(matriz == null){
            System.err.println("Nenhuma locacao encontrada!");
            return null;
        }      
        //transformar a String[][] em ArrayList<Locacao>
        try{
            for(int i = 0;i < matriz.length;++i){
                //Locacao(long Identificador,String CPFCliente, String Placa, LocalDate DataRetirada, LocalDate DataDevolucao, float ValorLocacao, String Status)
                locacoes.add(new Locacao(Long.parseLong(matriz[i][0]), matriz[i][1], matriz[i][2], LocalDate.parse(matriz[i][3]), 
                        LocalDate.parse(matriz[i][4]), Float.parseFloat(matriz[i][5]), matriz[i][6]));                      
            }
        }catch(DateTimeParseException dtpe){
            System.err.println("ERRO: "+dtpe);
        }catch(NumberFormatException nfe){
            System.err.println("ERRO: "+nfe);
        }
        return locacoes;   
    }
    
    public static ArrayList<Cliente> getClientes(){
        String[][] matriz;
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        //le a String[][] direto do arquivo
        matriz = lerArquivo("clientes.txt", 5);
        
        //checa se o arquivo esta vazio
        if(matriz == null){
            System.err.println("Nenhum cliente encontrado!");
            return null;
        }
        //transformar a String[][] em ArrayList<Cliente>
        try{
            for(int i = 0;i < matriz.length;++i){
                //Clientes(String CPF, String NomeCliente, LocalDate DataNascimento, String Email, String NumeroCelular)
                clientes.add(new Cliente(matriz[i][0], matriz[i][1], LocalDate.parse(matriz[i][2]), matriz[i][3], matriz[i][4]));                      
            }
        }catch(DateTimeParseException dtpe){
            System.err.println("ERRO: "+dtpe);
        }
        return clientes;
    }
    
    //metodos set chamam metodo escreverNoArquivo e passam o texto, o nome do arquivo e o append para o metodo
    public static void setParametros(String NomeDoGrupo, float ValorDiaria, float ValorTanque, float ValorLimpezaExt, float ValorLimpezaInt, float DiariaSeguro, boolean append){
        String texto = NomeDoGrupo+"\t"+ValorDiaria+"\t"+ValorTanque+"\t"+ValorLimpezaExt+"\t"+ValorLimpezaInt+"\t"+DiariaSeguro+"\n";                          
        escreverNoArquivo(texto, "parametros.txt", append);
    }
    
    public static void setVeiculos(Veiculo veiculo, boolean append){
        String texto = veiculo.getPlaca()+"\t"+veiculo.getMarca()+"\t"+veiculo.getModelo()+"\t"+veiculo.getCor()+"\t"+veiculo.getAnoFabricacao()+"\t"+veiculo.getNomeGrupo()+"\t"+veiculo.getStatus()+"\n";
        escreverNoArquivo(texto, "veiculos.txt", append);
    }
    
    public static void setLocacoes(Locacao locacao, boolean append){
        String texto = locacao.getIdentificador()+"\t"+locacao.getCPFCliente()+"\t"+locacao.getPlaca()+"\t"+locacao.getDataRetirada()+"\t"+locacao.getDataDevolucao()+"\t"+locacao.getValorLocacao()+"\t"+locacao.getStatus()+"\n";
        escreverNoArquivo(texto, "locacoes.txt", append);
    }
    
    public static void setClientes(Cliente cliente, boolean append){
        String texto = cliente.getCPF()+"\t"+cliente.getNomeCliente()+"\t"+cliente.getDataNascimento()+"\t"+cliente.getEmail()+"\t"+cliente.getNumeroCelular()+"\n";
        escreverNoArquivo(texto , "clientes.txt", append);
    }
    
    //metodos auxiliares  
    private static String[][] lerArquivo(String nomeArquivo, int qntColunas){
        String[][] matriz = null;
        String lerLinha, aux = "";       
        BufferedReader reader = null;
        File file;
        int qntLinhas, linha, coluna, i, j;
        try{
            file = new File("src"+File.separatorChar+"moduloGerencia"+File.separatorChar+nomeArquivo);
            if(!file.exists()){
                System.err.println("\nArquivo '"+nomeArquivo+"' nao foi encontrado!\nCriando arquivo...\n");
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            //ler arquivo
            qntLinhas = 0;
            while(reader.ready()){
                lerLinha = reader.readLine();            
                if(!lerLinha.equals("")){
                    aux += lerLinha+"\n";
                }      
                ++qntLinhas;
            }       
            //checar se arquivo está vazio 
            if(aux.equals("")){
                if(nomeArquivo.equals("parametros.txt")){             
                    //setar default se for o arquivo parametros
                    setParametros("basico", 0 , 0, 0, 0, 0, false);
                    setParametros("padrao", 0 , 0, 0, 0, 0, true);
                    setParametros("premium", 0 , 0, 0, 0, 0, true);        
                    //ler de novo
                    while(reader.ready()){
                        lerLinha = reader.readLine();            
                        if(!lerLinha.equals("")){
                            aux += lerLinha+"\n";
                        }  
                    }
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
            while(i < aux.length() && linha < qntLinhas){
                //verifica se essa parte da string (de j=i até j = i que é na verdade i+1 por conta do metodo substring que tem -1 por padrao) é um /t ou /n              
                j = i;
                while(!aux.substring(j, j+1).contains("\t")&&!aux.substring(j, j+1).contains("\n")){                   
                    j++;                   
                }                             
                //apos encontrar um \t ou \n, seleciona a parte da string de i (onde comecou a busca) até j-1 (que é j pois o metodo tem -1 e representa o caractere anterior a \t ou \n) 
                matriz[linha][coluna] = aux.substring(i,j);
                ++coluna;
                //proxima linha
                if(aux.substring(j, j+1).contains("\n")){
                    ++linha;
                    coluna = 0;
                }                                                                              
                //i vai para j+2 (o caracter posterior a \t)
                i = j+1;
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
            file = new File("src"+File.separatorChar+"moduloGerencia"+File.separatorChar+nomeArquivo);
            if(!file.exists()){
                System.err.println("\nArquivo '"+nomeArquivo+"' nao foi encontrado!\nCriando arquivo...");
                file.createNewFile();           
            }
            //o append = true deve ser usado apenas na primeira insercao do FileWriter para o arquivo ser sobrescrito
            writer =  new BufferedWriter(new FileWriter(file.getAbsolutePath(), append));           
            writer.write(entrada);                    
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