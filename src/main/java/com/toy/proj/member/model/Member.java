package com.toy.proj.member.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

    private String id;
    private String password;
    private String email;
    private String group; // groupA,groupB,groupC....
}
