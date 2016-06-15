package org.swinchester;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by swinchester on 15/06/16.
 */
public class KubernetesProcessor implements Processor {

    DefaultKubernetesClient kubernetesClient = new DefaultKubernetesClient();

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(kubernetesClient.namespaces().list());
    }
}
