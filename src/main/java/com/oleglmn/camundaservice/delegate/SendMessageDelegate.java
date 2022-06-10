package com.oleglmn.camundaservice.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class SendMessageDelegate extends AbstractDelegate {

    @Override
    public void startExecute(DelegateExecution delegateExecution) {
        delegateExecution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("someMessage")
                //.processInstanceBusinessKey("Message_Pool")
                .correlate();
    }
}
