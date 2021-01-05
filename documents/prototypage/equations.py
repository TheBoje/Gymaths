import random

MAX = 100
# derivation est un dictionnaire comportant la chance d'apparition de chaque possibilitée de dérivation
# ainsi pour accéder à la liste des chances il faudra faire : nomDuDictionnaire["chance"] (retourne une liste d'entier compris entre 0 et 100 (MAX) dans l'ordre croissant)
# pour accéder à la liste des dérivations : nomDuDictionnaire["der"] (retourne une liste de chaine de caractères)

# Pour derivO on a donc
#   - (X + X) qui a 20% de chance de passer (20 - 0)
#   - (X / X) qui a 30% de chance de passer (50 - 20)
#   - (X - X) qui a 25% de chance de passer (75 - 50)
#   - (X x X) qui a 10% de chance de passer (85 - 75)
#   - v       qui a 15% de chance de passer (100 - 85)
derivO = {"chance" : [20, 50, 75, 85, MAX], "der" : ["(X + X)", "(X / X)", "(X - X)", "(X x X)", "v"]}
derivX = {"chance" : [70, MAX], "der" : ["O", "v"]}

# dictionnaire des dérivations, on stocke ici les dictionnaires (vu au dessus) dans le dictionnaire de dérivations.
# ainsi, "O" -> "(X + X)", "(X / X)", "(X - X)", "(X x X)" ou "v" en fonction des chances
# ainsi, "X" -> "O" ou "v" en fonction des chances
derivation = {"O" : derivO, "X" : derivX}

# calcul la dérivation de la lettre en fonction du dictionnaire de dérivation de la lettre correspondante
def compute_derive(derivation) :
    i = 0
    rand = random.randint(0, MAX - 1) # On génère un nombre aléatoire entre 0 et le maximum (ici 100)
    # On parcours les chances jusqu'à tomber sur le bon intervalle
    for chance in derivation["chance"] :
        if rand < chance :
            return derivation["der"][i] # On retourne la dérivation de la lettre correspondante
        else :
            i = i + 1
    exit("error compute_derive")

# parcours la chaine de caractere lettre par lettre et ajoute les valeurs pour les variables (à appeler à la fin des dérivations)
def compute_values(line) :
    strtmp = ""
    for i in range(len(line)) :
        # si la lettre fait partie de la liste des lettre à dériver et les remplaces par des valeurs entières
        if line[i] in ["v", "O", "X"] :
            strtmp = strtmp + str(random.randint(1, 9))
        else :
            strtmp = strtmp + line[i]
    return strtmp

# Dérive la ligne en fonction du dictionnaire de dérivation passé en argument
def compute_line(derivation, line) :
    newline = ""
    for letter in line :
        # On regarde si la lettre est une lettre à dériver
        if letter in derivation.keys() :
            newline = newline + compute_derive(derivation[letter])
        else :
            newline = newline + letter
    return newline

# Dérive n fois la chaine de caractère line (récursif)
def deriv(derivation, n, line) :
    if n == 0 :
        return compute_values(line)
    else :
        return deriv(derivation, n - 1, compute_line(derivation, line))

print(deriv(derivation, 4, "O"))
print(deriv(derivation, 5, "O"))
print(deriv(derivation, 6, "O"))
print(deriv(derivation, 7, "O"))
print(deriv(derivation, 10, "O"))

