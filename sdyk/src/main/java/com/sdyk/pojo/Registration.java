package com.sdyk.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String stuid;

    private Integer coursecode;

    private String term;

    private String grade;


}
