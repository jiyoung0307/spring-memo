package com.toy.memo.model;

import java.util.Objects;

import com.toy.memo.common.CommonUtil;
import com.toy.memo.model.timeEntity.CommonEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Memo extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seq; // seq는 안바뀜 serial은 바뀜 그래서 seq가 있어야함
    private String serial;
    private String title;
    private String content;
    private Boolean locked;
    private int dirSeq;

	public Memo() {
		serial = CommonUtil.getSaltString();
		dirSeq = 1;
	}
	
    public MemoLog toLog() {
    	return MemoLog.builder()
    			.serial(serial)
    			.title(title)
    			.content(content)
    			.memoSeq(seq)
    			// 업데이트 내역이 없으면 생성 mid, 일자로 로그 생성
    			.orgmid(Objects.isNull(upmid) ? crmid : upmid)
    			.orgdte(Objects.isNull(updte) ? crdte : updte)
    			.build();
    }
    
    public Memo update(Memo newMemo) {
    	serial = CommonUtil.getSaltString();
    	title = newMemo.getTitle();
    	content = newMemo.getContent();
    	locked = newMemo.getLocked();
    	dirSeq = newMemo.getDirSeq();
    	
    	return this;
    }
}



