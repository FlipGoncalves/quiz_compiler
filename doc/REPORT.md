## Indice
1. Introdução
2. Group members e a sua participação
3. Segunda Linguagem
4. Primeira Linguagem - Introdução
5. Primeira Linguagem - Ajuda
6. Compilation & Run
7. Working Examples
8. Semantic error examples


## Introdução
Este é o trabalho realizado pelo grupo Comp-06 de Compiladores de 2020/2021.

A participação de cada representante, bem como as especificações do trabalho de cada um está incorporado na tabela a seguir.
A especificação não tem percentagem, por ser difícil de manter a par com o tanto de trabalho que cada um fez em pedaços tão específicos.

Este relatório contém, para além do pedido, uma pequena introdução às linguages, tanto a primeira como a do banco de perguntas, para ser mais fácil a sua interpretação.

É utilizado o branch principal para o código de avaliação.


## Group members
&nbsp;
| NMec | Name | email | Contribution (%) | Detailed contribution [1]
|:-:|:--|:--|:-:|:--|
| 98188 | Daniel Francisco | daniel.francisco@ua.pt | 100/6% | primary-grammar<br> compiler<br> testing<br> code-generation|
| 98039 | Daniela Dias | ddias@ua.pt | 100/6% | primary-semantic-analysis<br> examples<br> report<br> secondary-grammar|
| 98083 | Filipe Gonçalves | filipeg@ua.pt | 100/6% | primary-grammar<br> secondary-grammar<br> examples<br> report<br> secondary-interpretation/secondary-code-generation|
| 98497 | Hugo Gonçalves | hugogoncalves13@ua.pt | 100/6% | examples<br> primary-semantic-analysis<br> primary-grammar<br> compiler|
| 98262 | Martinho Tavares | martinho.tavares@ua.pt | 100/6% | primary-grammar<br> compiler<br> secondary-grammar<br> secondary-semantic-analysis<br> secondary-interpretation/secondary-code-generation<br> code-generation|
| 98601 | Tiago Costa | bran.costa@ua.pt | 100/6% | primary-grammar<br> compiler<br> testing<br> primary-semantic-analysis<br> code-generation|

[1] Topics:<br>
   primary-grammar --- primary-semantic-analysis --- code-generation --- secondary-grammar --- secondary-semantic-analysis<br>   secondary-interpretation/secondary-code-generation --- examples --- testing --- report


## Segunda Linguagem
O Banco de Perguntas vai corresponder a vários conjuntos Pergunta-Resposta(s) e baseia-se em texto JSON, obedecendo à seguinte estrutura:
<br>
{<br>
	{Question1},<br>
	{Question2},<br>
  	{Question3},<br>
}

Cada Question é composta pela seguinte implementação:

{<br>
	tema “nome do tema”,<br>
	enunciado “texto do enunciado”,<br>
	dificuldade dificuldade,<br>
	tipo “tipo”,<br>
	palavras-chave [ palavras-chave ],<br>
	opcoes {opções}<br>
}

- O campo “tema” é uma String.
- O campo “enunciado” é uma String.
- O campo “dificuldade” é um número inteiro (int) que irá tomar um valor pertencente ao intervalo [1, 2, 3], sendo 1 o grau de dificuldade mais simples e 3 o mais complexo.
- O campo “tipo” é uma String, o que corresponde ao tipo da pergunta (Matching, MultipleChoice, etc.), dependendo da pergunta. Uma pergunta só pode ter um tipo.
- O campo “palavra-chave” é um array de tipos primitivos JSON e corresponde à resposta certa ou a um conjunto de palavras que devem estar presentes na resposta do Utilizador.
- O campo “opções” é um array com as opções de resposta. Quando a pergunta é do tipo Essay, NumericAnswer ou ShortAnswer, trata-se de um objeto vazio.

## Primeira Linguagem - Introdução
A linguagem que foi desenvolvida, denominada por Buzz, tem como principal objetivo ajudar a criar um Questionário versátil, com um número variável de perguntas (definidas dentro de grupos) de diversos tipos diferentes, desde Matching, Short Answer, ... até Multiple Choice. O programador consegue criar as suas próprias perguntas, bem como importar algumas de um banco de perguntas fornecido. Deste modo, é possível criar questionários, inquéritos, jogos (como “Joker” ou “Quem quer ser milionário”) ou até testes e exames para uma certa frequência.

A linguagem criada não precisa de “;” no final de cada comando, sendo possível fazer um, e apenas um, comando por linha. A linguagem não será rígida quanto à indentação de cada comando, sendo blocos de código associados a ciclos for e a condições if delimitadas por do...end.

