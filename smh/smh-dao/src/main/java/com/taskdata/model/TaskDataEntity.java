/**
 * @Title TaskDataEntity.java
 * @Package com.taskdata.model
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-12 16:37:55
 * @version : V1.0
 */

package com.taskdata.model;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @ClassName TaskDataEntity
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-12 16:37:55
 */
@Data
public class TaskDataEntity{

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer recordId;

	/**
	 * 取user_task的id或者team_task的id
	 */
	private Integer dataId;

	/**
	 * 
	 */
	private Integer pointNumber;

	/**
	 * 0是非控制点，1是控制点，默认0

	 */
	private String controlPoint;

	/**
	 * 
	 */
	private BigDecimal elevation;

	/**
	 * 
	 */
	private BigDecimal preDistance;

	/**
	 * 
	 */
	private BigDecimal postDistance;
}