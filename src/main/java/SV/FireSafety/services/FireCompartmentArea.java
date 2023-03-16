package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class FireCompartmentArea {
    Long userId;
    DatabaseRepository databaseRepository;

    public FireCompartmentArea(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }

    private String typeObject(){return databaseRepository.getType_of_object(userId);}
    private String fireResistance(){return databaseRepository.getFire_resistance(userId);}
    private String typePremisses(){return databaseRepository.getType_premises(userId);}
    private String  typeCinema(){return databaseRepository.getType_cinema(userId);}
    private String category(){return databaseRepository.getCategory_buildings(userId);}
    private int floors(){return databaseRepository.getFloors(userId);}
    private boolean fireAlarm(){return databaseRepository.getFire_alarm(userId);}
    private String square(int square) {
        return "Висновок: площа протипожежного відсіку становить до " + square + " м2 🔥";
    }
    private String squareFloors(int square, int floors){
        return "Висновок: площа протипожежного відсіку становить до " + square + " м2, допустима поверховість становить до " + floors + " поверхів \uD83D\uDEA8";
    }
    private String seatsFloorsNotStandardized(){
        return "Висновок: кількість посадочних місць та поверховість не нормується";
    }
    private String seatsExceptFloors(){
        return "Висновок: кількість посадочних місць понад 600 чоловік, поверховість не нормується \uD83D\uDEA8";
    }
    private String seatsFloors(int seats,int floors){
        return "Висновок: кількість посадочних місць до " + seats + " чоловік, поверховість не більше " + floors + " \uD83D\uDEA8";
    }
    private String seatsFloorsHall(int seats, int floors, int hall){
        return "Висновок: кількість посадочних місць до " + seats + " чоловік, поверховість не більше " + floors + ", зали для глядачів не вище " + hall + " поверху \uD83D\uDEA8";
    }
    private String seats(int seats){
        return "Висновок: кількість посадочних місць до " + seats + " чоловік \uD83D\uDEA8";
    }
    private String notExpected(){
        return "Висновок: нормативно-правовими актами не передбачається";
    }

    private String squareSeatsFloors(){
        if (typeObject().equals("2.1 1.1 ПМП")){
            if (fireResistance().equals("І ступінь вогнестійкості")){
                if (floors()==25){
                    return square(2500);
                } else if (floors()==9) {
                    return square(5000);
                } else {
                    return square(6000);
                }
            } else if (fireResistance().equals("ІІ ступінь вогнестійкості")) {
                if (floors()==25){
                    return square(2200);
                } else if (floors()==9) {
                    return square(4000);
                } else {
                    return square(6000);
                }
            } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                return squareFloors(1800,5);
            } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                return squareFloors(2500,1);
            } else if (fireResistance().equals("ІІІб ступінь вогнестійкості") || fireResistance().equals("ІV ступінь вогнестійкості")) {
                if (floors() == 2){
                    return square(1000);
                }else {
                    return square(1400);
                }
            } else if (fireResistance().equals("ІVа ступінь вогнестійкості")) {
                return squareFloors(1000,1);
            }else {
                return squareFloors(800,1);
            }
        } else if (typeObject().equals("2.2 1.1 ПМП")) {
            if (fireResistance().equals("І ступінь вогнестійкості")){
                if (floors()==25){
                    if (fireAlarm()){
                        return square(5000);
                    }else {
                        return square(2500);
                    }
                } else if (floors()==9) {
                    if (fireAlarm()){
                        return square(10000);
                    }else {
                        return square(5000);
                    }
                }else {
                    if (fireAlarm()){
                        return square(12000);
                    }else {
                        return square(6000);
                    }
                }
            } else if (fireResistance().equals("ІІ ступінь вогнестійкості")) {
                if (floors()==25){
                    if (fireAlarm()){
                        return square(4400);
                    }else {
                        return square(2200);
                    }
                } else if (floors()==9) {
                    if (fireAlarm()){
                        return square(8000);
                    }else {
                        return square(4000);
                    }
                }else {
                    if (fireAlarm()){
                        return square(12000);
                    }else {
                        return square(6000);
                    }
                }
            } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                if (floors()==5){
                    return square(2000);
                }else {
                    return square(3000);
                }
            } else if (fireResistance().equals("ІІІа ступінь вогнестійкості") || fireResistance().equals("ІІІб ступінь вогнестійкості")) {
                return squareFloors(2500,1);
            } else if (fireResistance().equals("ІV ступінь вогнестійкості")) {
                if (floors()==2){
                    return square(1400);
                }else {
                    return square(2000);
                }
            } else if (fireResistance().equals("ІVа ступінь вогнестійкості")) {
                return squareFloors(1000,1);
            }else {
                if (floors()==2){
                    return square(800);
                }else {
                    return square(1200);
                }
            }
        } else if (typeObject().equals("2.3 1.1 ПМП")) {
            if (typePremisses().equals("театр")){
                return seatsFloorsNotStandardized();
            } else if (typePremisses().equals("клубний заклад")) {
                if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості")){
                    return seatsExceptFloors();
                } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                    return seatsFloorsHall(600,3,2);
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    return seatsFloorsHall(400,2,1);
                } else if (fireResistance().equals("ІІІб ступінь вогнестійкості") || fireResistance().equals("ІV ступінь вогнестійкості")) {
                    return seatsFloors(400,2);
                } else if (fireResistance().equals("ІVа ступінь вогнестійкості")) {
                    return seatsFloorsHall(600,3,2);
                }else {
                    return squareFloors(300,1);
                }
            }else {
                if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості")){
                    if (typeCinema().equals("цілорічної дії")){
                        return seatsExceptFloors();
                    }else {
                        return notExpected();
                    }
                } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                    if (typeCinema().equals("цілорічної дії")){
                        return seatsFloors(600,2);
                    }else {
                        return "Висновок: кількість посадочних місць понад 600 чоловік, поверховість 1 поверх";
                    }
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    if (typeCinema().equals("цілорічної дії")){
                        return seatsFloorsHall(400,2,1);
                    }else if (typeCinema().equals("літній закритий")){
                        return "Висновок: кількість посадочних місць до 600 чоловік, поверховість 1 поверх";
                    }else {
                        return "Висновок: нормативними актами не передбачається";
                    }
                } else if (fireResistance().equals("ІІІб ступінь вогнестійкості")) {
                    if (typeCinema().equals("цілорічної дії")){
                        return "Висновок: нормативними актами не передбачається";
                    }else if (typeCinema().equals("літній закритий")){
                        return "Висновок: кількість посадочних місць понад 600 чоловік, поверховість 1 поверх";
                    }else {
                        return "Висновок: кількість посадочних місць понад 600 чоловік, поверховість 1 поверх";
                    }
                }else if (fireResistance().equals("ІV ступінь вогнестійкості")){
                    if (typeCinema().equals("цілорічної дії")){
                        return seatsFloorsHall(400,2,1);
                    }else if (typeCinema().equals("літній закритий")){
                        return "Висновок: кількість посадочних місць до 600 чоловік, поверховість 1 поверх";
                    }else {
                        return "Висновок: кількість посадочних місць до 600 чоловік, поверховість 1 поверх";
                    }
                } else if (fireResistance().equals("ІVа ступінь вогнестійкості")) {
                    if (typeCinema().equals("цілорічної дії")){
                        return seatsFloorsHall(600,2,1);
                    }else if (typeCinema().equals("літній закритий")){
                        return "Висновок: нормативними актами не передбачається";
                    }else {
                        return "Висновок: нормативними актами не передбачається";
                    }
                }else {
                    if (typeCinema().equals("цілорічної дії")){
                        return seatsFloors(300,1);
                    }else if (typeCinema().equals("літній закритий")){
                        return "Висновок: кількість посадочних місць до 600 чоловік, поверховість до 1";
                    }else {
                        return "Висновок: кількість посадочних місць до 600 чоловік, поверховість до 1";
                    }
                }
            }
        } else if (typeObject().equals("2.4 1.1 ПМП")) {
            if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості") || fireResistance().equals("ІІІ ступінь вогнестійкості") || fireResistance().equals("ІІІб ступінь вогнестійкості")){
                return seats(600);
            } else if (fireResistance().equals("ІІІа ступінь вогнестійкості") || fireResistance().equals("V ступінь вогнестійкості")) {
                return seats(300);
            } else if (fireResistance().equals("ІV ступінь вогнестійкості")) {
                return seats(400);
            }else {
                return "Висновок: нормативними актами не допускається розміщувати посадочні місця";
            }
        } else if (typeObject().equals("2.5 1.1 ПМП")) {
            if (fireResistance().equals("І ступінь вогнестійкості")){
                if (floors()==5){
                    if (fireAlarm()){
                        return square(10000);
                    }else {
                        return square(5000);
                    }
                }else {
                    if (fireAlarm()){
                        return square(12000);
                    }else {
                        return square(6000);
                    }
                }
            } else if (fireResistance().equals("ІІ ступінь вогнестійкості")) {
                if (floors()==5){
                    if (fireAlarm()){
                        return square(8000);
                    }else {
                        return square(4000);
                    }
                }else {
                    if (fireAlarm()){
                        return square(12000);
                    }else {
                        return square(6000);
                    }
                }
            } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                if (floors()==5){
                    return square(2000);
                }else {
                    return square(3000);
                }
            } else if (fireResistance().equals("ІІІа ступінь вогнестійкості") || fireResistance().equals("ІІІб ступінь вогнестійкості")) {
                return seatsFloors(2500,1);
            } else if (fireResistance().equals("ІV ступінь вогнестійкості")) {
                if (floors()==2){
                    return square(1400);
                }else {
                    return square(2000);
                }
            } else if (fireResistance().equals("ІVа ступінь вогнестійкості")) {
                return seatsFloors(800,1);
            }else {
                if (floors()==2){
                    return square(800);
                }else {
                    return square(1000);
                }
            }
        } else {
            return "Невідома помилка";
        }
    }
    public String getSquareSeatsFloors(){
        return squareSeatsFloors();
    }
    private String squareFloors(){
        if (typeObject().equals("2.1 1.2 ПМП")){
            if (category().equals("Категорія А")){
                if (fireResistance().equals("І ступінь вогнестійкості")){
                    return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 6 поверхів";
                } else if (fireResistance().equals("ІІ ступінь вогнестійкості")) {
                    if (typePremisses().equals("наявні об’єкти")){
                        if (floors()==6){
                            return square(3500);
                        } else if (floors() == 2) {
                            return square(5200);
                        }else {
                            return "Висновок: площа протипожежного відсіку не нормується";
                        }
                    }else {
                        return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 6 поверхів";
                    }
                } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                    return "Висновок: нормативно-правовими актами не передбачається";
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    return "Висновок: площа протипожежного відсіку до 3500 м2, максимальна кількість поверхів 1 поверх";
                } else {
                    return "Висновок: нормативно-правовими актами не передбачається";
                }
            } else if (category().equals("Категорія Б")) {
                if (fireResistance().equals("І ступінь вогнестійкості")){
                    return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 6 поверхів";
                } else if (fireResistance().equals("ІІ ступінь вогнестійкості")) {
                    if (typePremisses().equals("наявні об’єкти")){
                        if (floors()==6){
                            return square(7800);
                        } else if (floors() == 2) {
                            return square(10400);
                        }else {
                            return "Висновок: площа протипожежного відсіку не нормується";
                        }
                    }else {
                        return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 6 поверхів";
                    }
                } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                    return "Висновок: нормативно-правовими актами не передбачається";
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    return "Висновок: площа протипожежного відсіку до 3500 м2, максимальна кількість поверхів 1 поверх";
                } else {
                    return "Висновок: нормативно-правовими актами не передбачається";
                }
            } else if (category().equals("Категорія В")) {
                if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості")){
                    return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 8 поверхів";
                } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                    if (floors()==3){
                        return square(2600);
                    } else if (floors()==2) {
                        return square(3500);
                    }else {
                        return square(5200);
                    }
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(10400);
                    }else {
                        return square(25000);
                    }
                } else if (fireResistance().equals("ІІІб ступінь вогнестійкості")) {
                    return squareFloors(15000,1);
                } else if (fireResistance().equals("ІV ступінь вогнестійкості") || fireResistance().equals("ІVа ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(2000);
                    }else {
                        return square(2600);
                    }
                } else  {
                    return squareFloors(1200,1);
                }
            } else if (category().equals("Категорія Г")) {
                if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості")){
                    return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 10 поверхів";
                } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                    if (floors()==3){
                        return square(3500);
                    } else if (floors()==2) {
                        return square(5200);
                    }else {
                        return square(6500);
                    }
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 6 поверхів";
                } else if (fireResistance().equals("ІІІб ступінь вогнестійкості")) {
                    return squareFloors(20000,1);
                } else if (fireResistance().equals("ІV ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(2600);
                    }else {
                        return square(3500);
                    }
                } else if (fireResistance().equals("ІVа ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(5200);
                    }else {
                        return square(6500);
                    }
                }else {
                    return "Висновок: нормативно-правовими актами не передбачається";
                }
            } else {
                if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості")){
                    return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 10 поверхів";
                } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                    if (floors()==3){
                        return square(3500);
                    } else if (floors()==2) {
                        return square(6500);
                    }else {
                        return square(7800);
                    }
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість складає 6 поверхів";
                } else if (fireResistance().equals("ІІІб ступінь вогнестійкості")) {
                    return squareFloors(25000,1);
                } else if (fireResistance().equals("ІV ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(2600);
                    }else {
                        return square(3500);
                    }
                } else if (fireResistance().equals("ІVа ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(7800);
                    }else {
                        return square(10400);
                    }
                }else {
                    if (floors()==2){
                        return square(1500);
                    }else {
                        return square(2600);
                    }
                }
            }
        }else {
            if (category().equals("Категорія А")){
                if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості")){
                    return squareFloors(5200,1);
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    return squareFloors(3500,1);
                }else {
                    return "Висновок: нормативно-правовими актами не передбачається";

                }
            } else if (category().equals("Категорія Б")) {
                if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості")){
                    if (floors()==3){
                        return square(3500);
                    } else if (floors()==2) {
                        return square(5200);
                    }else {
                        return square(7800);
                    }
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    return squareFloors(5200,1);
                }else {
                    return "Висновок: нормативно-правовими актами не передбачається";
                }
            } else if (category().equals("Категорія В")) {
                if (fireResistance().equals("І ступінь вогнестійкості") || fireResistance().equals("ІІ ступінь вогнестійкості")){
                    if (floors()==6){
                        return square(5200);
                    } else if (floors()==2) {
                        return square(7800);
                    }else {
                        return square(10500);
                    }
                } else if (fireResistance().equals("ІІІ ступінь вогнестійкості")) {
                    if (floors()==3){
                        return square(2200);
                    } else if (floors()==2) {
                        return square(2500);
                    }else {
                        return square(3500);
                    }
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості") || fireResistance().equals("ІІІб ступінь вогнестійкості")) {
                    return squareFloors(7800,1);
                } else if (fireResistance().equals("ІV ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(1200);
                    }else {
                        return square(2200);
                    }
                } else if (fireResistance().equals("ІVа ступінь вогнестійкості")) {
                    return squareFloors(3500,1);
                } else {
                    return squareFloors(1200,1);
                }
            } else if (category().equals("Категорія Г")) {
                return "Висновок: нормативно-правовими актами не передбачається";
            }else {
                if (fireResistance().equals("ІІІ ступінь вогнестійкості")){
                    if (floors()==3){
                        return square(3000);
                    } else if (floors()==2) {
                        return square(3500);
                    }else {
                        return square(5200);
                    }
                } else if (fireResistance().equals("ІІІа ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(3000);
                    }else {
                        return "Висновок: площа протипожежного відсіку не обмежується";
                    }
                } else if (fireResistance().equals("ІV ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(2200);
                    }else {
                        return square(3500);
                    }
                } else if (fireResistance().equals("V ступінь вогнестійкості")) {
                    if (floors()==2){
                        return square(1200);
                    }else {
                        return square(2200);
                    }
                }else if (fireResistance().equals("ІІІб ступінь вогнестійкості")){
                    return squareFloors(10500,1);
                }else {
                    return "Висновок: площа протипожежного відсіку не нормується, максимальна поверховість не обмежується";
                }
            }
        }
    }
    public String getSquareFloors(){
        return squareFloors();
    }
}
