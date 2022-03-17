package com.application.repositories;

import com.application.models.ProcessusStage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessusStageRepository extends JpaRepository<ProcessusStage, String> {
    ProcessusStage findByCode(String code);
}
