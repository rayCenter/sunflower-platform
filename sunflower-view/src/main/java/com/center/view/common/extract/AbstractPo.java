package com.center.view.common.extract;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class AbstractPo implements Serializable {

    @Id
    /*JPA标准-主键标识*/
    @GeneratedValue(generator = "uuid2")
    /*JPA标准-通用策略生成器*/
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    /*自定义主键生成策略*/
    @Column(name = "id", unique = true, nullable = false, length = 36, columnDefinition = "varchar(36) comment '非业务，主键'")
    private String id;

    @Column(name = "create_time", nullable = false, columnDefinition = "datetime comment '创建时间'")
    private LocalDateTime createTime;

    @Column(name = "modify_time", nullable = false, columnDefinition = "datetime comment '修改时间'")
    private LocalDateTime modifyTime;

}
