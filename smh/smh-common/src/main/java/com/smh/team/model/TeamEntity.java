/**
 * @Title TeamEntity.java
 * @Package com.team.model
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:38:09
 * @version : V1.0
 */

package com.smh.team.model;

import com.smh.model.Entity;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @ClassName TeamEntity
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:38:09
 */
@Data
public class TeamEntity implements Serializable, Entity {

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer teamId;

	/**
	 * 
	 */
	private String teamName;

	/**
	 * 
	 */
	private Integer teamOwnerId;

	/**
	 * 
	 */
	private String summary;

	/**
	 * 
	 */
	private Date creatTime;
}