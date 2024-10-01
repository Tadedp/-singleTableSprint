package org.example.singleTableSpring.repositorios;

import org.example.singleTableSpring.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository <Persona, Long> {
}
