/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opfa;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import nl.geodienstencentrum.maven.plugin.sass.Resource;
import org.apache.maven.model.FileSet;
import org.apache.maven.plugin.logging.Log;
import org.codehaus.plexus.util.DirectoryScanner;
import org.junit.Test;

/**
 *
 * @author sbaruzza
 */
public class DirectoryScannerTest {

    @Test
    public void asd() {
        DirectoryScanner scanner = new DirectoryScanner();
        scanner.setBasedir("/home/sbaruzza/NetBeansProjects/help4u/help4u-web/src/main/sass");
        scanner.setIncludes(new String[]{"*.scss", "*.sass"});
        scanner.setExcludes(new String[]{});
        scanner.addDefaultExcludes();
        scanner.scan();
        System.out.println(Arrays.asList(scanner.getIncludedDirectories()));
        System.out.println(Arrays.asList(scanner.getIncludedFiles()));
        System.out.println("asd");
    }

    @Test
    public void bsd() {
        final FileSet fileSet = new FileSet();
        fileSet.setDirectory("/home/sbaruzza/NetBeansProjects/help4u/help4u-web/src/main/sass");
        fileSet.setIncludes(Arrays.asList("*.scss", "*.sass"));
        fileSet.setExcludes(Arrays.<String>asList());
        final File destination = new File("/tmp/output");
        Resource resource = new TestResource(fileSet, "", destination);
        Map<String, String> directoriesAndDestinations = resource.getDirectoriesAndDestinations(new NotTodayLogger());
        System.out.println(directoriesAndDestinations);
    }

    private static class TestResource extends Resource {

        public TestResource(FileSet source, String relativeOutputDirectory, File destination) {
            this.source = source;
            this.relativeOutputDirectory = relativeOutputDirectory;
            this.destination = destination;
        }
    }

    private static class NotTodayLogger implements Log {

        public NotTodayLogger() {
        }

        @Override
        public boolean isDebugEnabled() {
            return false;
        }

        @Override
        public void debug(CharSequence content) {
        }

        @Override
        public void debug(CharSequence content, Throwable error) {
        }

        @Override
        public void debug(Throwable error) {
        }

        @Override
        public boolean isInfoEnabled() {
            return false;
        }

        @Override
        public void info(CharSequence content) {
        }

        @Override
        public void info(CharSequence content, Throwable error) {
            
        }

        @Override
        public void info(Throwable error) {
            
        }

        @Override
        public boolean isWarnEnabled() {
            return false;
        }

        @Override
        public void warn(CharSequence content) {
        }

        @Override
        public void warn(CharSequence content, Throwable error) {
            
        }

        @Override
        public void warn(Throwable error) {
            
        }

        @Override
        public boolean isErrorEnabled() {
            return false;
        }

        @Override
        public void error(CharSequence content) {
        }

        @Override
        public void error(CharSequence content, Throwable error) {
        }

        @Override
        public void error(Throwable error) {
        }
    }
}
