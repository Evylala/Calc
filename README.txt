Statut :
Les pistes vertes et bleues sont complètes.


Gestion des erreurs :
Toutes les erreurs des pistes vertes sont gérées (testées via le TestCalc qui nous a été envoyé).
Ces erreurs sont soit gérées dans le Lexer (envoie une exception "UnepextectedCharacter" si 
un caractère est inattendu), soit dans Expression (envoie une "SyntaxicError" pour toutes les erreurs
de syntaxe).
La gestion aussi des variables non déclarées : on ne peut pas appeler eval de variable si lookup(variable)
renvoie null (envoie une exception). Ceci est donc géré dans Variable.
Le body, quant à lui, vérifie qu'il contient une seule et unique expression.
Je n'ai pas remis des tests pour les pistes vertes. Les fichiers tests déposés avec le projet sont donc
principalement utilisés pour tester les pistes bleues.


