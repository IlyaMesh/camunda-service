package com.oleglmn.camundaservice.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SecondMessageSender extends AbstractDelegate{
    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        delegateExecution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("secondMessage")
                .correlate();
    }
}
