package com.toy.memo.model.dto;

import lombok.Getter;

import java.util.List;

import com.toy.memo.model.JopPost;

@Getter
public class JopPostDetailRes {

    private Long jopPostNo;
    private String position;
    private Long reward;
    private String techStack;
    private String content;

    private String companyName;
    private String companyCountry;
    private String companyCity;

    private List<Long> jopPostNoList;

    public JopPostDetailRes(JopPost jopPost, List<Long> jopPostNoList) {
        this.jopPostNo = jopPost.getNo();
        this.position = jopPost.getPosition();
        this.reward = jopPost.getReward();
        this.techStack = jopPost.getTechStack();
        this.content = jopPost.getContent();

        this.companyName = jopPost.getCompany().getName();
        this.companyCountry = jopPost.getCompany().getCountry();
        this.companyCity = jopPost.getCompany().getCity();

        this.jopPostNoList = jopPostNoList;
    }
}
