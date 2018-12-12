/**
 * @Title UserTeamEntity.java
 * @Package com.userteam.model
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:40
 * @version : V1.0
 */

package com.userteam.model;

import lombok.Data;

/**
 * @ClassName UserTeamEntity
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:37:40
 */
@Data
public class UserTeamEntity {

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer userTeamId;

	/**
	 * 
	 */
	private Integer userId;

	/**
	 * 
	 */
	private Integer teamId;

	/**
	 * 0是成员，1是团队所有者
	 */
	private Integer role;
}