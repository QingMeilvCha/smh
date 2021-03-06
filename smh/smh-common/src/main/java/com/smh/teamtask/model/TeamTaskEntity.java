/**
 * @Title TeamTaskEntity.java
 * @Package com.teamtask.model
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:36:46
 * @version : V1.0
 */

package com.smh.teamtask.model;

import com.smh.model.Entity;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @ClassName TeamTaskEntity
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:36:46
 */
@Data
public class TeamTaskEntity implements Serializable, Entity {

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer teamTaskId;

	/**
	 * 
	 */
	private Integer teamId;

	/**
	 * 
	 */
	private Integer dataId;

	/**
	 * 
	 */
	private String taskType;

	/**
	 * 
	 */
	private Date creatTime;
}