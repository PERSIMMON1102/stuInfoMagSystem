package com.sdyk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author wjd
 * @since 2024-11-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    private String mname;

    private String level;

    private String sex;

    private Integer age;

    private LocalDateTime regtime;


}
