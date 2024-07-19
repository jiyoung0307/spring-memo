package com.toy.memo.model.timeEntity;

import java.time.LocalDateTime;

public interface TimeAuditable {

    LocalDateTime getCrdte();
    LocalDateTime getUpdte();

    void setCrdte(LocalDateTime crdte);
    void setUpdte(LocalDateTime updte);
}
