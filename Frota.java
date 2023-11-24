for(Veiculo i : frota){
            if(i.getPlaca() == placa){
                frota.remove(i);
                return true;
            }
        }
