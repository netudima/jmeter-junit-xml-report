package com.github.netudima.jmeter.junit.report.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "jmeter-to-junit")
public class ConvertJMeterReportToJUnitMojo extends AbstractMojo {
    public void execute() throws MojoExecutionException
    {
        getLog().info( "Hello, world." );
    }
}