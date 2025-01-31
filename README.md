# Współbieżność w Javie – Problem Producenta i Konsumenta

## Przegląd

Projekt implementuje rozwiązanie klasycznego problemu producenta i konsumenta za pomocą monitorów oraz wersji opartej o `BlockingQueue` w Javie. Symulacja ilustruje, jak producent i konsument współpracują w ograniczonym buforze, zapewniając synchronizację za pomocą metod `wait()` i `notifyAll()` w jednej wersji oraz przy użyciu `BlockingQueue` w drugiej. Celem projektu jest zrozumienie mechanizmów synchronizacji w programowaniu wielowątkowym.

## Główne funkcje

Program implementuje klasyczny problem producenta i konsumenta, używając monitorów do synchronizacji:

1. **Producent** – Dodaje elementy do bufora, czekając, gdy bufor jest pełny.
2. **Konsument** – Pobiera elementy z bufora, czekając, gdy bufor jest pusty.
3. **Bufor** – Monitor z ograniczoną pojemnością, zarządzający synchronizacją wątków.

## Struktura projektu

- `Bufor` – Interfejs definiujący operacje bufora.
- `BuforV1` – Klasa implementująca monitor.
- `BuforV2` – Klasa implementująca bufor oparty o `BlockingQueue`.
- `Producent` i `Konsument` – Klasy reprezentujące odpowiednie role w problemie.
- `PKmon` – Klasa uruchamiająca program i konfigurująca symulację.

## Wyniki

Pełne wyniki działania programu są dostępne w pliku:  
[results.txt](https://github.com/akotu235/PKmon/blob/master/results/results.txt)

## Raport

Szczegóły implementacji i analizy:

- [Raport 1](report/report.md) – Rozwiązanie problemu producenta i konsumenta za pomocą monitorów.
- [Raport 2](https://github.com/akotu235/Tury/blob/master/report/report.md) – Rozwiązanie problemu producenta i konsumenta za pomocą mechanizmów Java Concurrency Utilities (JCU).