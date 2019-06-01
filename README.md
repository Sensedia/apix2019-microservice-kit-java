# apix2019-microservice-kit-java :tshirt:

### Como executar via docker:

1 - Execute o script 'generate-image.sh', presente na pasta raiz do projeto, para gerar a imagem docker da aplicação;

2 - Execute o script 'docker-start.sh' para iniciar o container da aplicação;

OBS: Caso tenha feito alguma alteração de código e queira vê-la refletida na aplicação, repita os dois passos anteriores.  

### Como executar / debugar localmente:

1 - Localize o arquivo application.yml;

  - Altere o valor da propriedade rabbit.host para `localhost`;

  - Altere o valor da propriedade datasource.url substituindo o valor `mysql` por `localhost`;
  
2 - Diretamente pelo Intelijj, execute a classe ApiKitApplication em modo "run" ou "debug".

##### Para acessar o console de administração do RabbitMQ:
http://[docker host IP]:15672/#/

