package SV.FireSafety.services;

public class Categories {
    //Категорія приміщення
    //категорія А
    String text;
    private String categoryA(){
        text = "За вказаними Вами характеристиками речовин, що обертаються в технологічному процесі, приміщення за вибухопожежною небезпекою відноситься до категорії - А.\n\n";
        text += "Горючі гази, легкозаймисті рідини з температурою спалаху не вище ніж 28°C у такій кількості, що можуть утворювати вибухонебезпечні газо-, пароповітряні суміші, у разі займання яких розвивається розрахунковий надлишковий тиск вибуху у приміщенні, який перевищує 5кПа, і/або речовини і матеріали, здатні вибухати і горіти при взаємодії з водою, киснем повітря і/або один з одним, у такій кількості, що розрахунковий надлишковий тиск вибуху в приміщенні перевищує 5кПа \n";
        return text;
    }
    public String getCategoryA(){
        return categoryA();
    }
    //категорія Б
    private String categoryБ(){
        text ="За вказаними Вами характеристиками речовин, що обертаються в технологічному процесі, приміщення за вибухопожежною небезпекою відноситься до категорії - Б.\n\n";
        text +="Горючі пил і/або волокна, легкозаймисті рідини з температурою вище ніж 28°C, горючі рідини у такій кількості, що можуть утворювати вибухонебезпечні пило-, пароповітряні суміші, у разі займання яких розвивається розрахунковий надлишковий тиск вибуху в приміщенні, який перевищує 5 кПа\n";
        return text;
    }
    public String getCategoryБ(){
        return categoryБ();
    }
    //категорія В
    private String categoryВ(){
        text ="За вказаними Вами характеристиками речовин, що обертаються в технологічному процесі, приміщення за вибухопожежною небезпекою відноситься до категорії - В.\n\n";
        text += "Горючі гази, легкозаймисті, горючі і/або важкогорючі рідини, а також речовини і/або матеріали, які здатні вибухати і горіти або тільки горіти під час взаємодії з водою, киснем повітря і/або один з одним;тверді горючі і/або важкогорючі речовини і матеріали(включно горючий пил і/або волокна), за умови, що приміщення, в яких вони знаходяться(зберігаються, переробляються, транспортуються), не відносяться до категорій А або Б і питома пожежна навантага для твердих і рідких легкозаймистих, горючих та важкогорючих речовин і/або матеріалів на окремих ділянках площею не менше 10 м² кожна перевищує 180 МДж/м². Якщо питома пожежна навантага не перевищує 180 МДж/м², то приміщення відноситься до категорії Д за умови виконання вимог пунктів 7.6.1, 7.6.5 та 7.6.8 ДСТУ Б.В.1.1-36:2016";
        return text;
    }
    public String getCategoryВ(){
        return categoryВ();
    }
    //категорія Г
    private String categoryГ(){
        text ="За вказаними Вами характеристиками речовин, що обертаються в технологічному процесі, приміщення за вибухопожежною небезпекою відноситься до категорії - Г.\n\n";
        text +="Негорючі речовини і/або матеріали у гарячому, розпеченому і/або розплавленому стані, процес обробки яких супроводжується виділенням променистого тепла, утворенням іскор і/або полум'я;горючі гази, рідини і/або тверді речовини, що спалюються або утилізуються як паливо\n ";
        return text;
    }
    public String getCategoryГ(){
        return categoryГ();
    }
    //категорія Д
    private String categoryД(){
        text ="За вказаними Вами характеристиками речовин, що обертаються в технологічному процесі, приміщення за вибухопожежною небезпекою відноситься до категорії - Д.\n\n";
        text +="Речовини і/або матеріали, що зазначені вище для категорії приміщень В (крім горючих газів, горючих пилу і/або волокон), а також негорючі речовини і/або матеріали в холодному стані(за температури навколишнього середовища), за умов, що приміщення, в яких знаходяться, зберігаються, переробляються, транспортуються) зазнчені вище речовини і/або матеріали, не відносяться до категорій А,Б або В\n";
        return text;
    }
    public String getCategoryД(){
        return categoryД();
    }
    //Категорія зовнішньої установки
    //категорія Аз
    private String categoryАз(){
        text ="За казаними Вами характеристиками речовин, що обертаються в технологічному процесі, зона технологічної установки відноситься до категорії виробництва за пожежною небезпекою - Аз. \n\n";
        text +="Установка відноситься до категорії Aз, якщо в ній знаходяться (обертаються) горючі гази; легкозаймисті рідини з температурою спалаху не більше ніж 28°C; речовини і/або матеріали, які здатні вибухати і горіти під час взаємодії з водою, киснем повітря і/або один з одним. При цьому горизонтальний розмір зони, що обмежує газо-, пароповітряні суміші із концентрацією горючої речовини вище нижньої концентраційної межі поширення полум'я (Снкмп), перевищує 30м (даний критерій застосовується тільки для горючих газів і парів) і/або розрахунковий надлишковий тиск вибуху, що розвивається в разу займання газо-, пароповітряних сумішей, і/або під час вибуху речовин і/або матеріалів, які здатні вибухати і горіти під час взаємодії з водою, киснем повітря і/або один з одним, перевищує більше еіж 5 кПа на відстані 30м від зовнішньої установки \n ";
        return text;
    }
    public String getCategoryАз(){
        return categoryАз();
    }
    //категорія Бз
    private String categoryБз(){
        text = "За казаними Вами характеристиками речовин, що обертаються в технологічному процесі, зона технологічної установки відноситься до категорії виробництва за пожежною небезпекою - Бз. \n\n";
        text += "Установка відноситься до категорії Бз, якщо в ній знаходяться (обертаються) горючі пил і/або волокна; легкозаймисті рідини з температурою спалаху більше ніж 28°C; горючі рідини. При цьому горизонтальний розмір зони,що обмежує пароповітряні суміші із концентрацією горючої речовини вище нижньої концентраційної межі поширення полум'я (Снкмп), перевищує 30м (даний притерій застосовується тільки для горючих парів) і/або розрахунковий надлишковий тиск вибуху, що розвивається у разу пило-, пароповітряних сумішей, перевищує більше ніж 5 кПа на відстані 30м від зовнішньої установки\n ";
        return text;
    }
    public String getCategoryБз(){
        return categoryБз();
    }
    //категорія Вз
    private String categoryВз(){
        text ="За казаними Вами характеристиками речовин, що обертаються в технологічному процесі, зона технологічної установки відноситься до категорії виробництва за пожежною небезпекою - Вз. \n\n";
        text += "Установка відноситься до категорії Вз,якщо в ній знаходяться (обертаються) горючі гази, легкозаймисті, горючі і/або важкогорючі рідини, тверді горючі і/або важкогорючі речовини і/або матеріали (включно з горючим пилом і/або волокнами), а також речовини і/або матеріали, які здатні вибухати і горіти або тільки горіти під час взаємодії з водою, киснем повітря і/або один з одним, за умови, що установка не відноситься до категорій Aз або Бз. При цьому інтенсивність теплового випромінювання від вогнища пожежі перевищує 4 кВт/м² на відстані 30м від зовнішної установки.\n ";
        return text;
    }
    public String getCategoryВз(){
        return categoryВз();
    }
    //категорія Гз
    private String categoryГз(){
        text = "За казаними Вами характеристиками речовин, що обертаються в технологічному процесі, зона технологічної установки відноситься до категорії виробництва за пожежною небезпекою - Гз. \n\n";
        text += "Установка відноситься до категорії Гз, якщо в ній знаходяться (обертаються) негорючі речовини і/або матеріали в гарячому, розпеченому і/або розплавленому стані, процес обробки яких супроводжується виділенням променистого тепла, утворенням іскор і/або полум'я, а також горючі гази, рідини і/або тверді речовини, які спалюються або утилізуються як паливо\n";
        return text;
    }
    public String getCategoryГз(){
        return categoryГз();
    }
    //категорія Дз
    private String categoryДз(){
        text = "За казаними Вами характеристиками речовин, що обертаються в технологічному процесі, зона технологічної установки відноситься до категорії виробництва за пожежною небезпекою - Дз. \n\n";
        text += "Установка відноситься до категорії Дз, якщо вона не відноситься до категорій Аз, Бз, Вз або Гз. Якщо в установці знаходяться (обертаються) тільки важкогорючі речовини і матеріали, то вона відноситься до категорії Дз.\n";
        return text;
    }
    public String getCategoryДз(){
        return categoryДз();
    }

