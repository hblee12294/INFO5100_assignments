import java.io.File;
import java.io.RandomAccessFile; 

public class ParseFile {

	public static void parse(File file) {
		RandomAccessFile input = null;
		String line = null;
		try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
			return;
		}
        catch (Exception e) {
        	e.printStackTrace();
        } 
        finally {
        	if (input != null) {
        		try {
        			input.close();
        		}
        		catch (Exception e) {
        			e.printStackTrace();
        		}
        	}
        }
    }  
	
	public static void main(String[] args) {
		File p1 = new File("/test");
		ParseFile.parse(p1);
	}
}