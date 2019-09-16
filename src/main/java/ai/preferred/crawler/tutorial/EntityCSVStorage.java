package ai.preferred.crawler.tutorial;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityCSVStorage<T> implements AutoCloseable {

  private static final Logger LOGGER = LoggerFactory.getLogger(EntityCSVStorage.class);

  private final CSVPrinter printer;

  private boolean hasHeader;

  public EntityCSVStorage(String file) throws IOException {
    printer = new CSVPrinter(new FileWriter(file), CSVFormat.EXCEL);
    hasHeader = false;
  }

  private static List<String> getHeaderList(Class clazz) {
    final List<String> result = new ArrayList<>();
    for (final Field field : clazz.getDeclaredFields()) {
      result.add(field.getName());
    }
    return result;
  }

  private List<Object> toList(Object object) throws IllegalAccessException {
    final Field[] fields = object.getClass().getDeclaredFields();
    final List<Object> result = new ArrayList<>();
    for (final Field field : fields) {
      field.setAccessible(true);
      result.add(field.get(object));
    }
    return result;
  }

  public synchronized void append(T object) throws IOException {
    if (!hasHeader) {
      printer.printRecord(getHeaderList(object.getClass()));
      printer.flush();
      hasHeader = true;
    }

    try {
      printer.printRecord(toList(object));
      printer.flush();
    } catch (IllegalAccessException e) {
      throw new IOException("unable to store property: ", e);
    }
  }

  @Override
  public void close() throws IOException {
    printer.close(true);
  }

}