    //Категорія будівлі
    //категорія А
    private String categoryAб(){
        text = "Проведеним розрахунком за геометричними параметрами будівлі, приміщень та характеристиками речовин, що обертаються у приміщеннях, в загальному будівля відноситься до категорії виробництва за вибухопожежною небезпекою - А.\n\n";
        text += "Горючі гази, легкозаймисті рідини з температурою спалаху не вище ніж 28°C у такій кількості, що можуть утворювати вибухонебезпечні газо-, пароповітряні суміші, у разі займання яких розвивається розрахунковий надлишковий тиск вибуху у приміщенні, який перевищує 5кПа, і/або речовини і матеріали, здатні вибухати і горіти при взаємодії з водою, киснем повітря і/або один з одним, у такій кількості, що розрахунковий надлишковий тиск вибуху в приміщенні перевищує 5кПа \n";
        return text;
    }
    public String getCategoryAб(){
        return categoryAб();
    }
    //категорія Б
    private String categoryБб(){
        text = "Проведеним розрахунком за геометричними параметрами будівлі, приміщень та характеристиками речовин, що обертаються у приміщеннях, в загальному будівля відноситься до категорії виробництва за вибухопожежною небезпекою - Б.\n\n";
        text +="Горючі пил і/або волокна, легкозаймисті рідини з температурою вище ніж 28°C, горючі рідини у такій кількості, що можуть утворювати вибухонебезпечні пило-, пароповітряні суміші, у разі займання яких розвивається розрахунковий надлишковий тиск вибуху в приміщенні, який перевищує 5 кПа\n";
        return text;
    }
    public String getCategoryБб(){
        return categoryБб();
    }
    //категорія В
    private String categoryВб(){
        text = "Проведеним розрахунком за геометричними параметрами будівлі, приміщень та характеристиками речовин, що обертаються у приміщеннях, в загальному будівля відноситься до категорії виробництва за вибухопожежною небезпекою - В.\n\n";
        text += "Горючі гази, легкозаймисті, горючі і/або важкогорючі рідини, а також речовини і/або матеріали, які здатні вибухати і горіти або тільки горіти під час взаємодії з водою, киснем повітря і/або один з одним;тверді горючі і/або важкогорючі речовини і матеріали(включно горючий пил і/або волокна), за умови, що приміщення, в яких вони знаходяться(зберігаються, переробляються, транспортуються), не відносяться до категорій А або Б і питома пожежна навантага для твердих і рідких легкозаймистих, горючих та важкогорючих речовин і/або матеріалів на окремих ділянках площею не менше 10 м² кожна перевищує 180 МДж/м². Якщо питома пожежна навантага не перевищує 180 МДж/м², то приміщення відноситься до категорії Д за умови виконання вимог пунктів 7.6.1, 7.6.5 та 7.6.8 ДСТУ Б.В.1.1-36:2016";
        return text;
    }
    public String getCategoryВб(){
        return categoryВб();
    }
    //категорія Г
    private String categoryГб(){
        text = "Проведеним розрахунком за геометричними параметрами будівлі, приміщень та характеристиками речовин, що обертаються у приміщеннях, в загальному будівля відноситься до категорії виробництва за вибухопожежною небезпекою - Г.\n\n";
        text +="Негорючі речовини і/або матеріали у гарячому, розпеченому і/або розплавленому стані, процес обробки яких супроводжується виділенням променистого тепла, утворенням іскор і/або полум'я;горючі гази, рідини і/або тверді речовини, що спалюються або утилізуються як паливо\n ";
        return text;
    }
    public String getCategoryГб(){
        return categoryГб();
    }
    //категорія Д
    private String categoryДб(){
        text = "Проведеним розрахунком за геометричними параметрами будівлі, приміщень та характеристиками речовин, що обертаються у приміщеннях, в загальному будівля відноситься до категорії виробництва за вибухопожежною небезпекою - Д.\n\n";
        text +="Речовини і/або матеріали, що зазначені вище для категорії приміщень В (крім горючих газів, горючих пилу і/або волокон), а також негорючі речовини і/або матеріали в холодному стані(за температури навколишнього середовища), за умов, що приміщення, в яких знаходяться, зберігаються, переробляються, транспортуються) зазнчені вище речовини і/або матеріали, не відносяться до категорій А,Б або В\n";
        return text;
    }
    public String getCategoryДб(){
        return categoryДб();
    }
}