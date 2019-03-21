package com.cldt.zk.generator;

/**
 * The interface Id generator.
 *
 * @zhoukj
 */
public interface IdGenerator {

	/**
	 * 生成下一个ID
	 *
	 * @return the string
	 */
	Long nextId();
}
