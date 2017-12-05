;; prog5-6.asm
;; Mark Hawley

;; list those routines that should be found outside of this file
;; (usually all of the subroutines called)
extern readString, writeString, upperCaseString, newLine, isNumeric, lowerCaseString, getData, findMax, intToString, findMin, computeAverage, printList, insertionSort, selectionSort

;; list those routines
global _start    ;  flag those routines in this file that are
                 ;  to be known outside of the file

;; main method's data
section .data
   message db 'Maximum: ';
   messageLen equ $-message
   message2 db 'Minimum: ';
   messageLen2 equ $-message2
   message3 db 'Rounded Average: ';
   messageLen3 equ $-message3
   message4 db 'Sorted: ';
   messageLen4 equ $-message4
   MAX equ 10

;; uninitialized data
section .bss
   list resd MAX
   count resb 1
   answer resb 1000
   answerLen resb 1
   answer2 resb 1000
   answerLen2 resb 1

;; code section
section .text
 _start:

       push dword MAX     ; arg2 - length of string
       push dword list             ; arg1 - address of string
       call getData

       mov [count], eax     ; # of values input into array stored
       mov edx, eax

	;find max
       push dword [count]    ; arg2 - max chars to read
       push dword list            ; arg1 - address of string to store
       call findMax
b1:
       push dword messageLen
       push dword message
       call writeString     ;output "Maximum"

       mov [answer2], eax

       push dword [answer2]
       push dword answer
       call intToString

       mov [answerLen], eax

       push dword answerLen
       push dword answer
       call writeString
       call newLine
       
       mov [count], edx	; restore count
b2:
       ;find min
       push dword [count] 
       push dword list  
       call findMin
       
       push dword messageLen2
       push dword message2
       call writeString     ;output "Minimum"
       
       mov [answer2], eax

       push dword [answer2]
       push dword answer
       call intToString

       mov [answerLen], eax

       push dword answerLen
       push dword answer
       call writeString
       call newLine
b3:       
       mov [count], edx	; restore count
       
       ;find average
       push dword [count] 
       push dword list  
       call computeAverage
       
       push dword messageLen3
       push dword message3
       call writeString     ;output "Rounded average"
       
       mov [answer2], eax

       push dword [answer2]
       push dword answer
       call intToString

       mov [answerLen], eax

       push dword answerLen
       push dword answer
       call writeString
       call newLine
       
       mov [count], edx	; restore count
       
       push dword [count] 
       push dword list  
       call printList
       call newLine
       
	   push dword messageLen4
       push dword message4
       call writeString     ;output "Sorted"
       
       mov [count], edx	; restore count
       
       push dword [count]
       push dword list
       call selectionSort
       
       mov [count], edx	; restore count
       
       push dword [count] 
       push dword list  
       call printList
       

;;;; Exit Program
       mov ebx,0
       mov eax, 1
       int 80h
