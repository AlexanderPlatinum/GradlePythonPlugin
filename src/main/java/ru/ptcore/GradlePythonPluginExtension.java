package ru.ptcore;

import org.gradle.api.NamedDomainObjectContainer;

public class GradlePythonPluginExtension {

    private String pythonVersion = "";
    private String executeModule = "";

    final private NamedDomainObjectContainer<GradlePythonPluginTestExtension> tests;

    public GradlePythonPluginExtension(NamedDomainObjectContainer<GradlePythonPluginTestExtension> tests) {
        this.tests = tests;
    }

    public String getPythonVersion() {
        return pythonVersion;
    }

    public void setPythonVersion(String pythonVersion) {
        this.pythonVersion = pythonVersion;
    }

    public String getExecuteModule() {
        return executeModule;
    }

    public void setExecuteModule(String executeModule) {
        this.executeModule = executeModule;
    }

    public NamedDomainObjectContainer<GradlePythonPluginTestExtension> getTests() {
        return tests;
    }
}
