;;  mysubs.asm
;;  subprograms to do a few commonly needed tasks
;;  Mark Hawley

;;; declare the global methods
 global  readString, upperCaseString, lowerCaseString, writeString, newLine, isNumeric, stringToInt, intToString, getData, findMin, findMax, computeAverage, printList, insertionSort, selectionSort

section .data
    prompt1 db 'Enter an int. X to Stop: '
    prompt1Len equ $-prompt1
    negFlag db 0

section .bss
    string resb 20
    stringLen resd 1
	
 section .text

;;;;; void newLine()  outputs a crlf sequence to screen
;     no arguments sent - 
 newLine:  
   push ebp               ; save old ebp
   mov ebp,esp            ; establish current ebp
   sub esp, 4             ; reserve 4 bytes of local memory
   pushad                 ; push all registers (doubleword registers)
   lea esi, [ebp-4]
   mov byte[esi], 13      ; store a cr character (ascii code 13)
   inc esi                ; move up 1 byte for next character
   mov byte [esi], 10     ; store a lf character (ascii code 10)
   lea esi, [ebp-4]       ; load address of ebp-4 into esi (the crlf)
   mov ecx, 2             ; count of chars in crlf string
   push ecx               ; push arg2 ( #chars)
   push esi               ; push arg 1 (addr of string to write)
   call writeString       ; void writeString(addr of string , #chars in string)
   
   popad                  ; restore all registers (pop all doubleword registers)
   add esp, 4             ; remove local stack data
   pop ebp                ; restore old ebp
        
   ret                    ; go back! (no arguments sent, so none to pop)


writeString:  ;  routine that writes  a string to stdoutput
 		      ; void writeString(string addr, int charCount) returns nothing

    push ebp      ; save the old ebp
    mov ebp, esp  ; establish ebp for this subroutine
    pushad
               ;; set up int 80h for output a string
    mov eax, 4
    mov ebx, 1
    mov ecx, [ebp+8]    ; address of string is 1st argument
    mov edx, [ebp+12]   ; number of chars in string is 2nd argument
    int 80h

             ;; restore registers we used
    popad
    pop ebp
    ret 8    ;; return and pop 2 arguments from the stack


readString:      ;; routine that reads a string from keyboard
				 ;; int readString(string addr, maxCharsToRead)
                 ;; returns #chars read

    push ebp      ;; save old ebp
    mov ebp, esp  ;; establish new ebp
    push ebx      ;; save ebx, ecx, edx (NOT eax though)
    push ecx
    push edx

    mov eax, 3    ;; set up the int 80h call for read a string
    mov ebx, 2
    mov ecx, [ebp+8]   ;; first argument at [ebp+8] -- string address
    mov edx, [ebp+12]  ;; second argument at [ebp+12] -- max chars to read
    int 80h

    dec eax       ;  take away 1 for the newline char
    pop edx       ;; restore the saved registers (not eax!)
    pop ecx
    pop ebx
    pop ebp       ;; restore the old ebp
    ret 8         ; be sure to pop of 8 bytes for 2 arguments passed 

;;;;;   void upperCaseString (address of string, int numCharsInString)
 upperCaseString:
    push ebp         ; save old ebp
    mov ebp, esp     ; establish our ebp
    pushad           ; save ALL doubleword registers
   
    mov esi, [ebp+8]  ; get address of string to uppercase
    mov ecx, [ebp+12] ; get count of chars into ecx
    mov al, 'a'       ; for comparing against 'a' is lower limit
    mov ah, 'z'       ; for comparing against 'z' is upper limit

mySubs_Loop1:
    mov bl, [esi]     ; get next character of string into bl
    cmp bl, al        ; compare character to letter 'a'
    jb mySubs_not_lower_case
    cmp bl, ah        ; is it greater than 'z' ?
    ja mySubs_not_lower_case

    sub bl, 32        ; convert bl to uppercase equivalent
    mov [esi], bl     ; store character back into string
    
mySubs_not_lower_case:
    inc esi
    loop mySubs_Loop1

    popad             ; restore all doubleword registers
    pop ebp           ; restore old ebp
    ret 8             ; pop 2 args from stack

;;;;;   void lowerCaseString (address of string, int numCharsInString)
lowerCaseString:
    push ebp         ; save old ebp
    mov ebp, esp     ; establish our ebp
    pushad           ; save ALL doubleword registers
    
   
    mov esi, [ebp+8]  ; get address of string to uppercase
    mov ecx, [ebp+12] ; get count of chars into ecx
    mov al, 'A'       ; for comparing against 'a' is lower limit
    mov ah, 'Z'       ; for comparing against 'z' is upper limit

mySubs_Loop2:
    mov bl, [esi]     ; get next character of string into bl
    cmp bl, al        ; compare character to letter 'a'
    jb mySubs_not_upper_case
    cmp bl, ah        ; is it greater than 'z' ?
    ja mySubs_not_upper_case

    add bl, 32        ; convert bl to uppercase equivalent
    mov [esi], bl     ; store character back into string
    
mySubs_not_upper_case:
    inc esi
    loop mySubs_Loop2

    popad             ; restore all doubleword registers
    pop ebp           ; restore old ebp
    ret 8             ; pop 2 args from stack
    
;;;;;int isNumeric(String str, int strLen) 
;receives: str a string of length strLen 
;returns: true (1) if str contains all numeric characters (base 10) returns false (0) if not. str may have a leading "+" or a leading "-".
isNumeric:
	
	push ebp         ; save old ebp
    mov ebp, esp     ; establish our ebp
    push ebx      ;; save ebx, ecx, edx (NOT eax though)
    push ecx
    push edx
    push esi
	
    mov esi, [ebp+8]  ; get address of string to uppercase
    mov ecx, [ebp+12] ; get count of chars into ecx
	
    mov al, '0'       ; for comparing against '0' is lower limit
    mov ah, '9'       ; for comparing against '9' is upper limit
	
	cmp [esi], byte '+'
	jne checkMinus
	dec ecx
	inc esi
	jmp mySubs_Loop3

checkMinus:
	cmp [esi], byte '-'
	jne mySubs_Loop3
	dec ecx
	inc esi
	
mySubs_Loop3:
    mov bl, [esi]     ; get next character of string into bl
    cmp bl, al        ; compare character to letter '0'
    jl mySubs_not_numeric
    cmp bl, ah        ; is it greater than '9' ?
    jg mySubs_not_numeric

    inc esi
    loop mySubs_Loop3
    
    mov eax, 1
    jmp finishNumeric
    
mySubs_not_numeric:
	mov eax, 0
	
finishNumeric:
	pop esi
	pop edx       ;; restore the saved registers (not eax!)
    pop ecx
    pop ebx
    pop ebp       ;; restore the old ebp
	ret 8
	
	
;;;;;int stringToInt(StringAddress strAddr, int strLen)
	;receives: strAddr the address of the string containing the integer
	;strLen the length of the string containing the integer
	;returns:  the int value of the given string at strAddr with length strLen
	;invalid strings stop the routine and print an error message and exit.	
stringToInt:
	push ebp      ;; save old ebp
    mov ebp, esp  ;; establish new ebp
    push ebx      ;; save ebx, ecx, edx (NOT eax though)
    push ecx
    push edx
    push edi
 
    mov edi, [ebp+8] ;storing address
    xor eax, eax
    mov ecx, [ebp+12];string length
    mov ebx, 10

 ;; push items then call
    push dword [ebp+12]
    push dword [ebp+8]
    call isNumeric
    test eax, eax
    jz finishStringToInt  ;; if false/not number, skips conversion
	xor esi, esi
    cmp [edi], byte '+' ;;reset edi before this?
    jne checkMinus2
    dec ecx
    inc edi
    jmp pre_loopbody

checkMinus2:
 cmp [edi], byte '-'
 jne pre_loopbody
 dec ecx
 inc edi
 mov esi, 1

pre_loopbody:
	xor eax, eax
    
loopbody:
	mul ebx
	xor edx, edx
    mov dl, [edi] ;get next char out of stirng
    sub dl, 48 ;edx has numeric value of the character in all 32 bits
    add eax, edx
    inc edi
    loop loopbody
    
    test esi, esi
    je finishStringToInt
    neg eax

finishStringToInt:
    pop edi
    pop edx       ;; restore the saved registers (not eax!)
    pop ecx
    pop ebx
    pop ebp       ;; restore the old ebp

    ret 8         ; be sure to pop of 8 bytes for 2 arguments passed
	
;;;;;int intToString (address of string, int value to convert)
intToString:
	push ebp
	mov ebp, esp
	push ebx
	push ecx
	push edx
	push edi
	push esi
	
	mov edi, [ebp + 8]; string address into edi
	mov eax, [ebp + 12]; value to convert
	test eax, eax; compare with 0
	jg positive
	jl negative
	;else if int == 0
	mov [edi], byte 48; move char 0 out to string
	mov eax, 1; size is 1
	jmp doneIntToString
	
positive: ;if value is positive
	mov [edi], byte '+'; put + into string
	inc edi
	jmp pre_loop
	
negative: ;if value is negative
	mov [edi], byte '-'; put - into string
	neg eax; make value positive
	inc edi
	jmp pre_loop
	
pre_loop:
	xor ecx, ecx; clear out ecx digit counter
	mov ebx, 10; for help with division
	
top_loop:
	xor edx, edx; clear out for division
	div ebx;
	add edx, 48; convert from decimal to ascii
	push edx; push ascii char onto stack
	inc ecx; increment digit counter
	test eax, eax
	jne top_loop
	
	mov eax, 1; length of string is 1 because of +/-
	xor edx, edx
	
top_loop2:
	pop edx
	mov [edi], dl; put ascii char into string address
	inc edi; go to next slot in string address
	inc eax
	loop top_loop2
	
doneIntToString:
	pop esi
	pop edi
	pop edx
	pop ecx
	pop ebx
	pop ebp
	ret 8
	
;;;;;int getData(addrOfArrayOfInts, max#ToRead)
	 ;returns # of values input into the array
getData:
	;;setup
	push ebp
	mov ebp, esp
	push ebx
	push esi
	push ecx
	push edx
	push edi
	
	;;setup registers
	mov edi, [ebp+8];addrOfArrayOfInts
	mov dl, 'X'; used for end of array
	mov ebx, [ebp+12]; max number to read
	mov esi, 12; max chars to read as input
	
	xor ecx, ecx; this is counter for number of ints read
 
getData_loop:
	cmp ecx, ebx; if counter >= max number to read
	jge done_reading

	call newLine
	;print prompt for number
	push dword prompt1Len
	push dword prompt1
	call writeString ;(string addr, int charCount) returns nothing

	;read in next number
	xor eax, eax
	push dword 12
	push dword string
	call readString ;(string addr, maxCharsToRead) returns # of chars read
	mov [stringLen], eax 	;put string length into stringLen
postread:
	;check for 'X'
	cmp [string], dl; if input = 'X' bail out of loop
	je done_reading

	;if input != 'X' convert input into an int
	push dword [stringLen]
	push dword string
	call stringToInt ;(StringAddress strAddr, int strLen) returns the int value

	;store value from stringToInt into the array
	mov [edi], eax
	
	;finish up the loop
	add edi, 4 ;go to the next spot in the array
	inc ecx ;increment the counter
	jmp getData_loop	

done_reading:
	mov eax, ecx ;put the count into eax to return

	;finish up method
	pop edi
	pop edx
	pop ecx
	pop esi
	pop ebx
	pop ebp
	ret 8
	
	;;;;;int findMax(addr of array of ints, number of ints in array)
findMax:
push ebp      ;; save old ebp
    mov ebp, esp  ;; establish new ebp
    push ebx      ;; save ebx, ecx, edx (NOT eax though)
    push ecx      ;; count
    push edi   ;; array address

    mov edi, [ebp+8]
    mov ecx, [ebp+12] ;;count
    mov eax, [edi]
    dec ecx
    add edi, 4
    test ecx, ecx
    jz done2
findMax_loop:
    cmp eax, [edi]
    jge skip
    mov eax, [edi]
skip:
    add edi, 4
    loop findMax_loop
done2:
    pop edi
    pop ecx
    pop ebx
    pop ebp
    ret 8
    
;;;;;int findMin(addr of array of ints, number of ints in array)
findMin:
push ebp      ;; save old ebp
    mov ebp, esp  ;; establish new ebp
    push ebx      ;; save ebx, ecx, edx (NOT eax though)
    push ecx      ;; count
    push edi   ;; array address

    mov edi, [ebp+8]
    mov ecx, [ebp+12]
    mov eax, [edi]
    dec ecx
    add edi, 4
    test ecx, ecx
    jz done
findMin_loop:
    cmp eax, [edi]
    jle skip1
    mov eax, [edi]
skip1:
    add edi, 4
    loop findMin_loop

    pop edi
    pop ecx
    pop ebx
    pop ebp
    ret 8

;;;;;int computeAverage(addr of array of ints, number of ints in array)
computeAverage:
push ebp
    mov ebp, esp ;;
    push ebx ;;
    push ecx ;; # of ints in array
    push edx ;; quotient
    push edi ;; array address

    mov edi, [ebp+8]
    mov ecx, [ebp+12]
    mov eax, [edi]
    add edi, 4
sum_loop:
    mov ebx, [edi] ;;next int into eax
    add eax, ebx ;;add ebx and eax, sum in eax
    add edi, 4  ;;next int in array
    loop sum_loop

    cmp eax, 0
    jge positive1
    neg eax
    mov [negFlag], byte 1  ;;negFlag 1 = negative number
positive1:
	xor edx, edx
    mov ebx, [ebp+12]   ;;put count of ints in ebx
    div ebx  ;;edx:eax/ebx
    add edx, edx ;;add remainder to itself
    cmp edx, ebx
    jl roundDown
    inc eax  ;;round off
roundDown:
    cmp [negFlag], byte 1
    jne done
    neg eax
done:    

    pop edi
    pop edx
    pop ecx
    pop ebx
    pop ebp
    ret 8
    
;;;;;void printList(address of array of ints, number of elements in array) 
	;outputs each integer in array to screen, 1 per line    
printList:
	push ebp
	mov ebp, esp
	sub esp, 20 ;stack space
	pushad
	lea esi, [ebp-20]
	mov edi, [ebp+8] ;list address
	mov ecx, [ebp+12] ;num of elements
	test ecx, ecx
	je done_printList
	
printList_loop:
	mov ebx, [edi]
	
	push ebx
	push esi
	call intToString
	
	push eax
	push esi
	call writeString
	call newLine
	
	add edi, 4
	loop printList_loop
	
done_printList:
	popad
	add esp, 20
	pop ebp
	ret 8
	
;;;;;void insertionSort(address of array of ints, number of elements in array) 
	;sorts the array into ascending order	
insertionSort:
	push ebp
	mov ebp, esp
	pushad
	
	mov ebx, [ebp+8] ;backstop
	mov ecx, [ebp+12] ;count
	dec ecx
	test ecx, ecx
	jle doneInsertionSort
	mov edi, ebx

outInsertLoop:
	add edi, 4
	mov esi, edi
	
inInsertLoop:
	cmp ebx, esi
	jae endInsertWhile
	mov eax, [esi]
	sub esi, 4
	cmp eax, [esi]
	jge endInsertWhile
	push eax
	push dword [esi]
	pop dword [esi+4]
	pop dword [esi]
	jmp inInsertLoop
	
endInsertWhile:
	loop outInsertLoop
	
doneInsertionSort:
	popad
	pop ebp
	ret 8
	
;;;;;void selectionSort(address of array of ints, number of elements in array) 
	;sorts the array into ascending order	
selectionSort:
	push ebp
	mov ebp, esp
	pushad
	
	mov ecx, [ebp+12]
	dec ecx
	test ecx, ecx
	jle doneSelectionSort
	
	mov esi, [ebp+8]
	
outSelectionLoop:
	mov edi, esi
	mov edx, ecx
	mov ebx, edi
	add ebx,  4
	
inSelectionLoop:
	mov eax, [ebx]
	cmp eax, [edi]
	jge skipIf
	mov edi, ebx
	
skipIf:
	add ebx, 4
	dec edx
	test edx, edx
	jg inSelectionLoop
	push dword [edi]
	push dword [esi]
	pop dword [edi]
	pop dword [esi]
	add esi, 4
	loop outSelectionLoop
	
doneSelectionSort:
	popad
	pop ebp
	ret 8
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	