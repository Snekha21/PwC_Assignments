resource "aws_instance" "web" {
  ami                    = "ami-075686beab831bb7f"
  instance_type          = "t2.micro"
#   key_name               = "ec2-key"

  tags = {
    Name = "demo-ec2"
  }
}