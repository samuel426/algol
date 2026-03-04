
a = str(input())

def countingspace(line):
    b = 0 
    if line[0] == ' ':
        b -= 1
    if line[-1] == ' ':
        b -= 1
    b += line.count(' ')+1
    print(b)

countingspace(a)