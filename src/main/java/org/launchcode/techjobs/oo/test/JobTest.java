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
        Assert.assertTrue(test.getEmployer() != null);
        Assert.assertTrue(test.getLocation() != null);
        Assert.assertTrue(test.getCoreCompetency() != null);


        Assert.assertEquals("Product tester", test.getName());
        Assert.assertEquals(new Employer("ACME"), test.getEmployer());
        Assert.assertEquals(new Location("Desert"), test.getLocation());
        Assert.assertEquals(new PositionType("Quality Control"), test.getPositionType());
        Assert.assertEquals(new CoreCompetency(), test.getCoreCompetency());



    }



}


