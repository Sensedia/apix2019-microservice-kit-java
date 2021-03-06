# apix2019-microservice-kit-java :tshirt:

### Como executar via docker:

1 - Execute o script 'generate-image.sh', presente na pasta raiz do projeto, para gerar a imagem docker da aplicação;

2 - Execute o script 'docker-start.sh' para iniciar o container da aplicação;

OBS: Caso tenha feito alguma alteração de código e queira vê-la refletida na aplicação, repita o primeiro passo e execute o script 'update-kit.sh' na sequência.  

### Como executar / debugar localmente:

1 - Localize o arquivo 'application.yml';

  - Altere o valor da propriedade rabbit.host para `localhost`;

  - Altere o valor da propriedade spring.datasource.url substituindo `jdbc:mysql://mysql:3306/...` por `jdbc:mysql://localhost:3306/...`;
  
2 - Diretamente pelo InteliJ, execute a classe ApiKitApplication em modo "run" ou "debug".

### Como testar se o serviço está salvando os kits devidamente:

1 - Execute um post para a seguinte uri > `localhost:5060/kits`. Você pode utilizar o postman ou outra ferramenta de sua preferência para fazer isso.
  - Como todo bom post, é necessário informar o body. Um exemplo de entrada é:
  
```
{
   "phone":"+5519999999999",
   "gender":"F",
   "specifications":[
      { 
         "type":"PANT",
         "color":"BLUE"
      },
      {
         "type":"SHIRT",
         "color":"WHITE"
      },
      {
         "type":"SHOES",
         "color":"BLACK"
      }
   ]
}
```

##### Para acessar o console de administração do RabbitMQ:
http://[docker host IP]:15672/#/

