.macro done
li $v0, 10
syscall
.end_macro

.macro print_int (%x)
li $v0, 1
add $a0, $zero, %x
syscall
.end_macro

.macro print_char (%c)
.data
chr: .byte %c
.text
li $v0, 11
lb $a0, chr
syscall
.end_macro

.macro print_string (%str)
.data
myLabel: .asciiz %str
.text
li $v0, 4
la $a0, myLabel
syscall
.end_macro

.macro read_int
li $v0, 5
syscall
move $t1, $v0
.end_macro

.macro read_char
li $v0, 12
syscall
move $t0, $v0
.end_macro

.macro read_string (%b)
.data
buffer: .space %b
.text
li $v0, 8
la $a0, buffer
li $a1, %b
move $t0, $a0
syscall
.end_macro

.macro return (%r)
li $a0, %r
bgez $a0, else
li $v0, 17
syscall
else:
done
.end_macro

.macro load_var (%var, %address)
la $t0, %var
lw %address, 0($t0)
.end_macro 

.macro store_var (%var, %address)
la $t0, %var
sw %address, 0($t0)
.end_macro 

.macro Fork (%labelStart)
li $v0, 60
la $a0, %labelStart
syscall
.end_macro

.macro Fork (%labelStart, %labelEnd)
li $v0, 60
la $a0, %labelStart
la $a1, %labelEnd
syscall
.end_macro

.macro ProcessTerminate
li $v0, 62
syscall
.end_macro

.macro ProcessChange
li $v0, 61
syscall
.end_macro
