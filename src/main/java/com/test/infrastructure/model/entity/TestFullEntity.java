package com.test.infrastructure.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author test
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestFullEntity extends IdentityEntity implements Serializable {

    private String testCode;
}
