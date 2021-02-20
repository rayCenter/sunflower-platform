package com.center.view.common.extract;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class AbstractVo implements Serializable {

    private String id;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

}
