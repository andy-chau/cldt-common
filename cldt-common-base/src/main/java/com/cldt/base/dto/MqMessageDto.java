package com.cldt.base.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * The class Tpc message dto.
 *
 * @zhoukj
 */
@Data
@AllArgsConstructor
public class MqMessageDto implements Serializable {

	private static final long serialVersionUID = -995670498005087805L;
	/**
	 * 消息key
	 */
	private String messageKey;

	/**
	 * topic
	 */
	private String messageTopic;
}