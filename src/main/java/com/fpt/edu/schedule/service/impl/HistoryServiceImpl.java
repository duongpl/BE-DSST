package com.fpt.edu.schedule.service.impl;

import com.fpt.edu.schedule.model.History;
import com.fpt.edu.schedule.repository.base.HistoryRepository;
import com.fpt.edu.schedule.repository.base.QueryParam;
import com.fpt.edu.schedule.service.base.HistoryService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    HistoryRepository historyRepository;

    @Override
    public History addHistory(History history) {
          return historyRepository.save(history);
    }

    @Override
    public QueryParam.PagedResultSet<History> findByCriteria(QueryParam queryParam) {
        return null;
    }
}
