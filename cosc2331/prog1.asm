; Program 1 COSC 2331
; Author:  Mark Hawley
; prompts input and outputs message

;uninitialized data section
	section .bss
	my_name resb 80
	name_len resd 1
	my_major resb 80
	major_len resd 1

;initialized data section
	section .data
	hello_msg db "Aloha ",10 ;the 10 is the newline
	len1 equ $ - hello_msg 	;length of hello_msg
	prompt_name db "What is your name?"
	len2 equ $ - prompt_name ;length of prompt_name
	prompt_major db "What is your major?"
	len3 equ $ - prompt_major ;length of prompt_major
	welcome_msg db "Welcome to Assembly Language, "
	len4 equ $ - welcome_msg ;length of welcome_msg
	welcome_msg2 db ", "
	len5 equ $ - welcome_msg2 ;length of welcome_msg2
	welcome_msg3 db " is a stressful major"
	len6 equ $ - welcome_msg3 ;length of welcome_msg3
	newline db 10		 ;string for LineFeed(LF)

	section .text

	global _start

        _start:
	mov edx,len1		;message length
	mov ecx, hello_msg	;pointer to message to write
	mov ebx,1		;file handle (stdout)
	mov eax,4		;system call number (sys_write)
	int 0x80		;call kernel to perform the interrupt (output string)

	;now to output prompt for name
	mov edx, len2 		;message length
	mov ecx, prompt_name	;pointer to message to write
	mov ebx,1		;first argument: file handle (stdout)
	mov eax,4		;system call number (sys_write)
	int 0x80		;call kernel to perform the interrupt (output string)
	
	;now to read name
	mov edx, 80		;max chars to read
	mov ecx, my_name	;where to store input value
	mov ebx, 2		;where to read from (stdin)
	mov eax, 3		;read
	int 0x80		;call kernel to perform the interrupt (input string)

	;now save size of string input
	;which is placed into the eax register by interrupt
	dec eax			;don't count new line
	mov dword [name_len], eax
	
	;now to output prompt for major	
	mov edx, len3		;message length
	mov ecx, prompt_major	;pointer to message to write
	mov ebx,1		;first argument: file handle (stdout)
	mov eax,4		;system call number (sys_write)
	int 0x80		;call kernel to perform the interrupt (output string)
	
	;now to read major
	mov edx, 80		;max chars to read
	mov ecx, my_major	;where to store input value
	mov ebx, 2		;where to read from (stdin)
	mov eax, 3		;read
	int 0x80		;call kernel to perform the interrupt (input string)

	;now to save size of string input
	;which is placed into the eax register by inerrupt
	dec eax			;don't count new line
	mov dword [major_len], eax ;

	;now to output full message
	mov edx,len4		;message length
	mov ecx,welcome_msg	;second argument: pointer to message to write
	mov ebx,1		;first argument: file handle (stdout)
	mov eax,4		;system call number (sys_write)
	int 0x80		;call kernel to perform the interrupt

	mov edx, dword [name_len]
	mov ecx, my_name
	mov ebx, 1
	mov eax, 4
	int 0x80		;call kernel to perform the interrupt

	mov edx, len5		;message length
	mov ecx,welcome_msg2	;second argument: pointer to message to write
	mov ebx,1		;first argument: file handle (stdout)
	mov eax,4		;system call number (sys_write)
	int 0x80		;call kernel to perform the interrupt
	
	mov edx, dword [major_len] 
	mov ecx, my_major	  
	mov ebx, 1
	mov eax, 4
	int 0x80		;call kernel to perform the interrupt

	mov edx, len6		;message length
	mov ecx,welcome_msg3	;second argument: pointer to message to write
	mov ebx,1		;first argument: file handle (stdout)
	mov eax,4		;system call number (sys_write)
	int 0x80		;call kernel to perform the interrupt

	;now print the new line
	mov edx, 1		;1 character to print
	mov ecx, newline	;load address of character
	mov ebx, 1 		;ebx = 1
	mov eax, 4		;eax = 4
	int 0x80		;call kernel to perform the interrupt

	;now exit the program
	mov ebx, 0		;the stop interrupt
	mov eax, 1		;eax = 0, ebx = 1
	int 0x80		;call kernel to perform the interrupt (stop)