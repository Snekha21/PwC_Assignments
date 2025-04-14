# AWS Projects Documentation
Hi, This is Snekha from CEDA!
This repository contains end-to-end deployment, automation, and integration workflows using Docker, Kubernetes, Terraform, and AWS native services. Each sample showcases a specific real-world use case.

---

##  Sample App - 1: Docker & Kubernetes Deployment

### 1️⃣ Dockerfiles Setup
- Developed Dockerfiles for:
    - `Intern Service`
    - `Training Service`
    - `Eureka Server`

📸 *Output Image:*  
![Intern Service Dockerfile Output](./images/intern_service_docker.png)  

---

### 2️⃣ Docker Compose
- Combined all three services for local orchestration using `docker-compose.yml`.

📸 *Output Image:*  
![Docker Compose Output](./images/docker_compose_output.png)  

---

### 3️⃣ Kubernetes Deployment using Minikube
- Minikube cluster setup.
- Deployment of services using YAML files.

📸 *Output Image:*  
![Minikube Deployment Output](./images/minikube_output.png)  

---

### 4️⃣ Docker Image to Docker Hub
- Tagged and pushed Docker images to Docker Hub.

📸 *Output Image:*  
![Docker Hub Push Output](./images/dockerhub_push.png)  

---

### 5️⃣ Docker Image to AWS ECR
- Created ECR repositories.
- Pushed Docker images to AWS ECR.

📸 *Output Image:*  
![ECR Push Output](./images/ecr_push.png)  

---

### 6️⃣ EKS Deployment
- Deployed the Docker images on AWS EKS.

📸 *Output Image:*  
![EKS Deployment Output](./images/eks_output.png)  

---

##  Sample App - 2: CI/CD with AWS

### 7️⃣ AWS CodeCommit Integration
- Hosted code on AWS CodeCommit.

📸 *Output Image:*  
![CodeCommit Output](./images/codecommit_output.png)  

---

### 8️⃣ AWS CodeBuild Integration
- Built and tested code using AWS CodeBuild.

📸 *Output Image:*  
![CodeBuild Output](./images/codebuild_output.png)  

---

### 9️⃣ AWS CodePipeline Integration
- Automated build and deployment pipeline.

📸 *Output Image:*  
![CodePipeline Output](./images/codepipeline_output.png)  

---

##  Sample App - 3: Infrastructure as Code (IaC) with Terraform

###  EC2 Creation
- Terraform script to spin up EC2 instances.

📸 *Output Image:*  
![EC2 Terraform Output](./images/terraform_ec2_output.png)  

---

###  Aurora and S3 Setup
- Terraform modules for Aurora DB and S3 buckets.

📸 *Output Image:*  
![Aurora S3 Terraform Output](./images/terraform_aurora_s3_output.png)  

---

##  Sample App - 4: Bedrock-Powered Chat App

### 💬 Python Chat Application
- Created a chat app using AWS Bedrock to leverage foundation models for responses.

📸 *Output Image:*  
![Bedrock Chat App Output](./images/bedrock_chat_output.png)  

---

##  Conclusion
This collection demonstrates how to:
- Build microservices using Docker.
- Deploy locally and on AWS (ECR & EKS).
- Automate workflows via CodeCommit, CodeBuild, and CodePipeline.
- Define AWS infrastructure as code with Terraform.
- Use AWS Bedrock for serverless AI applications.

---


