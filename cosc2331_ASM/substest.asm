;; tests mysubs.asm routines
;; Mark Hawley

;; list those routines that should be found outside of this file
;; (usually all of the subroutines called)
extern readString, writeString, upperCaseString, lowerCaseString, newLine, isNumeric

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
   is_Numeric db 'Is a number!';
   isNumericlen equ $-is_Numeric
   notNumeric db 'Is NOT a number!';
   notNumericlen equ $-notNumeric

;; uninitialized data 
section .bss
   string1 resb 1000
   string1Len resd 1

;; code section
section .text
 _start:
       ;; set up the call to writeString(addr of string, #chars)
       push dword promptLen        ; arg2 - length of string
       push dword prompt           ; arg1 - address of string
       call writeString
 
       ;; set up the call to int readString(address of string, max # to read)
       push dword 1000            ; arg2 - max chars to read
       push dword string1               ; arg1 - address of string to store
       call readString          
       mov [string1Len], eax     ; get returned value store it into memory

       ;; set up the call to upperCaseString(addr of string, #chars)
       push dword [string1Len]     ;  arg2 - length of string
       push dword string1          ; address of string
       call upperCaseString        

       call newLine              ; no args to send - just outputs a newline
    
       ;; set up the call to writeString(addr of string, #chars)
       push dword messageLen1        ; arg2 - length of string
       push dword message1           ; arg1 - address of string
       call writeString

       call newLine
       ;; set up the call to writeString(addr of string, #chars)
       push dword [string1Len]        ; arg2 - length of string
       push dword string1             ; arg1 - address of string
       call writeString
 
       call newLine                  ; output newline

       ;; set up the call to lowerCaseString(addr of string, #chars)
       push dword [string1Len]     ;  arg2 - length of string
       push dword string1          ; address of string
       call lowerCaseString 

       call newLine              ; no args to send - just outputs a newline
    
       ;; set up the call to writeString(addr of string, #chars)
       push dword messageLen2        ; arg2 - length of string
       push dword message2           ; arg1 - address of string
       call writeString

       call newLine
       ;; set up the call to writeString(addr of string, #chars)
       push dword [string1Len]        ; arg2 - length of string
       push dword string1             ; arg1 - address of string
       call writeString
 
       call newLine                  ; output newline
       
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
       call isNumeric
       
       test eax, eax
       je not_numeric
       
       push dword isNumericlen        ; arg2 - length of string
       push dword is_Numeric           ; arg1 - address of string
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

