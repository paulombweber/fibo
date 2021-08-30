How to run this project

#### On IntelliJ IDEA

- Install Maven
- Open the project
- Reload All Maven Dependencies
- Run FiboApplication as a application
- curl localhost:8080/fib?n=45

#### On Kubernetes
- Generate docker image `docker build -t pauloweber/fibo .`
- Create a tag for the image `docker tag pauloweber/fibo pauloweber/fibo:snapshot`
- Load image into cluster (I used `kind` as a helper to create a local cluster and loading the image, but you may use another of your choice) `kind load docker-image pauloweber/fibo:snapshot`
- Apply Deployment file `kubectl apply -f deployment.yaml`
- Forward port 8080(or any other of your choice) of localhost to port 8080 of container `kubectl port-forward svc/fibo 8080:8080`
- Run the service on port selected above `curl localhost:8080/fib?n=45`

#### Limits:
This Service limits `n` to a maximum of 5000000, this was done to make the service more stable, since values higher than this cause the service to take too much time to respond. But unit tests show that it works for larger numbers but will take too much time.