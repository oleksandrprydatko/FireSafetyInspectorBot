package SV.FireSafety.services;

import SV.FireSafety.repository.DatabaseRepository;

public class IndustrialPremises{

    Long userId;
    DatabaseRepository databaseRepository;
    public IndustrialPremises(Long userId, DatabaseRepository databaseRepository) {
        this.userId = userId;
        this.databaseRepository = databaseRepository;
    }

    float square(){return databaseRepository.getSquare(userId);}
    String categoryPremisses(){return databaseRepository.getCategory_premises(userId);}
    String classFire(){return databaseRepository.getClass_fire(userId);}
    String typeExtinguisher(){return databaseRepository.getType_extinguisher(userId);}

    //	int arrayDemo [] = {ВП_5, ВП_6, ВП_8, ВП_9, ВП_12, ВП_20, ВП_50, ВП_100, ВП_150};
    int[] array = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };


    String transformation(int vp) {
        String temp;
        if (vp == 0)
            temp = "не рекомендується";
        else
            temp = vp + " од.";
        return temp;
    }

    public String quantityExtinguisherPoroshok() {

        String s = null;
        double n = square() / 1000;
        double nLeft = square() % 1000;
        if ((categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б")
                || categoryPremisses().equals("Категорія В з ГГ"))
                && (classFire().equals("Клас пожежі A") || classFire().equals("Клас пожежі B") || classFire().equals("Клас пожежі C")
                || classFire().equals("Клас пожежі E"))
                && typeExtinguisher().equals("порошковий")) {
            if (square()<= 25) {
                array[0] = 2;
                array[1] = 2;
                array[2] = 1;
                array[3] = 1;
                array[4] = 1;
            } else if (square() > 25 && square() <= 50) {
                array[0] = 3;
                array[1] = 3;
                array[2] = 2;
                array[3] = 2;
                array[4] = 2;
            } else if (square()> 50 && square() <= 150) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 3;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;
            } else if (square()> 150 && square()<= 250) {
                array[0] = 6;
                array[1] = 6;
                array[2] = 4;
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square()> 250 && square() <= 500) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 6;
                array[3] = 6;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;
            } else if (square()> 500 && square() <= 1000) {
                array[0] = 16;
                array[1] = 16;
                array[2] = 12;
                array[3] = 12;
                array[4] = 8;
                array[5] = 4;
                array[6] = 3;
                array[7] = 2;
                array[8] = 1;
            } else if (square()> 1000) {

                if (nLeft == 0) {
                    array[0] = 16 * (int) n;
                    array[1] = 16 * (int) n;
                    array[2] = 12 * (int) n;
                    array[3] = 12 * (int) n;
                    array[4] = 8 * (int) n;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;
                    array[8] =(int) n;
                } else if (nLeft <= 50) {
                    array[0] = 16 * (int) n + 3;
                    array[1] = 16 * (int) n + 3;
                    array[2] = 12 * (int) n + 2;
                    array[3] = 12 * (int) n + 2;
                    array[4] = 8 * (int) n + 2;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;
                    array[8] =(int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[0] = 16 * (int) n + 4;
                    array[1] = 16 * (int) n + 4;
                    array[2] = 12 * (int) n + 3;
                    array[3] = 12 * (int) n + 3;
                    array[4] = 8 * (int) n + 2;
                    array[5] = 4 * (int) n + 1;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;
                    array[8] =(int) n;

                } else if (nLeft > 150 && nLeft <= 250) {
                    array[0] = 16 * (int) n + 6;
                    array[1] = 16 * (int) n + 6;
                    array[2] = 12 * (int) n + 4;
                    array[3] = 12 * (int) n + 4;
                    array[4] = 8 * (int) n + 3;
                    array[5] = 4 * (int) n + 2;
                    array[6] = 3 * (int) n + 1;
                    array[7] = 2 * (int) n;
                    array[8] =(int) n;

                } else if (nLeft > 250 && nLeft <= 500) {
                    array[0] = 16 * (int) n + 8;
                    array[1] = 16 * (int) n + 8;
                    array[2] = 12 * (int) n + 6;
                    array[3] = 12 * (int) n + 6;
                    array[4] = 8 * (int) n + 4;
                    array[5] = 4 * (int) n + 3;
                    array[6] = 3 * (int) n + 2;
                    array[7] = 2 * (int) n + 1;
                    array[8] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[0] = 16 * (int) n + 16;
                    array[1] = 16 * (int) n + 16;
                    array[2] = 12 * (int) n + 12;
                    array[3] = 12 * (int) n + 12;
                    array[4] = 8 * (int) n + 8;
                    array[5] = 4 * (int) n + 4;
                    array[6] = 3 * (int) n + 3;
                    array[7] = 2 * (int) n + 2;
                    array[8] =(int) n + 1;
                }
            }

            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square()<= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1]) + "\n"
                        + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - " + transformation(array[3])
                        + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                        + "\n" + "3. ВП-100 - " + transformation(array[7]) + "\n" + "4. ВП-150 - "
                        + transformation(array[8]) + "\n";
            } else if (square()> 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1]) + "\n"
                        + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - " + transformation(array[3])
                        + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                        + "\n" + "3. ВП-100 - " + transformation(array[7]) + "\n" + "4. ВП-150 - "
                        + transformation(array[8]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВП-5 - 3 од. або ВП-6 - 3 од. або ВП-8 - 2 од. або ВП-9 - 2 од. або ВП-12 - 2 од.";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До пересувних вогнегасників ВП-50/ВП-100/ВП-150 необхідно додатково обрати: "
                            + "ВП-5 - 4 од. або ВП-6 - 4 од. або ВП-8 - 3 од. або ВП-9 - 3 од. або ВП-12 - 2 од.";
                } else if (nLeft > 150 && nLeft <= 250) {
                    s = s + "❗️ До пересувних вогнегасників ВП-100/ВП-150 необхідно додатково обрати: "
                            + "ВП-5 - 6 од. або ВП-6 - 6 од. або ВП-8 - 4 од. або ВП-9 - 4 од. або ВП-12 - 3 од.";
                } else if (nLeft > 250 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВП-150 необхідно додатково обрати: "
                            + "ВП-5 - 8 од. або ВП-6 - 8 од. або ВП-8 - 6 од. або ВП-9 - 6 од. або ВП-12 - 4 од.";
                }
            }

        } else if (categoryPremisses().equals("Категорія В без ГГ")
                && (classFire().equals("Клас пожежі A") || classFire() .equals("Клас пожежі E")) && typeExtinguisher().equals("порошковий")) {
            if (square()<= 50) {
                array[0] = 2;
                array[1] = 2;
                array[2] = 1;
                array[3] = 1;
                array[4] = 1;
            } else if (square()> 50 && square()<= 100) {
                array[0] = 3;
                array[1] = 3;
                array[2] = 2;
                array[3] = 2;
                array[4] = 2;
            } else if (square()> 100 && square() <= 300) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 3;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;
            } else if (square()> 300 && square()<= 500) {
                array[0] = 6;
                array[1] = 6;
                array[2] = 4;
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square()> 500 && square()<= 1000) {
                array[0] = 9;
                array[1] = 9;
                array[2] = 7;
                array[3] = 7;
                array[4] = 5;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;
            } else if (square()> 1000) {

                if (nLeft == 0) {
                    array[0] = 9 * (int) n;
                    array[1] = 9 * (int) n;
                    array[2] = 7 * (int) n;
                    array[3] = 7 * (int) n;
                    array[4] = 5 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft <= 50) {
                    array[0] = 9 * (int) n + 2;
                    array[1] = 9 * (int) n + 2;
                    array[2] = 7 * (int) n + 1;
                    array[3] = 7 * (int) n + 1;
                    array[4] = 5 * (int) n + 1;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 50 && nLeft <= 100) {
                    array[0] = 9 * (int) n + 3;
                    array[1] = 9 * (int) n + 3;
                    array[2] = 7 * (int) n + 2;
                    array[3] = 7 * (int) n + 2;
                    array[4] = 5 * (int) n + 2;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 100 && nLeft <= 300) {
                    array[0] = 9 * (int) n + 4;
                    array[1] = 9 * (int) n + 4;
                    array[2] = 7 * (int) n + 3;
                    array[3] = 7 * (int) n + 3;
                    array[4] = 5 * (int) n + 2;
                    array[5] = 3 * (int) n + 1;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 300 && nLeft <= 500) {
                    array[0] = 9 * (int) n + 6;
                    array[1] = 9 * (int) n + 6;
                    array[2] = 7 * (int) n + 4;
                    array[3] = 7 * (int) n + 4;
                    array[4] = 5 * (int) n + 3;
                    array[5] = 3 * (int) n + 2;
                    array[6] = 2 * (int) n + 1;
                    array[7] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[0] = 9 * (int) n + 9;
                    array[1] = 9 * (int) n + 9;
                    array[2] = 7 * (int) n + 7;
                    array[3] = 7 * (int) n + 7;
                    array[4] = 5 * (int) n + 5;
                    array[5] = 3 * (int) n + 3;
                    array[6] = 2 * (int) n + 2;
                    array[7] =(int) n + 1;
                }
            }

            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square()<= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1]) + "\n"
                        + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - " + transformation(array[3])
                        + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                        + "\n" + "3. ВП-100 - " + transformation(array[7]) + "\n";
            } else if (square()> 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1]) + "\n"
                        + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - " + transformation(array[3])
                        + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                        + "\n" + "3. ВП-100 - " + transformation(array[7]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВП-5 - 2 од. або ВП-6 - 2 од. або ВП-8 - 1 од. або ВП-9 - 1 од. або ВП-12 - 1 од.";
                } else if (nLeft > 50 && nLeft <= 100) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВП-5 - 3 од. або ВП-6 - 3 од. або ВП-8 - 2 од. або ВП-9 - 2 од. або ВП-12 - 2 од.";
                } else if (nLeft > 100 && nLeft <= 300) {
                    s = s + "❗️ До пересувних вогнегасників ВП-50/ВП-100 необхідно додатково обрати: "
                            + "ВП-5 - 4 од. або ВП-6 - 4 од. або ВП-8 - 3 од. або ВП-9 - 3 од. або ВП-12 - 2 од.";
                } else if (nLeft > 300 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВП-100 необхідно додатково обрати: "
                            + "ВП-5 - 6 од. або ВП-6 - 6 од. або ВП-8 - 4 од. або ВП-9 - 4 од. або ВП-12 - 3 од.";
                } else if (nLeft > 500 && nLeft < 1000) {
                    s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                    s = s + "🧯" + " Переносні вогнегасники:\n";
                    s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1])
                            + "\n" + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - "
                            + transformation(array[3]) + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                    s = s + "🧯" + " Пересувні вогнегасники:\n";
                    s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                            + "\n" + "3. ВП-100 - " + transformation(array[7]) + "\n";
                }
            }
        } else if (categoryPremisses().equals("Категорія Г") && (classFire().equals("Клас пожежі B") || classFire().equals("Клас пожежі C"))
                && typeExtinguisher().equals("порошковий")) {
            if (square() <= 50) {
                array[0] = 2;
                array[1] = 2;
                array[2] = 1;
                array[3] = 1;
                array[4] = 1;
            } else if (square() > 50 && square() <= 100) {
                array[0] = 3;
                array[1] = 3;
                array[2] = 2;
                array[3] = 2;
                array[4] = 2;
            } else if (square()> 100 && square()<= 300) {
                array[0] = 5;
                array[1] = 5;
                array[2] = 3;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;
            } else if (square()> 300 && square() <= 500) {
                array[0] = 7;
                array[1] = 7;
                array[2] = 4;
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square()> 500 && square() <= 1000) {
                array[0] = 11;
                array[1] = 11;
                array[2] = 7;
                array[3] = 7;
                array[4] = 5;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;
            } else if (square()> 1000) {

                if (nLeft == 0) {
                    array[0] = (int) n;
                    array[1] = (int) n;
                    array[2] = 7 * (int) n;
                    array[3] = 7 * (int) n;
                    array[4] = 5 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft <= 50) {
                    array[0] = (int) n + 2;
                    array[1] = (int) n + 2;
                    array[2] = 7 * (int) n + 1;
                    array[3] = 7 * (int) n + 1;
                    array[4] = 5 * (int) n + 1;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 50 && nLeft <= 100) {
                    array[0] = (int) n + 3;
                    array[1] = (int) n + 3;
                    array[2] = 7 * (int) n + 2;
                    array[3] = 7 * (int) n + 2;
                    array[4] = 5 * (int) n + 2;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 100 && nLeft <= 300) {
                    array[0] = (int) n + 5;
                    array[1] = (int) n + 5;
                    array[2] = 7 * (int) n + 3;
                    array[3] = 7 * (int) n + 3;
                    array[4] = 5 * (int) n + 2;
                    array[5] = 3 * (int) n + 1;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 300 && nLeft <= 500) {
                    array[0] = (int) n + 7;
                    array[1] = (int) n + 7;
                    array[2] = 7 * (int) n + 4;
                    array[3] = 7 * (int) n + 4;
                    array[4] = 5 * (int) n + 3;
                    array[5] = 3 * (int) n + 2;
                    array[6] = 2 * (int) n + 1;
                    array[7] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[0] = (int) n + 11;
                    array[1] = (int) n + 11;
                    array[2] = 7 * (int) n + 7;
                    array[3] = 7 * (int) n + 7;
                    array[4] = 5 * (int) n + 5;
                    array[5] = 3 * (int) n + 3;
                    array[6] = 2 * (int) n + 2;
                    array[7] =(int) n + 1;
                }
            }

            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square()<= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1]) + "\n"
                        + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - " + transformation(array[3])
                        + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                        + "\n" + "3. ВП-100 - " + transformation(array[7]) + "\n";
            } else if (square()> 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1]) + "\n"
                        + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - " + transformation(array[3])
                        + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                        + "\n" + "3. ВП-100 - " + transformation(array[7]) + "\n";

                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВП-5 - 2 од. або ВП-6 - 2 од. або ВП-8 - 1 од. або ВП-9 - 1 од. або ВП-12 - 1 од.";
                } else if (nLeft > 50 && nLeft <= 100) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВП-5 - 3 од. або ВП-6 - 3 од. або ВП-8 - 2 од. або ВП-9 - 2 од. або ВП-12 - 2 од.";
                } else if (nLeft > 100 && nLeft <= 300) {
                    s = s + "❗️ До пересувних вогнегасників ВП-50/ВП-100 необхідно додатково обрати: "
                            + "ВП-5 - 5 од. або ВП-6 - 5 од. або ВП-8 - 3 од. або ВП-9 - 3 од. або ВП-12 - 2 од.";
                } else if (nLeft > 300 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВП-100 необхідно додатково обрати: "
                            + "ВП-5 - 7 од. або ВП-6 - 7 од. або ВП-8 - 4 од. або ВП-9 - 4 од. або ВП-12 - 3 од.";
                }
            }
        } else if ((categoryPremisses().equals("Категорія Г") || categoryPremisses().equals("Категорія Д"))
                && (classFire().equals("Клас пожежі A") || classFire().equals("Клас пожежі E")) && typeExtinguisher().equals("порошковий")) {
            if (square()<= 50) {
                array[0] = 2;
                array[1] = 2;
                array[2] = 1;
                array[3] = 1;
                array[4] = 1;
            } else if (square()> 50 && square() <= 150) {
                array[0] = 3;
                array[1] = 3;
                array[2] = 2;
                array[3] = 2;
                array[4] = 2;
            } else if (square()> 150 && square()<= 500) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 3;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;
            } else if (square()> 500 && square() <= 1000) {
                array[0] = 6;
                array[1] = 6;
                array[2] = 4;
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square() > 1000) {

                if (nLeft == 0) {
                    array[0] = 6 * (int) n;
                    array[1] = 6 * (int) n;
                    array[2] = 4 * (int) n;
                    array[3] = 4 * (int) n;
                    array[4] = 3 * (int) n;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft <= 50) {
                    array[0] = 6 * (int) n + 2;
                    array[1] = 6 * (int) n + 2;
                    array[2] = 4 * (int) n + 1;
                    array[3] = 4 * (int) n + 1;
                    array[4] = 3 * (int) n + 1;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[0] = 6 * (int) n + 3;
                    array[1] = 6 * (int) n + 3;
                    array[2] = 4 * (int) n + 2;
                    array[3] = 4 * (int) n + 2;
                    array[4] = 3 * (int) n + 2;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 150 && nLeft <= 500) {
                    array[0] = 6 * (int) n + 4;
                    array[1] = 6 * (int) n + 4;
                    array[2] = 4 * (int) n + 3;
                    array[3] = 4 * (int) n + 3;
                    array[4] = 3 * (int) n + 2;
                    array[5] = 2 * (int) n + 1;
                    array[6] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[0] = 6 * (int) n + 6;
                    array[1] = 6 * (int) n + 6;
                    array[2] = 4 * (int) n + 4;
                    array[3] = 4 * (int) n + 4;
                    array[4] = 3 * (int) n + 3;
                    array[5] = 2 * (int) n + 2;
                    array[6] =(int) n + 1;

                }
            }

            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1]) + "\n"
                        + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - " + transformation(array[3])
                        + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                        + "\n";
            } else if (square()> 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВП-5 - " + transformation(array[0]) + "\n" + "2. ВП-6 - " + transformation(array[1]) + "\n"
                        + "3. ВП-8 - " + transformation(array[2]) + "\n" + "4. ВП-9 - " + transformation(array[3])
                        + "\n" + "5. ВП-12 - " + transformation(array[4]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВП-20 - " + transformation(array[5]) + "\n" + "2. ВП-50 - " + transformation(array[6])
                        + "\n";

                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВП-5 - 2 од. або ВП-6 - 2 од. або ВП-8 - 1 од. або ВП-9 - 1 од. або ВП-12 - 1 од.";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВП-5 - 3 од. або ВП-6 - 3 од. або ВП-8 - 2 од. або ВП-9 - 2 од. або ВП-12 - 2 од.";
                } else if (nLeft > 150 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВП-50 необхідно додатково обрати: "
                            + "ВП-5 - 4 од. або ВП-6 - 4 од. або ВП-8 - 3 од. або ВП-9 - 3 од. або ВП-12 - 2 од.";
                }
            }
        } else if ((categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б")
                || categoryPremisses().equals("Категорія В з ГГ") || categoryPremisses().equals("Категорія В без ГГ")
                || categoryPremisses().equals("Категорія Г") || categoryPremisses().equals("Категорія Д"))
                && classFire().equals("Клас пожежі D") && typeExtinguisher().equals("порошковий")) {
            s = "🧯 Оснащення порошковими вогнегасниками для гасіння пожеж класу D слід проводити з дотриманням галузевих норм, погоджених у встановленому порядку";
        }
        return s;
    }

    public String quantityExtinguisherVodopinni() {
        String s = null;
        double n = square() / 1000;
        double nLeft = square() % 1000;
        if ((categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б")
                || categoryPremisses().equals("Категорія В з ГГ")) && classFire().equals("Клас пожежі A")
                && typeExtinguisher().equals("водопінний")) {
            if (square() <= 25) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 2;
                array[3] = 2;
            } else if (square()> 25 && square() <= 50) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 4;
                array[3] = 3;
                array[4] = 1;
            } else if (square()> 50 && square() <= 150) {
                array[0] = 12;
                array[1] = 12;
                array[2] = 6;
                array[3] = 4;
                array[4] = 2;
                array[5] = 1;
            } else if (square()> 150 && square() <= 250) {
                array[2] = 8;
                array[3] = 6;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square()> 250 && square() <= 500) {
                array[2] = 12;
                array[3] = 8;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;
            } else if (square()> 500 && square() <= 1000) {
                array[3] = 16;
                array[4] = 6;
                array[5] = 4;
                array[6] = 3;
                array[7] = 2;
            } else if (square()> 1000) {
                if (nLeft == 0) {
                    array[3] = 16 * (int) n;
                    array[4] = 6 * (int) n;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft <= 50) {
                    array[3] = 16 * (int) n + 3;
                    array[4] = 6 * (int) n + 1;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[3] = 16 * (int) n + 4;
                    array[4] = 6 * (int) n + 2;
                    array[5] = 4 * (int) n + 1;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 150 && nLeft <= 250) {
                    array[3] = 16 * (int) n + 6;
                    array[4] = 6 * (int) n + 3;
                    array[5] = 4 * (int) n + 2;
                    array[6] = 3 * (int) n + 1;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 250 && nLeft <= 500) {
                    array[3] = 16 * (int) n + 8;
                    array[4] = 6 * (int) n + 4;
                    array[5] = 4 * (int) n + 3;
                    array[6] = 3 * (int) n + 2;
                    array[7] = 2 * (int) n + 1;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[3] = 16 * (int) n + 16;
                    array[4] = 6 * (int) n + 6;
                    array[5] = 4 * (int) n + 4;
                    array[6] = 3 * (int) n + 3;
                    array[7] = 2 * (int) n + 2;
                }
            }
            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square()<= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n" + "4. ВВП-150 - "
                        + transformation(array[7]) + "\n";
            } else if (square()> 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n" + "4. ВВП-150 - "
                        + transformation(array[7]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До пересувних вогнегасників ВВП-50/ВВП-100/ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 8 од. або ВВП-6 - 8 од. або ВВП-9 - 4 од. або ВВП-12 - 3 од.";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До пересувних вогнегасників ВВП-100/ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 12 од. або ВВП-6 - 12 од. або ВВП-9 - 6 од. або ВВП-12 - 4 од.";
                } else if (nLeft > 150 && nLeft <= 250) {
                    s = s + "❗️ До пересувного вогнегасника ВВП-150 необхідно додатково обрати: "
                            + "ВВП-9 - 8 од. або ВВП-12 - 6 од.";
                }
            }
        } else if ((categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б")
                || categoryPremisses().equals("Категорія В з ГГ")) && classFire().equals("Клас пожежі B")
                && typeExtinguisher().equals("водопінний")) {
            if (square()<= 25) {
                array[0] = 3;
                array[1] = 3;
                array[2] = 2;
                array[3] = 1;
            } else if (square()> 25 && square() <= 50) {
                array[0] = 5;
                array[1] = 5;
                array[2] = 3;
                array[3] = 2;
                array[4] = 1;
            } else if (square()> 50 && square() <= 150) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 5;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;
            } else if (square()> 150 && square()<= 250) {
                array[2] = 7;
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square()> 250 && square()<= 500) {
                array[2] = 10;
                array[3] = 6;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;
            } else if (square()> 500 && square() <= 1000) {
                array[3] = 12;
                array[4] = 6;
                array[5] = 4;
                array[6] = 3;
                array[7] = 2;
            } else if (square()> 1000) {
                if (nLeft == 0) {
                    array[3] = 12 * (int) n;
                    array[4] = 6 * (int) n;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft <= 50) {
                    array[3] = 12 * (int) n + 2;
                    array[4] = 6 * (int) n + 1;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[3] = 12 * (int) n + 3;
                    array[4] = 6 * (int) n + 2;
                    array[5] = 4 * (int) n + 1;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 150 && nLeft <= 250) {
                    array[3] = 12 * (int) n + 4;
                    array[4] = 6 * (int) n + 3;
                    array[5] = 4 * (int) n + 2;
                    array[6] = 3 * (int) n + 1;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 250 && nLeft <= 500) {
                    array[3] = 12 * (int) n + 6;
                    array[4] = 6 * (int) n + 4;
                    array[5] = 4 * (int) n + 3;
                    array[6] = 3 * (int) n + 2;
                    array[7] = 2 * (int) n + 1;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[3] = 12 * (int) n + 12;
                    array[4] = 6 * (int) n + 6;
                    array[5] = 4 * (int) n + 4;
                    array[6] = 3 * (int) n + 3;
                    array[7] = 2 * (int) n + 2;
                }
            }
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square()<= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n" + "4. ВВП-150 - "
                        + transformation(array[7]) + "\n";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n" + "4. ВВП-150 - "
                        + transformation(array[7]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До пересувних вогнегасників ВВП-50/ВВП-100/ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 5 од. або ВВП-6 - 5 од. або ВВП-9 - 3 од. або ВВП-12 - 2 од.";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До пересувних вогнегасників ВВП-100/ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 8 од. або ВВП-6 - 8 од. або ВВП-9 - 5 од. або ВВП-12 - 3 од.";
                } else if (nLeft > 150 && nLeft <= 250) {
                    s = s + "❗️ До пересувного вогнегасника ВВП-150 необхідно додатково обрати: "
                            + "ВВП-9 - 7 од. або ВВП-12 - 4 од.";
                }
            }
        } else if (categoryPremisses().equals("Категорія В без ГГ") && classFire().equals("Клас пожежі A")
                && typeExtinguisher().equals("водопінний")) {
            if (square()> 0 && square()<= 50) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 2;
                array[3] = 2;

            } else if (square()> 50 && square()<= 100) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 4;
                array[3] = 3;
                array[4] = 1;

            } else if (square()> 100 && square()<= 300) {
                array[0] = 12;
                array[1] = 12;
                array[2] = 6;
                array[3] = 4;
                array[4] = 2;
                array[5] = 1;

            } else if (square() > 300 && square()<= 500) {
                array[2] = 8;
                array[3] = 6;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;

            } else if (square()> 500 && square() <= 1000) {
                array[2] = 14;
                array[3] = 10;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;

            } else if (square()> 1000) {
                if (nLeft == 0) {
                    array[2] = 14 * (int) n;
                    array[3] = 10 * (int) n;
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft <= 50) {
                    array[2] = 14 * (int) n + 2;
                    array[3] = 10 * (int) n + 2;
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 50 && nLeft <= 100) {
                    array[2] = 14 * (int) n + 4;
                    array[3] = 10 * (int) n + 3;
                    array[4] = 4 * (int) n + 1;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 100 && nLeft <= 300) {
                    array[2] = 14 * (int) n + 6;
                    array[3] = 10 * (int) n + 4;
                    array[4] = 4 * (int) n + 2;
                    array[5] = 3 * (int) n + 1;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 300 && nLeft <= 500) {
                    array[2] = 14 * (int) n + 8;
                    array[3] = 10 * (int) n + 6;
                    array[4] = 4 * (int) n + 3;
                    array[5] = 3 * (int) n + 2;
                    array[6] = 2 * (int) n + 1;
                    array[7] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[2] = 14 * (int) n + 14;
                    array[3] = 10 * (int) n + 10;
                    array[4] = 4 * (int) n + 4;
                    array[5] = 3 * (int) n + 3;
                    array[6] = 2 * (int) n + 2;
                    array[7] =(int) n + 1;
                }
            }
            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n" + "4. ВВП-150 - "
                        + transformation(array[7]) + "\n";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n" + "4. ВВП-150 - "
                        + transformation(array[7]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВВП-5 - 4 од. або ВВП-6 - 4 од. або ВВП-9 - 2 од. або ВВП-12 - 2 од.";
                } else if (nLeft > 50 && nLeft <= 100) {
                    s = s + "❗️ До пересувних вогнегасників ВВП-50/ВВП-100/ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 8 од. або ВВП-6 - 8 од. або ВВП-9 - 4 од. або ВВП-12 - 3 од.";
                } else if (nLeft > 100 && nLeft <= 300) {
                    s = s + "❗️ До пересувноих вогнегасників ВВП-100/ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 12 од. або ВВП-6 - 12 од. або ВВП-9 - 6 од. або ВВП-12 - 4 од.";
                } else if (nLeft > 300 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВВП-150 необхідно додатково обрати: "
                            + "ВВП-9 - 8 од. або ВВП-12 - 6 од.";
                }
            }
        } else if (categoryPremisses().equals("Категорія Г") && classFire().equals("Клас пожежі B")
                && typeExtinguisher().equals("водопінний")) {
            if (square()> 0 && square() <= 50) {
                array[0] = 3;
                array[1] = 3;
                array[2] = 2;
                array[3] = 1;

            } else if (square()> 50 && square() <= 100) {
                array[0] = 5;
                array[1] = 5;
                array[2] = 3;
                array[3] = 2;
                array[4] = 1;

            } else if (square()> 100 && square() <= 300) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 5;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;

            } else if (square()> 300 && square()<= 500) {
                array[0] = 11;
                array[1] = 11;
                array[2] = 7;
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;

            } else if (square()> 500 && square()<= 1000) {
                array[2] = 12;
                array[3] = 7;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;

            } else if (square()> 1000) {
                if (nLeft == 0) {
                    array[2] = 12 * (int) n;
                    array[3] = 7 * (int) n;
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft <= 50) {
                    array[2] = 12 * (int) n + 2;
                    array[3] = 7 * (int) n + 1;
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 50 && nLeft <= 100) {
                    array[2] = 12 * (int) n + 3;
                    array[3] = 7 * (int) n + 2;
                    array[4] = 4 * (int) n + 1;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 100 && nLeft <= 300) {
                    array[2] = 12 * (int) n + 5;
                    array[3] = 7 * (int) n + 3;
                    array[4] = 4 * (int) n + 2;
                    array[5] = 3 * (int) n + 1;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 300 && nLeft <= 500) {
                    array[2] = 12 * (int) n + 7;
                    array[3] = 7 * (int) n + 4;
                    array[4] = 4 * (int) n + 3;
                    array[5] = 3 * (int) n + 2;
                    array[6] = 2 * (int) n + 1;
                    array[7] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[2] = 12 * (int) n + 12;
                    array[3] = 7 * (int) n + 7;
                    array[4] = 4 * (int) n + 4;
                    array[5] = 3 * (int) n + 3;
                    array[6] = 2 * (int) n + 2;
                    array[7] =(int) n + 1;
                }
            }
            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square()<= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n" + "4. ВВП-150 - "
                        + transformation(array[7]) + "\n";
            } else if (square()> 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n" + "4. ВВП-150 - "
                        + transformation(array[7]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВВП-5 - 3 од. або ВВП-6 - 3 од. або ВВП-9 - 2 од. або ВВП-12 - 1 од.";
                } else if (nLeft > 50 && nLeft <= 100) {
                    s = s + "❗️ До пересувних вогнегасників ВВП-50/ВВП-100/ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 5 од. або ВВП-6 - 5 од. або ВВП-9 - 3 од. або ВВП-12 - 2 од.";
                } else if (nLeft > 100 && nLeft <= 300) {
                    s = s + "❗️ До пересувноих вогнегасників ВВП-100/ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 8 од. або ВВП-6 - 8 од. або ВВП-9 - 5 од. або ВВП-12 - 3 од.";
                } else if (nLeft > 300 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВВП-150 необхідно додатково обрати: "
                            + "ВВП-5 - 11 од. або ВВП-6 - 11 од. абоВВП-9 - 7 од. або ВВП-12 - 4 од.";
                }
            }
        } else if ((categoryPremisses().equals("Категорія Г") || categoryPremisses().equals("Категорія Д"))
                && classFire().equals("Клас пожежі A") && typeExtinguisher().equals("водопінний")) {
            if (square()> 0 && square()<= 50) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 2;
                array[3] = 2;

            } else if (square()> 50 && square() <= 150) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 4;
                array[3] = 3;
                array[4] = 1;

            } else if (square() > 150 && square() <= 500) {
                array[0] = 12;
                array[1] = 12;
                array[2] = 6;
                array[3] = 4;
                array[4] = 2;
                array[5] = 1;

            } else if (square() > 500 && square() <= 1000) {
                array[0] = 16;
                array[1] = 16;
                array[2] = 8;
                array[3] = 6;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;

            } else if (square() > 1000) {
                if (nLeft == 0) {
                    array[0] = 16 * (int) n;
                    array[1] = 16 * (int) n;
                    array[2] = 8 * (int) n;
                    array[3] = 6 * (int) n;
                    array[4] = 3 * (int) n;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft <= 50) {
                    array[0] = 16 * (int) n + 4;
                    array[1] = 16 * (int) n + 4;
                    array[2] = 8 * (int) n + 2;
                    array[3] = 6 * (int) n + 2;
                    array[4] = 3 * (int) n;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[0] = 16 * (int) n + 8;
                    array[1] = 16 * (int) n + 8;
                    array[2] = 8 * (int) n + 4;
                    array[3] = 6 * (int) n + 3;
                    array[4] = 3 * (int) n + 1;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 150 && nLeft <= 500) {
                    array[0] = 16 * (int) n + 12;
                    array[1] = 16 * (int) n + 12;
                    array[2] = 8 * (int) n + 6;
                    array[3] = 6 * (int) n + 4;
                    array[4] = 3 * (int) n + 2;
                    array[5] = 2 * (int) n + 1;
                    array[6] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[0] = 16 * (int) n + 16;
                    array[1] = 16 * (int) n + 16;
                    array[2] = 8 * (int) n + 8;
                    array[3] = 6 * (int) n + 6;
                    array[4] = 3 * (int) n + 3;
                    array[5] = 2 * (int) n + 2;
                    array[6] =(int) n + 1;

                }
            }
            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВП-5 - " + transformation(array[0]) + "\n" + "2. ВВП-6 - " + transformation(array[1])
                        + "\n" + "3. ВВП-9 - " + transformation(array[2]) + "\n" + "4. ВВП-12 - "
                        + transformation(array[3]) + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВП-20 - " + transformation(array[4]) + "\n" + "2. ВВП-50 - " + transformation(array[5])
                        + "\n" + "3. ВВП-100 - " + transformation(array[6]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВВП-5 - 4 од. або ВВП-6 - 4 од. або ВВП-9 - 2 од. або ВВП-12 - 2 од.";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До пересувних вогнегасників ВВП-50/ВВП-100 необхідно додатково обрати: "
                            + "ВВП-5 - 8 од. або ВВП-6 - 8 од. або ВВП-9 - 4 од. або ВВП-12 - 3 од.";
                } else if (nLeft > 150 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВВП-100 необхідно додатково обрати: "
                            + "ВВП-5 - 12 од. або ВВП-6 - 12 од. або ВВП-9 - 6 од. або ВВП-12 - 4 од.";
                }
            }
        }
        return s;
    }

    public String quantityExtinguisherVodiani() {
        String s = null;
        double n = square() / 1000;
        double nLeft = square() % 1000;
        if ((categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б")
                || categoryPremisses().equals("Категорія В з ГГ")) && classFire().equals("Клас пожежі A")
                && typeExtinguisher().equals("водяний")) {
            if (square() <= 25) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 2;
                array[3] = 2;
            } else if (square() > 25 && square() <= 50) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 4;
                array[3] = 3;
                array[4] = 1;
            } else if (square() > 50 && square() <= 150) {
                array[0] = 12;
                array[1] = 12;
                array[2] = 6;
                array[3] = 4;
                array[4] = 2;
                array[5] = 1;
            } else if (square() > 150 && square() <= 250) {
                array[2] = 8;
                array[3] = 6;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square() > 250 && square() <= 500) {
                array[2] = 12;
                array[3] = 8;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;
            } else if (square() > 500 && square() <= 1000) {
                array[3] = 16;
                array[4] = 6;
                array[5] = 4;
                array[6] = 3;
                array[7] = 2;
            } else if (square() > 1000) {
                if (nLeft == 0) {
                    array[3] = 16 * (int) n;
                    array[4] = 6 * (int) n;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft <= 50) {
                    array[3] = 16 * (int) n + 3;
                    array[4] = 6 * (int) n + 1;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[3] = 16 * (int) n + 4;
                    array[4] = 6 * (int) n + 2;
                    array[5] = 4 * (int) n + 1;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 150 && nLeft <= 250) {
                    array[3] = 16 * (int) n + 6;
                    array[4] = 6 * (int) n + 3;
                    array[5] = 4 * (int) n + 2;
                    array[6] = 3 * (int) n + 1;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 250 && nLeft <= 500) {
                    array[3] = 16 * (int) n + 8;
                    array[4] = 6 * (int) n + 4;
                    array[5] = 4 * (int) n + 3;
                    array[6] = 3 * (int) n + 2;
                    array[7] = 2 * (int) n + 1;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[3] = 16 * (int) n + 16;
                    array[4] = 6 * (int) n + 6;
                    array[5] = 4 * (int) n + 4;
                    array[6] = 3 * (int) n + 3;
                    array[7] = 2 * (int) n + 2;
                }
            }

            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n" + "4. ВВ-150 - "
                        + transformation(array[7]) + "\n";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n" + "4. ВВ-150 - "
                        + transformation(array[7]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До пересувних вогнегасників ВВ-50/ВВ-100/ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 8 од. або ВВ-6 - 8 од. або ВВ-9 - 4 од. або ВВ-12 - 3 од.";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До пересувних вогнегасників ВВ-100/ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 12 од. або ВВ-6 - 12 од. або ВВ-9 - 6 од. або ВВ-12 - 4 од.";
                } else if (nLeft > 150 && nLeft <= 250) {
                    s = s + "❗️ До пересувного вогнегасника ВВ-150 необхідно додатково обрати: "
                            + "ВВ-9 - 8 од. або ВВ-12 - 6 од.";
                }
            }
        } else if ((categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б")
                || categoryPremisses().equals("Категорія В з ГГ")) && classFire().equals("Клас пожежі B")
                && typeExtinguisher().equals("водяний")) {
            if (square() <= 25) {
                array[0] = 3;
                array[1] = 3;
                array[2] = 2;
                array[3] = 1;
            } else if (square() > 25 && square() <= 50) {
                array[0] = 5;
                array[1] = 5;
                array[2] = 3;
                array[3] = 2;
                array[4] = 1;
            } else if (square()> 50 && square() <= 150) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 5;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;
            } else if (square() > 150 && square() <= 250) {
                array[2] = 7;
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square() > 250 && square() <= 500) {
                array[2] = 10;
                array[3] = 6;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;
            } else if (square() > 500 && square() <= 1000) {
                array[3] = 12;
                array[4] = 6;
                array[5] = 4;
                array[6] = 3;
                array[7] = 2;
            } else if (square() > 1000) {
                if (nLeft == 0) {
                    array[3] = 12 * (int) n;
                    array[4] = 6 * (int) n;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft <= 50) {
                    array[3] = 12 * (int) n + 2;
                    array[4] = 6 * (int) n + 1;
                    array[5] = 4 * (int) n;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[3] = 12 * (int) n + 3;
                    array[4] = 6 * (int) n + 2;
                    array[5] = 4 * (int) n + 1;
                    array[6] = 3 * (int) n;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 150 && nLeft <= 250) {
                    array[3] = 12 * (int) n + 4;
                    array[4] = 6 * (int) n + 3;
                    array[5] = 4 * (int) n + 2;
                    array[6] = 3 * (int) n + 1;
                    array[7] = 2 * (int) n;

                } else if (nLeft > 250 && nLeft <= 500) {
                    array[3] = 12 * (int) n + 6;
                    array[4] = 6 * (int) n + 4;
                    array[5] = 4 * (int) n + 3;
                    array[6] = 3 * (int) n + 2;
                    array[7] = 2 * (int) n + 1;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[3] = 12 * (int) n + 12;
                    array[4] = 6 * (int) n + 6;
                    array[5] = 4 * (int) n + 4;
                    array[6] = 3 * (int) n + 3;
                    array[7] = 2 * (int) n + 2;
                }
            }

            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n" + "4. ВВ-150 - "
                        + transformation(array[7]) + "\n";
                s = s + "‼️ Для гасіння пожеж класу В слід застосовувати водяні вогнегасники із зарядом води з добавками, що забезпечують гасіння пожеж класу В";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n" + "4. ВВ-150 - "
                        + transformation(array[7]) + "\n";
                s = s + "‼️ Для гасіння пожеж класу В слід застосовувати водяні вогнегасники із зарядом води з добавками, що забезпечують гасіння пожеж класу В";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До пересувних вогнегасників ВВ-50/ВВ-100/ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 5 од. або ВВ-6 - 5 од. або ВВ-9 - 3 од. або ВВ-12 - 2 од." + "\n";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До пересувних вогнегасників ВВ-100/ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 8 од. або ВВ-6 - 8 од. або ВВ-9 - 5 од. або ВВ-12 - 3 од." + "\n";
                } else if (nLeft > 150 && nLeft <= 250) {
                    s = s + "❗️ До пересувного вогнегасника ВВ-150 необхідно додатково обрати: "
                            + "ВВ-9 - 7 од. або ВВ-12 - 4 од." + "\n";
                }
            }
        } else if (categoryPremisses().equals("Категорія В без ГГ") && classFire().equals("Клас пожежі A")
                && typeExtinguisher().equals("водяний")) {
            if (square() > 0 && square() <= 50) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 2;
                array[3] = 2;

            } else if (square() > 50 && square() <= 100) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 4;
                array[3] = 3;
                array[4] = 1;

            } else if (square() > 100 && square() <= 300) {
                array[0] = 12;
                array[1] = 12;
                array[2] = 6;
                array[3] = 4;
                array[4] = 2;
                array[5] = 1;

            } else if (square() > 300 && square() <= 500) {
                array[2] = 8;
                array[3] = 6;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;

            } else if (square() > 500 && square() <= 1000) {
                array[2] = 14;
                array[3] = 10;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;

            } else if (square()> 1000) {
                if (nLeft == 0) {
                    array[2] = 14 * (int) n;
                    array[3] = 10 * (int) n;
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft <= 50) {
                    array[2] = 14 * (int) n + 2;
                    array[3] = 10 * (int) n + 2;
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 50 && nLeft <= 100) {
                    array[2] = 14 * (int) n + 4;
                    array[3] = 10 * (int) n + 3;
                    array[4] = 4 * (int) n + 1;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 100 && nLeft <= 300) {
                    array[2] = 14 * (int) n + 6;
                    array[3] = 10 * (int) n + 4;
                    array[4] = 4 * (int) n + 2;
                    array[5] = 3 * (int) n + 1;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 300 && nLeft <= 500) {
                    array[2] = 14 * (int) n + 8;
                    array[3] = 10 * (int) n + 6;
                    array[4] = 4 * (int) n + 3;
                    array[5] = 3 * (int) n + 2;
                    array[6] = 2 * (int) n + 1;
                    array[7] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[2] = 14 * (int) n + 14;
                    array[3] = 10 * (int) n + 10;
                    array[4] = 4 * (int) n + 4;
                    array[5] = 3 * (int) n + 3;
                    array[6] = 2 * (int) n + 2;
                    array[7] =(int) n + 1;
                }
            }
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n" + "4. ВВ-150 - "
                        + transformation(array[7]) + "\n";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n" + "4. ВВ-150 - "
                        + transformation(array[7]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВВ-5 - 4 од. або ВВ-6 - 4 од. або ВВ-9 - 2 од. або ВВ-12 - 2 од.";
                } else if (nLeft > 50 && nLeft <= 100) {
                    s = s + "❗️ До пересувних вогнегасників ВВ-50/ВВ-100/ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 8 од. або ВВ-6 - 8 од. або ВВ-9 - 4 од. або ВВ-12 - 3 од.";
                } else if (nLeft > 100 && nLeft <= 300) {
                    s = s + "❗️ До пересувноих вогнегасників ВВ-100/ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 12 од. або ВВ-6 - 12 од. або ВВ-9 - 6 од. або ВВ-12 - 4 од.";
                } else if (nLeft > 300 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВВ-150 необхідно додатково обрати: "
                            + "ВВ-9 - 8 од. або ВВ-12 - 6 од.";
                }
            }
        } else if (categoryPremisses().equals("Категорія Г") && classFire().equals("Клас пожежі B") && typeExtinguisher().equals("водяний")) {
            if (square() > 0 && square() <= 50) {
                array[0] = 3;
                array[1] = 3;
                array[2] = 2;
                array[3] = 1;

            } else if (square() > 50 && square() <= 100) {
                array[0] = 5;
                array[1] = 5;
                array[2] = 3;
                array[3] = 2;
                array[4] = 1;

            } else if (square()> 100 && square() <= 300) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 5;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;

            } else if (square() > 300 && square() <= 500) {
                array[0] = 11;
                array[1] = 11;
                array[2] = 7;
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;

            } else if (square() > 500 && square() <= 1000) {
                array[2] = 12;
                array[3] = 7;
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
                array[7] = 1;

            } else if (square() > 1000) {
                if (nLeft == 0) {
                    array[2] = 12 * (int) n;
                    array[3] = 7 * (int) n;
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft <= 50) {
                    array[2] = 12 * (int) n + 2;
                    array[3] = 7 * (int) n + 1;
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 50 && nLeft <= 100) {
                    array[2] = 12 * (int) n + 3;
                    array[3] = 7 * (int) n + 2;
                    array[4] = 4 * (int) n + 1;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 100 && nLeft <= 300) {
                    array[2] = 12 * (int) n + 5;
                    array[3] = 7 * (int) n + 3;
                    array[4] = 4 * (int) n + 2;
                    array[5] = 3 * (int) n + 1;
                    array[6] = 2 * (int) n;
                    array[7] =(int) n;

                } else if (nLeft > 300 && nLeft <= 500) {
                    array[2] = 12 * (int) n + 7;
                    array[3] = 7 * (int) n + 4;
                    array[4] = 4 * (int) n + 3;
                    array[5] = 3 * (int) n + 2;
                    array[6] = 2 * (int) n + 1;
                    array[7] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[2] = 12 * (int) n + 12;
                    array[3] = 7 * (int) n + 7;
                    array[4] = 4 * (int) n + 4;
                    array[5] = 3 * (int) n + 3;
                    array[6] = 2 * (int) n + 2;
                    array[7] =(int) n + 1;
                }
            }
            if (square()== 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n" + "4. ВВ-150 - "
                        + transformation(array[7]) + "\n";
                s = s + "‼️ Для гасіння пожеж класу В слід застосовувати водяні вогнегасники із зарядом води з добавками, що забезпечують гасіння пожеж класу В";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n" + "4. ВВ-150 - "
                        + transformation(array[7]) + "\n";
                s = s + "‼️ Для гасіння пожеж класу В слід застосовувати водяні вогнегасники із зарядом води з добавками, що забезпечують гасіння пожеж класу В";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВВ-5 - 3 од. або ВВ-6 - 3 од. або ВВ-9 - 2 од. або ВВ-12 - 1 од.";
                } else if (nLeft > 50 && nLeft <= 100) {
                    s = s + "❗️ До пересувних вогнегасників ВВ-50/ВВ-100/ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 5 од. або ВВ-6 - 5 од. або ВВ-9 - 3 од. або ВВ-12 - 2 од.";
                } else if (nLeft > 100 && nLeft <= 300) {
                    s = s + "❗️ До пересувноих вогнегасників ВВ-100/ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 8 од. або ВВ-6 - 8 од. або ВВ-9 - 5 од. або ВВ-12 - 3 од.";
                } else if (nLeft > 300 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВВ-150 необхідно додатково обрати: "
                            + "ВВ-5 - 11 од. або ВВ-6 - 11 од. або ВВ-9 - 7 од. або ВВ-12 - 4 од.";
                }
            }
        } else if ((categoryPremisses().equals("Категорія Г") || categoryPremisses().equals("Категорія Д"))
                && classFire().equals("Клас пожежі A") && typeExtinguisher().equals("водяний")) {
            if (square() > 0 && square() <= 50) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 2;
                array[3] = 2;

            } else if (square() > 50 && square() <= 150) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 4;
                array[3] = 3;
                array[4] = 1;

            } else if (square()> 150 && square() <= 500) {
                array[0] = 12;
                array[1] = 12;
                array[2] = 6;
                array[3] = 4;
                array[4] = 2;
                array[5] = 1;

            } else if (square()> 500 && square() <= 1000) {
                array[0] = 16;
                array[1] = 16;
                array[2] = 8;
                array[3] = 6;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;

            } else if (square()> 1000) {
                if (nLeft == 0) {
                    array[0] = 16 * (int) n;
                    array[1] = 16 * (int) n;
                    array[2] = 8 * (int) n;
                    array[3] = 6 * (int) n;
                    array[4] = 3 * (int) n;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft <= 50) {
                    array[0] = 16 * (int) n + 4;
                    array[1] = 16 * (int) n + 4;
                    array[2] = 8 * (int) n + 2;
                    array[3] = 6 * (int) n + 2;
                    array[4] = 3 * (int) n;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[0] = 16 * (int) n + 8;
                    array[1] = 16 * (int) n + 8;
                    array[2] = 8 * (int) n + 4;
                    array[3] = 6 * (int) n + 3;
                    array[4] = 3 * (int) n + 1;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 150 && nLeft <= 500) {
                    array[0] = 16 * (int) n + 12;
                    array[1] = 16 * (int) n + 12;
                    array[2] = 8 * (int) n + 6;
                    array[3] = 6 * (int) n + 4;
                    array[4] = 3 * (int) n + 2;
                    array[5] = 2 * (int) n + 1;
                    array[6] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[0] = 16 * (int) n + 16;
                    array[1] = 16 * (int) n + 16;
                    array[2] = 8 * (int) n + 8;
                    array[3] = 6 * (int) n + 6;
                    array[4] = 3 * (int) n + 3;
                    array[5] = 2 * (int) n + 2;
                    array[6] =(int) n + 1;

                }
            }
            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВ-5 - " + transformation(array[0]) + "\n" + "2. ВВ-6 - " + transformation(array[1]) + "\n"
                        + "3. ВВ-9 - " + transformation(array[2]) + "\n" + "4. ВВ-12 - " + transformation(array[3])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВ-20 - " + transformation(array[4]) + "\n" + "2. ВВ-50 - " + transformation(array[5])
                        + "\n" + "3. ВВ-100 - " + transformation(array[6]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До одного із варіантів пересувних вогнегасників необхідно додатково обрати: "
                            + "ВВ-5 - 4 од. або ВВ-6 - 4 од. або ВВ-9 - 2 од. або ВВ-12 - 2 од.";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До пересувних вогнегасників ВВ-50/ВВ-100 необхідно додатково обрати: "
                            + "ВВ-5 - 8 од. або ВВ-6 - 8 од. або ВВ-9 - 4 од. або ВВ-12 - 3 од.";
                } else if (nLeft > 150 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВВ-100 необхідно додатково обрати: "
                            + "ВВ-5 - 12 од. або ВВ-6 - 12 од. або ВВ-9 - 6 од. або ВВ-12 - 4 од.";
                }
            }
        } else if ((categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б")
                || categoryPremisses().equals("Категорія В з ГГ") || categoryPremisses().equals("Категорія В без ГГ")
                || categoryPremisses().equals("Категорія Г") || categoryPremisses().equals("Категорія Д"))
                && classFire().equals("Клас пожежі F") && typeExtinguisher().equals("водяний")) {
            s = "🧯 Оснащення водяними вогнегасниками, що містять воду з сольовими добавками для гасіння пожеж класу F, слід проводити з дотриманням галузевих норм, погоджених у встановленому порядку";
        }

        return s;
    }

    //int array [] = {ВВК_3.5, ВВК_5, ВВК_7, ВВК_14, ВВК_18, ВВК_28, ВВК_56};
    public String quantityExtinguisherGazovyi() {
        String s = null;
        double n = square() / 1000;
        double nLeft = square() % 1000;
        if ((categoryPremisses().equals("Категорія А") || categoryPremisses().equals("Категорія Б")
                || categoryPremisses().equals("Категорія В з ГГ"))
                && (classFire().equals("Клас пожежі B") || classFire().equals("Клас пожежі E")) && typeExtinguisher().equals("газовий")) {
            if (square() <= 25) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 1;
            } else if (square() > 25 && square() <= 50) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 2;
                array[3] = 1;
            } else if (square() > 50 && square() <= 150) {
                array[0] = 13;
                array[1] = 13;
                array[2] = 3;
                array[3] = 2;
                array[4] = 1;
            } else if (square() > 150 && square() <= 250) {
                array[2] = 4;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;
            } else if (square() > 250 && square() <= 500) {
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square() > 500 && square() <= 1000) {
                array[4] = 4;
                array[5] = 3;
                array[6] = 2;
            } else if (square() > 1000) {

                if (nLeft == 0) {
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;

                } else if (nLeft <= 50) {
                    array[4] = 4 * (int) n;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;

                } else if (nLeft > 50 && nLeft <= 150) {
                    array[4] = 4 * (int) n + 1;
                    array[5] = 3 * (int) n;
                    array[6] = 2 * (int) n;

                } else if (nLeft > 150 && nLeft <= 250) {
                    array[4] = 4 * (int) n + 2;
                    array[5] = 3 * (int) n + 1;
                    array[6] = 2 * (int) n;

                } else if (nLeft > 250 && nLeft <= 500) {
                    array[4] = 4 * (int) n + 3;
                    array[5] = 3 * (int) n + 2;
                    array[6] = 2 * (int) n + 1;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[4] = 4 * (int) n + 4;
                    array[5] = 3 * (int) n + 3;
                    array[6] = 2 * (int) n + 2;
                }
            }

            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВК-3,5 - " + transformation(array[0]) + "\n" + "2. ВВК-5 - " + transformation(array[1])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВК-7 - " + transformation(array[2]) + "\n" + "2. ВВК-14 - " + transformation(array[3])
                        + "\n" + "3. ВВК-18 - " + transformation(array[4]) + "\n" + "4. ВВК-28 - "
                        + transformation(array[5]) + "\n" + "5. ВВК-56 - " + transformation(array[6]) + "\n";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВК-3,5 - " + transformation(array[0]) + "\n" + "2. ВВК-5 - " + transformation(array[1])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВК-7 - " + transformation(array[2]) + "\n" + "2. ВВК-14 - " + transformation(array[3])
                        + "\n" + "3. ВВК-18 - " + transformation(array[4]) + "\n" + "4. ВВК-28 - "
                        + transformation(array[5]) + "\n" + "5. ВВК-56 - " + transformation(array[6]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До пересувних вогнегасників ВВК-18/ВВК-28/ВВК-56 необхідно додатково обрати: "
                            + "ВВК-3,5 - 8 од. або ВВК-5 - 8 од. або ВВК-7 - 2 од. або ВВК-14 - 1 од.";
                } else if (nLeft > 50 && nLeft <= 150) {
                    s = s + "❗️ До пересувних вогнегасників ВВК-28/ВВК-56 необхідно додатково обрати: "
                            + "ВВК-3,5 - 13 од. або ВВК-5 - 13 од. або ВВК-7 - 3 од. або ВВК-14 - 2 од.";
                } else if (nLeft > 150 && nLeft <= 250) {
                    s = s + "❗️ До пересувного вогнегасника ВВК-56 необхідно додатково обрати: "
                            + "ВВК-7 - 4 од. або ВВК-14 - 3 од.";
                }
            }
        } else if (categoryPremisses().equals("Категорія Г") && (classFire().equals("Клас пожежі B") || classFire().equals("Клас пожежі E"))
                && typeExtinguisher().equals("газовий")) {
            if (square() > 0 && square() <= 50) {
                array[0] = 4;
                array[1] = 4;
                array[2] = 1;

            } else if (square() > 50 && square() <= 100) {
                array[0] = 8;
                array[1] = 8;
                array[2] = 2;
                array[3] = 1;

            } else if (square() > 100 && square() <= 300) {
                array[0] = 13;
                array[1] = 13;
                array[2] = 3;
                array[3] = 2;
                array[4] = 1;

            } else if (square() > 300 && square() <= 500) {
                array[2] = 4;
                array[3] = 3;
                array[4] = 2;
                array[5] = 1;

            } else if (square() > 500 && square() <= 1000) {
                array[3] = 4;
                array[4] = 3;
                array[5] = 2;
                array[6] = 1;
            } else if (square() > 1000) {

                if (nLeft == 0) {
                    array[3] = 4 * (int) n;
                    array[4] = 3 * (int) n;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft <= 50) {
                    array[3] = 4 * (int) n;
                    array[4] = 3 * (int) n;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 50 && nLeft <= 100) {
                    array[3] = 4 * (int) n + 1;
                    array[4] = 3 * (int) n;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 100 && nLeft <= 300) {
                    array[3] = 4 * (int) n + 2;
                    array[4] = 3 * (int) n + 1;
                    array[5] = 2 * (int) n;
                    array[6] =(int) n;

                } else if (nLeft > 300 && nLeft <= 500) {
                    array[3] = 4 * (int) n + 3;
                    array[4] = 3 * (int) n + 2;
                    array[5] = 2 * (int) n + 1;
                    array[6] =(int) n;

                } else if (nLeft > 500 && nLeft <= 1000) {
                    array[3] = 4 * (int) n + 4;
                    array[4] = 3 * (int) n + 3;
                    array[5] = 2 * (int) n + 2;
                    array[6] =(int) n + 1;
                }
            }

            if (square() == 0) {
                s = "🚨 Не задано площу приміщення/об'єкту. Зазначне площу та повторіть спробу!";
            } else if (square() <= 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВК-3,5 - " + transformation(array[0]) + "\n" + "2. ВВК-5 - " + transformation(array[1])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВК-7 - " + transformation(array[2]) + "\n" + "2. ВВК-14 - " + transformation(array[3])
                        + "\n" + "3. ВВК-18 - " + transformation(array[4]) + "\n" + "4. ВВК-28 - "
                        + transformation(array[5]) + "\n" + "5. ВВК-56 - " + transformation(array[6]) + "\n";
            } else if (square() > 1000) {
                s = "5. Рекомендована кількість вогнегасників (приймається один з наданих варіантів):\n";
                s = s + "🧯" + " Переносні вогнегасники:\n";
                s = s + "1. ВВК-3,5 - " + transformation(array[0]) + "\n" + "2. ВВК-5 - " + transformation(array[1])
                        + "\n";
                s = s + "🧯" + " Пересувні вогнегасники:\n";
                s = s + "1. ВВК-7 - " + transformation(array[2]) + "\n" + "2. ВВК-14 - " + transformation(array[3])
                        + "\n" + "3. ВВК-18 - " + transformation(array[4]) + "\n" + "4. ВВК-28 - "
                        + transformation(array[5]) + "\n" + "5. ВВК-56 - " + transformation(array[6]) + "\n";
                if (nLeft > 0 && nLeft <= 50) {
                    s = s + "❗️ До пересувних вогнегасників ВВК-14/ВВК-18/ВВК-28/ВВК-56 необхідно додатково обрати: "
                            + "ВВК-3,5 - 4 од. або ВВК-5 - 4 од. або ВВК-7 - 1од.";
                } else if (nLeft > 50 && nLeft <= 100) {
                    s = s + "❗️ До пересувних вогнегасників ВВК-18/ВВК-28/ВВК-56 необхідно додатково обрати: "
                            + "ВВК-3,5 - 8 од. або ВВК-5 - 8 од. або ВВК-7 - 2 од. або ВВК-14 - 1 од.";
                } else if (nLeft > 100 && nLeft <= 300) {
                    s = s + "❗️ До пересувних вогнегасників ВВК-28/ВВК-56 необхідно додатково обрати: "
                            + "ВВК-3,5 - 14 од. або ВВК-5 - 13 од. або ВВК-7 - 3 од. або ВВК-14 - 2 од. або ВВК-18 - 1 од.";
                } else if (nLeft > 300 && nLeft <= 500) {
                    s = s + "❗️ До пересувного вогнегасника ВВК-56 необхідно додатково обрати: " + "ВВК-7 - 4 од.";
                }
            }
        }

        return s;
    }

}

