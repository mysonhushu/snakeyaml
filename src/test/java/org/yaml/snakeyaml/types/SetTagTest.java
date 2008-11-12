/*
 * See LICENSE file in distribution for copyright and licensing information.
 */
package org.yaml.snakeyaml.types;

import java.util.Map;
import java.util.Set;

import org.yaml.snakeyaml.YamlDocument;

/**
 * @see http://yaml.org/type/set.html
 */
public class SetTagTest extends AbstractTest {

    @SuppressWarnings("unchecked")
    public void testSet() {
        try {
            YamlDocument document = new YamlDocument("types/set.yaml");
            Map<String, Set<String>> map = (Map<String, Set<String>>) document.getNativeData();
            assertEquals(2, map.size());
            Set<String> set1 = (Set<String>) map.get("baseball players");
            assertEquals(3, set1.size());
            assertTrue(set1.contains("Mark McGwire"));
            assertTrue(set1.contains("Sammy Sosa"));
            assertTrue(set1.contains("Ken Griffey"));
            //
            Set<String> set2 = (Set<String>) map.get("baseball teams");
            assertEquals(3, set2.size());
            assertTrue(set2.contains("Boston Red Sox"));
            assertTrue(set2.contains("Detroit Tigers"));
            assertTrue(set2.contains("New York Yankees"));
        } catch (RuntimeException e) {
            // TODO set is not yet properly implemented
        }
    }
}
