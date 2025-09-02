package com.example.OrderService.Entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@CreatedDate
	private Instant createdOn;
	
	@LastModifiedDate
	private Instant updatedOn;
	
	@PrePersist
	public void created() {
		Instant time = Instant.now();
		this.createdOn=time;
		this.updatedOn=time;
	}
	
	@PreUpdate
	public void update() {
		this.updatedOn=Instant.now();
	}
}
