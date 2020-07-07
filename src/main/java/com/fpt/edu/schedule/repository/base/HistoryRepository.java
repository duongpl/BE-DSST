package com.fpt.edu.schedule.repository.base;

import com.fpt.edu.schedule.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface HistoryRepository extends JpaRepository<History,Long>, JpaSpecificationExecutor<History> {

    History save(History history);
}
