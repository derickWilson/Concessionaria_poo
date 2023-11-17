import java.util.ArrayList;
public class Frota{
    private ArrayList<Veiculo> frota = new ArrayList<Veiculo>();

    public Frota(Veiculo veiculo = new (String placa, 
                                String marca,
                                String modelo,
                                String cor,
                                String anoFabricacao,
                                String nomeGrupo)){
        this.insert(veiculo);
    }

    public boolean insert(Veiculo veiculo){
        try {
            frota.add(veiculo);
            return true;   
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }

    public boolean validaInsert(String placa){
        
        //loop para percorrer a frota
        for(Veiculo i : frota){

            //se a placa ja estiver em um veiculo da frota retorna true
            if(i.placa == placa){
                return true;
            }
        }

        //caso a placa não esteja na frota retorna false, o objeto não foi cadastrado
        return false;
    }

    public boolean removeVeiculo(String placa){
        for(Veiculo i : frota){
            if(i.placa == placa){
                frota.remove(i);
                return true;
            }
        }
        return false;
    }
}
