# Docker-Controll 

_👀 Aplicação em java e Spring-boot que utiliza  a biblioteca docker-java-client para criar,listar e gerenciar imagens e containers. 

## clone esse repositório

```bash
git clone https://github.com/D4N23/Docker-Controll.git
```

## Endpoints:

```bash
# Endpoint para criar um container
curl -X POST http://localhost:8080/api/container/

# Endpoint para listar os containers, podendo passar um parâmetro de pesquisa
curl -X GET http://localhost:8080/api/container/filter?showAll=false

# Endpoint para startar um container através do seu ID
curl -X POST http://localhost:8080/api/container/{id}/start

# Endpoint para parar a execução de um container
curl -X POST http://localhost:8080/api/container/{id}/stop

# Endpoint para deletar containers
curl -X DELETE http://localhost:8080/api/container/{id}

# Endpoint para listar todas as imagens Docker baixadas
curl -X GET http://localhost:8080/api/images

# Endpoint para pesquisar imagens através do nome
curl -X GET http://localhost:8080/api/images/search?name={nome}
