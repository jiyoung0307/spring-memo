package com.toy.memo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(columnDefinition = "varchar(100) comment '회사명'", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(100) comment '국가'", nullable = false)
    private String country;

    @Column(columnDefinition = "varchar(100) comment '지역'", nullable = false)
    private String city;

}



