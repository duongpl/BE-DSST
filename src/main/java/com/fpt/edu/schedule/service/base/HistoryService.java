package com.fpt.edu.schedule.service.base;

import com.fpt.edu.schedule.model.History;
import com.fpt.edu.schedule.model.Request;
import com.fpt.edu.schedule.repository.base.QueryParam;

public interface HistoryService {
    History addHistory(History history);

    QueryParam.PagedResultSet<History> findByCriteria(QueryParam queryParam);
}
