# Decoder.py finalized on 06-16-2021 by Marc Casper
#
# A small pet project, essentially just making a bloated caesar cipher using the
# ascii table. This is not to be taken as any sort of serious attempt at
# cryptography, and it is not to be used in any circumstance to try and encrypt
# any information. This process completely fails Kerckhoffs's principle, and just
# as a caesar cipher is trivial to crack once you know its process, so too is this
# programs process trivial to crack.

cypher = input("Enter your cipher text: ")
separators = "" #initializes a variable to hold the letters in the cipher
for char in cypher:
    if not char.isnumeric():
        separators = separators + char
        #Puts all the letters in separators variable

values = "".join(char if char not in separators else " " for char in cypher).split()

conCat = ""
for i in range(0, len(values)):
    temp = int(values[i])-2
    conCat += (str(temp.to_bytes(1, 'big'))[-2])
conCatRev = conCat[::-1]
print(conCatRev)