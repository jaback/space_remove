package br.com.jback;

import java.io.File;

public class Main {

	private final static String FILE_SEPARATOR = System.getProperty("file.separator");
	private final static String WHITE_SPACE = " ";
	private final static String UNDERSCORE = "_";
	private final static String HELP_MESSAGE = "Informar um, e apenas um, caminho alvo.";

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println(HELP_MESSAGE);
		} else {
			rename(args[0]);
		}
	}

	private static void rename(String path) {
		File file = new File(path);
		if (file.getName().contains(WHITE_SPACE)) {
			String new_path = file.getAbsolutePath().replaceAll(WHITE_SPACE, UNDERSCORE);
			//noinspection ResultOfMethodCallIgnored
			new File(file.getAbsolutePath()).renameTo(new File(new_path));
			rename(new_path);
			return;
		}
		String[] children = file.list();
		if (children != null) {
			for (String child : children) {
				rename(path + FILE_SEPARATOR + child);
			}
		}
	}
}
