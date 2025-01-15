package com.sdyk.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("userrole")
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer uid;

    private Integer roleid;


}
