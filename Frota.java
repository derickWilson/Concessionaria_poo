import java.util.ArrayList;
public class Frota{
    private ArrayList<Veiculo> frota = new ArrayList<Veiculo>();

    public Frota(Veiculo veiculo)){
        this.insert(veiculo);
    }

    public boolean insert(Veiculo veiculo){
        try {//troca essa merda
            if(validaInsert(veiculo.getPlaca())){
                frota.add(veiculo);
                return true;
            }else{
                System.out.println("o veiculo ja esta na frota");
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            return false;
        }
    }

    public boolean validaInsert(String placa){
        
        //loop para percorrer a frota
        for(Veiculo i : frota){

            //se a placa ja estiver em um veiculo da frota retorna true
            if(i.getPlaca() == placa){
                return true;
            }else{
                return false;
            }
        }

        //caso a placa não esteja na frota retorna false, o objeto não foi cadastrado
        return false;
    }

    public boolean removeVeiculo(String placa){
        for(Veiculo i : frota){//terminar
            if(i.getPlaca() == placa){
                frota.remove(i);
                return true;
            }
        }
        return false;
    }
}
