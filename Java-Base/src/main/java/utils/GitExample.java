package utils;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.BufferedWriter;
import java.io.File;    
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Git 操作命令
 */

public class GitExample {

    private static final String REPO_URL = "http://116.63.86.13/testent001/test_repo.git";
    private static final String LOCAL_DIR = "/Users/menghuawei/IdeaProjects/my-project/Learn-Java/.tmp/tmp/test_repo";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "qwe123456";

    public static void main(String[] args) throws Exception {
        cloneResponsitory(REPO_URL, LOCAL_DIR, USERNAME, PASSWORD);
        pullResponsitory(USERNAME, PASSWORD);
        pushResponsitory();
    }

    // 克隆仓库
    private static void cloneResponsitory(String repoUrl, String localDir, String username, String password) throws Exception {
        File localRepoDir = new File(localDir);

        // 检查本地目录是否存在且是否为 Git 仓库
        if (localRepoDir.exists() && new File(localDir, ".git").exists()) {
            System.out.println("Repository already cloned at " + localDir);
        } else {
            try {
                // Git.cloneRepository().setURI(repoUrl).setDirectory(newFile(localDir)).call();
                CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider("admin", "qwe123456");
                Git.cloneRepository().setURI(repoUrl).setDirectory(new File(localDir))
                        .setCredentialsProvider(credentialsProvider).call();
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }    


    // 拉取仓库
    private static void pullResponsitory(String username, String password) throws Exception {
        try {
            Git git = Git.open(new File(LOCAL_DIR));
            CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider("admin", "qwe123456");
            git.pull().setCredentialsProvider(credentialsProvider).call();
            System.out.println("pull 仓库");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 推送仓库
    private static void pushResponsitory() throws Exception {
        try {
            Git git = Git.open(new File(LOCAL_DIR));

            File myFile = new File(LOCAL_DIR, "newfile.txt");
            if (!myFile.exists()) {
                myFile.createNewFile();
            }

            // 写入当前时间
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true))) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                writer.write("Current time: " + now.format(formatter) + "\n");
                System.out.println("Current time written to file.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            git.add().addFilepattern("newfile.txt").call();

            git.commit().setMessage("add file").call();

            CredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider("admin", "qwe123456");
            git.push().setCredentialsProvider(credentialsProvider).call();
            System.out.println("push 仓库");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