O Quiz é organizado por grupos, sendo que, independentemente de se definir grupos na sua inicialização, é sempre definido por um grupo default 0.

Todos os tipos de variáveis definidos, à exceção de Number e Text, têm getters e setters de modo a podermos modificar os dados (depois da variável já ter sido inicializada e declarada) e de modo a obtermos os dados necessários tanto para a representação do quiz do lado do utilizador, como para manipular o quiz e o seu conteúdo.

Para podermos criar uma questão válida, tem de ser criado o respetivo tipo de questão que será utilizado como um dos parâmetros de entrada na inicialização da questão. Da mesma forma, para podermos criar uma questão do tipo Matching, temos de criar três Tables (mais detalhe à frente) previamente ou durante a inicialização do tipo. É de se notar que a linguagem aceita a inicialização de questões vazias.

## Primeira Linguagem - Ajuda
Para substituir String, criamos o tipo Text que funciona de igual forma:
Text txt = “Hello World”, ou então, Text txt = Text(“Hello World”)

Para números, criamos o tipo Number que aceita tanto valores inteiros (Int), como valores com casas decimais (Double):
Number num1 = 1, ou então, Number num1 = Number(1.4)

Para o tipo boolean, definimos a sua utilização de acordo com os número 0, para false, e 1, para true.

- Table, representativo de array: Table t1 = {1, 2, 3}
Quando não é inicializada com dados, tem de ser especifícado o tipo de Objetos que vão ser armazenados dentro, como: Table t1 = {Number}

- ShortAnswer, para uma resposta simples, entre 1 a 10 palavras
ShortAnswer short = ShortAnswer(“resposta”, “regex”)
Os argumentos de entrada, para além da resposta certa, será o regex para palavras-chave

- NumericAnswer, para as perguntas com resposta numerica:
NumericAnswer num = NumericAnswer(num1)
Recebe como argumento um número que será a resposta certa

- Essay, para respostas de texto longo: 
Essay essay = Essay(“text”)
O argumento de entrada é a resposta proposta pelo Quiz Master, não tendo necessariamente que ser a resposta igual ao Quiz Doer

- Matching, para perguntas com o propósito de dar match: 
Matching match = Matching([“1”, “2”, ”3“], [“A”, “B”, “C”], [1, 2, 0])
Os argumentos de entrada são 3 Tables, as duas primeiras com as colunas para fazer o matching e a última com a respostas: o elemento “1” irá corresponder a “B”, pois a resposta coloca “1” no índice 1 da tabela 2

- MultipleChoice, para perguntas com múltiplas respostas: 
MultipleChoice mult = MultipleChoice(["Opt1", "Opt2", "Opt3"], 1)
Os argumentos de entrada são: uma Table com as diferentes opções, bem como o índice da resposta certa

- Question, para a inicialização das perguntas: 
Question ques = Question(Type, Text title, Text theme, Number difficulty)
Recebe como argumentos, o tipo da pergunta, Matching, ShortAnswer, etc., bem como o enunciado (title), o tema da pergunta e a sua dificuldade

- Quiz, para a criação do quiz: 
Quiz quiz1 = Quiz(Text quiz_name)
Tem também a variante de inicializar com grupos de perguntas: 
Quiz quiz1 = Quiz(Text quiz_name, Table {group0, group1, group2})
O quiz_name é o título

- BQuest, para o importe do Banco de Perguntas: 
BQuest bq = import(“ /path/ficheiro.txt ”)
Recebe o ficheiro como argumento de entrada

- Shuffle, para organizar as tabelas de forma aleatória:
Table tab1 = Shuffle[Table tab2]
Recebe uma Table como argumento de entrada e retorna uma Table com a ordenação aleatória

Com a nossa linguagem é possível ter quatro métodos diferentes: getters, setters, add e remove. A sua forma de escrever é de acordo com o seguinte esquema:
- object <+ (attirubte, object2) 	Add
- object <- (attirubte, object2) 	Remove 
- object << (attribute, arg)		Setters
- object >> attribute		   	Getters

Uma condição é realizada entre dois operandos, onde podem existir mais condições do mesmo estilo.
Para a sua realização, foi utilizada a norma de todas as linguagens:
- == para igualdade
- != para diferença
- < , > , <= , >= para verificações de menor, maior, menor e igual, e maior e igual
- not (condição) para a negação de uma condição
- and e or para operadores lógicos

