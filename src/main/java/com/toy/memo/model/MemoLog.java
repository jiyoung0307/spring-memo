package com.toy.memo.model;

import java.time.LocalDateTime;

import com.toy.memo.model.timeEntity.CommonEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoLog extends CommonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String seq;
	private String serial;
    private String title;
    private String content;
    private int memoSeq;
    private String orgmid;
    private LocalDateTime orgdte;

}



