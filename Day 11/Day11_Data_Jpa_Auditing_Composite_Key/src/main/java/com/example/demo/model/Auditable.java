package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	@CreatedBy
	@Column(updatable = false)
	private String createdBy;

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Auditable(LocalDateTime createDate, LocalDateTime modifiedDate, String createdBy) {
		super();
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
	}

	public Auditable() {
		super();
	}

	@Override
	public String toString() {
		return "Auditable [createDate=" + createDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy
				+ "]";
	}
	
	
	
}
