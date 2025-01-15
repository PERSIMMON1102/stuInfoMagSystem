package com.sdyk.pojo;

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
public class Rolepersion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roleid;

    private Integer pid;


}
