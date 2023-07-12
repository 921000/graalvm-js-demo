package cn.dgj.controller;

import cn.dgj.entity.CalculationParam;
import cn.dgj.entity.ReturnT;
import cn.dgj.service.FormulaService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import org.graalvm.polyglot.Value;

@Controller("formula")
public class FormulaController {

    private final FormulaService formulaService;

    @Inject
    public FormulaController(FormulaService formulaService) {
        this.formulaService = formulaService;
    }

    @Post(value = "calculate",consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ReturnT<String> calculateFormula(@Body CalculationParam request) {
        try {
            String result = formulaService.calculate(request);
            return ReturnT.success(result);
        } catch (Exception e) {
            return ReturnT.failedMsg(e.getMessage());
        }
    }
}
