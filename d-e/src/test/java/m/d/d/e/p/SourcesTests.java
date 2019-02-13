package m.d.d.e.p;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;


class SourcesTests {

    @Test
    void fileWriterReaderTest() throws IOException {
        final String resource = Files.createTempFile("sample-file", ".txt").toString();

        final ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.putInt(1);
        buffer.putDouble(42.0);
        final Sources.DataSource dataSource = new Sources.DataSource(buffer.array());
        final Sources.FileWriter fileWriter = new Sources.FileWriter(resource);
        fileWriter.write(dataSource);
        final Sources.FileReader fileReader = new Sources.FileReader(resource);
        final Sources.DataSource dataSourceSaved = fileReader.read();
        assertNotNull(dataSourceSaved);
        final ByteBuffer bufferSaved = ByteBuffer.wrap(dataSourceSaved.data);
        assertEquals(1, bufferSaved.getInt());
        assertEquals(42.0, bufferSaved.getDouble());
    }
}