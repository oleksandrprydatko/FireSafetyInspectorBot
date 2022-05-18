package LDUBGD.Inspector.service;

import org.glassfish.jersey.internal.inject.ParamConverters.TypeValueOf;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ExtinguisherJavaBot extends TelegramLongPollingBot {

//	private final TypeModeService typeModeService = TypeModeService.getInstance();
//	private final CategoryModeService categoryModeService = CategoryModeService.getInstance();
	SendMessage sendMessage = new SendMessage();
	Message mess;

	static ArrayList<String> data = new ArrayList<String>();

	static String comandOfMenu; // зберігає тип обраної команди в меню
	static String typePremises; // зберігається тип приміщення
	static String categoryPremises; // зберігається категорія приміщення
	static String classFire; // зберігається клас ймовірної пожежі
	static String typeExtinguisher; // зберігається вогнегасник
	static String typeSpacesBuild; // зберігається тип громадського приміщення
	static boolean b1 = false; // враховує чи використовується оргтехніка
	static boolean b2 = false;// враховує чи наявні технічні приміщення
	static String kitchen;// зберігає тип побутового приміщення, чи це кухні чи це інші побутові
							// приміщення
	static String characteristicsObject; // зберіє в себе характеристику об'єкту для визначення ступеня ризику
											// (проєктується/експлуатується)
	static String typeObjectOfRisk; // зберігає тип об'єкту для визначення ступеня ризику (ОПН, держ.власності тощо)
	static String typeStateOwnedObject; // зберігає об'єкти державної власності
	static String typeCulturalObject; // зберігає тип об'єкта культурної спадщини
	static String typeIndustrialStorageFacility; // зберігає промисловий чи складський об'єкт для визначення ступеня
													// ризику
	static String levelEmergency; // зберігає рівень надзвичайних ситуацій, що траплялись на об'єкті
	static String typeResultDegreeRisk; // зберігає значення класу наслідків під час будівництва об'єкту (крайнє
										// значення)

	@Override
	public void onUpdateReceived(Update update) {

		if (update.hasCallbackQuery()) {
			handleCalldack(update.getCallbackQuery());
		} else if (update.hasMessage()) {
			handleMessage(update.getMessage());
		}
	}

	@SneakyThrows
	private void handleCalldack(CallbackQuery callbackQuery) {
		Message message = callbackQuery.getMessage(); // отримуємо інформацію що це було за повідомлення після
														// натискання кнопки
		mess = message; // передаю посилання в глобальну змінну

		String s2 = null;
		String s3 = null;
		String s4 = null;
		String s5 = null;
		String s7 = null;
		String s8 = null;
		String s9 = null;
		String s10 = null;

		String param = callbackQuery.getData();
		switch (param) {
		case "Розпочати":
			if (comandOfMenu == "type_number_fire_extinguishers") {
				startExtinguishers(message);
			} else if (comandOfMenu == "degree_of_risk_from_activities") {
				startDegreeOfRisk(message);
			}
			break;

		/*
		 * Перераховано кейси, що відповідають за роботу бота - визнчення ступеня ризику
		 */
		case "Об’єкт що експлуатується":
			s2 = "Обрано: об'єкт експлуатується";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s2).build());
				characteristicsObject = "експлуатується";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			dataEntryDegreeOfRisk(message);
			break;
		case "Об’єкт на стадії будівництва":
			s2 = "Обрано: об'єкт на стадії будівництва";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s2).build());
				characteristicsObject = "проєктується";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			dangerousEvents(message);
			break;
		case "2.1":
			s3 = "Обрано: Об’єкт підвищеної небезпеки";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				typeObjectOfRisk = "об'єкт підвищеної небезпеки";
				objectArea(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "2.2":
			s3 = "Обрано: Об’єкт державної власності, що має стратегічне значення для економіки і безпеки держави";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				typeObjectOfRisk = "об'єкт стратегічного значення";
				stateOwnedObject(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "2.3":
			s3 = "Обрано: Об’єкт метрополітену";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				objectArea(message);
				typeObjectOfRisk = "об’єкт метрополітену";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "2.4":
			s3 = "Обрано: Об’єкт, включений до Державного реєстру нерухомих пам’яток";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				typeObjectOfRisk = "нерухома пам'ятка";
				objectsCulturalHeritage(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "2.5":
			s3 = "Обрано: Промисловий або складський об’єкт";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				typeObjectOfRisk = "промисловий або складський об’єкт";
				industrialWarehouseObjects(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "2.6":
			s3 = "Обрано: Інші об’єкти";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				objectArea(message);
				typeObjectOfRisk = "інші об’єкти";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.1":
			s4 = "Обрано: Об’єкт сфери оборони";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт оборони";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.2":
			s4 = "Обрано: Об’єкт паливно-енергетичного комплексу";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт енергетичного комплексу";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.3":
			s4 = "Обрано: Об’єкт транспортної галузі";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт транспорту";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.4":
			s4 = "Обрано: Об’єкт підприємств, що забезпечують розміщення і зберігання матеріальних цінностей державного резерву";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт держрезерву";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.5":
			s4 = "Обрано: Об’єкт агропромислового комплексу";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт аграрного комплексу";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.6":
			s4 = "Обрано: Об’єкт сфери електронних комунікацій та зв’язку";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт зв'язку";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.7":
			s4 = "Обрано: Об’єкт авіаційної та ракетно-космічної промисловості";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт авіації";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.8":
			s4 = "Обрано: Об’єкт машинобудівної промисловості";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт машинобувної промисловості";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.9":
			s4 = "Обрано: Об’єкт металургійного комплексу";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт металургії";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.10":
			s4 = "Обрано: Об’єкт хімічного комплексу";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт хімпрому";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.11":
			s4 = "Обрано: Об’єкт наукової діяльності";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт науки";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.12":
			s4 = "Обрано: Об’єкт сфери стандартизації, метрології та сертифікації";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт метрології";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.13":
			s4 = "Обрано: Об’єкт гідрометеорологічної діяльності";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт гідрометеорології";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.14":
			s4 = "Обрано: Об’єкт промисловості будівельних матеріалів";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт будматеріалів";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.15":
			s4 = "Обрано: Об’єкт фінансово-бюджетної сфери";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт фінансово-бюджетний";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.16":
			s4 = "Обрано: Об’єкт харчової промисловості";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт харчовий";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.17":
			s4 = "Обрано: Об’єкт легкої промисловості";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт легкої промисловості";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.18":
			s4 = "Обрано: Об’єкт поліграфії";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт поліграфії";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏢 3.19":
			s4 = "Обрано: Об’єкт геологорозвідувальної галузі";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeStateOwnedObject = "об’єкт геологорозвідувальний";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏛 3.1":
			s4 = "Обрано: Пам’ятка культурної спадщини національного значення";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeCulturalObject = "пам'ятка національного значення";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🏛 3.2":
			s4 = "Обрано: Пам’ятка культурної спадщини місцевого значення";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				objectArea(message);
				typeCulturalObject = "пам'ятка місцевого значення";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Промисловий об’єкт":
			s4 = "Обрано: Промисловий об’єкт";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				categoryPremisesDegreeOfRisk(message);
				typeIndustrialStorageFacility = "промисловий об'єкт";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Складський об’єкт":
			s4 = "Обрано: Складський об’єкт";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				categoryPremisesDegreeOfRisk(message);
				typeIndustrialStorageFacility = "складський об’єкт";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Категорія  А":
			s3 = "Обрано: приміщення категорії А";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				categoryPremises = "Категорія А";
				objectArea(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Категорія  Б":
			s3 = "Обрано: приміщення категорії Б";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				categoryPremises = "Категорія Б";
				objectArea(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Категорія  В":
			s3 = "Обрано: приміщення категорії В";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				categoryPremises = "Категорія В";
				objectArea(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Категорія  Г":
			s3 = "Обрано: приміщення категорії Г";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				categoryPremises = "Категорія Г";
				objectArea(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Категорія  Д":
			s3 = "Обрано: приміщення категорії Д";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				categoryPremises = "Категорія Д";
				objectArea(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Далі":
			reactionButtonDali(message);
			break;
		case "🔥 5.1":
		case "🔥 4.1":
		case "🔥 3.1":
		case "🔥 2.1":
			s3 = "Обрано: надзвичайна ситуація державного рівня";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				levelEmergency = "НС державного рівня";
				reactionButtonDali(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🔥 5.2":
		case "🔥 4.2":
		case "🔥 3.2":
		case "🔥 2.2":
			s3 = "Обрано: надзвичайна ситуація регіонального рівня";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				levelEmergency = "НС регіонального рівня";
				reactionButtonDali(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🔥 5.3":
		case "🔥 4.3":
		case "🔥 3.3":
		case "🔥 2.3":
			s3 = "Обрано: надзвичайна ситуація місцевого рівня";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				levelEmergency = "НС місцевого рівня";
				reactionButtonDali(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;

		case "🔥 5.4":
		case "🔥 4.4":
		case "🔥 3.4":
		case "🔥 2.4":
			s3 = "Обрано: надзвичайна ситуація об’єктового рівня";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				levelEmergency = "НС об’єктового рівня";
				reactionButtonDali(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🔥 5.5":
		case "🔥 4.5":
		case "🔥 3.5":
		case "🔥 2.5":
			s3 = "Обрано: небезпечна подія, що не класифікується як надзвичайна ситуація";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				levelEmergency = "не класифікована НС";
				reactionButtonDali(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "🔥 5.6":
		case "🔥 4.6":
		case "🔥 3.6":
		case "🔥 2.6":
			s3 = "Обрано: надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				levelEmergency = "без НС";
				reactionButtonDali(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "⚡️ 3.1":
			s4 = "Обрано: Об’єкт із значними наслідками (СС3)";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				typeResultDegreeRisk = "об’єкт із значними наслідками";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			resultDegreeRisk(message);
			break;
		case "⚡️ 3.2":
			s4 = "Обрано: Об’єкт із середніми наслідками (СС2)";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				typeResultDegreeRisk = "об’єкт із середніми наслідками";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			resultDegreeRisk(message);
			break;
		case "⚡️ 3.3":
			s4 = "Обрано: Об’єкт із незначними наслідками (СС1)";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				typeResultDegreeRisk = "об’єкт із незначними наслідками";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			resultDegreeRisk(message);
			break;

		/*
		 * Перераховано кейси, що відповідають за роботу бота - вогнегасник
		 */
		case "Виробничі / складські":
			s2 = "Обрано: Виробничі (складські) приміщення";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s2).build());
				categoryPremises(message);
				typePremises = "Виробничі_складські";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Громадські":
			s2 = "Обрано: Громадські приміщення (у т.ч. об'єкти адміністративного, побутового та торгівельного призначення)\n";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s2).build());
				typeSpaces(message);
				typePremises = "Громадські";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Житлові":
			s2 = "Обрано: Житлові приміщення";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s2).build());
				typePremises = "Житлові";
				typesLiving(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Гаражі / автомайстерні":
			s2 = "Обрано: Приміщення автогаріжів, автостоянок та/або автомайстерень";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s2).build());
				typePremises = "Гаражі";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			List<List<InlineKeyboardButton>> buttButt = new ArrayList<>();
			buttButt.add(Arrays
					.asList(InlineKeyboardButton.builder().text("Розрахувати").callbackData("Розрахувати").build()));
			try {
				execute(SendMessage.builder().text(
						"2. Надішліть кількість місць стоянки автомобілів у боксі (гаражі, стоянці) після чого натисніть <Розрахувати>")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttButt).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;

		case "Категорія А":
			s3 = "Обрано: приміщення категорії А";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				fireСlassForА_Б_В1_Г(message);
				categoryPremises = "Категорія А";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Категорія Б":
			s3 = "Обрано: приміщення категорії Б";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());

				fireСlassForА_Б_В1_Г(message);

				categoryPremises = "Категорія Б";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Категорія В":
			categoryPremisesВ(message);
			break;
		case "наявні горючі рідини та гази":
			s3 = "Обрано: приміщення категорії В з наявністю горючих рідин та газів";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());

				fireСlassForА_Б_В1_Г(message);

				categoryPremises = "Категорія В з ГГ";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "відсутні горючі рідини та гази":
			s3 = "Обрано: приміщення категорії В за відсутності горючих рідин та газів";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());

				fireСlassForВ2_Д(message);

				categoryPremises = "Категорія В без ГГ";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;

		case "Категорія Г":
			s3 = "Обрано: приміщення категорії Г";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());

				fireСlassForА_Б_В1_Г(message);

				categoryPremises = "Категорія Г";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Категорія Д":
			s3 = "Обрано: приміщення категорії Д";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());

				fireСlassForВ2_Д(message);

				categoryPremises = "Категорія Д";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Клас ймовірної пожежі A":
			s4 = "Обрано: клас ймовірної пожежі A";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				typeExtinguisherForClassA(message);
				classFire = "Клас пожежі A";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Клас ймовірної пожежі B":
			s4 = "Обрано: клас ймовірної пожежі B";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				typeExtinguisherForClassB(message);
				classFire = "Клас пожежі B";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Клас ймовірної пожежі C":
			s4 = "Обрано: клас ймовірної пожежі C";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				typeExtinguisherForClassC(message);
				classFire = "Клас пожежі C";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Клас ймовірної пожежі D":
			s4 = "Обрано: клас ймовірної пожежі D";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				typeExtinguisherForClassD(message);
				classFire = "Клас пожежі D";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Клас ймовірної пожежі F":
			s4 = "Обрано: клас ймовірної пожежі F";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				typeExtinguisherForClassF(message);
				classFire = "Клас пожежі F";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Клас ймовірної пожежі E":
			s4 = "Обрано: клас ймовірної пожежі E";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
				if (categoryPremises == "Категорія В без ГГ" || categoryPremises == "Категорія Д") {
					typeExtinguisherForClassE_category_В2_Д(message);
				} else {
					typeExtinguisherForClassE(message);
				}
				classFire = "Клас пожежі E";
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Порошковий":
			s5 = "Обрано: порошковий вогнегасник";
			typeExtinguisher = "порошковий";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s5).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			result(message);
			break;
		case "Водопінний":
			s5 = "Обрано: водопінний вогнегасник";
			typeExtinguisher = "водопінний";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s5).build());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			result(message);
			break;
		case "Водяний":
			s5 = "Обрано: водяний вогнегасник";
			typeExtinguisher = "водяний";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s5).build());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			result(message);
			break;
		case "Газовий":
			s5 = "Обрано: газовий вогнегасник";
			typeExtinguisher = "газовий";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s5).build());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			result(message);
			break;
		case "Адміністративні будівлі":
			s7 = "Обрано: адміністративні будівлі/приміщення";
			typeSpacesBuild = "адміністративні";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s7).build());
				officeEquipment(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Будівлі побутового призначення":
			s7 = "Обрано: приміщення побутового призначення";
			typeSpacesBuild = "побутові";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s7).build());
				pobutoviBudivli(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Підприємства торгівлі":
			s7 = "Обрано: тогрівельні приміщення";
			typeSpacesBuild = "торгівельні";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s7).build());
				officeEquipment(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Офісні приміщення":
			s7 = "Обрано: офісні приміщення";
			typeSpacesBuild = "офісні";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s7).build());
				officeEquipment(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;

		case "Архіви, бібліотеки, музеї":
			s7 = "Обрано: архіви, бібліотеки, музеї";
			typeSpacesBuild = "архіви";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s7).build());
				officeEquipment(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

			break;

		case "Так, використовується":
			s8 = "Обрано: в приміщеннях використовується оргтехніка";
			b1 = true;
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s8).build());
				typeExtinguisherForPublicPremises(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

			break;
		case "Ні, не використовується":
			s8 = "Обрано: в приміщеннях не використовується оргтехніка";
			b1 = false;
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s8).build());
				typeExtinguisherForPublicPremises(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Приміщення для приготування їжі":
			s8 = "Обрано: приміщення для приготуван їжі";
			kitchen = "кухні";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s8).build());
				robMaisciaKukhnia(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Інші побутові приміщення":
			s8 = "Обрано: в приміщеннях відсутні технологічні процеси приготування їжі";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s8).build());
				typeExtinguisherForPublicPremises(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Так, передбачені":
			s9 = "Обрано: наявні технічні приміщення (у т.ч. комори, електрощитові тощо)\n";
			b2 = true;
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s9).build());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			List<List<InlineKeyboardButton>> butt = new ArrayList<>();
			butt.add(Arrays
					.asList(InlineKeyboardButton.builder().text("Розрахувати").callbackData("Розрахувати").build()));
			if (kitchen == "кухні") {
				try {
					execute(SendMessage.builder().text(
							"8. Надішліть загальну площу технічних приміщень (м.кв.) після чого натисніть <Розрахувати>")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(butt).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			} else {
				try {
					execute(SendMessage.builder().text(
							"7. Надішліть загальну площу технічних приміщень (м.кв.) після чого натисніть <Розрахувати>")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(butt).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			break;
		case "Ні, не передбачені":
			s9 = "Технічні приміщення відсутні. Додаткового остащення вогнегасниками не потребується";
			b2 = false;
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s9).build());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Квартири":
			s10 = "Обрано: квартири багатоквартирних житлових будинків";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s10).build());
				result(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Гуртожитки":
			s10 = "Обрано: кімната/секція/блок гуртожитку";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s10).build());
				result(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		case "Будинки індивідуальної забудови":
			s10 = "Обрано: житлові будинки індивідуальної забудови";
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s10).build());
				result(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;

		case "Розрахувати":

			if (typePremises == "Гаражі") {
				result(message);
			} else {
				technicalАcilitiesResult(message);
			}

			break;
		case "Інструкція":
			String sTemp;
			InstructionExtinguisher ie = new InstructionExtinguisher();
			sTemp = ie.instruction();
			try {
				execute(SendMessage.builder().chatId(message.getChatId().toString()).text(sTemp).build());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	void handleMessage(Message message) {
		if (message.hasText() && message.hasEntities()) {
			Optional<MessageEntity> comandEntity = message.getEntities().stream()
					.filter(e -> "bot_command".equals(e.getType())).findFirst();
			if (comandEntity.isPresent()) {
				String command = message.getText().substring(comandEntity.get().getOffset(),
						comandEntity.get().getLength());
				switch (command) {
				case "/start":
					String s = "Вітаю! Я чат-бот Fire Safety Bot" + " 🇺🇦\n";
					s = s + "Для початку роботи скористайтеся командами бота" + "👇";
					try {
						execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s).build());
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					return;
				case "/type_number_fire_extinguishers": // розпочинає роботу вогнегасника + виводить інструкцію
					comandOfMenu = "type_number_fire_extinguishers";
					data.clear();
					typePremises = null;
					categoryPremises = null;
					classFire = null;
					typeExtinguisher = null;
					typeSpacesBuild = null;
					b1 = false;
					b2 = false;
					characteristicsObject = null;
					typeObjectOfRisk = null;
					typeStateOwnedObject = null;
					typeCulturalObject = null;
					typeIndustrialStorageFacility = null;
					levelEmergency = null;
					typeResultDegreeRisk = null;
					// перевірити чи всі змінні обнуляються
					String s_ext = "Я підсистема Extinguisher Bot" + " 🇺🇦\n";
					s_ext = s_ext + "Допоможу вибрати тип та необхідну кількість вогнегасників 🧯 \n\n";
					s_ext = s_ext + "Для початку роботи натисніть <Розпочати> \n\n";
					s_ext = s_ext + "📚 Для ознайомлення з інструкцією користувача скористайтесь відповідним меню";

					List<List<InlineKeyboardButton>> instruction = new ArrayList<>();
					instruction.add(Arrays.asList(
							InlineKeyboardButton.builder().text("Розпочати").callbackData("Розпочати").build()));
					instruction.add(Arrays.asList(
							InlineKeyboardButton.builder().text("Інструкція").callbackData("Інструкція").build()));
					try {
						execute(SendMessage.builder().text(s_ext).chatId(message.getChatId().toString())
								.replyMarkup(InlineKeyboardMarkup.builder().keyboard(instruction).build()).build());

					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					return;

				case "/degree_of_risk_from_activities":
					comandOfMenu = "degree_of_risk_from_activities";
					data.clear();
					typePremises = null;
					categoryPremises = null;
					classFire = null;
					typeExtinguisher = null;
					typeSpacesBuild = null;
					b1 = false;
					b2 = false;
					characteristicsObject = null;
					typeObjectOfRisk = null;
					typeStateOwnedObject = null;
					typeCulturalObject = null;
					typeIndustrialStorageFacility = null;
					levelEmergency = null;
					typeResultDegreeRisk = null;
					// перевірити чи всі змінні обнуляються
					String s_risk = "Я підсистема Degree of subject risk Bot" + " 🇺🇦\n";
					s_risk = s_risk
							+ "Допоможу визначити ступніть ризику від провадження господарської діяльності 🔥 \n\n";
					s_risk = s_risk + "Для початку роботи натисніть <Розпочати> \n\n";
					s_risk = s_risk + "📚 Для ознайомлення з інструкцією користувача скористайтесь відповідним меню";

					List<List<InlineKeyboardButton>> ButtonInstruction = new ArrayList<>();
					ButtonInstruction.add(Arrays.asList(
							InlineKeyboardButton.builder().text("Розпочати").callbackData("Розпочати").build()));
//					ButtonInstruction.add(Arrays.asList(
//							InlineKeyboardButton.builder().text("Інструкція").callbackData("Інструкція").build()));
					try {
						execute(SendMessage.builder().text(s_risk).chatId(message.getChatId().toString())
								.replyMarkup(InlineKeyboardMarkup.builder().keyboard(ButtonInstruction).build())
								.build());

					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					return;
				case "/on_start":
					String s4 = "🇺🇦 Для початку роботи повторно скористайтеся командами бота Fire Safety Bot 👇";
					comandOfMenu = null;
					data.clear();
					typePremises = null;
					categoryPremises = null;
					classFire = null;
					typeExtinguisher = null;
					typeSpacesBuild = null;
					b1 = false;
					b2 = false;
					characteristicsObject = null;
					typeObjectOfRisk = null;
					typeStateOwnedObject = null;
					typeCulturalObject = null;
					typeIndustrialStorageFacility = null;
					levelEmergency = null;
					typeResultDegreeRisk = null;
					// перевірити чи всі змінні обнуляються
					try {
						execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s4).build());
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					return;
				case "/feedback_info":
					InstructionExtinguisher ie = new InstructionExtinguisher();
					String s11 = ie.feedback();
					try {
						execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s11).build());
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					return;
				}
			}
		}

		if (message.hasText()) { // якщо введено текст, перевірка чи це значення
			String messageText = message.getText();
			String s3 = "Надіслані дані збережено: " + messageText + "\n";

			Scanner sc = new Scanner(message.getText());

			if (sc.hasNextDouble()) {
				try {
					execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s3).build());
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
				stringToDouble(messageText);
			} else {
				try {
					execute(SendMessage.builder().chatId(message.getChatId().toString())
							.text("Зазначено не коректні дані: " + messageText + " Спробуйте ще раз!").build());
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void startExtinguishers(Message message) {

		List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("Виробничі / складські")
				.callbackData("Виробничі / складські").build()));
		buttons.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Громадські").callbackData("Громадські").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("Житлові").callbackData("Житлові").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("Гаражі / автомайстерні")
				.callbackData("Гаражі / автомайстерні").build()));

		try {
			execute(SendMessage.builder().text("1. Оберіть тип приміщення/об'єкту")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void categoryPremises(Message message) { // вибір категорії приміщення в окремому методі

		List<List<InlineKeyboardButton>> buttonsTwo = new ArrayList<>();
		buttonsTwo.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Категорія А").callbackData("Категорія А").build()));
		buttonsTwo.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Категорія Б").callbackData("Категорія Б").build()));
		buttonsTwo.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Категорія В").callbackData("Категорія В").build()));
		buttonsTwo.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Категорія Г").callbackData("Категорія Г").build()));
		buttonsTwo.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Категорія Д").callbackData("Категорія Д").build()));

		try {
			execute(SendMessage.builder().text(
					"2. Надішліть площу приміщення/поверху (м.кв.) та оберіть категорію приміщення за вибухопожежною та пожежною небезпекою (порядковість не має значення)")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsTwo).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void categoryPremisesВ(Message message) {
		List<List<InlineKeyboardButton>> buttonsThree = new ArrayList<>();

		buttonsThree.add(Arrays.asList(InlineKeyboardButton.builder().text("наявні горючі рідини та гази")
				.callbackData("наявні горючі рідини та гази").build()));
		buttonsThree.add(Arrays.asList(InlineKeyboardButton.builder().text("відсутні горючі рідини та гази")
				.callbackData("відсутні горючі рідини та гази").build()));
		try {
			execute(SendMessage.builder().text(
					"2.1. Зазначте чи наявні в приміщенні виробництва (складському примішенні) горючі рідини та гази")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsThree).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void fireСlassForА_Б_В1_Г(Message message) {
		List<List<InlineKeyboardButton>> buttonsFour = new ArrayList<>();
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі A")
				.callbackData("Клас ймовірної пожежі A").build()));
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі B")
				.callbackData("Клас ймовірної пожежі B").build()));
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі C")
				.callbackData("Клас ймовірної пожежі C").build()));
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі D")
				.callbackData("Клас ймовірної пожежі D").build()));
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі F")
				.callbackData("Клас ймовірної пожежі F").build()));
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі E")
				.callbackData("Клас ймовірної пожежі E").build()));
		try {
			execute(SendMessage.builder().text("3. Оберіть клас можливої пожежі").chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsFour).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void fireСlassForВ2_Д(Message message) {
		List<List<InlineKeyboardButton>> buttonsFour = new ArrayList<>();
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі A")
				.callbackData("Клас ймовірної пожежі A").build()));
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі D")
				.callbackData("Клас ймовірної пожежі D").build()));
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі F")
				.callbackData("Клас ймовірної пожежі F").build()));
		buttonsFour.add(Arrays.asList(InlineKeyboardButton.builder().text("Клас ймовірної пожежі E")
				.callbackData("Клас ймовірної пожежі E").build()));
		try {
			execute(SendMessage.builder().text("3. Оберіть клас можливої пожежі").chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsFour).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void typeExtinguisherForClassA(Message message) {
		List<List<InlineKeyboardButton>> buttonsFive = new ArrayList<>();
		buttonsFive.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
		buttonsFive.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Водопінний").callbackData("Водопінний").build()));
		buttonsFive.add(Arrays.asList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));
		try {
			execute(SendMessage.builder().text("4. Оберіть бажаний/наявний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsFive).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void typeExtinguisherForClassB(Message message) {
		List<List<InlineKeyboardButton>> buttonsFive = new ArrayList<>();
		buttonsFive.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
		buttonsFive.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Водопінний").callbackData("Водопінний").build()));
		buttonsFive.add(Arrays.asList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));
		buttonsFive.add(Arrays.asList(InlineKeyboardButton.builder().text("Газовий").callbackData("Газовий").build()));

		try {
			execute(SendMessage.builder().text("4. Оберіть бажаний/наявний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsFive).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void typeExtinguisherForClassC(Message message) {
		List<List<InlineKeyboardButton>> buttonsFive = new ArrayList<>();
		buttonsFive.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
		try {
			execute(SendMessage.builder().text("4. Оберіть бажаний/наявний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsFive).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void typeExtinguisherForClassD(Message message) {
		List<List<InlineKeyboardButton>> buttonsFive = new ArrayList<>();
		buttonsFive.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));

		try {
			execute(SendMessage.builder().text("4. Оберіть бажаний/наявний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsFive).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void typeExtinguisherForClassE(Message message) {
		List<List<InlineKeyboardButton>> buttonsFive = new ArrayList<>();
		buttonsFive.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
		buttonsFive.add(Arrays.asList(InlineKeyboardButton.builder().text("Газовий").callbackData("Газовий").build()));

		try {
			execute(SendMessage.builder().text("4. Оберіть бажаний/наявний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsFive).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void typeExtinguisherForClassE_category_В2_Д(Message message) {
		List<List<InlineKeyboardButton>> buttonsFive = new ArrayList<>();
		buttonsFive.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));

		try {
			execute(SendMessage.builder().text("4. Оберіть бажаний/наявний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsFive).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void typeExtinguisherForClassF(Message message) {
		List<List<InlineKeyboardButton>> buttonsSix = new ArrayList<>();

		buttonsSix.add(Arrays.asList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));

		try {
			execute(SendMessage.builder().text("4. Оберіть бажаний/наявний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsSix).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	void stringToDouble(String s) {
		data.add(s);
	}

	private void typeSpaces(Message message) { // вибір типу громадської будівлі в окремому методі

		List<List<InlineKeyboardButton>> buttonsSeven = new ArrayList<>();
		buttonsSeven.add(Arrays.asList(InlineKeyboardButton.builder().text("Адміністративні будівлі")
				.callbackData("Адміністративні будівлі").build()));
		buttonsSeven.add(Arrays.asList(InlineKeyboardButton.builder().text("Будівлі побутового призначення")
				.callbackData("Будівлі побутового призначення").build()));
		buttonsSeven.add(Arrays.asList(InlineKeyboardButton.builder().text("Підприємства торгівлі")
				.callbackData("Підприємства торгівлі").build()));
		buttonsSeven.add(Arrays.asList(
				InlineKeyboardButton.builder().text("Офісні приміщення").callbackData("Офісні приміщення").build()));
		buttonsSeven.add(Arrays.asList(InlineKeyboardButton.builder().text("Архіви, бібліотеки, музеї")
				.callbackData("Архіви, бібліотеки, музеї").build()));
		try {
			execute(SendMessage.builder().text(
					"2. Надішліть площу приміщення/поверху (м.кв.) та оберіть тип громадської будівлі/приміщення (порядковість не має значення): ")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsSeven).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void officeEquipment(Message message) { // встановлюється чи використовується в приміщеннях оргтехніка
		List<List<InlineKeyboardButton>> buttonsEight = new ArrayList<>();
		buttonsEight.add(Arrays.asList(InlineKeyboardButton.builder().text("Так, використовується")
				.callbackData("Так, використовується").build()));
		buttonsEight.add(Arrays.asList(InlineKeyboardButton.builder().text("Ні, не використовується")
				.callbackData("Ні, не використовується").build()));

		try {
			execute(SendMessage.builder().text("3. Чи використовується в досліджуваному приміщенні оргтехніка? ")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsEight).build()).build());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void pobutoviBudivli(Message message) { // чи в побутових приміщеннях є приміщення приготування їжі
		List<List<InlineKeyboardButton>> buttonsSeven = new ArrayList<>();
		buttonsSeven.add(Arrays.asList(InlineKeyboardButton.builder().text("Приміщення для приготування їжі")
				.callbackData("Приміщення для приготування їжі").build()));
		buttonsSeven.add(Arrays.asList(InlineKeyboardButton.builder().text("Інші побутові приміщення")
				.callbackData("Інші побутові приміщення").build()));

		try {
			execute(SendMessage.builder().text("3. Оберіть тип  побутового приміщення: ")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsSeven).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void robMaisciaKukhnia(Message message) {
		try {
			execute(SendMessage.builder().text(
					"4. Вкажіть кількість окремих робочих місць де в технологічному процесі приготування їжі застосовуються рослинні або тваринні масла і жири. Пілся - оберіть тип вогнегасника 🧯: ")
					.chatId(message.getChatId().toString()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		typeExtinguisherForKukhni(message);

	}

	private void typeExtinguisherForPublicPremises(Message message) { // вибір типу вогнегасника для громадських
																		// будівель
		List<List<InlineKeyboardButton>> buttonsTen = new ArrayList<>();

		buttonsTen.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Порошковий").callbackData("Порошковий").build()));
		buttonsTen.add(
				Arrays.asList(InlineKeyboardButton.builder().text("Водопінний").callbackData("Водопінний").build()));
		buttonsTen.add(Arrays.asList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));

		try {
			execute(SendMessage.builder().text("4. Оберіть бажаний/наявний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsTen).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void typeExtinguisherForKukhni(Message message) { // вибір типу вогнегасника для побутових приміщень
																// приготування їжі
		List<List<InlineKeyboardButton>> buttonsTen = new ArrayList<>();
		buttonsTen.add(Arrays.asList(InlineKeyboardButton.builder().text("Водяний").callbackData("Водяний").build()));

		try {
			execute(SendMessage.builder().text("5. Оберіть необхідний тип вогнегасника")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsTen).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void technicalАcilities(Message message) { // вставновлення чи є технічні приміщення
		List<List<InlineKeyboardButton>> buttonsNine = new ArrayList<>();
		buttonsNine.add(Arrays.asList(
				InlineKeyboardButton.builder().text("Так, передбачені").callbackData("Так, передбачені").build()));
		buttonsNine.add(Arrays.asList(
				InlineKeyboardButton.builder().text("Ні, не передбачені").callbackData("Ні, не передбачені").build()));

		try {
			if (kitchen == "кухні") {
				Thread.sleep(1000);
				execute(SendMessage.builder()
						.text("7. Чи передбачені в досліджуваних приміщеннях комори, електрощитові, "
								+ "вентиляційні камери або інші технічні приміщення? ")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsNine).build()).build());
			} else {
				Thread.sleep(1000);
				execute(SendMessage.builder()
						.text("6. Чи передбачені в досліджуваних приміщеннях комори, електрощитові, "
								+ "вентиляційні камери або інші технічні приміщення? ")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttonsNine).build()).build());
			}
		} catch (TelegramApiException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void technicalАcilitiesResult(Message message) { // викликається метод розрахунку кількосіт вогнегасників
																// для технічних приміщень громадських будівель
		PublicPremises pp = new PublicPremises();
		String s10 = pp.quantityExtinguisherTekhPrym();
		try {
//			execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s10).build());
			execute(SendMessage.builder().text(s10).chatId(message.getChatId().toString()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	void typesLiving(Message message) {

		List<List<InlineKeyboardButton>> button = new ArrayList<>();
		button.add(Arrays.asList(InlineKeyboardButton.builder().text("Квартири").callbackData("Квартири").build()));
		button.add(Arrays.asList(InlineKeyboardButton.builder().text("Гуртожитки").callbackData("Гуртожитки").build()));
		button.add(Arrays.asList(InlineKeyboardButton.builder().text("Будинки індивідуальної забудови")
				.callbackData("Будинки індивідуальної забудови").build()));

		try {
			execute(SendMessage.builder().text("2. Оберіть різновид житлового приміщення")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	void result(Message message) { // виводить результат для вогнегасника
		String s6 = null;
		if (typePremises == "Виробничі_складські") {
			IndustrialPremises ip = new IndustrialPremises();
			if (typeExtinguisher == "порошковий") {
				s6 = ip.quantityExtinguisherPoroshok();
			} else if (typeExtinguisher == "водопінний") {
				s6 = ip.quantityExtinguisherVodopinni();
			} else if (typeExtinguisher == "водяний") {
				s6 = ip.quantityExtinguisherVodiani();
			} else if (typeExtinguisher == "газовий") {
				s6 = ip.quantityExtinguisherGazovyi();
			}
		} else if (typePremises == "Громадські") {
			PublicPremises pp = new PublicPremises();
			if (typeExtinguisher == "порошковий") {
				s6 = pp.quantityExtinguisherPoroshok();
			}
			if (typeExtinguisher == "водопінний") {
				s6 = pp.quantityExtinguisherVodopinni();
			}
			if (typeExtinguisher == "водяний") {
				s6 = pp.quantityExtinguisherVodiani();
			}
		} else if (typePremises == "Житлові") {
			TypesLivingSpace lp = new TypesLivingSpace();
			s6 = lp.quantityExtinguisherLivingSpace();
		} else if (typePremises == "Гаражі") {
			Garages gg = new Garages();
			s6 = gg.quantityExtinguisherGarages();
		}
		try {
			execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s6).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

		if (typePremises == "Громадські" && data.isEmpty() == false) {
			technicalАcilities(message);
		}
	}

	private void startDegreeOfRisk(Message message) {// розпочинає роботу бот по визначенню ступеня ризику

		List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("Об’єкт що експлуатується")
				.callbackData("Об’єкт що експлуатується").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("Об’єкт на стадії будівництва")
				.callbackData("Об’єкт на стадії будівництва").build()));

		try {
			execute(SendMessage.builder().text("1. Оберіть характеристику об’єкта")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void dataEntryDegreeOfRisk(Message message) {// обираємо тип об'єкту для визначення ступеня ризику (спочатку
															// для об'єктів, що експлуатуються)
//		if (typeObjectOfRisk == "експлуатується") {
		List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("2.1").callbackData("2.1").build(),
				InlineKeyboardButton.builder().text("2.2").callbackData("2.2").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("2.3").callbackData("2.3").build(),
				InlineKeyboardButton.builder().text("2.4").callbackData("2.4").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("2.5").callbackData("2.5").build(),
				InlineKeyboardButton.builder().text("2.6").callbackData("2.6").build()));

		try {
			execute(SendMessage.builder().text("2. Оберіть тип об’єкта (з запропонованого переліку):\n\n"
					+ "2.1. Об’єкт підвищеної небезпеки\n"
					+ "2.2. Об’єкт державної власності, що має стратегічне значення для економіки і безпеки держави\n"
					+ "2.3. Об’єкт метрополітену\n"
					+ "2.4. Об’єкт, включений до Державного реєстру нерухомих пам’яток\n"
					+ "2.5. Промисловий або складський об’єкт\n" + "2.6. Інший об’єкт \n")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void stateOwnedObject(Message message) {// якщо обрані об'єкти державної власності, що експлуатуються, то
													// цей метод викинає наступне меню з вибором конкретного типу
		List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.1").callbackData("🏢 3.1").build(),
				InlineKeyboardButton.builder().text("🏢 3.2").callbackData("🏢 3.2").build(),
				InlineKeyboardButton.builder().text("🏢 3.3").callbackData("🏢 3.3").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.4").callbackData("🏢 3.4").build(),
				InlineKeyboardButton.builder().text("🏢 3.5").callbackData("🏢 3.5").build(),
				InlineKeyboardButton.builder().text("🏢 3.6").callbackData("🏢 3.6").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.7").callbackData("🏢 3.7").build(),
				InlineKeyboardButton.builder().text("🏢 3.8").callbackData("🏢 3.8").build(),
				InlineKeyboardButton.builder().text("🏢 3.9").callbackData("🏢 3.9").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.10").callbackData("🏢 3.10").build(),
				InlineKeyboardButton.builder().text("🏢 3.11").callbackData("🏢 3.11").build(),
				InlineKeyboardButton.builder().text("🏢 3.12").callbackData("🏢 3.12").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.13").callbackData("🏢 3.13").build(),
				InlineKeyboardButton.builder().text("🏢 3.14").callbackData("🏢 3.14").build(),
				InlineKeyboardButton.builder().text("🏢 3.15").callbackData("🏢 3.15").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.16").callbackData("🏢 3.16").build(),
				InlineKeyboardButton.builder().text("🏢 3.17").callbackData("🏢 3.17").build(),
				InlineKeyboardButton.builder().text("🏢 3.18").callbackData("🏢 3.18").build()));
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🏢 3.19").callbackData("🏢 3.19").build()));

		try {
			execute(SendMessage.builder().text("3. Оберіть різновид об’єкта (з запропонованого переліку):\n\n"
					+ "3.1. Об’єкт сфери оборони \n" + "3.2. Об’єкт паливно-енергетичного комплексу\n"
					+ "3.3. Об’єкт транспортної галузі \n"
					+ "3.4. Об’єкт підприємств, що забезпечують розміщення і зберігання матеріальних цінностей державного резерву \n"
					+ "3.5. Об’єкт агропромислового комплексу \n"
					+ "3.6. Об’єкт сфери електронних комунікацій та зв’язку \n"
					+ "3.7. Об’єкт авіаційної та ракетно-космічної промисловості \n"
					+ "3.8. Об’єкт машинобудівної промисловості \n" + "3.9. Об’єкт металургійного комплексу \n"
					+ "3.10. Об’єкт хімічного комплексу \n" + "3.11. Об’єкт наукової діяльності \n"
					+ "3.12. Об’єкт сфери стандартизації, метрології та сертифікації \n"
					+ "3.13. Об’єкт гідрометеорологічної діяльності \n"
					+ "3.14. Об’єкт промисловості будівельних матеріалів \n"
					+ "3.15. Об’єкт фінансово-бюджетної сфери \n" + "3.16. Об’єкт харчової промисловості \n"
					+ "3.17. Об’єкт легкої промисловості \n" + "3.18. Об’єкт поліграфії \n"
					+ "3.19. Об’єкт геологорозвідувальної галузі").chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void objectsCulturalHeritage(Message message) { // якщо обрані об'єкти культурної спадщини, то
		// цей метод викинає наступне меню з вибором рівня спадщини
		List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
		buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🏛 3.1").callbackData("🏛 3.1").build(),
				InlineKeyboardButton.builder().text("🏛 3.2").callbackData("🏛 3.2").build()));

		try {
			execute(SendMessage.builder()
					.text("3. Оберіть різновид об’єкта (з запропонованого переліку):\n\n"
							+ "3.1. Пам’ятка культурної спадщини національного значення \n"
							+ "3.2. Пам’ятка культурної спадщини місцевого значення\n")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void industrialWarehouseObjects(Message message) {// якщо обрані промислові чи складські об'єкти то цей
																// метод надає можливість обрати: промислові або
																// складські
		List<List<InlineKeyboardButton>> buttons = new ArrayList<>();

		buttons.add(Arrays.asList(
				InlineKeyboardButton.builder().text("Промисловий об’єкт").callbackData("Промисловий об’єкт").build()));
		buttons.add(Arrays.asList(
				InlineKeyboardButton.builder().text("Складський об’єкт").callbackData("Складський об’єкт").build()));

		try {
			execute(SendMessage.builder().text("3. Оберіть різновид об’єкта:").chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void categoryPremisesDegreeOfRisk(Message message) {
		List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
		buttons.add(Arrays
				.asList(InlineKeyboardButton.builder().text("Категорія  А").callbackData("Категорія  А").build()));
		buttons.add(Arrays
				.asList(InlineKeyboardButton.builder().text("Категорія  Б").callbackData("Категорія  Б").build()));
		buttons.add(Arrays
				.asList(InlineKeyboardButton.builder().text("Категорія  В").callbackData("Категорія  В").build()));
		buttons.add(Arrays
				.asList(InlineKeyboardButton.builder().text("Категорія  Г").callbackData("Категорія  Г").build()));
		buttons.add(Arrays
				.asList(InlineKeyboardButton.builder().text("Категорія  Д").callbackData("Категорія  Д").build()));

		try {
			execute(SendMessage.builder()
					.text("4. Оберіть категорію приміщення за вибухопожежною та пожежною небезпекою")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void objectArea(Message message) {// метод викликає сповіщення щоб ввести площу об'єкта і натиснути кнопку
												// Далі
		List<List<InlineKeyboardButton>> button = new ArrayList<>();
		button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));

		try {
			execute(SendMessage.builder()
					.text("Надішліть загальну площу об'єкта (м.кв.) та натисніть <Далі>\n"
							+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void reactionButtonDali(Message message) {// метод буде реагувати на натискання кнопки далі, залежно від
														// сценарію розвитку подій
		if (characteristicsObject == "експлуатується") {
			if (data.size() == 1) {
				List<List<InlineKeyboardButton>> button = new ArrayList<>();
				button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
				try {
					execute(SendMessage.builder().text(
							"Введіть максимальну розрахункову (проектну) кількість людей, які ПОСТІЙНО перебувають на об’єкті (осіб) та натисніть <Далі>\n"
									+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			if (data.size() == 2) {
				List<List<InlineKeyboardButton>> button = new ArrayList<>();
				button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
				try {
					execute(SendMessage.builder().text(
							"Введіть максимальну розрахункову (проектну) кількість людей, які ПЕРІОДИЧНО перебувають на об’єкті (осіб) та натисніть <Далі>\n"
									+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			if (data.size() == 3) {
				List<List<InlineKeyboardButton>> button = new ArrayList<>();
				button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
				try {
					execute(SendMessage.builder().text(
							"Введіть значення умовної висоти об’єкта (м.) (визначається різницею позначок найнижчого рівня проїзду (встановлення)"
									+ " пожежних автодрабин (автопідйомників) і підлоги верхнього поверху без урахування верхніх технічних поверхів, "
									+ "якщо на технічних поверхах розміщено лише інженерні обладнання та комунікації будинку). Натисніть <Далі>\n"
									+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
		}
		if (data.size() == 4 && levelEmergency == null && characteristicsObject == "експлуатується") {
			dangerousEvents(message);// викликається метод який далі виводиить меню із введенням значень небезпечних
										// подій (ситуацій), що ставались на об'єкті
		}
		if ((data.size() == 4 && characteristicsObject == "експлуатується")
				|| (data.size() == 0 && characteristicsObject == "проєктується")
						&& (levelEmergency == "НС регіонального рівня" || levelEmergency == "НС місцевого рівня"
								|| levelEmergency == "НС об’єктового рівня"
								|| levelEmergency == "не класифікована НС")) {
			List<List<InlineKeyboardButton>> button = new ArrayList<>();
			button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
			try {
				execute(SendMessage.builder().text(
						"Введіть загальну кількість загиблих в наслідок виникнення надзвичайної/них сиутації/цій (осіб). Натисніть <Далі>\n"
								+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		if ((data.size() == 5 && characteristicsObject == "експлуатується")
				|| (characteristicsObject == "проєктується" && data.size() == 1)
						&& (levelEmergency == "НС місцевого рівня" || levelEmergency == "НС об’єктового рівня"
								|| levelEmergency == "не класифікована НС")) {
			List<List<InlineKeyboardButton>> button = new ArrayList<>();
			button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
			try {
				execute(SendMessage.builder().text(
						"Введіть кількість збитків в наслідок виникнення надзвичайної/них сиутації/цій (грн). Натисніть <Далі>\n"
								+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		if ((data.size() == 6 && characteristicsObject == "експлуатується")
				|| (characteristicsObject == "проєктується" && data.size() == 2)
						&& (levelEmergency == "НС місцевого рівня" || levelEmergency == "НС об’єктового рівня"
								|| levelEmergency == "не класифікована НС")) {
			List<List<InlineKeyboardButton>> button = new ArrayList<>();
			button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
			try {
				execute(SendMessage.builder()
						.text("Введіть розмір неоподаткованого мінімуму доходів громадян (грн.) Натисніть <Далі>\n"
								+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		if ((data.size() == 7 && characteristicsObject == "експлуатується")
				|| (characteristicsObject == "проєктується" && data.size() == 3)
						&& (levelEmergency == "НС об’єктового рівня" || levelEmergency == "не класифікована НС")) {
			List<List<InlineKeyboardButton>> button = new ArrayList<>();
			button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
			try {
				execute(SendMessage.builder().text(
						"Введіть кількість травмованих осіб в наслідок виникнення надзвичайної/них ситуації/цій (події). Натисніть <Далі>\n"
								+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		if (characteristicsObject == "експлуатується") {
			if ((data.size() == 4 && levelEmergency == "НС державного рівня") // приймає порушення які були усунуті
					|| (data.size() == 5 && levelEmergency == "НС регіонального рівня")
					|| (data.size() == 7 && levelEmergency == "НС місцевого рівня")
					|| (data.size() == 8
							&& (levelEmergency == "НС об’єктового рівня" || levelEmergency == "не класифікована НС"))
					|| (data.size() == 4 && levelEmergency == "без НС")) {
				List<List<InlineKeyboardButton>> button = new ArrayList<>();
				button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
				try {
					execute(SendMessage.builder().text(
							"Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією об’єкта "
									+ "УСУНЕНИХ за останніх 5 років. Натисніть <Далі>\n"
									+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			if ((data.size() == 5 && levelEmergency == "НС державного рівня") // приймає порушення які НЕ були усунуті
					|| (data.size() == 6 && levelEmergency == "НС регіонального рівня")
					|| (data.size() == 8 && levelEmergency == "НС місцевого рівня")
					|| (data.size() == 9
							&& (levelEmergency == "НС об’єктового рівня" || levelEmergency == "не класифікована НС"))
					|| (data.size() == 5 && levelEmergency == "без НС")) {
				List<List<InlineKeyboardButton>> button = new ArrayList<>();
				button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
				try {
					execute(SendMessage.builder().text(
							"Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки пов’язаних з експлуатацією "
									+ "об’єкта, які НЕ БУЛО УСУНЕНО за останніх 5 років . Натисніть <Далі>\n"
									+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			if ((data.size() == 6 && levelEmergency == "НС державного рівня") // перевірє умову для виклику на виконання
																				// методу з результатом
					|| (data.size() == 7 && levelEmergency == "НС регіонального рівня")
					|| (data.size() == 9 && levelEmergency == "НС місцевого рівня")
					|| (data.size() == 10
							&& (levelEmergency == "НС об’єктового рівня" || levelEmergency == "не класифікована НС"))
					|| (data.size() == 6 && levelEmergency == "без НС")) {
				resultDegreeRisk(message);
			}
		}
		if (characteristicsObject == "проєктується") {
			if ((data.size() == 0 && levelEmergency == "НС державного рівня") // приймає порушення які були усунуті
					|| (data.size() == 1 && levelEmergency == "НС регіонального рівня")
					|| (data.size() == 3 && levelEmergency == "НС місцевого рівня")
					|| (data.size() == 4
							&& (levelEmergency == "НС об’єктового рівня" || levelEmergency == "не класифікована НС"))
					|| (data.size() == 0 && levelEmergency == "без НС")) {
				List<List<InlineKeyboardButton>> button = new ArrayList<>();
				button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
				try {
					execute(SendMessage.builder().text(
							"Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки під час будівництва"
									+ " об’єкта УСУНЕНИХ за останніх 5 років. Натисніть <Далі>\n"
									+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			if ((data.size() == 1 && levelEmergency == "НС державного рівня") // приймає порушення які НЕ були усунуті
					|| (data.size() == 2 && levelEmergency == "НС регіонального рівня")
					|| (data.size() == 4 && levelEmergency == "НС місцевого рівня")
					|| (data.size() == 5
							&& (levelEmergency == "НС об’єктового рівня" || levelEmergency == "не класифікована НС"))
					|| (data.size() == 1 && levelEmergency == "без НС")) {
				List<List<InlineKeyboardButton>> button = new ArrayList<>();
				button.add(Arrays.asList(InlineKeyboardButton.builder().text("Далі").callbackData("Далі").build()));
				try {
					execute(SendMessage.builder().text(
							"Введіть кількість порушень вимог законодавства у сфері техногенної та пожежної безпеки під час будівництва "
									+ "об’єкта, які НЕ БУЛО УСУНЕНО за останніх 5 років. Натисніть <Далі>\n"
									+ "Якщо введено помилкові дані - скористайтесь меню <На початок> 👇")
							.chatId(message.getChatId().toString())
							.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}

			if ((data.size() == 2 && levelEmergency == "НС державного рівня") // перевірє умову для виклику на виконання
																				// наступного методу для визначення
																				// ступеня ризику за класом наслідків
					|| (data.size() == 3 && levelEmergency == "НС регіонального рівня")
					|| (data.size() == 5 && levelEmergency == "НС місцевого рівня")
					|| (data.size() == 6
							&& (levelEmergency == "НС об’єктового рівня" || levelEmergency == "не класифікована НС"))
					|| (data.size() == 2 && levelEmergency == "без НС")) {
				constructionConsequences(message);
			}
		}

	}

	private void dangerousEvents(Message message) {// метод збору даних про небезпечні події, які траплялись на об'єкті
		if (typeObjectOfRisk == "об'єкт підвищеної небезпеки" || typeObjectOfRisk == "об’єкт метрополітену"
				|| typeObjectOfRisk == "інші об’єкти") {
			List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 3.1").callbackData("🔥 3.1").build(),
					InlineKeyboardButton.builder().text("🔥 3.2").callbackData("🔥 3.2").build()));
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 3.3").callbackData("🔥 3.3").build(),
					InlineKeyboardButton.builder().text("🔥 3.4").callbackData("🔥 3.4").build()));
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 3.5").callbackData("🔥 3.5").build(),
					InlineKeyboardButton.builder().text("🔥 3.6").callbackData("🔥 3.6").build()));
			try {
				execute(SendMessage.builder().text(
						"3. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n"
								+ "3.1. Надзвичайна ситуація державного рівня\n"
								+ "3.2. Надзвичайна ситуація регіонального рівня\n"
								+ "3.3. Надзвичайна ситуація місцевого рівня\n"
								+ "3.4. Надзвичайна ситуація об’єктового рівня\n"
								+ "3.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n"
								+ "3.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		if (typeObjectOfRisk == "об'єкт стратегічного значення" || typeObjectOfRisk == "нерухома пам'ятка") {
			List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 4.1").callbackData("🔥 4.1").build(),
					InlineKeyboardButton.builder().text("🔥 4.2").callbackData("🔥 4.2").build()));
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 4.3").callbackData("🔥 4.3").build(),
					InlineKeyboardButton.builder().text("🔥 4.4").callbackData("🔥 4.4").build()));
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 4.5").callbackData("🔥 4.5").build(),
					InlineKeyboardButton.builder().text("🔥 4.6").callbackData("🔥 4.6").build()));
			try {
				execute(SendMessage.builder().text(
						"4. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n"
								+ "4.1. Надзвичайна ситуація державного рівня\n"
								+ "4.2. Надзвичайна ситуація регіонального рівня\n"
								+ "4.3. Надзвичайна ситуація місцевого рівня\n"
								+ "4.4. Надзвичайна ситуація об’єктового рівня\n"
								+ "4.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n"
								+ "4.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

		if (typeObjectOfRisk == "промисловий або складський об’єкт") {
			List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 5.1").callbackData("🔥 5.1").build(),
					InlineKeyboardButton.builder().text("🔥 5.2").callbackData("🔥 5.2").build()));
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 5.3").callbackData("🔥 5.3").build(),
					InlineKeyboardButton.builder().text("🔥 5.4").callbackData("🔥 5.4").build()));
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 5.5").callbackData("🔥 5.5").build(),
					InlineKeyboardButton.builder().text("🔥 5.6").callbackData("🔥 5.6").build()));
			try {
				execute(SendMessage.builder().text(
						"5. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n"
								+ "5.1. Надзвичайна ситуація державного рівня\n"
								+ "5.2. Надзвичайна ситуація регіонального рівня\n"
								+ "5.3. Надзвичайна ситуація місцевого рівня\n"
								+ "5.4. Надзвичайна ситуація об’єктового рівня\n"
								+ "5.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n"
								+ "5.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		if (characteristicsObject == "проєктується") {
			List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 2.1").callbackData("🔥 2.1").build(),
					InlineKeyboardButton.builder().text("🔥 2.2").callbackData("🔥 2.2").build()));
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 2.3").callbackData("🔥 2.3").build(),
					InlineKeyboardButton.builder().text("🔥 2.4").callbackData("🔥 2.4").build()));
			buttons.add(Arrays.asList(InlineKeyboardButton.builder().text("🔥 2.5").callbackData("🔥 2.5").build(),
					InlineKeyboardButton.builder().text("🔥 2.6").callbackData("🔥 2.6").build()));
			try {
				execute(SendMessage.builder().text(
						"2. Вкажіть масштаб небезпечних подій, надзвичайних ситуацій, які сталися на об’єкті протягом останніх п’ять років:\n\n"
								+ "2.1. Надзвичайна ситуація державного рівня\n"
								+ "2.2. Надзвичайна ситуація регіонального рівня\n"
								+ "2.3. Надзвичайна ситуація місцевого рівня\n"
								+ "2.4. Надзвичайна ситуація об’єктового рівня\n"
								+ "2.5. Небезпечна подія, що не класифікується як надзвичайна ситуація\n"
								+ "2.6. Надзвичайних ситуацій та небезпечних подій за останні 5 років не виникало\n")
						.chatId(message.getChatId().toString())
						.replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());

			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	void resultDegreeRisk(Message message) { // виводить результат для ступеня ризику
		String s6 = null;
		DegreeRiskObject dro = new DegreeRiskObject();
		if (characteristicsObject == "експлуатується") {
			s6 = dro.degreeRiskObjectExploited();
		}
		if (characteristicsObject == "проєктується") {
			s6 = dro.degreeRiskObjectProjected();
		}

		try {
			execute(SendMessage.builder().chatId(message.getChatId().toString()).text(s6).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void constructionConsequences(Message message) {
		List<List<InlineKeyboardButton>> button = new ArrayList<>();
		button.add(Arrays.asList(InlineKeyboardButton.builder().text("⚡️ 3.1").callbackData("⚡️ 3.1").build()));
		button.add(Arrays.asList(InlineKeyboardButton.builder().text("⚡️ 3.2").callbackData("⚡️ 3.2").build()));
		button.add(Arrays.asList(InlineKeyboardButton.builder().text("⚡️ 3.3").callbackData("⚡️ 3.3").build()));
		try {
			execute(SendMessage.builder().text(
					"3. Оберіть тип об'єкта для встановлення показників ступеня ризику за класом наслідків (відповідальності) під час будівництва (з запропонованого переліку):\n\n"
							+ "3.1. Об’єкт із значними наслідками (СС3)\n"
							+ "3.2. Об’єкт із середніми наслідками (СС2)\n"
							+ "3.3. Об’єкт із незначними наслідками (СС1)")
					.chatId(message.getChatId().toString())
					.replyMarkup(InlineKeyboardMarkup.builder().keyboard(button).build()).build());

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		return "extinguisher_fire_safety_bot";
	}

	@Override
	public String getBotToken() {
		return "5296860397:AAGV29wdQowtGKYPPgUOYl0E-NoixxNMyNY";
	}
}

//	private ReplyKeyboardMarkup getMenuKeyboard() {
//		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
//		replyKeyboardMarkup.setSelective(true);
//		replyKeyboardMarkup.setResizeKeyboard(true);
//		replyKeyboardMarkup.setOneTimeKeyboard(false);
//
//		List<KeyboardRow> keyboardRows = new ArrayList<>();
//		KeyboardRow keyboardRow = new KeyboardRow();
//		keyboardRow.add("Громадські приміщення");
//		keyboardRow.add("Житлові приміщення");
//		KeyboardRow keyboardSecondRow = new KeyboardRow();
//		keyboardSecondRow.add("Виробничі приміщення");
//
//		keyboardRows.add(keyboardRow);
//		keyboardRows.add(keyboardSecondRow);
//
//		replyKeyboardMarkup.setKeyboard(keyboardRows);
//		return replyKeyboardMarkup;
//	}
//

//	sendMessage.enableMarkdown(true);
//	ReplyKeyboardMarkup keyboardMarkup = getMenuKeyboard();
//	sendMessage.setReplyMarkup(keyboardMarkup);

//if (message.getText().equals("Громадські приміщення")) {
//	sendMessage.setText("Порахували вогнегасники для громадських приміщень");
//} else if (message.getText().equals("Житлові приміщення")) {
//	sendMessage.setText("Порахували вогнегасники для житлових приміщень");
//} else if (message.getText().equals("Виробничі приміщення")) {
//	sendMessage.setText("Порахували вогнегасники для виробничих приміщень");
//}

//public void onUpdateReceived(Update update) {
//	Message messege = update.getMessage();
////	System.out.println("messege " + messege.getText()); // зчитуємо повідомлення в консоль
//	SendMessage sendMessege = new SendMessage(); // об'єкт для опрацювання запиту + надсилання повідомлення у
//													// відповідь
//	
//	sendMessege.setText("Решта функціоналу в розробці :-* ... " + messege.getText()); // встановлюємо текст який
//																	// далі буде надсилатись
//	
//	sendMessege.setChatId(String.valueOf(messege.getChatId())); // встановлюється ІД чату, куда будемо надсилати
//																// повідомлення
//	

//
//		
//			sendMessege.enableMarkdown(true);
//			ReplyKeyboardMarkup keyboardMarkup = getMenuKeyboard();
//			sendMessege.setReplyMarkup(keyboardMarkup);
//
//	}
//	
//	if (messege.getText().equals("Задати площу об'єкта/приміщення")) {
//		sendMessege.setText("Введіть площу об'єкта/приміщення");
//		square = messege.getText();
//		sendMessege.setText(square);
//		
//	}

//команди в телеграмі:
//type_number_fire_extinguishers - Визначення типу та необхідної кількості вогнегасників
//degree_of_risk_from_activities - Оцінка ступеня ризику від провадження господарської діяльності
//on_start - На початок
//feedback_info - Інформація. Зворотній зв'язок
