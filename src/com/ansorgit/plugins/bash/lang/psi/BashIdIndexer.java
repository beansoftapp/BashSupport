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

package com.ansorgit.plugins.bash.lang.psi;

import com.ansorgit.plugins.bash.lang.lexer.BashLexer;
import com.ansorgit.plugins.bash.lang.psi.stubs.index.BashIndexVersion;
import com.intellij.lexer.Lexer;
import com.intellij.psi.impl.cache.impl.OccurrenceConsumer;
import com.intellij.psi.impl.cache.impl.id.LexerBasedIdIndexer;

public class BashIdIndexer extends LexerBasedIdIndexer {
    public static BashFilterLexer createIndexingLexer(OccurrenceConsumer occurendeConsumer) {
        return new BashFilterLexer(new BashLexer(), occurendeConsumer);
    }

    @Override
    public Lexer createLexer(OccurrenceConsumer consumer) {
        return createIndexingLexer(consumer);
    }

    @Override
    public int getVersion() {
        return BashIndexVersion.ID_INDEX_VERSION;
    }
}
