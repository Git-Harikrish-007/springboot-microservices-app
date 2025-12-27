package com.harikrish.organizationservice.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Organization Service Model Representation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

	private Long id;

	@Schema(description = "Organization Name")
	private String organizationName;

	@Schema(description = "Organization Description")
	private String organizationDescription;

	@Schema(description = "Organization Code")
	private String organizationCode;

	@Schema(description = "Organization Created Date")
	private LocalDateTime createdDate;

}
