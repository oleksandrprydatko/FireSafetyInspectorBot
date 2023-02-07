package SV.FireSafety.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "inspector")
public class Database {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_telegram;

    private String comand_of_menu,type_premises,category_premises,class_fire,
            type_extinguisher,type_spaces_build,b1,b2,characteristics_object,type_object_of_risk,
            type_state_owned_object,type_cultural_object,type_industrial_storage_facility,level_emergency,
            type_result_degree_risk,used_indoors,category_buildings,value,parking,workplace,
            humidity_of_space,type_of_object_fire_alarm;
    private Integer kitchen,dead_people,hotel_rooms;
    private Float constantly_at_facility,periodically_at_facility,height_object,fixed_violations,no_fixed_violations,
          losses,tax_free_income,injured_people,volume_premises,volume_rooms_a,volume_rooms_б,volume_rooms_в,volume_rooms_г,square,square_technical_premises;

    public Database() {

    }

    public Database(Long id_telegram){
        this.id_telegram = id_telegram;
    }
}
