<<<<<<< main
import java.util.ArrayList;
public class Frota{
    private ArrayList<Veiculo> frota = new ArrayList<Veiculo>();

    public Frota(Veiculo veiculo)){
        this.insertVeiculo(veiculo);
    }

    public int insertVeiculo(Veiculo veiculo){
        try {//troca essa merda
            if(!existePlaca(veiculo.getPlaca())){
                frota.add(veiculo);
                return 0;
            }else{
                System.out.println("o veiculo ja esta na frota");
                return 1;
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            return 2;
        }
    }
//metodo para checar formato da plac
    public boolean checkPlaca(){
        //loop para percorrer a frota
        for(Veiculo i : frota){
            //se a placa ja estiver em um veiculo da frota retorna true
            if(i.getPlaca() == placa){
                return true;
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
    }
