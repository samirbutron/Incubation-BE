package com.mx.Incubation.repository;

import com.mx.Incubation.entity.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareDao extends JpaRepository<Hardware, Integer> {

}
