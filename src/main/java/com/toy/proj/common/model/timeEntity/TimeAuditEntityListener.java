package com.toy.proj.common.model.timeEntity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class TimeAuditEntityListener {

    @PrePersist // Persist(insert)메서드가 호출되기 전에 실행되는 메서드
    public void prevInsert(Object obj) {
        if(obj instanceof TimeAuditable) ((TimeAuditable) obj).setCrdte(LocalDateTime.now());
    }

    @PreUpdate // merge메서드가 호출되기 전에 실행되는 메서드
    public void prevUpdate(Object obj) {
        if(obj instanceof TimeAuditable) ((TimeAuditable) obj).setUpdte(LocalDateTime.now());
    }
}
