package com.plicku.stepin.processor;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StepinProcessorTest {

    public static List<MethodCallRegistryEntry> methodRegistryExp = new ArrayList<>();
    public static List<MethodCallRegistryEntry> methodRegistryAct = new ArrayList<>();
    @Test
    public void testSimpleProcessingFromFile() throws Exception {

        methodRegistryExp.add(new MethodCallRegistryEntry("Simple Given Test",true));
        methodRegistryExp.add(new MethodCallRegistryEntry("Simple When Test",true));
        methodRegistryExp.add(new MethodCallRegistryEntry("Test with simple bean matchedMethod param",true));
        methodRegistryExp.add(new MethodCallRegistryEntry("Test with simple bean json matchedMethod param",true));
        methodRegistryExp.add(new MethodCallRegistryEntry("Simple When Test",true));
        methodRegistryExp.add(new MethodCallRegistryEntry("Test with list of beans json matchedMethod param",true));

        StepinProcessor stepinProcessor = new StepinProcessor("com.plicku.stepin.processor.stepdefs");
        stepinProcessor.process(new File("D:\\development\\plicku\\plicku-stepforward\\src\\test\\resources\\test1.sequence"));

        Assert.assertEquals("Method Call expectation failed",methodRegistryExp,methodRegistryAct);
    }

    @Test
    public void testRegexExpressions() throws Exception {

        StepinProcessor stepinProcessor = new StepinProcessor("com.plicku.stepin.processor.stepdefs");
        stepinProcessor.process(new File("D:\\Development\\plicku\\plicku-stepforward\\src\\test\\resources\\test2regex.sequence"));
    }



}