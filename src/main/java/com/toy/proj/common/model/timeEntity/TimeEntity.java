package com.toy.proj.common.model.timeEntity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass // 자식 class에 부모 class의 field를 column으로 생성시켜줌
@EntityListeners(AuditingEntityListener.class)
public class TimeEntity implements TimeAuditable {

	protected String crmid;
    @CreatedDate
    protected LocalDateTime crdte;
    protected String upmid;
    @LastModifiedDate
    protected LocalDateTime updte;
}
