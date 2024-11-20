# Współbieżność w Javie – Problem Producenta i Konsumenta

## Przegląd

Projekt implementuje rozwiązanie klasycznego problemu producenta i konsumenta za pomocą monitorów w Javie. Symulacja ilustruje, jak producent i konsument współpracują w ograniczonym buforze, zapewniając synchronizację za pomocą metod `wait()` i `notifyAll()`. Celem projektu jest zrozumienie mechanizmów synchronizacji w programowaniu wielowątkowym.

## Główne funkcje

Program implementuje klasyczny problem producenta i konsumenta, używając monitorów do synchronizacji:

1. **Producent** – Dodaje elementy do bufora, czekając, gdy bufor jest pełny.
2. **Konsument** – Pobiera elementy z bufora, czekając, gdy bufor jest pusty.
3. **Bufor** – Monitor z ograniczoną pojemnością, zarządzający synchronizacją wątków.

## Struktura projektu

- `Bufor` – Klasa implementująca monitor.
- `Producent` i `Konsument` – Klasy reprezentujące odpowiednie role w problemie.
- `Main` – Klasa uruchamiająca program i konfigurująca symulację.

## Wyniki

Pełne wyniki działania programu są dostępne w pliku:  
[results.txt](https://github.com/akotu235/PKmon/blob/master/results/results.txt)

## Raport

Szczegóły implementacji i analizy:

- [Raport](report/report.md) – Rozwiązanie problemu producenta i konsumenta za pomocą monitorów.