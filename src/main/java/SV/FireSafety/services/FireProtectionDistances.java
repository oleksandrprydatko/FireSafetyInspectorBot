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
    private String subcategory(){return databaseRepository.getCategory_premises(userId);}
    private String typePremisses(){return databaseRepository.getType_premises(userId);}
    private String typeGasStation(){return databaseRepository.getType_gas_station(userId);}
    private String sizeGasStation(){return databaseRepository.getSize_gas_station(userId);}
    private String typeOfFuel(){return databaseRepository.getType_of_fuel(userId);}
    private String typeGasHolder(){return databaseRepository.getType_gas_holder(userId);}
    private String locationPipeline(){return databaseRepository.getLocation_pipeline(userId);}
    private String typeLiquid(){return databaseRepository.getType_liquid(userId);}
    private boolean fireAlarm(){return databaseRepository.getFire_alarm(userId);}
    private boolean specificLoad(){return databaseRepository.getSpecific_load(userId);}
    private int parking(){return databaseRepository.getParking(userId);}
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
                    if (typePremisses().equals("вікна наявні")){
                        return distances(6);
                    }else {
                        return distances(4.8);
                    }
                } else if (fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")) {
                    if (typePremisses().equals("вікна наявні")){
                        return distances(8);
                    }else {
                        return distances(6);
                    }
                } else{
                    return distances(10);
                }
            } else if (fireResistanceFromWhich().equals("ІІІ ступінь вогнестійкості")) {
                if (fireResistanceToWhich().equals("І ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІ ступінь вогнестійкості") || fireResistanceToWhich().equals("ІІІ ступінь вогнестійкості")){
                    if (typePremisses().equals("вікна наявні")){
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
    private String fireProtectionDistancesTechnological(){
        if (typeObject().equals("2.1 ВПВ технологічні")){
            if (category().equals("категорія складу - І")){
                return distances(200);
            } else if (category().equals("категорія складу - ІІ")) {
                if (subcategory().equals("підкатегорія – IІа")){
                    if (typePremisses().equals("легкозаймисті рідини")){
                        return distances(180);
                    }else {
                        return distances(150);
                    }
                }else {
                    return distances(100);
                }
            }else {
                if (subcategory().equals("підкатегорія – IIІа")){
                    if (typePremisses().equals("легкозаймисті рідини")){
                        return distances(100);
                    }else {
                        return distances(80);
                    }
                }else if (subcategory().equals("підкатегорія – ІIIб")){
                    if (typePremisses().equals("легкозаймисті рідини")){
                        return distances(75);
                    }else {
                        return distances(60);
                    }
                }else {
                    if (typePremisses().equals("легкозаймисті рідини")){
                        return distances(50);
                    }else {
                        return distances(40);
                    }
                }
            }
        }else if (typeObject().equals("2.2 ВПВ технологічні")){
            if (category().equals("категорія складу - І")){
                if (typePremisses().equals("сільськогосподарські")){
                    if (subcategory().equals("підкатегорія – Іа")){
                        return distances(200);
                    }else {
                        return distances(150);
                    }
                } else if (typePremisses().equals("тверді горючі")) {
                    return distances(100);
                } else if (typePremisses().equals("гаражі")) {
                    if (parking()==1){
                        return distances(75);
                    }else {
                        return distances(200);
                    }
                } else if (typePremisses().equals("технологічні")) {
                    return distances(100);
                } else {
                    return distances(100);
                }
            } else if (category().equals("категорія складу - ІІ")) {
                if (subcategory().equals("підкатегорія – IІа")){
                    if (typePremisses().equals("сільськогосподарські")){
                        return distances(100);
                    } else if (typePremisses().equals("тверді горючі")) {
                        return distances(75);
                    } else if (typePremisses().equals("гаражі")) {
                        if (parking()==1){
                            return distances(50);
                        }else {
                            return distances(150);
                        }
                    } else if (typePremisses().equals("технологічні")) {
                        return distances(100);
                    } else {
                        return distances(100);
                    }
                } else  {
                    if (typePremisses().equals("сільськогосподарські")){
                        return distances(75);
                    } else if (typePremisses().equals("тверді горючі")) {
                        return distances(50);
                    } else if (typePremisses().equals("гаражі")) {
                        if (parking()==1){
                            return distances(50);
                        }else {
                            return distances(150);
                        }
                    } else if (typePremisses().equals("технологічні")) {
                        return distances(100);
                    } else {
                        return distances(100);
                    }
                }
            }else {
                if (subcategory().equals("підкатегорія – IIІа")){
                    if (typePremisses().equals("сільськогосподарські")){
                        return distances(40);
                    } else if (typePremisses().equals("тверді горючі")) {
                        return distances(50);
                    } else if (typePremisses().equals("гаражі")) {
                        if (parking()==1){
                            return distances(30);
                        }else {
                            return distances(75);
                        }
                    } else if (typePremisses().equals("технологічні")) {
                        return distances(100);
                    } else {
                        return distances(100);
                    }
                } else if (typePremisses().equals("підкатегорія – ІIIб")) {
                    if (typePremisses().equals("сільськогосподарські")){
                        return distances(36);
                    } else if (typePremisses().equals("тверді горючі")) {
                        return distances(50);
                    } else if (typePremisses().equals("гаражі")) {
                        if (parking()==1){
                            return distances(25);
                        }else {
                            return distances(50);
                        }
                    } else if (typePremisses().equals("технологічні")) {
                        return distances(100);
                    } else {
                        return distances(100);
                    }
                }else {
                    if (typePremisses().equals("сільськогосподарські")){
                        return distances(30);
                    } else if (typePremisses().equals("тверді горючі")) {
                        return distances(40);
                    } else if (typePremisses().equals("гаражі")) {
                        if (parking()==1){
                            return distances(15);
                        }else {
                            return distances(25);
                        }
                    } else if (typePremisses().equals("технологічні")) {
                        return distances(100);
                    } else {
                        return distances(100);
                    }
                }
            }
        }else if (typeObject().equals("2.3 ВПВ технологічні")){
            if (category().equals("категорія складу - І")){
                if (typePremisses().equals("хвойні породи")){
                    return distances(100);
                }else if (typePremisses().equals("змішані породи")){
                    return distances(50);
                } else if (typePremisses().equals("листяні породи")) {
                    return distances(20);
                }else {
                    return distances(100);
                }
            } else if (category().equals("категорія складу - ІІ")) {
                if (typePremisses().equals("хвойні породи")){
                    return distances(80);
                }else if (typePremisses().equals("змішані породи")){
                    return distances(30);
                } else if (typePremisses().equals("листяні породи")) {
                    return distances(20);
                }else {
                    return distances(50);
                }
            }else {
                if (typePremisses().equals("хвойні породи")){
                    return distances(50);
                }else if (typePremisses().equals("змішані породи")){
                    return distances(30);
                } else if (typePremisses().equals("листяні породи")) {
                    return distances(20);
                }else {
                    return distances(50);
                }
            }
        } else if (typeObject().equals("2.4 ВПВ технологічні")) {
            if (category().equals("категорія складу - І")){
                if (subcategory().equals("підкатегорія – Іа")){
                    if (typePremisses().equals("5.1 ВПВ резервуари")){
                        return distances(100);
                    }else if (typePremisses().equals("5.2 ВПВ резервуари")){
                        return distances(40);
                    } else if (typePremisses().equals("5.3 ВПВ резервуари")) {
                            return distances(15);
                    } else if (typePremisses().equals("5.4 ВПВ резервуари")) {
                        return distances(30);
                    } else if (typePremisses().equals("5.5 ВПВ резервуари")) {
                        return distances(30);
                    } else if (typePremisses().equals("5.6 ВПВ резервуари")) {
                        return distances(40);
                    } else if (typePremisses().equals("5.7 ВПВ резервуари")) {
                        return distances(30);
                    } else if (typePremisses().equals("легкозаймисті рідини")) {
                        return distances(80);
                    } else if (typePremisses().equals("горючі рідини")) {
                        return distances(60);
                    } else if (typePremisses().equals("5.9 ВПВ резервуари")) {
                        return distances(24);
                    }else {
                        return distances(60);
                    }
                }else {
                    if (typePremisses().equals("5.1 ВПВ резервуари")){
                        return distances(75);
                    }else if (typePremisses().equals("5.2 ВПВ резервуари")){
                        return distances(30);
                    } else if (typePremisses().equals("5.3 ВПВ резервуари")) {
                        return distances(15);
                    } else if (typePremisses().equals("5.4 ВПВ резервуари")) {
                        return distances(30);
                    } else if (typePremisses().equals("5.5 ВПВ резервуари")) {
                        return distances(30);
                    } else if (typePremisses().equals("5.6 ВПВ резервуари")) {
                        return distances(40);
                    } else if (typePremisses().equals("5.7 ВПВ резервуари")) {
                        return distances(30);
                    } else if (typePremisses().equals("легкозаймисті рідини")) {
                        return distances(60);
                    } else if (typePremisses().equals("горючі рідини")) {
                        return distances(60);
                    } else if (typePremisses().equals("5.9 ВПВ резервуари")) {
                        return distances(18);
                    }else {
                        return distances(40);
                    }
                }
            } else if (category().equals("категорія складу - ІІ")) {
                if (typePremisses().equals("5.1 ВПВ резервуари")){
                    if (subcategory().equals("підкатегорія – IІа")){
                        return distances(60);
                    }else {
                        return distances(50);
                    }
                }else if (typePremisses().equals("5.2 ВПВ резервуари")){
                    if (subcategory().equals("підкатегорія – IІа")){
                        return distances(24);
                    }else {
                        return distances(20);
                    }
                } else if (typePremisses().equals("5.3 ВПВ резервуари")) {
                    return distances(15);
                } else if (typePremisses().equals("5.4 ВПВ резервуари")) {
                    return distances(15);
                } else if (typePremisses().equals("5.5 ВПВ резервуари")) {
                    return distances(15);
                } else if (typePremisses().equals("5.6 ВПВ резервуари")) {
                    return distances(40);
                } else if (typePremisses().equals("5.7 ВПВ резервуари")) {
                    return distances(30);
                } else if (typePremisses().equals("легкозаймисті рідини")) {
                    return distances(40);
                } else if (typePremisses().equals("горючі рідини")) {
                    return distances(30);
                } else if (typePremisses().equals("5.9 ВПВ резервуари")) {
                    return distances(18);
                }else {
                    return distances(40);
                }
            }else {
                if (subcategory().equals("підкатегорія – IIІа")){
                    if (typePremisses().equals("5.1 ВПВ резервуари")){
                        return distances(50);
                    }else if (typePremisses().equals("5.2 ВПВ резервуари")){
                        return distances(15);
                    } else if (typePremisses().equals("5.3 ВПВ резервуари")) {
                        return distances(15);
                    } else if (typePremisses().equals("5.4 ВПВ резервуари")) {
                        return distances(12);
                    } else if (typePremisses().equals("5.5 ВПВ резервуари")) {
                        return distances(15);
                    } else if (typePremisses().equals("5.6 ВПВ резервуари")) {
                        return distances(12);
                    } else if (typePremisses().equals("5.7 ВПВ резервуари")) {
                        return distances(15);
                    } else if (typePremisses().equals("легкозаймисті рідини")) {
                        return distances(40);
                    } else if (typePremisses().equals("горючі рідини")) {
                        return distances(30);
                    } else if (typePremisses().equals("5.9 ВПВ резервуари")) {
                        return distances(18);
                    }else {
                        return distances(40);
                    }
                } else if (subcategory().equals("підкатегорія – ІIIб")) {
                    if (typePremisses().equals("5.1 ВПВ резервуари")){
                        return distances(50);
                    }else if (typePremisses().equals("5.2 ВПВ резервуари")){
                        return distances(15);
                    } else if (typePremisses().equals("5.3 ВПВ резервуари")) {
                        return distances(10);
                    } else if (typePremisses().equals("5.4 ВПВ резервуари")) {
                        return distances(9);
                    } else if (typePremisses().equals("5.5 ВПВ резервуари")) {
                        return distances(10);
                    } else if (typePremisses().equals("5.6 ВПВ резервуари")) {
                        return distances(40);
                    } else if (typePremisses().equals("5.7 ВПВ резервуари")) {
                        return distances(30);
                    } else if (typePremisses().equals("легкозаймисті рідини")) {
                        return distances(36);
                    } else if (typePremisses().equals("горючі рідини")) {
                        return distances(30);
                    } else if (typePremisses().equals("5.9 ВПВ резервуари")) {
                        return distances(18);
                    }else {
                        return distances(40);
                    }
                }else {
                    if (typePremisses().equals("5.1 ВПВ резервуари")){
                        return distances(50);
                    }else if (typePremisses().equals("5.2 ВПВ резервуари")){
                        return distances(15);
                    } else if (typePremisses().equals("5.3 ВПВ резервуари")) {
                        return distances(10);
                    } else if (typePremisses().equals("5.4 ВПВ резервуари")) {
                        return distances(9);
                    } else if (typePremisses().equals("5.5 ВПВ резервуари")) {
                        return distances(10);
                    } else if (typePremisses().equals("5.6 ВПВ резервуари")) {
                        return distances(40);
                    } else if (typePremisses().equals("5.7 ВПВ резервуари")) {
                        return distances(20);
                    } else if (typePremisses().equals("легкозаймисті рідини")) {
                        return distances(30);
                    } else if (typePremisses().equals("горючі рідини")) {
                        return distances(24);
                    } else if (typePremisses().equals("5.9 ВПВ резервуари")) {
                        return distances(18);
                    }else {
                        return distances(15);
                    }
                }
            }
        } else if (typeObject().equals("2.5 ВПВ технологічні")) {
            if (typeGasStation().equals("тип А або Б")){
                if (sizeGasStation().equals("велика")){
                    if (typePremisses().equals("1 ВПВ заправки")){
                        return distances(50);
                    } else if (typePremisses().equals("2 ВПВ заправки")) {
                        return distances(50);
                    } else if (typePremisses().equals("3 ВПВ заправки")) {
                        return distances(25);
                    } else if (typePremisses().equals("4 ВПВ заправки")) {
                        return distances(18);
                    } else if (typePremisses().equals("5 ВПВ заправки")) {
                        return distances(15);
                    } else if (typePremisses().equals("І, ІІ, ІІІ ступінь")) {
                        return distances(15);
                    } else if (typePremisses().equals("ІІІа, ІІІб, IV, IVa, V ступінь")) {
                        return distances(20);
                    } else if (typePremisses().equals("7 ВПВ заправки")) {
                        return distances(100);
                    } else if (typePremisses().equals("8 ВПВ заправки")) {
                        return distances(20);
                    } else if (typePremisses().equals("хвойні породи") || typePremisses().equals("змішані породи")) {
                        return distances(25);
                    }else {
                        return distances(10);
                    }
                }else {
                    if (typePremisses().equals("1 ВПВ заправки")){
                        if (sizeGasStation().equals("мала")){
                            return distances(20);
                        }else{
                            return distances(40);
                        }
                    } else if (typePremisses().equals("2 ВПВ заправки")) {
                        if (sizeGasStation().equals("мала")){
                            return distances(30);
                        }else{
                            return distances(50);
                        }
                    } else if (typePremisses().equals("3 ВПВ заправки")) {
                        return distances(20);
                    } else if (typePremisses().equals("4 ВПВ заправки")) {
                        return distances(18);
                    } else if (typePremisses().equals("5 ВПВ заправки")) {
                        return distances(15);
                    } else if (typePremisses().equals("І, ІІ, ІІІ ступінь")) {
                        return distances(12);
                    } else if (typePremisses().equals("ІІІа, ІІІб, IV, IVa, V ступінь")) {
                        return distances(18);
                    } else if (typePremisses().equals("7 ВПВ заправки")) {
                        return distances(100);
                    } else if (typePremisses().equals("8 ВПВ заправки")) {
                        return distances(20);
                    } else if (typePremisses().equals("хвойні породи") || typePremisses().equals("змішані породи")) {
                        return distances(25);
                    }else {
                        return distances(10);
                    }
                }
            }else {
                if (sizeGasStation().equals("мала")){
                    if (typePremisses().equals("1 ВПВ заправки")){
                        return distances(50);
                    } else if (typePremisses().equals("2 ВПВ заправки")) {
                        return distances(50);
                    } else if (typePremisses().equals("3 ВПВ заправки")) {
                        return distances(25);
                    } else if (typePremisses().equals("4 ВПВ заправки")) {
                        return distances(20);
                    } else if (typePremisses().equals("5 ВПВ заправки")) {
                        return distances(25);
                    } else if (typePremisses().equals("І, ІІ, ІІІ ступінь")) {
                        return distances(15);
                    } else if (typePremisses().equals("ІІІа, ІІІб, IV, IVa, V ступінь")) {
                        return distances(20);
                    } else if (typePremisses().equals("7 ВПВ заправки")) {
                        return distances(100);
                    } else if (typePremisses().equals("8 ВПВ заправки")) {
                        return distances(25);
                    } else if (typePremisses().equals("хвойні породи") || typePremisses().equals("змішані породи")) {
                        return distances(30);
                    }else {
                        return distances(15);
                    }
                }else {
                    if (typePremisses().equals("1 ВПВ заправки")){
                        return distances(80);
                    } else if (typePremisses().equals("2 ВПВ заправки")) {
                        return distances(80);
                    } else if (typePremisses().equals("3 ВПВ заправки")) {
                        return distances(25);
                    } else if (typePremisses().equals("4 ВПВ заправки")) {
                        return distances(20);
                    } else if (typePremisses().equals("5 ВПВ заправки")) {
                        return distances(30);
                    } else if (typePremisses().equals("І, ІІ, ІІІ ступінь")) {
                        return distances(20);
                    } else if (typePremisses().equals("ІІІа, ІІІб, IV, IVa, V ступінь")) {
                        return distances(25);
                    } else if (typePremisses().equals("7 ВПВ заправки")) {
                        return distances(100);
                    } else if (typePremisses().equals("8 ВПВ заправки")) {
                        return distances(25);
                    } else if (typePremisses().equals("хвойні породи") || typePremisses().equals("змішані породи")) {
                        return distances(40);
                    }else {
                        return distances(15);
                    }
                }
            }
        } else if (typeObject().equals("2.6 ВПВ технологічні")) {
            if (category().equals("категорія І(малої потужності)")){
                if (typePremisses().equals("1 ВПВ заправки")){
                    return distances(100);
                } else if (typePremisses().equals("2 ВПВ заправки")) {
                    return distances(100);
                } else if (typePremisses().equals("3 ВПВ заправки")) {
                    return distances(50);
                } else if (typePremisses().equals("4 ВПВ заправки")) {
                    return distances(30);
                } else if (typePremisses().equals("5 ВПВ заправки")) {
                    return distances(30);
                } else if (typePremisses().equals("6 ВПВ заправки")) {
                    return distances(30);
                } else if (typePremisses().equals("7 ВПВ заправки")) {
                    return distances(100);
                } else if (typePremisses().equals("8 ВПВ заправки")) {
                    return distances(35);
                } else if (typePremisses().equals("хвойні породи") || typePremisses().equals("змішані породи")) {
                    return distances(40);
                }else {
                    return distances(15);
                }
            }else {
                if (typePremisses().equals("1 ВПВ заправки")){
                    return distances(100);
                } else if (typePremisses().equals("2 ВПВ заправки")) {
                    return distances(100);
                } else if (typePremisses().equals("3 ВПВ заправки")) {
                    return distances(50);
                } else if (typePremisses().equals("4 ВПВ заправки")) {
                    return distances(35);
                } else if (typePremisses().equals("5 ВПВ заправки")) {
                    return distances(35);
                } else if (typePremisses().equals("6 ВПВ заправки")) {
                    return distances(30);
                } else if (typePremisses().equals("7 ВПВ заправки")) {
                    return distances(100);
                } else if (typePremisses().equals("8 ВПВ заправки")) {
                    return distances(45);
                } else if (typePremisses().equals("хвойні породи") || typePremisses().equals("змішані породи")) {
                    return distances(45);
                }else {
                    return distances(20);
                }
            }
        } else if (typeObject().equals("2.7 ВПВ технологічні")) {
            if (typeOfFuel().equals(". скраплений вуглеводневий газ")){
                if (typePremisses().equals("1 ВПВ заправки")){
                    return distances(60);
                } else if (typePremisses().equals("2 ВПВ заправки")) {
                    return distances(40);
                } else if (typePremisses().equals("3 ВПВ заправки")) {
                    return distances(100);
                } else if (typePremisses().equals("4 ВПВ заправки")) {
                    return distances(40);
                } else if (typePremisses().equals("5 ВПВ заправки")) {
                    return distances(60);
                } else if (typePremisses().equals("6 ВПВ заправки")) {
                    return distances(100);
                } else if (typePremisses().equals("7 ВПВ заправки")) {
                    return distances(60);
                } else if (typePremisses().equals("8 ВПВ заправки")) {
                    return distances(50);
                } else if (typePremisses().equals("хвойні породи") || typePremisses().equals("змішані породи")) {
                    return distances(50);
                }else {
                    return distances(25);
                }
            }else {
                if (typePremisses().equals("1 ВПВ заправки")){
                    return distances(35);
                } else if (typePremisses().equals("2 ВПВ заправки")) {
                    return distances(25);
                } else if (typePremisses().equals("3 ВПВ заправки")) {
                    return distances(100);
                } else if (typePremisses().equals("4 ВПВ заправки")) {
                    return distances(30);
                } else if (typePremisses().equals("5 ВПВ заправки")) {
                    return distances(35);
                } else if (typePremisses().equals("6 ВПВ заправки")) {
                    return distances(35);
                } else if (typePremisses().equals("7 ВПВ заправки")) {
                    return distances(15);
                } else if (typePremisses().equals("8 ВПВ заправки")) {
                    return distances(30);
                } else if (typePremisses().equals("хвойні породи") || typePremisses().equals("змішані породи")) {
                    return distances(30);
                }else {
                    return distances(55);
                }
            }
        } else if (typeObject().equals("2.8 ВПВ технологічні")) {
            if (fireResistanceFromWhich().equals("І ступінь вогнестійкості") || fireResistanceFromWhich().equals("ІІ ступінь вогнестійкості")){
                return distances(7);
            } else if (fireResistanceFromWhich().equals("ІІІ ступінь вогнестійкості") || fireResistanceFromWhich().equals("ІІІа ступінь вогнестійкості") || fireResistanceFromWhich().equals("ІІІб ступінь вогнестійкості")) {
                return distances(9);
            }else {
                return distances(10);
            }
        } else {
            if (typeGasHolder().equals("поршневий")){
                if (typePremisses().equals("3.1 ВПВ газгольдерів")){
                    return distances(150);
                } else if (typePremisses().equals("до 10000 вугілля")) {
                    return distances(12);
                } else if (typePremisses().equals("від 10000 вугілля")) {
                    return distances(18);
                } else if (typePremisses().equals("3.3 ВПВ газгольдерів")) {
                    return distances(30);
                } else if (typePremisses().equals("до 10000 ліс")) {
                    return distances(36);
                } else if (typePremisses().equals("від 10000 ліс")) {
                    return distances(48);
                } else if (typePremisses().equals("до 500")) {
                    return distances(30);
                } else if (typePremisses().equals("від 500 до 1000")) {
                    return distances(36);
                } else if (typePremisses().equals("від 1000 до 2000")) {
                    return distances(42);
                }else if (typePremisses().equals("до 2500")){
                    return distances(30);
                } else if (typePremisses().equals("від 2500 до 5000")) {
                    return distances(36);
                } else if (typePremisses().equals("від 5000 до 10000")) {
                    return distances(42);
                } else if (typePremisses().equals("І/ІІ ступінь")) {
                    return distances(30);
                } else if (typePremisses().equals("ІІ-V ступінь")) {
                    return distances(36);
                }else {
                    return distances(100);
                }
            }else {
                if (typePremisses().equals("3.1 ВПВ газгольдерів")){
                    return distances(100);
                } else if (typePremisses().equals("до 10000 вугілля")) {
                    return distances(9);
                } else if (typePremisses().equals("від 10000 вугілля")) {
                    return distances(15);
                } else if (typePremisses().equals("3.3 ВПВ газгольдерів")) {
                    return distances(24);
                } else if (typePremisses().equals("до 10000 ліс")) {
                    return distances(30);
                } else if (typePremisses().equals("від 10000 ліс")) {
                    return distances(42);
                } else if (typePremisses().equals("до 500")) {
                    return distances(24);
                } else if (typePremisses().equals("від 500 до 1000")) {
                    return distances(30);
                } else if (typePremisses().equals("від 1000 до 2000")) {
                    return distances(36);
                }else if (typePremisses().equals("до 2500")){
                    return distances(24);
                } else if (typePremisses().equals("від 2500 до 5000")) {
                    return distances(30);
                } else if (typePremisses().equals("від 5000 до 10000")) {
                    return distances(36);
                } else if (typePremisses().equals("І/ІІ ступінь")) {
                    return distances(24);
                } else if (typePremisses().equals("ІІ-V ступінь")) {
                    return distances(30);
                }else {
                    return distances(100);
                }
            }
        }
    }
    public String getFireProtectionDistancesTechnological(){
        return fireProtectionDistancesTechnological();
    }
    private String fireProtectionDistancesCommunications(){
        if (typeObject().equals("2.1 ВПВ комунікації")){
            if (category().equals("категорія складу - І")){
                if (subcategory().equals("підкатегорія – Іа")){
                    if (typePremisses().equals("водопровідні")){
                        return distances(200);
                    }else {
                        return distances(75);
                    }
                }else {
                    if (typePremisses().equals("водопровідні")){
                        return distances(175);
                    }else {
                        return distances(60);
                    }
                }
            } else if (category().equals("категорія складу - ІІ")) {
                if (subcategory().equals("підкатегорія – IІа")){
                    if (typePremisses().equals("водопровідні")){
                        return distances(150);
                    }else {
                        return distances(50);
                    }
                }else {
                    if (typePremisses().equals("водопровідні")){
                        return distances(100);
                    }else {
                        return distances(40);
                    }
                }
            }else {
                if (subcategory().equals("підкатегорія – IIІа")){
                    if (typePremisses().equals("водопровідні")){
                        return distances(100);
                    }else {
                        return distances(30);
                    }
                } else if (subcategory().equals("підкатегорія – ІIIб")) {
                    if (typePremisses().equals("водопровідні")){
                        return distances(75);
                    }else {
                        return distances(25);
                    }
                }else {
                    if (typePremisses().equals("водопровідні")){
                        return distances(75);
                    }else {
                        return distances(20);
                    }
                }
            }
        }else if (typeObject().equals("2.2 ВПВ комунікації")){
            if (locationPipeline().equals("наземне")){
                if (typePremisses().equals("4.1 трубопроводи ВПВ")){
                    return distances(3);
                } else if (typePremisses().equals("до 2,5 МПа")) {
                    return distances(12.5);
                } else if (typePremisses().equals("більше 2,5 МПа")) {
                    return distances(25);
                } else if (typePremisses().equals("4.3 трубопроводи ВПВ")) {
                    return distances(3);
                } else if (typePremisses().equals("4.4 трубопроводи ВПВ")) {
                    return distances(1);
                }else if (typePremisses().equals("до 1 кВ")){
                    return distances(1);
                }else if (typePremisses().equals("більше 1 кВ до 35 кВ")){
                    return distances(5);
                } else if (typePremisses().equals("більше 35 кВ")) {
                    return distances(10);
                } else if (typePremisses().equals("4.6 трубопроводи ВПВ")) {
                    return distances(10);
                } else if (typePremisses().equals("4.7 трубопроводи ВПВ")) {
                    return distances(1.5);
                } else if (typePremisses().equals("4.8 трубопроводи ВПВ")) {
                    return distances(3);
                }else {
                    return distances(1);
                }
            }else {
                if (typePremisses().equals("4.1 трубопроводи ВПВ")){
                    return distances(3);
                } else if (typePremisses().equals("до 2,5 МПа")) {
                    return distances(5);
                } else if (typePremisses().equals("більше 2,5 МПа")) {
                    return distances(10);
                } else if (typePremisses().equals("4.3 трубопроводи ВПВ")) {
                    return distances(4);
                } else if (typePremisses().equals("4.4 трубопроводи ВПВ")) {
                    return distances(1.5);
                }else if (typePremisses().equals("до 1 кВ")){
                    return distances(1.5);
                }else if (typePremisses().equals("більше 1 кВ до 35 кВ")){
                    return distances(5);
                } else if (typePremisses().equals("більше 35 кВ")) {
                    return distances(10);
                } else if (typePremisses().equals("4.6 трубопроводи ВПВ")) {
                    return distances(10);
                } else if (typePremisses().equals("4.7 трубопроводи ВПВ")) {
                    return distances(1.5);
                } else if (typePremisses().equals("4.8 трубопроводи ВПВ")) {
                    return distances(3);
                }else {
                    return distances(1);
                }
            }
        } else if (typePremisses().equals("2.3 ВПВ комунікації")) {
            if (typeLiquid().equals("легкозаймисті/горючі рідини")){
                if (typePremisses().equals("4.1 2.3 ВПВ комунікації")){
                    return distances(15);
                } else if (typePremisses().equals("4.2 2.3 ВПВ комунікації")) {
                    return distances(10);
                } else if (typePremisses().equals("до 300 мм")) {
                    return distances(15);
                }else {
                    return distances(25);
                }
            }else {
                if (typePremisses().equals("4.1 2.3 ВПВ комунікації")){
                    return distances(10);
                } else if (typePremisses().equals("4.2 2.3 ВПВ комунікації")) {
                    return distances(5);
                } else if (typePremisses().equals("до 300 мм")) {
                    return distances(10);
                }else {
                    return distances(15);
                }
            }
        } else if (typeObject().equals("2.4 ВПВ комунікації")) {
            if (typePremisses().equals("тип АЗС А або Б")){
                return distances(15);
            } else if (typePremisses().equals("мала АЗС")) {
                return distances(25);
            }else if (typePremisses().equals("середня АЗС")){
                return distances(30);
            } else if (typePremisses().equals("3.2 2.4 ВПВ комунікації")) {
                return "Висновок: протипожежна відстань становить не менше 1,5 висоти опори лінії";
            } else if (typePremisses().equals("3.3 2.4 ВПВ комунікації")) {
                return distances(13);
            } else if (typePremisses().equals("кабельні")) {
                return distances(13);
            } else if (typePremisses().equals("повітряні")) {
                return "Висновок: протипожежна відстань становить не менше 1,5 висоти опори лінії";
            }else {
                return distances(5);
            }
        }else {
            if (typePremisses().equals("4.1 2.5 ВПВ комунікації")){
                return distances(2);
            } else if (typePremisses().equals("4.2 2.5 ВПВ комунікації")) {
                return distances(4);
            } else if (typePremisses().equals("4.3 2.5 ВПВ комунікації")) {
                return distances(7);
            } else if (typePremisses().equals("4.4 2.5 ВПВ комунікації")) {
                return distances(10);
            } else if (typePremisses().equals("3.2 2.5 ВПВ комунікації")) {
                return distances(0.6);
            }else {
                return distances(2);
            }
        }
    }
    public String getFireProtectionDistancesCommunications(){
        return fireProtectionDistancesCommunications();
    }
}
