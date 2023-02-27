package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class Garages {
    Long userId;
    DatabaseRepository databaseRepository;

    public Garages(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }
    double[] array = { 1, 1, 2, 2 };

    int numberСarSeats() {
        return databaseRepository.getParking(userId);
    }

    public String quantityExtinguisherGarages() {
        double n = numberСarSeats();
        String s;
        if (n == 0) {
            s = "🚨 Не вказана кількість місць автостоянки/боксу. Зазначте кількість та повторіть спробу!";
        } else {
            if (n >= 10 && n <= 15) {
                array[0] = array[0] * 2;
                array[1] = array[1] * 2;
                array[2] = array[2] * 2;
                array[3] = array[3] * 2;

            } else if (n > 15) {
                double i = Math.ceil(n / 15);
                array[0] = array[0] * i;
                array[1] = array[1] * i;
                array[2] = array[2] * i;
                array[3] = array[3] * i;

            }
            s = "3. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
            s = s + "🧯" + " Переносні вогнегасники:\n";
            s = s + "1. ВП-5 - " + ((int) array[0]) + " од. \n" + "2. ВП-6 - " + ((int) array[1]) + " од. \n"
                    + "3. ВВ-9 - " + ((int) array[2]) + " од. \n" + "4. ВВП-9 - " + ((int) array[3]) + " од. \n";
            s = s + "❗️ Як додатковим засобом для гасіння невеликих осередків пожеж на початкових стадіях, гаражі та автомайстерні можуть оснащуватися вогнегасниками водопінними аерозольними одноразового використання\n";
            s = s + "‼️ Водяні вогнегасники слід обрати із зарядом вогнегасної речовини, що придатна для гасіння пожеж класів А та В";
        }
        return s;
    }
}
