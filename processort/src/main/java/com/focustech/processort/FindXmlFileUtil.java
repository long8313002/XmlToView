package com.focustech.processort;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.Filer;
import javax.tools.JavaFileObject;

/**
 * Created by zhangzheng on 2017/4/12.
 */

public class FindXmlFileUtil {

    private static File projectRoot;

    public static File findXmlFile(String packageName, int resId, Filer filer) {
        try {
            List<File> layoutFolders = findLayoutFolders(filer);
            for (File file : layoutFolders) {
                File r = findR(packageName,filer);
                String rOutput = readFile(r);
                String layoutName = getFieldNameFromLayoutId(rOutput, resId);
                File layout = findLayout(file, layoutName);
                System.out.println("layout====>" + layout.getAbsolutePath());
                return layout;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static List<File> findLayoutFolders(Filer filer) throws Exception {
        List<File> layoutFolders = new ArrayList<>();
        File resourceFolder = findFolder("/src/main/res/",filer);
        File[] files = resourceFolder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().startsWith("layout")) {
                    layoutFolders.add(file);
                }
            }
        }
        return layoutFolders;
    }

    private static File findFolder(String path, Filer filer) throws Exception {
        File projectRoot = getProjectRoot(filer);

        File sourceFile = new File(projectRoot.getAbsolutePath() + path);

        while (true) {
            if (sourceFile.exists()) {
                return sourceFile;
            } else {
                if (projectRoot.getParentFile() != null) {
                    projectRoot = projectRoot.getParentFile();
                    sourceFile = new File(projectRoot.getAbsolutePath() + path);
                } else {
                    break;
                }
            }
        }
        return new File(projectRoot.getAbsolutePath() + path);
    }

    private static File getProjectRoot(Filer filer) throws Exception {
        if (projectRoot == null) {
            JavaFileObject dummySourceFile = filer.createSourceFile("dummy" + System.currentTimeMillis());

            String dummySourceFilePath = dummySourceFile.toUri().toString();

            if (dummySourceFilePath.startsWith("file:")) {
                if (!dummySourceFilePath.startsWith("file://")) {
                    dummySourceFilePath = "file://" + dummySourceFilePath.substring("file:".length());
                }
            } else {
                dummySourceFilePath = "file://" + dummySourceFilePath;
            }

            URI cleanURI = new URI(dummySourceFilePath);

            File dummyFile = new File(cleanURI);

            projectRoot = dummyFile.getParentFile();
        }

        return projectRoot;
    }

    private static File findR(String packageName,Filer filer) throws Exception {
        File rFile = findFolder("/r/debug/" + packageName.replace(".", "/") + "/R.java",filer);
        if (rFile.isFile()) {
            return rFile;
        } else {
            return findFolder("/r/dev/debug/" + packageName.replace(".", "/") + "/R.java",filer);
        }
    }

    private static File findLayout(File layouts, String layoutName) throws Exception {
        return new File(layouts, layoutName + ".xml");
    }

    private static String getFieldNameFromLayoutId(String rOutput, int layoutId) {
        String hex = "0x" + Integer.toHexString(layoutId);
        int index = rOutput.indexOf(hex);
        String subToLayout = rOutput.substring(0, index);
        String[] splitFields = subToLayout.split("=");
        String lastField = splitFields[splitFields.length - 1];
        String[] lastFieldNameSplit = lastField.split(" ");
        return lastFieldNameSplit[lastFieldNameSplit.length - 1];
    }

    @SuppressWarnings("NewApi")
    private static String readFile(File file) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            return com.focustech.processort.IOUtils.toString(inputStream);
        }
    }
}
