<h1 align="center">

Analisador Sintático

</h1>

<p align="center">
  Implementação de um Analisador Sintático para reconhecimento da linguagem OWL2 (Web Ontology Language) no formato Manchester Syntax.
</p>

<h4 align="center">
	🖥️&nbsp; Compiladores 🖥️ </br>
</h4>

Sumario
=================
<!--ts-->
   * [💡 O que é um Analisador Sintatico?](#question)
   * [🛠 OWL e Manchester Syntax](#OWL)
   * [:gear:  Implementação ](#implementation)
   * [:memo: Funções ](#function)
   * [👨‍💻 Autores](#authors)
<!--te-->

</br>
<h2 id="question">💡 O que é um Analisador Sintatico?</h2>
O analisador sintático, também conhecido como parser, trabalha com os tokens gerados pelo analisador léxico. 
Ele verifica a estrutura gramatical do código fonte, de acordo com as regras da linguagem de programação em questão. 
O analisador sintático utiliza uma gramática formal para determinar se a sequência de tokens é válida de acordo com as regras da linguagem.

</br> 

<h2 id="OWL">🛠 OWL e Manchester Syntax</h2>
A linguagem OWL (Web Ontology Language) é baseada em RDF (Resource Description
Framework) e XML (eXtensible Markup Language) para relacionar recursos que têm algo a ver um com o outro
na Web. Tudo na Web é um recurso: uma página, um perfil de utilizador de redes sociais, um vídeo, um áudio,
um texto, entre outros. O nível de granularidade dos recursos na Web é vasto. Cada recurso pode ser
identificado por uma URI (Unified Resource Identifier).

</br>

Manchester Syntax, para descrição de ontologias em Description Logics:
</br>
Pizza THAT
hasTopping SOME MozzarellaTopping AND
hasTopping SOME TomatoTopping AND
hasTopping ONLY (MozzarellaTopping OR
TomatoTopping OR
PepperonniTopping)

</br>
Description Logics é a lógica de descrever coisas com base nas relações que elas têm entre si. Uma linguagem
baseada em Description Logics é geralmente declarativa, ou seja, não contém métodos ou funções de
transformação. Sendo assim, os conceitos de uma ontologia, por exemplo, são descritos sequencialmente, como
declarações avulsas. Um motor de inferência (reasoner) lê essas declarações e realiza inferências sobre
relações implícitas que poderiam conectar ainda mais os conceitos de uma ontologia. 


<h2 id="implementation">:gear: Implementação</h2>
Nosso analisador Sintatico tem com objetivo o reconhecimento da gramatica da linguagem OWL2 (Web Ontology
Language) no formato Manchester Syntax. O programa é feito em java e utiliza a implementação do [Analisador Lexico](https://github.com/isabeleLima/AnalisadorLexico) 
previvamente construido para geração dos tokens.


</br>

<h2 id="function">:memo: Funções</h2>
Resumo das funções utilizadas na implementação:

- <h3>Arquivo State</h3>
contem a classe State com o seguintes atributos:

  - State
  	- retorna o estado atual
  
  - final_state
  	- retorna o estado final se for uma cadeia aceita
  
  - accepted
  	- retorna um boolena que diz se foi aceito ou não	
</br>

<h2 id="authors">👨‍💻 Autores</h2>
<table>
  <tr>
	<td align="center">
	      <a href="https://github.com/Rigobertto">
		<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/54067766?v=4" width="100px;" alt=""/>
		<br /><sub><b>👩‍💻 Rigoberto</b></sub>
	      </a>
	</td>
    <td align="center">
      <a href="https://github.com/isabeleLima">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/58983203?v=4" width="100px;" alt=""/>
        <br /><sub><b>👩‍💻 Isabele Cristina</b></sub>
      </a>
    </td>
	<td align="center">
	      <a href="https://github.com/KennedyEduRG">
		<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/112023497?v=4" width="100px;" alt=""/>
		<br /><sub><b>👩‍💻 Kennedy</b></sub>
	      </a>
	    </td>
	<td align="center">
      <a href="https://github.com/pslayne">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/58180438?v=4" width="100px;" alt=""/>
        <br /><sub><b>👩‍💻 Layne</b></sub>
      </a>
    </td>
  </tr>
</table>
