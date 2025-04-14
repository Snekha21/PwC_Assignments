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

📸 *Dockerfile Image:*  
![Screenshot 2025-04-15 002117](https://github.com/user-attachments/assets/ce63fdf4-b198-469a-9dac-dcaa91ffdcf6)


---

### 2️⃣ Docker Compose
- Combined all three services for local orchestration using `docker-compose.yml`.

📸 *Output Image:*  
![image](https://github.com/user-attachments/assets/1aa7fe54-fa6b-4895-b913-679e8ba02806)


---

### 3️⃣ Kubernetes Deployment using Minikube
- Minikube cluster setup.
- Deployment of services using YAML files.

📸 *Output Image:*  
<img width="1710" alt="Screenshot 2025-04-13 at 6 44 45 PM" src="https://github.com/user-attachments/assets/313abcaa-268d-41de-b32b-ad582880749e" />
<img width="1710" alt="Screenshot 2025-04-13 at 7 36 02 PM" src="https://github.com/user-attachments/assets/498b48ec-57f5-48b2-b883-a42c1b966a95" />
<img width="1710" alt="Screenshot 2025-04-13 at 6 44 57 PM" src="https://github.com/user-attachments/assets/e6b54ccd-3399-4c9c-8da0-9b17bcf73de1" />
<img width="1437" alt="Screenshot 2025-04-13 at 6 45 06 PM" src="https://github.com/user-attachments/assets/7853a020-b17a-4ae3-8bb1-c0e0f2de5bcd" />



---

### 4️⃣ Docker Image to Docker Hub
- Tagged and pushed Docker images to Docker Hub.

📸 *Output Image:*  
![Screenshot 2025-04-14 125340](https://github.com/user-attachments/assets/dfa07f4c-edc0-4ede-b523-67a69b58d5c6)

![Screenshot 2025-04-14 125404](https://github.com/user-attachments/assets/20a5c1c7-3d82-46a6-9624-2b2b46201b09)
 

---

### 5️⃣ Docker Image to AWS ECR
- Created ECR repositories.
- Pushed Docker images to AWS ECR.

📸 *Output Image:*  
![Screenshot 2025-04-13 200029](https://github.com/user-attachments/assets/4a688d2f-1619-4813-9505-29ff622766fd)
![Screenshot 2025-04-13 200940](https://github.com/user-attachments/assets/e57f124e-b5b4-4066-98b6-47ca835c5fc9)



---

### 6️⃣ EKS Deployment
- Deployed the Docker images on AWS EKS.
- Created VPC for the same

📸 *Output Image:*  
![Screenshot 2025-04-13 224543](https://github.com/user-attachments/assets/eafad58b-c5c3-48cc-bc30-12873211bbcc)
![Screenshot 2025-04-13 224603](https://github.com/user-attachments/assets/9482f74a-93ef-4340-95bd-743945de79e9)
![Screenshot 2025-04-13 205433](https://github.com/user-attachments/assets/94b7916a-7d31-4b3e-8939-ccaacfe88b23)
![Screenshot 2025-04-13 205959](https://github.com/user-attachments/assets/e88b50e4-46c6-4e02-9c06-95dddaba6438)
![Screenshot 2025-04-13 224308](https://github.com/user-attachments/assets/ebeb43e3-2f11-4253-bf36-28fff34e2bbe)
![Screenshot 2025-04-13 224245](https://github.com/user-attachments/assets/a1b4ae4a-596e-4b0b-b5f6-6a50cfb22970)

---

##  Sample App - 2: CI/CD with AWS

### 7️⃣ AWS CodeCommit Integration
- Hosted code on AWS CodeCommit.

📸 *Output Image:*  
![Screenshot 2025-04-15 004614](https://github.com/user-attachments/assets/9927c5d4-74f9-43a0-8287-ff601711e5a3)

---

### 8️⃣ AWS CodeBuild Integration
- Built and tested code using AWS CodeBuild.

📸 *Output Image:*  
#### Sample 1:
![Screenshot 2025-04-13 211429](https://github.com/user-attachments/assets/9e465fc9-4b41-45b9-99b3-ffb254cb49a5)

#### Sample 2: (With Logs)
![Screenshot 2025-04-14 215451](https://github.com/user-attachments/assets/3dccbc5a-1391-4a03-8601-e9a45c6eebdb)
![Screenshot 2025-04-14 215511](https://github.com/user-attachments/assets/f78c0d35-fd86-49e6-8934-47a0d4b362e8)

#### Output in S3:
![Screenshot 2025-04-14 210925](https://github.com/user-attachments/assets/ee89b939-2e86-4b96-a796-495cfb61c21e)



---

### 9️⃣ AWS CodePipeline Integration
- Automated build and deployment pipeline.

📸 *Output Image:*  
![Screenshot 2025-04-14 225852](https://github.com/user-attachments/assets/583d2616-d722-421d-880d-542404b5c6aa)
![Screenshot 2025-04-14 225922](https://github.com/user-attachments/assets/7855435e-6bfc-4e07-be20-1b81c9ce3bdd)
![Screenshot 2025-04-15 000321](https://github.com/user-attachments/assets/3a99c055-85ed-4bce-9b0f-2dd3df4bfc07)



---

##  Sample App - 3: Infrastructure as Code (IaC) with Terraform

###  EC2 Creation
- Terraform script to spin up EC2 instances.

📸 *Output Image:*  
##### 1) terraform init
![Screenshot 2025-04-14 191300](https://github.com/user-attachments/assets/a85a0641-4e8a-44d3-ac66-3a3287bad620)
#### 2) terraform plan
![Screenshot 2025-04-14 191629](https://github.com/user-attachments/assets/c6b9e9e9-7e2b-4400-a1e3-ee50fb7aeba0)
#### 3) terraform apply
![Screenshot 2025-04-14 192313](https://github.com/user-attachments/assets/b3010dac-3d72-435e-a04a-458b63e79310)
#### Created EC2:
![Screenshot 2025-04-14 192357](https://github.com/user-attachments/assets/814acc44-73ba-44a3-8019-d31dece088ac)
#### Status: Running
![Screenshot 2025-04-14 192720](https://github.com/user-attachments/assets/22b9b08d-2e45-440a-a730-323532734b45)


---

###  Aurora and S3 Setup
- Terraform modules for Aurora DB and S3 buckets.

📸 *Output Image:*  
#### Terraform creation
![Screenshot 2025-04-14 200043](https://github.com/user-attachments/assets/9cb639ac-fc1e-491a-9e1a-3f61f6315eeb)
#### Aurora 
![Screenshot 2025-04-14 200215](https://github.com/user-attachments/assets/49396e03-2699-4844-9a4b-7dd55f267f4a)
#### S3
![Screenshot 2025-04-14 210706](https://github.com/user-attachments/assets/055840b6-6dd7-496f-959a-49276c6c215e)



---

##  Sample App - 4: Bedrock-Powered Chat App

### 💬 Python Chat Application
- Created a Console based chat app using AWS Bedrock to leverage foundation models for responses.

📸 *Output Image:*  
![Screenshot 2025-04-14 231816](https://github.com/user-attachments/assets/6f7f5110-d561-41ad-8083-136a4d8995ec)


---

##  Conclusion
This collection demonstrates how to:
- Build microservices using Docker.
- Deploy locally and on AWS (ECR & EKS).
- Automate workflows via CodeCommit, CodeBuild, and CodePipeline.
- Define AWS infrastructure as code with Terraform.
- Use AWS Bedrock for serverless AI applications.

---


