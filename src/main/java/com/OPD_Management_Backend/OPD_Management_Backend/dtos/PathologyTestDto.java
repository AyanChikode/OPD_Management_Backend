package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PathologyTestDto {

	@NotBlank(message = "Result is required")
	private String result;
	@NotBlank(message = "Result is required")
	private String remarks;
	@NotBlank(message = "Result is required")
	private String report_file;
	private LocalDateTime created_at;
	@NotNull(message = "id is required")
	private int visitid;
	@NotNull(message = "id is required")
	private int testMasterid;
}
