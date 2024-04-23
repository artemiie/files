source https://www.youtube.com/playlist?list=PLg5SS_4L6LYvN1RqaVesof8KAf-02fJSi

# Install

```virtualbox``` https://www.virtualbox.org/ 

```kubectl``` https://kubernetes.io/docs/tasks/tools/

```minikube``` https://minikube.sigs.k8s.io/docs/start/

# Commands

### minikube

```minikube version``` - показать версию

```minikube start``` - создать и запустить vm с k8s cluster  с параметрами по умолчанию

```minikube start --cpus=2 --memory=xmd/gb --disk-size=ymd/gb```

```minikube ssh``` - сделать Login на VM с нашим k8s cluster

```minikube stop``` - остановить vm с k8s cluster

```minikube delete``` - удалить vm с k8s cluster

```minikube start -p name``` - создать и запустить vm с k8s cluster с указанным именем

### kubectl

```kubectl version``` - версия kubectl client и сервера

```kubectl version --client``` - версия kubectl client и сервера

```kubectl get componentstatuses``` -  показать состояние k8s cluster

```kubectl cluster-info``` - показать информацию k8s cluster

```kubectl get nodes``` - показать все серверы k8s cluster

# K8s in AWS

Install 

```aws cli``` - для аутентификации и запуска команд aws https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html

```kubectl``` - для управления k8s cluster

```eksctl``` - для создания k8s cluster https://eksctl.io/installation/

# commands

```aws configure``` - setup aws credential command (mandatory key id, key, region)

```aws configure set region <region>```

```aws s3 ls``` - list files in folder

```eksctl create cluster --name <cluster name>```

```eksctl delete cluster --name <cluster name>```

# create cluster using config file

```eksctl create cluster -f <filename>```

```eksctl delete cluster -f <filename>```

file example:

    apiversion: eksctl.io/v1alpha5
    kind: ClusterConfig
    
    metadata:
        name: test-cluster
        region: us-east-1
    
    vpc:
        subnets:
            private:
                us-east-1a: { id: subnet-xxxxxxxxxxxx }
                us-east-1b: { id: subnet-yyyyyyyyyyyy }
                us-east-1c: { id: subnet-zzzzzzzzzzzz }
    
    nodeGroups:
        - name              : worker-nodes-group-1
          instanceType      : m5.large
          desiredCapacity   : 2
        - name              : worker-nodes-group-2
          instanceType      : r5.large
          desiredCapacity   : 2



# K8s components

```Pod``` - самый маленький объект в k8s, он состоит из одного или нескольких Container

```Deployment``` - состоит их одного или нескольких Pod (одинаковых, копий). Указывается количество Pod, Container. Делает Autoscaling, обновляет Container, раскидывает Pod в разные WorkerNode

```Service``` - дает доступ к Pod которые бегут в Deployment, подключается к Deployment и имеет доступ ко всем Pod которые в Deployment. Предоставляет доступ к Deplyment через ClusterIP, NodePort, LoadBalancer, Externalname

```Nodes``` - сервера, где бегут Pod

```Cluster``` - объединение серверов

and others : 

```DeamonSets, StatefulSets, ReplicaSets, Secrets, PV, SVC, LoadBalancers, ConfigMaps, Vertical/Horizontal Pod Autoscaler, ...```

