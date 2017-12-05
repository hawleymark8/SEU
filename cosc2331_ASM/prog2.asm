; prog2.asm
; author: Mark Hawley

;unitialized data section
	section .bss
	string_read resb 71
	string_len resd 1

;intialized data section
	section .data
	string_in db "Input String: ",10 ;input for string
	len1 equ $ - string_in	      ;length for string_in
	string_out db "Original String: ",10      ;output for string
	len2 equ $ - string_out	      ;length for string_out
	string_up db "Upper case String: ", 10 ;output for string
	len3 equ $ - string_up		       ;length for string_up
	string_low db "Lower case String: ",10 ;output for string
	len4 equ $ - string_low		       ;length for string_low
	newline db 10		      ;string for LF

	section .text
	global _start
_start:
;; read string
;; -prompt for string
	mov edx, len1	   ;message length
	mov ecx, string_in ;string_in message to be output
	mov ebx, 1	   ;standard out
	mov eax, 4	   ;sys_write
	int 80h		   ;interrupt and output string
;; -read string, store under string_read
	mov edx, 71		;max chars to read
	mov ecx, string_read	;store under string_read
	mov ebx, 2		;standard in
	mov eax, 3		;read
	int 80h			;interrupt and read string

	mov dword [string_len], eax ;move into eax
;; echo string inputted
;; -output string_out
	mov edx, len2		;message length
	mov ecx, string_out	;string_out to be output
	mov ebx, 1		;standard out
	mov eax, 4		;sys_write
	int 80h
;; -output string_read
	mov edx, dword [string_len] ;length
	mov ecx, string_read	    ;string_read to be output
	mov ebx, 1		    ;standard out
	mov eax, 4		    ;sys_write
	int 80h
;; capitalize all letters
	mov [string_len], eax	
	mov edi, string_read  ;string address
	mov ecx, eax	      ;length of string for counter
top_loop:
	cmp [edi], byte 'a'	;compare to 'a'
	jl not_lower_case	;jump if less than
	cmp [edi], byte 'z'	;compare to 'z'
	jg not_lower_case	;jump is greater than
	sub [edi], byte 32	;character is a lowercase letter-subtract by 32 to capitalize
not_lower_case:
	inc edi			;increment to next character
	loop top_loop		;decrement ecx
;; echo string_read with capital letters
;; -output string_out
	mov edx, len3		;message length
	mov ecx, string_up	;string_out to be output
	mov ebx, 1		;standard out
	mov eax, 4		;sys_write
	int 80h
;; -output string_read
	mov edx, dword [string_len] ;length
	mov ecx, string_read	    ;string_read to be output
	mov ebx, 1		    ;standard out
	mov eax, 4		    ;sys_write
	int 80h
;; lower case all letters
	mov [string_len], eax	
	mov edi, string_read  ;string address
	mov ecx, eax	      ;length of string for counter
top_loop2:
	cmp [edi], byte 'A'	;compare to 'A'
	jl not_upper_case	;jump if less than
	cmp [edi], byte 'Z'	;compare to 'Z'
	jg not_upper_case	;jump is greater than
	add [edi], byte 32	;character is a uppercase letter-add by 32 to lower case
not_upper_case:
	inc edi			;increment to next character
	loop top_loop2		;decrement ecx
;; echo string_read with lower case letters
;; -output string_out
	mov edx, len4		;message length
	mov ecx, string_low	;string_out to be output
	mov ebx, 1		;standard out
	mov eax, 4		;sys_write
	int 80h
;; -output string
	mov edx, dword [string_len] ;length
	mov ecx, string_read	    ;string_read to be output

	dec ecx			;decrement to take off last newline char

	mov ebx, 1		    ;standard out
	mov eax, 4		    ;sys_write
	int 80h
;; -print new line
	mov edx, 1		;1 char to print
	mov ecx, newline	;load address of char
	mov ebx, 1		;standard out
	mov eax, 4		;sys_write
	int 80h
;; exit program
	mov ebx, 0		;the stop interrupt
	mov eax, 1		;eax = 0, ebx = 1
	int 80h