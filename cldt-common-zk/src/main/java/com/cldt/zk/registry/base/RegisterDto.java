package com.cldt.zk.registry.base;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * The class Register dto.
 *
 * @zhoukj
 */
@Data
@AllArgsConstructor
public class RegisterDto {

	private String app;

	private String host;

	private CoordinatorRegistryCenter coordinatorRegistryCenter;

}
