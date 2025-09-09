
🗓 Sistema de Gerenciamento de Eventos – USJT-ADS

Projeto em Java para gerenciamento de eventos, desenvolvido seguindo o paradigma de Programação Orientada a Objetos (POO). Permite cadastrar, listar, editar e deletar eventos com persistência em arquivo.

🔧 Tecnologias Utilizadas

Linguagem: Java

IDE Recomendada: VSCode, IntelliJ IDEA, Eclipse ou NetBeans

Versionamento: Git / GitHub

⚡ Funcionalidades

Cadastrar eventos: Adicionar novos eventos ao sistema.

Listar eventos: Visualizar todos os eventos cadastrados.

Editar eventos: Atualizar informações de eventos existentes.

Deletar eventos: Remover eventos do sistema.

Persistência de dados: Armazena informações em arquivo (events.data).

Interface de console: Interação simples e direta via terminal.

🗂 Estrutura do Projeto
event-manager/
├── data/
├── src/
│   └── com/eventocity/
│       ├── models/       -> Classes de modelo (Event, User, etc.)
│       ├── services/     -> Lógica de negócio
│       ├── utils/        -> Classes utilitárias      
│       └── Main.java     -> Classe principal para executar o sistema
└── events.data           -> Arquivo de dados persistentes

🚀 Como Executar

Abra o projeto em sua IDE favorita.

Compile e execute a classe Main.java.

Siga as instruções exibidas no console para interagir com o sistema.

📌 Observações

Os dados dos eventos são salvos localmente no arquivo events.data.

O sistema não possui interface gráfica; é totalmente baseado em console.

Para reiniciar os dados, basta deletar o arquivo events.data.

🤝 Contribuição

Contribuições são bem-vindas! Para sugerir melhorias ou reportar bugs:


📝 Licença

Este projeto é de uso acadêmico para a disciplina de ADS – USJT.
