/**
 * @Title UserEntity.java
 * @Package com.user.model
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 * @version : V1.0
 */

package com.smh.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName UserEntity
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:28:51
 */
@Data
public class UserEntity {

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer userId;

	/**
	 * 
	 */
	private String userName;

	/**
	 * 
	 */
	private String sex;

	/**
	 * 
	 */
	private Integer age;

	/**
	 * 
	 */
	private String email;

	/**
	 * 
	 */
	private String phoneNumber;
}