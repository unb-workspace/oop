# Estrutura do Projeto

## Mini-cenário

O aplicativo oferece várias alternativas de emprego para a sua área profissional. Cada empresa deve ter seu representante, responsável por cadastrar no sistema:

- Nome da empresa
- Àrea de ocupação da empresa
- Endereço da empresa
- E-mail
- Número de telefone

Além disto, para cada emprego ofertado, é de importância atualizar seus respectivos salários, carga horária, área de atuação e exigências. Quando não há vagas ofertadas, a empresa é movida para o "arquivo" e não deverá ser mostrada nos filtros e nem no menu principal do aplicativo.

## Classes e Métodos

\* Quando a variável for `type`, significa que está ainda a definir.

1. Classe: `Company`
    -  Atributos:
        - *private type:* **ID**
        - *private String:* **name**
        - *private String::* **occupation_area**
        - *private String:* **email**
        - *private long int:* **cellphone_number**
        - *private Owner:* **owner**
        - *private Address:* **address**
        - *private Job[]:* **jobs**

    - Métodos:
        - *public type:* **getId()**
        - *public Owner:* **getOwner()**

2. Classe: `User`
    - Atributos:
        - *private String:* **name**
        - *private String:* **password**
        - *private Date:* **creation_date**
        - *private type:* **company**

    - Métodos:
        - *public boolean:* **setCompany(type ID)**
        - *public boolean:* **setCompany()**
        - *public string:* **getPassword()**
        - *public Date:* **getCreationDate()**
        - *public type:* **getCompany()**

3. Classe: `Job`
    - Atributos:
        - *private int:* **salary**
        - *private int:* **workload**
        - *private string:* **modality**
        - *private string:* **occupation_area**
        - *private string[]:* **requirements**
    
    - Métodos:
        - *public int:* **getSalary()**
        - *public int:* **getWorkload()**
        - *public string:* **getModality()**
        - *public string:* **getOccupation()**
        - *public string[]:* **getRequirements()**
        - *void:* **setSalary(int salary)**
        - *void:* **setWorkload(int hours)**
        - *void:* **setModality(string modality)**
        - *void:* **setRequirement(string requirement)**
        - *void:* **setRequirement(string[] requirements)**
        - *void:* **removeRequirements()**

4. Classe: `Address`
    - Atributos:
        - *private string:* **state**
        - *private string:* **city**
        - *private string:* **street**
    
    - Métodos:
        - *public string:* **getState()**
        - *public string:* **getCity()**
        - *public string:* **getStreet()**