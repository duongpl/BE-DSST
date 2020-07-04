package com.fpt.edu.schedule.repository.base;

import com.fpt.edu.schedule.model.History;
import com.fpt.edu.schedule.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Long>, JpaSpecificationExecutor<History> {

    History save(History history);

    List<History> findAllBySemester(Semester semester);
}
