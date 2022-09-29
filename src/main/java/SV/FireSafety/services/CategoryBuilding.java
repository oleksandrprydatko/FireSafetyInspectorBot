package SV.FireSafety.services;

public class CategoryBuilding {
    DBWorker dbWorker = new DBWorker();
    String chatID;

    public CategoryBuilding(String chatID) {
        this.chatID = chatID;
    }

    double volumeBuilding;
    double volumeRoomA;
    double volumeRoomБ;
    double volumeRoomВ;
    double volumeRoomГ;
    double result;

    private boolean buildingsCategoryA(){
        volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
        volumeRoomA = Double.parseDouble(dbWorker.getVolumeRoomsA(chatID));
        result = (volumeRoomA / volumeBuilding) * 100;
        if (result >= 5) return true;
        else return false;
    }
    public boolean getBuildingCategoryA(){
        return buildingsCategoryA();
    }
    private boolean buildingsCategoryБ(){
        if (dbWorker.getVolumeRoomsA(chatID)!=null && dbWorker.getVolumeRoomsБ(chatID)!=null) {
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomA = Double.parseDouble(dbWorker.getVolumeRoomsA(chatID));
            volumeRoomБ = Double.parseDouble(dbWorker.getVolumeRoomsБ(chatID));
            result = ((volumeRoomA + volumeRoomБ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else{
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomБ = Double.parseDouble(dbWorker.getVolumeRoomsБ(chatID));
            result = (volumeRoomБ/volumeBuilding) * 100;
            if (result >=5) return true;
            else return false;
        }
    }
    public boolean getBuildingCategoryБ(){
        return buildingsCategoryБ();
    }
    private boolean buildingsCategoryВ(){
        if (dbWorker.getVolumeRoomsA(chatID)!=null && dbWorker.getVolumeRoomsБ(chatID)!=null && dbWorker.getVolumeRoomsB(chatID)!=null){
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomA = Double.parseDouble(dbWorker.getVolumeRoomsA(chatID));
            volumeRoomБ = Double.parseDouble(dbWorker.getVolumeRoomsБ(chatID));
            volumeRoomВ = Double.parseDouble(dbWorker.getVolumeRoomsB(chatID));
            result = ((volumeRoomA + volumeRoomБ + volumeRoomВ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else if (dbWorker.getVolumeRoomsA(chatID)==null && dbWorker.getVolumeRoomsБ(chatID)!=null && dbWorker.getVolumeRoomsB(chatID)!=null){
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomБ = Double.parseDouble(dbWorker.getVolumeRoomsБ(chatID));
            volumeRoomВ = Double.parseDouble(dbWorker.getVolumeRoomsB(chatID));
            result = ((volumeRoomБ + volumeRoomВ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else {
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomВ = Double.parseDouble(dbWorker.getVolumeRoomsB(chatID));
            result = (volumeRoomВ / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }
    }
    public boolean getBuildingCategoryВ(){
        return buildingsCategoryВ();
    }
    private boolean buildingsCategoryГ(){
        if (dbWorker.getVolumeRoomsA(chatID)!=null && dbWorker.getVolumeRoomsБ(chatID)!=null && dbWorker.getVolumeRoomsB(chatID)!=null && dbWorker.getVolumeRoomsГ(chatID)!=null){
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomA = Double.parseDouble(dbWorker.getVolumeRoomsA(chatID));
            volumeRoomБ = Double.parseDouble(dbWorker.getVolumeRoomsБ(chatID));
            volumeRoomВ = Double.parseDouble(dbWorker.getVolumeRoomsB(chatID));
            volumeRoomГ = Double.parseDouble(dbWorker.getVolumeRoomsГ(chatID));
            result = ((volumeRoomA + volumeRoomБ + volumeRoomВ + volumeRoomГ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else if (dbWorker.getVolumeRoomsA(chatID)==null && dbWorker.getVolumeRoomsБ(chatID)!=null && dbWorker.getVolumeRoomsB(chatID)!=null && dbWorker.getVolumeRoomsГ(chatID)!=null ){
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomБ = Double.parseDouble(dbWorker.getVolumeRoomsБ(chatID));
            volumeRoomВ = Double.parseDouble(dbWorker.getVolumeRoomsB(chatID));
            volumeRoomГ = Double.parseDouble(dbWorker.getVolumeRoomsГ(chatID));
            result = ((volumeRoomБ + volumeRoomВ + volumeRoomГ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else if (dbWorker.getVolumeRoomsA(chatID)==null && dbWorker.getVolumeRoomsБ(chatID) ==null && dbWorker.getVolumeRoomsB(chatID)!=null && dbWorker.getVolumeRoomsГ(chatID)!=null ){
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomВ = Double.parseDouble(dbWorker.getVolumeRoomsB(chatID));
            volumeRoomГ = Double.parseDouble(dbWorker.getVolumeRoomsГ(chatID));
            result = ((volumeRoomВ + volumeRoomГ) / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }else{
            volumeBuilding = Double.parseDouble(dbWorker.getVolumePremises(chatID));
            volumeRoomГ = Double.parseDouble(dbWorker.getVolumeRoomsГ(chatID));
            result = (volumeRoomГ / volumeBuilding) * 100;
            if (result >= 5) return true;
            else return false;
        }
    }
    public boolean getBuildingCategoryГ(){
        return buildingsCategoryГ();
    }

}
