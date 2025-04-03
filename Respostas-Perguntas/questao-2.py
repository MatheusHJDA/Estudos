def verifica_fibonacci(numero):

    fibonacci = [0, 1]

    while fibonacci[-1] < numero:
        proximo_valor = fibonacci[-1] + fibonacci[-2]
        fibonacci.append(proximo_valor)

    if numero in fibonacci:
        return f"O número {numero} pertence à sequência de Fibonacci."
    else:
        return f"O número {numero} não pertence à sequência de Fibonacci."

try:
    numero = int(input("Hello world, digite um número para verificar se pertence à sequência de Fibonacci: "))
    print(verifica_fibonacci(numero))
except ValueError:
    print("Coloque um número inteiro por favor....")

