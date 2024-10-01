package org.example.singleTableSpring.repositorios;

import org.example.singleTableSpring.entidades.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository <Alumno, Long> {
}
