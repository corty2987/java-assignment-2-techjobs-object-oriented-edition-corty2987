package org.launchcode.techjobs.oo.test;

import org.launchcode.techjobs.oo.Job;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;


import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job test = new Job();
        Job test2 = new Job();
        assertNotEquals(test.getId(), test2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertTrue(test.getName() != null);
        Assert.assertTrue(test.getEmployer() instanceof Employer);
        Assert.assertTrue(test.getLocation() instanceof Location);
        Assert.assertTrue(test.getPositionType() instanceof PositionType);
        Assert.assertTrue(test.getCoreCompetency() instanceof CoreCompetency);

        Assert.assertEquals("Product tester", test.getName());
        Assert.assertEquals(test.getEmployer().getValue(), new Employer("ACME").getValue());
        Assert.assertEquals(test.getLocation().getValue(), new Location("Desert").getValue());
        Assert.assertEquals(test.getPositionType().getValue(), new PositionType("Quality control").getValue());
        Assert.assertEquals(test.getCoreCompetency().getValue(), new CoreCompetency("Persistence").getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test1.getId();
        test2.getId();
        assertFalse(test1.equals(test2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstChar = test.toString().charAt(0);
        char lastChar = test.toString().charAt(test.toString().length()-1);
        Assert.assertEquals(firstChar, '\n');
        Assert.assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testData =
                "\nID: " + test.getId() + "\n" +
                "Name: " + test.getName() + "\n" +
                "Employer: " + test.getEmployer() + "\n" +
                "Location: " + test.getLocation() + "\n" +
                "Position Type: " + test.getPositionType()+ "\n" +
                "Core Competency: " + test.getCoreCompetency() + "\n";
        Assert.assertEquals(testData, test.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job test = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));

        Assert.assertEquals("\nID: " + test.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Data not available" + "\n" +
                "Core Competency: Persistence" + "\n", test.toString());

    }
}


