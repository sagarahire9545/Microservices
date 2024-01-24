package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

@Entity
@Table(name = "Hotels")
public class Hotel {

	@Id
	@Column(name = "HotelId")
	private String id;

	
	@Column(name = "Hotel_Name")
	private String name;

	@Column(name = "Hotel_Location")
	private String location;

	@Column(name = "About")
	private String about;

}
