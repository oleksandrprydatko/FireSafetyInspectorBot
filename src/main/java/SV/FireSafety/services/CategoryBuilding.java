package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class CategoryBuilding {
    Long userId;
    DatabaseRepository databaseRepository;

    public CategoryBuilding(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }

    double volumeBuilding;
    double volumeRoomA;
    double volumeRoomБ;
    double volumeRoomВ;
    double volumeRoomГ;
    double result;

    private boolean buildingsCategoryA(){
        volumeBuilding = (databaseRepository.getVolume_premises(userId));
        volumeRoomA = (databaseRepository.getVolume_rooms_a(userId));
        result = (volumeRoomA / volumeBuilding) * 100;
        if (result >= 5) return true;
        else return false;
    }
    public boolean getBuildingCategoryA(){
        return buildingsCategoryA();
    }
    private boolean buildingsCategoryБ(){
        if (databaseRepository.getVolume_rooms_a(userId)!=null && databaseRepository.getVolume_rooms_б(userId)!=null) {
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomA = (databaseRepository.getVolume_rooms_a(userId));
            volumeRoomБ = (databaseRepository.getVolume_rooms_б(userId));
            result = ((volumeRoomA + volumeRoomБ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else{
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomБ = (databaseRepository.getVolume_rooms_б(userId));
            result = (volumeRoomБ/volumeBuilding) * 100;
            if (result >=5) return true;
            else return false;
        }
    }
    public boolean getBuildingCategoryБ(){
        return buildingsCategoryБ();
    }
    private boolean buildingsCategoryВ(){
        if (databaseRepository.getVolume_rooms_a(userId)!=null && databaseRepository.getVolume_rooms_б(userId)!=null && databaseRepository.getVolume_rooms_в(userId)!=null){
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomA = (databaseRepository.getVolume_rooms_a(userId));
            volumeRoomБ = (databaseRepository.getVolume_rooms_б(userId));
            volumeRoomВ = (databaseRepository.getVolume_rooms_в(userId));
            result = ((volumeRoomA + volumeRoomБ + volumeRoomВ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else if (databaseRepository.getVolume_rooms_a(userId)==null && databaseRepository.getVolume_rooms_б(userId)!=null && databaseRepository.getVolume_rooms_в(userId)!=null){
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomБ = (databaseRepository.getVolume_rooms_б(userId));
            volumeRoomВ = (databaseRepository.getVolume_rooms_в(userId));
            result = ((volumeRoomБ + volumeRoomВ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else {
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomВ = (databaseRepository.getVolume_rooms_в(userId));
            result = (volumeRoomВ / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }
    }
    public boolean getBuildingCategoryВ(){
        return buildingsCategoryВ();
    }
    private boolean buildingsCategoryГ(){
        if (databaseRepository.getVolume_rooms_a(userId)!=null && databaseRepository.getVolume_rooms_б(userId)!=null && databaseRepository.getVolume_rooms_в(userId)!=null && databaseRepository.getVolume_rooms_г(userId)!=null){
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomA = (databaseRepository.getVolume_rooms_a(userId));
            volumeRoomБ = (databaseRepository.getVolume_rooms_б(userId));
            volumeRoomВ = (databaseRepository.getVolume_rooms_в(userId));
            volumeRoomГ = (databaseRepository.getVolume_rooms_г(userId));
            result = ((volumeRoomA + volumeRoomБ + volumeRoomВ + volumeRoomГ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else if (databaseRepository.getVolume_rooms_a(userId)==null && databaseRepository.getVolume_rooms_б(userId)!=null && databaseRepository.getVolume_rooms_в(userId)!=null && databaseRepository.getVolume_rooms_г(userId)!=null ){
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomБ = (databaseRepository.getVolume_rooms_б(userId));
            volumeRoomВ = (databaseRepository.getVolume_rooms_в(userId));
            volumeRoomГ = (databaseRepository.getVolume_rooms_г(userId));
            result = ((volumeRoomБ + volumeRoomВ + volumeRoomГ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else if (databaseRepository.getVolume_rooms_a(userId)==null && databaseRepository.getVolume_rooms_б(userId) ==null && databaseRepository.getVolume_rooms_в(userId)!=null && databaseRepository.getVolume_rooms_г(userId)!=null ){
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomВ = (databaseRepository.getVolume_rooms_в(userId));
            volumeRoomГ = (databaseRepository.getVolume_rooms_г(userId));
            result = ((volumeRoomВ + volumeRoomГ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else{
            volumeBuilding = (databaseRepository.getVolume_premises(userId));
            volumeRoomГ = (databaseRepository.getVolume_rooms_г(userId));
            result = (volumeRoomГ / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }
    }
    public boolean getBuildingCategoryГ(){
        return buildingsCategoryГ();
    }

}