É possível fazermos input de texto do terminal utilizando input() que pode conter uma String dentro ou não.
Também deve ser possível fazer output/print do que seja pretendido, utilizando output(Text).

- output(“Vamos começar o quiz! Diga nos qual o seu nome!”)
- input(“Nome: ”)

É possível criar estruturas condicionais como if, bem como ciclos, nomeadamente o ciclo for, para iterar perguntas, ou outro tipo de dados, bem como para fazer um número específico de ciclos. Com a junção destas estruturas, é importante termos uma forma de terminar o ciclo, por isso foi adicionado o break.

Na nossa linguagem, temos duas formas de comentar:
- Inline
- Multi-line

Podemos aceder ao Banco de Perguntas através da utilização de um objeto do tipo BQuest, que é inicializado com o path do ficheiro com o banco de perguntas.
- BQuest bq = import(“ /path/ficheiro.txt ”)<br>
Para receber as perguntas do banco de perguntas: bq >> (Questions)<br>
Para receber uma pergunta num índice específico: bq >> (Question, 5)<br>
Para receber uma pergunta com um índex random: bq >> (Question)<br>

Para iniciar o quiz, utilizamos o comando quiz::start(), sendo quiz a variável que contém o objeto quiz criado.

## Compilation & Run

- Foi criado um script bash para fazer a compilação e correr o código. Pode ser encontrado em src/quizz.sh e corrido com -- $./quizz.sh example0.txt Output.java --, sendo que example0.txt é o ficheiro texto com o exemplo e Output.java é o ficheiro de destino, não sendo específicado fica em Output.java
- Em caso de erro do script, deve ser feito primeiro a compilação das classes na pasta classes com javac *.java, depois volta-se à pasta src e compila-se com antlr4-build, correndo com antlr4-java QuizzMain e colocando o texto do ficheiro dentro do espaço para tal e terminando com ctrl+D, tendo o código sido gerado para o ficheiro Output.

## Working examples

Use examples to show the language functionalities.

1. `examples/Example0.txt`<br>
    Criação de um Quiz simples, com uma única pergunta do tipo Numeric Answer. 
    
    Primeiramente é gerado um objeto do tipo Quiz, depois cria-se o tipo de pergunta com a resposta certa como argumento de entrada, criamos a pergunta com esse tipo, e por fim adicionamos ao quiz.
    
    Tambem temos implementado o tipo Shuffle, que faz uma ordenação aleatória da tabela.
    
    Por fim iteramos pelo quiz, que só tem uma pergunta e um grupo, fazemos o output da pergunta e recebemos o input da resposta, verificamos se é certa, e se sim, fazemos print da mensagem “Resposta correta. Parabéns.”.
    

2. `examples/Example1.txt`<br>
    Criação de um Quiz, com duas perguntas diferentes, uma do tipo Multiple Choice e outra do tipo Matching. 
    
    Primeiramente é gerado um objeto do tipo Quiz, depois inicializamos duas tabelas para serem os argumentos de entrada das nossas questões; Criamos os tipos das perguntas, com os respetivos argumentos e por fim criamos as questões. Temos também de adicionar as perguntas ao nosso quiz, e, neste caso, ainda modificamos a 1ª opção da primeira pergunta. Para tal, utilizamos um getter que nos vai buscar ao tipo da pergunta, a tabela com as opcoes, alteramos essa tabela, e depois usamos um setter para armazenar a nova tabela no lugar da outra.
    
    Por fim iteramos pelo quiz, que só tem um grupo, fazemos o output da pergunta e recebemos o input da resposta, verificamos se é certa, e se sim, fazemos print da mensagem “Resposta correta. Parabéns.”, para cada pergunta.
    

3. `examples/Example5.txt`<br> 
    Criação de um Quiz, com duas perguntas diferentes, uma do tipo Multiple Choice e outra do tipo Matching. 
    
    Primeiramente é gerado um objeto do tipo Quiz, depois inicializamos duas tabelas para serem os argumentos de entrada das nossas questões; Criamos os tipos das perguntas, com os respetivos argumentos e por fim criamos as questões. Temos também de adicionar as perguntas ao nosso quiz, e, neste caso, ainda modificamos a 1ª opção da primeira pergunta. Para tal, utilizamos um getter que nos vai buscar ao tipo da pergunta, a tabela com as opcoes, alteramos essa tabela, e depois usamos um setter para armazenar a nova tabela no lugar da outra.
    
    Por fim iteramos pelo quiz, que só tem um grupo, fazemos o output da pergunta e recebemos o input da resposta, verificamos se é certa, e se sim, fazemos print da mensagem “Resposta correta. Parabéns.”, para cada pergunta.
    
    Igual ao Exemplo1.txt, mas com variante no tipo de pergunta. (Multiple Choice)
    

