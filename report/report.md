### [Laboratorium 3](https://artemis.wszib.edu.pl/~funika/pwir/tw/lab3/)
# Temat: Współbieżność w Javie
### **Andrzej Kotulski**
#### 10.11.2024r.

---



## 1. Co było do zrobienia

Celem laboratorium było zapoznanie się z&nbsp;mechanizmami współbieżności w&nbsp;Javie oraz realizacja rozwiązania problemu producentów i&nbsp;konsumentów z&nbsp;wykorzystaniem monitorów.

W szczególności:

* Zastosowanie oczekiwania warunkowego w&nbsp;monitorach.
* Implementacja synchronizacji w Javie przy pomocy wbudowanych mechanizmów `wait()` i&nbsp;`notifyAll()`.
* Przeprowadzenie testów w&nbsp;środowisku wielowątkowym.

## 2. Podejście do rozwiązania problemu

Przy rozwiązaniu problemu producentów i&nbsp;konsumentów przyjęto podejście z wykorzystaniem klasy `Bufor`, która pełni rolę mechanizmu synchronizującego dostęp do zasobów. Producent wstawia elementy do&nbsp;bufora, a&nbsp;konsument je&nbsp;pobiera. Synchronizacja została osiągnięta za&nbsp;pomocą metod `wait()` i&nbsp;`notifyAll()`.

Główne założenia:

* Producent nie może dodać elementu do&nbsp;pełnego bufora.
* Konsument nie może pobrać elementu z&nbsp;pustego bufora.
* Bufor ma&nbsp;ograniczoną pojemność określoną w&nbsp;konstruktorze.
* Oczekiwanie na&nbsp;spełnienie warunków odbywa się w&nbsp;pętli `while`, aby ponownie sprawdzić warunek po&nbsp;przebudzeniu wątku.

## 3. Fragmenty kodu

### Klasa `Bufor`:

```Java
class Bufor {
    private final Queue<Integer> queue;
    private final int size;

    public Bufor(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(int i) {
        while (queue.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Wątek przerwany podczas oczekiwania w put.");
            }
        }
        queue.add(i);
        System.out.println("P -> " + i);
        notifyAll();
    }

    public synchronized int get() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Wątek przerwany podczas oczekiwania w get.");
            }
        }
        int product = queue.poll();
        notifyAll();
        return product;
    }
}
```

### Klasa `Producent`:

```Java
class Producent extends Thread {
    private final Bufor _buf;

    public Producent(Bufor buf) {
        this._buf = buf;
    }

    public void run() {
        for (int i = 0; i < 100; ++i) {
            _buf.put(i);
        }
    }
}
```

### Klasa `Konsument`:

```Java
class Konsument extends Thread {
    private final Bufor _buf;

    public Konsument(Bufor buf) {
        this._buf = buf;
    }

    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.println("K <- " + _buf.get());
        }
    }
}
```

### Klasa `PKmon`:

```Java
public class PKmon {
    public static void main(String[] args) {
        Bufor buf = new Bufor(10);
        Producent p = new Producent(buf);
        Konsument k = new Konsument(buf);

        p.start();
        k.start();

        try {
            p.join();
            k.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Wątek główny przerwany.");
        }
    }
}
```

## 4. Wyniki

Producent dodaje elementy do bufora (oznaczenie `P -> X`), a&nbsp;konsument pobiera je&nbsp;(oznaczenie `K <- X`). W&nbsp;przypadku pełnego bufora producent czeka, a&nbsp;w&nbsp;przypadku pustego bufora konsument oczekuje na&nbsp;nowy element. Kolejność działań jest zgodna z&nbsp;założeniami programu.

Fragment wyników:
```
...
P -> 80
K <- 71
P -> 81
K <- 72
P -> 82
K <- 73
K <- 74
K <- 75
K <- 76
P -> 83
P -> 84
P -> 85
P -> 86
K <- 77
P -> 87
K <- 78
P -> 88
K <- 79
P -> 89
K <- 80
...
```

Pełne wyniki działania programu znajdują się w&nbsp;pliku:

[results.txt](https://github.com/akotu235/PKmon/blob/master/results/results.txt)

Adres pliku: <https://github.com/akotu235/PKmon/blob/master/results/results.txt>


## 5. Wnioski

Implementacja problemu producentów i&nbsp;konsumentów przy użyciu monitorów w&nbsp;Javie pozwala na&nbsp;efektywną synchronizację między wątkami. Metody `wait()` i&nbsp;`notifyAll()` w&nbsp;połączeniu z&nbsp;pętlami warunkowymi są&nbsp;skutecznym narzędziem w&nbsp;obsłudze współbieżności.
Ograniczenie bufora umożliwiło przetestowanie mechanizmów oczekiwania i&nbsp;powiadamiania w&nbsp;praktyce.

## 6. Bibliografia

1. **Java Platform, Standard Edition Documentation** - Oracle. Dostępne online: <https://docs.oracle.com/javase/8/docs/>


## 7. Załączniki

1. **Repozytorium kodu źródłowego** – Pełny kod projektu. Dostępne online: <https://github.com/akotu235/PKmon>

2. **Wersja online sprawozdania** – Bieżąca wersja dokumentu. Dostępne online: <https://github.com/akotu235/PKmon/blob/master/report/report.md>

3. **Plik wyników programu** – Pełne dane wyjściowe wygenerowane przez program. Dostępne online: <https://github.com/akotu235/PKmon/blob/master/results/results.txt>