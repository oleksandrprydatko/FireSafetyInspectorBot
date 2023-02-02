package SV.FireSafety.services;

public class FireAlarm {

    DBWorker dbWorker = new DBWorker();
    String chatID;
    String text = "Висновок: ";

    public FireAlarm(String chatID){
        this.chatID = chatID;
    }
    //житлові будинки
    private String housing(){
        if (Double.parseDouble(dbWorker.getHeightObject(chatID))<=26.5){
            text += "не підлягають обладнанню системою пожежної сигналізації, підлягають обладнанню усі вбудовані приміщення різного призначення незалежно від площі";
        }else if (Double.parseDouble(dbWorker.getHeightObject(chatID))>26.5 && Double.parseDouble(dbWorker.getHeightObject(chatID)) <= 47){
            text += "підлягають обладнанню передпокої житлових квартир та усі вбудовані приміщення різного призначення незалежно від площі";
        }else if (Double.parseDouble(dbWorker.getHeightObject(chatID)) > 47 && Double.parseDouble(dbWorker.getHeightObject(chatID)) <= 73.5){
            text += "підлягають обладнанню системою пожежної сигналізації, передпокої житлових квартир, поза квартирні коридори, ліфтові холи та усі вбудовані приміщення різного призначення незалежно від площі";
        }else if (Double.parseDouble(dbWorker.getHeightObject(chatID)) > 73.5 && Double.parseDouble(dbWorker.getHeightObject(chatID)) <= 100){
            text += "підлягають обладнанню системою пожежної сигналізації, передпокої житлових квартир, позаквартирні коридори, ліфтові холи та усі вбудовані приміщення різного призначення незалежно від площі та підлягають обладнанню системою автоматичного пожежогасіння усі вбудовані і прибудовані громадські та інші нежитлові приміщення, автостоянки, допоміжні та технічні приміщення, сміттєзабірні, стовбур сміттєпроводу";
        }else{
            text += "обладнання системами пожежної сигналізації та автоматичного пожежогасіння визначається індивідуальними технічними вимогами на кожен об’єкт окремо";
        }
        return text;
    }

    public String getHousing(){
        return housing();
    }

    //будинок пристарілих
    private String nursingHome(){
        text += "підлягають обладнанню системою пожежної сигналізації усі приміщення";
        return text;
    }

    public String getNursingHome(){
        return nursingHome();
    }

    //гуртожиток
    private String dormitory(){
        if (Double.parseDouble(dbWorker.getHeightObject(chatID))<= 26.5){
            text += "підлягають обладнанню системою пожежної сигналізації усі приміщення ";
        }else{
            text += "підлягають обладнанню адресною системою пожежної сигналізації усі приміщення ";
        }
        return text;
    }
    public String getDormitory(){
        return dormitory();
    }
}
