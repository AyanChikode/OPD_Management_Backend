package com.OPD_Management_Backend.OPD_Management_Backend.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OPD_Management_Backend.OPD_Management_Backend.dtos.DoctorDto;

import com.OPD_Management_Backend.OPD_Management_Backend.entities.Doctor;
import com.OPD_Management_Backend.OPD_Management_Backend.entities.Role;
import com.OPD_Management_Backend.OPD_Management_Backend.repositories.PatientRepository;
import com.OPD_Management_Backend.OPD_Management_Backend.services.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:5173")
public class DoctorController {

    @Autowired
    private DoctorService service;
    
    @Autowired
    private PatientRepository patientrepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // REGISTER DOCTOR

    @PostMapping("/register")
    public ResponseEntity<Doctor> saveDoctor(
            @Valid @RequestBody DoctorDto dto
    ) {

        Doctor doctor = new Doctor();

        doctor.setName(dto.getName());

        doctor.setEmail(dto.getEmail());

        doctor.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );

        doctor.setSpecialization(dto.getSpecialization());

        doctor.setClinic_name(dto.getClinic_name());

        doctor.setAddress(dto.getAddress());

        doctor.setMobileNo(dto.getMobileNo());

        doctor.setToken(dto.getToken());

        doctor.setStatus(dto.getStatus());

        doctor.setQulification(dto.getQulification());

        doctor.setCreated_at(LocalDateTime.now());

        doctor.setUpdated_at(LocalDateTime.now());

        doctor.setRole(Role.DOCTOR);

        Doctor saveDoctor = service.saveDoctor(doctor);

        return new ResponseEntity<>(
                saveDoctor,
                HttpStatus.CREATED
        );
    }

    // GET ALL DOCTORS

    @GetMapping("/list")
    public ResponseEntity<List<Doctor>> getAllDoctor() {

        try {

            List<Doctor> doctor = service.getAllDoctor();

            if (doctor == null || doctor.isEmpty()) {

                return new ResponseEntity<>(
                        HttpStatus.NOT_FOUND
                );
            }

            return new ResponseEntity<>(
                    doctor,
                    HttpStatus.OK
            );

        }

        catch (Exception e) {

            return new ResponseEntity<>(
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    // GET DOCTOR BY ID

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(
            @PathVariable("id") int id
    ) {

        Doctor doctor = service.getDoctorById(id);

        if (doctor == null) {

            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }

        return new ResponseEntity<>(
                doctor,
                HttpStatus.OK
        );
    }

    // UPDATE DOCTOR

    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctorById(
            @PathVariable("id") int id,
            @Valid @RequestBody DoctorDto dto
    ) {

        Doctor doctor = service.getDoctorById(id);

        if (doctor == null) {

            return new ResponseEntity<>(
                    HttpStatus.NOT_FOUND
            );
        }

        doctor.setName(dto.getName());

        doctor.setEmail(dto.getEmail());

        doctor.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );

        doctor.setSpecialization(dto.getSpecialization());

        doctor.setQulification(dto.getQulification());

        doctor.setClinic_name(dto.getClinic_name());

        doctor.setAddress(dto.getAddress());

        doctor.setMobileNo(dto.getMobileNo());

        doctor.setToken(dto.getToken());
        
		doctor.setRole(Role.DOCTOR);    


        doctor.setStatus(dto.getStatus());

        doctor.setUpdated_at(LocalDateTime.now());

        Doctor updateDoctor = service.saveDoctor(doctor);

        return new ResponseEntity<>(
                updateDoctor,
                HttpStatus.OK
        );
    }

    // DELETE DOCTOR

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDoctorById(
            @PathVariable("id") int id
    ) {

        try {

            Doctor doctor = service.getDoctorById(id);

            if (doctor == null) {

                return new ResponseEntity<>(
                        HttpStatus.NOT_FOUND
                );
            }

            service.deleteDoctorById(id);

            return ResponseEntity.ok(
                    "Doctor Deleted Successfully"
            );

        } catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body(
                        "Doctor has assigned patients"
                    );
        }
    }
}