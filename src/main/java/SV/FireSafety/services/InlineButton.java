package SV.FireSafety.services;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InlineButton {
    //тип та необхідність вогнегасників
    public InlineKeyboardMarkup inlineFireExtinguisherStartKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Розпочати").callbackData("Розпочати").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Інструкція").callbackData("Інструкція").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір типу об'єкта
    public InlineKeyboardMarkup inlineFireExtinguisherTypesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Виробничі/складські").callbackData("Виробничі/складські").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Громадські").callbackData("Громадські").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Житлові").callbackData("Житлові").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Гаражі/автомайстерні").callbackData("Гаражі/автомайстерні").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // вибір категорії приміщення в окремому методі
    public InlineKeyboardMarkup inlineFireExtinguisherCategoryPremissesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія А").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія Б").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія В").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Г").callbackData("Категорія Г").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Д").callbackData("Категорія Д").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // вибір типу громадської будівлі в окремому методі
    public InlineKeyboardMarkup inlineFireExtinguisherTypeSpacesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Адміністративні будівлі").callbackData("Адміністративні будівлі").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Будівлі побутового призначення").callbackData("Будівлі побутового призначення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Підприємства торгівлі").callbackData("Підприємства торгівлі").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Офісні приміщення").callbackData("Офісні приміщення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Архіви, бібліотеки, музеї").callbackData("Архіви, бібліотеки, музеї").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір типу житлової будівлі
    public InlineKeyboardMarkup inlineFireExtinguisherTypesLivingKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Квартири").callbackData("Квартири").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Гуртожитки").callbackData("Гуртожитки").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Будинки індивідуальної забудови").callbackData("Будинки індивідуальної забудови").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //розрахувати побутові приміщення
    public InlineKeyboardMarkup inlineFireExtinguisherCalculateKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Розрахувати").callbackData("Розрахувати").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //розрахувати технічні приміщення
    public InlineKeyboardMarkup inlineFireExtinguisherCalculateTechnicalPremisesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Розрахувати").callbackData("Розрахувати(техн.прим)").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір класу ймовірної пожежі для категорій A, Б, В1, Г
    public InlineKeyboardMarkup inlineFireExtinguisherFireClassForA_Б_В1_ГKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі A").callbackData("Клас ймовірної пожежі A").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі B").callbackData("Клас ймовірної пожежі B").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі C").callbackData("Клас ймовірної пожежі C").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі D").callbackData("Клас ймовірної пожежі D").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі F").callbackData("Клас ймовірної пожежі F").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі E").callbackData("Клас ймовірної пожежі E").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір класу ймовірної пожежі для категорії В
    public InlineKeyboardMarkup inlineFireExtinguisherFireClassForBKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("наявні горючі рідини та гази").callbackData("наявні горючі рідини та гази").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("відсутні горючі рідини та гази").callbackData("відсутні горючі рідини та гази").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір класу ймовірної пожежі для категорій В2, Д
    public InlineKeyboardMarkup inlineFireExtinguisherFireClassForB2_ДKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі A").callbackData("Клас ймовірної пожежі A").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі D").callbackData("Клас ймовірної пожежі D").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі F").callbackData("Клас ймовірної пожежі F").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі E").callbackData("Клас ймовірної пожежі E").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір типу вогнегасника для класу А
    public InlineKeyboardMarkup inlineFireExtinguisherTypeExtinguisherForClassAKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Водопінний").callbackData("Водопінний").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір типу вогнегасника для класу В
    public InlineKeyboardMarkup inlineFireExtinguisherTypeExtinguisherForClassВKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Водопінний").callbackData("Водопінний").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Газовий").callbackData("Газовий").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір типу вогнегасника для класу С, D
    public InlineKeyboardMarkup inlineFireExtinguisherTypeExtinguisherForClassC_DKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір типу вогнегасника для класу E, категорія B2,Д
    public InlineKeyboardMarkup inlineFireExtinguisherTypeExtinguisherForClassE_category_В2_ДKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //вибір типу вогнегасника для класу F
    public InlineKeyboardMarkup inlineFireExtinguisherTypeExtinguisherForClassFKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // встановлюється чи використовується в приміщеннях оргтехніка
    public InlineKeyboardMarkup inlineFireExtinguisherOfficeEquipmentKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так, використовується").callbackData("Так, використовується").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні, не використовується").callbackData("Ні, не використовується").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // чи в побутових приміщеннях є приміщення приготування їжі
    public InlineKeyboardMarkup inlineFireExtinguisherPreparingFoodKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Приміщення для приготування їжі").callbackData("Приміщення для приготування їжі").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Інші побутові приміщення").callbackData("Інші побутові приміщення").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // вибір типу вогнегасника для громадських будівель
    public InlineKeyboardMarkup inlineFireExtinguisherForPublicPremisesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Водопінний").callbackData("Водопінний").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // вибір типу вогнегасника для побутових приміщень приготування їжі
    public InlineKeyboardMarkup inlineFireExtinguisherForKitchenKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний для кухні").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // встановлення чи є технічні приміщення
    public InlineKeyboardMarkup inlineFireExtinguisherTechnicalFacilitiesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так, передбачені").callbackData("Так, передбачені").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні, не передбачені").callbackData("Ні, не передбачені").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // розпочинає роботу бот по визначенню ступеня ризику
    public InlineKeyboardMarkup inlineStartKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Розпочати").callbackData("Розпочати").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // встановлення чи є технічні приміщення
    public InlineKeyboardMarkup inlineDegreeOfRiskTechnicalPremisesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Об’єкт що експлуатується").callbackData("Об’єкт що експлуатується").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Об’єкт на стадії будівництва").callbackData("Об’єкт на стадії будівництва").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // обираємо тип об'єкту для визначення ступеня ризику (спочатку для об'єктів, що експлуатуються)
    public InlineKeyboardMarkup inlineDegreeOfRiskDataEntryKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("2.2").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("2.4").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5").build(),
                InlineKeyboardButton.builder().text("2.6").callbackData("2.6").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // метод збору даних про небезпечні події, які траплялись на об'єкті
    public InlineKeyboardMarkup inlineDegreeOfRiskDangerousEventsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 3.1").callbackData("🔥 3.1").build(),
                InlineKeyboardButton.builder().text("🔥 3.2").callbackData("🔥 3.2").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 3.3").callbackData("🔥 3.3").build(),
                InlineKeyboardButton.builder().text("🔥 3.4").callbackData("🔥 3.4").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 3.5").callbackData("🔥 3.5").build(),
                InlineKeyboardButton.builder().text("🔥 3.6").callbackData("🔥 3.6").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // метод викликає сповіщення щоб ввести площу об'єкта і натиснути кнопку далі
    public InlineKeyboardMarkup inlineDegreeOfRiskObjectAreaKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // метод викликає сповіщення щоб ввести площу об'єкта і натиснути кнопку далі
    public InlineKeyboardMarkup inlineDegreeOfRiskObjectAreaKitchenKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі кухні").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // якщо обрані об'єкти державної власності, що експлуатуються, то цей метод викинає наступне меню з вибором конкретного типу
    public InlineKeyboardMarkup inlineDegreeOfRiskStateOwnedObjectKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.1").callbackData("🏢 3.1").build(),
                InlineKeyboardButton.builder().text("🏢 3.2").callbackData("🏢 3.2").build(),
                InlineKeyboardButton.builder().text("🏢 3.3").callbackData("🏢 3.3").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.4").callbackData("🏢 3.4").build(),
                InlineKeyboardButton.builder().text("🏢 3.5").callbackData("🏢 3.5").build(),
                InlineKeyboardButton.builder().text("🏢 3.6").callbackData("🏢 3.6").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.7").callbackData("🏢 3.7").build(),
                InlineKeyboardButton.builder().text("🏢 3.8").callbackData("🏢 3.8").build(),
                InlineKeyboardButton.builder().text("🏢 3.9").callbackData("🏢 3.9").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.10").callbackData("🏢 3.10").build(),
                InlineKeyboardButton.builder().text("🏢 3.11").callbackData("🏢 3.11").build(),
                InlineKeyboardButton.builder().text("🏢 3.12").callbackData("🏢 3.12").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.13").callbackData("🏢 3.13").build(),
                InlineKeyboardButton.builder().text("🏢 3.14").callbackData("🏢 3.14").build(),
                InlineKeyboardButton.builder().text("🏢 3.15").callbackData("🏢 3.15").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.16").callbackData("🏢 3.16").build(),
                InlineKeyboardButton.builder().text("🏢 3.17").callbackData("🏢 3.17").build(),
                InlineKeyboardButton.builder().text("🏢 3.18").callbackData("🏢 3.18").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("🏢 3.19").callbackData("🏢 3.19").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // якщо обрані об'єкти культурної спадщини, то цей метод викидає наступне меню з вибором рівня спадщини
    public InlineKeyboardMarkup inlineDegreeOfRiskObjectsCulturalHeritageKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🏛 3.1").callbackData("🏛 3.1").build(),
                InlineKeyboardButton.builder().text("🏛 3.2").callbackData("🏛 3.2").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // якщо обрані промислові чи складські об'єкти то цей метод надає можливість обрати: промислові або складські
    public InlineKeyboardMarkup inlineDegreeOfRiskIndustrialWarehouseObjectsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Промисловий об’єкт").callbackData("Промисловий об’єкт").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Складський об’єкт").callbackData("Складський об’єкт").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //масштаб небезпечних подій протягом останніх 5 років на стратегічному об'єкті
    public InlineKeyboardMarkup inlineDegreeOfRiskScaleOfEmergenciesStrategicKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 4.1").callbackData("🔥 4.1").build(),
                InlineKeyboardButton.builder().text("🔥 4.2").callbackData("🔥 4.2").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 4.3").callbackData("🔥 4.3").build(),
                InlineKeyboardButton.builder().text("🔥 4.4").callbackData("🔥 4.4").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 4.5").callbackData("🔥 4.5").build(),
                InlineKeyboardButton.builder().text("🔥 4.6").callbackData("🔥 4.6").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //масштаб небезпечних подій протягом останніх 5 років на промисловому об'єкті
    public InlineKeyboardMarkup inlineDegreeOfRiskScaleOfEmergenciesIndustrialKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 5.1").callbackData("🔥 5.1").build(),
                InlineKeyboardButton.builder().text("🔥 5.2").callbackData("🔥 5.2").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 5.3").callbackData("🔥 5.3").build(),
                InlineKeyboardButton.builder().text("🔥 5.4").callbackData("🔥 5.4").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 5.5").callbackData("🔥 5.5").build(),
                InlineKeyboardButton.builder().text("🔥 5.6").callbackData("🔥 5.6").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //масштаб небезпечних подій протягом останніх 5 років на етапі проектування та будівництва
    public InlineKeyboardMarkup inlineDegreeOfRiskScaleOfEmergenciesDesigningBuildingKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 2.1").callbackData("🔥 2.1").build(),
                InlineKeyboardButton.builder().text("🔥 2.2").callbackData("🔥 2.2").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 2.3").callbackData("🔥 2.3").build(),
                InlineKeyboardButton.builder().text("🔥 2.4").callbackData("🔥 2.4").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 2.5").callbackData("🔥 2.5").build(),
                InlineKeyboardButton.builder().text("🔥 2.6").callbackData("🔥 2.6").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //масштаб небезпечних подій протягом останніх 5 років на етапі проектування
    public InlineKeyboardMarkup inlineDegreeOfRiskConstructionConsequencesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("⚡️ 3.1").callbackData("⚡️ 3.1").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("⚡️ 3.2").callbackData("⚡️ 3.2").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("⚡️ 3.3").callbackData("⚡️ 3.3").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //категорія приміщення за вибухопожежною та пожежною небезпекою
    public InlineKeyboardMarkup inlineDegreeOfRiskCategoryPremisesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія приміщення А").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія приміщення Б").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія приміщення В").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Г").callbackData("Категорія приміщення Г").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Д").callbackData("Категорія приміщення Д").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // розпочинає роботу визначення категорій приміщень за пожежною небезпекою

    //обрання характеристики, що необхідно визначити
    public InlineKeyboardMarkup inlineDeterminationCharacteristicKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія приміщень, будівель чи зовнішніх установок").callbackData("Категорія Прим./Буд/Зовн.Уст").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія приміщення").callbackData("Категорія приміщення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія зовнішньої установки").callbackData("Категорія зовнішньої установки").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія будівлі").callbackData("Категорія будівлі").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //обрання місця розташування технологічної установки
    public InlineKeyboardMarkup inlineDeterminationLocationKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Використовується в приміщенні").callbackData("Використовується в прим.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Використовується на відкритому повітрі").callbackData("Використовується на вулиці").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //необхідність визначення категорії будівлі
    public InlineKeyboardMarkup inlineDeterminationNecessityCategoriesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так, є необхідність").callbackData("Так, є необхідність").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні, необхідність відсутня").callbackData("Ні, необхідність відсутня").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //обрання виду речовини, що обертається у технологічному процесі - категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationTypeOfSubstanceRoomsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Горючі гази").callbackData("Горючі гази").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Легкозаймисті рідини").callbackData("Легкозаймисті рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Вибухові/горючі при контакті з іншими речовинами").callbackData("Вибухові речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Горючі рідини").callbackData("Горючі рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Горючі пили").callbackData("Горючі пили").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Горючі волокна").callbackData("Горючі волокна").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Тверді горючі речовини").callbackData("Тверді горючі речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Тверді важкогорючі речовини").callbackData("Тверді важкогорючі речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Важкогорючі рідини").callbackData("Важкогорючі рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Негорючі речовини").callbackData("Негорючі речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих газів, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleGasesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі гази").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі гази").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Горючі гази").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика легкозаймистих рідин, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicFlammableLiquidsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Легкозаймисті рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Легкозаймисті рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Легкозаймисті рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 Легкозаймисті рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 Легкозаймисті рідини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика речовин і матеріалів, які здатні вибухати і/або горіти при взаємодії з іншими речовинами, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicExplosiveSubstancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Вибухові речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Вибухові речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Вибухові речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих рідин, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleLiquidsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Горючі рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 Горючі рідини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючого пилу, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleSawsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі пили").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі пили").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих волокон, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleFibersKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі волокна").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі волокна").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика тверді горючі речовини, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicSolidCombustibleSubstancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Тверді горючі речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Тверді горючі речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Тверді горючі речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика тверді важкогорючі речовини, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicSolidHighlyFlammableSubstancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Тверді важкогорючі речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Тверді важкогорючі речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика важкогорючі рідини, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicHighlyFlammableLiquidKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Важкогорючі рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Важкогорючі рідини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика негорючих речовин, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicNonCombustibleSubstancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Негорючі речовини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Негорючі речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //обрання виду речовини, що обертається у технологічному процесі,  категорія - зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationTypeOfSubstanceExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Горючі гази").callbackData("Горючі гази З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Легкозаймисті рідини").callbackData("Легкозаймисті рідини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Вибухові/горючі при контакті з іншими речовинами").callbackData("Вибухові речовини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Горючі рідини").callbackData("Горючі рідини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Горючі пили").callbackData("Горючі пили З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Горючі волокна").callbackData("Горючі волокна З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Тверді горючі речовини").callbackData("Тверді горючі речовини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Тверді важкогорючі речовини").callbackData("Тверді важкогорючі речовини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Важкогорючі рідини").callbackData("Важкогорючі рідини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Негорючі речовини").callbackData("Негорючі речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих газів, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleGasesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі гази З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі гази З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Горючі гази З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика легкозаймистих рідин, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicFlammableLiquidsExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Легкозаймисті рідини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Легкозаймисті рідини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Легкозаймисті рідини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика речовин і матеріалів, які здатні вибухати і/або горіти при взаємодії з іншими речовинами, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicExplosiveSubstancesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Вибухові речовини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Вибухові речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих рідин, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleLiquidsExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі рідини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі рідини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Горючі рідини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючого пилу, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleSawsExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі пили З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі пили З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих волокон, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleFibersExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі волокна З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі волокна З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика тверді горючі речовини, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicSolidCombustibleSubstancesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Тверді горючі речовини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Тверді горючі речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика тверді важкогорючі речовини, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicSolidHighlyFlammableSubstancesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Тверді важкогорючі речовини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Тверді важкогорючі речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика важкогорючі рідини, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicHighlyFlammableLiquidExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Важкогорючі рідини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Важкогорючі рідини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика негорючих речовин, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicNonCombustibleSubstancesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Негорючі речовини З").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Негорючі речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // клавіатура "Далі" після надіслання об'єму будівлі
    public InlineKeyboardMarkup inlineDeterminationContinueKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі категорія будівлі").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineDeterminationMostDangerousCategoryKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("А - вибухопожежонебезпечна").callbackData("А - вибухопожежонебезпечна").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Б - вибухопожежонебезпечна").callbackData("Б - вибухопожежонебезпечна").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("В - пожежонебезпечна").callbackData("В - пожежонебезпечна").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Г - помірнопожежонебезпечна").callbackData("Г - помірнопожежонебезпечна").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Д - зниженопожежонебезпечна").callbackData("Д - зниженопожежонебезпечна").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // кнопка для переходу на портал електронних послуг
    public InlineKeyboardMarkup inlineServicePortalKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Посилання").callbackData("Directory").url("https://e-services.dsns.gov.ua").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // кнопки визначення класу зон (перший етап)
    public InlineKeyboardMarkup inlineZoneClassesKeyboardMarkup(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.1").callbackData("1.1_Zone_classes").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.2").callbackData("1.2_Zone_classes").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.3").callbackData("1.3_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // кнопки визначення вибухонебезпечної зони (другий етап)
    public InlineKeyboardMarkup inlineExplosiveEnvironmentKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1_Zone_classes").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2_Zone_classes").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // кнопки визначення вибухонебезпечної зони (етап 2.1)
    public InlineKeyboardMarkup inlineExplosiveEnvironmentTwoKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1.1").callbackData("2.1.1_Zone_classes").build(),
                InlineKeyboardButton.builder().text("2.1.2").callbackData("2.1.2_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // кнопки визначення вибухонебезпечної зони (етап 2.2)
    public InlineKeyboardMarkup inlineExplosiveEnvironmentThreeKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2.1").callbackData("2.2.1_Zone_classes").build(),
                InlineKeyboardButton.builder().text("2.2.2").callbackData("2.2.2_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // кнопки визначення вибухонебезпечної зони (етап 2.3)
    public InlineKeyboardMarkup inlineExplosiveEnvironmentFourKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3.1").callbackData("2.3.1_Zone_classes").build(),
                InlineKeyboardButton.builder().text("2.3.2").callbackData("2.3.2_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // кнопки визначення вибухонебезпечної зони (етап 3)
    public InlineKeyboardMarkup inlineExplosiveEnvironmentFiveKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("3.1_Zone_classes").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("3.2_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineExplosiveEnvironmentSixKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1.1").callbackData("3.1.1_Zone_classes").build(),
                InlineKeyboardButton.builder().text("2.1.2").callbackData("3.1.2_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineExplosiveEnvironmentSevenKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1.1.1").callbackData("3.1.1.1_Zone_classes").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1.1.2").callbackData("3.1.1.2_Zone_classes").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1.1.3").callbackData("3.1.1.3_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineExplosiveEnvironmentEightKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2.1").callbackData("3.2.1_Zone_classes").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2.2").callbackData("3.2.2_Zone_classes").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2.3").callbackData("3.2.3_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineExplosiveEnvironmentNineKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("4.1_Zone_classes").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("4.2_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("4.3_Zone_classes").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("4.4_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineExplosiveEnvironmentTenKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("5.1_Zone_classes").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("5.2_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("5.3_Zone_classes").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("5.4_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    //монтаж пожежної сигналізації

    public InlineKeyboardMarkup inlineTypeOfProtectionFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Будівлі").callbackData("будівлі протипожежний захист").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Приміщення").callbackData("приміщення протипожежний захист").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    //тип об'єкту
    public InlineKeyboardMarkup inlineObjectTypeFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Об’єкт громадського призначення ").callbackData("об’єкт громадського призначення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Об’єкт промислового призначення ").callbackData("об’єкт промислового призначення").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlinePurposePublicObjectFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 громадський об'єкт").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("2.2 громадський об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 громадський об'єкт").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("2.4 громадський об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 громадський об'єкт").build(),
                InlineKeyboardButton.builder().text("2.6").callbackData("2.6 громадський об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.7").callbackData("2.7 громадський об'єкт").build(),
                InlineKeyboardButton.builder().text("2.8").callbackData("2.8 громадський об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.9").callbackData("2.9 громадський об'єкт").build(),
                InlineKeyboardButton.builder().text("2.10").callbackData("2.10 громадський об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.11").callbackData("2.11 громадський об'єкт").build(),
                InlineKeyboardButton.builder().text("2.12").callbackData("2.12 громадський об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.13").callbackData("2.13 громадський об'єкт").build(),
                InlineKeyboardButton.builder().text("2.14").callbackData("2.14 громадський об'єкт").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlinePurposeIndustrialObjectFireAlarmKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 промисловий об'єкт").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("2.2 промисловий об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 промисловий об'єкт").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("2.4 промисловий об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 промисловий об'єкт").build(),
                InlineKeyboardButton.builder().text("2.6").callbackData("2.6 промисловий об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.7").callbackData("2.7 промисловий об'єкт").build(),
                InlineKeyboardButton.builder().text("2.8").callbackData("2.8 промисловий об'єкт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.9").callbackData("2.9 промисловий об'єкт").build(),
                InlineKeyboardButton.builder().text("2.10").callbackData("2.10 промисловий об'єкт").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypeResidentialBuildingFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 житловий фонд").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 житловий фонд").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 житловий фонд").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 житловий фонд").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypeOfficeBuildingFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 офісна будівля").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 офісна будівля").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypeShoppingBuildingFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 торгівельна будівля").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 торгівельна будівля").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypeMallFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.1").callbackData("4.1 торгівельний підземний").build(),
                InlineKeyboardButton.builder().text("4.2").callbackData("4.2 торгівельний надземний").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypeCateringBuildingFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 будівля харчування").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 будівля харчування").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypeExhibitionBuildingFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 виставкова будівля").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 виставкова будівля").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypeScienceBuildingFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 освітня будівля").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 освітня будівля").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 освітня будівля").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 освітня будівля").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypeLibraryFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 бібліотека").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 бібліотека").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypeEducationBuildingFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 навчальні заклади").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 навчальні заклади").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 навчальні заклади").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 навчальні заклади").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineNextFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі сигналізація").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineInstitutesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("так").callbackData("так інститути").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("ні").callbackData("ні інститути").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypeTransportFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 транспорт").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 транспорт").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 транспорт").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 транспорт").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypeRepairTransportFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 обслуговувавння транспорту").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 обслуговувавння транспорту").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 обслуговувавння транспорту").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 обслуговувавння транспорту").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.5").callbackData("3.5 обслуговувавння транспорту").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineCategoryBuildingFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія А виробнича").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія Б виробнича").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія В виробнича").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineStorageFireAlarmKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 склад").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 склад").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 склад").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 склад").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.5").callbackData("3.5 склад").build(),
                InlineKeyboardButton.builder().text("3.6").callbackData("3.6 склад").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.7").callbackData("3.7 склад").build(),
                InlineKeyboardButton.builder().text("3.8").callbackData("3.8 склад").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineStorageTankFireAlarmKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 резервуари").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 резервуари").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 резервуари").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 резервуари").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.5").callbackData("3.5 резервуари").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }


    public InlineKeyboardMarkup inlineAgricultureFireAlarmKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 сг").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 сг").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 сг").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 сг").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.5").callbackData("3.5 сг").build(),
                InlineKeyboardButton.builder().text("3.6").callbackData("3.6 сг").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.7").callbackData("3.7 сг").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineBreadProductsStorageFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Наявні").callbackData("наявні хлібопродукти").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Відсутні").callbackData("відсутні хлібопродукти").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTunnelFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 тунелі").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 тунелі").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlinePipelinesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 трубопроводи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 трубопроводи").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineFlammabilityGroupFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Г1").callbackData("Г1").build(),
                InlineKeyboardButton.builder().text("Г2").callbackData("Г2").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Г3").callbackData("Г3").build(),
                InlineKeyboardButton.builder().text("Г4").callbackData("Г4").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineFireProtectionPremissesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.1").callbackData("1.1 АСПЗ приміщення").build(),
                InlineKeyboardButton.builder().text("1.2").callbackData("1.2 АСПЗ приміщення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.3").callbackData("1.3 АСПЗ приміщення").build(),
                InlineKeyboardButton.builder().text("1.4").callbackData("1.4 АСПЗ приміщення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.5").callbackData("1.5 АСПЗ приміщення").build(),
                InlineKeyboardButton.builder().text("1.6").callbackData("1.6 АСПЗ приміщення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.7").callbackData("1.7 АСПЗ приміщення").build(),
                InlineKeyboardButton.builder().text("1.8").callbackData("1.8 АСПЗ приміщення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.9").callbackData("1.9 АСПЗ приміщення").build(),
                InlineKeyboardButton.builder().text("1.10").callbackData("1.10 АСПЗ приміщення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.11").callbackData("1.11 АСПЗ приміщення").build(),
                InlineKeyboardButton.builder().text("1.12").callbackData("1.12 АСПЗ приміщення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.13").callbackData("1.13 АСПЗ приміщення").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineEnergySupplyFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 енергозабезпечення").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("2.2 енергозабезпечення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 енергозабезпечення").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("2.4 енергозабезпечення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 енергозабезпечення").build(),
                InlineKeyboardButton.builder().text("2.6").callbackData("2.6 енергозабезпечення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.7").callbackData("2.7 енергозабезпечення").build(),
                InlineKeyboardButton.builder().text("2.8").callbackData("2.8 енергозабезпечення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.9").callbackData("2.9 енергозабезпечення").build(),
                InlineKeyboardButton.builder().text("2.10").callbackData("2.10 енергозабезпечення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.11").callbackData("2.11 енергозабезпечення").build(),
                InlineKeyboardButton.builder().text("2.12").callbackData("2.12 енергозабезпечення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.13").callbackData("2.13 енергозабезпечення").build(),
                InlineKeyboardButton.builder().text("2.14").callbackData("2.14 енергозабезпечення").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineCablesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 кабельні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 кабельні").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 кабельні").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineOilFilledEquipmentFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Наявнє").callbackData("наявне обладнання").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Відсутнє").callbackData("відсутнє обладнання").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireLoadFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("менше 180 МДж/м2").callbackData("менше 180 МДж/м2").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("більше 180 МДж/м2").callbackData("більше 180 МДж/м2").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineStationFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 вокзал").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 вокзал").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 вокзал").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineLuggageStationFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Надземний поверх").callbackData("надземний поверх камера схову").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Підземний поверх").callbackData("підземний поверх камера схову").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineAutoLuggageStationFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Надземний поверх").callbackData("надземний поверх автоматична").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Підземний поверх").callbackData("підземний поверх автоматична").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineAgriculturePremissesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 сг").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 сг").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 сг").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 сг").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 сг").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTelecommunicationsFacilitiesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 телекомунікаційні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 телекомунікаційні").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 телекомунікаційні").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }


    public InlineKeyboardMarkup inlinePowerTelecommunicationsFacilitiesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("до 12 кВт").callbackData("до 12 кВт  телекомунікаційні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("більше 12 кВт").callbackData("більше 12 кВт телекомунікаційні").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineMobileCommunicationFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("у діючих будинках зв’язку").callbackData("у діючих будинках зв’язку").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("у будинках іншого призначення").callbackData("у будинках іншого призначення").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("окремо розташованих спорудах").callbackData("окремо розташованих спорудах").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineProductionFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 виробничі").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("2.2 виробничі").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 виробничі").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("2.4 виробничі").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 виробничі").build(),
                InlineKeyboardButton.builder().text("2.6").callbackData("2.6 виробничі").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.7").callbackData("2.7 виробничі").build(),
                InlineKeyboardButton.builder().text("2.8").callbackData("2.8 виробничі").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.9").callbackData("2.9 виробничі").build(),
                InlineKeyboardButton.builder().text("2.10").callbackData("2.10 виробничі").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.11").callbackData("2.11 виробничі").build(),
                InlineKeyboardButton.builder().text("2.12").callbackData("2.12 виробничі").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.13").callbackData("2.13 виробничі").build(),
                InlineKeyboardButton.builder().text("2.14").callbackData("2.14 виробничі").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.15").callbackData("2.15 виробничі").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineCategoryProductionPremissesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія А виробничі приміщення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія Б виробничі приміщення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія В виробничі приміщення").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }


    public InlineKeyboardMarkup inlineLocationProductionFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Підземне").callbackData("підземне розташування").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Надземне").callbackData("надземне розташування").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineCategoryAggregatePremissesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія АБ агрегатні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія АБ агрегатні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія В агрегатні").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlinePremissesAirTransportFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 авіаційний").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 авіаційний").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 авіаційний").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineStoragePremissesFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 складські").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("2.2 складські").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 складські").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("2.4 складські").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 складські").build(),
                InlineKeyboardButton.builder().text("2.6").callbackData("2.6 складські").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.7").callbackData("2.7 складські").build(),
                InlineKeyboardButton.builder().text("2.8").callbackData("2.8 складські").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineBeerProductionFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 пиво").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 пиво").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 пиво").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineAutoTransportFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 автотранспорт").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 автотранспорт").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 автотранспорт").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 автотранспорт").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 автотранспорт").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypeAutoTransportFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 вид транспорту").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 вид транспорту").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineRepairAutoTransportFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 ремонт авто").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 ремонт авто").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 ремонт авто").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineSubwayFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 метрополітен").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 метрополітен").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 метрополітен").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 метрополітен").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 метрополітен").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlinePremissesProductionPurposeFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 виробничого призначення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 виробничого призначення").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 виробничого призначення").build()));inlineKeyboardMarkup.setKeyboard(keyboard);
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }


    //оповіщення та управління евакуацією
    public InlineKeyboardMarkup inlineStartNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("\uD83D\uDCE2 1.1").callbackData("1.1 оповіщення").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("\uD83D\uDCE2 1.2").callbackData("1.2 оповіщення").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlinePublicNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("2.2 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("2.4 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.6").callbackData("2.6 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.7").callbackData("2.7 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.8").callbackData("2.8 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.9").callbackData("2.9 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.10").callbackData("2.11 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.12").callbackData("2.12 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.13").callbackData("2.13 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.14").callbackData("2.14 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.15").callbackData("2.15 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.16").callbackData("2.16 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.17").callbackData("2.17 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.18").callbackData("2.18 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.19").callbackData("2.19 громадські опов.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.20").callbackData("2.20 громадські опов.").build(),
                InlineKeyboardButton.builder().text("2.21").callbackData("2.21 громадські опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineBankNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 банк опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 банк опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineNextNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі оповіщення").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineHouseholdNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 побутові опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 побутові опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCateringNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так").callbackData("Так харчування опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні").callbackData("Ні харчування опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTradeNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так").callbackData("Так торгівля опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні").callbackData("Ні торгівля опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineEducationNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 освіта опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 освіта опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlinePreschoolNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так").callbackData("Так дошкільні опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні").callbackData("Ні дошкільні опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSchoolsNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("4.1 навчальні опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("4.2 навчальні опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.3").callbackData("4.3 навчальні опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineEntertainmentNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Протягом року").callbackData("Протягом року опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Сезонної дії").callbackData("Сезонні опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineSeasonalEntertainmentNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("4.1 сезонні опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("4.2 сезонні опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineLibraryNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так").callbackData("Так бібліотека опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні").callbackData("Ні бібліотека опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineHealthyNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 здоров'я опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 здоров'я опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 здоров'я опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineSanatoriumNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так").callbackData("Так санаторій опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні").callbackData("Ні санаторій опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCampNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 табори опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 табори опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlinePurposeIndustrialNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 промис. опов.").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 промис. опов.").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCategoryIndustrialNotificationSystemKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("категорія А").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("категорія Б").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("категорія В").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Г").callbackData("категорія Г").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    //протипожежне водопостачання
    public InlineKeyboardMarkup inlineFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.1").callbackData("1.1 ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.2").callbackData("1.2 ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.3").callbackData("1.3 ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineNextFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineExternalFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 зовнішнє ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 зовнішнє ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineExternalResidentialFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 зовнішнє житлові ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 зовнішнє громадські ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineExternalStorageFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 зовнішнє складські ПВ").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 зовнішнє складські ПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 зовнішнє складські ПВ").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 зовнішнє складські ПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.5").callbackData("3.5 зовнішнє складські ПВ").build(),
                InlineKeyboardButton.builder().text("3.6").callbackData("3.6 зовнішнє складські ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.7").callbackData("3.7 зовнішнє складські ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineStorageAllCategoriesFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("А склади ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Б склади ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("В склади ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Г").callbackData("Г склади ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Д").callbackData("Д склади ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineStorageCategoriesВГДFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("В склади ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Г").callbackData("Г склади ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Д").callbackData("Д склади ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineStorageCategoriesВДFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("В склади ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Д").callbackData("Д склади ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineInternalFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 внутрішнє ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 внутрішнє ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineInternalPublicAndResidentialFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 внутрішнє ПВ").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 внутрішнє ПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 внутрішнє ПВ").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 внутрішнє ПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.5").callbackData("3.5 внутрішнє ПВ").build(),
                InlineKeyboardButton.builder().text("3.6").callbackData("3.6 внутрішнє ПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.7").callbackData("3.7 внутрішнє ПВ").build(),
                InlineKeyboardButton.builder().text("3.8").callbackData("3.8 внутрішнє ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineInternalCultureFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.1").callbackData("4.1 внутрішнє культурні ПВ").build(),
                InlineKeyboardButton.builder().text("4.2").callbackData("4.2 внутрішнє культурні ПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.3").callbackData("4.3 внутрішнє культурні ПВ").build(),
                InlineKeyboardButton.builder().text("4.4").callbackData("4.4 внутрішнє культурні ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineInternalStorageFireWaterSupplyKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 внутрішнє складські ПВ").build(),
                InlineKeyboardButton.builder().text("3.2").callbackData("3.2 внутрішнє складські ПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 внутрішнє складські ПВ").build(),
                InlineKeyboardButton.builder().text("3.4").callbackData("3.4 внутрішнє складські ПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.5").callbackData("3.5 внутрішнє складські ПВ").build(),
                InlineKeyboardButton.builder().text("3.6").callbackData("3.6 внутрішнє складські ПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.7").callbackData("3.7 внутрішнє складські ПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    //визначення протипожежних відстаней

    public InlineKeyboardMarkup inlineFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.1").callbackData("1.1 ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.2").callbackData("1.2 ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.3").callbackData("1.3 ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireProtectionDistancesBetweenBuildingsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 ВПВ між будівлями").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 ВПВ між будівлями").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 ВПВ між будівлями").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireResistanceFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("І ступінь").callbackData("І ступінь вогнестійкості").build(),
                InlineKeyboardButton.builder().text("ІІ ступінь").callbackData("ІІ ступінь вогнестійкості").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("ІІІ ступінь").callbackData("ІІІ ступінь вогнестійкості").build(),
                InlineKeyboardButton.builder().text("ІІІа ступінь").callbackData("ІІІа ступінь вогнестійкості").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("ІІІб ступінь").callbackData("ІІІб ступінь вогнестійкості").build(),
                InlineKeyboardButton.builder().text("ІV ступінь").callbackData("ІV ступінь вогнестійкості").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("ІVа ступінь").callbackData("ІVа ступінь вогнестійкості").build(),
                InlineKeyboardButton.builder().text("V ступінь").callbackData("V ступінь вогнестійкості").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineWindowsFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Наявні").callbackData("вікна наявні ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Відсутні").callbackData("вікна відсутні ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCategoriesАБВFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія А ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія Б ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія В ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія не наявна").callbackData("Категорія не наявна ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCategoriesАБВГДFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія А ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія Б ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія В ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Г").callbackData("Категорія Г ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія Д").callbackData("Категорія Д ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCategoryВFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так, наявна").callbackData("Категорія В ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні, не наявна").callbackData("Категорія не наявна ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineFireAlarmFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Так, наявні").callbackData("Так сигналізації ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Ні, не наявні").callbackData("Ні сигналізації ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineSpecificLoadFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("до 10 кг на 1 м2 включно").callbackData("навантага до 10 ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("більше 10 кг на 1 м2 включно").callbackData("навантага більше 10 ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineFireProtectionDistancesTechnologicalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 ВПВ технологічні").build(),
                InlineKeyboardButton.builder().text("2.2").callbackData("2.2 ВПВ технологічні").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 ВПВ технологічні").build(),
                InlineKeyboardButton.builder().text("2.4").callbackData("2.4 ВПВ технологічні").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 ВПВ технологічні").build(),
                InlineKeyboardButton.builder().text("2.6").callbackData("2.6 ВПВ технологічні").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.7").callbackData("2.7 ВПВ технологічні").build(),
                InlineKeyboardButton.builder().text("2.8").callbackData("2.8 ВПВ технологічні").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.9").callbackData("2.9 ВПВ технологічні").build()));
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCategoriesStorageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія складу - І").callbackData("категорія складу - І").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія складу - ІІ").callbackData("категорія складу - ІІ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Категорія складу - ІІІ").callbackData("категорія складу - ІІІ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSubcategoriesIStorageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("підкатегорія – Іа").callbackData("підкатегорія – Іа").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("підкатегорія – Іб").callbackData("підкатегорія – Іб").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSubcategoriesIIStorageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("підкатегорія – ІIа").callbackData("підкатегорія – IІа").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("підкатегорія – ІIб").callbackData("підкатегорія – ІIб").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSubcategoriesIIIStorageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("підкатегорія – IІIа").callbackData("підкатегорія – IIІа").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("підкатегорія – ІIIб").callbackData("підкатегорія – ІIIб").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("підкатегорія – ІIIв").callbackData("підкатегорія – ІIIв").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineLiquidsFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("легкозаймисті ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("горючі ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineOilStorageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("5.1 2.2 ВПВ технологічні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("5.2 2.2 ВПВ технологічні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.3").callbackData("5.3 2.2 ВПВ технологічні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.4").callbackData("5.4 2.2 ВПВ технологічні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.5").callbackData("5.5 2.2 ВПВ технологічні").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCarsFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("до 20 одиниць").callbackData("до 20 авто ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("більше 20 одиниць").callbackData("більше 20 авто ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlinePeatFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("лісові масиви").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("ділянки залягання торфу").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineForestFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("хвойні породи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("змішані породи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.3").callbackData("листяні породи").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineFireProtectionDistancesTechnologicalReservoirsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.1").callbackData("5.1 ВПВ резервуари").build(),
                InlineKeyboardButton.builder().text("5.2").callbackData("5.2 ВПВ резервуари").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.3").callbackData("5.3 ВПВ резервуари").build(),
                InlineKeyboardButton.builder().text("5.4").callbackData("5.4 ВПВ резервуари").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.5").callbackData("5.5 ВПВ резервуари").build(),
                InlineKeyboardButton.builder().text("5.6").callbackData("5.6 ВПВ резервуари").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.7").callbackData("5.7 ВПВ резервуари").build(),
                InlineKeyboardButton.builder().text("5.8").callbackData("5.8 ВПВ резервуари").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.9").callbackData("5.9 ВПВ резервуари").build(),
                InlineKeyboardButton.builder().text("5.10").callbackData("5.10 ВПВ резервуари").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineOilFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("6.1").callbackData("легкозаймисті ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("6.2").callbackData("горючі ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineGasStationFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("тип А або Б").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("тип В").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypeGasStationАБFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("мала").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("середня").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.3").callbackData("велика").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypeGasStationВFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("мала").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("середня").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireProtectionDistancesTechnologicalGasStationKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.1").callbackData("1 ВПВ заправки").build(),
                InlineKeyboardButton.builder().text("5.2").callbackData("2 ВПВ заправки").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.3").callbackData("3 ВПВ заправки").build(),
                InlineKeyboardButton.builder().text("5.4").callbackData("4 ВПВ заправки").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.5").callbackData("5 ВПВ заправки").build(),
                InlineKeyboardButton.builder().text("5.6").callbackData("6 ВПВ заправки").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("5.7").callbackData("7 ВПВ заправки").build(),
                InlineKeyboardButton.builder().text("5.8").callbackData("8 ВПВ заправки").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.9").callbackData("9 ВПВ заправки").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireResistanceGasStationFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("6.1").callbackData("І, ІІ, ІІІ ступінь").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("6.2").callbackData("ІІІа, ІІІб, IV, IVa, V ступінь").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineForestGasStationFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("6.1").callbackData("хвойні породи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("6.2").callbackData("змішані породи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("6.3").callbackData("листяні породи").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineModularGasStationFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("категорія І(малої потужності)").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("категорія ІІ(середньої потужності)").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireProtectionDistancesTechnologicalModularGasStationKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.1").callbackData("1 ВПВ заправки").build(),
                InlineKeyboardButton.builder().text("4.2").callbackData("2 ВПВ заправки").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.3").callbackData("3 ВПВ заправки").build(),
                InlineKeyboardButton.builder().text("4.4").callbackData("4 ВПВ заправки").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.5").callbackData("5 ВПВ заправки").build(),
                InlineKeyboardButton.builder().text("4.6").callbackData("6 ВПВ заправки").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.7").callbackData("7 ВПВ заправки").build(),
                InlineKeyboardButton.builder().text("4.8").callbackData("8 ВПВ заправки").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.9").callbackData("9 ВПВ заправки").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineMultiFuelGasStationsFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("скраплений вуглеводневий газ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("стиснений природний газ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineGasHolderFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("поршневий").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("постійного об’єму").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireProtectionDistancesGasHolderKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.1").callbackData("4.1 ВПВ газгольдерів").build(),
                InlineKeyboardButton.builder().text("4.2").callbackData("4.2 ВПВ газгольдерів").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.3").callbackData("4.3 ВПВ газгольдерів").build(),
                InlineKeyboardButton.builder().text("4.4").callbackData("4.4 ВПВ газгольдерів").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.5").callbackData("4.5 ВПВ газгольдерів").build(),
                InlineKeyboardButton.builder().text("4.6").callbackData("4.6 ВПВ газгольдерів").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.7").callbackData("4.7 ВПВ газгольдерів").build(),
                InlineKeyboardButton.builder().text("4.8").callbackData("4.8 ВПВ газгольдерів").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineHardCoalStorageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("до 10000 вугілля").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("від 10000 вугілля").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFlammableLiquidsStorageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("до 500").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("від 500 до 1000").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.3").callbackData("від 1000 до 2000").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineCombustibleLiquidsStorageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("до 2500").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("від 2500 до 5000").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.3").callbackData("від 5000 до 10000").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireResistancePistonGasHolderFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("І/ІІ ступінь").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("ІІ-V ступінь").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineLumberFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("до 10000 ліс").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("від 10000 ліс").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineFireProtectionDistancesBetweenCommunicationsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 ВПВ комунікації").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypeUtilityNetworkFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("5.1 2.1 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("5.2 2.1 ВПВ комунікації").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineLocationPipelineFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 2.2 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 2.2 ВПВ комунікації").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlinePipelineFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.1").callbackData("4.1 трубопроводи ВПВ").build(),
                InlineKeyboardButton.builder().text("4.2").callbackData("4.2 трубопроводи ВПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.3").callbackData("4.3 трубопроводи ВПВ").build(),
                InlineKeyboardButton.builder().text("4.4").callbackData("4.4 трубопроводи ВПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.5").callbackData("4.5 трубопроводи ВПВ").build(),
                InlineKeyboardButton.builder().text("4.6").callbackData("4.6 трубопроводи ВПВ").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("4.7").callbackData("4.7 трубопроводи ВПВ").build(),
                InlineKeyboardButton.builder().text("4.8").callbackData("4.8 трубопроводи ВПВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.9").callbackData("4.9 трубопроводи ВПВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlinePressurePipelineFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("до 2,5 МПа").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("більше 2,5 МПа").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineVoltageFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("до 1 кВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("більше 1 кВ до 35 кВ").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.3").callbackData("більше 35 кВ").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlinePipelineLiquidsFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("легкозаймисті/горючі рідини").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("масла, мазути").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypeBuildingPipelineLiquidsFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("4.1 2.3 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("4.2 2.3 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.3").callbackData("4.3 2.3 ВПВ комунікації").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineDiameterPipelineFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("до 300 мм").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("більше 300 мм").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineGasStationEngineeringNetworksFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 2.4 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 2.4 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.3").callbackData("3.3 2.4 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.4").callbackData("3.4 2.4 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.5").callbackData("3.5 2.4 ВПВ комунікації").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypesGasStationFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("тип АЗС А або Б").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("тип АЗС В").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypesCommunicationLinesFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("кабельні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("повітряні").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypesGasStationEngineeringNetworksFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("мала АЗС").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("середня АЗС").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypesEngineeringNetworksFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("3.1 2.5 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.2 2.5 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("3.3 2.5 ВПВ комунікації").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypesGasPipelineFireProtectionDistancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("4.1 2.5 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("4.2 2.5 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.3").callbackData("4.3 2.5 ВПВ комунікації").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.4").callbackData("4.4 2.5 ВПВ комунікації").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // площа протипожежних відсіків, посадочних місць, поверховість
    public InlineKeyboardMarkup inlineChooseCharacteristicSquareSeatsFloorsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.1").callbackData("1.1 ПМП").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.2").callbackData("1.2 ПМП").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSquareSeatsFloorsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 1.1 ПМП").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 1.1 ПМП").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 1.1 ПМП").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 1.1 ПМП").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 1.1 ПМП").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineSquareSeatsFloorsFloorsFrom1To25Keyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("від 10 до 25 поверхів").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("від 2 до 9 поверхів").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.3").callbackData("1 поверх").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSquareSeatsFloorsFloors1Or2Keyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("2 поверхи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("1 поверх").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSquareSeatsFloorsFloorsFrom1To5Keyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("від 2 до 5 поверхів").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("1 поверх").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSquareSeatsFloorsFireAlarmKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("відсутні").callbackData("відсутні").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("наявні").callbackData("наявні").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineSquareSeatsFloorsFloorsTypeEntertainmentKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.1").callbackData("театр").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.2").callbackData("клубний заклад").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("3.3").callbackData("кінотеатр").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSquareSeatsFloorsFloorsTypesCinemaKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("цілорічної дії").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("літній закритий").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.3").callbackData("літній відкритий").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineTypesIndustrialSquareSeatsFloorsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 1.2 ПМП").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 1.2 ПМП").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineTypesObjectsCategoryАSquareSeatsFloorsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("наявні об’єкти").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("відсутні об’єкти").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSquareSeatsFloorsFrom1To6Keyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.1").callbackData("від 3 до 6 поверхів").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.2").callbackData("2 поверхи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("4.3").callbackData("1 поверх").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineSquareSeatsFloorsFrom1To3Keyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.1").callbackData("3 поверхи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.2").callbackData("2 поверхи").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("5.3").callbackData("1 поверх").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // класи пожеж
    public InlineKeyboardMarkup inlineFireClassesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.1").callbackData("Клас A").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.2").callbackData("Клас B").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.3").callbackData("Клас C").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.4").callbackData("Клас D").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("1.5").callbackData("Клас F").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
}