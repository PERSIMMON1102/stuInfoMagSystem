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
public class Checkitem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String stuid;

    private String name;

    private String sex;

    private String age;

    private String ethnicity;

    /**
     * 查检项类型,分为检查和检验两种
     */
    private String type;

    private String hometown;

    private String politicalstatus;


}
