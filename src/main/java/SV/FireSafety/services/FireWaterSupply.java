package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class FireWaterSupply {
    Long userId;
    DatabaseRepository databaseRepository;

    public FireWaterSupply(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }

    int residents(){return databaseRepository.getSeats(userId);}
    int floors(){return databaseRepository.getFloors(userId);}

    private String text(int fire, int consumption){
        return  "розрахункова кількість одночасних пожеж – " + fire + ", розрахункові витрати води на зовнішнє пожежогасіння в населеному пункті – " + consumption + "л/с";
    }


}
