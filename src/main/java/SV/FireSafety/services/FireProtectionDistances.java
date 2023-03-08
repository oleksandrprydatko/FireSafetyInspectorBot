package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class FireProtectionDistances {
    Long userId;
    DatabaseRepository databaseRepository;

    public FireProtectionDistances(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }
    private String typeObject(){return databaseRepository.getType_of_object(userId);}
    private String fireResistanceFromWhich(){return databaseRepository.getFire_resistance(userId);}
    private String fireResistanceToWhich(){return databaseRepository.getFire_resistance_to_which(userId);}
    private String category(){return databaseRepository.getCategory_buildings(userId);}
    private boolean windows(){return databaseRepository.getWindows(userId);}
    private boolean fireAlarm(){return databaseRepository.getFire_alarm(userId);}
    private boolean specificLoad(){return databaseRepository.getSpecific_load(userId);}
    private String distances(double distances){
        return "Висновок: протипожежна відстань становить " + distances + " м. \uD83D\uDCCD";
    }
    private String notStandardized(){
        return "Висновок: протипожежна відстань не нормується";
    }

    private String fireProtectionDistancesBetweenBuildings(){
        if (typeObject().equals("2.1 ВПВ між будівлями")){
            if (fireResistanceFromWhich().equals("І ступінь вогнестійкості") || fireResistanceFromWhich().equals("ІІ ступінь вогнестійкості")){
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості")){
                    if (windows()){
                        return distances(6);
                    }else {
                        return distances(4.8);
                    }
                } else if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    if (windows()){
                        return distances(8);
                    }else {
                        return distances(6);
                    }
                } else{
                    return distances(10);
                }
            } else if (fireResistanceFromWhich().equals("ІІІ ступінь вогнестійкості")) {
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")){
                    if (windows()){
                        return distances(8);
                    }else {
                        return distances(6);
                    }
                } else {
                    return distances(10);
                }
            }else {
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    return distances(10);
                }else {
                    return distances(15);
                }
            }
        } else if (typeObject().equals("2.2 ВПВ між будівлями")) {
            if (fireResistanceFromWhich().equals("І ступінь вогнестійкості") || fireResistanceFromWhich().equals("ІІ ступінь вогнестійкості")){
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості")){
                    if (category().equals("А") || category().equals("Б")){
                        return distances(13.5);
                    } else if (category().equals("В")) {
                        return distances(11.25);
                    }else {
                        return distances(9);
                    }
                } else if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    if (category().equals("В")){
                        return distances(11.25);
                    }else {
                        return distances(9);
                    }
                }else {
                    if (category().equals("В")){
                        return distances(15);
                    }else {
                        return distances(12);
                    }
                }
            } else if (fireResistanceFromWhich().equals("ІІІ ступінь вогнестійкості")) {
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості")){
                    if (category().equals("А") || category().equals("Б")){
                        return distances(13.5);
                    } else if (category().equals("В")) {
                        return distances(11.25);
                    }else {
                        return distances(9);
                    }
                } else if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    if (category().equals("В")){
                        return distances(15);
                    }else {
                        return distances(12);
                    }
                }else {
                    if (category().equals("В")){
                        return distances(18.25);
                    }else {
                        return distances(15);
                    }
                }
            } else {
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості")){
                    if (category().equals("А") || category().equals("Б")){
                        return distances(18);
                    } else if (category().equals("В")) {
                        return distances(15);
                    }else {
                        return distances(12);
                    }
                }if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")){
                    if (category().equals("В")){
                        return distances(18.75);
                    }else {
                        return distances(15);
                    }
                }else {
                    if (category().equals("В")){
                        return distances(22.5);
                    }else {
                        return distances(18);
                    }
                }
            }
        }else if (typeObject().equals("2.3 ВПВ між будівлями")){
            if (fireResistanceFromWhich().equals("І ступінь вогнестійкості") || fireResistanceFromWhich().equals("ІІІа ступінь вогнестійкості")){
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІІа ступінь вогнестійкості")){
                    if (category().equals("А") || category().equals("Б") || category().equals("В")){
                        return distances(9);
                    }else {
                        return notStandardized();
                    }
                } else if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    return distances(9);
                }else {
                    return distances(12);
                }
            } else if (fireResistanceFromWhich().equals("ІІ ступінь вогнестійкості")) {
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості")){
                    if (category().equals("А") || category().equals("Б") || category().equals("В")){
                        return distances(9);
                    }else {
                        return notStandardized();
                    }
                } else if (fireResistanceToWhich().equals("ІІ ступінь вогнестійкості")) {
                    if (category().equals("А") || category().equals("Б")){
                        if (fireAlarm()){
                            return distances(6);
                        }else {
                            return distances(9);
                        }
                    } else if (category().equals("В")) {
                        if (fireAlarm()){
                            return distances(6);
                        }else {
                            if (!specificLoad()){
                                return distances(6);
                            }else {
                                return distances(9);
                            }
                        }
                    }else {
                        return notStandardized();
                    }
                } else if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    return distances(9);
                } else if (fireResistanceToWhich().equals("ІІІа ступінь вогнестійкості")) {
                    if (category().equals("А") || category().equals("Б") || category().equals("В")){
                        return distances(9);
                    }else {
                        return notStandardized();
                    }
                }else {
                    return distances(12);
                }
            } else if (fireResistanceFromWhich().equals("ІІІ ступінь вогнестійкості")) {
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІІа ступінь вогнестійкості")){
                    return distances(9);
                } else if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    return distances(12);
                }else {
                    return distances(15);
                }
            } else {
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІІа ступінь вогнестійкості")){
                    return distances(12);
                } else if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    return distances(15);
                }else {
                    return distances(18);
                }
            }
        }else {
            return "в процесі";
        }
    }
    public String getFireProtectionDistancesBetweenBuildings(){
        return fireProtectionDistancesBetweenBuildings();
    }
}
