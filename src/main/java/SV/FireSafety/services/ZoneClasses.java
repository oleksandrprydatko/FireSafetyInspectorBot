package SV.FireSafety.services;

public class ZoneClasses {

    public String zoneClass0 (){
        return "\uD83D\uDCA5 Висновок: Вибухонебезпечна зона класу 0. \n\n" +
                "Простір, у якому вибухонебезпечне середовище присутнє постійно або протягом тривалого часу. " +
                "Вибухонебезпечна зона класу 0 може мати місце тільки в межах корпусів технологічного обладнання";
    }

    public String zoneClass20 (){
        return "\uD83D\uDCA5 Висновок: Вибухонебезпечна зона класу 20. \n\n" +
                "Простір, у якому під час нормальної експлуатації вибухонебезпечний пил у вигляді хмари присутній " +
                "постійно або часто в кількості, достатній для утворення небезпечної концентрації суміші з повітрям, " +
                "і (або) простір, де можуть утворюватися пилові шари непередбаченої або надмірної товщини. " +
                "Звичайно це має місце всередині обладнання, де пил може формувати вибухонебезпечні суміші " +
                "часто і на тривалий термін";
    }

    public String zoneClass1(){
        return "\uD83D\uDCA5 Висновок: Вибухонебезпечна зона класу 1. \n\n" +
                "Простір, у якому вибухонебезпечне середовище може утворюватися під час нормальної роботи";
    }

    public String zoneClass21(){
        return "\uD83D\uDCA5 Висновок: Вибухонебезпечна зона класу 21. \n\n" +
                "Простір, у якому під час нормальної експлуатації ймовірна поява пилу у вигляді хмари в кількості, " +
                "достатній для утворення суміші з повітрям вибухонебезпечної концентрації. Ця зона може включати простір " +
                "поблизу місця порошкового заповнення або осідання і простір, де під час нормальної експлуатації ймовірна " +
                "поява пилових шарів, які можуть утворювати небезпечну концентрацію вибухонебезпечної пилоповітряної суміші.";
    }

    public String zoneClass2(){
        return "\uD83D\uDCA5 Висновок: Вибухонебезпечна зона класу 2. \n\n" +
                "Простір, у якому вибухонебезпечне середовище за нормальних умов експлуатації відсутнє, а якщо виникає то рідко " +
                "і триває недовго. У цих випадках можливі аварії катастрофічних розмірів, не повинні розглядатися під " +
                "час проектування електроустановок";
    }

    public String zoneClass22(){
        return "\uD83D\uDCA5 Висновок: Вибухонебезпечна зона класу 22. \n\n" +
                "Простір, у якому вибухонебезпечний пил у завислому стані може з’являтися не часто й існувати недовго або в якому " +
                "шари вибухонебезпечного пилу можуть існувати й утворювати вибухонебезпечні суміші в разі аварії. Ця зона може " +
                "включати простір поблизу обладнання, що утримує пил, який може вивільнятися шляхом витоку і формувати пилові утворення";
    }

    public String zoneClassP_I(){
        return "\uD83D\uDD25 Висновок: Пожежонебезпечна зона класу П-І. \n\n" +
                "Простір приміщення, у якому знаходиться горюча рідина, яка має температуру спалаху більше + 61 С.";
    }

    public String zoneClassP_II(){
        return "\uD83D\uDD25 Висновок: Пожежонебезпечна зона класу П-ІІ. \n\n" +
                "Простір приміщення, у якому можуть накопичуватись і виділятися горючий пил або волокна.";
    }

    public String zoneClassP_IIa(){
        return "\uD83D\uDD25 Висновок: Пожежонебезпечна зона класу П-ІІа. \n\n" +
                "Простір приміщення, у якому знаходяться тверді горючі речовини та матеріали.";
    }
    public String zoneClassP_III(){
        return "\uD83D\uDD25 Висновок: Пожежонебезпечна зона класу П-ІІI. \n\n" +
                "Простір поза приміщенням, в якому знаходяться горюча рідина, яка має температуру спалахування понад + 61 С або тверді горючі речовини.";
    }

    public String zoneClassSukhi(){
        return "♻️ Висновок: Сухі приміщення \n\n" +
                "Приміщення, в яких відносна вологість не перевищує 60%.";
    }

    public String zoneClassVologi(){
        return "♻️ Висновок: Вологі приміщення \n\n" +
                "Приміщення, в яких пара або волога, яка конденсується лише короткочасно, є в невеликих кількостях, а відносна вологість більше 60%, але не перевищує 75%";
    }

    public String zoneClassSyri(){
        return "♻️ Висновок: Сирі приміщення \n\n" +
                "Приміщення, в яких відносна вологість повітря тривалий час перевищує 75%";
    }

    public String zoneClassOsoblyvoSyri(){
        return "♻️ Висновок: Особливо сирі приміщення \n\n" +
                "Приміщення, в яких відносна вологість повітря близька до 100%";
    }

    public String zoneClassGariachi(){
        return "♻️ Висновок: Гарячі приміщення \n\n" +
                "Приміщення, в яких температура постійно або періодично перевищує + 35 С";
    }

    public String zoneClassZapyleni(){
        return "♻️ Висновок: Запилені приміщення \n\n" +
                "Приміщення, в яких за умовами виробництва виділяється технологічний пил в такій кількості, що він може осідати на проводи, проникати всередину машин, апаратів";
    }

    public String zoneClassKhimichni(){
        return "♻️ Висновок: Приміщення з хімічно-активним середовищем \n\n" +
                "Приміщення, в яких постійно або протягом тривалого часу утримуються агресивні пари, гази, рідини, утворюючи відкладення або плісняви, які руйнують ізоляцію і струмопровідні частини електрообладнання";
    }

}
