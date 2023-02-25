package com.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;


@Slf4j
public class IOFileCopyTest {

    /**
     * 字节流
     */
    @Test
    public void fileIOStreamTest() {
        try (FileInputStream fis = new FileInputStream("./src/test/java/com/test/source.text");
             FileOutputStream fos = new FileOutputStream("./src/test/java/com/test/target.text")) {

            int content;
            StringBuilder sb = new StringBuilder();
            while ((content = fis.read()) != -1) {
                char source = (char) content;
                sb.append(source);
            }
            log.info("fileIOStreamTest source: {}", sb);

            fos.write(sb.toString().getBytes(StandardCharsets.UTF_8));

        } catch (FileNotFoundException e) {
            log.error("fileIOStreamTest FileNotFoundException:", e);
        } catch (IOException e) {
            log.error("fileIOStreamTest IOException:", e);
        }

    }

    /**
     * 字符流
     */
    @Test
    public void fileReaderTest() {
        try (FileReader fr = new FileReader("./src/test/java/com/test/source.text");
             FileWriter fw = new FileWriter("./src/test/java/com/test/target.text")) {
            int content;
            StringBuilder sb = new StringBuilder();
            while ((content = fr.read()) != -1) {
                sb.append((char) content);
            }
            log.info("fileReaderTest :{}", sb);
            fw.write(sb.toString());

        } catch (FileNotFoundException e) {
            log.error("fileReaderTest FileNotFoundException: ", e);
        } catch (IOException e) {
            log.error("fileReaderTest IOException: ", e);
        }
    }

    /**
     * 缓冲流
     */
    @Test
    public void fileBufferTest() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./src/test/java/com/test/source.text"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./src/test/java/com/test/target.text"))) {
            int length;
            byte[] bytes = new byte[4 * 1024];

            StringBuilder sb = new StringBuilder();
            while ((length = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, length);
                bos.flush();
            }
        } catch (FileNotFoundException e) {
            log.error("fileBufferTest FileNotFoundException: ", e);
        } catch (IOException e) {
            log.error("fileBufferTest IOException: ", e);
        }
    }

    /**
     * NIO 流
     */
    @Test
    public void fileTransferTest() {
        try (FileInputStream fis = new FileInputStream("./src/test/java/com/test/source.text");
             FileOutputStream fos = new FileOutputStream("./src/test/java/com/test/target.text")) {
            final FileChannel fisChannel = fis.getChannel();
            final FileChannel fosChannel = fos.getChannel();

            fosChannel.transferFrom(fisChannel, 0, fisChannel.size());
        } catch (FileNotFoundException e) {
            log.error("fileTransferTest FileNotFoundException: ", e);
        } catch (IOException e) {
            log.info("fileTransferTest IOException: ", e);
        }
    }
}
