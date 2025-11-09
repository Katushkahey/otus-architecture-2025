How to install in minikube and test with newman

kubectl create namespace otus-homework
kubectl config set-context --current --namespace=otus-homework
git clone https://github.com/Katushkahey/otus-architecture-2025.git
cd otus-architecture-2025/
kubectl create secret generic my-postgresql --from-literal=POSTGRES_PASSWORD=otus
kubectl apply -f ./k8s/postgres
cd helm/
helm install otus-homework ./ -f values.yaml -n otus-homework

helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx/
helm repo update
helm install nginx ingress-nginx/ingress-nginx -f nginx_ingress-25239-20146a.yaml

curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash -
sudo apt-get install -y nodejs
sudo npm install -g newman
cd ../postman
sudo nano /etc/hosts (add 127.0.0.1       arch.homework)

     (OPTIONALLY: 
     minikube service nginx-ingress-nginx-controller --url -n otus-homework

     in another window:

     sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 37453
     sudo iptables -t nat -A OUTPUT -p tcp --dport 80 -j REDIRECT --to-port 37453

     cd  /otus-architecture-2025/postman
     newman run otus-homework-collection.postman_collection.json
     )


newman run otus-homework-collection.postman_collection.json




