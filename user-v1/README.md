

[← Regresar](../README.md) <br>

---

## ▶️ Despliegue local

1. Generar el compilado
```sh
mvn clean install
```

2. Configurar las [variables de entorno](./variables.env) en el IDE.

2. Ejecutar aplicación


---

## ▶️ Despliegue con Docker

⚙️ Crear imagen
```shell
docker build -t miguelarmasabt/user:v1.0.1 -f ./Dockerfile ./user-v1
```

⚙️ Ejecutar contenedor
```shell
docker run --rm -p 8080:8080 --env-file ./variables.env --name user-v1  miguelarmasabt/user:v1.0.1
```

---

## ▶️ Despliegue con Kubernetes

⚙️ Crear imagen
```shell
eval $(minikube docker-env --shell bash)
docker build -t miguelarmasabt/user:v1.0.1 -f ./Dockerfile ./user-v1
```

⚙️ Crear namespace y aplicar manifiestos
```shell
kubectl create namespace security
kubectl apply -f ./k8s.yaml -n security
```

⚙️ Eliminar orquestación
```shell
kubectl delete -f ./k8s.yaml -n security
```

⚙️ Port-forward
```shell
kubectl port-forward <pod-id> 8080:8080 -n security
```

