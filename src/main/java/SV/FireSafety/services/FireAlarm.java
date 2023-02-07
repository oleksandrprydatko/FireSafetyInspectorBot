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
        return  "Ви не ввели рекомнндовані системою параметри.\n\n" +
                "Надішліть кількість номерів для проживання та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getRoomsEmpty(){
        return roomsEmpty();
    }

    private String heightEmpty(){
        return  "Ви не ввели рекомнндовані системою параметри.\n\n" +
                "Надішліть умовну висоту будівлі (м.) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getHeightEmpty(){
        return heightEmpty();
    }

    private String squareEmpty(){
        return  "Ви не ввели рекомнндовані системою параметри.\n\n" +
                "Надішліть загальну площу приміщень (м.кв) та натисніть \"Далі\" \uD83D\uDC47";
    }
    public String getSquareEmpty(){
        return squareEmpty();
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
}
