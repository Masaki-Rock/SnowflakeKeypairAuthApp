import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FileUtil {

	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);
	  
	public static Boolean copyPrivateKeyFile(String fileName, String tmpDir, String content) {

		String filepath = tmpDir + "/" + fileName;
		File file = new File(filepath);
		logger.trace(content);
		logger.info(filepath);

		if (file.exists()) {
			logger.info(">>> Exist Key File.");
			return false;
		}

		logger.info(">>> Create Key File.");
		try {
			FileWriter filewriter = new FileWriter(file);
			filewriter.write(content);
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}
}
