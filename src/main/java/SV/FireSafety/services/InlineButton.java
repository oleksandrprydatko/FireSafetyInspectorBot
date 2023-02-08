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
    //вибір типу вогнегасника для класу E
    public InlineKeyboardMarkup inlineFireExtinguisherTypeExtinguisherForClassEKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
        keyboard.add(Collections.singletonList(InlineKeyboardButton.builder().text("Газовий").callbackData("Газовий").build()));
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
    public InlineKeyboardMarkup inlineFireExtinguisherTechnicalАcilitiesKeyboard(){
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
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.19").callbackData("🏢 3.19").build()));
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
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("⚡️ 3.1").callbackData("⚡️ 3.1").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("⚡️ 3.2").callbackData("⚡️ 3.2").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("⚡️ 3.3").callbackData("⚡️ 3.3").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //категорія приміщення за вибухопожежною та пожежною небезпекою
    public InlineKeyboardMarkup inlineDegreeOfRiskCategoryPremisesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія приміщення А").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія приміщення Б").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія приміщення В").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія Г").callbackData("Категорія приміщення Г").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія Д").callbackData("Категорія приміщення Д").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // розпочинає роботу визначення категорій приміщень за пожежною небезпекою

    //обрання характеристики, що необхідно визначити
    public InlineKeyboardMarkup inlineDeterminationCharacteristicKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія приміщень, будівель чи зовнішніх установок").callbackData("Категорія Прим./Буд/Зовн.Уст").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія приміщення").callbackData("Категорія приміщення").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія зовнішньої установки").callbackData("Категорія зовнішньої установки").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Категорія будівлі").callbackData("Категорія будівлі").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //обрання місця розташування технологічної установки
    public InlineKeyboardMarkup inlineDeterminationLocationKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Використовується в приміщенні").callbackData("Використовується в прим.").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Використовується на відкритому повітрі").callbackData("Використовується на вулиці").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //необхідність визначення категорії будівлі
    public InlineKeyboardMarkup inlineDeterminationNecessityCategoriesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Так, є необхідність").callbackData("Так, є необхідність").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Ні, необхідність відсутня").callbackData("Ні, необхідність відсутня").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //обрання виду речовини, що обертається у технологічному процесі - категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationTypeOfSubstanceRoomsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Горючі гази").callbackData("Горючі гази").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Легкозаймисті рідини").callbackData("Легкозаймисті рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Вибухові/горючі при контакті з іншими речовинами").callbackData("Вибухові речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Горючі рідини").callbackData("Горючі рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Горючі пили").callbackData("Горючі пили").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Горючі волокна").callbackData("Горючі волокна").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Тверді горючі речовини").callbackData("Тверді горючі речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Тверді важкогорючі речовини").callbackData("Тверді важкогорючі речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Важкогорючі рідини").callbackData("Важкогорючі рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Негорючі речовини").callbackData("Негорючі речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих газів, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleGasesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі гази").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі гази").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Горючі гази").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика легкозаймистих рідин, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicFlammableLiquidsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Легкозаймисті рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Легкозаймисті рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Легкозаймисті рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 Легкозаймисті рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5 Легкозаймисті рідини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика речовин і матеріалів, які здатні вибухати і/або горіти при взаємодії з іншими речовинами, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicExplosiveSubstancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Вибухові речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Вибухові речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Вибухові речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих рідин, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleLiquidsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Горючі рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 Горючі рідини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючого пилу, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleSawsKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі пили").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі пили").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих волокон, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleFibersKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі волокна").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі волокна").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика тверді горючі речовини, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicSolidСombustibleSubstancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Тверді горючі речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Тверді горючі речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика тверді важкогорючі речовини, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicSolidHighlyFlammableSubstancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Тверді важкогорючі речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Тверді важкогорючі речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Тверді важкогорючі речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика важкогорючі рідини, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicHighlyFlammableLiquidKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Важкогорючі рідини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Важкогорючі рідини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика негорючих речовин, категорія приміщення
    public InlineKeyboardMarkup inlineDeterminationCharacteristicNonCombustibleSubstancesKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Негорючі речовини").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Негорючі речовини").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //обрання виду речовини, що обертається у технологічному процесі,  категорія - зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationTypeOfSubstanceExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Горючі гази").callbackData("Горючі гази З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Легкозаймисті рідини").callbackData("Легкозаймисті рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Вибухові/горючі при контакті з іншими речовинами").callbackData("Вибухові речовини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Горючі рідини").callbackData("Горючі рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Горючі пили").callbackData("Горючі пили З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Горючі волокна").callbackData("Горючі волокна З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Тверді горючі речовини").callbackData("Тверді горючі речовини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Тверді важкогорючі речовини").callbackData("Тверді важкогорючі речовини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Важкогорючі рідини").callbackData("Важкогорючі рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Негорючі речовини").callbackData("Негорючі речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих газів, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleGasesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі гази З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі гази З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Горючі гази З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика легкозаймистих рідин, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicFlammableLiquidsExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Легкозаймисті рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Легкозаймисті рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Легкозаймисті рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.4").callbackData("2.4 Легкозаймисті рідини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика речовин і матеріалів, які здатні вибухати і/або горіти при взаємодії з іншими речовинами, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicExplosiveSubstancesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Вибухові речовини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Вибухові речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих рідин, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleLiquidsExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3 Горючі рідини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючого пилу, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleSawsExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі пили З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі пили З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика горючих волокон, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicCombustibleFibersExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Горючі волокна З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Горючі волокна З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика тверді горючі речовини, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicSolidСombustibleSubstancesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Тверді горючі речовини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Тверді горючі речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика тверді важкогорючі речовини, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicSolidHighlyFlammableSubstancesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Тверді важкогорючі речовини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Тверді важкогорючі речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    //характеристика важкогорючі рідини, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicHighlyFlammableLiquidExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Важкогорючі рідини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Важкогорючі рідини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // характеристика негорючих речовин, категорія зовнішньої установки
    public InlineKeyboardMarkup inlineDeterminationCharacteristicNonCombustibleSubstancesExternalKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1 Негорючі речовини З").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2 Негорючі речовини З").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    // клавіатура "Далі" після надіслання об'єму будівлі
    public InlineKeyboardMarkup inlineDeterminationContinueKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі категорія будівлі").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    public InlineKeyboardMarkup inlineDeterminationMostDangerousCategoryKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("А - вибухопожежонебезпечна").callbackData("А - вибухопожежонебезпечна").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Б - вибухопожежонебезпечна").callbackData("Б - вибухопожежонебезпечна").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("В - пожежонебезпечна").callbackData("В - пожежонебезпечна").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Г - помірнопожежонебезпечна").callbackData("Г - помірнопожежонебезпечна").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("Д - зниженопожежонебезпечна").callbackData("Д - зниженопожежонебезпечна").build()));
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
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.1").callbackData("1.1_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.2").callbackData("1.2_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("1.3").callbackData("1.3_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }
    // кнопки визначення вибухонебезпечної зони (другий етап)
    public InlineKeyboardMarkup inlineExplosiveEnvironmentKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2").callbackData("2.2_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3_Zone_classes").build()));
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
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1.1.1").callbackData("3.1.1.1_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1.1.2").callbackData("3.1.1.2_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("3.1.1.3").callbackData("3.1.1.3_Zone_classes").build()));
        inlineKeyboardMarkup.setKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup inlineExplosiveEnvironmentEightKeyboard(){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2.1").callbackData("3.2.1_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2.2").callbackData("3.2.2_Zone_classes").build()));
        keyboard.add(Arrays.asList(InlineKeyboardButton.builder().text("2.2.3").callbackData("3.2.3_Zone_classes").build()));
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




}