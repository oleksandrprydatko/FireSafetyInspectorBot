package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class FireAlarm {
    Long userId;
    DatabaseRepository databaseRepository;

    public FireAlarm(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }

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


    //житлові будинки
    private String housing(){
        if ((databaseRepository.getHeight_object(userId))<=26.5){
            text += "не підлягають обладнанню системою пожежної сигналізації, підлягають обладнанню усі вбудовані приміщення різного призначення незалежно від площі \uD83C\uDFE0";
        }else if ((databaseRepository.getHeight_object(userId))>26.5 && (databaseRepository.getHeight_object(userId)) <= 47){
            text += "підлягають обладнанню передпокої житлових квартир та усі вбудовані приміщення різного призначення незалежно від площі \uD83C\uDFE0";
        }else if ((databaseRepository.getHeight_object(userId)) > 47 && (databaseRepository.getHeight_object(userId)) <= 73.5){
            text += "підлягають обладнанню системою пожежної сигналізації, передпокої житлових квартир, поза квартирні коридори, ліфтові холи та усі вбудовані приміщення різного призначення незалежно від площі \uD83C\uDFE0";
        }else if ((databaseRepository.getHeight_object(userId)) > 73.5 && (databaseRepository.getHeight_object(userId)) <= 100){
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
        if ((databaseRepository.getHeight_object(userId))<= 26.5){
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
        if (databaseRepository.getHotel_rooms(userId)<7){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення при загальній площі більше 300 м2 \uD83C\uDFE8";
        }else if (databaseRepository.getHotel_rooms(userId)>=7 && databaseRepository.getHotel_rooms(userId)<50){
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
        if (databaseRepository.getHeight_object(userId)<26.5){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення із врахуванням кількості номерів \uD83C\uDFE8";
        }else if (databaseRepository.getHeight_object(userId)>=26.5 && databaseRepository.getHeight_object(userId)<100){
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
        if (databaseRepository.getHeight_object(userId)<3){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення при загальній площі більше 300 м2 \uD83C\uDFE2";
        }else if (databaseRepository.getHeight_object(userId)>=3 && databaseRepository.getHeight_object(userId)<26.5){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFE2";
        }else if (databaseRepository.getHeight_object(userId)>=26.5 && databaseRepository.getHeight_object(userId)<47){
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення \uD83C\uDFE2";
        }else if (databaseRepository.getHeight_object(userId)>=47 && databaseRepository.getHeight_object(userId)<100){
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
        if (databaseRepository.getSquare(userId)<400){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення та системою автоматичного пожежогасіння торгівельні зали площею більше 150 м2 \uD83C\uDFEC";
        }else if (databaseRepository.getSquare(userId)>=400 && databaseRepository.getSquare(userId)<1000){
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
        if (databaseRepository.getFloors(userId)==1){
            if (databaseRepository.getSquare(userId)<3500){
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння при загальній площі більше допустимої площі протипожежного відсіку усі приміщення \uD83C\uDFEC";
            }else{
                text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння при загальній площі більше допустимої площі протипожежного відсіку усі приміщення  \uD83C\uDFEC";
            }
        }else if (databaseRepository.getFloors(userId) == 2){
            if (databaseRepository.getSquare(userId)<3500){
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
            }else {
                text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння при загальній площі торгових залів більше 3500 м2 усі приміщення \uD83C\uDFEC";
            }
        }else{
            if (databaseRepository.getSquare(userId)<1000){
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
        if (databaseRepository.getHeight_object(userId)<47){
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
        if (databaseRepository.getFloors(userId)==1){
            if (databaseRepository.getSquare(userId)<50){
                text += "не підлягають обладнанню системою пожежної сигналізації \uD83C\uDFEC";
            }else if (databaseRepository.getSquare(userId)>=50 && databaseRepository.getSquare(userId)<3500){
                text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFEC";
            }else{
                text += "підлягають обладнанню системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFEC";
            }
        }else if (databaseRepository.getFloors(userId)==2){
            if (databaseRepository.getSquare(userId)<2500){
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
        if (databaseRepository.getSquare(userId)<400){
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
        if (databaseRepository.getFloors(userId)==1){
            if (databaseRepository.getFire_resistance(userId).equals("1") || databaseRepository.getFire_resistance(userId).equals("2")){
                if (databaseRepository.getSquare(userId)<3500){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else{
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else if (databaseRepository.getFire_resistance(userId).equals("3")){
                if (databaseRepository.getSquare(userId)<2000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else if (databaseRepository.getFire_resistance(userId).equals("3а")||databaseRepository.getFire_resistance(userId).equals("3б")){
                if (databaseRepository.getSquare(userId)<1000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else if (databaseRepository.getFire_resistance(userId).equals("4") || databaseRepository.getFire_resistance(userId).equals("4а") || databaseRepository.getFire_resistance(userId).equals("5")){
                if (databaseRepository.getSquare(userId)<500){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else{
                text = "Ступінь вогнестійкості будівлі введено не коректно. Спробуйте ввести (1,2,3,3a,3б,4,4a,5) ступені вогнестійкості.";
            }
        }else{
            if (databaseRepository.getFire_resistance(userId).equals("1") || databaseRepository.getFire_resistance(userId).equals("2")){
                if (databaseRepository.getSquare(userId)<3000){
                    text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83C\uDFDB";
                }else {
                    text += "підлягають обладнанню адресною системою пожежної сигналізації та системою автоматичного пожежогасіння усі приміщення \uD83C\uDFDB";
                }
            }else if (databaseRepository.getFire_resistance(userId).equals("3")){
                if (databaseRepository.getSquare(userId)<1000){
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
        if (databaseRepository.getSeats(userId)<700){
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
        if (databaseRepository.getSquare(userId)<500){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення";
        }else if (databaseRepository.getSquare(userId)>=500 &&  databaseRepository.getSquare(userId)<1000){
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
        if (databaseRepository.getBooks_storage(userId)<500){
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
        if (databaseRepository.getBooks_storage(userId)<500){
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
        if (databaseRepository.getSquare(userId)<400){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDCD6";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення \uD83D\uDCD6";
        }
        return text;
    }

    public String getArchive(){
        return archive();
    }

    private String institutes(){
        if (databaseRepository.getHeight_object(userId)<26.5){
            if (databaseRepository.getFloors(userId)==1){
                if (databaseRepository.getSquare(userId)<=300 && !databaseRepository.getArchives(userId)){
                    text += "не підлягають обладнанню системою пожежної сигналізації \uD83D\uDCDA";
                }else if (databaseRepository.getSquare(userId)<=300 && databaseRepository.getArchives(userId)){
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
        if (databaseRepository.getHeight_object(userId)<26.5){
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
        if (databaseRepository.getSquare(userId)<300){
            text += "не підлягає обладнанню системою пожежної сигналізації ⛪️";
        }else {
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення ⛪️";
        }
        return text;
    }
    public String getReligious(){
        return religious();
    }
}
