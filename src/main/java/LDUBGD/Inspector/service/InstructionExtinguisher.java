package LDUBGD.Inspector.service;

public class InstructionExtinguisher {

	String instruction() {
		return "Робота чат боту щодо визначення нормативних показників "
				+ "чисельності та типів первинних засобів пожежогасіння (вогнегасників) регламентована "
				+ "Правилами експлуатації та типовими нормами належності вогнегасників, що затверджені "
				+ "Наказом МВС України № 25 від 15.01.2018 р.\n\n"
				+ "Ці правила не поширюються на:\n"
				+ "🚫 Підземні споруди підприємств гірничодобувної промисловості;\n"
				+ "🚫 Електрорухомий склад, шахти, тунелі та підземні споруди метрополітену;\n"
				+ "🚫 Транспортні засоби залізничного, повітряного, річкового та морського транспорту.\n\n"
				+ "У цих Правилах наведено такі позначення типів вогнегасників:\n"
				+ "🧯 ВВ - вогнегасник водяний;\n"
				+ "🧯 ВВП - вогнегасник водопінний (у тому числі аерозольний);\n"
				+ "🧯 ВГ (ВВК) - вогнегасник газовий, у тому числі вуглекислотний;\n"
				+ "🧯 ВП - вогнегасник порошковий.\n"
				+ "Цифра після позначення типу вогнегасника означає масу вогнегасної речовини в кілограмах, "
				+ "що міститься в його корпусі. Наприклад, ВП-5 - вогнегасник порошковий з масою вогнегасної речовини 5 кг.\n\n"
				+ "❗️ Для вибору типу та необхідної кількості вогнегасників для оснащення об’єкта в чат-боті враховано фізико-хімічні "
				+ "та пожежонебезпечні властивості горючих речовин, характер їх взаємодії з вогнегасними речовинами, а також площу приміщень, "
				+ "будинків і споруд.\n"
				+ "❗️ Необхідну кількість вогнегасників визначають окремо для кожного поверху та приміщення об’єкта.\n"
				+ "Приміщення, у якому розміщено декілька різних за пожежною небезпекою виробництв, не відділених одне від "
				+ "одного протипожежними стінами, оснащують вогнегасниками за нормами найбільш небезпечного виробництва.\n\n"
				+ "🧯 Критерії, які необхідно буде зазначити (обрати) для визначення типу та необхідної кількості вогнегасників:\n"
				+ "1️⃣ тип приміщення (об'єкту);\n"
				+ "2️⃣ категорія приміщення за вибухопожежною та пожежною небезпекою (для виробничих, складських та лабораторних приміщень);\n"
				+ "3️⃣ клас можливої пожежі;\n"
				+ "4️⃣ захищувана площа;\n"
				+ "5️⃣ особливості об'ємно-планувальних рішень (наявність комор, електрощитових тощо).\n"
				+ "*️⃣ Придатність вогнегасника для гасіння пожежі певного класу, а також вогнегасна здатність вогнегасника конкретного типу "
				+ "враховуються підсистемою Extinguisher Bot автоматично.\n\n"
				+ "🧯 Якщо на об’єкті можливі осередки пожеж різних класів, слід обирати вогнегасники окремо для кожного класу пожежі "
				+ "або віддавати перевагу більш універсальному вогнегаснику. При виборі таких вогнегасників їх мінімальна кількість має "
				+ "дорівнювати більшому значенню, що отримане для кожного класу пожежі окремо.\n\n"
				+ "🧯 За потреби використання різних типів вогнегасників допускається здійснювати заміну одного типу на інший із забезпеченням "
				+ "рівності сумарної вогнегасної здатності за класом пожежі, характерної для цього об’єкта із врахуванням коефіцієнта ефективності "
				+ "вогнегасників згідно п. 5 Розділ 6 Наказу МВС України №25 від 15.01.2018\n\n"
				+ "Для початку роботи надішліть площу приміщення/об'єкту (м.кв.) 👇 та натисніть <розпочати> 👆\n";
		
	}
	
	String feedback () {
		return "Чат бот Інтерактивний інспектор розроблено колективом Львівського державного університету безпеки життєдіяльності для автоматизації"
				+ " процесів оцінки протипожежного стану об’єктів. \n\n "
				+ "Розробка чат боту реалізована в рамках виконання науково-дослідної роботи "
				+ "<Дослідження параметрів оцінки протипожежного стану об’єктів та "
				+ "побудова на їх основі комп’ютерної аналітичної системи> на замовлення Департаменту запобігання надзвичайним ситуаціям "
				+ "Державної служби України з надзвичайних ситуацій\n\n"
				+ "Чат бот автоматизує процеси : \n"
				+ "✅ вибору типу та необхідної кількості вогнегасників для об’єкту; \n"
				+ "✅ визначення ступеня ризику від провадження господарської діяльності; \n"
				+ "✅ визначення категорій приміщень, будинків, установок за вибухопожежною та пожежною небезпекою; \n"
				+ "✅ визначення класу зони; \n"
				+ "✅ визначення необхідності проектування та монтажу автоматичних систем пожежної сигналізації; \n"
				+ "✅ визначення необхідності проектування та монтажу автоматичних систем пожежогасіння; \n"
				+ "✅ визначення типу системи оповіщення, характеристик системи оповіщення та управління евакуюванням людей при пожежі; \n"
				+ "✅ визначення необхідності влаштування та параметрів зовнішнього протипожежного водопостачання; \n"
				+ "✅ визначення необхідності влаштування та параметрів внутрішнього протипожежного водопостачання; \n"
				+ "✅ визначення протипожежних відстаней між будівлями, технологічними установками, інженерними комунікаціями; \n"
				+ "✅ визначення допустимої поверховості та площі протипожежного відсіку. \n\n"
				+ "Ініціатори (модератори) проєкту: \n"
				+ "☑️ Олександр ЧЕКРИГІН - начальник Департаменту запобігання надзвичайним ситуаціям\n"
				+ "☑️ Степан ЮДІН - фахівець відділу забезпечення заходів запобігання надзвичайним ситуаціям\n\n"
				+ "Розробники проєкту:\n"
				+ "☑️ Олександр ПРИДАТКО - начальник кафедри інформаційних технологій та телекомунікаційних систем ЛДУ БЖД\n"
				+ "☑️ Олександр ХЛЕВНОЙ - ст.викладач кафедри інформаційних технологій та телекомунікаційних систем ЛДУ БЖД\n"
				+ "☑️ Олег ПАЗЕН - начальник кафедри наглядово-профілактичної діяльності та пожежної автоматики ЛДУ БЖД\n"
				+ "☑️ Валентин ПРИДАТКО - викладач кафедри наглядово-профілактичної діяльності та пожежної автоматики ЛДУ БЖД\n\n"
				+ "ℹ️ Пропозиції та побажаннями щодо роботи комп'ютерної аналітичної системи (чат боту) надсилайте за адресами o.prydatko@ldubgd.edu.ua або o_prydatko@ukr.net";
	}

}
