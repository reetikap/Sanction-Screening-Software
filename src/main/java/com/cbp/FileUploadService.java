package com.cbp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static final Logger logger = Logger.getLogger(FileUploadService.class.getName());
	
	@Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job csvFileToDatabaseJob;
    
	public ResponseEntity<String> uploadData(MultipartFile file) throws Exception {

		if (file == null) {
			throw new RuntimeException("You must select a file for uploading");
		}

		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();

		logger.info("inputStream: " + inputStream);
		logger.info("originalName: " + originalName);
		logger.info("name: " + name);
		logger.info("contentType: " + contentType);
		logger.info("size: " + size);

		// Do processing with uploaded file data in Service layer
		/*String path = new ClassPathResource("C:\\Users\\Lenovo\\Desktop\\tmpuploads").getURL().getPath();//it's assumed you have a folder called tmpuploads in the resources folder
        File fileToImport = new File(path + originalName);
        OutputStream outputStream = new FileOutputStream(fileToImport);
        IOUtils.copy(inputStream, outputStream);
        outputStream.flush();
        outputStream.close();*/
		try 
		{
			byte[] bytes = file.getBytes();
			File dir=new File("C:\\\\Users\\\\Lenovo\\\\Desktop\\\\tmpuploads");

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + name);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			logger.info("Server File Location="
					+ serverFile.getAbsolutePath());
		}
		catch (Exception e)
		{
			return new ResponseEntity<String>("unsuccessfully", HttpStatus.OK);
		}
		JobExecution jobExecution = jobLauncher.run(csvFileToDatabaseJob,new JobParameters());
        /*JobExecution jobExecution = jobLauncher.run(csvFileToDatabaseJob, new JobParametersBuilder()
                .addString("fullPathFileName", fileToImport.getAbsolutePath())
                .toJobParameters());   */ 
		return new ResponseEntity<String>("successfully", HttpStatus.OK);
	}
}


