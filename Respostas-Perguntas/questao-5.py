texto = input("Digite uma string para inverter: ")

texto_invertido = ""
for i in range(len(texto) - 1, -1, -1):
    texto_invertido += texto[i]

print("String invertida:", texto_invertido)
