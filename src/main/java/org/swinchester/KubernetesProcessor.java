package org.swinchester;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by swinchester on 15/06/16.
 */
public class KubernetesProcessor implements Processor {

    @Value("${KUBERNETES_NAMESPACE}")
    private String kubeNS;

    DefaultKubernetesClient kubernetesClient = new DefaultKubernetesClient();

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(kubernetesClient.inNamespace(kubeNS).getNamespace());
    }
}
