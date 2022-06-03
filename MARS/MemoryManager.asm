.include "macros.asm"

.data
.text
#criação dos processos
Fork (Programa1, Programa2)
Fork (Programa2, Idle)
Fork (Idle, EndProgram)
ProcessChange

Programa1:
	addi $s1, $zero, 1
	addi $s2, $zero, 2
	j Programa2
	loop1: addi $s1, $s1, 1
	beq $s1, $s2, fim1
	j loop1
	fim1: ProcessTerminate
	
Programa2:
	addi $s1, $zero, -1
	addi $s2, $zero, -10
	
	loop2: addi $s1, $s1, -1
	beq $s1, $s2, fim2
	j loop2
	fim2: ProcessTerminate
	
Idle:
	loop:
		nop
		j loop
		
EndProgram: done
