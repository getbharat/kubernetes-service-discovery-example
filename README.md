# kubernetes-service-discovery-example

### Deployment using docker compose -
- Clone the repository using ``git clone`` command.
- Go to customer project directory and execute ``mvn clean install``
- Now build docker image `` docker build -t {name}:{tag} . `` ,  and replace {name} by 'customer' and {tag} by 'latest'.
- Go to order project directory and execute ``mvn clean install``
- Now build docker image `` docker build -t {name}:{tag} . `` ,  and replace {name} by 'order' and {tag} by 'latest'.
- Create a network using ``docker network create {NETWORK_NAME}`` , replace {NETWORK_NAME} by 'kubernetes-service-discovery-example'.
- Navigate to parent directory, kubernetes-service-discovery-example, in cmd and execute ```docker compose up```
- Access services using http://localhost:8090/customer/get and http://localhost:8090/customer/get/order/C1.

### Deployment using kubernetes -
 - Make sure minikube and kubectl are installed and configured.
 - Start minkube using ``minikube start --nodes=2``, it would create a k8s cluster with 2 nodes.
 - If images are not present locally, both the images would be pulled from here - https://hub.docker.com/repository/docker/getbharat/order, https://hub.docker.com/repository/docker/getbharat/order
 - Apply order deployment file using command ``kubectl apply -f order-deployment.yml``
 - Above command will create a ClusterIP service.
 - Get ClusterIP service's ip address, get it using ``kubectl get services`` and ``kubectl describe service {SERVICE_NAME}`` - use service name that you want to be described.
 -  Replace the [value](https://github.com/getbharat/kubernetes-service-discovery-example/blob/master/customer-deployment.yml#L30) by the ClusterIP address and port 8091. Also, make a change in order-deployment.yml, replace [port](https://github.com/getbharat/kubernetes-service-discovery-example/blob/master/order-deployment.yml#L36) by 8091. Alternatively, use name instead of the IP address. 
 -  Apply deployment file using command ``kubectl apply -f customer-deployment.yml``
 -  Use port forwarding (not recommended) to access the urls metioned in deployment using docker compose section. ```kubectl port-forward deployment/customer 8090:8090``` and ``kubectl port-forward deployment/order 8091:8091``

##### Note: If the jar names, ports, and image names that I metioned in the repository are changed, the above commands would also change accordingly. 
