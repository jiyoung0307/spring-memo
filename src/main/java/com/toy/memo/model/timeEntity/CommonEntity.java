package com.toy.memo.model.timeEntity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonEntity implements TimeAuditable {

	private String crmid;
    @CreatedDate
    private LocalDateTime crdte;
    private String upmid;
    @LastModifiedDate
    private LocalDateTime updte;
}
