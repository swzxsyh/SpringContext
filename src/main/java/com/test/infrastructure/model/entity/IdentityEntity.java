package com.test.infrastructure.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author swzxsyh
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class IdentityEntity extends BaseEntity implements Serializable {

    private String identity;

    private String name;

    private String  crateName;

    private String updateName;
}