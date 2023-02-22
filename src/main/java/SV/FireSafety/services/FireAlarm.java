package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class FireAlarm {
    Long userId;
    DatabaseRepository databaseRepository;

    public FireAlarm(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }

    float square() {
        return databaseRepository.getSquare(userId);
    }

    float heightObject(){
        return databaseRepository.getHeight_object(userId);
    }
    float weight(){
        return  databaseRepository.getWeight(userId);
    }
    float volumePremisses(){
        return databaseRepository.getVolume_premises(userId);
    }
    float length(){return databaseRepository.getLength(userId);}
    float productivity(){return databaseRepository.getProductivity(userId);}
    int floors(){
        return databaseRepository.getFloors(userId);
    }
    int hotelRooms(){
        return databaseRepository.getHotel_rooms(userId);
    }
    int amountOfTransport(){
        return databaseRepository.getAmount_of_transport(userId);
    }
    int booksStorage(){
        return databaseRepository.getBooks_storage(userId);
    }
    int seats(){
        return databaseRepository.getSeats(userId);
    }
    String typeOfObjectFireAlarm(){
        return databaseRepository.getType_of_object_fire_alarm(userId);
    }
    String fireResistance(){
        return databaseRepository.getFire_resistance(userId);
    }
    String categoryBuildings(){return databaseRepository.getCategory_buildings(userId);}
    String categoryPremisses(){return databaseRepository.getCategory_premises(userId);}
    String text = "Висновок: ";

    private String roomsEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть кількість номерів для проживання та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getRoomsEmpty(){
        return roomsEmpty();
    }

    private String heightEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть умовну висоту будівлі (м.) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getHeightEmpty(){
        return heightEmpty();
    }

    private String squareEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getSquareEmpty(){
        return squareEmpty();
    }

    private String floorsEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getFloorsEmpty(){
        return floorsEmpty();
    }

    private String fireResistanceEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть ступінь вогнестійкості будівлі (1,2,3,3a,3б,4,4a,5) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getFireResistanceEmpty(){
        return fireResistanceEmpty();
    }

    private String seatsEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть місткість зали для глядачів та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getSeatsEmpty(){
        return seatsEmpty();
    }

    private String booksStorageEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть  фонд зберігання умовних одиниць літератури(тис.умовних одиниць) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getBooksStorageEmpty(){
        return booksStorageEmpty();
    }

    private String amountOfTransportEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть  кількість одиниць автотранспорту та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getAmountOfTransportEmpty(){
        return amountOfTransportEmpty();
    }

    private String weightEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальну вагу (кг.) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getWeightEmpty(){
        return weightEmpty();
    }

    private String volumeEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальний об'єм (м.куб) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getVolumeEmpty(){
        return volumeEmpty();
    }

    private String lengthEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть загальну довжину (м.) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getLengthEmpty(){
        return lengthEmpty();
    }

    private String productivityEmpty(){
        return  "Ви не ввели рекомендовані системою параметри.\n\n" +
                "Надішліть продуктивність (м.куб/год) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getProductivityEmpty(){
        return productivityEmpty();
    }


    //житлові будинки
    private String housing(){
        if ((heightObject())<=26.5){
            text += "не підлягають обладнанню системою пожежної сигналізації, підлягають обладнанню усі вбудовані приміщення різного призначення незалежно від площі \uD83C\uDFE0";
        }else if ((heightObject())>26.5 && (heightObject()) <= 47){
            text += "підлягають обладнанню передпокої житлових квартир та усі вбудовані приміщення різного призначення незалежно від площі \uD83C\uDFE0";
        }else if ((heightObject()) > 47 && (heightObject()) <= 73.5){
            text += "підлягають обладнанню системою пожежної сигналізації, передпокої житлових квартир, поза квартирні коридори, ліфтові холи та усі вбудовані приміщення різного призначення незалежно від площі \uD83C\uDFE0";
        }else if ((heightObject()) > 73.5 && (heightObject()) <= 100){
            text += "підлягають обладнанню системою пожежної сигналізації, передпокої житлових квартир, позаквартирні коридори, ліфтові холи та усі вбудовані приміщення різного призначення незалежно від площі та підлягають обладнанню системою автоматичного пожежогасіння усі вбудовані і прибудовані громадські та інші нежитлові приміщення, автостоянки, допоміжні та технічні приміщення, сміттєзабірні, стовбур сміттєпроводу \uD83C\uDFE0";
        }else{
            text += "обладнання системами пожежної сигналізації та автоматичного пожежогасіння визначається індивідуальними технічними вимогами на кожен об’єкт окремо \uD83C\uDFE0";
        }
        return text;
    }

    public String getHousing(){
        return housing();
    }

    //будинок пристарілих
    private String nursingHome(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFE0";
        return text;
    }

    public String getNursingHome(){
        return nursingHome();
    }

    //гуртожиток
    private String dormitory(){
        if ((heightObject())<= 26.5){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }else{
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getDormitory(){
        return dormitory();
    }

    private String hotel(){
        if (hotelRooms()<7){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення при загальній площі більше 300 м2 \uD83C\uDFE8";
        }else if (hotelRooms()>=7 && hotelRooms()<50){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFE8";
        }else{
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення \uD83C\uDFE8  \n\n";
        }
        return text;
    }
    public String getHotel(){
        return hotel();
    }

    private String hotelHeight(){
        if (heightObject()<26.5){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення із врахуванням кількості номерів \uD83C\uDFE8";
        }else if (heightObject()>=26.5 && heightObject()<100){
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення та обладнанню системою автоматичного пожежогасіння усі приміщення \uD83C\uDFE8";
        }else {
            text += "обладнання системами пожежної сигналізації та автоматичного пожежогасіння визначається індивідуальними технічними вимогами \uD83C\uDFE8";
        }
        return text;
    }

    public String getHotelHeigth(){
        return hotelHeight();
    }

    private String office(){
        if (heightObject()<3){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення при загальній площі більше 300 м2 \uD83C\uDFE2";
        }else if (heightObject()>=3 && heightObject()<26.5){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFE2";
        }else if (heightObject()>=26.5 && heightObject()<47){
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення \uD83C\uDFE2";
        }else if (heightObject()>=47 && heightObject()<100){
            text += "підлягають обладнанню адресною системою пожежної сигналізації та автоматичного пожежогасіння усі приміщення \uD83C\uDFE2";
        }else{
            text += "обладнання системами пожежної сигналізації та автоматичного пожежогасіння визначається індивідуальними технічними вимогами \uD83C\uDFE2";
        }
        return text;
    }

    public String getOffice(){
        return office();
    }

    private String stateAuthorities(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення цінних документів, архівів, центрів обробки даних \uD83C\uDFE2";
        return text;
    }

    public String getStateAuthorities(){
        return stateAuthorities();
    }

    private String bank(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння сховища цінностей та їх відсіки \uD83C\uDFE6";
        return text;
    }

    public String getBank(){
        return bank();
    }

    private String undergroundMall(){
        if (square()<400){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння торгівельні зали площею більше 150 м2 \uD83C\uDFEC";
        }else if (square()>=400 && square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }else{
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getUndergroundMall(){
        return undergroundMall();
    }

    private String groundMall(){
        if (floors()==1){
            if (square()<3500){
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння при загальній площі більше допустимої площі протипожежного відсіку усі приміщення \uD83C\uDFEC";
            }else{
                text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння при загальній площі більше допустимої площі протипожежного відсіку усі приміщення  \uD83C\uDFEC";
            }
        }else if (floors() == 2){
            if (square()<3500){
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
            }else {
                text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння при загальній площі торгових залів більше 3500 м2 усі приміщення \uD83C\uDFEC";
            }
        }else{
            if (square()<1000){
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
            }else {
                text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
            }
        }
        return text;
    }

    public String getGroundMall(){
        return groundMall();
    }

    private String agriculturalMall(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення камер схову, у яких зберігаються матеріальні цінності, окрім приміщень категорії Д, незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String  getAgriculturalMall(){
        return agriculturalMall();
    }

    private String builtInCatering(){
        if (heightObject()<47){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFE0";
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFE0";
        }
        return text;
    }
    public String getBuiltInCatering(){
        return builtInCatering();
    }

    private String separateCatering(){
        if (floors()==1){
            if (square()<50){
                text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
            }else if (square()>=50 && square()<3500){
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
            }else{
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
            }
        }else if (floors()==2){
            if (square()<2500){
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
            }else{
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
            }
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації та автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }

    public String getSeparateCatering(){
        return separateCatering();
    }

    private String exhibitionUnderground(){
        if (square()<400){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння виставкові зали площею більше 150 м2 \uD83C\uDFDB";
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
        }
        return text;
    }

    public String getExhibitionUnderground(){
        return exhibitionUnderground();
    }

    private String exhibitionGround(){
        if (floors()==1){
            if (fireResistance().equals("1") || fireResistance().equals("2")){
                if (square()<3500){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else{
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else if (fireResistance().equals("3")){
                if (square()<2000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else if (fireResistance().equals("3а")||fireResistance().equals("3б")){
                if (square()<1000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else if (fireResistance().equals("4") || fireResistance().equals("4а") || fireResistance().equals("5")){
                if (square()<500){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else{
                text = "Ступінь вогнестійкості будівлі введено не коректно. Спробуйте ввести (1,2,3,3a,3б,4,4a,5) ступені вогнестійкості.";
            }
        }else{
            if (fireResistance().equals("1") || fireResistance().equals("2")){
                if (square()<3000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else if (fireResistance().equals("3")){
                if (square()<1000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else{
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else{
                text =  "Ступінь вогнестійкості будівлі введено не коректно. Спробуйте ввести (1,2,3) ступені вогнестійкості.";
            }
        }
        return text;
    }
    public String getExhibitionGround(){
        return exhibitionGround();
    }

    private String theatre(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення під колосниками сцени і ар’єрсцени, яруси робочих галерей і усі перехідні містки крім нижніх, сейф згорнутих декорацій, всі прорізи сцени, порталу сцени, частини трюму із вбудованим обладнанням, покриття сцени та ар’єрсцени, кармани сцени, складські приміщення і комори, майстерні, приміщення монтажу декорацій, камери пиловидалення, виробничі приміщення і резервні склади, демонстраційні комплекси місткістю 600 і більше місць \uD83C\uDFE4";
        return text;
    }
    public String getTheatre(){
        return theatre();
    }

    private String circus(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення складів декорацій, бутафорії і реквізиту, столярні, фуражні, інвентарні та господарські комори, приміщення зберігання і виготовлення реклами, виробничі приміщення, приміщення для тварин, підкупольний простір над залою для глядачів, естакадою, гімнастичним майданчиком, кармани арени й портали виходів на арену і естраду \uD83C\uDFAA";
        return text;
    }
    public String getCircus(){
        return circus();
    }

    private String cinema(){
        if (seats()<700){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFA5";
        }else{
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення під колосниками сцени і ар’єрсцени, яруси робочих галерей і усі перехідні містки крім нижніх, сейф згорнутих декорацій, всі прорізи сцени, порталу сцени, частини трюму із вбудованим обладнанням, покриття сцени та ар’єрсцени, кармани сцени, складські приміщення і комори, майстерні, приміщення монтажу декорацій, камери пиловидалення \uD83C\uDFA5";
        }
        return text;
    }
    public String getCinema(){
        return cinema();
    }

    private String casino(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення";
        }else if (square()>=500 &&  square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }else {
            text+= "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getCasino(){
        return casino();
    }

    private String museum(){
        text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення зберігання музейного фонду \uD83C\uDFDB";
        return text;
    }
    public String getMuseum(){
        return museum();
    }

    private String library(){
        if (booksStorage()<500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення сховищ, архівів, комор, ремонтних майстерень, палітурно-брошурувальних, збирання і обробки макулатури \uD83D\uDCDA";
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення сховищ, архівів, комор, ремонтних майстерень, палітурно-брошурувальних, збирання і обробки макулатури \uD83D\uDCDA";
        }
        return text;
    }

    public String getLibrary(){
        return library();
    }

    private String libraryOtherBuildings(){
        if (booksStorage()<500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDCDA";
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення \uD83D\uDCDA";
        }
        return text;
    }

    public String getLibraryOtherBuildings(){
        return libraryOtherBuildings();
    }

    private String archive(){
        if (square()<400){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDCD6";
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDCD6";
        }
        return text;
    }

    public String getArchive(){
        return archive();
    }

    private String institutes(){
        if (heightObject()<26.5){
            if (floors()==1){
                if (square()<=300 && !databaseRepository.getArchives(userId)){
                    text += "не підлягають обладнанню системою пожежної сигналізації \uD83D\uDCDA";
                }else if (square()<=300 && databaseRepository.getArchives(userId)){
                    text += "підлягають системою автоматичного пожежогасіння зазначені приміщення \uD83D\uDCDA";
                }else {
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення зберігання цінних документів та архівів \uD83D\uDCDA";
                }
            }else{
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення зберігання цінних документів та архівів \uD83D\uDCDA";
            }
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDCDA";
        }
        return text;
    }

    public String getInstitutes(){
        return institutes();
    }

    private String preschool(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення крім приміщень приготування їжі \uD83C\uDFEB";
        return text;
    }
    public String getPreschool(){
        return preschool();
    }

    private String school(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEB";
        return text;
    }
    public String getSchool(){
        return school();
    }

    private String specialSchool(){
        text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення \uD83C\uDFEB";
        return text;
    }

    public String getSpecialSchool(){
        return specialSchool();
    }

    private String healthCare(){
        if (heightObject()<26.5){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння склади та приміщення оперативного зберігання горючих і легкозаймистих рідин та хімікатів, приміщення з унікальним обладнанням \uD83C\uDFE5";
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння склади та приміщення оперативного зберігання горючих і легкозаймистих рідин та хімікатів, приміщення з унікальним обладнанням \uD83C\uDFE5";
        }
        return text;
    }

    public String getHealthCare(){
        return healthCare();
    }

    private String sport(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння елінги, криті споруди місткістю більше 800 місць, склади горючих матеріалів і негорючих у горючій упаковці площею більше 100 м2, підтрибунні простори \uD83C\uDFDF";
        return text;
    }
    public String getSport(){
        return sport();
    }
    private String religious(){
        if (square()<300){
            text += "не підлягає обладнанню системою пожежної сигналізації ⛪️";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення ⛪️";
        }
        return text;
    }
    public String getReligious(){
        return religious();
    }

    private String station(){
        if (square()<3500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDE9B";
        }else{
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE9B";
        }
        return text;
    }
    public String getStation(){
        return station();
    }
    private String hangar(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE9B";
        return text;
    }
    public String getHangar(){
        return hangar();
    }

    private String airTransport(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDE9B";
        return text;
    }
    public String getAirTransport(){
        return airTransport();
    }

    private String depot(){
        if (square()<7000){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDE83";
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE83";
        }
        return text;
    }
    public String getDepot(){
        return depot();
    }
    private String undergroundGarages(){
        if (amountOfTransport()<25){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDE8D";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE8D";
        }
        return text;
    }
    public String getUndergroundGarages(){
        return undergroundGarages();
    }

    private String garages(){
        if (floors()==1){
            if (fireResistance().equals("1")|| fireResistance().equals("2")){
                if (square()<7000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDE8D";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE8D";
                }
            }else if (fireResistance().equals("3а")){
                if (square() < 3600){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення";
                }else{
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE8D";
                }
            }else {
                if (square()<2000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDE8D";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE8D";
                }
            }
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення\uD83D\uDE8D";
        }
        return text;
    }
    public String getGarages(){
        return garages();
    }
    private String mechanizedGarages(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE8D";
        return text;
    }
    public String getMechanizedGarages(){
        return mechanizedGarages();
    }
    private String gasStation(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння приміщення категорії «В», складські приміщення з наявністю легкозаймистих та горючих рідин, пости технічного обслуговування від 100 м2, БП АЗС та АГЗП об’ємом від 500 м3 ⛽️";
        return text;
    }
    public String getGasStation(){
        return gasStation();
    }
    private String carDealership(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDE99";
        }else {
            text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83D\uDE99";
        }
        return text;
    }
    public String getCarDealership(){
        return carDealership();
    }

    private String productionBuilding(){
        if (categoryBuildings().equals("В")){
            if (floors()==1){
                if (square()<1000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFED";
                }else {
                    text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFED";
                }
            }else {
                if (square()<500){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFED";
                }else {
                    text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFED";
                }
            }
        }else {
            if (floors()==1){
                if (square()<300){
                    text += "– підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFED";
                }else {
                    text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFED";
                }
            }else {
                text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFED";
            }
        }
        return text;
    }
    public String getProductionBuilding(){
        return productionBuilding();
    }

    private String storageA(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getStorageA(){
        return storageA();
    }

    private String storageB(){
        if (square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getStorageB(){
        return storageB();
    }

    private String storageRack(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        return text;
    }
    public String getStorageRack(){
        return storageRack();
    }

    private String storageRubber(){
        if (floors()==1){
            if (square()<750){
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
            }
        }else{
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }

    public String getStorageRubber(){
        return storageRubber();
    }

    private String storageNonCombustibleSubstances(){
        if (square()<1500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getStorageNonCombustibleSubstances(){
        return storageNonCombustibleSubstances();
    }

    private String storageSaltpeter(){
        if (square()<700){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getStorageSaltpeter(){
        return storageSaltpeter();
    }

    private String storageFilm(){
        if (weight()<200){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }else {
            text +="підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getStorageFilm(){
        return storageFilm();
    }

    private String storageEngine(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getStorageEngine(){
        return storageEngine();
    }

    private String alcoholTanks(){
        if (volumePremisses()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getAlcoholTanks(){
        return alcoholTanks();
    }
    private String oilTanks(){
        if (volumePremisses()<5000){
            text += "не підлягають обладнанню системами протипожежного захисту \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getOilTanks(){
        return oilTanks();
    }

    private String oilPremissesBellow120(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getOilPremissesBellow120(){
        return oilPremissesBellow120();
    }

    private String oilPremissesHigher120(){
        if (square()<750){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getOilPremissesHigher120(){
        return oilPremissesHigher120();
    }
    private String closedStorage(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getClosedStorage(){
        return closedStorage();
    }

    private String breadProductsStorage(){
        if (typeOfObjectFireAlarm().equals("наявні приміщення")){
            text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else{
            text += "не підлягають обладнанню системою пожежної сигналізації лише ті приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getBreadProductsStorage(){
        return breadProductsStorage();
    }

    private String flourStorage(){
        if (square()<100){
            text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else if (square()>=100 && square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації зазначені приміщення \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння зазначені приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getFlourStorage(){
        return flourStorage();
    }

    private String vitaminsStorage(){
        if (square()<200){
            text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else if (square()>200 && square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації зазначені приміщення \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння зазначені приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getVitaminsStorage(){
        return vitaminsStorage();
    }

    private String materialStorage(){
        if (square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getMaterialStorage(){
        return materialStorage();
    }

    private String poultryFarm(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        return text;
    }
    public String getPoultryFarm(){
        return poultryFarm();
    }

    private String barn(){
        if (square()<1500){
            text += "не підлягає обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getBarn(){
        return barn();
    }

    private String pesticidesStorage(){
        if (square()<100){
            text += "не підлягає обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        } else if (square()>=100 && square()<500) {
            text += "підлягає обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        }
        return text;
    }
    public String getPesticidesStorage(){
        return pesticidesStorage();
    }

    private String railwayTunnel(){
        text += "підлягають обладнанню системою пожежної сигналізації допоміжні приміщення тунелю та системою автоматичного пожежогасіння при протяжності більше 2000 м \uD83C\uDFEC";
        return text;
    }
    public String getRailwayTunnel(){
        return railwayTunnel();
    }
    private String carTunnel(){
        if (length()<500){
            text += "не підлягає обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння за індивідуальними технічними умовами";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння за індивідуальними технічними умовами";
        }
        return text;
    }
    public String getCarTunnel(){
        return carTunnel();
    }

    private String pumpingStation(){
        text += "підлягають обладнанню системою пожежної сигналізації приміщення персоналу, газоперекачувальних агрегатів цехового і блочного виконання, машинні зали газомотокомпресорів та системами автоматичного пожежогасіння нагнітачі і приводи газоперекачувальних апаратів цехового і блочного виконання при ємності маслоблоків більше 60 кг \uD83C\uDFEC";
        return text;
    }
    public String getPumpingStation(){
        return pumpingStation();
    }

    private String filtrationStation(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
        return text;
    }
    public String getFiltrationStation(){
        return filtrationStation();
    }

    private String oilRefiningEnterprisesStorage(){
        text += "підлягають обладнанню системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
        return text;
    }
    public String getOilRefiningEnterprisesStorage(){
        return oilRefiningEnterprisesStorage();
    }

    private String polymersStorage(){
        if (typeOfObjectFireAlarm().equals("Г1 або Г2")){
            if (square()<1000){
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
            }
        }else {
            if (square()<100){
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
            }
        }
        return text;
    }
    public String getPolymersStorage(){
        return polymersStorage();
    }

    private String basements(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getBasements(){
        return basements();
    }

    private String treatmentPlant(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getTreatmentPlant(){
        return treatmentPlant();
    }

    private String internalCableStructure(){
        if (volumePremisses()<20){
            text += "не підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        } else if (volumePremisses()>=20 && volumePremisses()<100) {
            text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        }
        return text;
    }
    public String getInternalCableStructure(){
        return internalCableStructure();
    }

    private String cableThermalPowerStation(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі та системою автоматичного пожежогасіння \uD83C\uDFEC";
        return text;
    }
    public String getCableThermalPowerStation(){
        return cableThermalPowerStation();
    }
    private String oilFilledEquipments(){
        if (typeOfObjectFireAlarm().equals("відсутнє")){
            text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        }
        return text;
    }
    public String getOilFilledEquipments(){
        return oilFilledEquipments();
    }
    private String engineRooms(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getEngineRooms(){
        return engineRooms();
    }
    private String boilerRooms(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getBoilerRooms(){
        return boilerRooms();
    }
    private String boilerGasRooms(){
        text += "підлягають обладнанню системою пожежної сигналізації у вибухозахищеному виконанні незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getBoilerGasRooms(){
        return boilerGasRooms();
    }

    private String powerGenerator(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння вибухозахищеного виконання незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getPowerGenerator(){
        return powerGenerator();
    }

    private String fireLoad(){
        if (typeOfObjectFireAlarm().equals("менше 180 МДж/м2")){
            text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        }
        return text;
    }
    public String getFireLoad(){
        return fireLoad();
    }

    private String transformer(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі окрім самих трансформаторів та системами автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getTransformer(){
        return transformer();
    }
    private String transformerClosedSubstation(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getTransformerClosedSubstation(){
        return transformerClosedSubstation();
    }

    private String flammableLiquidsStorage(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації\uD83C\uDFE2 ";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFE2";
        }
        return text;
    }
    public String getFlammableLiquidsStorage(){
        return flammableLiquidsStorage();
    }

    private String pumpRooms(){
        text += "підлягають обладнанню системою пожежної сигналізації  та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getPumpRooms(){
        return pumpRooms();
    }

    private String transformerWorkshops(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getTransformerWorkshops(){
        return transformerWorkshops();
    }
    private String solidFuelWarehouses(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String  getSolidFuelWarehouses(){
        return solidFuelWarehouses();
    }

    private String stationPremisses(){
        text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getStationPremisses(){
        return stationPremisses();
    }
    private String cloakroom(){
        if (square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2 ";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFE2 ";
        }
        return text;
    }
    public String getCloakroom(){
        return cloakroom();
    }

    private String cloakroomUnderground(){
        if (square()<700){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFE2";
        }
        return text;
    }
    public String getCloakroomUnderground(){
        return cloakroomUnderground();
    }

    private String autoCloakroom(){
        if (typeOfObjectFireAlarm().equals("надземний поверх автоматична камера \uD83C\uDFE2")){
            if (square()<1500){
                text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFE2";
            }
        }else {
            if (square()<1000){
                text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння \uD83C\uDFE2";
            }
        }
        return text;
    }
    public String getAutoCloakroom(){
        return autoCloakroom();
    }

    private String grainCleaning(){
        if (square()<100){
            text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else if (square()>=100 && square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFE2";
        }
        return text;
    }
    public String getGrainCleaning(){
        return grainCleaning();
    }

    private String cornCleaning(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getCornCleaning(){
        return cornCleaning();
    }

    private String premisesOfCompoundFeedShops(){
        if (square()<200){
            text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else if (square()>=200 && square()<1500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFE2";
        }
        return text;
    }
    public String getPremissesOfCompoundFeedShops(){
        return premisesOfCompoundFeedShops();
    }

    private String mills(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі\uD83C\uDFE2";
        return text;
    }
    public String getMills(){
        return mills();
    }
    private String transportGalleries(){
        if (square()<200){
            text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }
        return text;
    }
    public String getTransportGalleries(){
        return transportGalleries();
    }

    private String powerTransportGalleries(){
        if (typeOfObjectFireAlarm().equals("до 12 кВт")){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFE2";
        }
        return text;
    }
    public String getPowerTransportGalleries(){
        return powerTransportGalleries();
    }

    private String premisesOfRegenerationUnits(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getPremisesOfRegenerationUnits(){
        return premisesOfRegenerationUnits();
    }

    private String mobileCommunication(){
        if (typeOfObjectFireAlarm().equals("у діючих будинках зв’язку")){
            text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFE2";
        }else if (typeOfObjectFireAlarm().equals("у будинках іншого призначення")){
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та модульними системами автоматичного пожежогасіння незалежно від площі\uD83C\uDFE2";
        }
        return text;
    }
    public String getMobileCommunication(){
        return mobileCommunication();
    }

    private String airTransportPremisses(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getAitTransportPremisses(){
        return airTransportPremisses();
    }

    private String ukrainianPost(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFE2";
        }
        return text;
    }
    public String getUkrainianPost(){
        return ukrainianPost();
    }

    private String productionPremisses(){
        if (typeOfObjectFireAlarm().equals("виробничі А та Б")){
            if (square()<300){
                text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFE2";
            }
        }else if (typeOfObjectFireAlarm().equals("підземне розташування")){
            if (square()<500){
                text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFE2";
            }
        }else {
            if (square()<1000){
                text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFE2";
            }
        }
        return text;
    }
    public String getProductionPremisses(){
        return productionPremisses();
    }

    private String adjustment(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFE2";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFE2";
        }
        return text;
    }
    public String getAdjustment(){
        return adjustment();
    }

    private String aggregate(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFE2";
        return text;
    }
    public String getAggregate(){
        return aggregate();
    }
    private String woodGrinding(){
        if (categoryPremisses().equals("АБ")){
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83E\uDEB5";
        }else {
            if (square()<500){
                text += "підлягають обладнанню системою пожежної сигналізації \uD83E\uDEB5";
            }else {
                text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83E\uDEB5";
            }
        }
        return text;
    }
    public String getWoodGrinding(){
        return woodGrinding();
    }
    private String oilPremisses(){
        if (square()<50){
            text += "підлягають обладнанню системою пожежної сигналізації\uD83C\uDFEC ";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getOilPremisses(){
        return oilPremisses();
    }

    private String rubberEngineeringWorkshops(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getRubberEngineeringWorkshops(){
        return rubberEngineeringWorkshops();
    }
    private String testPremisses(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getTestPremisses(){
        return testPremisses();
    }

    private String analysisLaboratories(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getAnalysisLaboratories(){
        return analysisLaboratories();
    }

    private String testEquipment(){
        if (square()<300){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getTestEquipment(){
        return testEquipment();
    }
    private String testAggregate(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getTestAggregate(){
        return testAggregate();
    }
    private String metalProcessing(){
        if (square()<750){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getMetalProcessing(){
        return metalProcessing();
    }
    private String cyclones(){
        if (volumePremisses()<50){
            text += "не підлягають обладнанню системами протипожежного захисту \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getCyclones(){
        return cyclones();
    }
    private String pneumaticTransport(){
        text += "підлягають обладнанню системами протипожежного захисту згідно окремих технічних умов \uD83C\uDFEC";
        return text;
    }
    public String getPneumaticTransport(){
        return pneumaticTransport();
    }
    private String pumpsPremisses(){
        if (productivity()<1200){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системами пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getPumpsPremisses(){
        return pumpsPremisses();
    }
    private String switchPremisses(){
        if (weight()<60){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getSwitchPremisses(){
        return switchPremisses();
    }
    private String installationOfEngines(){
        if (square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getInstallationOfEngines(){
        return installationOfEngines();
    }
    private String placesOfDisassembly(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getPlacesDisassembly(){
        return placesOfDisassembly();
    }
    private String lubricantStorage(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getLubricantStorage(){
        return lubricantStorage();
    }
    private String celluloidStorage(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getCelluloidStorage(){
        return celluloidStorage();
    }
    private String flammablePesticidesStorage(){
        if (square()<200){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getFlammablePesticidesStorage(){
        return flammablePesticidesStorage();
    }
    private String archivesUpTo150(){
        if (square()<400){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getArchivesUpTo150(){
        return archivesUpTo150();
    }

    private String rubberStorage(){
        if (square()<500){
            text += "підлягають обладнанню системою пожежної сигналізації\uD83C\uDFEC" ;
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getRubberStorage(){
        return rubberStorage();
    }
    private String flammableInBasement(){
        if (square()<700){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getFlammableInBasement(){
        return flammableInBasement();
    }
    private String petroleumProducts(){
        if (square()<750){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getPetroleumProducts(){
        return petroleumProducts();
    }
    private String combustibleMaterials(){
        if (square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getCombustibleMaterials(){
        return combustibleMaterials();
    }
    private String boatRamps(){
        if (square()<1500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getBoatRamps(){
        return boatRamps();
    }
    private String siloPremisses(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getSiloPremisses(){
        return siloPremisses();
    }
    private String crushingDepartment(){
        if (square()<100){
            text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else if (square()>=100 && square()<1000){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getCrushingDepartment(){
        return crushingDepartment();
    }
    private String compressorDepartment(){
        if (square()<100){
            text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else if (square()>=100 && square()<1500){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getCompressorDepartment(){
        return compressorDepartment();
    }
    private String car(){
        if (square()<7000){
            text += "підлягають обладнанню системою пожежної сигналізації\uD83C\uDFEC ";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getCar(){
        return car();
    }
    private String bus(){
        if (square()<3600){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння\uD83C\uDFEC" ;
        }
        return text;
    }
    public String getBus(){
        return bus();
    }
    private String autoInPremisses3fireResistance(){
        if (square()<2000){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getAutoInPremisses3fireResistance(){
        return autoInPremisses3fireResistance();
    }
    private String autoInPremisses3aFireResistance(){
        if (square()<3600){
            text += "підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння \uD83C\uDFEC";
        }
        return text;
    }
    public String getAutoInPremisses3aFireResistance(){
        return autoInPremisses3aFireResistance();
    }
    private String autoMoreTwoFloors(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getAutoMoreTwoFloors(){
        return autoMoreTwoFloors();
    }
    private String repairAutoInBasement(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getRepairAutoInBasement(){
        return repairAutoInBasement();
    }
    private String staffPremisses(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getStaffPremisses(){
        return staffPremisses();
    }
    private String electricCabinetZones(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getElectricCabinetZones(){
        return electricCabinetZones();
    }
    private String subway(){
        text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getSubway(){
        return subway();
    }
    private String stationsElectricalDepot(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getStationsElectricalDepot(){
        return stationsElectricalDepot();
    }
    private String cableChannels(){
        if (productivity()<180){
            text += "підлягають обладнанню системою пожежної сигналізації незалежно від площі \uD83C\uDFEC";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        }
        return text;
    }
    public String getCableChannels(){
        return cableChannels();
    }
    private String sumpHousings(){
        if (square()<7000){
            text += "підлягають обладнанню системою пожежної сигналізації\uD83C\uDFEC ";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння\uD83C\uDFEC ";
        }
        return text;
    }
    public String getSumpHousing(){
        return sumpHousings();
    }
    private String serverPremisses(){
        text += "підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі\uD83C\uDFEC";
        return text;
    }
    public String getServerPremisses(){
        return serverPremisses();
    }
    private String suspendedCeiling(){
        text += "згідно до вимог ДСТУ-Н CEN/TS 54-14 – підлягають обладнанню системою пожежної сигналізації\n\n" +
                "за наявності пожежного навантаження більше 25МДж/м – підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння\uD83C\uDFEC";
        return text;
    }
    public String getSuspendedCeiling(){
        return suspendedCeiling();
    }

    private String serverInHotel(){
        text += "всі приміщення – підлягають обладнанню системою пожежної сигналізації незалежно від площі\n\n" +
                "приміщення зберігання авто- та мототранспорту, склади горючих та легкозаймистих рідин і хімікатів, камери оперативного запасу горючих та легкозаймистих рідин і хімікатів від 300 м2, приміщення з унікальним обладнанням, зберігання та видачі унікальних видань, звітів, рукописів та іншої документації, серверні – підлягають обладнанню системою пожежної сигналізації та автоматичного пожежогасіння незалежно від площі \uD83C\uDFEC";
        return text;
    }
    public String getServerInHotel(){
        return serverInHotel();
    }













}
