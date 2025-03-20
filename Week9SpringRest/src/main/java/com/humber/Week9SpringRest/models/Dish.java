package com.humber.Week9SpringRest.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    @Embedded //Cuisine.java is embedded in Dish.java
    private Cuisine cuisine;

    // 1対多の関係を示す。
    @ManyToOne
    @JoinColumn(name = "fk_category_id")
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE})
//    CascadeType.PERSIST: 親エンティティが保存（persist）されると、関連する子エンティティも自動的に保存されます。
//    CascadeType.MERGE: 親エンティティがマージ（merge）されると、関連する子エンティティも自動的にマージされます。
    private Category category;
}
