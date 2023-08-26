# LDS-LAB01

## Descrição do Sistema:

Uma universidade pretende informatizar seu sistema de matrículas. A secretaria da universidade gera o currículo para cada semestre e mantém as informações sobre as disciplinas, professores e alunos.

Cada curso tem um nome, um determinado número de créditos e é constituído por diversas disciplinas.

Os alunos podem se matricular em 4 disciplinas como 1ª opção (obrigatórias) e em mais 2 outras alternativas (optativas).

Há períodos para efetuar matrículas, durante os quais um aluno pode acessar o sistema para se matricular em disciplinas e/ou para cancelar matrículas feitas anteriormente.

Uma disciplina só fica ativa, isto é, só vai ocorrer no semestre seguinte se, no final do período de matrículas tiver, pelo menos, 3 alunos inscritos (matriculados). Caso contrário, a disciplina será cancelada. O número máximo de alunos inscritos a uma disciplina é de 60 e quando este número é atingido, as inscrições (matrículas) para essa disciplina são encerradas.

Após um aluno se inscrever para um semestre, o sistema de cobranças é notificado pelo sistema de matrículas, de modo que o aluno possa ser cobrado pelas disciplinas daquele semestre.

Os professores podem acessar o sistema para saber quais são os alunos que estão matriculados em cada disciplina.

Todos os usuários do sistema têm senhas que são utilizadas para validação do respectivo login.


## História de usuários

> Antes de começar a escrever histórias, recomenda-se listar os principais usuários que vão interagir com o sistema. Assim, evita-se que as histórias fiquem enviesadas e atendam às necessidades de apenas certos usuários. Definidos esses papéis de usuários (user roles), costuma-se escrever as histórias no seguinte formato:

	"Como um [papel de usuário], eu gostaria de [realizar algo com o sistema]"

fonte: Engenharia de Software Moderna, disponível em https://engsoftmoderna.info/cap3.html

Agentes: Secretário(a), Professor(a), Aluno(a)


**Secretário(a)** :
* Como um(a) secretário(a), eu gostaria de ter um login e senha para acessar o sistema.
* Como um(a) secretário(a), eu gostaria de gerar um currículo para cada semestre.


**Aluno(a)**
* Como um(a) aluno(a), eu gostaria de ter um login e senha para acessar o sistema.
* Como um(a) aluno(a), eu gostaria de realizar a matrícula do semestre.
* Como um(a) aluno(a), eu gostaria de adiconar disciplinas obrigátórias e opcionais.


**Professor(a)**
* Como um(a) professor(a), eu gostaria de ter um login e senha para acessar o sistema.
* Como um(a) professor(a), eu gostaria de saber quem são os alunos matriculados na minha disciplina.


## Casos de uso


	"Casos de uso são escritos na perspectiva de um ator que deseja usar o sistema com um objetivo. Tipicamente, esse ator é um usuário humano (embora possa ser um outro sistema de software ou hardware). Ou seja, normalmente, o ator é uma entidade externa ao sistema."

> Explicando com mais detalhes, um caso de uso enumera os passos que um ator realiza em um sistema com um determinado objetivo. Na verdade, um caso de uso inclui duas listas de passos. A primeira representa o fluxo normal de passos necessários para concluir uma operação com sucesso. Ou seja, o fluxo normal descreve um cenário em que tudo dá certo, às vezes chamado também de fluxo feliz. Já a segunda lista inclui extensões do fluxo normal, as quais representam alternativas de execução de um passo normal ou então situações de erro. Ambos os fluxos — normal e extensões — serão posteriormente implementados no sistema. Mostra-se a seguir um caso de uso, referente a um sistema bancário e que especifica uma transferência entre contas, por um cliente do banco."

fonte: Engenharia de Software Moderna, disponível em https://engsoftmoderna.info/cap3.html

### Gerar currículo para o semestre
Ator: Secreterário(a)

**Fluxo normal:**
1. O sistema autentica o(a) secretário(a) com login e senha
2. O(a) secretario(a) gera o currículo para o semestre de um curso.
3. O(a) secretario(a) adiciona disciplinas do currículo com seus repectivos professores, créditos e infromações para os alunos se matricularem.

**FLuxo alternativo**
* 3(a) O sistema somente permitirá que disciplinas com no mínimo 3 alunos fiquem ativas após o fim do prazo de matrículas e cancelará
as que não cumprem estas condições.



### Matricular-se
Ator: Aluno(a)

**Fluxo normal**:
1. O sistema autentica o(a) aluno(a) com login e senha.
2. O(a) aluno(a) Matricula-se em até 4 disciplinas obrigatórias e até 2 optativas por semestre.
3. O sistema notifica o sistema de cobranças após o aluno(a) se matricular
4. O(a) Aluno(a) pode alterar suas disciplinas as incluindo e/ou excluindo.
5. O(a) aluno(a) pode cancelar sua matrícula.


**Fluxo alternativo**
* 2a : O(a) aluno não pode se matricular fora do prazo.
* 4a : O(a) aluno não pode se alterar as disciplinas fora do prazo.
* 5a : O(a) aluno não pode cancelar a matrícula fora do prazo.


### Verificar alunos
Ator: Professor(a)

**Fluxo principal:**
1. O sistema autentica o(a) professor(a) com login e senha.
2. O sistema informa para o professor os alunos que estão na(s) sua(s) disciplina(s) informadas.

### Diagrama de Caso de Uso
![diagrama de caso de uso](./Projeto/DCU-versao2.png)