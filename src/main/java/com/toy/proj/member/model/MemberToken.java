package com.toy.proj.member.model;

import com.toy.proj.common.model.timeEntity.TimeEntity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberToken extends TimeEntity {

    @Id
    private int seq;
    private String value;
    private String type;
}
