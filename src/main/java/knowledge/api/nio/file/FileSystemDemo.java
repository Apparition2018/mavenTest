package knowledge.api.nio.file;

import l.demo.Demo;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

/**
 * FileSystem
 * 两个实现类：WindowsFileSystem，ZipFileSystem
 * String	            getSeparator()          返回分隔符
 * WatchService	        newWatchService()       新建 WatchService
 * FileSystemProvider	provider()              返回 FileSystemProvider
 * boolean	            isOpen()                是否打开
 * boolean	            isReadOnly()            是否只读
 * https://www.matools.com/file/manual/jdk_api_1.8_google/java/nio/file/FileSystem.html
 * <p>
 * FileSystems
 * 文件系统的工厂方法。 该类定义了 getDefault() 来获取默认文件系统和工厂方法来构建其他类型的文件系统。
 * https://www.matools.com/file/manual/jdk_api_1.8_google/java/nio/file/FileSystems.html
 */
public class FileSystemDemo extends Demo {
    
    @Test
    public void testFileSystem() throws IOException {
        // static FileSystem    getDefault()                            返回默认 FileSystem
        FileSystem fileSystem = FileSystems.getDefault();

        // Path                 getPath(String first, String... more)   将路径字符串或多个路径字符串连接起来转换为 Path 
        Path path = fileSystem.getPath(DEMO_PATH, "demo");
        p(path); // src\main\resources\demo\demo
        
        // Set<String>	        supportedFileAttributeViews()           返回此文件系统支持的文件属性视图的名称集
        p(fileSystem.supportedFileAttributeViews()); // [owner, dos, acl, basic, user]

        // Iterable<Path>	    getRootDirectories()                    返回根目录 Iterable
        Iterable<Path> rootDirectories = fileSystem.getRootDirectories();
        for (Path rootDirectory : rootDirectories) {
            p(rootDirectory);
        }

        // Iterable<FileStore>	getFileStores()                         返回文件存储器 Iterable
        Iterable<FileStore> fileStores = fileSystem.getFileStores();
        for (FileStore fileStore : fileStores) {
            p(fileStore.name() + " " + fileStore.type());
        }

        // PathMatcher	        getPathMatcher(String syntaxAndPattern) 返回 PathMatcher，用于匹配路径
        PathMatcher pathMatcher = fileSystem.getPathMatcher("glob:**demo");
        p(pathMatcher.matches(path)); // true

        // UserPrincipalLookupService   getUserPrincipalLookupService() 返回按名称查找用户和组主体的对象 UserPrincipalLookupService
        UserPrincipalLookupService userPrincipalLookupService = fileSystem.getUserPrincipalLookupService();
        UserPrincipal arsenal = userPrincipalLookupService.lookupPrincipalByName("Arsenal");
        Files.setOwner(Paths.get(DEMO_FILE_ABSOLUTE_PATH), arsenal);

        fileSystem.close();
    }

    /**
     * 解压 Zip 文件
     * https://www.cnblogs.com/lyndon-chen/p/3575393.html
     */
    @Test
    public void unzip() throws IOException {
        // static FileSystem	newFileSystem(Path, ClassLoader)         构造一个新的文件系统来访问文件的内容
        FileSystem fileSystem = FileSystems.newFileSystem(Paths.get(DEMO_PATH + "demo.zip"), null);
        Files.walkFileTree(fileSystem.getPath("/"), new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path destPath = Paths.get(DEMO_PATH + "a/", file.toString());
                Files.deleteIfExists(destPath);
                Files.createDirectories(destPath.getParent());
                Files.move(file, destPath);
                return FileVisitResult.CONTINUE;
            }
        });

        fileSystem.close();
    }

}
