#Static-Multilevel-Scheduler
This was implemented by following the specification (in hungarian) below:

> Készítsen egy programot, amely statikus többszintű ütemező működését
> szimulálja!
> 
> Az ütemező 0 és 9 közötti statikus prioritású (0 a legmagasabb)
> taszkokat kezel az alábbi szinteken és algoritmusokkal:
> 
>     1. szint (0-4 közötti prioritás) nem preemptív, SJF ütemező
>     (a prioritás a szinten belül már nem játszik szerepet, "vegytiszta" SJF ütemezési algoritmus működik)
>     2. szint (5-9) preemptív RR ütemező, időszelet: 2
>     (a prioritás a szinten belül itt sem játszik szerepet, "vegytiszta" RR ütemező fut)
> 
> Bemenet (standard input, stdin)
> 
> Soronként egy (max. 10) taszk adatai. Egy sor felépítése (vesszővel
> elválasztva):
> 
>     a taszk betűjele (A, B, C...) megfelel az érkezési sorrendnek
>     a taszk prioritása (0-9)
>     a taszk indítási ideje (egész szám >= 0), a következő időszeletben már futhat (0: az ütemező indításakor már létezik)
>     a taszk CPU-löketideje (egész szám >= 1)
> 
> Példa:
> 
> A,3,0,5 B,4,0,4 C,6,5,8 D,6,7,8
> 
> A bemenet végét egy üres sor (utána EOF) jelzi. Ekkor kell a kimenetre
> kiírni az eredményt. Kimenet (standard output, stdout)
> 
> A kimenet első sorában a taszkok futási sorrendje betűjeleikkel (csak
> betűk, szóközök nélkül). A második sorban a teljes várakozási idő
> taszkonként, a befejezésük sorrendjében az alábbi formában (vesszővel
> elválasztva, szóközök nélkül):
> 
> 1. taszk betűjel:várakozási idő,2. betűjel:várakozási idő, ...
> 
> Példa (a fenti bemenetre adott válasz):
> 
> BACDCDCDCD B:0,A:4,C:10,D:10