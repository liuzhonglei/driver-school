package com.drivers.weixin.web.response;

import com.drivers.entity.CashierPay;
import com.drivers.entity.CashierPayRecord;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 支付数据dto
 * @author liangb
 * @version 1.0
 * @date 16/6/30 上午9:55
 */
@Data
@NoArgsConstructor
public class CashierPayDataResp {
    private CashierPay cashierPay;
    private CashierPayRecord cashierPayRecord;
    public CashierPayDataResp(CashierPay cashierPay, CashierPayRecord cashierPayRecord){
        this.cashierPay = cashierPay;
        this.cashierPayRecord = cashierPayRecord;
    }

}
