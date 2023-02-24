package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;
import lombok.Data;

@Data
public class NotificationSystem {
    Long userId;
    DatabaseRepository databaseRepository;

    public NotificationSystem(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }
    int floors(){
        return databaseRepository.getFloors(userId);
    }
    float square() {
        return databaseRepository.getSquare(userId);
    }
    int seats(){
        return databaseRepository.getSeats(userId);
    }
    private String text = "Висновок: ";
    private String s0 = "Система оповіщення не вимагається \uD83D\uDCE2";
    private String s1 = "Тип системи оповіщення – 1-й \uD83D\uDCE2";
    private String s2 = "Тип системи оповіщення – 2-й \uD83D\uDCE2";
    private String s3 = "Тип системи оповіщення – 3-й \uD83D\uDCE2";
    private String s45 = "Тип системи оповіщення – 4-й або 5-й \uD83D\uDCE2";

    private String separatedBankHousehold(){
        if (floors()==1){
            text += s1;
        }else if (floors()==2){
            text += s2;
        }else if (floors()>=3 && floors()<=5){
            text += s3;
        }else{
            text += s45;
        }
        return text;
    }
    public String getSeparatedBankHousehold(){
        return separatedBankHousehold();
    }

    private String bankHousehold(){
        if (square()<300){
            text += s1;
        }else {
            text += s2;
        }
        return text;
    }
    public String getBankHousehold(){
        return bankHousehold();
    }
    private String baths(){
        if (seats()<20){
            text += s1;
        }else {
            text += s2;
        }
        return text;
    }
    public String getBaths(){
        return baths();
    }
    private String catering(){
        if (seats()<50){
            text += s0;
        }else if (seats()>=50 && seats()<200){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getCatering(){
        return catering();
    }
    private String trade(){
        if (square()<500){
            text += s1;
        }else if (square()>=500 && square()<3500){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getTrade(){
        return trade();
    }
    private String preschool(){
        if (seats()<100){
            text += s1;
        }else if (seats()>=100 && seats()<150){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getPreschool(){
        return preschool();
    }
    private String secondarySchools(){
        if (seats()<270){
            text += s1;
        }else if (seats()>=270 && seats()<=350){
            text += s2;
        }else if (seats()>=351 && seats()<=1600){
            text += s3;
        }else {
            text += s45;
        }
        return text;
    }
    public String getSecondarySchools(){
        return secondarySchools();
    }
}
