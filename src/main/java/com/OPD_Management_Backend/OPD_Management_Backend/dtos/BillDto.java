package com.OPD_Management_Backend.OPD_Management_Backend.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BillDto {
	
	@NotNull(message = "Consultation fee is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Consultation fee must be greater than 0")
	private BigDecimal consultation_fee;
	
	@NotBlank(message = "Payment status is required")
    @Pattern(
        regexp = "^(PAID|UNPAID|PENDING)$",
        message = "Payment status must be PAID, UNPAID, or PENDING"
    )
	private String payment_status;
	
	@NotBlank(message = "Payment mode is required")
    @Pattern(
        regexp = "^(CASH|UPI|CARD|ONLINE)$",
        message = "Payment mode must be CASH, UPI, CARD, or ONLINE"
    )
	private String payment_mode;
	
	@NotNull(message = "Concession value is required")
    @DecimalMin(value = "0.0", message = "Concession cannot be negative")
	private BigDecimal concession;
	
	@NotNull(message = "Paid amount is required")
    @DecimalMin(value = "0.0", message = "Paid amount cannot be negative")
	private BigDecimal paid_amount;
	
	@NotNull(message = "Total amount is required")
    @DecimalMin(value = "0.0", message = "Total amount cannot be negative")
	private BigDecimal total_amount;
	
	@NotNull(message = "Pending amount is required")
    @DecimalMin(value = "0.0", message = "Pending amount cannot be negative")
	private BigDecimal pending_amount;
	

	
	@NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int visitid;
}