4. `examples/Example_start.txt`<br>
    Criação de um quiz muito simples, que não mostra respostas nem perguntas, apenas para ajudar a ter um exemplo de começo.
    
    São criados tipos de perguntas, e as respetivas perguntas, bem como um quiz, com um setter para modificar o nome deste.


5. `examples/Example_secondary.txt`<br>
    Criação de um quiz muito simples, com implementação da(s) pergunta(s) do banco de perguntas, guardado num ficheiro texto.
    
    Simplesmente criamos o quiz e o o Objeto do tipo BQuest e fazemos um getter a todas as perguntas que estão no banco de perguntas para um grupo no quiz.
	
    Por fim iteramos pelo quiz, que só tem um grupo, fazemos o output da pergunta e recebemos o input da resposta, verificamos se é certa, e se sim, fazemos print da mensagem “Resposta correta. Parabéns.”, para cada pergunta.


## Semantic error examples

1. `examples/Example2.txt`<br>
    Criação de um Quiz, com mais perguntas, de diferentes tipos. 
    
    Primeiramente é gerado um objeto do tipo Quiz, depois inicializamos uma tabela sem items, com o tipo representado entre chavetas, e colocamos elementos nela com um ciclo for. Também criamos tipos de pergunta e objetos de Question, sendo a única diferença, que não introduzimos parâmetros, sendo só atribuidos por setters posteriormente. Para Multiple Choice temos "opcoes" e "answer" para os getters, colocando, respetivamente, opções e a resposta certa no tipo de pergunta. Para Question temos "type", "title", "theme" e "difficulty" que irão guardar no objeto, o tipo da pergunta, o enunciado, o tema e a dificuldade, respetivamente. Finalmente adicionamos as perguntas criadas ao quiz e estamos prontos para as puder mostrar.
    
    Por fim iteramos pelo quiz, que só tem um grupo, fazemos o output da pergunta e recebemos o input da resposta, verificamos se é certa, e se sim, fazemos print da mensagem “Resposta correta. Parabéns.”, para cada pergunta.
    
    Falha na Table, especificamente nos getters, setters e em alguns metodos, quando fazemos Matching.


2. `examples/Example3.txt`<br>
    Criação de um Quiz, com perguntas de diferentes tipos, mas com a utilização de grupos de perguntas.
    
    Primeiramente é gerado um objeto do tipo Quiz, depois são criados todos os tipos e todas as perguntas para cada tipo. São criadas duas tabelas de Question, para simbolizar os grupos e armazenar as perguntas, sendo usado um add (<+) para adicionar à tabela. Depois adicionamos os grupos criados ao quiz, que contêm as perguntas, e antes de "começarmos" o quiz, também criamos uma nova pergunta e adicionamos ao grupo com índice 2 (que será o segundo grupo adicionado, por termos um grupo default com índice 0) 
    
    Por fim iteramos pelo quiz, que só tem um grupo, fazemos o output da pergunta e recebemos o input da resposta, verificamos se é certa, e se sim, fazemos print da mensagem “Resposta correta. Parabéns.”, para cada pergunta.
    
    Falha na Table, especificamente nos getters, setters e em alguns metodos.
    

3. `examples/Example4.txt`<br>
    Criação de um Quiz, com duas perguntas diferentes, uma do tipo Multiple Choice e outra do tipo Matching. 
    
    Primeiramente é gerado um objeto do tipo Quiz, depois inicializamos duas tabelas para serem os argumentos de entrada das nossas questões; Criamos os tipos das perguntas, com os respetivos argumentos e por fim criamos as questões. Temos também de adicionar as perguntas ao nosso quiz, e, neste caso, ainda modificamos a 1ª opção da primeira pergunta. Para tal, utilizamos um getter que nos vai buscar ao tipo da pergunta, a tabela com as opcoes, alteramos essa tabela, e depois usamos um setter para armazenar a nova tabela no lugar da outra.
    
    Por fim iteramos pelo quiz, que só tem um grupo, fazemos o output da pergunta e recebemos o input da resposta, verificamos se é certa, e se sim, fazemos print da mensagem “Resposta correta. Parabéns.”, para cada pergunta.
    
    Igual ao Exemplo1.txt, mas com variante no tipo de pergunta. (Matching)
    
    Falha na Table, especificamente nos getters, setters e em alguns metodos.
