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
    float volume(){return databaseRepository.getVolume_premises(userId);}
    String typePremisses(){return databaseRepository.getType_premises(userId);}
    String category(){return databaseRepository.getCategory_premises(userId);}

    private String result(int fire, int consumption){
        return  "Висновок: розрахункова кількість одночасних пожеж – " + fire + " \uD83D\uDD25, розрахункові витрати води на зовнішнє пожежогасіння в населеному пункті – " + consumption + "л/с \uD83D\uDCA7";
    }
    private String notStandardized(){return "Висновок: не нормується";}
    private String costs(int costs){return "Висновок: витрати на зовнішнє пожежогасіння складають - " + costs + "\uD83D\uDCA7 л/с";}
    private String noLessCosts(int costs){return "Висновок: витрати на зовнішнє пожежогасіння складають – не менше " + costs + "\uD83D\uDCA7 л/с";}
    private String incorrectFloors(boolean value, int floors){
        if (value)return "Ви ввели не корректні дані. Можлива максимальна кількість поверхів відповідно до об'єму будівлі - " + floors;
        else return "Ви ввели не корректні дані. Можлива мінімальна кількість поверхів відповідно до об'єму будівлі - " + floors;
    }
    private String incorrectVolume(int volume){
        return "Ви введи не корректні дані. Максимальний можливий об'єм для будівлі обраної вами категорії за вибухопожежною та пожежною небезпекою - " + volume+ " м.куб";
    }
    private String settlement(){
        if (residents()<=1000){
            if (floors()<=2){
                return result(1,5);
            }else {
                return result(1,10);
            }
        } else if (residents()>1000 && residents()<=5000) {
            return result(1,10);
        } else if (residents() > 5000 && residents() <=10000) {
            if (floors()<=2){
                return result(1,10);
            }else {
                return result(1,15);
            }
        } else if (residents()>10000 & residents()<=25000) {
            if (floors()<=2){
                return result(2,10);
            }else {
                return result(2,15);
            }
        } else if (residents()>25000 && residents()<=50000) {
            if (floors()<=2){
                return result(2,20);
            }else {
                return result(2,25);
            }
        } else if (residents()>50000 && residents()<=100000) {
            if (floors()<=2){
                return result(2,25);
            }else {
                return result(2,35);
            }
        } else if (residents()>100000 & residents()<=200000) {
            if (floors()<=2){
                return notStandardized();
            }else {
                return result(3,40);
            }
        } else if (residents()>200000 && residents()<=300000) {
            if (floors()<=2){
                return notStandardized();
            }else {
                return result(3,55);
            }
        } else if (residents()>300000 && residents() <=400000) {
            if (floors()<=2){
                return notStandardized();
            }else {
                return result(3,70);
            }
        } else if (residents()<400000 && residents()<=500000) {
            if (floors()<=2){
                return notStandardized();
            }else {
                return result(3,80);
            }
        } else if (residents()>500000 && residents()<=600000) {
            if (floors()<=2){
                return notStandardized();
            }else {
                return result(3,85);
            }
        } else if (residents()>600000 & residents()<=700000) {
            if (floors()<=2){
                return notStandardized();
            }else {
                return result(3,90);
            }
        } else if (residents()>700000 && residents()<=800000) {
            if (floors()<=2){
                return notStandardized();
            }else {
                return result(3,95);
            }
        } else if (residents()>800000 & residents()<1000000) {
            if (floors()<=2){
                return notStandardized();
            }else {
                return result(3,100);
            }
        }else {
            if (floors()<=2){
                return notStandardized();
            }else {
                return "Висновок: для кожної частини міста до 1000000 чоловік розрахункова кількість одночасних пожеж – 3 \uD83D\uDD25, " +
                        "розрахункові витрати води на зовнішнє пожежогасіння в населеному пункті – 100 л/с \uD83D\uDCA7";
            }
        }
    }
    public String getSettlement(){
        return settlement();
    }

    private String externalResidential(){
        if (volume()<=1000){
            if (floors()<=12){
                return costs(10);
            }else {
                return incorrectFloors(true,12);
            }
        } else if (volume()>1000 && volume() <=5000) {
            if (floors() <= 2){
                return costs(10);
            } else if (floors()>2 && floors()<=12) {
                return costs(15);
            }else {
                return incorrectFloors(true,12);
            }
        } else if (volume()>5000 && volume()<=25000) {
            if (floors()<3){
                return incorrectFloors(false,3);
            } else if (floors()>=3 && floors() <=12) {
                return costs(15);
            } else if (floors()>12 && floors()<=16) {
                return costs(20);
            }else {
                return incorrectFloors(true,16);
            }
        } else if (volume()>25000 && volume()<=50000) {
            if (floors()<3){
                return  incorrectFloors(false,3);
            } else if (floors() >=3 && floors()<=12) {
                return costs(20);
            } else if (floors()>12 && floors()<=25) {
                return costs(25);
            } else {
                return noLessCosts(35);
            }
        } else if (volume()>50000 && volume()<=150000) {
            if (floors()<17){
                return incorrectFloors(false,17);
            } else if (floors()>=17 && floors()<=25) {
                return costs(30);
            }else {
                return noLessCosts(35);
            }
        }else {
            return "Висновок: витрати на зовнішнє протипожежне водопостачання приймати за індивідуальними технічними умовами або" +
                    " здійснювати поділ на протипожежні зони до 150000 м3 та передбачати витрати на зовнішнє пожежогасіння" +
                    " – 30 \uD83D\uDCA7 л/с для кожної зони";
        }
    }
    public String getExternalResidential(){
        return externalResidential();
    }
    private String externalPublic(){
        if (volume()<=1000){
            if (floors()<=6){
                return costs(10);
            }else {
                return incorrectFloors(true,6);
            }
        } else if (volume()>1000 && volume() <=5000) {
            if (floors() <= 2){
                return costs(10);
            } else if (floors()>2 && floors()<=6) {
                return costs(15);
            }else {
                return incorrectFloors(true,6);
            }
        } else if (volume()>5000 && volume()<=25000) {
            if (floors()<=2){
                return costs(15);
            } else if (floors()>2 && floors()<=6) {
                return costs(20);
            } else if (floors()>6 && floors()<=12) {
                return costs(25);
            }else {
                return incorrectFloors(true,12);
            }
        } else if (volume()>25000 && volume()<=50000) {
            if (floors()<3){
                return incorrectFloors(false,3);
            } else if (floors()>=3 && floors()<=6) {
                return costs(25);
            } else if (floors()>6 && floors()<=16) {
                return costs(30);
            } else{
                return noLessCosts(35);
            }
        } else if (volume()>50000 && volume()<=150000) {
            if (floors()<3){
                return incorrectFloors(false,3);
            } else if (floors()>=3 && floors()<=6) {
                return costs(30);
            } else if (floors()>6 && floors()<=16) {
                return costs(35);
            }else {
                return noLessCosts(35);
            }
        } else{
            return "Висновок: витрати на зовнішнє протипожежне водопостачання приймати за індивідуальними технічними" +
                    " умовами або здійснювати поділ на протипожежні зони до 150000 м3 та передбачати витрати на зовнішнє" +
                    " пожежогасіння – 35 \uD83D\uDCA7 л/с для кожної зони";
        }
    }
    public String getExternalPublic(){
        return externalPublic();
    }
    private String externalStorage(){
        if (typePremisses().equals("1 ступінь")){
            if (category().equals("А") || category().equals("Б") || category().equals("В")){
                if (volume()<=5000){
                    return costs(10);
                } else if (volume()>5000 && volume()<20000) {
                    return costs(15);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(20);
                } else if (volume()>50000 && volume()<=200000) {
                    return costs(30);
                } else if (volume()>200000 && volume()<=400000) {
                    return costs(35);
                } else if (volume()>400000 && volume()<=600000) {
                    return costs(40);
                }else {
                    return costs(40) + " для кожної частини будівлі";
                }
            } else {
                if (volume()<=50000){
                    return costs(10);
                } else if (volume()>50000 && volume()<=200000) {
                    return costs(15);
                } else if (volume()>200000 && volume()<=400000) {
                    return costs(20);
                } else if (volume()>400000 && volume()<=600000) {
                    return costs(25);
                }else {
                    return costs(25) + " для кожної частини будівлі";
                }
            }
        } else if (typePremisses().equals("3 ступінь")) {
            if (category().equals("В")){
                if (volume()<=3000){
                    return costs(10);
                } else if (volume()>3000 && volume()<=5000) {
                    return costs(15);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(20);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(30);
                } else if (volume()>50000 && volume()<=20000) {
                    return costs(40);
                }else {
                    return incorrectVolume(200000);
                }
            } else {
                if (volume()<=5000){
                    return costs(10);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(15);
                } else if (volume()>20000 && volume() <=50000) {
                    return costs(25);
                } else if (volume()>50000 && volume()<=200000) {
                    return costs(35);
                }else{
                    return incorrectVolume(200000);
                }
            }
        } else if (typePremisses().equals("3а ступінь")) {
            if (category().equals("А") || category().equals("Б") || category().equals("В")){
                if (volume()<=5000){
                    return costs(15);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(20);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(25);
                } else if (volume()>50000 && volume()<=200000) {
                    return costs(35);
                }else return incorrectVolume(200000);
            } else {
                if (volume()<=5000){
                    return costs(10);
                } else if (volume()>5000 & volume()<=50000) {
                    return costs(15);
                } else if (volume()>50000 && volume()<=200000) {
                    return costs(20);
                }else return incorrectVolume(200000);
            }
        } else if (typePremisses().equals("3б ступінь")) {
            if (category().equals("В")){
                if (volume()<=3000){
                    return costs(20);
                } else if (volume()>3000 && volume()<=5000) {
                    return costs(25);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(30);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(45);
                }else return incorrectVolume(50000);
            }else {
                if (volume()<=3000){
                    return costs(15);
                } else if (volume()>3000 && volume()<=5000) {
                    return costs(20);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(25);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(35);
                }else return incorrectVolume(50000);
            }
        } else if (typePremisses().equals("4 ступінь") || typePremisses().equals("5 ступінь")) {
            if (category().equals("В")||category().equals("Д")){
                if (volume()<=3000){
                    return costs(15);
                } else if (volume()>3000 && volume()<=5000) {
                    return costs(20);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(25);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(40);
                }else return incorrectVolume(50000);
            }else {
                if (volume()<=3000){
                    return costs(10);
                } else if (volume()>3000 && volume()<=5000) {
                    return costs(15);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(20);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(30);
                }else return incorrectVolume(50000);
            }
        } else if (typePremisses().equals("4а ступінь")) {
            if (category().equals("В")){
                if (volume()<=3000){
                    return costs(25);
                } else if (volume()>3000 && volume()<=5000) {
                    return costs(30);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(35);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(50);
                }else return incorrectVolume(50000);
            }else {
                if (volume()<=3000){
                    return costs(20);
                } else if (volume()>3000 && volume()<=5000) {
                    return costs(25);
                } else if (volume()>5000 && volume()<=20000) {
                    return costs(30);
                } else if (volume()>20000 && volume()<=50000) {
                    return costs(40);
                }else return incorrectVolume(50000);
            }
        }else{
            return "Невідома помилка";
        }
    }
    public String getExternalStorage(){
        return externalStorage();
    }


}