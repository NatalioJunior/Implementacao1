.include "macros1.asm"
.data
.text             
	#criação dos processos
	
	SyscallFork(Programa1, 1)
	SyscallFork(Programa2, 0)
	SyscallFork(Idle, 2)

	#escalonando o primeiro processo
	SyscallProcessChange
	
Idle:	NOP
	loop: NOP
	j loop

Programa1:	addi $s1, $zero, 1 # valor inicial do contador
		addi $s2, $zero, 10 # valor limite do contador
	loop1: 	addi $s1, $s1, 1
		beq $s1, $s2, fim1
		j loop1
	fim1:	ProcessTerminate

Programa2: 	addi $s1, $zero, -1 # valor inicial do contador
		addi $s2, $zero, -10 # valor limite do contador
	loop2: 	addi $s1, $s1, -1
		beq $s1, $s2, fim2
		j loop2
	fim2:	ProcessTerminate