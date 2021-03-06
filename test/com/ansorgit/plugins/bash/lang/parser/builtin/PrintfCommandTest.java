/*
 * Copyright (c) Joachim Ansorg, mail@ansorg-it.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.parser.builtin;

import com.ansorgit.plugins.bash.lang.parser.BashPsiBuilder;
import com.ansorgit.plugins.bash.lang.parser.MockPsiTest;
import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * @author jansorg
 */
public class PrintfCommandTest extends MockPsiTest {
    private final MockFunction parsingFunction = new MockFunction() {
        @Override
        public boolean apply(BashPsiBuilder psi) {
            PrintfCommand d = new PrintfCommand();
            return d.parse(psi);
        }
    };

    @Test
    public void testNoVar() throws Exception {
        mockTest(parsingFunction, Lists.newArrayList("printf"), WORD);
    }

    @Test
    public void testVarDef() throws Exception {
        mockTest(parsingFunction, Lists.newArrayList("printf", "-v", "x"), WORD, WORD, WORD);
    }
}