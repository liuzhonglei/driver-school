package com.drivers.router.service.impl;

import com.drivers.entity.Trade;
import com.drivers.router.repository.TradeRepository;
import com.drivers.router.service.TradeService;
import com.drivers.router.web.request.TradeReq;
import com.drivers.router.web.response.base.PagerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhuji on 2016/11/25.
 */
@Service
@Transactional
@Slf4j
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    @Override
    public void findAllBySearch(TradeReq request, PagerResponse<Trade> response) {
        Long count = tradeRepository.countBySearch(request);
        List<Trade> cadetResps = tradeRepository.findAllBySearch(request);
        response.setTotal(count);
        response.setRows(cadetResps);
    }
}
