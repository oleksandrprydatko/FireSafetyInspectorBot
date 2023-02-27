package SV.FireSafety.handlers;

import SV.FireSafety.messagesender.MessageSender;
import SV.FireSafety.model.BotMenu;
import SV.FireSafety.model.Database;
import SV.FireSafety.repository.BotMenuRepository;
import SV.FireSafety.repository.DatabaseRepository;
import SV.FireSafety.services.InlineButton;
import SV.FireSafety.services.InlineButtonFromDB;
import SV.FireSafety.services.InstructionExtinguisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;

import java.util.List;
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
    InstructionExtinguisher instructionExtinguisher = new InstructionExtinguisher();
    InlineButton inlineButton = new InlineButton();


    @Autowired
    BotMenuRepository botMenuRepository;

    @Autowired
    InlineButtonFromDB inlineButtonFromDB;


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
                        List<BotMenu> rootMenus = botMenuRepository.findRootMenus();
                        sendMessage.setReplyMarkup(inlineButtonFromDB.inlineStartKeyboard(rootMenus));
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
                        sendMessage.setText("Я підсистема Degree of subject risk Bot \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити ступніть ризику від провадження господарської діяльності \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    case "/determination_of_categories":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/determination_of_categories",userId);
                        sendMessage.setText("Я підсистема Determination of categories of premisses according to fire hazard \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу з визначенням категорій приміщень,будинків та зовнішніх установок за вибухопожежною та пожежною небезпекою \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //визначення класу зон
                    case "/zone_classes":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/zone_classes",userId);
                        sendMessage.setText("Я підсистема Determination of zone classes \uD83C\uDDFA\uD83C\uDDE6 \nДопоможу визначити клас зони приміщення залежно від параметрів функціонування \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //проектування пожежної сигналізації
                    case "/fire_alarm_installation":
                        //встановлення команди в БД
                        databaseRepository.setComand_of_menu("/fire_alarm_installation",userId);
                        sendMessage.setText("Я підсистема Fire alarm installation \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити необхіднІсть проектування та монтажу автоматичних систем пожежної сигналізації \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
                        messageSender.sendMessage(sendMessage);
                        //очищення бази
                        databaseRepository.clearDB(userId);
                        return;
                    //система оповіщення
                    case "/notification_system":
                        databaseRepository.setComand_of_menu("/notification_system",userId);
                        sendMessage.setText("Я підсистема Notification System \uD83C\uDDFA\uD83C\uDDE6 \n Допоможу визначити тип системи оповіщення, характеристики системи оповіщення та управління евакуюванням людей при пожежі \uD83D\uDD25 \n\n Для початку роботи натисніть <Розпочати>");
                        sendMessage.setReplyMarkup(inlineButton.inlineStartKeyboard());
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
                        sendMessage.setText(instructionExtinguisher.feedback());
                        messageSender.sendMessage(sendMessage);
                        return;
                }
            }
        }
        if (message.hasText()){ //якщо введено текст, перевірка чи це значення
            String messageText = message.getText();
            try{
                if (databaseRepository.getValue(userId).equals("площа")){
                    databaseRepository.setSquare(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("паркування")){
                    databaseRepository.setParking(Integer.parseInt(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("технічні приміщення")){
                    databaseRepository.setSquare_technical_premises(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("робочі місця")){
                    databaseRepository.setWorkplace(Integer.parseInt(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("постійно перебувають на обєкті")){
                    databaseRepository.setConstantly_at_facility(Integer.parseInt(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("періодично перебувають на обєкті")){
                    databaseRepository.setPeriodically_at_facility(Integer.parseInt(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("висота обєкта")){
                    databaseRepository.setHeight_object(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
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
                    databaseRepository.setVolume_premises(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("обєм приміщень А")){
                    databaseRepository.setVolume_rooms_a(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("обєм приміщень Б")){
                    databaseRepository.setVolume_rooms_б(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("обєм приміщень В")){
                    databaseRepository.setVolume_rooms_в(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("обєм приміщень Г")){
                    databaseRepository.setVolume_rooms_г(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("кількість номерів")){
                    databaseRepository.setHotel_rooms(Integer.parseInt(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("поверхи")){
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
                }else if (databaseRepository.getValue(userId).equals("місця")){
                    databaseRepository.setSeats(Integer.parseInt(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("фонд книг")){
                    databaseRepository.setBooks_storage(Integer.parseInt(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("кількість транспорту")){
                    databaseRepository.setAmount_of_transport(Integer.parseInt(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("вага")){
                    databaseRepository.setWeight(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("довжина")){
                    databaseRepository.setLength(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }else if (databaseRepository.getValue(userId).equals("продуктивність")){
                    databaseRepository.setProductivity(Float.parseFloat(messageText),userId);
                    sendMessage.setText("Надіслані дані збережено: " + messageText);
                }
                else{
                    sendMessage.setText("Зазначено не коректні дані: " + messageText + " Спробуйте ще раз!");
                    messageSender.sendMessage(sendMessage);
                }
                messageSender.sendMessage(sendMessage);
            }catch (NumberFormatException exception) {
                sendMessage.setText("Зазначено не коректні дані: " + messageText + " Спробуйте ще раз!");
                messageSender.sendMessage(sendMessage);

            }
        }else {
            sendMessage.setText("Помилка");
            messageSender.sendMessage(sendMessage);
        }
    }
}
//        on_start - На початок
//        type_number_fire_extinguishers - Визначення типу та необхідної кількості вогнегасників
//        degree_of_risk_from_activities - Оцінка ступеня ризику від провадження господарської діяльності
//        determination_of_categories - Визначення категорій приміщень за пожежною небезпекою
//        zone_classes - Визначення класу зони
//        fire_alarm_installation - Визначення необхідності проектування та монтажу автоматичних систем пожежної сигналізації
//        notification_system - Визначення типу системи оповіщення, та управління евакуюванням людей
//        service_portal - Портал електронних послуг ДСНС України
//        feedback_info - Інформація. Зворотній зв'язок