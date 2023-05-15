package com.joe.roomBooking.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NonNull;

@Data
public class TestBean {

	@NonNull
	@JsonProperty("string")
	private String str;
}
