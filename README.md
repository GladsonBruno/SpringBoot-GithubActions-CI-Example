# Visão Geral
Este projeto foi criado com o intuito de servir de referência para uma automação em Java e Maven.

# Pré-requisitos para execução da aplicação
Este são os pré-requisitos para execução local da aplicação:
* JDK 17
* Plugin Lombok instalado no IDE ( Apenas para execução local )
* Plugin SpringTools instalado no IDE ( Apenas para execução local )

Além disso também é necessário definir as seguintes variáveis de ambiente no IDE:
* **DATASOURCE_URL**: Insira o valor **jdbc:h2:mem:mydb**
* **DATASOURCE_USERNAME**: Insira o valor **sa**
* **DATASOURCE_PASSWORD**: Insira o valor **D6Nl8BstFl4G0KF**
* **JWT_SECRET**: Insira o valor **======================9u9TtfXQ=Spring===========================**

Vale ressaltar que este é um banco de dados local ficticio e não contém nenhum informação importante.

Usuário e senha do mesmo é irrelevante pois o banco sempre será criado novamente após cada novo start da aplicação.
