import sys
import os

WHITE_SPACE = " "

def rename(path):
    if WHITE_SPACE in path:
        os.rename(path, path.replace(WHITE_SPACE, "_"))
        #TODO: Chamar novamente rename com o novo nome, pois pode se tratar de um diretório
    else:
        for i in os.listdir(path):
            rename(os.path.join(path, i))

if len(sys.argv) == 2:
    rename(sys.argv[1])
else:
    print("Informar um, e apenas um, caminho alvo.")

