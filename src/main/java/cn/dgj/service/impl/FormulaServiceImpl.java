package cn.dgj.service.impl;

import cn.dgj.entity.CalculationParam;
import cn.dgj.service.FormulaService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

@Singleton
public class FormulaServiceImpl implements FormulaService {

    private final String customScriptPath;

    /**
     * 获取js 文件
     */
    @Inject
    public FormulaServiceImpl() {
        this.customScriptPath = getResourcePath("scripts/demo.js");
    }

    private String getResourcePath(String resourceName) {
        try {
            URL resourceUrl = getClass().getClassLoader().getResource(resourceName);
            if (resourceUrl != null) {
                File file = new File(resourceUrl.toURI());
                return file.getAbsolutePath();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Resource not found: " + resourceName);
    }

    @Override
    public String calculate(CalculationParam request){
        String formula = request.getFormula();
        double a1 = request.getA1();
        double a2 = request.getA2();

        try (Context context = Context.newBuilder("js").build()) {
            // 加载自定义的JavaScript文件
            File file  = new File(customScriptPath);
            Source customScript = Source.newBuilder("js", file).build();
            context.eval(customScript);

            // 找到js 中的函数并执行
            context.getBindings("js").putMember("A1",a1);
            context.getBindings("js").putMember("A2",a2);
            Value result = context.eval("js", formula);
            // 将计算结果返
            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
