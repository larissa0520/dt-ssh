package com.xll.dt.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 定时执行日志
 * 
 */
@Entity
@Table(name="schedule_job_log")
public class ScheduleJobLog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 日志id
	 */
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="log_id")
	private Long logId;
	
	/**
	 * 任务id
	 */
	@Column(name="job_id")
	private Long jobId;
	
	/**
	 * spring bean名称
	 */
	@Column(name="bean_name")
	private String beanName;
	
	/**
	 * 方法名
	 */
	@Column(name="method_name")
	private String methodName;
	
	/**
	 * 参数
	 */
	@Column(name="params")
	private String params;
	
	/**
	 * 任务状态    0：成功    1：失败
	 */
	@Column(name="status")
	private Byte status;
	
	/**
	 * 失败信息
	 */
	@Column(name="error")
	private String error;
	
	/**
	 * 耗时(单位：毫秒)
	 */
	@Column(name="times")
	private Long times;
	
	/**
	 * 创建时间
	 */
	@Column(name="create_time")
	private Date createTime;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
