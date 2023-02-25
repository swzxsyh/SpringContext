package com.test.application.designPatten.structuralPattern.decoratorPattern.decorators;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

@Slf4j
public class CompressionDecorator extends DataSourceDecorator {

    private int comLevel = 6;

    public CompressionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    public int getCompressionLevel() {
        return comLevel;
    }

    public void setCompressionLevel(int value) {
        this.comLevel = value;
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String compress(String stringData) {
        byte[] data = stringData.getBytes();
        try {
            //这不能try-with-resource，否则会加密错误数据
            //https://stackoverflow.com/questions/24531089/exception-unexpected-end-of-zlib-input-stream
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(comLevel));
            dos.write(data);
            dos.close();
            bout.close();
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException ex) {
            log.error("compress err:", ex);
        }
        return null;
    }

    private String decompress(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        try {
            InputStream in = new ByteArrayInputStream(result);
            InflaterInputStream iin = new InflaterInputStream(in);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            int b;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            in.close();
            iin.close();
            bout.close();
            return bout.toString();
        } catch (IOException ex) {
            log.error("decompress err:", ex);
        }
        return null;
    }
}
