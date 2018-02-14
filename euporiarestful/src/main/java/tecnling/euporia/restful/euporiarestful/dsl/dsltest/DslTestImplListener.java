package tecnling.euporia.restful.euporiarestful.dsl.dsltest;

import org.antlr.runtime.ANTLRInputStream;

public class DslTestImplListener extends DslTestBaseListener{

    @Override
    public void enterMf(DslTestParser.MfContext ctx){
        System.out.println(ctx.getText());

        new ANTLRInputStream();
    }
}
