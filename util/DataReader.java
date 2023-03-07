package toysShop.util;

import java.util.List;

abstract class DataReader<T> {
    abstract List<T> readFromFile(String file);
}
