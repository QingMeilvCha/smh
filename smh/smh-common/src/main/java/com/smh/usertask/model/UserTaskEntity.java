/**
 * @Title UserTaskEntity.java
 * @Package com.usertask.model
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:05
 * @version : V1.0
 */

package com.smh.usertask.model;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName UserTaskEntity
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:37:05
 */
@Data
public class UserTaskEntity {

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer userTaskId;

	/**
	 * 
	 */
	private Integer userId;

	/**
	 * 
	 */
	private String dataId;

	/**
	 *
	 */
	private String taskName;

	/**
	 * 
	 */
	private String taskType;

	/**
	 * 
	 */
	private Date creatTime;
}