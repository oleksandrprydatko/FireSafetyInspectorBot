package SV.FireSafety.handlers;

import SV.FireSafety.messagesender.MessageSender;
import SV.FireSafety.model.Database;
import SV.FireSafety.repository.DatabaseRepository;
import SV.FireSafety.services.InlineButton;
import SV.FireSafety.services.Instructions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

import java.util.Optional;

@Component
@Slf4j
public class MessageHandler implements Handler<Message> {
    //конструктор класу MessageSender
    private final MessageSender messageSender;
    public MessageHandler(MessageSender messageSender,
                          DatabaseRepository databaseRepository) {
        this.messageSender = messageSender;
        this.databaseRepository = databaseRepository;
    }
    //екземпляри класів

    DatabaseRepository databaseRepository;
    Instructions instructions = new Instructions();
    InlineButton inlineButton = new InlineButton();




    @Override
    public void choose(Message message) {

        long userId = message.getFrom().getId();
        Optional<Database> optionalDatabase = databaseRepository.findByTelegramId(userId);

        //перевірка чи юзер є в базі, додавання в базу
        if (!optionalDatabase.isPresent()){
            databaseRepository.setId_telegram(userId);
        }

        //виведення повідомлення користувача в консоль
        log.info("{}:{}", userId, message.getText());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> comandEntity = message.getEntities().stream()
                    .filter(e -> "bot_command".equals(e.getType())).findFirst();
            if (comandEntity.isPresent()) {
                String command = message.getText().substring(comandEntity.get().getOffset(),
                        comandEntity.get().getLength());
                switch (command) {
                    case "/start":
                        String text = "Вітаю! Я чат-бот Fire Safety Bot \uD83C\uDDFA\uD83C\uDDE6 \n Для початку роботи скористайтеся командами бота👇";
                        sendMessage.setText(text);
                        messageSender.sendMessage(sendMessage);
                        return;
                    case "/on_start":
                        sendMessage.setText("🇺🇦 Для початку роботи повторно скористайтеся командами бота Fire Safety Bot 👇");
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    // розпочинає роботу вогнегасника + виводить інструкцію
                    case "/type_number_fire_extinguishers":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/type_number_fire_extinguishers",userId);
                        sendMessage.setText("Я підсистема Extinguisher Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу вибрати тип та необхідну кількість вогнегасників \uD83E\uDDEF \n\n Для початку роботи натисніть <Розпочати> \n\n \uD83D\uDCDA Для ознайомлення з інструкцією користувача скористайтесь відповідним меню");
                        sendMessage.setReplyMarkup(inlineButton.inlineFireExtinguisherStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    // визначення ступення ризику
                    case "/degree_of_risk_from_activities":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/degree_of_risk_from_activities",userId);
                        sendMessage.setText("Я підсистема Degree of Subject Risk Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити ступніть ризику від провадження господарської діяльності \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    case "/determination_of_categories":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/determination_of_categories",userId);
                        sendMessage.setText("Я підсистема Determination of Categories Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу з визначенням категорій приміщень,будинків та зовнішніх установок за вибухопожежною та пожежною небезпекою \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //класи пожеж
                    case "/fire_classes":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/fire_classes",userId);
                        sendMessage.setText("Я підсистема Fire Classes Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу з визначенням ймовірного класу пожежі \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //визначення класу зон
                    case "/zone_classes":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/zone_classes",userId);
                        sendMessage.setText("Я підсистема Determination of Zone Classes Bot\uD83C\uDDFA\uD83C\uDDE6 \nДопоможу визначити клас зони приміщення залежно від параметрів функціонування \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //проектування пожежної сигналізації
                    case "/fire_alarm_installation":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/fire_alarm_installation",userId);
                        sendMessage.setText("Я підсистема Fire Alarm Installation Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити необхіднІсть проектування та монтажу автоматичних систем пожежної сигналізації та пожежогасіння \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //система оповіщення
                    case "/notification_system":
                        databaseRepository.setComand_of_menu("/notification_system",userId);
                        sendMessage.setText("Я підсистема Notification System Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити тип системи оповіщення, характеристики системи оповіщення та управління евакуюванням людей при пожежі \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //протипожежне водопостачання
                    case "/fire_water_supply":
                        databaseRepository.setComand_of_menu("/fire_water_supply",userId);
                        sendMessage.setText("Я підсистема Fire Water Supply Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити необхідність влаштування та параметри зовнішнього та внутрішнього протипожежного водопостачання \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //протипожежні відстані
                    case "/fire_protection_distances":
                        databaseRepository.setComand_of_menu("/fire_protection_distances",userId);
                        sendMessage.setText("Я підсистема Fire Protection Distances Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити протипожежні відстані між будівлями, технологічними установками, інженерними комунікаціями \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //площа протипожежних відсіків, посадочні місця, поверховість
                    case "/fire_compartment_area":
                        databaseRepository.setComand_of_menu("/fire_compartment_area",userId);
                        sendMessage.setText("Я підсистема Fire Compartment Area Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити допустиму площу протипожежних відсіків, кількості посадочних місць та поверховості об'єктів \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    // системи протипожежного захисту
                    case "/smoke_protection_systems":
                        databaseRepository.setComand_of_menu("/smoke_protection_systems",userId);
                        sendMessage.setText("Я підсистема Smoke Protection Systems Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити необхідність влаштування систем протидимного захисту \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    // посилання на сертифікаційний центр
                    case "/certification_center":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/certification_center",userId);
                        sendMessage.setText("\uD83C\uDDFA\uD83C\uDDE6 Офіційний чат-бот випробувальної лабораторії Державного центру сертифікації ДСНС України: https://t.me/tl_statecenter_bot");
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    // посилання на нормативно-правові акти
                    case "/regulatory_documents":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/certification_center",userId);
                        sendMessage.setText("\uD83C\uDDFA\uD83C\uDDE6 Перелік нормативно-правових документів, що регламентують діяльність підрозділів ДСНС України: https://dsns.gov.ua/uk/zakonodavstvo/departament-derzhavnogo-naglyadu-ta-kontrolyu-docs");
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    // видає посилання на портал електронних послуг
                    case "/service_portal":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/service_portal",userId);
                        sendMessage.setText("🇺🇦 Ви обрали портал електронних послуг ДСНС України. Для переходу скористайтесь посиланням 👇");
                        sendMessage.setReplyMarkup(inlineButton.inlineServicePortalKeyboardMarkup());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    case "/feedback_info":
                        sendMessage.setText(instructions.feedback());
                        messageSender.sendMessage(sendMessage);
                        return;
                }
            }
        }
        if (message.hasText()){ //якщо введено текст, перевірка чи це значення
            String messageText = message.getText();
            if (databaseRepository.getValue(userId)!=null){
                try{
                    if (databaseRepository.getValue(userId).equals("площа")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне площу та повторіть спробу!");
                        }else{
                            databaseRepository.setSquare(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("паркування")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне кількість місць для паркування та повторіть спробу!");
                        }else{
                            databaseRepository.setParking(Integer.parseInt(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("технічні приміщення")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне площу та повторіть спробу!");
                        }else{
                            databaseRepository.setSquare_technical_premises(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("робочі місця")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне кількість робочих місць та повторіть спробу!");
                        }else{
                            databaseRepository.setWorkplace(Integer.parseInt(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("постійно перебувають на обєкті")){
                        databaseRepository.setConstantly_at_facility(Integer.parseInt(messageText),userId);
                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                    }else if (databaseRepository.getValue(userId).equals("періодично перебувають на обєкті")){
                        databaseRepository.setPeriodically_at_facility(Integer.parseInt(messageText),userId);
                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                    }else if (databaseRepository.getValue(userId).equals("висота обєкта")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне висоту об'єкта та повторіть спробу!");
                        }else{
                            databaseRepository.setHeight_object(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("усунено порушень")){
                        databaseRepository.setFixed_violations(Integer.parseInt(messageText),userId);
                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                    }else if (databaseRepository.getValue(userId).equals("не усунено порушень")){
                        databaseRepository.setNo_fixed_violations(Integer.parseInt(messageText),userId);
                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                    }else if (databaseRepository.getValue(userId).equals("загиблі")){
                        databaseRepository.setDead_people(Integer.parseInt(messageText),userId);
                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                    }else if (databaseRepository.getValue(userId).equals("збитки")){
                        databaseRepository.setLosses(Float.parseFloat(messageText),userId);
                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                    }else if (databaseRepository.getValue(userId).equals("дохід")){
                        databaseRepository.setTax_free_income(Float.parseFloat(messageText),userId);
                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                    }else if (databaseRepository.getValue(userId).equals("травмовані")){
                        databaseRepository.setInjured_people(Integer.parseInt(messageText),userId);
                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                    }else if (databaseRepository.getValue(userId).equals("обєм будівлі")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне об'єс будівлі та повторіть спробу!");
                        }else{
                            databaseRepository.setVolume_premises(Float.parseFloat(messageText), userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("обєм приміщень А")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне об'єм приміщень А та повторіть спробу!");
                        }else{
                            databaseRepository.setVolume_rooms_a(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("обєм приміщень Б")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне об'єм приміщень Б та повторіть спробу!");
                        }else{
                            databaseRepository.setVolume_rooms_б(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("обєм приміщень В")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне об'єм приміщень В та повторіть спробу!");
                        }else{
                            databaseRepository.setVolume_rooms_в(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("обєм приміщень Г")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне об'єм приміщень Г та повторіть спробу!");
                        }else{
                            databaseRepository.setVolume_rooms_г(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("кількість номерів")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне кількість номерів та повторіть спробу!");
                        }else{
                            databaseRepository.setHotel_rooms(Integer.parseInt(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("поверхи")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне поверховість та повторіть спробу!");
                        }else {
                            if (databaseRepository.getType_of_object(userId)!= null){
                                if (databaseRepository.getType_of_object(userId).equals("склади гуми")){
                                    if (Integer.parseInt(messageText)>2){
                                        sendMessage.setText("Ви ввели не корректні данні. Склади гуми, каучуку та виробів із них не можуть бути вище 2 поверху\n\n" +
                                                "Введіть кількість поверхів та натисніть \"Далі\" \uD83D\uDC47");
                                        sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                                    }else {
                                        databaseRepository.setFloors(Integer.parseInt(messageText),userId);
                                        sendMessage.setText("Надіслані дані збережено: " + messageText);
                                    }
                                }else {
                                    databaseRepository.setFloors(Integer.parseInt(messageText),userId);
                                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                                }
                            }else {
                                databaseRepository.setFloors(Integer.parseInt(messageText),userId);
                                sendMessage.setText("Надіслані дані збережено: " + messageText);
                            }
                        }
                    }else if (databaseRepository.getValue(userId).equals("вогнеснійкість будівлі")){
                        if (databaseRepository.getType_of_object(userId).equals("виставкова надземна")){
                            if (databaseRepository.getFloors(userId)==1 &&(messageText.equals("1")||messageText.equals("2")||messageText.equals("3")||messageText.equals("3а")||messageText.equals("3б")||messageText.equals("4")||messageText.equals("4а")||messageText.equals("5"))){
                                databaseRepository.setFire_resistance(messageText,userId);
                                sendMessage.setText("Надіслані дані збережено: " + messageText);
                            }else if (databaseRepository.getFloors(userId)==2 &&(messageText.equals("1")||messageText.equals("2")||messageText.equals("3"))){
                                databaseRepository.setFire_resistance(messageText,userId);
                                sendMessage.setText("Надіслані дані збережено: " + messageText);
                            } else {
                                sendMessage.setText("Ступінь вогнестійкості будівлі введено не коректно.\n" +
                                        "Спробуйте ввести (1 / 2 / 3 / 3a / 3б / 4 / 4a / 5) [ I поверх] або " +
                                        "(1 / 2 / 3) [II поверхи] ступені вогнестійкості та натисніть \"Далі\" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            }
                        }else if (databaseRepository.getType_of_object(userId).equals("наземні гаражі")){
                            if (messageText.equals("1")||messageText.equals("2")||messageText.equals("3")||messageText.equals("3а")||messageText.equals("4")){
                                databaseRepository.setFire_resistance(messageText,userId);
                                sendMessage.setText("Надіслані дані збережено: " + messageText);
                            }else {
                                sendMessage.setText("Ступінь вогнестійкості будівлі введено не коректно.\n" +
                                        "Спробуйте ввести (1 / 2 / 3 / 3a / 4) ступені вогнестійкості та натисніть \"Далі\" \uD83D\uDC47");
                                sendMessage.setReplyMarkup(inlineButton.inlineNextFireAlarmKeyboard());
                            }
                        }
                    }else if (databaseRepository.getValue(userId).equals("місця") || databaseRepository.getValue(userId).equals("жителі")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Повторіть спробу!");
                        }else{
                            databaseRepository.setSeats(Integer.parseInt(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("фонд книг")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне фонд книг та повторіть спробу!");
                        }else{
                            databaseRepository.setBooks_storage(Integer.parseInt(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("кількість транспорту")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне кількість транспорту та повторіть спробу!");
                        }else{
                            databaseRepository.setAmount_of_transport(Integer.parseInt(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("вага")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне вагу та повторіть спробу!");
                        }else{
                            databaseRepository.setWeight(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("довжина")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне довжину та повторіть спробу!");
                        }else{
                            databaseRepository.setLength(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }else if (databaseRepository.getValue(userId).equals("продуктивність")){
                        if (messageText.equals("0")){
                            sendMessage.setText("Ви ввели не корректні дані. Зазначне об'єм приміщень Г та повторіть спробу!");
                        }else{
                            databaseRepository.setProductivity(Float.parseFloat(messageText),userId);
                            sendMessage.setText("Надіслані дані збережено: " + messageText);
                        }
                    }
                    else{
                        sendMessage.setText("Зазначено не коректні дані: " + messageText + " Спробуйте ще раз!");
                    }
                    messageSender.sendMessage(sendMessage);
                }catch (NumberFormatException exception) {
                    sendMessage.setText("Зазначено не коректні дані: " + messageText + " Спробуйте ще раз!");
                    messageSender.sendMessage(sendMessage);
                }
            }else {
                sendMessage.setText("Зазначено не коректні дані: " + messageText + " Спробуйте ще раз!");
                messageSender.sendMessage(sendMessage);
            }

        }else {
            sendMessage.setText("Вибачте, я не можу обробити ваше повідомлення \uD83E\uDD37\u200D♂️");
            messageSender.sendMessage(sendMessage);
        }
    }
}
//        on_start - На початок
//        type_number_fire_extinguishers - Тип та необхідна кількость вогнегасників
//        degree_of_risk_from_activities - Ступінь ризику від провадження господарської діяльності
//        determination_of_categories - Категорії приміщень за пожежною небезпекою
//        fire_classes - Ймовірний клас пожежі
//        zone_classes - Клас зони
//        fire_alarm_installation - Проектування та монтаж АСПС та АСПГ
//        notification_system - Тип системи оповіщення, та управління евакуюванням людей
//        fire_water_supply - Влаштування та параметри протипожежного водопостачання
//        fire_protection_distances - Протипожежні відстані
//        fire_compartment_area - Допустима площа протипожежних відсіків, кількості посадочних місць та поверховість об'єктів
//        smoke_protection_systems - Влаштування систем протидимного захисту
//        service_portal - Портал електронних послуг ДСНС України
//        feedback_info - Інформація. Зворотній зв'язок