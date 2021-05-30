package com.jagadeesh.usertreeservice.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode(of = {"name"})
@NoArgsConstructor
@AllArgsConstructor
public class UserNest {
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Sub Classes")
	@JsonInclude(value = Include.NON_NULL)
	private List<UserNest> subClasses;
}
