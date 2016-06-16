# Camel Kubernetes Example

Quickstart just to show camel on a timer grabbing stuff from the kubernetes API.


## Build...

	oc new-app jboss-fuse-6/fis-java-openshift:1.0~https://github.com/welshstew/camel-kubernetes-example.git --strategy=source

- Remember to change the configuration/settings.xml - I've pointed it to my local nexus
- Remember to modify the dc on deployment - to ensure we have the KUBERNETES_NAMESPACE param passed down (see kube/exported-dc.yaml)
- remember to add permissions to the kube API


	oc policy add-user-to-role view system:serviceaccount:my-namespace:default -n my-namespace

