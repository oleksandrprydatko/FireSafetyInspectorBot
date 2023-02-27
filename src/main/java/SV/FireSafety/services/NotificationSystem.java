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
    double height(){return databaseRepository.getHeight_object(userId);}
    private String text = "Висновок: \n";
    private String s0 = "Система оповіщення не вимагається \uD83D\uDCE2";
    private String s1 = "\uD83D\uDD34 Тип системи оповіщення – 1-й \n" +
            "<b>вимагається</b> звуковий спосіб оповіщення (дзвінок, тонований сигнал тощо);\n" +
            "<b>рекомендується</b> світловий спосіб оповіщення (світловий сигнал який блимає, світлові покажчики «Вихід») черговість оповіщення (усіх одночасно або тільки в одному приміщенні чи частині будинку).\n";
    private String s2 = "\uD83D\uDD34 Тип системи оповіщення – 2-й\n" +
            "<b>вимагається</b> звуковий спосіб оповіщення (дзвінок, тонований сигнал тощо), світловий спосіб оповіщення (світлові покажчики «Вихід»), черговість оповіщення (усіх одночасно). \n" +
            "<b>рекомендується</b> світловий спосіб оповіщення (світловий сигнал який блимає, світлові покажчики напрямку руху, світлові покажчики напрямку руху з включенням для окремо кожної зони) черговість оповіщення (тільки в одному приміщенні чи частині будинку, спочатку обслуговуючий персонал, а потім усіх інших за спеціально розробленою черговістю).\n";
    private String s3 = "\uD83D\uDD34 Тип системи оповіщення – 3-й\n" +
            "<b>вимагається</b> мовленнєвий спосіб оповіщення (запис і передача спеціальних текстів), світловий спосіб оповіщення (світлові покажчики «Вихід»), черговість оповіщення (спочатку обслуговуючий персонал, а потім усіх інших за спеціально розробленою черговістю). \n" +
            "<b>рекомендується</b> звуковий спосіб оповіщення (дзвінок, тонований сигнал, тощо) світловий спосіб оповіщення (світлові покажчики напрямку руху, світлові покажчики напрямку руху з включенням для окремо кожної зони), зв’язок зони оповіщення з диспетчерською, черговість оповіщення (тільки в одному приміщенні чи частині будинку).\n";
    private String s4 = "\uD83D\uDD34 Тип системи оповіщення – 4-й\n" +
            "<b>вимагається</b> мовленнєвий спосіб оповіщення (запис і передача спеціальних текстів), світловий спосіб оповіщення (світлові покажчики «Вихід», світлові покажчики напрямку руху), зв’язок зони оповіщення з диспетчерською,  черговість оповіщення (спочатку обслуговуючий персонал, а потім усіх інших за спеціально розробленою черговістю).  \n" +
            "<b>рекомендується</b> звуковий спосіб оповіщення (дзвінок, тонований сигнал, тощо) світловий спосіб оповіщення (світлові покажчики напрямку руху з включенням для окремо кожної зони).\n";
    private String s5 ="\uD83D\uDD34 Тип системи оповіщення – 5-й\n" +
            "<b>вимагається</b> мовленнєвий спосіб оповіщення (запис і передача спеціальних текстів), світловий спосіб оповіщення (світлові покажчики «Вихід», світлові покажчики напрямку руху, світлові покажчики напрямку руху з включенням для окремо кожної зони), зв’язок зони оповіщення з диспетчерською,  черговість оповіщення (спочатку обслуговуючий персонал, а потім усіх інших за спеціально розробленою черговістю), повна автоматизація управління системою оповіщення та можливість різних варіантів організації евакуювання з кожної зони оповіщення.  \n" +
            "<b>рекомендується</b> звуковий спосіб оповіщення (дзвінок, тонований сигнал, тощо).\n";
    private String or = "Допускається одна із запропонованих систем оповіщення: \uD83D\uDD14 \n\n";

    private String separatedBankHousehold(){
        if (floors()==1){
            text += s1;
        }else if (floors()==2){
            text += s2;
        }else if (floors()>=3 && floors()<=5){
            text += s3;
        }else{
            text += or + s4 + s5;
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
            text += or + s4 + s5;
        }
        return text;
    }
    public String getSecondarySchools(){
        return secondarySchools();
    }
    private String specializedSchools(){
        if (seats()<=100){
            text += s1;
        }else if (seats()>100 && seats()<200){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getSpecializedSchools(){
        return specializedSchools();
    }
    private String higherSchool(){
        if (floors()<4){
            text += s2;
        }else if (floors()>=4 && floors()<9){
            text += s3;
        }else {
            text += or + s4 + s5;
        }
        return text;
    }
    public String getHigherSchool(){
        return higherSchool();
    }
    private String entertainmentWholeYear(){
        if (seats()<300){
            text += s1;
        }else if (seats()>=300 && seats()<800){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getEntertainmentWholeYear(){
        return entertainmentWholeYear();
    }
    private String entertainmentClosed(){
        if (seats()<800){
            text += s1;
        }else {
            text += s2;
        }
        return text;
    }
    public String getEntertainmentClosed(){
        return entertainmentClosed();
    }
    private String entertainmentOpen(){
        if (seats()<400){
            text += s1;
        }else if (seats()>=400 && seats()<600){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getEntertainmentOpen(){
        return entertainmentOpen();
    }
    private String museum(){
        if (seats()<500){
            text += s2;
        }else if (seats()>=500 && seats()<1000){
            text += s3;
        }else{
            text += or + s4 + s5;
        }
        return text;
    }
    public String getMuseum(){
        return museum();
    }
    private String sport(){
        if (seats()<200){
            text += s2;
        }else if (seats()>=200 && seats()<1000){
            text += s3;
        }else {
            text += or + s4 + s5;
        }
        return text;
    }
    public String getSport(){
        return sport();
    }
    private String medical(){
        if (seats()<60){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getMedical(){
        return medical();
    }
    private String ambulatory(){
        if (seats()<90){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getAmbulatory(){
        return ambulatory();
    }
    private String sanatorium(){
        if (floors()<9){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getSanatorium(){
        return sanatorium();
    }
    private String researchInstitutions(){
        if (floors()<=5){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getResearchInstitutions(){
        return researchInstitutions();
    }
    private String station(){
        if (floors()==1){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getStation(){
        return station();
    }
    private String hotels(){
        if (height()>26.5 && height()<47){
            text += or + s3 + s5;
        }else{
            text += or + s4 + s5;
        }
        return text;
    }
    public String getHotels(){
        return hotels();
    }
    private String seatsHotels(){
        if (seats()<50){
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getSeatsHotels(){
        return seatsHotels();
    }
    private String residentialBuildings(){
        if (height()<26.5){
            text += s0;
        } else if (height()>=26.5 && height()<73.5) {
            text += s1;
        }else {
            text += s4;
        }
        return text;
    }
    public String getResidentialBuildings(){
        return residentialBuildings();
    }
    private String office(){
        if (seats()<50){
            text += s1;
        } else if (seats()>=50 && seats()<100) {
            text += s2;
        }else {
            text += s3;
        }
        return text;
    }
    public String getOffice(){
        return office();
    }
    private String cult(){
        if (seats()<300){
            text += s1;
        }else {
            text += s2;
        }
        return text;
    }
    public String getCult(){
        return cult();
    }
    private String exhibitions(){
        if (square()<500){
            text += s1;
        } else if (square() >=500 && square() <3500) {
            text += s2;
        }else {
            text += or + s3 + s5;
        }
        return text;
    }
    public String getExhibitions(){
        return exhibitions();
    }
}
