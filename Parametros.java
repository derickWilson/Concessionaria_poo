package moduloGerencia;

/**
 *
 * @author leobo
 */
public class Parametros {  
    /*valida parametros, se tudo der certo efetua insercao, se nao retorna um erro (String) para ser mostrado na interface pelo main
    
                resposta:
        "Nenhum valor foi alterado!"
        "... nao e um preco invalido!"
        s"... nao e um numero!"
        "sucesso"
    */
    public static String inserirParametros(String[][] novosParametros){
        String[][] parametros = Arquivos.getParametros();
        //so muda se os parametros forem realmente alterados ou se houver um erro
        String resposta = "Nenhum valor foi alterado!";
        int i = 0, j = 1;
        try{     
            while(i < novosParametros.length){
                while(j < novosParametros[i].length){
                    //ver se o preco e maior que 0.
                    if(Float.parseFloat(novosParametros[i][j]) < 0){
                        resposta = novosParametros[i][j]+" nao e um preco invalido!";
                        //sair dos 2 loops
                        i = novosParametros.length;
                        break;
                    }
                    //ve se os parametros realmente foram alterados
                    if(!parametros[i][j].equals(novosParametros[i][j])){
                        resposta = "sucesso";
                    }
                    ++j;
                }
                ++i;
                j = 1;
            } 
        }catch(NumberFormatException nfe){
            //erro de formato. Se a string nao puder ser convertida para float. Erro: return 2
            System.err.println("ERRO: "+nfe);
            resposta = novosParametros[i][j] + " nao e um numero!";
        }catch(Exception e){
            System.err.println("ERRO: "+e);
            resposta = e.toString();
        }
        
        if(resposta.equals("sucesso")){                       
            for(int k = 0;k < 3;++k){
                Arquivos.setParametros(novosParametros[k][0],
                        Float.parseFloat(novosParametros[k][1]),
                        Float.parseFloat(novosParametros[k][2]),
                        Float.parseFloat(novosParametros[k][3]),
                        Float.parseFloat(novosParametros[k][4]),
                        Float.parseFloat(novosParametros[k][5]), (k != 0));
            }            
        }         
        return resposta;
    }     
}
