package ru.ptcore;

public class GradlePythonPluginTestExtension {

    final private String name;
    private String description = "";
    private String externalName = "";
    private boolean execute = true;

    public GradlePythonPluginTestExtension(String name) {
        this.name = name;
    }

    public boolean isExecute() {
        return execute;
    }

    public void setExecute(boolean execute) {
        this.execute = execute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternalName() {
        return externalName;
    }

    public void setExternalName(String externalName) {
        this.externalName = externalName;
    }

    public String getName() {
        return name;
    }
}
