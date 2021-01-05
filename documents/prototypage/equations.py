import random

MAX = 100

derivO = {"chance" : [20, 50, 75, 85, MAX], "der" : ["(X + X)", "(X / X)", "(X - X)", "(X x X)", "v"]}
derivX = {"chance" : [70, 100], "der" : ["O", "v"]}
derivation = {"O" : derivO, "X" : derivX}

def compute_derive(derivation) :
    i = 0
    rand = random.randint(0, MAX - 1)
    for chance in derivation["chance"] :
        if rand < chance :
            return derivation["der"][i]
        else :
            i = i + 1
    exit("error compute_derive")

def compute_values(line) :
    strtmp = ""
    for i in range(len(line)) :
        if line[i] in ["v", "O", "X"] :
            strtmp = strtmp + str(random.randint(1, 9))
        else :
            strtmp = strtmp + line[i]
    return strtmp

def compute_line(derivation, line) :
    newline = ""
    for letter in line :
        if letter in derivation.keys() :
            newline = newline + compute_derive(derivation[letter])
        else :
            newline = newline + letter
    return newline

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

