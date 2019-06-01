# apix2019-microservice-kit-java :tshirt:

### Como executar via docker:

1 - Execute o script 'generate-image.sh', presente na pasta raiz do projeto, para gerar a imagem docker da aplicação;

2 - Execute o comando 'docker-start.sh' para iniciar o container da aplicação;

OBS: Caso tenha feito alguma alteração de código, gere novamente a imagem docker usando o comando 'generate-image.sh' e depois use o comando 'update-kit.sh', na pasta 'docker', para subir um novo container do docker. 

### Como executar / debugar localmente:

1 - Localize o arquivo application.yml;

  - Edite a propriedade rabbit.rabbitmq apontando o ip do container rabbitmq_apix2019;

  - Edite a propriedade datasource.url apontando o ip do container mysql_apix2019;

Para descobrir o ip do container, execute o seguinte comando para resgatar o valor IPAddress: 
```
$ docker inspect container_name
```
  
2 - Diretamente pela IDE, execute a classe ApiKitApplication em modo "run" ou "debug".

##### Para acessar o console de administração do RabbitMQ:
http://[docker host IP]:15672/#/

