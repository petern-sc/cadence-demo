package com.afterpay.ds.cadence;

import com.afterpay.ds.cadence.HelloCadence.HelloWorld;
import com.uber.cadence.WorkflowExecution;
import com.uber.cadence.client.WorkflowClient;

public class StartWorkflow {
    public static void main(String[] args) throws InterruptedException {
        String cadenceUrl = System.getenv("CADENCE_URL");
        String cadenceDomain = System.getenv("CADENCE_DOMAIN");
        
        WorkflowClient workflowClient = WorkflowClient.newInstance(cadenceUrl, 7933, cadenceDomain);

        for (int i = 0; i < 100; i++) {

            // Create a workflow stub.
            HelloWorld workflow = workflowClient.newWorkflowStub(HelloWorld.class);

            // Returns as soon as the workflow starts.
            WorkflowExecution workflowExecution = WorkflowClient.start(workflow::sayHello, args[0] + i);

            System.out.println("Started process file workflow with workflowId=\"" + workflowExecution.getWorkflowId() + "\" and runId=\"" + workflowExecution.getRunId() + "\"");
        }

        System.exit(0);
    }

}
