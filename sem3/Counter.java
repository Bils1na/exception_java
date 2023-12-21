package sem3;

import java.io.Closeable;
import java.io.IOException;

public class Counter implements Closeable {
//    private boolean isClosed;
    private Integer count = 0;

//        Создайте класс Счетчик, у которого есть метод add(),
//        увеличивающий значение внутренней int переменной на 1.
//        Сделайте так, чтобы с объектом такого типа можно было работать
//        в блоке try-with-resources. Подумайте, что должно происходить при закрытии этого ресурса?
//        Напишите метод для проверки, закрыт ли ресурс. При попытке вызвать add() у закрытого ресурса,
//        должен выброситься IOException


    public int add() throws IOException {
//        if (isClosed) {
        if (count == null) {
            throw new IOException("Recourse is closed");
        }
        return ++this.count;
    }

    @Override
    public void close() throws IOException {
//        isClosed = true;
        count = null;
    }

}
