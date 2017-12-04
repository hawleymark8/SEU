#makefile for prog5.asm
a.out: prog5-6.o mysubs.o
	ld -m elf_i386 mysubs.o prog5-6.o
prog5-6.o: prog5-6.asm
	nasm -f elf prog5-6.asm
mysubs.o: mysubs.asm
	nasm -f elf mysubs.asm
clean:
	rm a.out prog5-6.o mysubs.o