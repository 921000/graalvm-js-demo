package cn.dgj.service;

import cn.dgj.entity.CalculationParam;
import org.graalvm.polyglot.Value;

public interface FormulaService {

    /**
     * 计算
     * @param request
     * @return
     */
    String calculate(CalculationParam request);
}
