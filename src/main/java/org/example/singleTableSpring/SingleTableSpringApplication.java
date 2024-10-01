package org.example.singleTableSpring;

import org.example.singleTableSpring.repositorios.AlumnoRepository;
import org.example.singleTableSpring.repositorios.PersonaRepository;
import org.example.singleTableSpring.repositorios.ProfesorRepository;
import org.example.singleTableSpring.entidades.Profesor;
import org.example.singleTableSpring.entidades.Alumno;
import org.example.singleTableSpring.enumeraciones.Especialidades;
import org.example.singleTableSpring.enumeraciones.Titulos;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication

public class SingleTableSpringApplication {
	private static final Logger logger = LoggerFactory.getLogger(SingleTableSpringApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private AlumnoRepository alumnoRepository;
	public static void main(String[] args) {
		SpringApplication.run(SingleTableSpringApplication.class, args);

		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository,
						   AlumnoRepository alumnoRepository,
						   ProfesorRepository profesorRepository) {
		return args -> {

			LocalDate fechaIngreso = LocalDate.of(2022, 1, 1);
			BigDecimal sueldo = new BigDecimal("123.45");

			Profesor pro1 = Profesor.builder()
					.nombre("Alberto")
					.apellido("Perez")
					.cantHijos(2)
					.fechaIngreso(fechaIngreso)
					.sueldo(sueldo)
					.titulo(Titulos.MASTER)
					.build();

			profesorRepository.save(pro1);

			fechaIngreso = LocalDate.of(2020, 2, 20);
			sueldo = new BigDecimal("150.11");

			Profesor pro2 = Profesor.builder()
					.nombre("Daniel")
					.apellido("Lillo")
					.cantHijos(0)
					.fechaIngreso(fechaIngreso)
					.sueldo(sueldo)
					.titulo(Titulos.INGENIERO)
					.build();

			profesorRepository.save(pro2);

			Alumno al1 = Alumno.builder()
					.nombre("Tadeo")
					.apellido("Drube")
					.legajo(62222)
					.especialidad(Especialidades.PERITO_MERCANTIL)
					.build();

			alumnoRepository.save(al1);

			Alumno al2 = Alumno.builder()
					.nombre("Victoria")
					.apellido("Torres")
					.legajo(62100)
					.especialidad(Especialidades.BACHILLER)
					.build();

			alumnoRepository.save(al2);
		};
	};
}
