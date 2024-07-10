package com.toy.memo.model.dto;

import com.toy.memo.model.JopPost;

import lombok.Getter;

@Getter
public class JopPostListRes {

    private Long jopPostNo;
    private String position;
    private Long reward;
    private String techStack;

    private String companyName;
    private String companyCountry;
    private String companyCity;

    public JopPostListRes(JopPost jopPost) {
        this.jopPostNo = jopPost.getNo();
        this.position = jopPost.getPosition();
        this.reward = jopPost.getReward();
        this.techStack = jopPost.getTechStack();

        this.companyName = jopPost.getCompany().getName();
        this.companyCountry = jopPost.getCompany().getCountry();
        this.companyCity = jopPost.getCompany().getCity();
    }
}
