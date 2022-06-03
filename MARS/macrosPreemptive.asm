.macro SyscallFork(%address, %limit)
	li $v0, 60
	la $a0, %address
	la $a1, %limit
	syscall
.end_macro

.macro SyscallProcessChange
	li $v0, 61
	syscall
.end_macro

.macro ProcessTerminate
	li $v0, 62
	syscall
.end_macro


