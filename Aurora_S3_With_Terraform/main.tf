terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "us-west-2"
}

resource "random_id" "suffix" {
  byte_length = 4
}

resource "aws_s3_bucket" "rag_data" {
  bucket = "my-rag-chatbot-data-demo"
  force_destroy = true
}

resource "aws_rds_cluster" "aurora_serverless_v1" {
  cluster_identifier      = "rag-aurora-cluster-v1"
  engine                  = "aurora-postgresql"
  engine_version          = "14.6" 
  master_username         = "aurorauser"
  master_password         = "password1234"
  skip_final_snapshot     = true

}

output "s3_bucket_name" {
  value = aws_s3_bucket.rag_data.bucket
}

output "aurora_endpoint" {
  value =  aws_rds_cluster.aurora_serverless_v1.endpoint
}
