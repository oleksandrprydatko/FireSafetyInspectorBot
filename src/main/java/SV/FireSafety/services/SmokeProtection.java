package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;


public class SmokeProtection {
    Long userId;
    DatabaseRepository databaseRepository;

    public SmokeProtection(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }
    private String typeObject(){return databaseRepository.getType_of_object(userId);}
    private float height(){return databaseRepository.getHeight_object(userId);}
    private float length () {return databaseRepository.getLength(userId);}
    private boolean lighting() {return databaseRepository.getNatural_lighting(userId);}
    private String categoryBuildings(){return databaseRepository.getCategory_buildings(userId);}
    private String typePremisses() {return databaseRepository.getType_premises(userId);}
    private int constantlyAtFacility() {return databaseRepository.getConstantly_at_facility(userId);}
    private float square() {return databaseRepository.getSquare(userId);}
    private String typeStairs(){return databaseRepository.getType_stairs(userId);}
    private Boolean beingOnStairs(){return databaseRepository.getBeing_on_stairs(userId);}
    private int floors(){return databaseRepository.getFloors(userId);}
    private String location(){return databaseRepository.getB1(userId);}
    private String notNeeded(){
        return "Висновок: влаштування системи <b>не потребується</b> \uD83D\uDD34";
    }
    private String corridorsHalls(){
        return "Висновок: влаштування системи <b>потребується</b> в коридорах та холах \uD83D\uDD34";
    }
    private String needed(){
        return "Висновок: влаштування системи <b>потребується</b> \uD83D\uDD34";
    }
    private String corridors(){
        return "Висновок: влаштування системи <b>потребується</b> з коридорів \uD83D\uDD34";
    }

    private String smokeRemovalSystem(){
        if (typeObject().equals("житлові будівлі")){
            if (height()<26.5){
                return notNeeded();
            }else {
                return corridorsHalls();
            }
        } else if (typeObject().equals("громадські будівлі") || typeObject().equals("адміністративні будівлі")) {
            if (height()<26.5){
                if (length()<15){
                    return notNeeded();
                }else {
                    if (lighting()){
                        return notNeeded();
                    }else {
                        return corridorsHalls();
                    }
                }
            }else {
                return corridorsHalls();
            }
        }else if (typeObject().equals("виробничі будівлі")){
            if (height()<26.5){
                if (length()<15){
                    if (categoryBuildings().equals("наявні категорії")){
                        return needed();
                    }else {
                        return notNeeded();
                    }
                }else {
                    return needed();
                }
            }else {
                return corridors();
            }
        }else {
            if (typePremisses().equals("розташовані у будівлях")){
                if (constantlyAtFacility()<50){
                    return notNeeded();
                }else {
                    return needed();
                }
            } else if (typePremisses().equals("горючі матеріали")) {
                if (square()<55){
                    return notNeeded();
                }else {
                    return needed();
                }
            }else {
                if (square()<200){
                    return notNeeded();
                }else {
                    return needed();
                }
            }
        }
    }
    public String getSmokeRemovalSystem(){
        return smokeRemovalSystem();
    }
    private String protectionSystem(){
        if (typeObject().equals("ліфтові шахти")){
            if (height()<26.5){
                return notNeeded();
            }else {
                return needed();
            }
        } else if (typeObject().equals("сходові клітки")) {
            if (typeStairs().equals("Н1")){
                return notNeeded();
            } else if (typeStairs().equals("Н3")) {
                if (beingOnStairs()){
                    return needed();
                }else {
                    return notNeeded();
                }
            }else {
                return needed();
            }
        }else {
            if (typePremisses().equals("3 тамбур-шлюзи") || typePremisses().equals("4 тамбур-шлюзи")){
                if (floors()==1){
                    return notNeeded();
                }else {
                    return needed();
                }
            } else if (typePremisses().equals("5 тамбур-шлюзи")) {
                if (location().equals("на вході до атріумів")){
                    return needed();
                }else {
                    return notNeeded();
                }
            } else {
                return needed();
            }
        }
    }
    public String getProtectionSystem(){
        return protectionSystem();
    }
}
