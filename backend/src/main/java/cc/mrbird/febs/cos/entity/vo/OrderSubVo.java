package cc.mrbird.febs.cos.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderSubVo {

    /**
     * 所属销售店
     */
    private Integer pharmacyId;

    /**
     * 农产品ID
     */
    private Integer drugId;

    /**
     * 购买数量
     */
    private BigDecimal total;

    /**
     * 单价
     */
    private BigDecimal unitPrice;
}
