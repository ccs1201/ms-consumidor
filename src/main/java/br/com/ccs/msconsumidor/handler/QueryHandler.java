package br.com.ccs.msconsumidor.handler;

import br.com.messagedispatcher.annotation.MessageListener;
import br.com.messagedispatcher.annotation.Query;
import lombok.RequiredArgsConstructor;

import java.util.random.RandomGenerator;

@RequiredArgsConstructor
@MessageListener
public class QueryHandler {

    @Query
    public QuerySuccessResponse querySucessoHandler(QuerySuccessOutput payload) {
        return new QuerySuccessResponse(RandomGenerator.getDefault().nextInt(100));
    }

    @Query
    public void queryErrorHandler(QuerySuccessErrorOutput payload) throws Exception {
        throw new RuntimeException("Quando exception não for filha de MessageDispatcherRuntimeException," +
                " deve ocorrer o retry e a resposta ira demorar...");
    }

    public record QuerySuccessErrorOutput() {
    }

    public record QuerySuccessResponse(int resultado) {
    }

    public record QuerySuccessOutput() {
    }

}
