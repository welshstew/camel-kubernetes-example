package org.swinchester;

import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by swinchester on 15/06/16.
 */
public class KubernetesProcessor implements Processor {

    @Value("${KUBERNETES_NAMESPACE}")
    private String kubeNS;

    Logger log = LoggerFactory.getLogger(KubernetesProcessor.class);

    DefaultKubernetesClient kubernetesClient = new DefaultKubernetesClient();

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("calling kube api against " + kubeNS);
        PodList something = kubernetesClient.pods().inNamespace(kubeNS).list();
        exchange.getIn().setBody(something.toString());
        log.info("result is : " + something.toString());
    }
}
