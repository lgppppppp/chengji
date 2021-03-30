package edu.ait.listnames.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.ait.listnames.dto.Name;

public interface NameRepository extends JpaRepository<Name, Integer> {  
}

