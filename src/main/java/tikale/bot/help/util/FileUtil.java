package tikale.bot.help.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import tikale.bot.help.exception.DataFileNotFoundException;
import tikale.bot.help.exception.DataFileUnableToLoadException;
import tikale.bot.help.exception.DataFileUnableToSaveException;

@Service
public class FileUtil {

    @Value("${data.file.name}")
    private String fileName;

    public FileUtil() {
        super();
    }

    public String load() {
        File file = getDataFile();

        try {
            InputStream inputStream = new FileInputStream(file);

            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String content = new String(bdata, StandardCharsets.UTF_8);
            return content;
        } catch (IOException e) {
            throw new DataFileUnableToLoadException(e.getMessage());
        }

    }

    public void save(String savedData) {
        File file = getDataFile();

        try {
            InputStream inputStream = new ByteArrayInputStream(savedData.getBytes());

            OutputStream outputStream = new FileOutputStream(file);
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new DataFileUnableToSaveException(e.getMessage());
        }
    }

    private File getDataFile() {
        try {
            ClassPathResource classPathResource = new ClassPathResource(fileName);
            File file = classPathResource.getFile();
            return file;
        } catch (IOException e) {
            throw new DataFileNotFoundException(e.getMessage());
        }
    }
}
