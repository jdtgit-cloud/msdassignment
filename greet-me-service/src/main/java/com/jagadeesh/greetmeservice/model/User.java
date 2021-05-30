package com.jagadeesh.greetmeservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(description = "Details about the User input")
public class User {
	@ApiModelProperty(notes = "name of the user")
	private String name;
	@ApiModelProperty(notes = "surname of the user")
	private String surname;
}
