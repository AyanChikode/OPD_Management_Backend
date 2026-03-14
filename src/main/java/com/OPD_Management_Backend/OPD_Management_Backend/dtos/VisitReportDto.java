package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class VisitReportDto {
	@NotBlank(message = "File name is required")
	private String file_name;
	@NotBlank(message = "file_url is required")
	private String file_url;
	@NotBlank(message = "file_type is required")
	private String file_type;
	 @NotNull(message = "Id must be required")
	private int visitid;
}
