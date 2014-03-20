package jdk8.lambda;

import java.io.File;
import java.io.FileFilter;

/**
 *
 *
 * @author Kane.Sun
 * @version Mar 20, 2014 1:32:35 PM
 * 
 */

public class Demo1 {

	public static void main(String... args) {
	}

	// normal way
	public void demonstrate1() {
		File dir = new File("/an/dir/");

		class XFileFilter implements FileFilter {
			@Override
			public boolean accept(File file) {
				return file.isDirectory();
			}
		}

		dir.listFiles(new XFileFilter());
	}

	// anonymous inner class
	public void demonstrate2() {
		File dir = new File("/an/dir/");
		FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		dir.listFiles(directoryFilter);
	}

	// lambda expression 1
	public void demonstrate3() {
		File dir = new File("/an/dir/");
		FileFilter directoryFilter = (File f) -> f.isDirectory();
		File[] dirs = dir.listFiles(directoryFilter);
	}

	// lambda expression 2
	public void demonstrate4() {
		File dir = new File("/an/dir/");
		File[] dirs = dir.listFiles((File f) -> f.isDirectory());
	}
}
