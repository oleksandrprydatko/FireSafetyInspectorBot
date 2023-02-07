package SV.FireSafety.repository;


import SV.FireSafety.model.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DatabaseRepository extends JpaRepository<Database, Long> {

    @Query(value = "select u from Database u where u.id_telegram = :telegram_id")
    Optional<Database> findByTelegramId(long telegram_id);
    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_premises = NULL,category_premises=NULL," +
            "class_fire=NULL,type_extinguisher=NULL,type_spaces_build=NULL,b1=NULL,b2=NULL,kitchen=NULL," +
            "characteristics_object=NULL,type_object_of_risk=NULL,type_state_owned_object=NULL," +
            "type_cultural_object=NULL,type_industrial_storage_facility=NULL,level_emergency=NULL,type_result_degree_risk=NULL," +
            "used_indoors='null',category_buildings=NULL,value=NULL,square=NULL,parking=NULL," +
            "workplace=NULL,square_technical_premises=NULL,constantly_at_facility=NULL," +
            "periodically_at_facility=NULL,height_object=NULL,fixed_violations=NULL,no_fixed_violations=NULL," +
            "dead_people = NULL,losses = NULL, tax_free_income = NULL, injured_people=NULL," +
            "volume_premises=NULL, volume_rooms_a=NULL, volume_rooms_б=NULL, volume_rooms_в=NULL," +
            "volume_rooms_г=NULL,hotel_rooms=NULL where inspector.users.id_telegram = :telegram_id",nativeQuery = true)
    int clearDB(long telegram_id);
    @Transactional
    @Modifying
    @Query(value = "insert  into inspector.users (id_telegram) values (:id)", nativeQuery = true)
    void setId_telegram(Long id);
    @Transactional
    @Modifying
    @Query(value = "update inspector.users set comand_of_menu = :command where id_telegram = :userId", nativeQuery = true)
    void setComand_of_menu(String command,long userId);

    @Query(value = "select comand_of_menu from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getComand_of_menu(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_premises = :command where id_telegram = :userId", nativeQuery = true)
    void setType_premises(String command,long userId);

    @Query(value = "select type_premises from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_premises(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set category_premises = :command where id_telegram = :userId", nativeQuery = true)
    void setCategory_premises(String command,long userId);

    @Query(value = "select category_premises from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getCategory_premises(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set class_fire = :command where id_telegram = :userId", nativeQuery = true)
    void setClass_fire(String command,long userId);

    @Query(value = "select class_fire from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getClass_fire(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_extinguisher = :command where id_telegram = :userId", nativeQuery = true)
    void setType_extinguisher(String command,long userId);

    @Query(value = "select type_extinguisher from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_extinguisher(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_spaces_build = :command where id_telegram = :userId", nativeQuery = true)
    void setType_spaces_build(String command,long userId);

    @Query(value = "select type_spaces_build from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_spaces_build(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set b1 = :command where id_telegram = :userId", nativeQuery = true)
    void setB1(String command,long userId);

    @Query(value = "select b1 from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getB1(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set b2 = :command where id_telegram = :userId", nativeQuery = true)
    void setB2(String command,long userId);


    @Transactional
    @Modifying
    @Query(value = "update inspector.users set characteristics_object = :command where id_telegram = :userId", nativeQuery = true)
    void setCharacteristics_object(String command,long userId);

    @Query(value = "select characteristics_object from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getCharacteristics_object(long userId);


    @Transactional
    @Modifying
    @Query(value = "update inspector.users set value = :command where id_telegram = :userId", nativeQuery = true)
    void setValue(String command,long userId);

    @Query(value = "select value from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getValue(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set square = :command where id_telegram = :userId", nativeQuery = true)
    void setSquare(String command,long userId);

    @Query(value = "select square from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getSquare(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_object_of_risk = :command where id_telegram = :userId", nativeQuery = true)
    void setType_object_of_risk(String command,long userId);

    @Query(value = "select type_object_of_risk from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_object_of_risk(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_state_owned_object = :command where id_telegram = :userId", nativeQuery = true)
    void setType_state_owned_object(String command,long userId);

    @Query(value = "select type_state_owned_object from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_state_owned_object(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_cultural_object = :command where id_telegram = :userId", nativeQuery = true)
    void setType_culture_object(String command,long userId);

    @Query(value = "select type_cultural_object from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_culture_object(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_industrial_storage_facility = :command where id_telegram = :userId", nativeQuery = true)
    void setType_industrial_storage_facility(String command,long userId);

    @Query(value = "select type_industrial_storage_facility from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_industrial_storage_facility(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set level_emergency = :command where id_telegram = :userId", nativeQuery = true)
    void setLevel_emergency(String command,long userId);

    @Query(value = "select level_emergency from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getLevel_emergency(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_result_degree_risk = :command where id_telegram = :userId", nativeQuery = true)
    void setType_result_degree_risk(String command,long userId);

    @Query(value = "select type_result_degree_risk from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_result_degree_risk(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set used_indoors = :command where id_telegram = :userId", nativeQuery = true)
    void setUsed_indoors(String command,long userId);

    @Query(value = "select used_indoors from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getUsed_indoors(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set category_buildings = :command where id_telegram = :userId", nativeQuery = true)
    void setCategory_buildings(String command,long userId);

    @Query(value = "select category_buildings from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getCategory_buildings(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set parking = :command where id_telegram = :userId", nativeQuery = true)
    void setParking(String command,long userId);

    @Query(value = "select parking from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getParking(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set workplace = :command where id_telegram = :userId", nativeQuery = true)
    void setWorkplace(String command,long userId);

    @Query(value = "select workplace from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getWorkplace(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set square_technical_premises = :command where id_telegram = :userId", nativeQuery = true)
    void setSquare_technical_premises(String command,long userId);

    @Query(value = "select square_technical_premises from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getSquare_technical_premises(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set humidity_of_space = :command where id_telegram = :userId", nativeQuery = true)
    void setHumidity_of_space(String command,long userId);

    @Query(value = "select humidity_of_space from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getHumidity_of_space(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set type_of_object_fire_alarm = :command where id_telegram = :userId", nativeQuery = true)
    void setType_of_object_fire_alarm(String command,long userId);

    @Query(value = "select type_of_object_fire_alarm from inspector.users where id_telegram = :userId ", nativeQuery = true)
    String getType_of_object_fire_alarm(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set constantly_at_facility = :command where id_telegram = :userId", nativeQuery = true)
    void setConstantly_at_facility(float command,long userId);

    @Query(value = "select constantly_at_facility from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getConstantly_at_facility(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set periodically_at_facility = :command where id_telegram = :userId", nativeQuery = true)
    void setPeriodically_at_facility(float command,long userId);

    @Query(value = "select periodically_at_facility from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getPeriodically_at_facility(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set height_object = :command where id_telegram = :userId", nativeQuery = true)
    void setHeight_object(float command,long userId);

    @Query(value = "select height_object from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getHeight_object(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set fixed_violations = :command where id_telegram = :userId", nativeQuery = true)
    void setFixed_violations(float command,long userId);

    @Query(value = "select fixed_violations from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getFixed_violations(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set no_fixed_violations = :command where id_telegram = :userId", nativeQuery = true)
    void setNo_fixed_violations(float command,long userId);

    @Query(value = "select no_fixed_violations from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getNo_fixed_violations(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set dead_people = :command where id_telegram = :userId", nativeQuery = true)
    void setDead_people(float command,long userId);

    @Query(value = "select dead_people from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Integer getDead_people(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set losses = :command where id_telegram = :userId", nativeQuery = true)
    void setLosses(float command,long userId);

    @Query(value = "select losses from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getLosses(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set tax_free_income = :command where id_telegram = :userId", nativeQuery = true)
    void setTax_free_income(float command,long userId);

    @Query(value = "select tax_free_income from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getTax_free_income(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set injured_people = :command where id_telegram = :userId", nativeQuery = true)
    void setInjured_people(float command,long userId);

    @Query(value = "select injured_people from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getInjured_people(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set volume_premises = :command where id_telegram = :userId", nativeQuery = true)
    void setVolume_premises(float command,long userId);

    @Query(value = "select volume_premises from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getVolume_premises(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set volume_rooms_a = :command where id_telegram = :userId", nativeQuery = true)
    void setVolume_rooms_a(float command,long userId);

    @Query(value = "select volume_rooms_a from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getVolume_rooms_a(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set volume_rooms_б = :command where id_telegram = :userId", nativeQuery = true)
    void setVolume_rooms_б(float command,long userId);

    @Query(value = "select volume_rooms_б from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getVolume_rooms_б(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set volume_rooms_в = :command where id_telegram = :userId", nativeQuery = true)
    void setVolume_rooms_в(float command,long userId);

    @Query(value = "select volume_rooms_в from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getVolume_rooms_в(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set volume_rooms_г = :command where id_telegram = :userId", nativeQuery = true)
    void setVolume_rooms_г(float command,long userId);

    @Query(value = "select volume_rooms_г from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Float getVolume_rooms_г(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set kitchen = :command where id_telegram = :userId", nativeQuery = true)
    void setKitchen(Integer command,long userId);

    @Query(value = "select kitchen from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Integer getKitchen(long userId);

    @Transactional
    @Modifying
    @Query(value = "update inspector.users set hotel_rooms = :command where id_telegram = :userId", nativeQuery = true)
    void setHotel_rooms(int command,long userId);

    @Query(value = "select hotel_rooms from inspector.users where id_telegram = :userId ", nativeQuery = true)
    Integer getHotel_rooms(long userId);





}
