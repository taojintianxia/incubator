package com.github.taojintianxia.incubator.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

public class JavaTest {

    public static void main(String[] args) throws FileNotFoundException, IOException, XmlPullParserException {

        MavenXpp3Reader reader = new MavenXpp3Reader();
        String myPom = "pom.xml";
        Model model = reader.read(new FileReader(myPom));

        System.out.println("artifactId is : " + model.getArtifactId());
        System.out.println("groupId is : " + model.getGroupId());
        System.out.println("version is : " + model.getVersion());


    }
}
