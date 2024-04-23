# Создание и управление

### commands

List pods

```kubectl get pods```

Create pod

```kubectl run <pod name> --generator=run-pod/v1 --image=<image from dockerhub> --port=80```

Delete pod

```kubectl delete pods <pod name>```

Pod information

```kubectl describe pods <pod name>```

Show date in pod

```kubectl exec <pod name> date```

Enter pod bash

```kubectl exec -it <pod name> sh```

Show logs

```kubectl logs <pod name>```

Port forwarding (to access pod)

```kubectl port-forward <pod name> <local port>:<pod port>```

Start/Delete pod from file

```kubectl apply -f <file name>```

```kubectl delete -f <file name>```

### start pod using manifest file

pod-applicationname.yaml

file example: (minimum number of lines to run the file)

    apiVersion : v1
    kind: Pod
    metadata:
        name: <pod name>
    spec:
        containers:
            - name : <container name>
              image: <image name>:<version>

*image can be changed without deleting pod

File with labels, 2 containers (in one pod)

    apiVersion : v1
    kind: Pod
    metadata:
        name: <pod name>
        labels:
            env  : <env name> (ex: prod)
            app  : <application name> (ex: main)
            tier : <tier> (ex: frontend)
            owner: <owner name>
    spec:
        containers:

            - name : <container name>
              image: <image name>:<version>
              ports:
                - containerPort: <port>

            - name : <container name>
              image: <image name>:<version>
              ports:
                - containerPort: <port>