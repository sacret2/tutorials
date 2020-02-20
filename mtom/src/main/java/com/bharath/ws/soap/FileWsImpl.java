package com.bharath.ws.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.cxf.feature.Features;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class FileWsImpl implements FileWs {

	InputStream inputStream = null;
	OutputStream outputStream = null;

	@Override
	public void upload(DataHandler attachment) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = attachment.getInputStream();
			
			outputStream = new FileOutputStream(new File(
					new File("").getAbsolutePath() + "\\Files\\test.jpg"));
			int bytesReadNb; 
			
			byte[] buf = new byte[100000];
			
			while( -1 != (bytesReadNb = inputStream.read(buf)) ) {
				outputStream.write(buf, 0, bytesReadNb);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public DataHandler download() {
		return new DataHandler(new FileDataSource(new File(
				new File("").getAbsolutePath() + "\\Files\\test.jpg")));
	}

}
