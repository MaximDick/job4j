package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ProfileTest {

    /**
     * Test convert profile list to address list.
     */
    @Test
    public void whenListProfilesThenListAddress() {
        List<Address> expected = new ArrayList<>();
        List<Profile> profiles = Arrays.asList(
                new Profile(new Address("Moscow", "Sadovaya", 16, 28)),
                new Profile(new Address("Nizhniy Novgorod", "Minina", 24, 21)),
                new Profile(new Address("Moscow", "Baumana", 16, 28)));

        Profile profile = new Profile(new Address("Moscow", "Baumana", 16, 28));
        List<Address> result = profile.collect(profiles);

    for (Profile pr : profiles) {
        expected.add(pr.getAddress());
    }
    assertThat(result, is(expected));
}

    /**
     * Test convert profile list to address list.
     */
    @Test
    public void whenListProfilesThenUniqueSortedListAddress() {
        Address[] arr = {
                new Address("Rostov", "Krasnay", 40, 17),
                new Address("Tver", "Lasurnay", 56, 60),
                new Address("Anapa", "Svetlay", 40, 17),
                new Address("Anapa", "Svetlay", 40, 17)
        };
        List<Profile> profiles = Arrays.asList(new Profile(new Address("Rostov", "Krasnay", 40, 17)),
                new Profile(new Address("Tver", "Lasurnay", 56, 60)),
                new Profile(new Address("Anapa", "Svetlay", 40, 17)),
                new Profile(new Address("Anapa", "Svetlay", 40, 17)));
        Profile profile = new Profile(new Address("Rostov", "Kasnay", 40, 17));
        List<Address> result = profile.unique(profiles);
        List<Address> expected = new ArrayList<>(new HashSet<>(Arrays.asList(arr)));
        expected.sort((o1, o2) -> o1.getCity().compareTo(o2.getCity()));
        assertThat(result, is(expected));
    }
}

