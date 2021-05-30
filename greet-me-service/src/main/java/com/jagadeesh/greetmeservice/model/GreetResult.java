package com.jagadeesh.greetmeservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Description about Greeting Result")
public class GreetResult {
	@ApiModelProperty(notes = "This is composed and formatted using the User input")
	private String composedGreeting;
}
