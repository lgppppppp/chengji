package edu.ait.utils;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@MappedSuperclass
// 不是完整的数据库表中不会映射
public class Audited {

	@Id
	@Column(name = "id")
	private String id;

	@CreatedBy
	protected String createdBy;
	@CreatedDate
	protected Calendar createdDate;

	@LastModifiedBy
	protected String modifiedBy;
	@LastModifiedDate
	protected Calendar modifiedDate;

	public Integer flag;

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 
	 * @Description: 插入
	 */
	@PrePersist
	public void createAuditInfo() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (null != context.getAuthentication() && !context.getAuthentication().isAuthenticated()) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			setCreatedBy(null == userDetails ? "" : userDetails.getUsername());
		}
		setCreatedDate(Calendar.getInstance());
		String id = UUID.randomUUID().toString().replaceAll("-", "");
		this.setId(id);
		this.setFlag(1);// 默认初始化
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @Description: 当更新记录
	 */
	@PreUpdate
	public void updateAuditInfo() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (null != context.getAuthentication() && !context.getAuthentication().isAuthenticated()) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			setModifiedBy(null == userDetails ? "" : userDetails.getUsername());
		}
		setModifiedDate(Calendar.getInstance());
	}

}
