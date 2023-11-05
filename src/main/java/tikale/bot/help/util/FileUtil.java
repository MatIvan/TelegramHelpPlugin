package tikale.bot.help.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import tikale.bot.help.exception.DataFileNotFoundException;
import tikale.bot.help.exception.DataFileUnableToLoadException;
import tikale.bot.help.exception.DataFileUnableToSaveException;

@Service
public class FileUtil {

    @Value("${data.file.name}")
    private String fileName;

    @Value("${data.file.path}")
    private String filePath;

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
            Path path = Paths.get(filePath).resolve(fileName);
            Resource resource = new UrlResource(path.toUri());
            File file = resource.getFile();
            return file;
        } catch (MalformedURLException e) {
            throw new DataFileNotFoundException(e.getMessage());
        } catch (IOException e) {
            throw new DataFileNotFoundException(e.getMessage());
        }
    }
}
