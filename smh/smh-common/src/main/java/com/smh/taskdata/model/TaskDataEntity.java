/**
 * @Title TaskDataEntity.java
 * @Package com.taskdata.model
 * @Description 
 * @author zhouyuhang
 * @date 2018-12-14 16:48:21
 * @version : V1.0
 */

package com.smh.taskdata.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName TaskDataEntity
 * @Description Service
 * @author zhouyuhang
 * @date 2018-12-14 16:48:21
 */
@Data
public class TaskDataEntity {

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
	private String dataId;

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
	private BigDecimal postDistanceUp;

	/**
	 *
	 */
	private BigDecimal postDistanceBottm;

	/**
	 * 
	 */
	private BigDecimal postDistance;

	/**
	 * 
	 */
	private BigDecimal preDistanceUo;

	/**
	 *
	 */
	private BigDecimal preDistance;

	/**
	 * 
	 */
	private BigDecimal preDistanceBottm;

	/**
	 * 
	 */
	private BigDecimal distanceReduce;

	/**
	 * 
	 */
	private BigDecimal accDistance;

	/**
	 * 
	 */
	private BigDecimal postBlack;

	/**
	 * 
	 */
	private BigDecimal preBlack;

	/**
	 * 
	 */
	private BigDecimal postRed;

	/**
	 * 
	 */
	private BigDecimal preRed;
}