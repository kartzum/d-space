package m.d.d.e.p;

import java.io.*;

class Sources {
    static class DataSource {
        final byte[] data;

        DataSource(final byte[] data) {
            this.data = data;
        }
    }

    static abstract class Writer {
        abstract void write(DataSource dataSource);
    }

    static abstract class Reader {
        abstract DataSource read();
    }

    static class FileWriter extends Writer {
        private final String resource;

        FileWriter(String resource) {
            this.resource = resource;
        }

        @Override
        void write(final DataSource dataSource) {
            try {
                try (final OutputStream outputStream = new FileOutputStream(resource)) {
                    outputStream.write(dataSource.data);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class FileReader extends Reader {
        private final String resource;

        FileReader(final String resource) {
            this.resource = resource;
        }

        @Override
        DataSource read() {
            byte[] data;
            try {
                try (final ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
                    try {
                        try (final InputStream inputStream = new FileInputStream(resource)) {
                            final byte[] bytes = new byte[4096];
                            int r;
                            while ((r = inputStream.read(bytes)) != -1) {
                                buffer.write(bytes, 0, r);
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    data = buffer.toByteArray();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return new DataSource(data);
        }
    }
}