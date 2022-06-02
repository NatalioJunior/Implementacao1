.include "macrosPreemptive.asm"
.data
.text             
	#criacao dos processos
	
	SyscallFork(Programa2)
	SyscallFork(Programa1)
	SyscallFork(Idle)

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
	
