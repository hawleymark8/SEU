;; tests mysubs.asm routines

;; list those routines that should be found outside of this file
;; (usually all of the subroutines called)
extern readString, writeString, upperCaseString, lowerCaseString, newLine, isNumeric, intToString, stringToInt

;; list those routines 
global _start    ;  flag those routines in this file that are 
                 ;  to be known outside of the file

;; main method's data
section .data
   prompt db 'Enter a sentence: ';
   promptLen equ $-prompt
   prompt2 db 'Enter a number: ';
   promptLen2 equ $-prompt2
   message1 db 'Here is the string in uppercase: ';
   messageLen1 equ $-message1
   message2 db 'Here is the string in lowercase: ';
   messageLen2 equ $-message2
   is_Result db 'Is the result!';
   isResultlen equ $-is_Result
   notNumeric db 'Is NOT a number!';
   notNumericlen equ $-notNumeric

;; uninitialized data 
section .bss
   string1 resb 1000
   string1Len resd 1

;; code section
section .text
 _start:
       push dword promptLen2        ; arg2 - length of string
       push dword prompt2           ; arg1 - address of string
       call writeString
       
       push dword 1000            ; arg2 - max chars to read
       push dword string1               ; arg1 - address of string to store
       call readString          
       mov [string1Len], eax     ; get returned value store it into memory
       
       xor eax, eax
       
       push dword [string1Len]     ;  arg2 - length of string
       push dword string1          ; address of string
       call stringToInt
       
       test eax, eax
       je not_numeric
b1:
	mov ebx, 13
       imul ebx
b2:
       push eax
       push dword string1
       call intToString
       
	mov [string1Len], eax
       push dword [string1Len]
       push dword string1
       call writeString

       call newLine
       
       push dword isResultlen        ; arg2 - length of string
       push dword is_Result           ; arg1 - address of string
       call writeString
       jmp finish
       
not_numeric:
       push dword notNumericlen        ; arg2 - length of string
       push dword notNumeric           ; arg1 - address of string
       call writeString
       
finish:
	   call newLine                  ; output newline

       mov ebx, 0
       mov eax, 1
       int 80h

