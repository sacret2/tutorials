package com.bharath.ws.soap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWsImpl implements FileWs {

	InputStream inputStream = null;
	OutputStream outputStream = null;

	@Override
	public void upload(DataHandler attachment) {
		try {
			InputStream inputStream = attachment.getInputStream();
			OutputStream outputStream = new FileOutputStream(new File("C:\\Marcin\\App\\tutorials\\Files\\test.jpg"));
			int bytesReadNb; 
			
			byte[] buf = new byte[100000];
			
			while( -1 != (bytesReadNb = inputStream.read(buf)) ) {
				outputStream.write(buf, 0, bytesReadNb);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			int cos;
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
		return new DataHandler(new FileDataSource(new File("C:\\Marcin\\App\\tutorials\\Files\\test.jpg")));
	}

}
