Statut :
Les pistes vertes et bleues sont compl�tes.


Gestion des erreurs :
Toutes les erreurs des pistes vertes sont g�r�es (test�es via le TestCalc qui nous a �t� envoy�).
Ces erreurs sont soit g�r�es dans le Lexer (envoie une exception "UnepextectedCharacter" si 
un caract�re est inattendu), soit dans Expression (envoie une "SyntaxicError" pour toutes les erreurs
de syntaxe).
La gestion aussi des variables non d�clar�es : on ne peut pas appeler eval de variable si lookup(variable)
renvoie null (envoie une exception). Ceci est donc g�r� dans Variable.
Le body, quant � lui, v�rifie qu'il contient une seule et unique expression.
Je n'ai pas remis des tests pour les pistes vertes. Les fichiers tests d�pos�s avec le projet sont donc
principalement utilis�s pour tester les pistes bleues.


