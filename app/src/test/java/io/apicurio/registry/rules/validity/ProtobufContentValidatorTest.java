/*
 * Copyright 2019 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.registry.rules.validity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.apicurio.registry.AbstractRegistryTestBase;
import io.apicurio.registry.rules.validity.InvalidContentException;
import io.apicurio.registry.rules.validity.ProtobufContentValidator;
import io.apicurio.registry.rules.validity.ValidityLevel;

/**
 * Tests the Protobuf content validator.
 * @author eric.wittmann@gmail.com
 */
public class ProtobufContentValidatorTest extends AbstractRegistryTestBase {
    
    @Test
    public void testValidProtobufSchema() throws Exception {
        String content = resourceToString("protobuf-valid.proto");
        ProtobufContentValidator validator = new ProtobufContentValidator();
        validator.validate(ValidityLevel.SYNTAX_ONLY, content);
    }

    @Test
    public void testInvalidProtobufSchema() throws Exception {
        String content = resourceToString("protobuf-invalid.proto");
        ProtobufContentValidator validator = new ProtobufContentValidator();
        Assertions.assertThrows(InvalidContentException.class, () -> {
            validator.validate(ValidityLevel.SYNTAX_ONLY, content);
        });
    }

}
