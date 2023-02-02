package SV.FireSafety.services;

import java.sql.*;

public class DBWorker {

    private final String HOST = "jdbc:mysql://localhost:3306/interactive-inspector?autoReconnect=true";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    Connection connection;

    public DBWorker(){
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // перевірка чи користувач вже існує в базі даних
    public void checkUser(String chatID){
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            int exists = 0;
            while (resultSet.next()){
                String idTelegram = resultSet.getString("idTelegram");
                if (idTelegram.equals(chatID)){
                    exists += 1;
                }
            }
            if (exists == 0){
                String sql = "INSERT INTO users (idTelegram) values ('"+chatID+"')";
                statement.addBatch(sql);
                statement.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //очищення бази
    public void update(String chatID){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typePremises=NULL,categoryPremises=NULL," +
                    "classFire=NULL,typeExtinguisher=NULL,typeSpacesBuild=NULL,b1=NULL,b2=NULL,kitchen=NULL," +
                    "characteristicsObject=NULL,typeObjectOfRisk=NULL,typeStateOwnedObject=NULL," +
                    "typeCulturalObject=NULL,typeIndustrialStorageFacility=NULL,levelEmergency=NULL,typeResultDegreeRisk=NULL," +
                    "usedIndoors='null',categoryBuildings=NULL,value=NULL,square=NULL,parking=NULL," +
                    "workplace=NULL,squareTechnicalPremises=NULL,constantlyAtFacility=NULL," +
                    "periodicallyAtFacility=NULL,heightObject=NULL,fixedViolations=NULL,noFixedViolations=NULL," +
                    "deadPeople = NULL,losses = NULL, taxFreeIncome = NULL, injuredPeople=NULL," +
                    "volumePremises=NULL, volumeRoomsA=NULL, volumeRoomsБ=NULL, volumeRoomsB=NULL," +
                    "volumeRoomsГ=NULL where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // встановлення comandOfMenu
    public void setComandOfMenu(String chatID,String comand){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set comandOfMenu='"+comand+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо comandOfMenu з БД
    public String getComandOfMenu(String chatID){
        String comandOfMenu= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                comandOfMenu = resultSet.getString("comandOfMenu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comandOfMenu;
    }
    // встановлення TypePremises
    public void setTypePremises(String chatID,String typePremises){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typePremises='"+typePremises+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typePremises з БД
    public String getTypePremises(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typePremises");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення categoryPremises
    public void setCategoryPremises(String chatID,String categoryPremises){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set categoryPremises='"+categoryPremises+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо categoryPremises з БД
    public String getCategoryPremises(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("categoryPremises");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення classFire
    public void setClassFire(String chatID,String classFire){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set classFire='"+classFire+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо classFire з БД
    public String getClassFire(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("classFire");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення typeExtinguisher
    public void setTypeExtinguisher(String chatID,String typeExtinguisher){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typeExtinguisher='"+typeExtinguisher+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typeExtinguisher з БД
    public String getTypeExtinguisher(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typeExtinguisher");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення typeSpacesBuild
    public void setTypeSpacesBuild(String chatID,String typeSpacesBuild){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typeSpacesBuild='"+typeSpacesBuild+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typeSpacesBuild з БД
    public String getTypeSpacesBuild(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typeSpacesBuild");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення чи встановлюється в приміщеннях оргтехніка
    public void setB1(String chatID,String b1){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set b1='"+b1+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо B1 з БД
    public String getB1(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("b1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення чи наявні технічні приміщення
    public void setB2(String chatID,String b2){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set b2='"+b2+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // встановлення kitchen
    public void setKitchen(String chatID,String kitchen){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set kitchen='"+kitchen+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо kitchen з БД
    public String getKitchen(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("kitchen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення characteristicsObject
    public void setCharacteristicsObject(String chatID,String characteristicsObject){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set characteristicsObject='"+characteristicsObject+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо characteristicsObject з БД
    public String getCharacteristicsObject(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("characteristicsObject");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення typeObjectOfRisk
    public void setTypeObjectOfRisk(String chatID,String typeObjectOfRisk){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typeObjectOfRisk='"+typeObjectOfRisk+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typeObjectOfRisk з БД
    public String getTypeObjectOfRisk(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typeObjectOfRisk");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення typeIndustrialStorageFacility
    public void setTypeIndustrialStorageFacility(String chatID,String typeIndustrialStorageFacility){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typeIndustrialStorageFacility='"+typeIndustrialStorageFacility+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typeIndustrialStorageFacility з БД
    public String getTypeIndustrialStorageFacility(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typeIndustrialStorageFacility");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення typeStateOwnedObject
    public void setTypeStateOwnedObject(String chatID,String typeStateOwnedObject){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typeStateOwnedObject='"+typeStateOwnedObject+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typeStateOwnedObject з БД
    public String getTypeStateOwnedObject(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typeStateOwnedObject");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення typeCulturalObject
    public void setTypeCulturalObject(String chatID,String typeCulturalObject){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typeCulturalObject='"+typeCulturalObject+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typeCulturalObject з БД
    public String getTypeCulturalObject(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typeCulturalObject");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення levelEmergency
    public void setLevelEmergency(String chatID,String levelEmergency){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set levelEmergency='"+levelEmergency+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо levelEmergency з БД
    public String getLevelEmergency(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("levelEmergency");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення typeResultDegreeRisk
    public void setTypeResultDegreeRisk(String chatID,String typeResultDegreeRisk){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typeResultDegreeRisk='"+typeResultDegreeRisk+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typeResultDegreeRisk з БД
    public String getTypeResultDegreeRisk(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typeResultDegreeRisk");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення usedIndoors
    public void setUsedIndoors(String chatID,String usedIndoors){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set usedIndoors='"+usedIndoors+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо usedIndoors з БД
    public String getUsedIndoors(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("usedIndoors");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення categoryBuildings
    public void setCategoryBuildings(String chatID,String categoryBuildings){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set categoryBuildings='"+categoryBuildings+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо categoryBuildings з БД
    public String getCategoryBuildings(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("categoryBuildings");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення value
    public void setValue(String chatID,String value){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set value='"+value+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо value з БД
    public String getValue(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("value");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення square
    public void setSquare(String chatID,String square){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set square='"+square+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо square з БД
    public String getSquare(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("square");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення parking
    public void setParking(String chatID,String parking){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set parking='"+parking+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо parking з БД
    public String getParking(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("parking");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення workplace
    public void setWorkplace(String chatID,String workplace){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set workplace='"+workplace+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо workplace з БД
    public String getWorkplace(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("workplace");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення squareTechnicalPremises
    public void setSquareTechnicalPremises(String chatID,String squareTechnicalPremises){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set squareTechnicalPremises='"+squareTechnicalPremises+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо squareTechnicalPremises з БД
    public String getSquareTechnicalPremises(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("squareTechnicalPremises");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення constantlyAtFacility
    public void setConstantlyAtFacility(String chatID,String constantlyAtFacility){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set constantlyAtFacility='"+constantlyAtFacility+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо constantlyAtFacility з БД
    public String getConstantlyAtFacility(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("constantlyAtFacility");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення periodicallyAtFacility
    public void setPeriodicallyAtFacility(String chatID,String periodicallyAtFacility){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set periodicallyAtFacility='"+periodicallyAtFacility+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо periodicallyAtFacility з БД
    public String getPeriodicallyAtFacility(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("periodicallyAtFacility");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення heightObject
    public void setHeightObject(String chatID,String heightObject){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set heightObject='"+heightObject+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо heightObject з БД
    public String getHeightObject(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("heightObject");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення fixedViolations
    public void setFixedViolations(String chatID,String fixedViolations){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set fixedViolations='"+fixedViolations+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо fixedViolations з БД
    public String getFixedViolations(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("fixedViolations");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення noFixedViolations
    public void setNoFixedViolations(String chatID,String noFixedViolations){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set noFixedViolations='"+noFixedViolations+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо noFixedViolations з БД
    public String getNoFixedViolations(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("noFixedViolations");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення deadPeople
    public void setDeadPeople(String chatID,String deadPeople){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set deadPeople='"+deadPeople+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо deadPeople з БД
    public String getDeadPeople(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("deadPeople");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення losses
    public void setLosses(String chatID,String losses){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set losses='"+losses+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо losses з БД
    public String getLosses(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("losses");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення taxFreeIncome
    public void setTaxFreeIncome(String chatID,String taxFreeIncome){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set taxFreeIncome='"+taxFreeIncome+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо taxFreeIncome з БД
    public String getTaxFreeIncome(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("taxFreeIncome");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення injuredPeople
    public void setInjuredPeople(String chatID,String injuredPeople){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set injuredPeople='"+injuredPeople+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо injuredPeople з БД
    public String getInjuredPeople(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("injuredPeople");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення volumePremises
    public void setVolumePremises(String chatID,String volumePremises){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set volumePremises='"+volumePremises+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо volumePremises з БД
    public String getVolumePremises(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("volumePremises");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення volumeRoomsA
    public void setVolumeRoomsA(String chatID,String volumeRoomsA){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set volumeRoomsA='"+volumeRoomsA+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо volumeRoomsA з БД
    public String getVolumeRoomsA(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("volumeRoomsA");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення volumeRoomsБ
    public void setVolumeRoomsБ(String chatID,String volumeRoomsБ){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set volumeRoomsБ='"+volumeRoomsБ+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо volumeRoomsБ з БД
    public String getVolumeRoomsБ(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("volumeRoomsБ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення volumeRoomsB
    public void setVolumeRoomsB(String chatID,String volumeRoomsB){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set volumeRoomsB='"+volumeRoomsB+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо volumeRoomsB з БД
    public String getVolumeRoomsB(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("volumeRoomsB");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення volumeRoomsГ
    public void setVolumeRoomsГ(String chatID,String volumeRoomsГ){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set volumeRoomsГ='"+volumeRoomsГ+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо volumeRoomsГ з БД
    public String getVolumeRoomsГ(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("volumeRoomsГ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }
    // встановлення humidityOfSpace
    public void setHumidityOfSpac(String chatID,String humidityOfSpace){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set humidityOfSpace='"+humidityOfSpace+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо humidityOfSpace з БД
    public String getHumidityOfSpace(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("humidityOfSpace");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }

    // встановлення typeOfObjectFireAlarm
    public void setTypeOfObjectFireAlarm(String chatID,String purposeOfObject){
        try {
            Statement statement = getConnection().createStatement();
            String sql = "UPDATE users set typeOfObjectFireAlarm='"+purposeOfObject+"' where idTelegram="+chatID;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // дістаємо typeOfObjectFireAlarm з БД
    public String getTypeOfObjectFireAlarm(String chatID){
        String typePremises= null;
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users where idTelegram ="+chatID);
            while (resultSet.next()){
                typePremises = resultSet.getString("typeOfObjectFireAlarm");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typePremises;
    }


}

