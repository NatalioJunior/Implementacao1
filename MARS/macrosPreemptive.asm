.macro SyscallFork(%address)
	li $v0, 60
	la $a0, %address
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


