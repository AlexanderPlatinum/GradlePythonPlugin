package ru.ptcore;

import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GradlePythonPlugin implements Plugin<Project> {

    private final String PYTHON_EXEC = "python";

    private final String SRC_FOLDER = "src/main/";
    private final String TEST_FOLDER = "src/test/";

    @Override
    public void apply(Project project) {

        NamedDomainObjectContainer<GradlePythonPluginTestExtension>
                testExtension = project.container(GradlePythonPluginTestExtension.class);

        GradlePythonPluginExtension extension =
                project.getExtensions().create("PythonPlugin", GradlePythonPluginExtension.class, testExtension);


        project.task("build").doLast(task -> {

            project.exec(execSpec -> {
                execSpec.setExecutable(PYTHON_EXEC + extension.getPythonVersion());
                execSpec.setArgs(Collections.singletonList(SRC_FOLDER + extension.getExecuteModule()));
                execSpec.setIgnoreExitValue(true);
            });
        });

        project.task("test").doLast(task -> {

            NamedDomainObjectContainer<GradlePythonPluginTestExtension> tests = extension.getTests();

            tests.forEach(test -> {

                String path = TEST_FOLDER;

                if (test.getExternalName().length() > 0) {
                    path += test.getExternalName();
                } else {
                    path += test.getName() + ".py";
                }

                String finalPath = path;
                project.exec(execSpec -> {

                    System.out.println(finalPath);

                    execSpec.setExecutable(PYTHON_EXEC + extension.getPythonVersion());

                    List<String> args = new ArrayList<>();

                    args.add("-m");
                    args.add("unittest");
                    args.add(finalPath);

                    execSpec.setArgs(args);

                    execSpec.setIgnoreExitValue(true);
                });
            });

        });
    }

}