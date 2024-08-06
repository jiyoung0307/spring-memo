package com.toy.proj.member.model;

import com.toy.proj.common.model.timeEntity.TimeEntity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member extends TimeEntity {

    @Id
    private String id;
    private String password;
    private String email;
    private String group; // groupA,groupB,groupC....
}
